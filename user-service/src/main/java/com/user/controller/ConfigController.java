
package com.user.controller;


import java.util.Arrays;
import java.util.Map;


import com.api.annotation.RemoteCacheEvict;
import com.api.annotation.RemoteCacheable;
import com.common.annotation.IgnoreAuth;
import com.common.core.utils.R;
import com.common.entity.ConfigEntity;
import com.common.utils.PageUtils;


import com.user.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.baomidou.mybatisplus.mapper.EntityWrapper;


/**
 * 登录相关
 */
@ComponentScan(basePackages = {"com.common.dao", "com.common.service"})
@RequestMapping("config")
@RestController
public class ConfigController{

	@Autowired
	private ConfigService configService;

	/**
     * 列表
     */
    @RemoteCacheable(key = "'config:page:' + #params.hashCode()")
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ConfigEntity config){
        EntityWrapper<ConfigEntity> ew = new EntityWrapper<ConfigEntity>();
    	PageUtils page = configService.queryPage(params);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RemoteCacheable(key = "'config:list:' + #params.hashCode()")
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ConfigEntity config){
        EntityWrapper<ConfigEntity> ew = new EntityWrapper<ConfigEntity>();
    	PageUtils page = configService.queryPage(params);
        return R.ok().put("data", page);
    }

    /**
     * 信息
     */
    @RemoteCacheable(key = "'config:info:' + #id")
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        ConfigEntity config = configService.selectById(id);
        return R.ok().put("data", config);
    }

    /**
     * 详情
     */
     @RemoteCacheable(key = "'config:detail:' + #id")
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        ConfigEntity config = configService.selectById(id);
        return R.ok().put("data", config);
    }

    /**
     * 根据name获取信息
     */
    @RemoteCacheable(key = "'config:info:' + #params.hashCode()")
    @RequestMapping("/info")
    public R infoByName(@RequestParam String name){
        ConfigEntity config = configService.selectOne(new EntityWrapper<ConfigEntity>().eq("name", "faceFile"));
        return R.ok().put("data", config);
    }

    /**
     * 保存
     */
    @RemoteCacheEvict(key = "'config:*'")
    @PostMapping("/save")
    public R save(@RequestBody ConfigEntity config){
//    	ValidatorUtils.validateEntity(config);
    	configService.insert(config);
        return R.ok();
    }

    /**
     * 修改
     */
    @RemoteCacheEvict(key = "'config:*'")
    @RequestMapping("/update")
    public R update(@RequestBody ConfigEntity config){
//        ValidatorUtils.validateEntity(config);
        configService.updateById(config);//全部更新
        return R.ok();
    }

    /**
     * 删除
     */
    @RemoteCacheEvict(key = "'config:*'")
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
    	configService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}
