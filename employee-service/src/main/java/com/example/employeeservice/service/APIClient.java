package com.example.employeeservice.service;

import com.example.employeeservice.dto.DepartmentDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {

    @CircuitBreaker(name = "department-detail", fallbackMethod = "getDefaultDepartment")
    @GetMapping("api/departments/{department-code}")
    DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);

    default DepartmentDto getDefaultDepartment(String departmentCode, Throwable ex) {
        return new DepartmentDto(0L, "R&D Department",
                "Research and Development", "RD001");
    }
}
