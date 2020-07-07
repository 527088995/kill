package com.debug.kill.server.admin.controller;

import com.lowagie.text.pdf.BaseFont;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

/**
 * Filename: JspToHtml.java <br>
 * Ttitle: jsp转换成html<br>
 * De.ion: 把动态网页转换成静态网页<br>
 * Copyright: Copyright (c) 2002-2008 BocSoft,Inc.All Rights Reserved. <br>
 * Company: BocSoft<br>
 * Author: <a href="mailto:sgicer@163.com">阿汐</a> <br>
 * Date: 2006-6-19 <br>
 * Time: 16:41:09 <br>
 * Version: 2.0.0 <br>
 */
public class JspToHtml {

    private static String title = "标题测试";
    private static String context = "标题测试";
    private static String editer = "标题测试";



    /**
     * 根据url生成静态页面
     *
     * @param u    动态文件路经 如：http://www.163.com/x.jsp
     * @param path 文件存放路经如：x:\\abc\bbb.html
     * @return
     */
    public static boolean JspToHtmlByURL(String u, String path) {
        //从utl中读取html存为str
        String str = "";
        try {
            URL url = new URL(u);
            URLConnection uc = url.openConnection();
            InputStream is = uc.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while (br.ready()) {
                str += br.readLine() + "\n";

            }
            is.close();
            //写入文件
            File f = new File(path);
            BufferedWriter o = new BufferedWriter(new FileWriter(f));
            o.write(str);
            o.close();
            str = "";
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据url生成静态页面
     *
     * @param url 动态文件路经 如：http://www.163.com/x.jsp
     * @return d
     */
    public static StringBuffer getHtmlTextByURL(String url) {
        //从utl中读取html存为str
        StringBuffer sb = new StringBuffer();
        try {
            URL u = new URL(url);
            URLConnection uc = u.openConnection();
            InputStream is = uc.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while (br.ready()) {
                sb.append(br.readLine() + "\n");
            }
            is.close();
            return sb;
        } catch (Exception e) {
            e.printStackTrace();
            return sb;
        }
    }
    /**
     * 根据本地模板生成静态页面
     *
     * @return
     */
    public static String JspToHtmlFile(String filePath) {
        String str = "";
        long beginDate = (new Date()).getTime();
        try {
            String tempStr = "";

            FileInputStream is = new FileInputStream(filePath);//读取模块文件
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while ((tempStr = br.readLine()) != null)
                str = str + tempStr;
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
            return "false";
        }
        try {

            str = str.replaceAll("###title###", title);
            str = str.replaceAll("###content###", context);
            str = str.replaceAll("###author###", editer);//替换掉模块中相应的地方

            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }
    /**
     * html转pdf
     *
     * @throws Exception
     */
    public static void testHtml2Pdf(String filePath) {
        try {


            StringBuffer html = new StringBuffer();

            html.append("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\"></meta>\n" +
                    "    <title>Issue Payment Receipt</title>\n" +
                    "    <style type=\"text/css\">\n" +
                    "    body {\n" +
                    "        font-family: Arial Unicode MS;\n" +
                    "    }\n" +
                    "    </style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <img src=\"file/logo.png\" style=\"width:160px;height:80px;\"></img>\n" +
                    "    <br/>\n" +
                    "    <br/> 建設銀行\n" +
                    "    <br/> 12345678901\n" +
                    "    <br/> 1000RMB\n" +
                    "    <br/> 姓名:李四\n" +
                    "    <br/> 單號:123456\n" +
                    "    <br/>\n" +
                    "</body>\n" +
                    "</html>");
            String jspToHtmlFile =JspToHtmlFile(filePath);
            //指定PDF的存放路径
            String outputFile = "/Users/hongzhenyue/Desktop/backup/spring_boot_demo/src/main/resources/file/test.pdf";
            OutputStream os = new FileOutputStream(outputFile);
            ITextRenderer renderer = new ITextRenderer();
            ITextFontResolver fontResolver = renderer.getFontResolver();
            //指定字体。为了支持中文字体
            fontResolver.addFont("font/arialunicodems.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            renderer.setDocumentFromString(jspToHtmlFile);
            // 解决图片的相对路径问题
            renderer.getSharedContext().setBaseURL("src/main/resources/file");
            renderer.layout();
            renderer.createPDF(os);
            renderer.finishPDF();
            renderer = null;
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 测试main 函数
     *
     * @param arg
     */
    public static void main(String[] arg) {
        long begin = System.currentTimeMillis();
        //循环生成10个html文件
        File file = new File("src/main/resources/resource.properties");
        String url = "src/main/resources/test.html";//模板文件地址
        String savepath = "F:\\test";//生成文件地址
        testHtml2Pdf(url);
        System.out.println("用时:" + (System.currentTimeMillis() - begin) + "ms");
    }
}
