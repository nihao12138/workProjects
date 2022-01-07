package com.nihao.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nihao.server.mapper.EmployeeMapper;
import com.nihao.server.pojo.Employee;
import com.nihao.server.pojo.Position;
import com.nihao.server.pojo.RespBean;
import com.nihao.server.pojo.RespPageBean;
import com.nihao.server.service.IEmployeeService;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Statement;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenziran
 * @since 2021-11-15
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private IEmployeeService employeeService;
    /**
     * 获取所有员工(分页)
     * @param currentPage
     * @param size
     * @param employee
     * @param beginDateScope
     * @return
     */
    @Override
    public RespPageBean getEmployeeByPage(Integer currentPage, Integer size, Employee employee, LocalDate[] beginDateScope) {

        //开启分页
        Page<Employee> page = new Page<>();

        IPage<Employee> employeeByPage = employeeMapper.getEmployeeByPage(page, employee, beginDateScope);

        RespPageBean respPageBean = new RespPageBean(employeeByPage.getTotal(),employeeByPage.getRecords());

        return respPageBean;
    }

    /**
     * 获取工号
     * @return
     */
    @Override
    public RespBean maxWorkID() {

        List<Map<String, Object>> maps = employeeMapper.selectMaps(new QueryWrapper<Employee>().select("max(workID)"));




        return RespBean.success(null,String.format("%08d",Integer.parseInt(maps.get(0).get("max(workID)").toString())+1));
    }

    /**
     * 添加员工
     * @param employee
     * @return
     */
    @Override
    public RespBean addEmp(Employee employee) {

        if (!StringUtils.isEmpty(employee)){
            //处理合同期限,保留2位小数
            LocalDate beginContract = employee.getBeginContract();
            LocalDate endContract = employee.getEndContract();
            long days = beginContract.until(endContract, ChronoUnit.DAYS);
            DecimalFormat decimalFormat=new DecimalFormat("##.00");
            employee.setContractTerm(Double.parseDouble(decimalFormat.format(days/365.00)));


            QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("workID", employee.getWorkID());
            List<Employee> list = employeeService.list(queryWrapper);
            if (list.size() == 0) {


                try{
                    employeeMapper.insert(employee);
                    return RespBean.success("添加成功！");
                }catch (Exception e){
                    return RespBean.success("添加成功！");
                }


            } else {
                return RespBean.success("员工已存在！");
            }
        }

        return RespBean.error("添加失败！");

    }

    /**
     * 查询员工
     * @param id
     * @return
     */
    @Override
    public List<Employee> getEmployee(Integer id) {
        return employeeMapper.getEmployee(id);
    }


}
