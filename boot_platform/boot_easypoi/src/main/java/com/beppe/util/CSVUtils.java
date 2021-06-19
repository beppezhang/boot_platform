package com.beppe.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.coyote.http11.Constants;
import org.springframework.util.Assert;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * CSVUtils
 *
 * @author Lijin
 * @version 1.0.0
 */
@Slf4j
public final class CSVUtils {

    private CSVUtils() {

    }

    /**
     * 读取csv文件
     *
     * @param inputStream
     *         文件流
     * @param headers
     *         文件头
     * @return CSVRecord
     * @throws IOException
     */
    public static List<CSVRecord> readCsv(InputStream inputStream, String[] headers) throws IOException {
        Assert.notNull(inputStream, "inputStream");
        CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader(headers);
        List<CSVRecord> records = new ArrayList<>();
        try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream); CSVParser parser = new CSVParser(inputStreamReader, csvFormat)) {
            records = parser.getRecords();
        }
        log.info("读取文件成功");
        return records;
    }

    /**
     * 写入csv文件
     *
     * @param file
     *         文件
     * @param headers
     *         列头
     * @param data
     *         数据
     * @throws IOException
     */
    public static String writeCsv(File file, String[] headers, List<String[]> data) throws IOException {
        Assert.notNull(file, "file");
        CSVFormat csvFormat = CSVFormat.DEFAULT.withRecordSeparator(Constants.CRLF);
        try (FileWriter fileWriter = new FileWriter(file); CSVPrinter csvPrinter = new CSVPrinter(fileWriter, csvFormat)) {
            csvPrinter.printRecord(headers);
            if (CollectionUtils.isNotEmpty(data)) {
                for (String[] lineData : data) {
                    csvPrinter.printRecord(lineData);
                }
            }
        }
        String path = file.getPath();
        log.info("写入{}文件成功,文件路径", path);
        return path;
    }

}