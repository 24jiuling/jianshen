package com.member.service.ipml;

import com.common.dao.HuiyuanDao;
import com.common.entity.HuiyuanEntity;
import com.common.entity.view.HuiyuanView;
import com.common.entity.vo.HuiyuanVO;
import com.common.utils.PageUtils;
import com.common.utils.Query;
import com.member.service.HuiyuanService;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("huiyuanService")
public class HuiyuanServiceImpl extends ServiceImpl<HuiyuanDao, HuiyuanEntity> implements HuiyuanService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuiyuanEntity> page = this.selectPage(
                new Query<HuiyuanEntity>(params).getPage(),
                new EntityWrapper<HuiyuanEntity>()
        );
        return new PageUtils(page);
    }

    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuiyuanEntity> wrapper) {
		  Page<HuiyuanView> page =new Query<HuiyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    @Override
	public List<HuiyuanVO> selectListVO(Wrapper<HuiyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}

	@Override
	public HuiyuanVO selectVO(Wrapper<HuiyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}

	@Override
	public List<HuiyuanView> selectListView(Wrapper<HuiyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuiyuanView selectView(Wrapper<HuiyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
