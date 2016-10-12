package com.jerome.categorylist.domain;

import java.util.List;

/**
 * User: Liumj(liumengjie@365tang.cn)
 * Date: 2016-10-11
 * Time: 15:04
 * describe:  药物实体
 */
public class DrugBean {

	private String title;
	private List<DrugListBean> mList;


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<DrugListBean> getmList() {
		return mList;
	}

	public void setmList(List<DrugListBean> mList) {
		this.mList = mList;
	}




}
