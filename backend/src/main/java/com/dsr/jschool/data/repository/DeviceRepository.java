package com.dsr.jschool.data.repository;

import com.dsr.jschool.data.entity.Device;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DeviceRepository extends PagingAndSortingRepository<Device, Long> {
}
