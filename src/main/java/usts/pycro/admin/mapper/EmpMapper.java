package usts.pycro.admin.mapper;

import usts.pycro.admin.bean.Employee;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-07 12:42 PM
 */
//@Mapper
public interface EmpMapper {
    Employee getEmpById(Long id);
}
