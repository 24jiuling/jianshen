package com.member.service.ipml;

import com.common.dao.HuiyuankaleixingDao;
import com.common.entity.HuiyuankaleixingEntity;
import com.common.entity.view.HuiyuankaleixingView;
import com.common.entity.vo.HuiyuankaleixingVO;
import com.common.utils.PageUtils;
import com.common.utils.Query;
import com.member.service.HuiyuankaleixingService;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("huiyuankaleixingService")
public class HuiyuankaleixingServiceImpl extends ServiceImpl<HuiyuankaleixingDao, HuiyuankaleixingEntity> implements HuiyuankaleixingService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuiyuankaleixingEntity> page = this.selectPage(
                new Query<HuiyuankaleixingEntity>(params).getPage(),
                new EntityWrapper<HuiyuankaleixingEntity>()
        );
        return new PageUtils(page);
    }

    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuiyuankaleixingEntity> wrapper) {
		  Page<HuiyuankaleixingView> page =new Query<HuiyuankaleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    @Override
	public List<HuiyuankaleixingVO> selectListVO(Wrapper<HuiyuankaleixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}

	@Override
	public HuiyuankaleixingVO selectVO(Wrapper<HuiyuankaleixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}

	@Override
	public List<HuiyuankaleixingView> selectListView(Wrapper<HuiyuankaleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuiyuankaleixingView selectView(Wrapper<HuiyuankaleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
