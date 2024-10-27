package com.beppe.kafka.util;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author beppe
 * @data 2020/8/7 18:06
 * @description : 读取文件 将Java 文件读成可执行 class
 */
public class ReadFileToClass {

    private static final String dir = "/Users/mengke/IdeaProjects/study/boot_platform/boot_easypoi";

    public static Object createStudentByFile() throws Exception {
        String fileName = "/Users/mengke/Desktop/StudentExcel2.java";
        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.flush();
        fileWriter.close();


        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> javaFileObjects = manager.getJavaFileObjects(fileName);
        String dest = dir + "/target/classes";

        //options就是指定编译输入目录，与我们命令行写javac -d C://是一样的

        List<String> options = new ArrayList<String>();
        options.add("-d");
        options.add(dest);
        JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, options, null, javaFileObjects);
        task.call();
        manager.close();
        URL[] urls = new URL[]{new URL("file:/" + dir + "/target/classes")};

        //加载class时要告诉你的classloader去哪个位置加载class文件

        ClassLoader classLoader = new URLClassLoader(urls);
        Object student = classLoader.loadClass("com.beppe.excel.StudentExcel2").newInstance();
        return student;
    }


}
