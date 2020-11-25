package com.dsr.jschool.data.mapper;

public class MappingKey {

    private final Class<?> in;
    private final Class<?> out;

    public MappingKey(Class<?> in, Class<?> out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MappingKey that = (MappingKey) o;

        if (in != null ? !in.equals(that.in) : that.in != null) return false;
        return out != null ? out.equals(that.out) : that.out == null;
    }

    @Override
    public int hashCode() {
        int result = in != null ? in.hashCode() : 0;
        result = 31 * result + (out != null ? out.hashCode() : 0);
        return result;
    }
}
