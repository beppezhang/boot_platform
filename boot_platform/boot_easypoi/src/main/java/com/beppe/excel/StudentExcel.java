package com.beppe.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author beppe
 * @data 2020/8/7 15:41
 * @description : Excel 导出类
 */
@Data
public class StudentExcel implements Serializable {

    private static final long serialVersionUID = -6254077899894792639L;

    @Excel(name = "学号", orderNum = "1")
    private String studentId;

    @Excel(name = "性别", replace = {"男_1", "女_2"}, suffix = "生", orderNum = "2")
    private int gender;

    @Excel(name = "班级", orderNum = "3")
    private String className;

    @Excel(name = "姓名", orderNum = "4")
    private String studentName;

}
