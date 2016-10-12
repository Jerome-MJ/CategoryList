package com.jerome.categorylist.adapter;

import android.support.design.widget.Snackbar;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jerome.categorylist.R;
import com.jerome.categorylist.domain.DrugItemBean;
import com.jerome.categorylist.domain.DrugListBean;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.List;

/**
 * User: Liumj(liumengjie@365tang.cn)
 * Date: 2016-10-11
 * Time: 15:51
 * describe:  右边适配器
 */
public class RightAdapter extends BaseQuickAdapter<DrugListBean>{



	public RightAdapter(List<DrugListBean> data) {
		super(R.layout.item_main_right, data);
	}

	@Override
	protected void convert(final BaseViewHolder helper, final DrugListBean listBean) {
		helper.setText(R.id.item_main_right_title,listBean.getType());
		 TagFlowLayout  flowlayout = helper.getView(R.id.item_main_right_taglayout);
		final List<DrugItemBean> drugItemBeen = listBean.getmList();
		final DrugTagAdapter drugAdapter=new DrugTagAdapter(mContext,drugItemBeen);

		flowlayout.setAdapter(drugAdapter);
		flowlayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
			@Override
			public boolean onTagClick(View view, int position, FlowLayout parent) {
				DrugItemBean drugItemBean = drugItemBeen.get(position);
				for (DrugItemBean b:
				     drugItemBeen) {
					b.setCheck(false);
				}
				drugItemBean.setCheck(true);
				drugAdapter.notifyDataChanged();
				Snackbar.make(helper.convertView, "点击了"+drugItemBean.getName(), Snackbar.LENGTH_SHORT).show();
				return false;
			}
		});



	}
}
