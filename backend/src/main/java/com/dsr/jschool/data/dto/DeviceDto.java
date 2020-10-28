package com.dsr.jschool.data.dto;

public class DeviceDto {

    public DeviceDto() {
    }

    public DeviceDto(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    private Long id;
    private String name;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeviceDto deviceDto = (DeviceDto) o;

        if (id != null ? !id.equals(deviceDto.id) : deviceDto.id != null) return false;
        if (name != null ? !name.equals(deviceDto.name) : deviceDto.name != null) return false;
        return description != null ? description.equals(deviceDto.description) : deviceDto.description == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
