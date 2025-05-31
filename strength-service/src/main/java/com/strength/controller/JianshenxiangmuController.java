package com.strength.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.api.annotation.RemoteCacheable;
import com.api.annotation.RemoteCacheEvict;
import com.common.core.utils.R;
import com.common.entity.JianshenxiangmuEntity;
import com.common.entity.view.JianshenxiangmuView;
import com.common.utils.MPUtil;
import com.common.utils.PageUtils;

import com.strength.service.JianshenxiangmuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

/**
 * 健身项目
 * 后端接口
 */
@RestController
@RequestMapping("/jianshenxiangmu")
public class JianshenxiangmuController {
    @Autowired
    private JianshenxiangmuService jianshenxiangmuService;

    /**
     * 后端分页列表
     */
    @RemoteCacheable(key = "'jianshenxiangmu:page:' + #params.hashCode()")
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, JianshenxiangmuEntity jianshenxiangmu,
                  HttpServletRequest request){
        EntityWrapper<JianshenxiangmuEntity> ew = new EntityWrapper<>();
        PageUtils page = jianshenxiangmuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianshenxiangmu), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 前端分页列表
     */
    @RemoteCacheable(key = "'jianshenxiangmu:list:' + #params.hashCode()")
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, JianshenxiangmuEntity jianshenxiangmu,
                  HttpServletRequest request){
        EntityWrapper<JianshenxiangmuEntity> ew = new EntityWrapper<>();
        PageUtils page = jianshenxiangmuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianshenxiangmu), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表（无分页）
     */
    @RemoteCacheable(key = "'jianshenxiangmu:lists:' + #jianshenxiangmu.hashCode()")
    @RequestMapping("/lists")
    public R lists(JianshenxiangmuEntity jianshenxiangmu){
        EntityWrapper<JianshenxiangmuEntity> ew = new EntityWrapper<>();
        ew.allEq(MPUtil.allEQMapPre(jianshenxiangmu, "jianshenxiangmu"));
        List<JianshenxiangmuView> list = jianshenxiangmuService.selectListView(ew);
        return R.ok().put("data", list);
    }

    /**
     * 查询单个视图实体
     */
    @RemoteCacheable(key = "'jianshenxiangmu:query:' + #jianshenxiangmu.hashCode()")
    @RequestMapping("/query")
    public R query(JianshenxiangmuEntity jianshenxiangmu){
        EntityWrapper<JianshenxiangmuEntity> ew = new EntityWrapper<>();
        ew.allEq(MPUtil.allEQMapPre(jianshenxiangmu, "jianshenxiangmu"));
        JianshenxiangmuView view = jianshenxiangmuService.selectView(ew);
        return R.ok("查询健身项目成功").put("data", view);
    }

    /**
     * 后端详情
     */
    @RemoteCacheable(key = "'jianshenxiangmu:info:' + #id")
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JianshenxiangmuEntity entity = jianshenxiangmuService.selectById(id);
        return R.ok().put("data", entity);
    }

    /**
     * 前端详情
     */
    @RemoteCacheable(key = "'jianshenxiangmu:detail:' + #id")
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JianshenxiangmuEntity entity = jianshenxiangmuService.selectById(id);
        return R.ok().put("data", entity);
    }

    /**
     * 后端保存（新增）
     */
    @RemoteCacheEvict(key = "'jianshenxiangmu:*'")
    @RequestMapping("/save")
    public R save(@RequestBody JianshenxiangmuEntity jianshenxiangmu, HttpServletRequest request){
        jianshenxiangmu.setId(new Date().getTime() + (long)(Math.floor(Math.random() * 1000)));
        jianshenxiangmuService.insert(jianshenxiangmu);
        return R.ok();
    }

    /**
     * 前端保存（新增）
     */
    @RemoteCacheEvict(key = "'jianshenxiangmu:*'")
    @RequestMapping("/add")
    public R add(@RequestBody JianshenxiangmuEntity jianshenxiangmu, HttpServletRequest request){
        jianshenxiangmu.setId(new Date().getTime() + (long)(Math.floor(Math.random() * 1000)));
        jianshenxiangmuService.insert(jianshenxiangmu);
        return R.ok();
    }

    /**
     * 修改
     */
    @RemoteCacheEvict(key = "'jianshenxiangmu:*'")
    @RequestMapping("/update")
    public R update(@RequestBody JianshenxiangmuEntity jianshenxiangmu, HttpServletRequest request){
        jianshenxiangmuService.updateById(jianshenxiangmu);
        return R.ok();
    }

    /**
     * 删除
     */
    @RemoteCacheEvict(key = "'jianshenxiangmu:*'")
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jianshenxiangmuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 提醒接口
     */
    @RequestMapping("/remind/{columnName}/{type}")
    public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request,
                         @PathVariable("type") String type, @RequestParam Map<String, Object> map) {
        map.put("column", columnName);
        map.put("type", type);

        if(type.equals("2")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            if(map.get("remindstart") != null) {
                Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
                c.setTime(new Date());
                c.add(Calendar.DAY_OF_MONTH, remindStart);
                map.put("remindstart", sdf.format(c.getTime()));
            }
            if(map.get("remindend") != null) {
                Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
                c.setTime(new Date());
                c.add(Calendar.DAY_OF_MONTH, remindEnd);
                map.put("remindend", sdf.format(c.getTime()));
            }
        }

        Wrapper<JianshenxiangmuEntity> wrapper = new EntityWrapper<>();
        if(map.get("remindstart") != null) {
            wrapper.ge(columnName, map.get("remindstart"));
        }
        if(map.get("remindend") != null) {
            wrapper.le(columnName, map.get("remindend"));
        }

        int count = jianshenxiangmuService.selectCount(wrapper);
        return R.ok().put("count", count);
    }
}
