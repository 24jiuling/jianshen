package com.common.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import com.common.entity.HuiyuankaleixingEntity;
import com.common.entity.view.HuiyuankaleixingView;
import com.common.entity.vo.HuiyuankaleixingVO;
import org.apache.ibatis.annotations.Param;




/**
 * 会员卡类型
 *
 * @author
 * @email
 * @date 2021-05-12 00:06:36
 */
public interface HuiyuankaleixingDao extends BaseMapper<HuiyuankaleixingEntity> {

	List<HuiyuankaleixingVO> selectListVO(@Param("ew") Wrapper<HuiyuankaleixingEntity> wrapper);

	HuiyuankaleixingVO selectVO(@Param("ew") Wrapper<HuiyuankaleixingEntity> wrapper);

	List<HuiyuankaleixingView> selectListView(@Param("ew") Wrapper<HuiyuankaleixingEntity> wrapper);

	List<HuiyuankaleixingView> selectListView(Pagination page,@Param("ew") Wrapper<HuiyuankaleixingEntity> wrapper);

	HuiyuankaleixingView selectView(@Param("ew") Wrapper<HuiyuankaleixingEntity> wrapper);

}
