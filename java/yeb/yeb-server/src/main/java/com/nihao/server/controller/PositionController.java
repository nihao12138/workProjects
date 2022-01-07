package com.nihao.server.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nihao.server.exception.GlobalException;
import com.nihao.server.pojo.Position;
import com.nihao.server.pojo.RespBean;
import com.nihao.server.service.IPositionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.security.GeneralSecurityException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static java.lang.Boolean.TRUE;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chenziran
 * @since 2021-11-15
 */
@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {

    @Autowired
    private IPositionService positionService;

    @ApiOperation(value = "获取所有职位信息")
    @GetMapping("/")
    public List<Position> getAllPositions(){
        return positionService.list();
    }

    @ApiOperation(value = "添加职位信息")
    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position) throws GeneralSecurityException {

        if (!StringUtils.isEmpty(position)){
            position.setCreateDate(LocalDateTime.now());
            position.setEnabled(true);


            QueryWrapper<Position> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name", position.getName());
            List<Position> list = positionService.list(queryWrapper);
            if (list.size() == 0) {


               try{
                   positionService.save(position);
                   return RespBean.success("添加成功");
               }catch (Exception e){
                   return RespBean.success("添加成功");
               }


            } else {
                return RespBean.success("职位已存在");
            }
        }

        return RespBean.error("添加失败");
    }

    @ApiOperation(value = "更新职位信息")
    @PutMapping("/")
    public RespBean updatePosition(@RequestBody Position position){
        if (positionService.updateById(position)){
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败");
    }

    @ApiOperation(value = "删除职位信息")
    @DeleteMapping("/{id}")
    public RespBean deletePosition(@PathVariable Integer id){
        if (!StringUtils.isEmpty(id)) {
            QueryWrapper<Position> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", id);
            List<Position> list = positionService.list(queryWrapper);
            if (list.size() == 0) {
                return RespBean.error("该数据不存在,删除失败!");
            }
            boolean remove = positionService.removeById(id);
            if (remove) {
                return RespBean.success("删除成功!");
            }
        }
        return RespBean.error("删除失败!");

    }

    @ApiOperation(value = "批量删除职位信息")
    @DeleteMapping("/")
    public RespBean deletePositionByIds(Integer[] ids){
        if (positionService.removeByIds(Arrays.asList(ids))){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败");
    }

}
