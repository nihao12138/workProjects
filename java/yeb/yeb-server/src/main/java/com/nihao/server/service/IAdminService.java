package com.nihao.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nihao.server.pojo.Admin;
import com.nihao.server.pojo.Menu;
import com.nihao.server.pojo.RespBean;
import com.nihao.server.pojo.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chenziran
 * @since 2021-11-15
 */
public interface IAdminService extends IService<Admin> {

    /**
     * 登录后返回token
     * @param username
     * @param password
     * @param code
     * @param httpServletRequest
     * @return
     */
    RespBean login(String username, String password, String code, HttpServletRequest httpServletRequest);


    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    Admin getAdminByUsername(String username);


    /**
     * 根据用户角色id查询角色列表
     * @param adminId
     * @return
     */
    List<Role> getRoles(Integer adminId);

    /**
     * 获取所有操作员
     * @param keywords
     * @return
     */
    List<Admin> getAllAdmins(String keywords);

    /**
     * 更新操作员角色
     * @param adminId
     * @param rids
     * @return
     */
    RespBean updateAdminRole(Integer adminId, Integer[] rids);
}
