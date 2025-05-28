package com.user.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.common.entity.YuangongEntity;
import com.common.entity.view.YuangongView;
import com.common.entity.vo.YuangongVO;

import java.util.List;
import java.util.Map;

import com.common.utils.PageUtils;
import org.apache.ibatis.annotations.Param;



/**
 * 员工
 *
 * @author
 * @email
 * @date 2021-05-12 00:06:36
 */
public interface YuangongService extends IService<YuangongEntity> {

    PageUtils queryPage(Map<String, Object> params);

   	List<YuangongVO> selectListVO(Wrapper<YuangongEntity> wrapper);

   	YuangongVO selectVO(@Param("ew") Wrapper<YuangongEntity> wrapper);

   	List<YuangongView> selectListView(Wrapper<YuangongEntity> wrapper);

   	YuangongView selectView(@Param("ew") Wrapper<YuangongEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuangongEntity> wrapper);

}

