package cn.jyd.sixteen.mappers;


import cn.jyd.sixteen.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    Employee getEmployeeById(Integer id);
    Employee getEmployeeByUsername(String username);
    List<Employee> getAllEmployee();
}
