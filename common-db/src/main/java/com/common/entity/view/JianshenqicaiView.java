package com.common.entity.view;

import com.common.entity.JianshenqicaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;


/**
 * 健身器材
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author
 * @email
 * @date 2021-05-12 00:06:36
 */
@TableName("jianshenqicai")
public class JianshenqicaiView  extends JianshenqicaiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JianshenqicaiView(){
	}

 	public JianshenqicaiView(JianshenqicaiEntity jianshenqicaiEntity){
 	try {
			BeanUtils.copyProperties(this, jianshenqicaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
