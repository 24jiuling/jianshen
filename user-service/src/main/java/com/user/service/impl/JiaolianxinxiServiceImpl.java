package com.user.service.impl;

import com.common.dao.JiaolianxinxiDao;
import com.common.entity.JiaolianxinxiEntity;
import com.common.entity.view.JiaolianxinxiView;
import com.common.entity.vo.JiaolianxinxiVO;
import com.common.utils.PageUtils;
import com.common.utils.Query;
import com.user.service.JiaolianxinxiService;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("jiaolianxinxiService")
public class JiaolianxinxiServiceImpl extends ServiceImpl<JiaolianxinxiDao, JiaolianxinxiEntity> implements JiaolianxinxiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiaolianxinxiEntity> page = this.selectPage(
                new Query<JiaolianxinxiEntity>(params).getPage(),
                new EntityWrapper<JiaolianxinxiEntity>()
        );
        return new PageUtils(page);
    }

    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiaolianxinxiEntity> wrapper) {
		  Page<JiaolianxinxiView> page =new Query<JiaolianxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    @Override
	public List<JiaolianxinxiVO> selectListVO(Wrapper<JiaolianxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}

	@Override
	public JiaolianxinxiVO selectVO(Wrapper<JiaolianxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}

	@Override
	public List<JiaolianxinxiView> selectListView(Wrapper<JiaolianxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiaolianxinxiView selectView(Wrapper<JiaolianxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
