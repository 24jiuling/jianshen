package com.common.entity.vo;


import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;


/**
 * 会员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author
 * @email
 * @date 2021-05-12 00:06:36
 */
public class HuiyuanVO  implements Serializable {
	private static final long serialVersionUID = 1L;


	/**
	 * 密码
	 */

	private String mima;

	/**
	 * 会员姓名
	 */

	private String huiyuanxingming;

	/**
	 * 身份证
	 */

	private String shenfenzheng;

	/**
	 * 性别
	 */

	private String xingbie;

	/**
	 * 头像
	 */

	private String touxiang;

	/**
	 * 手机
	 */

	private String shouji;


	/**
	 * 设置：密码
	 */

	public void setMima(String mima) {
		this.mima = mima;
	}

	/**
	 * 获取：密码
	 */
	public String getMima() {
		return mima;
	}


	/**
	 * 设置：会员姓名
	 */

	public void setHuiyuanxingming(String huiyuanxingming) {
		this.huiyuanxingming = huiyuanxingming;
	}

	/**
	 * 获取：会员姓名
	 */
	public String getHuiyuanxingming() {
		return huiyuanxingming;
	}


	/**
	 * 设置：身份证
	 */

	public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
	}

	/**
	 * 获取：身份证
	 */
	public String getShenfenzheng() {
		return shenfenzheng;
	}


	/**
	 * 设置：性别
	 */

	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}

	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}


	/**
	 * 设置：头像
	 */

	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}

	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return touxiang;
	}


	/**
	 * 设置：手机
	 */

	public void setShouji(String shouji) {
		this.shouji = shouji;
	}

	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}

}
