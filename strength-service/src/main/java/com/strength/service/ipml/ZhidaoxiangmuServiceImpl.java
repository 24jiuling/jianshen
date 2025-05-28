package com.strength.service.ipml;

import com.common.dao.ZhidaoxiangmuDao;
import com.common.entity.ZhidaoxiangmuEntity;
import com.common.entity.view.ZhidaoxiangmuView;
import com.common.entity.vo.ZhidaoxiangmuVO;
import com.common.utils.PageUtils;
import com.common.utils.Query;
import com.strength.service.ZhidaoxiangmuService;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("zhidaoxiangmuService")
public class ZhidaoxiangmuServiceImpl extends ServiceImpl<ZhidaoxiangmuDao, ZhidaoxiangmuEntity> implements ZhidaoxiangmuService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhidaoxiangmuEntity> page = this.selectPage(
                new Query<ZhidaoxiangmuEntity>(params).getPage(),
                new EntityWrapper<ZhidaoxiangmuEntity>()
        );
        return new PageUtils(page);
    }

    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhidaoxiangmuEntity> wrapper) {
		  Page<ZhidaoxiangmuView> page =new Query<ZhidaoxiangmuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    @Override
	public List<ZhidaoxiangmuVO> selectListVO(Wrapper<ZhidaoxiangmuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}

	@Override
	public ZhidaoxiangmuVO selectVO(Wrapper<ZhidaoxiangmuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}

	@Override
	public List<ZhidaoxiangmuView> selectListView(Wrapper<ZhidaoxiangmuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhidaoxiangmuView selectView(Wrapper<ZhidaoxiangmuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
