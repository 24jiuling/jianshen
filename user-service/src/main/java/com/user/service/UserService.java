
package com.user.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.common.entity.UserEntity;
import com.common.utils.PageUtils;



/**
 * 系统用户
 */
public interface UserService extends IService<UserEntity> {
 	PageUtils queryPage(Map<String, Object> params);

   	List<UserEntity> selectListView(Wrapper<UserEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params,Wrapper<UserEntity> wrapper);

}
