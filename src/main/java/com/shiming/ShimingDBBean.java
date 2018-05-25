package com.shiming;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * author： Created by shiming on 2018/5/25 17:31
 * mailbox：lamshiming@sina.com
 */
@Entity//对应数据库的一个表
public  class ShimingDBBean {
    @Id
    @GeneratedValue
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private String name;

    private Integer age;
    //必须来个无参的构造方法，要不然要报错
    public ShimingDBBean() {
    }
}
