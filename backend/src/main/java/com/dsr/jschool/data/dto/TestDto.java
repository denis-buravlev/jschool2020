package com.dsr.jschool.data.dto;

import java.util.Objects;

public class TestDto {

    private String msg;

    public TestDto(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestDto testDto = (TestDto) o;
        return Objects.equals(msg, testDto.msg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msg);
    }
}
