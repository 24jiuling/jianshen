package com.common.entity.model;



import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;


/**
 * 会员卡类型
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author
 * @email
 * @date 2021-05-12 00:06:36
 */
public class HuiyuankaleixingModel  implements Serializable {
	private static final long serialVersionUID = 1L;


	/**
	 * 会员卡图片
	 */

	private String huiyuankatupian;

	/**
	 * 会员卡类型
	 */

	private String huiyuankaleixing;

	/**
	 * 会员卡功能
	 */

	private String huiyuankagongneng;

	/**
	 * 会员卡价格
	 */

	private Integer huiyuankajiage;

	/**
	 * 有效时间
	 */

	private String youxiaoshijian;

	/**
	 * 日期
	 */

	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date riqi;


	/**
	 * 设置：会员卡图片
	 */

	public void setHuiyuankatupian(String huiyuankatupian) {
		this.huiyuankatupian = huiyuankatupian;
	}

	/**
	 * 获取：会员卡图片
	 */
	public String getHuiyuankatupian() {
		return huiyuankatupian;
	}


	/**
	 * 设置：会员卡类型
	 */

	public void setHuiyuankaleixing(String huiyuankaleixing) {
		this.huiyuankaleixing = huiyuankaleixing;
	}

	/**
	 * 获取：会员卡类型
	 */
	public String getHuiyuankaleixing() {
		return huiyuankaleixing;
	}


	/**
	 * 设置：会员卡功能
	 */

	public void setHuiyuankagongneng(String huiyuankagongneng) {
		this.huiyuankagongneng = huiyuankagongneng;
	}

	/**
	 * 获取：会员卡功能
	 */
	public String getHuiyuankagongneng() {
		return huiyuankagongneng;
	}


	/**
	 * 设置：会员卡价格
	 */

	public void setHuiyuankajiage(Integer huiyuankajiage) {
		this.huiyuankajiage = huiyuankajiage;
	}

	/**
	 * 获取：会员卡价格
	 */
	public Integer getHuiyuankajiage() {
		return huiyuankajiage;
	}


	/**
	 * 设置：有效时间
	 */

	public void setYouxiaoshijian(String youxiaoshijian) {
		this.youxiaoshijian = youxiaoshijian;
	}

	/**
	 * 获取：有效时间
	 */
	public String getYouxiaoshijian() {
		return youxiaoshijian;
	}


	/**
	 * 设置：日期
	 */

	public void setRiqi(Date riqi) {
		this.riqi = riqi;
	}

	/**
	 * 获取：日期
	 */
	public Date getRiqi() {
		return riqi;
	}

}
