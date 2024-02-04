package com.ipap.springboot3ai.model;

public class Singer {

    private String name;
    private int age;
    private String location;
    private String country;

    public Singer(String name, int age, String location, String country) {
        this.name = name;
        this.age = age;
        this.location = location;
        this.country = country;
    }

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Singer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", location='" + location + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
