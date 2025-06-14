package com.strength.service.ipml;

import com.common.dao.JianshenxiangmuDao;
import com.common.entity.JianshenxiangmuEntity;
import com.common.entity.view.JianshenxiangmuView;
import com.common.entity.vo.JianshenxiangmuVO;
import com.common.utils.PageUtils;
import com.common.utils.Query;
import com.strength.service.JianshenxiangmuService;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("jianshenxiangmuService")
public class JianshenxiangmuServiceImpl extends ServiceImpl<JianshenxiangmuDao, JianshenxiangmuEntity> implements JianshenxiangmuService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JianshenxiangmuEntity> page = this.selectPage(
                new Query<JianshenxiangmuEntity>(params).getPage(),
                new EntityWrapper<JianshenxiangmuEntity>()
        );
        return new PageUtils(page);
    }

    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JianshenxiangmuEntity> wrapper) {
		  Page<JianshenxiangmuView> page =new Query<JianshenxiangmuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    @Override
	public List<JianshenxiangmuVO> selectListVO(Wrapper<JianshenxiangmuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}

	@Override
	public JianshenxiangmuVO selectVO(Wrapper<JianshenxiangmuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}

	@Override
	public List<JianshenxiangmuView> selectListView(Wrapper<JianshenxiangmuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JianshenxiangmuView selectView(Wrapper<JianshenxiangmuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
