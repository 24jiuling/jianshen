package com.strength.controller;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import com.api.annotation.RemoteCacheable;
import com.api.annotation.RemoteCacheEvict;
import com.common.core.utils.R;
import com.common.entity.JianshenhuodongEntity;
import com.common.entity.view.JianshenhuodongView;
import com.common.utils.MPUtil;
import com.common.utils.PageUtils;
import com.strength.service.JianshenhuodongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

/**
 * 健身活动
 * 后端接口
 */
@RestController
@RequestMapping("/jianshenhuodong")
public class JianshenhuodongController {
    @Autowired
    private JianshenhuodongService jianshenhuodongService;

    /**
     * 后端分页列表
     */
    @RemoteCacheable(key = "'jianshenhuodong:page:' + #params.hashCode()")
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, JianshenhuodongEntity jianshenhuodong, HttpServletRequest request){
        EntityWrapper<JianshenhuodongEntity> ew = new EntityWrapper<>();
        PageUtils page = jianshenhuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianshenhuodong), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 前端分页列表
     */
    @RemoteCacheable(key = "'jianshenhuodong:list:' + #params.hashCode()")
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, JianshenhuodongEntity jianshenhuodong, HttpServletRequest request){
        EntityWrapper<JianshenhuodongEntity> ew = new EntityWrapper<>();
        PageUtils page = jianshenhuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianshenhuodong), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表（无分页）
     */
    @RemoteCacheable(key = "'jianshenhuodong:lists:' + #jianshenhuodong.hashCode()")
    @RequestMapping("/lists")
    public R lists(JianshenhuodongEntity jianshenhuodong){
        EntityWrapper<JianshenhuodongEntity> ew = new EntityWrapper<>();
        ew.allEq(MPUtil.allEQMapPre(jianshenhuodong, "jianshenhuodong"));
        List<JianshenhuodongView> list = jianshenhuodongService.selectListView(ew);
        return R.ok().put("data", list);
    }

    /**
     * 查询单个视图实体
     */
    @RemoteCacheable(key = "'jianshenhuodong:query:' + #jianshenhuodong.hashCode()")
    @RequestMapping("/query")
    public R query(JianshenhuodongEntity jianshenhuodong){
        EntityWrapper<JianshenhuodongEntity> ew = new EntityWrapper<>();
        ew.allEq(MPUtil.allEQMapPre(jianshenhuodong, "jianshenhuodong"));
        JianshenhuodongView view = jianshenhuodongService.selectView(ew);
        return R.ok("查询健身活动成功").put("data", view);
    }

    /**
     * 后端详情
     */
    @RemoteCacheable(key = "'jianshenhuodong:info:' + #id")
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JianshenhuodongEntity entity = jianshenhuodongService.selectById(id);
        return R.ok().put("data", entity);
    }

    /**
     * 前端详情
     */
    @RemoteCacheable(key = "'jianshenhuodong:detail:' + #id")
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JianshenhuodongEntity entity = jianshenhuodongService.selectById(id);
        return R.ok().put("data", entity);
    }

    /**
     * 后端保存（新增）
     */
    @RemoteCacheEvict(key = "'jianshenhuodong:*'")
    @RequestMapping("/save")
    public R save(@RequestBody JianshenhuodongEntity jianshenhuodong, HttpServletRequest request){
        jianshenhuodong.setId(new Date().getTime() + (long)(Math.floor(Math.random()*1000)));
        jianshenhuodongService.insert(jianshenhuodong);
        return R.ok();
    }

    /**
     * 前端保存（新增）
     */
    @RemoteCacheEvict(key = "'jianshenhuodong:*'")
    @RequestMapping("/add")
    public R add(@RequestBody JianshenhuodongEntity jianshenhuodong, HttpServletRequest request){
        jianshenhuodong.setId(new Date().getTime() + (long)(Math.floor(Math.random()*1000)));
        jianshenhuodongService.insert(jianshenhuodong);
        return R.ok();
    }

    /**
     * 修改
     */
    @RemoteCacheEvict(key = "'jianshenhuodong:*'")
    @RequestMapping("/update")
    public R update(@RequestBody JianshenhuodongEntity jianshenhuodong, HttpServletRequest request){
        jianshenhuodongService.updateById(jianshenhuodong);
        return R.ok();
    }

    /**
     * 删除
     */
    @RemoteCacheEvict(key = "'jianshenhuodong:*'")
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jianshenhuodongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 提醒接口
     */
    @RequestMapping("/remind/{columnName}/{type}")
    public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request,
                         @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
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

        Wrapper<JianshenhuodongEntity> wrapper = new EntityWrapper<>();
        if(map.get("remindstart") != null) {
            wrapper.ge(columnName, map.get("remindstart"));
        }
        if(map.get("remindend") != null) {
            wrapper.le(columnName, map.get("remindend"));
        }

        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("huiyuan")) {
            wrapper.eq("huiyuanzhanghao", (String)request.getSession().getAttribute("username"));
        }

        int count = jianshenhuodongService.selectCount(wrapper);
        return R.ok().put("count", count);
    }
}
