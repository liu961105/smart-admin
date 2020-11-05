package net.lab1024.smartadmin.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Authou LZN
 * @Date 2020/6/3 10:29
 * 项目启动的时候自动初始化对象
 **/
@Component
public class StartupRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>>服务已成功启动，开始执行加载数据等操作<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }
}
