package com.strength.controller;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.api.annotation.RemoteCacheable;
import com.api.annotation.RemoteCacheEvict;
import com.common.core.utils.R;
import com.common.entity.JianshenqicaiEntity;
import com.common.utils.MPUtil;
import com.common.utils.PageUtils;
import com.strength.service.JianshenqicaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
/**
 * 健身器材
 * 后端接口
 */
@RestController
@RequestMapping("/jianshenqicai")
public class JianshenqicaiController {

    @Autowired
    private JianshenqicaiService jianshenqicaiService;

    /**
     * 后端分页列表
     */
    @RemoteCacheable(key = "'jianshenqicai:page:' + #jianshenqicai.hashCode()")
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, JianshenqicaiEntity jianshenqicai, HttpServletRequest request) {
        EntityWrapper<JianshenqicaiEntity> ew = new EntityWrapper<>();
        PageUtils page = jianshenqicaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianshenqicai), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 前端分页列表
     */
    @RemoteCacheable(key = "'jianshenqicai:list:' + #jianshenqicai.hashCode()")
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, JianshenqicaiEntity jianshenqicai, HttpServletRequest request) {
        EntityWrapper<JianshenqicaiEntity> ew = new EntityWrapper<>();
        PageUtils page = jianshenqicaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianshenqicai), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表（无分页）
     */
    @RemoteCacheable(key = "'jianshenqicai:lists:' + #jianshenqicai.hashCode()")
    @RequestMapping("/lists")
    public R lists(JianshenqicaiEntity jianshenqicai) {
        EntityWrapper<JianshenqicaiEntity> ew = new EntityWrapper<>();
        ew.allEq(MPUtil.allEQMapPre(jianshenqicai, "jianshenqicai"));
        List<JianshenqicaiEntity> list = jianshenqicaiService.selectList(ew);
        return R.ok().put("data", list);
    }

    /**
     * 查询单个实体
     */
    @RemoteCacheable(key = "'jianshenqicai:query:' + #jianshenqicai.hashCode()")
    @RequestMapping("/query")
    public R query(JianshenqicaiEntity jianshenqicai) {
        EntityWrapper<JianshenqicaiEntity> ew = new EntityWrapper<>();
        ew.allEq(MPUtil.allEQMapPre(jianshenqicai, "jianshenqicai"));
        JianshenqicaiEntity entity = jianshenqicaiService.selectOne(ew);
        return R.ok("查询健身器材成功").put("data", entity);
    }

    /**
     * 后端详情
     */
    @RemoteCacheable(key = "'jianshenqicai:info:' + #id")
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        JianshenqicaiEntity entity = jianshenqicaiService.selectById(id);
        return R.ok().put("data", entity);
    }

    /**
     * 前端详情
     */
    @RemoteCacheable(key = "'jianshenqicai:detail:' + #id")
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        JianshenqicaiEntity entity = jianshenqicaiService.selectById(id);
        return R.ok().put("data", entity);
    }

    /**
     * 后端保存（新增）
     */
    @RemoteCacheEvict(key = "'jianshenqicai:*'")
    @RequestMapping("/save")
    public R save(@RequestBody JianshenqicaiEntity jianshenqicai, HttpServletRequest request) {
        jianshenqicai.setId(new Date().getTime() + (long)(Math.floor(Math.random() * 1000)));
        jianshenqicaiService.insert(jianshenqicai);
        System.out.println("保存健身活动实体：" + JSON.toJSONString(jianshenqicai));

        return R.ok();
    }

    /**
     * 前端保存（新增）
     */
    @RemoteCacheEvict(key = "'jianshenqicai:*'")
    @RequestMapping("/add")
    public R add(@RequestBody JianshenqicaiEntity jianshenqicai, HttpServletRequest request) {
        jianshenqicai.setId(new Date().getTime() + (long)(Math.floor(Math.random() * 1000)));
        jianshenqicaiService.insert(jianshenqicai);
        return R.ok();
    }

    /**
     * 修改
     */
    @RemoteCacheEvict(key = "'jianshenqicai:*'")
    @RequestMapping("/update")
    public R update(@RequestBody JianshenqicaiEntity jianshenqicai, HttpServletRequest request) {
        jianshenqicaiService.updateById(jianshenqicai);
        return R.ok();
    }

    /**
     * 删除
     */
    @RemoteCacheEvict(key = "'jianshenqicai:*'")
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        jianshenqicaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}
