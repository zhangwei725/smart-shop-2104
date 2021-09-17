package com.smart.auth.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseUtils {
    public static final String JSON_CONTENT_TYPE = "application/json;charset=UTF-8";

    public static void responseToJson(HttpServletResponse response, String result) throws IOException {
        response.setContentType(JSON_CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.write(result);
        out.flush();
    }
}