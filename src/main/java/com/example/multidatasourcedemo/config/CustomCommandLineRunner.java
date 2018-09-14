package com.example.multidatasourcedemo.config;/*
 *
 * @author 12539 1253950375@qq.com
 *  Created in 2018/9/15
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomCommandLineRunner implements CommandLineRunner {

    @Value("${spring.web.login-url}")
    private String loginUrl;

    @Value("${spring.web.browser-path}")
    private String browserPath;

    @Value("${spring.web.auto-open}")
    private boolean isOpen;

    @Override
    public void run(String... args) throws Exception {
        if (isOpen) {
            String cmd = browserPath + " " + loginUrl;
            Runtime run = Runtime.getRuntime();
            try {
                log.info("正在启动浏览器打开项目");
                run.exec(cmd);
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }
    }
}
