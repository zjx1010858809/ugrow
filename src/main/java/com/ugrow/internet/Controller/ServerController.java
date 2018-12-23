package com.ugrow.internet.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ClassUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ugrow.internet.ueditor.ActionEnter;

@Controller
public class ServerController {

    /*@RequestMapping(value="/config")
    public void config(HttpServletRequest request, HttpServletResponse response) throws JSONException {
        response.setContentType("application/json");
        String rootPath =ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/ueditor/jsp";
        System.out.println(rootPath);

        try {
            response.setCharacterEncoding("UTF-8");
            String exec = new ActionEnter(request, rootPath).exec();
            System.out.println(exec);
            PrintWriter writer = response.getWriter();
            writer.write(new ActionEnter( request, rootPath ).exec());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }*/
    @RequestMapping(value="/static/ueditor/config")
    public void config(HttpServletRequest request, HttpServletResponse response) throws JSONException {
        response.setContentType("application/json");
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        try {
            String exec = new ActionEnter(request, rootPath).exec();
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
