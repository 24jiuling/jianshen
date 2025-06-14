package com.common.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import com.common.entity.HuiyuanEntity;
import com.common.entity.view.HuiyuanView;
import com.common.entity.vo.HuiyuanVO;
import org.apache.ibatis.annotations.Param;



/**
 * 会员
 *
 * @author
 * @email
 * @date 2021-05-12 00:06:36
 */
public interface HuiyuanDao extends BaseMapper<HuiyuanEntity> {

	List<HuiyuanVO> selectListVO(@Param("ew") Wrapper<HuiyuanEntity> wrapper);

	HuiyuanVO selectVO(@Param("ew") Wrapper<HuiyuanEntity> wrapper);

	List<HuiyuanView> selectListView(@Param("ew") Wrapper<HuiyuanEntity> wrapper);

	List<HuiyuanView> selectListView(Pagination page,@Param("ew") Wrapper<HuiyuanEntity> wrapper);

	HuiyuanView selectView(@Param("ew") Wrapper<HuiyuanEntity> wrapper);

}
