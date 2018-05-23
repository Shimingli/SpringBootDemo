package com.shiming;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: shiming
 * @Date: 2018/5/23 22:43
 * @Description:
 */
@Component //去掉就会报错 哈哈
@ConfigurationProperties(prefix = "me")// 读取配置文件me开头的标记哦
public class MeProperties {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;
       private int age;
}
