package com.file.controller;

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
import com.common.entity.JiepinEntity;
import com.common.entity.view.JiepinView;
import com.common.utils.MPUtil;
import com.common.utils.PageUtils;


import com.file.service.JiepinService;
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
 * 解聘
 * 后端接口
 * @author
 * @email
 * @date 2021-05-12 00:06:36
 */
@RestController
@RequestMapping("/jiepin")
public class JiepinController {
    @Autowired
    private JiepinService jiepinService;



    /**
     * 后端列表
     */
    @RemoteCacheable(key = "'jiepin:page:' + #params.hashCode()")
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, JiepinEntity jiepin,
                  HttpServletRequest request){
//		String tableName = request.getSession().getAttribute("tableName").toString();
//		if(tableName.equals("yuangong")) {
//			jiepin.setGonghao((String)request.getSession().getAttribute("username"));
//		}
        jiepin.setGonghao((String)request.getSession().getAttribute("username"));
        EntityWrapper<JiepinEntity> ew = new EntityWrapper<JiepinEntity>();
		PageUtils page = jiepinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiepin), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
    @RemoteCacheable(key = "'jiepin:list:' + #params.hashCode()")
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiepinEntity jiepin,
		HttpServletRequest request){
        EntityWrapper<JiepinEntity> ew = new EntityWrapper<JiepinEntity>();
		PageUtils page = jiepinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiepin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RemoteCacheable(key = "'jiepin:lists:' + #jiepin.hashCode()")
    @RequestMapping("/lists")
    public R list( JiepinEntity jiepin){
       	EntityWrapper<JiepinEntity> ew = new EntityWrapper<JiepinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiepin, "jiepin"));
        return R.ok().put("data", jiepinService.selectListView(ew));
    }

	 /**
     * 查询
     */
     @RemoteCacheable(key = "'jiepin:query:' + #jiepin.hashCode()")
    @RequestMapping("/query")
    public R query(JiepinEntity jiepin){
        EntityWrapper< JiepinEntity> ew = new EntityWrapper< JiepinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiepin, "jiepin"));
		JiepinView jiepinView =  jiepinService.selectView(ew);
		return R.ok("查询解聘成功").put("data", jiepinView);
    }

    /**
     * 后端详情
     */
    @RemoteCacheable(key = "'jiepin:info:' + #id")
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiepinEntity jiepin = jiepinService.selectById(id);
        return R.ok().put("data", jiepin);
    }

    /**
     * 前端详情
     */
     @RemoteCacheable(key = "'jiepin:detail:' + #id")
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiepinEntity jiepin = jiepinService.selectById(id);
        return R.ok().put("data", jiepin);
    }




    /**
     * 后端保存
     */
    @RemoteCacheEvict(key = "'jiepin:*'")
    @RequestMapping("/save")
    public R save(@RequestBody JiepinEntity jiepin, HttpServletRequest request){
    	jiepin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiepin);
        jiepinService.insert(jiepin);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RemoteCacheEvict(key = "'jiepin:*'")
    @RequestMapping("/add")
    public R add(@RequestBody JiepinEntity jiepin, HttpServletRequest request){
    	jiepin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiepin);
        jiepinService.insert(jiepin);
        return R.ok();
    }

    /**
     * 修改
     */
    @RemoteCacheEvict(key = "'jiepin:*'")
    @RequestMapping("/update")
    public R update(@RequestBody JiepinEntity jiepin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiepin);
        jiepinService.updateById(jiepin);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RemoteCacheEvict(key = "'jiepin:*'")
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiepinService.deleteBatchIds(Arrays.asList(ids));
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

		Wrapper<JiepinEntity> wrapper = new EntityWrapper<JiepinEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			wrapper.eq("gonghao", (String)request.getSession().getAttribute("username"));
		}

		int count = jiepinService.selectCount(wrapper);
		return R.ok().put("count", count);
	}



}
