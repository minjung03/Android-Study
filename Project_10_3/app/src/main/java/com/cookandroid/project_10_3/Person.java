package com.cookandroid.project_10_3;

import java.io.Serializable;

public class Person implements Serializable {

    private String name;
    private String gender;
    private String tel;
    private String address;

    // 위 메뉴 Code -> 제너릭(4번째) *자동코드 생성 *implements 했으니 제너릭으로!?

    public Person(String name, String gender, String tel, String address) {
        this.name = name;
        this.gender = gender;
        this.tel = tel;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String age) {
        this.gender = age;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getTel() {
        return tel;
    }

    public String getAddress() {
        return address;
    }
}
