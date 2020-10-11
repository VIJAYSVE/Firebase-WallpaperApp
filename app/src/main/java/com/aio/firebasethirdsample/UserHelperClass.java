package com.aio.firebasethirdsample;

public class UserHelperClass {
    String name, gender;
    int age, mobile;

    public UserHelperClass() {
    }

    @Override
    public String toString() {
        return "UserHelperClass{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", mobile=" + mobile +
                '}';
    }

    public UserHelperClass(String name, String gender, int age, int mobile) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {

        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }
}
