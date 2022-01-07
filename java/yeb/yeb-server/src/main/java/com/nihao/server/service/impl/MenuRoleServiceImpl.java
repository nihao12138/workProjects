package com.nihao.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nihao.server.mapper.MenuRoleMapper;
import com.nihao.server.pojo.Menu;
import com.nihao.server.pojo.MenuRole;
import com.nihao.server.pojo.RespBean;
import com.nihao.server.service.IMenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenziran
 * @since 2021-11-15
 */
@Service
public class MenuRoleServiceImpl extends ServiceImpl<MenuRoleMapper, MenuRole> implements IMenuRoleService {

    @Autowired
    private MenuRoleMapper menuRoleMapper;

    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    @Override
    @Transactional
    public RespBean updateMenusRole(Integer rid, Integer[] mids) {

        menuRoleMapper.delete(new QueryWrapper<MenuRole>().eq("rid",rid));
        if (null==mids||0==mids.length){
            return RespBean.success("更新成功!");
        }
        Integer result = menuRoleMapper.insertRecord(rid, mids);
        if (result == mids.length){
            return RespBean.success("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
}
