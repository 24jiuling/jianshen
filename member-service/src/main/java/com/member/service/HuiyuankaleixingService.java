package com.member.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

import com.common.entity.HuiyuankaleixingEntity;
import com.common.entity.view.HuiyuankaleixingView;
import com.common.entity.vo.HuiyuankaleixingVO;
import com.common.utils.PageUtils;
import org.apache.ibatis.annotations.Param;


/**
 * 会员卡类型
 *
 * @author
 * @email
 * @date 2021-05-12 00:06:36
 */
public interface HuiyuankaleixingService extends IService<HuiyuankaleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);

   	List<HuiyuankaleixingVO> selectListVO(Wrapper<HuiyuankaleixingEntity> wrapper);

   	HuiyuankaleixingVO selectVO(@Param("ew") Wrapper<HuiyuankaleixingEntity> wrapper);

   	List<HuiyuankaleixingView> selectListView(Wrapper<HuiyuankaleixingEntity> wrapper);

   	HuiyuankaleixingView selectView(@Param("ew") Wrapper<HuiyuankaleixingEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuiyuankaleixingEntity> wrapper);

}

