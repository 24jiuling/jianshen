package com.file.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.common.entity.JiepinEntity;
import com.common.entity.view.JiepinView;
import com.common.entity.vo.JiepinVO;
import com.common.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 解聘
 *
 * @author
 * @email
 * @date 2021-05-12 00:06:36
 */
public interface JiepinService extends IService<JiepinEntity> {

    PageUtils queryPage(Map<String, Object> params);

   	List<JiepinVO> selectListVO(Wrapper<JiepinEntity> wrapper);

   	JiepinVO selectVO(@Param("ew") Wrapper<JiepinEntity> wrapper);

   	List<JiepinView> selectListView(Wrapper<JiepinEntity> wrapper);

   	JiepinView selectView(@Param("ew") Wrapper<JiepinEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiepinEntity> wrapper);

}

