
package com.user.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.common.entity.ConfigEntity;
import com.common.utils.PageUtils;



/**
 * 系统用户
 */
public interface ConfigService extends IService<ConfigEntity> {
	PageUtils queryPage(Map<String, Object> params);
}
