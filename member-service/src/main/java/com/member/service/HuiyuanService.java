package com.member.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

import com.common.entity.HuiyuanEntity;
import com.common.entity.view.HuiyuanView;
import com.common.entity.vo.HuiyuanVO;
import com.common.utils.PageUtils;
import org.apache.ibatis.annotations.Param;


/**
 * 会员
 *
 * @author
 * @email
 * @date 2021-05-12 00:06:36
 */
public interface HuiyuanService extends IService<HuiyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);

   	List<HuiyuanVO> selectListVO(Wrapper<HuiyuanEntity> wrapper);

   	HuiyuanVO selectVO(@Param("ew") Wrapper<HuiyuanEntity> wrapper);

   	List<HuiyuanView> selectListView(Wrapper<HuiyuanEntity> wrapper);

   	HuiyuanView selectView(@Param("ew") Wrapper<HuiyuanEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuiyuanEntity> wrapper);

}

