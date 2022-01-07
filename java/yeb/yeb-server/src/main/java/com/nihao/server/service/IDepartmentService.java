package com.nihao.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nihao.server.pojo.Department;
import com.nihao.server.pojo.RespBean;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chenziran
 * @since 2021-11-15
 */
public interface IDepartmentService extends IService<Department> {

    /**
     * 获取所有部门
     * @return
     */
    List<Department> getAllDepartments();



    /**
     * 添加部门
     * @return
     */
    RespBean addDep(Department dep);

    /**
     * 删除部门
     * @param id
     * @return
     */
    RespBean deleteDep(Integer id);
}
