
package com.user.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.common.dao.UserDao;
import com.common.entity.UserEntity;
import com.common.utils.PageUtils;
import com.common.utils.Query;

import com.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 系统用户
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<UserEntity> page = this.selectPage(
                new Query<UserEntity>(params).getPage(),
                new EntityWrapper<UserEntity>()
        );
        return new PageUtils(page);
	}

	@Override
	public List<UserEntity> selectListView(Wrapper<UserEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params,
			Wrapper<UserEntity> wrapper) {
		 Page<UserEntity> page =new Query<UserEntity>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
	}
}
