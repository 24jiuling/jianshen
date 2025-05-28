package com.strength.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

import com.common.entity.JianshenhuodongEntity;
import com.common.entity.view.JianshenhuodongView;
import com.common.entity.vo.JianshenhuodongVO;
import com.common.utils.PageUtils;

import org.apache.ibatis.annotations.Param;


/**
 * 健身活动
 *
 * @author
 * @email
 * @date 2021-05-12 00:06:36
 */
public interface JianshenhuodongService extends IService<JianshenhuodongEntity> {

    PageUtils queryPage(Map<String, Object> params);

   	List<JianshenhuodongVO> selectListVO(Wrapper<JianshenhuodongEntity> wrapper);

   	JianshenhuodongVO selectVO(@Param("ew") Wrapper<JianshenhuodongEntity> wrapper);

   	List<JianshenhuodongView> selectListView(Wrapper<JianshenhuodongEntity> wrapper);

   	JianshenhuodongView selectView(@Param("ew") Wrapper<JianshenhuodongEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params,Wrapper<JianshenhuodongEntity> wrapper);

}

