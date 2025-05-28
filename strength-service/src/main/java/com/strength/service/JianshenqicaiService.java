package com.strength.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

import com.common.entity.JianshenqicaiEntity;
import com.common.entity.view.JianshenqicaiView;
import com.common.entity.vo.JianshenqicaiVO;
import com.common.utils.PageUtils;
import org.apache.ibatis.annotations.Param;



/**
 * 健身器材
 *
 * @author
 * @email
 * @date 2021-05-12 00:06:36
 */
public interface JianshenqicaiService extends IService<JianshenqicaiEntity> {

    PageUtils queryPage(Map<String, Object> params);

   	List<JianshenqicaiVO> selectListVO(Wrapper<JianshenqicaiEntity> wrapper);

   	JianshenqicaiVO selectVO(@Param("ew") Wrapper<JianshenqicaiEntity> wrapper);

   	List<JianshenqicaiView> selectListView(Wrapper<JianshenqicaiEntity> wrapper);

   	JianshenqicaiView selectView(@Param("ew") Wrapper<JianshenqicaiEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params,Wrapper<JianshenqicaiEntity> wrapper);

}

