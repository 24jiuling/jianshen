package com.common.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import com.common.entity.YuangongEntity;
import com.common.entity.view.YuangongView;
import com.common.entity.vo.YuangongVO;
import org.apache.ibatis.annotations.Param;



/**
 * 员工
 *
 * @author
 * @email
 * @date 2021-05-12 00:06:36
 */
public interface YuangongDao extends BaseMapper<YuangongEntity> {

	List<YuangongVO> selectListVO(@Param("ew") Wrapper<YuangongEntity> wrapper);

	YuangongVO selectVO(@Param("ew") Wrapper<YuangongEntity> wrapper);

	List<YuangongView> selectListView(@Param("ew") Wrapper<YuangongEntity> wrapper);

	List<YuangongView> selectListView(Pagination page,@Param("ew") Wrapper<YuangongEntity> wrapper);

	YuangongView selectView(@Param("ew") Wrapper<YuangongEntity> wrapper);

}
