package com.nihao.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nihao.server.pojo.AdminRole;
import com.nihao.server.pojo.RespBean;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chenziran
 * @since 2021-11-15
 */
public interface AdminRoleMapper extends BaseMapper<AdminRole> {

    /**
     * 更新操作员角色
     * @param adminId
     * @param rids
     * @return
     */
    Integer addAdminRole(@Param("adminId") Integer adminId, @Param("rids") Integer[] rids);
}
