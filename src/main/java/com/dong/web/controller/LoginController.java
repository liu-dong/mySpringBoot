package com.dong.web.controller;

import com.dong.utils.ResponseResult;
import com.dong.web.model.LoginBean;
import com.dong.web.service.LoginService;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 用户登录模块
 *
 * @author LD
 * @date 2020/3/22 20:59
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Resource
    private Producer producer;

    /**
     * 登录
     *
     * @param bean
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseResult login(LoginBean bean, HttpServletRequest request) {
        // 从session中获取之前保存的验证码跟前台传来的验证码进行匹配
        final Object kaptcha = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (kaptcha == null) {
            return ResponseResult.error("验证码已失效");
        }
        if (!kaptcha.equals(bean.getCaptcha())) {
            return ResponseResult.error("验证码不正确");
        }
        return loginService.login(bean);
    }

    /**
     * 动态生成验证码
     *
     * @param response
     * @param request
     * @throws IOException
     */
    @GetMapping("/getKaptcha")
    public void getKaptcha(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        // 生成文字验证码
        String text = producer.createText();
        // 生成图片验证码
        BufferedImage image = producer.createImage(text);
        // 保存到验证码到 session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);
        ServletOutputStream out = response.getOutputStream();
        //使用支持给定格式的任意 ImageWriter写入图像到 File 。
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }
}
