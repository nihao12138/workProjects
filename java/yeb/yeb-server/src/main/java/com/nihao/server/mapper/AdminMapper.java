package com.nihao.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nihao.server.pojo.Admin;
import com.nihao.server.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chenziran
 * @since 2021-11-15
 */

public interface AdminMapper extends BaseMapper<Admin> {

    /**
     * 获取所有操作员
     * @param id
     * @param keywords
     * @return
     */

    List<Admin> getAllAdmins(@Param("id") Integer id, @Param("keywords") String keywords);
}
