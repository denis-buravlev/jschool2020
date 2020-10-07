package com.dsr.jschool.data.dto;

import java.util.Objects;

public class Test4Dto {

    private String name;
    private Integer age;

    public Test4Dto() {
    }

    public Test4Dto(String name, Integer age) {
        this.name = name;
        this.age = age;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test4Dto test4Dto = (Test4Dto) o;
        return Objects.equals(name, test4Dto.name) &&
                Objects.equals(age, test4Dto.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
