package com.strength.service.ipml;

import com.common.dao.JianshenqicaiDao;
import com.common.entity.JianshenqicaiEntity;
import com.common.entity.view.JianshenqicaiView;
import com.common.entity.vo.JianshenqicaiVO;
import com.common.utils.PageUtils;
import com.common.utils.Query;
import com.strength.service.JianshenqicaiService;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("jianshenqicaiService")
public class JianshenqicaiServiceImpl extends ServiceImpl<JianshenqicaiDao, JianshenqicaiEntity> implements JianshenqicaiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JianshenqicaiEntity> page = this.selectPage(
                new Query<JianshenqicaiEntity>(params).getPage(),
                new EntityWrapper<JianshenqicaiEntity>()
        );
        return new PageUtils(page);
    }

    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JianshenqicaiEntity> wrapper) {
		  Page<JianshenqicaiView> page =new Query<JianshenqicaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    @Override
	public List<JianshenqicaiVO> selectListVO(Wrapper<JianshenqicaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}

	@Override
	public JianshenqicaiVO selectVO(Wrapper<JianshenqicaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}

	@Override
	public List<JianshenqicaiView> selectListView(Wrapper<JianshenqicaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JianshenqicaiView selectView(Wrapper<JianshenqicaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
