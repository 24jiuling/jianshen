package com.member.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.common.entity.HuiyuankaEntity;
import com.common.entity.view.HuiyuankaView;
import com.common.entity.vo.HuiyuankaVO;
import com.common.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;



/**
 * 会员卡
 *
 * @author
 * @email
 * @date 2021-05-12 00:06:36
 */
public interface HuiyuankaService extends IService<HuiyuankaEntity> {

    PageUtils queryPage(Map<String, Object> params);

   	List<HuiyuankaVO> selectListVO(Wrapper<HuiyuankaEntity> wrapper);

   	HuiyuankaVO selectVO(@Param("ew") Wrapper<HuiyuankaEntity> wrapper);

   	List<HuiyuankaView> selectListView(Wrapper<HuiyuankaEntity> wrapper);

   	HuiyuankaView selectView(@Param("ew") Wrapper<HuiyuankaEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuiyuankaEntity> wrapper);

}

