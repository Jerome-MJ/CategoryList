package com.jerome.categorylist.domain;

import java.util.List;

/**
 * User: Liumj(liumengjie@365tang.cn)
 * Date: 2016-10-11
 * Time: 17:24
 * describe:
 */


public class DrugListBean {
	private String type;
	private List<DrugItemBean> mList;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<DrugItemBean> getmList() {
		return mList;
	}

	public void setmList(List<DrugItemBean> mList) {
		this.mList = mList;
	}



}
