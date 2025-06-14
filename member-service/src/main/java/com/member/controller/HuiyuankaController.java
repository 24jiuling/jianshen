package com.member.controller;

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
import com.common.entity.HuiyuankaEntity;
import com.common.entity.view.HuiyuankaView;
import com.common.utils.MPUtil;
import com.common.utils.PageUtils;
import com.member.service.HuiyuankaService;
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
 * 会员卡
 * 后端接口
 * @author
 * @email
 * @date 2021-05-12 00:06:36
 */
@RestController
@RequestMapping("/huiyuanka")
public class HuiyuankaController {
    @Autowired
    private HuiyuankaService huiyuankaService;



    /**
     * 后端列表
     */
    @RemoteCacheable(key = "'huiyuanka:page:' + #huiyuanka.hashCode()")
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HuiyuankaEntity huiyuanka,
                  HttpServletRequest request){
//		String tableName = request.getSession().getAttribute("tableName").toString();
//		if(tableName.equals("huiyuan")) {
//			huiyuanka.setHuiyuanzhanghao((String)request.getSession().getAttribute("username"));
//		}
        huiyuanka.setHuiyuanzhanghao((String)request.getSession().getAttribute("username"));
        EntityWrapper<HuiyuankaEntity> ew = new EntityWrapper<HuiyuankaEntity>();
		PageUtils page = huiyuankaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huiyuanka), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
    @RemoteCacheable(key = "'huiyuanka:list:' + #huiyuanka.hashCode()")
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuiyuankaEntity huiyuanka,
		HttpServletRequest request){
        EntityWrapper<HuiyuankaEntity> ew = new EntityWrapper<HuiyuankaEntity>();
		PageUtils page = huiyuankaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huiyuanka), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RemoteCacheable(key = "'huiyuanka:lists:' + #huiyuanka.hashCode()")
    @RequestMapping("/lists")
    public R list( HuiyuankaEntity huiyuanka){
       	EntityWrapper<HuiyuankaEntity> ew = new EntityWrapper<HuiyuankaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huiyuanka, "huiyuanka"));
        return R.ok().put("data", huiyuankaService.selectListView(ew));
    }

	 /**
     * 查询
     */
     @RemoteCacheable(key = "'huiyuanka:query:' + #huiyuanka.hashCode()")
    @RequestMapping("/query")
    public R query(HuiyuankaEntity huiyuanka){
        EntityWrapper< HuiyuankaEntity> ew = new EntityWrapper< HuiyuankaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huiyuanka, "huiyuanka"));
		HuiyuankaView huiyuankaView =  huiyuankaService.selectView(ew);
		return R.ok("查询会员卡成功").put("data", huiyuankaView);
    }

    /**
     * 后端详情
     */
    @RemoteCacheable(key = "'huiyuanka:info:' + #id")
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuiyuankaEntity huiyuanka = huiyuankaService.selectById(id);
        return R.ok().put("data", huiyuanka);
    }

    /**
     * 前端详情
     */
    @RemoteCacheable(key = "'huiyuanka:detail:' + #id")
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuiyuankaEntity huiyuanka = huiyuankaService.selectById(id);
        return R.ok().put("data", huiyuanka);
    }




    /**
     * 后端保存
     */
    @RemoteCacheEvict(key = "'huiyuanka:*'")
    @RequestMapping("/save")
    public R save(@RequestBody HuiyuankaEntity huiyuanka, HttpServletRequest request){
    	huiyuanka.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huiyuanka);
        huiyuankaService.insert(huiyuanka);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RemoteCacheEvict(key = "'huiyuanka:*'")
    @RequestMapping("/add")
    public R add(@RequestBody HuiyuankaEntity huiyuanka, HttpServletRequest request){
    	huiyuanka.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huiyuanka);
        huiyuankaService.insert(huiyuanka);
        return R.ok();
    }

    /**
     * 修改
     */
    @RemoteCacheEvict(key = "'huiyuanka:*'")
    @RequestMapping("/update")
    public R update(@RequestBody HuiyuankaEntity huiyuanka, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huiyuanka);
        huiyuankaService.updateById(huiyuanka);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RemoteCacheEvict(key = "'huiyuanka:*'")
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huiyuankaService.deleteBatchIds(Arrays.asList(ids));
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

		Wrapper<HuiyuankaEntity> wrapper = new EntityWrapper<HuiyuankaEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("huiyuan")) {
			wrapper.eq("huiyuanzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = huiyuankaService.selectCount(wrapper);
		return R.ok().put("count", count);
	}



}
