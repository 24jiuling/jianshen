package com.member.controller;

import com.api.annotation.RemoteCacheEvict;
import com.api.annotation.RemoteCacheable;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.common.annotation.IgnoreAuth;
import com.common.core.utils.R;
import com.common.entity.HuiyuanEntity;
import com.common.entity.view.HuiyuanView;
import com.common.utils.MPUtil;
import com.common.utils.PageUtils;
import com.member.service.HuiyuanService;
import com.user.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;


/**
 * 会员
 * 后端接口
 * @author
 * @email
 * @date 2021-05-12 00:06:36
 */
@ComponentScan(basePackages = {"com.user.service"})
@RestController
@RequestMapping("/huiyuan")
public class HuiyuanController {
    @Autowired
    private HuiyuanService huiyuanService;

	@Autowired
	private TokenService tokenService;

	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		HuiyuanEntity user = huiyuanService.selectOne(new EntityWrapper<HuiyuanEntity>().eq("huiyuanzhanghao", username));
		if(user==null || !user.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}

		String token = tokenService.generateToken(user.getId(), username,"huiyuan",  "会员" );
		return R.ok().put("token", token);
	}

	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody HuiyuanEntity huiyuan){
    	//ValidatorUtils.validateEntity(huiyuan);
    	HuiyuanEntity user = huiyuanService.selectOne(new EntityWrapper<HuiyuanEntity>().eq("huiyuanzhanghao", huiyuan.getHuiyuanzhanghao()));
		if(user!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		huiyuan.setId(uId);
        huiyuanService.insert(huiyuan);
        return R.ok();
    }

	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}

	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        HuiyuanEntity user = huiyuanService.selectById(id);
        return R.ok().put("data", user);
    }

    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	HuiyuanEntity user = huiyuanService.selectOne(new EntityWrapper<HuiyuanEntity>().eq("huiyuanzhanghao", username));
    	if(user==null) {
    		return R.error("账号不存在");
    	}
        user.setMima("123456");
        huiyuanService.updateById(user);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
	@RemoteCacheable(key = "'huiyuan:page:' + #huiyuan.hashCode()")
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HuiyuanEntity huiyuan,
				  HttpServletRequest request){
//		String tableName = request.getSession().getAttribute("tableName").toString();
//		if(tableName.equals("huiyuan")) {
//			huiyuan.setHuiyuanzhanghao((String)request.getSession().getAttribute("username"));
//		}
		huiyuan.setHuiyuanzhanghao((String)request.getSession().getAttribute("username"));
        EntityWrapper<HuiyuanEntity> ew = new EntityWrapper<HuiyuanEntity>();
		PageUtils page = huiyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huiyuan), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
	@RemoteCacheable(key = "'huiyuan:list:' + #huiyuan.hashCode()")
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuiyuanEntity huiyuan,
		HttpServletRequest request){
        EntityWrapper<HuiyuanEntity> ew = new EntityWrapper<HuiyuanEntity>();
		PageUtils page = huiyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huiyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
	@RemoteCacheable(key = "'huiyuan:lists:' + #huiyuan.hashCode()")
    @RequestMapping("/lists")
    public R list( HuiyuanEntity huiyuan){
       	EntityWrapper<HuiyuanEntity> ew = new EntityWrapper<HuiyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huiyuan, "huiyuan"));
        return R.ok().put("data", huiyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
	 @RemoteCacheable(key = "'huiyuan:query:' + #huiyuan.hashCode()")
    @RequestMapping("/query")
    public R query(HuiyuanEntity huiyuan){
        EntityWrapper< HuiyuanEntity> ew = new EntityWrapper< HuiyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huiyuan, "huiyuan"));
		HuiyuanView huiyuanView =  huiyuanService.selectView(ew);
		return R.ok("查询会员成功").put("data", huiyuanView);
    }

    /**
     * 后端详情
     */
	@RemoteCacheable(key = "'huiyuan:info:' + #id")
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuiyuanEntity huiyuan = huiyuanService.selectById(id);
        return R.ok().put("data", huiyuan);
    }

    /**
     * 前端详情
     */
	@RemoteCacheable(key = "'huiyuan:detail:' + #id")
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuiyuanEntity huiyuan = huiyuanService.selectById(id);
        return R.ok().put("data", huiyuan);
    }




    /**
     * 后端保存
     */
	@RemoteCacheEvict(key = "'huiyuan:*'")
    @RequestMapping("/save")
    public R save(@RequestBody HuiyuanEntity huiyuan, HttpServletRequest request){
    	huiyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huiyuan);
    	HuiyuanEntity user = huiyuanService.selectOne(new EntityWrapper<HuiyuanEntity>().eq("huiyuanzhanghao", huiyuan.getHuiyuanzhanghao()));
		if(user!=null) {
			return R.error("用户已存在");
		}
		huiyuan.setId(new Date().getTime());
        huiyuanService.insert(huiyuan);
        return R.ok();
    }

    /**
     * 前端保存
     */
	@RemoteCacheEvict(key = "'huiyuan:*'")
    @RequestMapping("/add")
    public R add(@RequestBody HuiyuanEntity huiyuan, HttpServletRequest request){
    	huiyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huiyuan);
    	HuiyuanEntity user = huiyuanService.selectOne(new EntityWrapper<HuiyuanEntity>().eq("huiyuanzhanghao", huiyuan.getHuiyuanzhanghao()));
		if(user!=null) {
			return R.error("用户已存在");
		}
		huiyuan.setId(new Date().getTime());
        huiyuanService.insert(huiyuan);
        return R.ok();
    }

    /**
     * 修改
     */
	@RemoteCacheEvict(key = "'huiyuan:*'")
    @RequestMapping("/update")
    public R update(@RequestBody HuiyuanEntity huiyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huiyuan);
        huiyuanService.updateById(huiyuan);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
	@RemoteCacheEvict(key = "'huiyuan:*'")
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huiyuanService.deleteBatchIds(Arrays.asList(ids));
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

		Wrapper<HuiyuanEntity> wrapper = new EntityWrapper<HuiyuanEntity>();
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

		int count = huiyuanService.selectCount(wrapper);
		return R.ok().put("count", count);
	}



}
