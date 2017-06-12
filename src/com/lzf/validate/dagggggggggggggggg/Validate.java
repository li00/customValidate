package com.lzf.validate.dagggggggggggggggg;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by lizf on 2017/6/12.
 */
public class Validate extends HttpServlet {
    private String V_CODE ;//输出到客户端
    public static int WIDTH = 58;
    public static int HEIGHT = 20;

    @Override
    public void init() throws ServletException {
        super.init();
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //生成验证码
        HttpSession session =req.getSession();
        int i =  (int) (Math.random()*10);
        int j =  (int) (Math.random()*10);
        char[] ch = {'加','减','乘'};
        int operator = (int) (Math.random()*3+1);
        String sessionCode ;//存到session
        switch (ch[operator-1]){
            case '加':
                sessionCode = (i+j)+"";
                session.setAttribute("SESSION_CODE",sessionCode);
                V_CODE = i+" 加 "+j+" = ?";
                break;
            case '减':
                sessionCode = (i-j)+"";
                session.setAttribute("SESSION_CODE",sessionCode);
                V_CODE = i+" 减 "+j+" = ?";
                break;
            case '乘':
                sessionCode = (i*j)+"";
                session.setAttribute("SESSION_CODE",sessionCode);
                V_CODE = i+" 乘 "+j+" = ?";
                break;
        }
        //创建一个画板
        BufferedImage bufferedImage = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
        //创建画笔
        Graphics2D graphics2D = bufferedImage.createGraphics();
        //设置背景色
        graphics2D.setBackground(Color.blue);
        //创建二维码区域
        graphics2D.clearRect(0,0,WIDTH,HEIGHT);
        //设置内容颜色
        graphics2D.setColor(Color.green);
        float x = 3F;//x轴
        float y = 14F;//y轴
        graphics2D.drawString(V_CODE,x,y);

        //释放资源,清空缓存
        graphics2D.dispose();
        bufferedImage.flush();

        ImageIO.write(bufferedImage,"png",resp.getOutputStream()); //输出图片
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}

