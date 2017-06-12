package com.lzf.validate.servlet;

import com.lzf.validate.SessionCode;
import com.lzf.validate.Validate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Administrator on 2017/6/12.
 */
public class ValidateServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String validate = (String) session.getAttribute(SessionCode.CODE);//从session获取验证码
        String v = request.getParameter("validate");//前台验证码
        System.out.println(validate+"\t"+v+"\t"+SessionCode.CODE);
        if(v!=null){
            if(v.equals(validate)){
                request.setAttribute("msg","验证成功!");
            }else {
                request.setAttribute("msg","验证失败!");
            }
        }
        request.getRequestDispatcher("/result.jsp").forward(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
