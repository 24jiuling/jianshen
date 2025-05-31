package com.common.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import com.common.entity.HuiyuankaEntity;
import com.common.entity.view.HuiyuankaView;
import com.common.entity.vo.HuiyuankaVO;
import org.apache.ibatis.annotations.Param;



/**
 * 会员卡
 *
 * @author
 * @email
 * @date 2021-05-12 00:06:36
 */
public interface HuiyuankaDao extends BaseMapper<HuiyuankaEntity> {

	List<HuiyuankaVO> selectListVO(@Param("ew") Wrapper<HuiyuankaEntity> wrapper);

	HuiyuankaVO selectVO(@Param("ew") Wrapper<HuiyuankaEntity> wrapper);

	List<HuiyuankaView> selectListView(@Param("ew") Wrapper<HuiyuankaEntity> wrapper);

	List<HuiyuankaView> selectListView(Pagination page,@Param("ew") Wrapper<HuiyuankaEntity> wrapper);

	HuiyuankaView selectView(@Param("ew") Wrapper<HuiyuankaEntity> wrapper);

}
