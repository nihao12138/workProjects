package com.nihao.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nihao.server.pojo.Admin;
import com.nihao.server.pojo.Menu;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chenziran
 * @since 2021-11-15
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 根据用户id查询菜单列表
     * @return
     */
    List<Menu> getMenusByAdminId();

    /**
     * 根据角色获取菜单列表
     * @return
     */
    List<Menu> getMenusWithRole();

    /**
     * 查询所有菜单
     * @return
     */
    List<Menu> getAllMenus();
}
