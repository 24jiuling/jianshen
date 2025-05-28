package com.strength.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

import com.common.entity.JianshenxiangmuEntity;
import com.common.entity.view.JianshenxiangmuView;
import com.common.entity.vo.JianshenxiangmuVO;
import com.common.utils.PageUtils;
import org.apache.ibatis.annotations.Param;



/**
 * 健身项目
 *
 * @author
 * @email
 * @date 2021-05-12 00:06:36
 */
public interface JianshenxiangmuService extends IService<JianshenxiangmuEntity> {

    PageUtils queryPage(Map<String, Object> params);

   	List<JianshenxiangmuVO> selectListVO(Wrapper<JianshenxiangmuEntity> wrapper);

   	JianshenxiangmuVO selectVO(@Param("ew") Wrapper<JianshenxiangmuEntity> wrapper);

   	List<JianshenxiangmuView> selectListView(Wrapper<JianshenxiangmuEntity> wrapper);

   	JianshenxiangmuView selectView(@Param("ew") Wrapper<JianshenxiangmuEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params,Wrapper<JianshenxiangmuEntity> wrapper);

}

