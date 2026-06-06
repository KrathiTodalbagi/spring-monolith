package com.example.employeeservice.service.impl;

import com.example.employeeservice.dto.APIResponseDto;
import com.example.employeeservice.dto.DepartmentDto;
import com.example.employeeservice.dto.EmployeeDto;
import com.example.employeeservice.dto.OrganisationDto;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.mapper.EmployeeMapper;
import com.example.employeeservice.repository.EmployeeRepository;
import com.example.employeeservice.service.APIClient;
import com.example.employeeservice.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final RestClient restClient;
    private final APIClient apiClient;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               APIClient apiClient, RestClient restClient) {
        this.employeeRepository = employeeRepository;
        this.apiClient = apiClient;
        this.restClient = restClient;
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        return EmployeeMapper.mapToEmployeeDto(employeeRepository.save(employee));
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();

//        DepartmentDto departmentDto = restClient.get()
//                .uri("http://localhost:8080/api/departments/{id}", employee.getDepartmentCode())
//                .retrieve()
//                .body(DepartmentDto.class);

        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        OrganisationDto organisationDto = restClient.get()
                .uri("http://localhost:8083/api/organisations/{code}", employee.getOrganisationCode())
                .retrieve()
                .body(OrganisationDto.class);

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        apiResponseDto.setOrganisation(organisationDto);
        return apiResponseDto;
    }
}
