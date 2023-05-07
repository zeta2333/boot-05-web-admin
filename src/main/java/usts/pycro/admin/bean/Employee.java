package usts.pycro.admin.bean;

import lombok.Data;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-07 12:43 PM
 */
@Data
public class Employee {
    private Long empId;
    private String empName;
    private Integer age;
    private String gender;
    private String email;
}
