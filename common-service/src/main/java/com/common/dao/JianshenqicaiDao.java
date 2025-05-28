package com.common.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import com.common.entity.JianshenqicaiEntity;
import com.common.entity.view.JianshenqicaiView;
import com.common.entity.vo.JianshenqicaiVO;
import org.apache.ibatis.annotations.Param;



/**
 * 健身器材
 *
 * @author
 * @email
 * @date 2021-05-12 00:06:36
 */
public interface JianshenqicaiDao extends BaseMapper<JianshenqicaiEntity> {

	List<JianshenqicaiVO> selectListVO(@Param("ew") Wrapper<JianshenqicaiEntity> wrapper);

	JianshenqicaiVO selectVO(@Param("ew") Wrapper<JianshenqicaiEntity> wrapper);

	List<JianshenqicaiView> selectListView(@Param("ew") Wrapper<JianshenqicaiEntity> wrapper);

	List<JianshenqicaiView> selectListView(Pagination page,@Param("ew") Wrapper<JianshenqicaiEntity> wrapper);

	JianshenqicaiView selectView(@Param("ew") Wrapper<JianshenqicaiEntity> wrapper);

}
