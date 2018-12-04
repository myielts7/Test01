package com.ibeifeng.contollor;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@MultipartConfig
public class UploadControllor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part file = req.getPart("file");
        String str = req.getHeader("content-disposition");
        substr(str);
        System.out.println(file);
    }
    public String substr(String str){
        String[] strs = str.split("=");
        int start = strs[2].indexOf("\"");
        int end =strs[2].lastIndexOf("\"");
        String substring = strs[2].substring(start+1,end);
        System.out.println(substring);
        return substring;
    }

    public static void main(String[] args) {

    }
}
