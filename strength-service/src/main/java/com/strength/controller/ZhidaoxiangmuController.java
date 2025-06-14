package com.strength.controller;

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
import com.common.entity.ZhidaoxiangmuEntity;
import com.common.entity.view.ZhidaoxiangmuView;
import com.common.utils.MPUtil;

import com.common.utils.PageUtils;
import com.strength.service.ZhidaoxiangmuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;



/**
 * 指导项目
 * 后端接口
 * @author
 * @email
 * @date 2021-05-12 00:06:36
 */
@RestController
@RequestMapping("/zhidaoxiangmu")
public class ZhidaoxiangmuController {
    @Autowired
    private ZhidaoxiangmuService zhidaoxiangmuService;



    /**
     * 后端列表
     */
    @RemoteCacheable(key = "'zhidaoxiangmu:page:' + #zhidaoxiangmu.hashCode()")
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ZhidaoxiangmuEntity zhidaoxiangmu,
                  HttpServletRequest request){
        EntityWrapper<ZhidaoxiangmuEntity> ew = new EntityWrapper<ZhidaoxiangmuEntity>();
		PageUtils page = zhidaoxiangmuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhidaoxiangmu), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
    @RemoteCacheable(key = "'zhidaoxiangmu:list:' + #zhidaoxiangmu.hashCode()")
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhidaoxiangmuEntity zhidaoxiangmu,
		HttpServletRequest request){
        EntityWrapper<ZhidaoxiangmuEntity> ew = new EntityWrapper<ZhidaoxiangmuEntity>();
		PageUtils page = zhidaoxiangmuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhidaoxiangmu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RemoteCacheable(key = "'zhidaoxiangmu:lists:' + #zhidaoxiangmu.hashCode()")
    @RequestMapping("/lists")
    public R list( ZhidaoxiangmuEntity zhidaoxiangmu){
       	EntityWrapper<ZhidaoxiangmuEntity> ew = new EntityWrapper<ZhidaoxiangmuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhidaoxiangmu, "zhidaoxiangmu"));
        return R.ok().put("data", zhidaoxiangmuService.selectListView(ew));
    }

	 /**
     * 查询
     */
     @RemoteCacheable(key = "'zhidaoxiangmu:query:' + #zhidaoxiangmu.hashCode()")
    @RequestMapping("/query")
    public R query(ZhidaoxiangmuEntity zhidaoxiangmu){
        EntityWrapper< ZhidaoxiangmuEntity> ew = new EntityWrapper< ZhidaoxiangmuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhidaoxiangmu, "zhidaoxiangmu"));
		ZhidaoxiangmuView zhidaoxiangmuView =  zhidaoxiangmuService.selectView(ew);
		return R.ok("查询指导项目成功").put("data", zhidaoxiangmuView);
    }

    /**
     * 后端详情
     */
    @RemoteCacheable(key = "'zhidaoxiangmu:info:' + #id")
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhidaoxiangmuEntity zhidaoxiangmu = zhidaoxiangmuService.selectById(id);
        return R.ok().put("data", zhidaoxiangmu);
    }

    /**
     * 前端详情
     */
    @RemoteCacheable(key = "'zhidaoxiangmu:detail:' + #id")
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhidaoxiangmuEntity zhidaoxiangmu = zhidaoxiangmuService.selectById(id);
        return R.ok().put("data", zhidaoxiangmu);
    }

    /**
     * 后端保存
     */
    @RemoteCacheEvict(key = "'zhidaoxiangmu:*'")
    @RequestMapping("/save")
    public R save(@RequestBody ZhidaoxiangmuEntity zhidaoxiangmu, HttpServletRequest request){
    	zhidaoxiangmu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhidaoxiangmu);
        zhidaoxiangmuService.insert(zhidaoxiangmu);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RemoteCacheEvict(key = "'zhidaoxiangmu:*'")
    @RequestMapping("/add")
    public R add(@RequestBody ZhidaoxiangmuEntity zhidaoxiangmu, HttpServletRequest request){
    	zhidaoxiangmu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhidaoxiangmu);
        zhidaoxiangmuService.insert(zhidaoxiangmu);
        return R.ok();
    }

    /**
     * 修改
     */
    @RemoteCacheEvict(key = "'zhidaoxiangmu:*'")
    @RequestMapping("/update")
    public R update(@RequestBody ZhidaoxiangmuEntity zhidaoxiangmu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhidaoxiangmu);
        zhidaoxiangmuService.updateById(zhidaoxiangmu);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RemoteCacheEvict(key = "'zhidaoxiangmu:*'")
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhidaoxiangmuService.deleteBatchIds(Arrays.asList(ids));
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

		Wrapper<ZhidaoxiangmuEntity> wrapper = new EntityWrapper<ZhidaoxiangmuEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = zhidaoxiangmuService.selectCount(wrapper);
		return R.ok().put("count", count);
	}



}
