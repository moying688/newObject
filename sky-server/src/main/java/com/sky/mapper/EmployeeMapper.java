package com.sky.mapper;

import com.sky.entity.Employee;
<<<<<<< HEAD
import org.apache.ibatis.annotations.Insert;
=======
>>>>>>> 5e5b6e5ae2c7ab2773bfa65a5341987e7d8934ae
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

<<<<<<< HEAD
    @Insert("insert into sky_take_out.employee (name, username, password, phone, sex, id_number, create_time, update_time, create_user, update_user)" +
            "values" +
            "(#{name},#{username},#{password},#{phone},#{sex},#{idNumber},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    void insert(Employee employee);
=======
>>>>>>> 5e5b6e5ae2c7ab2773bfa65a5341987e7d8934ae
}
