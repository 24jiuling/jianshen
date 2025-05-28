package com.strength.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

import com.common.entity.ZhidaoxiangmuEntity;
import com.common.entity.view.ZhidaoxiangmuView;
import com.common.entity.vo.ZhidaoxiangmuVO;
import com.common.utils.PageUtils;

import org.apache.ibatis.annotations.Param;



/**
 * 指导项目
 *
 * @author
 * @email
 * @date 2021-05-12 00:06:36
 */
public interface ZhidaoxiangmuService extends IService<ZhidaoxiangmuEntity> {

    PageUtils queryPage(Map<String, Object> params);

   	List<ZhidaoxiangmuVO> selectListVO(Wrapper<ZhidaoxiangmuEntity> wrapper);

   	ZhidaoxiangmuVO selectVO(@Param("ew") Wrapper<ZhidaoxiangmuEntity> wrapper);

   	List<ZhidaoxiangmuView> selectListView(Wrapper<ZhidaoxiangmuEntity> wrapper);

   	ZhidaoxiangmuView selectView(@Param("ew") Wrapper<ZhidaoxiangmuEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhidaoxiangmuEntity> wrapper);

}

