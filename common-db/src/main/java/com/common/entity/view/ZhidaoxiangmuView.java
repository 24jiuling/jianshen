package com.common.entity.view;



import com.baomidou.mybatisplus.annotations.TableName;
import com.common.entity.ZhidaoxiangmuEntity;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;


/**
 * 指导项目
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author
 * @email
 * @date 2021-05-12 00:06:36
 */
@TableName("zhidaoxiangmu")
public class ZhidaoxiangmuView  extends ZhidaoxiangmuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhidaoxiangmuView(){
	}

 	public ZhidaoxiangmuView(ZhidaoxiangmuEntity zhidaoxiangmuEntity){
 	try {
			BeanUtils.copyProperties(this, zhidaoxiangmuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
