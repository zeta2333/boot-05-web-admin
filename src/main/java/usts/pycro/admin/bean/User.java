package usts.pycro.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-24 10:57 AM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_tbl")
public class User {
    /**
     * 所有属性都应该在数据库中
     */
    @TableField(exist = false) //表示该字段在数据库中不存在，即忽略该字段
    private String userName;
    @TableField(exist = false)
    private String password;

    //以下是数据库的字段
    private Long id;
    private String name;
    private Integer age;
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
