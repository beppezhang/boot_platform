package com.beppe.test;

import com.beppe.entity.City;
import com.beppe.entity.CityDo;
import com.beppe.entity.ProductMarkInfoRequest;
import com.beppe.model.ToModel;
import com.beppe.model.UserDto;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Demo3 {
    static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        // 如果json中有新增的字段并且是实体类类中不存在的，不报错
        mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        // 如果存在未知属性，则忽略不报错
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 允许key没有双引号
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        // 允许key有单引号
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        // 允许整数以0开头
        mapper.configure(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS, true);
        // 允许字符串中存在回车换行控制符
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        //解决jackson无法反序列化LocalDate的问题
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.registerModule(new JavaTimeModule());
    }

    @Test
    public void test4() {
        String flag = "shanghai11";
        switch (flag) {
            case "beijing":
            case "shanghai":
            case "shenzhen":
            case "guanzhou":
                System.out.println("dddd");
        }
    }

    @Test
    public void test5()  {
//        int count =0;
//        for (int i = 0; i < 5; i++) {
//            count++;
//            System.out.println("flag:"+count);
//        }
        String str="https://ddmc-test-2w.ddimg.mobi/product/704e8b0cb7df47a198347b91e9122b79.jpg?width=750&height=1456,\n" +
                "https://ddmc-test-2w.ddimg.mobi/product/95f7eaa76627442a9f9f5a73111e30f8.jpg?width=750&height=1456,\n" +
                "https://ddmc-test-2w.ddimg.mobi/product/9386f496ebb64fe991a0899d9327f653.jpg?width=750&height=1456,\n" +
                "https://ddmc-test-2w.ddimg.mobi/product/4d238b1e608a4b9781a204dc91c19092.jpg?width=750&height=1457,\n" +
                "https://ddmc-test-2w.ddimg.mobi/product/19dc2aeb205e45fd9eb6ea1080d2ae03.jpg?width=750&height=1456,https://ddmc-test-2w.ddimg.mobi/product/d2917d2f8f8e44b781ec01e70b6c8f1e.jpg?width=750&height=1456,\n" +
                "https://ddmc-test-2w.ddimg.mobi/product/5784ca5d894f44389345d074f086c41f.jpg?width=750&height=1456,\n" +
                "https://ddmc-test-2w.ddimg.mobi/product/b9a62f5610224b4fb4980f462af9d76e.jpg?width=750&height=1456,\n" +
                "https://ddmc-test-2w.ddimg.mobi/product/1245319ee80d484db1138fe2b00cfe78.jpg?width=750&height=1457,\n" +
                "https://ddmc-test-2w.ddimg.mobi/product/072202c6559c4a6eae395a8344f57c0d.jpg?width=750&height=1456,\n" +
                "https://ddmc-test-2w.ddimg.mobi/product/6e953786e7a140ca9840f46376a07a3f.jpg?width=750&height=1456,\n" +
                "https://ddmc-test-2w.ddimg.mobi/product/f40b0cf94b6a44c3b7076701d98e159f.jpg?width=750&height=710";
        List<String> imageSet=new ArrayList<>();
        String[] split = str.split(",");
        for (String image : split) {
            imageSet.add(image);
        }
        System.out.println("list:"+imageSet);

    }

    private static ObjectMapper objectMapper = new ObjectMapper();
    public static <T> T parseObject(String body, Class<T> clazz) {
        try {
            return null == body ? null : objectMapper.readValue(body, clazz);
        } catch (IOException var3) {

        }
        return null;
    }

    @Test
    public void test6() throws JsonProcessingException {
        String str="{\n" +
                "    \"remark\": \"2333\",\n" +
                "    \"productId\": 126480,\n" +
                "    \"baseName\": \"商品名称\",\n" +
                "    \"specInfo\": {\n" +
                "      \"specMark\": {\n" +
                "        \"spec\": \"af222222222\",\n" +
                "        \"mark\": true\n" +
                "      },\n" +
                "      \"specCity\": [\n" +
                "        \n" +
                "      ]\n" +
                "    },\n" +
                "    \"recommendedReasonInfo\": {\n" +
                "      \"recommendedReasonMark\": {\n" +
                "        \"recommendedReason\": \"sdf,dsf,df,tt,zs\",\n" +
                "        \"mark\": true\n" +
                "      },\n" +
                "      \"recommendedReasonCity\": [\n" +
                "        \n" +
                "      ]\n" +
                "    },\n" +
                "    \"imageMarkInfoList\": [\n" +
                "      {\n" +
                "        \"templateId\": 103280,\n" +
                "        \"imageListMark\": false,\n" +
                "        \"imageDetailMark\": true\n" +
                "      }\n" +
                "    ]\n" +
                "  }";
        mapper.readValue(str, ProductMarkInfoRequest.class);
    }


    @Test
    public void test7(){
        City.GenericCityInfo genericCityInfo = new City.GenericCityInfo();
        genericCityInfo.setCityId("1111");
        genericCityInfo.setIsDelete(true);
        genericCityInfo.setValue("-1");
        City.GenericCityInfo genericCityInfo1 = new City.GenericCityInfo();
        BeanUtils.copyProperties(genericCityInfo,genericCityInfo1);

    }


    @Test
    public void test8(){
        // 根据类型找到接口的实现类
        ToModel toModel1 = new ToModel();
        toModel1.setOpSense(1);
        ToModel toModel2 = new ToModel();
        toModel2.setOpSense(2);
        toModel2.setFlag(true);
        ToModel toModel3 = new ToModel();
        toModel3.setOpSense(2);
        toModel3.setFlag(false);
        List<ToModel> toModels = Lists.newArrayList(toModel1, toModel2, toModel3);
        List<Integer> collect = toModels.stream().map(ToModel::getOpSense).distinct().collect(Collectors.toList());
        System.out.println("collect:"+collect);

        String ss=null;
        boolean b = ss != "-1";
        System.out.println("bbb:"+b);
//        boolean b = toModels.stream().anyMatch(toModel -> BooleanUtils.isTrue(toModel.getFlag()));
//        System.out.println("b"+b);
//        String[] split = StringUtils.split("");
//        List<String> strings = Lists.newArrayList(split);
    }

    @Test
    public void test9(){
//        int width = 440;
//        int height = 716;
//        int y = 3;//top
//        double x1 = 0.0357;//left
        String imagetype = ".jpeg";
        String oriImage="https://pub.ddimg.mobi/fdc-service/547940d5992f4abcb3633675ba0d36ec.jpeg?imageMogr2/thumbnail/1024x1024";
        String copyImageName = "_copy";
        String drawImage = "/Users/zhangshangliang/Desktop/" + copyImageName + imagetype;
        BufferedImage bufferedImage = null;
        InputStream inputStream=null;
        //读取图片文件，得到BufferedImage对象
        try {
            inputStream = new URL(oriImage).openConnection()
                    .getInputStream();
            bufferedImage = ImageIO.read(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int x1 = (int) Math.round(bufferedImage.getWidth(null)*0.0711);
        int x2 = (int) Math.round(bufferedImage.getWidth(null)*0.4781);
        int y1 = (int) Math.round(bufferedImage.getHeight(null)*0.2484);
        int y2 = (int) Math.round(bufferedImage.getHeight(null)*0.3747);



        //得到Graphics2D 对象
        Graphics2D g2D=(Graphics2D)bufferedImage.getGraphics();
        //设置颜色、画笔粗细
        g2D.setColor(Color.RED);
        g2D.setStroke(new BasicStroke(5));
        //绘制矩形
        g2D.drawRect(x1, y1, x2-x1, y2-y1);
        g2D.setFont(new Font("",Font.BOLD,40));


        try {
            //保存绘制后的新图片
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            ImageIO.write(bufferedImage, "JPG", baos);
//            byte[] bytes = baos.toByteArray();
//            String s = Base64.getEncoder().encodeToString(bytes);
//            System.out.println("s:"+s);
//            System.out.println("=========");
            ImageIO.write(bufferedImage, "JPG",new FileOutputStream(drawImage));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test10() {
        UserDto userDto = new UserDto();
        City city = new City();
        city.setId("11");
        city.setName("sh");
        userDto.setForm(city);
        toJavaObject(userDto.getForm(), City.class);
    }

    public static <T> T toJavaObject(Object obj, Class<T> tClass) {
        return obj != null ? toJavaObject(toJSONString(obj), tClass, () -> null) : null;
    }

    public static String toJSONString(Object obj) {
        return obj != null ? toJSONString(obj, () -> "", false) : "";
    }

    public static <T> T toJavaObject(String value, Class<T> tClass, Supplier<T> defaultSupplier) {
        try {
            if (org.apache.commons.lang3.StringUtils.isBlank(value)) {
                return defaultSupplier.get();
            }
            return mapper.readValue(value, tClass);
        } catch (Throwable e) {
        }
        return defaultSupplier.get();
    }

    public static String toJSONString(Object obj, Supplier<String> defaultSupplier, boolean format) {
        try {
            if (obj == null) {
                return defaultSupplier.get();
            }
            if (obj instanceof String) {
                return obj.toString();
            }
            if (obj instanceof Number) {
                return obj.toString();
            }
            if (format) {
                return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            }
            return mapper.writeValueAsString(obj);
        } catch (Throwable e) {
        }
        return defaultSupplier.get();
    }

    @Test
    public void test11(){
//        Date now=new Date();
//        Date date = dateStrToDate("2024-03-23", "yyyy-MM-dd", Locale.getDefault());
//        boolean after = now.toInstant().isAfter(date.toInstant());
        StringBuilder sb = new StringBuilder();
        System.out.println("after:"+StringUtils.isNotBlank(sb.toString()));

    }

    public static Date dateStrToDate(String strDate, String format, Locale locale) {
        if (strDate == null || strDate.trim() == "")
            return null;
        try {
            return new SimpleDateFormat(format, locale).parse(strDate);
        } catch (ParseException ex) {
            return null;
        }
    }

    @Test
    public void test12() throws InstantiationException, IllegalAccessException {
        City city1 = new City();
        City city2 = new City();
        City city3 = new City();
        City city4 = new City();
        City city5 = new City();
        city1.setId("11");
        city1.setAmount(100l);
        city2.setId("12");
        city2.setAmount(100l);
        city3.setId("13");
        city3.setAmount(100l);
        city4.setId("14");
        city4.setAmount(100l);
        city5.setId("15");
        city5.setAmount(100l);
        List<City> cities = Lists.newArrayList(city1, city2, city3,city4,city5);
        List<List<City>> partition = Lists.partition(cities, 2);


        System.out.println("cities:"+partition);

    }

    public static <T> T bean2Bean(Object srcBeanObject, Class<T> class0) throws InstantiationException, IllegalAccessException {

            if(Objects.isNull(srcBeanObject)) {
                return class0.newInstance();
            }
            T t = class0.newInstance();

            bean2Bean(srcBeanObject, t);


            return t;

    }

    public static void bean2Bean(Object srcBeanObject, Object destBeanObject) {
        BeanWrapperImpl srcBean = new BeanWrapperImpl(srcBeanObject);
        BeanWrapperImpl destBean = new BeanWrapperImpl(destBeanObject);
        PropertyDescriptor[] destDesc = destBean.getPropertyDescriptors();

        try {
            for (int i = 0; i < destDesc.length; ++i) {
                String name = destDesc[i].getName();
                if (destBean.isWritableProperty(name) && srcBean.isReadableProperty(name)) {
                    Object srcValue = srcBean.getPropertyValue(name);
                    if (srcValue != null) {
                        destBean.setPropertyValue(name, srcValue);
                    }
                }
            }

        } catch (Exception var8) {
            // TODO: 2021/7/11   明确异常信息，保证异常信息可以被上游感知到；否则难以定位问题
            String msg="BeanUtils.bean2Bean 异常错误，请检查:";
            if (var8!=null){
                msg=msg+"ExceptionClassName = "+var8.getClass().getName()+"message = "+var8.getMessage();
            }
            
        }
    }

    @Test
    public void test14(){
        System.out.println("aaaa");

    }




}
