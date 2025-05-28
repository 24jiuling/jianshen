package com.common.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import com.common.entity.ZhidaoxiangmuEntity;
import com.common.entity.view.ZhidaoxiangmuView;
import com.common.entity.vo.ZhidaoxiangmuVO;
import org.apache.ibatis.annotations.Param;



/**
 * 指导项目
 *
 * @author
 * @email
 * @date 2021-05-12 00:06:36
 */
public interface ZhidaoxiangmuDao extends BaseMapper<ZhidaoxiangmuEntity> {

	List<ZhidaoxiangmuVO> selectListVO(@Param("ew") Wrapper<ZhidaoxiangmuEntity> wrapper);

	ZhidaoxiangmuVO selectVO(@Param("ew") Wrapper<ZhidaoxiangmuEntity> wrapper);

	List<ZhidaoxiangmuView> selectListView(@Param("ew") Wrapper<ZhidaoxiangmuEntity> wrapper);

	List<ZhidaoxiangmuView> selectListView(Pagination page,@Param("ew") Wrapper<ZhidaoxiangmuEntity> wrapper);

	ZhidaoxiangmuView selectView(@Param("ew") Wrapper<ZhidaoxiangmuEntity> wrapper);

}
