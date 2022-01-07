package com.nihao.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nihao.server.pojo.Menu;
import com.nihao.server.pojo.MenuRole;
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
public interface IMenuRoleService extends IService<MenuRole> {

    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    RespBean updateMenusRole(Integer rid, Integer[] mids);
}
