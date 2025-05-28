package com.member.service.ipml;

import com.common.dao.HuiyuankaDao;
import com.common.entity.HuiyuankaEntity;
import com.common.entity.view.HuiyuankaView;
import com.common.entity.vo.HuiyuankaVO;
import com.common.utils.PageUtils;
import com.common.utils.Query;
import com.member.service.HuiyuankaService;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("huiyuankaService")
public class HuiyuankaServiceImpl extends ServiceImpl<HuiyuankaDao, HuiyuankaEntity> implements HuiyuankaService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuiyuankaEntity> page = this.selectPage(
                new Query<HuiyuankaEntity>(params).getPage(),
                new EntityWrapper<HuiyuankaEntity>()
        );
        return new PageUtils(page);
    }

    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuiyuankaEntity> wrapper) {
		  Page<HuiyuankaView> page =new Query<HuiyuankaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    @Override
	public List<HuiyuankaVO> selectListVO(Wrapper<HuiyuankaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}

	@Override
	public HuiyuankaVO selectVO(Wrapper<HuiyuankaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}

	@Override
	public List<HuiyuankaView> selectListView(Wrapper<HuiyuankaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuiyuankaView selectView(Wrapper<HuiyuankaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
