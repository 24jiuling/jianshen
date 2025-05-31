package com.common.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import com.common.entity.JiaolianxinxiEntity;
import com.common.entity.view.JiaolianxinxiView;
import com.common.entity.vo.JiaolianxinxiVO;
import org.apache.ibatis.annotations.Param;



/**
 * 教练信息
 *
 * @author
 * @email
 * @date 2021-05-12 00:06:36
 */
public interface JiaolianxinxiDao extends BaseMapper<JiaolianxinxiEntity> {

	List<JiaolianxinxiVO> selectListVO(@Param("ew") Wrapper<JiaolianxinxiEntity> wrapper);

	JiaolianxinxiVO selectVO(@Param("ew") Wrapper<JiaolianxinxiEntity> wrapper);

	List<JiaolianxinxiView> selectListView(@Param("ew") Wrapper<JiaolianxinxiEntity> wrapper);

	List<JiaolianxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<JiaolianxinxiEntity> wrapper);

	JiaolianxinxiView selectView(@Param("ew") Wrapper<JiaolianxinxiEntity> wrapper);

}
