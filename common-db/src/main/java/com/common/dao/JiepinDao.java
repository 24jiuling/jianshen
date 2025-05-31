package com.common.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import com.common.entity.JiepinEntity;
import com.common.entity.view.JiepinView;
import com.common.entity.vo.JiepinVO;
import org.apache.ibatis.annotations.Param;



/**
 * 解聘
 *
 * @author
 * @email
 * @date 2021-05-12 00:06:36
 */
public interface JiepinDao extends BaseMapper<JiepinEntity> {

	List<JiepinVO> selectListVO(@Param("ew") Wrapper<JiepinEntity> wrapper);

	JiepinVO selectVO(@Param("ew") Wrapper<JiepinEntity> wrapper);

	List<JiepinView> selectListView(@Param("ew") Wrapper<JiepinEntity> wrapper);

	List<JiepinView> selectListView(Pagination page,@Param("ew") Wrapper<JiepinEntity> wrapper);

	JiepinView selectView(@Param("ew") Wrapper<JiepinEntity> wrapper);

}
