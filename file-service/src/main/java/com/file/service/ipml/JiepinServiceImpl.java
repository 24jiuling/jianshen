package com.file.service.ipml;

import com.common.dao.JiepinDao;
import com.common.entity.JiepinEntity;
import com.common.entity.view.JiepinView;
import com.common.entity.vo.JiepinVO;
import com.common.utils.PageUtils;
import com.common.utils.Query;
import com.file.service.JiepinService;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("jiepinService")
public class JiepinServiceImpl extends ServiceImpl<JiepinDao, JiepinEntity> implements JiepinService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiepinEntity> page = this.selectPage(
                new Query<JiepinEntity>(params).getPage(),
                new EntityWrapper<JiepinEntity>()
        );
        return new PageUtils(page);
    }

    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiepinEntity> wrapper) {
		  Page<JiepinView> page =new Query<JiepinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    @Override
	public List<JiepinVO> selectListVO(Wrapper<JiepinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}

	@Override
	public JiepinVO selectVO(Wrapper<JiepinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}

	@Override
	public List<JiepinView> selectListView(Wrapper<JiepinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiepinView selectView(Wrapper<JiepinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
