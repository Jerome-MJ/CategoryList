package com.jerome.categorylist.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.jerome.categorylist.R;
import com.jerome.categorylist.domain.DrugItemBean;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;

import java.util.List;

/**
 * User: Liumj(liumengjie@365tang.cn)
 * Date: 2016-10-11
 * Time: 16:32
 * describe:  药品标签
 */
public class DrugTagAdapter extends TagAdapter<DrugItemBean>{

	private LayoutInflater mInflater;

	public DrugTagAdapter(Context context, List<DrugItemBean> datas) {
		super(datas);
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public View getView(FlowLayout parent, int position, DrugItemBean md) {
		TextView tv = (TextView) mInflater.inflate(R.layout.item_medical_tv,
				parent, false);
		if(md.isCheck()){
			tv.setBackgroundResource(R.drawable.shape_wiki_drug_check);
			tv.setTextColor(Color.parseColor("#40a5f3"));
		}else{
			tv.setBackgroundResource(R.drawable.shape_wiki_drug_normal);
			tv.setTextColor(Color.parseColor("#333333"));
		}
		tv.setText(md.getName());
		return tv;
	}
}
