package com.user.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.common.entity.JiaolianxinxiEntity;
import com.common.entity.view.JiaolianxinxiView;
import com.common.entity.vo.JiaolianxinxiVO;

import java.util.List;
import java.util.Map;

import com.common.utils.PageUtils;
import org.apache.ibatis.annotations.Param;



/**
 * 教练信息
 *
 * @author
 * @email
 * @date 2021-05-12 00:06:36
 */
public interface JiaolianxinxiService extends IService<JiaolianxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);

   	List<JiaolianxinxiVO> selectListVO(Wrapper<JiaolianxinxiEntity> wrapper);

   	JiaolianxinxiVO selectVO(@Param("ew") Wrapper<JiaolianxinxiEntity> wrapper);

   	List<JiaolianxinxiView> selectListView(Wrapper<JiaolianxinxiEntity> wrapper);

   	JiaolianxinxiView selectView(@Param("ew") Wrapper<JiaolianxinxiEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiaolianxinxiEntity> wrapper);

}

