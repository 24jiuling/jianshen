package com.user.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;


import com.api.annotation.RemoteCacheEvict;
import com.api.annotation.RemoteCacheable;
import com.common.core.utils.R;
import com.common.entity.JiaolianxinxiEntity;
import com.common.entity.view.JiaolianxinxiView;
import com.common.utils.MPUtil;
import com.common.utils.PageUtils;

import com.user.service.JiaolianxinxiService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;



/**
 * 教练信息
 * 后端接口
 * @author
 * @email
 * @date 2021-05-12 00:06:36
 */
@RestController
@RequestMapping("/jiaolianxinxi")
public class JiaolianxinxiController {
    @Autowired
    private JiaolianxinxiService jiaolianxinxiService;

    /**
     * 后端列表
     */
    @RemoteCacheable(key = "'jiaolianxinxi:page:' + #jiaolianxinxi.hashCode()")
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, JiaolianxinxiEntity jiaolianxinxi,
                  HttpServletRequest request){
        EntityWrapper<JiaolianxinxiEntity> ew = new EntityWrapper<JiaolianxinxiEntity>();
		PageUtils page = jiaolianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaolianxinxi), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
    @RemoteCacheable(key = "'jiaolianxinxi:list:' + #jiaolianxinxi.hashCode()")
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiaolianxinxiEntity jiaolianxinxi,
		HttpServletRequest request){
        EntityWrapper<JiaolianxinxiEntity> ew = new EntityWrapper<JiaolianxinxiEntity>();
		PageUtils page = jiaolianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaolianxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RemoteCacheable(key = "'jiaolianxinxi:lists:' + #jiaolianxinxi.hashCode()")
    @RequestMapping("/lists")
    public R list( JiaolianxinxiEntity jiaolianxinxi){
       	EntityWrapper<JiaolianxinxiEntity> ew = new EntityWrapper<JiaolianxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiaolianxinxi, "jiaolianxinxi"));
        return R.ok().put("data", jiaolianxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
     @RemoteCacheable(key = "'jiaolianxinxi:query:' + #jiaolianxinxi.hashCode()")
    @RequestMapping("/query")
    public R query(JiaolianxinxiEntity jiaolianxinxi){
        EntityWrapper< JiaolianxinxiEntity> ew = new EntityWrapper< JiaolianxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiaolianxinxi, "jiaolianxinxi"));
		JiaolianxinxiView jiaolianxinxiView =  jiaolianxinxiService.selectView(ew);
		return R.ok("查询教练信息成功").put("data", jiaolianxinxiView);
    }

    /**
     * 后端详情
     */
    @RemoteCacheable(key = "'jiaolianxinxi:info:' + #id")
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiaolianxinxiEntity jiaolianxinxi = jiaolianxinxiService.selectById(id);
        return R.ok().put("data", jiaolianxinxi);
    }

    /**
     * 前端详情
     */
    @RemoteCacheable(key = "'jiaolianxinxi:detail:' + #id")
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiaolianxinxiEntity jiaolianxinxi = jiaolianxinxiService.selectById(id);
        return R.ok().put("data", jiaolianxinxi);
    }




    /**
     * 后端保存
     */
    @RemoteCacheEvict(key = "'jiaolianxinxi:*'")
    @RequestMapping("/save")
    public R save(@RequestBody JiaolianxinxiEntity jiaolianxinxi, HttpServletRequest request){
    	jiaolianxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaolianxinxi);
        jiaolianxinxiService.insert(jiaolianxinxi);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RemoteCacheEvict(key = "'jiaolianxinxi:*'")
    @RequestMapping("/add")
    public R add(@RequestBody JiaolianxinxiEntity jiaolianxinxi, HttpServletRequest request){
    	jiaolianxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaolianxinxi);
        jiaolianxinxiService.insert(jiaolianxinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RemoteCacheEvict(key = "'jiaolianxinxi:*'")
    @RequestMapping("/update")
    public R update(@RequestBody JiaolianxinxiEntity jiaolianxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiaolianxinxi);
        jiaolianxinxiService.updateById(jiaolianxinxi);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RemoteCacheEvict(key = "'jiaolianxinxi:*'")
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiaolianxinxiService.deleteBatchIds(Arrays.asList(ids));
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
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}

		Wrapper<JiaolianxinxiEntity> wrapper = new EntityWrapper<JiaolianxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = jiaolianxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}



}
