package com.sky.service.impl;

import com.sky.constant.MessageConstant;
<<<<<<< HEAD
import com.sky.constant.PasswordConstant;
import com.sky.constant.StatusConstant;
import com.sky.context.BaseContext;
import com.sky.dto.EmployeeDTO;
=======
import com.sky.constant.StatusConstant;
>>>>>>> 5e5b6e5ae2c7ab2773bfa65a5341987e7d8934ae
import com.sky.dto.EmployeeLoginDTO;
import com.sky.entity.Employee;
import com.sky.exception.AccountLockedException;
import com.sky.exception.AccountNotFoundException;
import com.sky.exception.PasswordErrorException;
import com.sky.mapper.EmployeeMapper;
import com.sky.service.EmployeeService;
<<<<<<< HEAD
import org.springframework.beans.BeanUtils;
=======
>>>>>>> 5e5b6e5ae2c7ab2773bfa65a5341987e7d8934ae
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

<<<<<<< HEAD
import java.time.LocalDateTime;

=======
>>>>>>> 5e5b6e5ae2c7ab2773bfa65a5341987e7d8934ae
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 员工登录
     *
     * @param employeeLoginDTO
     * @return
     */
    public Employee login(EmployeeLoginDTO employeeLoginDTO) {
        String username = employeeLoginDTO.getUsername();
        String password = employeeLoginDTO.getPassword();

        //1、根据用户名查询数据库中的数据
        Employee employee = employeeMapper.getByUsername(username);

        //2、处理各种异常情况（用户名不存在、密码不对、账号被锁定）
        if (employee == null) {
            //账号不存在
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

<<<<<<< HEAD
        // TODO 密码比对
//         TODO 后期需要进行md5加密，然后再进行比对(已处理)
        password = DigestUtils.md5DigestAsHex(password.getBytes());

=======
        //密码比对
        // TODO 后期需要进行md5加密，然后再进行比对
>>>>>>> 5e5b6e5ae2c7ab2773bfa65a5341987e7d8934ae
        if (!password.equals(employee.getPassword())) {
            //密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        if (employee.getStatus() == StatusConstant.DISABLE) {
            //账号被锁定
            throw new AccountLockedException(MessageConstant.ACCOUNT_LOCKED);
        }

        //3、返回实体对象
        return employee;
    }

<<<<<<< HEAD
    /**
     * 新增员工
     * @param employeeDTO
     */

    @Override
    public void save(EmployeeDTO employeeDTO) {
        Employee employee =new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);//拷贝属性
        employee.setStatus(StatusConstant.ENABLE);
        employee.setCreateTime(LocalDateTime.now());
        employee.setUpdateTime(LocalDateTime.now());

//        employee.setPassword(PasswordConstant.DEFAULT_PASSWORD);
        //加密
        employee.setPassword(DigestUtils.md5DigestAsHex(PasswordConstant.DEFAULT_PASSWORD.getBytes()));

        employee.setCreateUser(BaseContext.getCurrentId());
        employee.setUpdateUser(BaseContext.getCurrentId());

        employeeMapper.insert(employee);

    }

=======
>>>>>>> 5e5b6e5ae2c7ab2773bfa65a5341987e7d8934ae
}
