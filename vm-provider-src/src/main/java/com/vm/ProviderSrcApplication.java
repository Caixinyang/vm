package com.vm;

import com.vm.src.listener.ApplicationRefreshedListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by ZhangKe on 2018/2/3.
 */


@SpringBootApplication
@ServletComponentScan
@EnableDiscoveryClient
public class ProviderSrcApplication {

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(ProviderSrcApplication.class);
        springApplication.addListeners(new ApplicationRefreshedListener());
        springApplication.run(args);

    }

}
