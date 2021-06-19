package com.beppe.controller;

import com.beppe.excel.StudentExcel;
import com.beppe.util.CSVUtils;
import com.beppe.util.EasyPoiUtils;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author beppe
 * @data 2020/8/7 15:48
 * @description : 导出
 */
@RestController
@RequestMapping("export")
public class ExportController {

    @GetMapping
    public void export(HttpServletResponse response) throws ClassNotFoundException {
        List<StudentExcel> studentExcelList = new ArrayList<>();
        StudentExcel studentExcel = new StudentExcel();
        studentExcel.setClassName("一年级一班");
        studentExcel.setGender(1);
        studentExcel.setStudentId("1");
        studentExcel.setStudentName("小明");
        studentExcelList.add(studentExcel);
        EasyPoiUtils.exportExcel(studentExcelList, "标题", "sheetName", Class.forName("com.beppe.excel.StudentExcel"),
                "导出文件.xls", true, response);
    }

    @PostMapping("read")
    public void read(HttpServletResponse response) throws IOException, ClassNotFoundException {
        String[] headers = {"student_id", "gender", "class_name", "student_name"};
        ClassPathResource resource = new ClassPathResource("data/student.csv");
        InputStream inputStream = resource.getInputStream();
        List<CSVRecord> records = CSVUtils.readCsv(inputStream, headers);
        records.remove(0);
        List<StudentExcel> list = new ArrayList<>();
        for (CSVRecord csvRecord : records) {
            System.out.println(csvRecord);
            StudentExcel studentExcel = new StudentExcel();
            studentExcel.setStudentId(csvRecord.get(headers[0]));
            studentExcel.setGender(Integer.parseInt(csvRecord.get(headers[0])));
            studentExcel.setClassName(csvRecord.get(headers[2]));
            studentExcel.setStudentName(csvRecord.get(headers[3]));
            list.add(studentExcel);
        }
        EasyPoiUtils.exportExcel(list, "标题", "sheetName", Class.forName("com.beppe.excel.StudentExcel"),
                "导出文件.xls", true, response);
    }


    @PostMapping(value = "/uploadFile", consumes = "multipart/*", headers = "content-type=multipart/form-data")
    public void readExcel(@RequestParam MultipartFile file) throws Exception {
        List<StudentExcel> list = EasyPoiUtils.importExcel(file,1,1,StudentExcel.class);
    }
}
