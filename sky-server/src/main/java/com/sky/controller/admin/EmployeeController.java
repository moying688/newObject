package com.sky.controller.admin;

import com.sky.constant.JwtClaimsConstant;
<<<<<<< HEAD
import com.sky.dto.EmployeeDTO;
=======
>>>>>>> 5e5b6e5ae2c7ab2773bfa65a5341987e7d8934ae
import com.sky.dto.EmployeeLoginDTO;
import com.sky.entity.Employee;
import com.sky.properties.JwtProperties;
import com.sky.result.Result;
import com.sky.service.EmployeeService;
import com.sky.utils.JwtUtil;
import com.sky.vo.EmployeeLoginVO;
<<<<<<< HEAD
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
=======
>>>>>>> 5e5b6e5ae2c7ab2773bfa65a5341987e7d8934ae
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 员工管理
 */
@RestController
@RequestMapping("/admin/employee")
@Slf4j
<<<<<<< HEAD
@Api(tags= "员工相关接口")
=======
>>>>>>> 5e5b6e5ae2c7ab2773bfa65a5341987e7d8934ae
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 登录
     *
     * @param employeeLoginDTO
     * @return
     */
<<<<<<< HEAD
    @ApiOperation(value="员工登录相关接口")
=======
>>>>>>> 5e5b6e5ae2c7ab2773bfa65a5341987e7d8934ae
    @PostMapping("/login")
    public Result<EmployeeLoginVO> login(@RequestBody EmployeeLoginDTO employeeLoginDTO) {
        log.info("员工登录：{}", employeeLoginDTO);

        Employee employee = employeeService.login(employeeLoginDTO);

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.EMP_ID, employee.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims);

        EmployeeLoginVO employeeLoginVO = EmployeeLoginVO.builder()
                .id(employee.getId())
                .userName(employee.getUsername())
                .name(employee.getName())
                .token(token)
                .build();

        return Result.success(employeeLoginVO);
    }

    /**
     * 退出
     *
     * @return
     */
<<<<<<< HEAD
    @ApiOperation("员工退出接口")
=======
>>>>>>> 5e5b6e5ae2c7ab2773bfa65a5341987e7d8934ae
    @PostMapping("/logout")
    public Result<String> logout() {
        return Result.success();
    }

<<<<<<< HEAD
    @ApiOperation("新增员工接口")
    @PostMapping()
    public Result<String> save(@RequestBody EmployeeDTO employeeDTO){
        employeeService.save(employeeDTO);
        log.info("新增员工：{}",employeeDTO);
        return Result.success();
    }

=======
>>>>>>> 5e5b6e5ae2c7ab2773bfa65a5341987e7d8934ae
}