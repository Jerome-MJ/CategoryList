package com.jerome.categorylist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;
import com.jerome.categorylist.adapter.LeftAdapter;
import com.jerome.categorylist.adapter.RightAdapter;
import com.jerome.categorylist.domain.DrugBean;
import com.jerome.categorylist.domain.DrugItemBean;
import com.jerome.categorylist.domain.DrugListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Liumj(liumengjie@365tang.cn)
 * Date: 2016-10-11
 * Time: 14:10
 * describe:  主页Activity
 */
public class MainActivity extends AppCompatActivity {

	private RecyclerView mLeftRvRecyclerView;
	private RecyclerView mRightRvRecyclerView;

	private List<DrugBean> drugBeanList;
	private LeftAdapter leftAdapter;
	private RightAdapter rightAdapter;
	private List<DrugListBean> listBeanList;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mLeftRvRecyclerView = (RecyclerView) findViewById(R.id.main_left_rv);
		mRightRvRecyclerView = (RecyclerView) findViewById(R.id.main_right_rv);

		initData();
		leftAdapter=new LeftAdapter(drugBeanList);
		rightAdapter=new RightAdapter(listBeanList);



		mLeftRvRecyclerView.setAdapter(leftAdapter);
		mRightRvRecyclerView.setAdapter(rightAdapter);

		mLeftRvRecyclerView.setLayoutManager(new LinearLayoutManager(this));
		mRightRvRecyclerView.setLayoutManager(new LinearLayoutManager(this));

		mLeftRvRecyclerView.addOnItemTouchListener(new SimpleClickListener() {
			@Override
			public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
				DrugBean drugBean = drugBeanList.get(i);
				listBeanList.clear();
				listBeanList.addAll(drugBean.getmList());
				leftAdapter.setSelectPos(i);
				leftAdapter.notifyDataSetChanged();
				rightAdapter.notifyDataSetChanged();
			}

			@Override
			public void onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {

			}

			@Override
			public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {

			}

			@Override
			public void onItemChildLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {

			}
		});






	}

	/**
	 * 初始化数据
	 */
	private void initData() {
		drugBeanList=new ArrayList<>();
		listBeanList=new ArrayList<>();

		DrugBean d1=new DrugBean();
		d1.setTitle("糖尿病");
		DrugBean d2=new DrugBean();
		d2.setTitle("高血压");
		DrugBean d3=new DrugBean();
		d3.setTitle("高血脂");

		DrugListBean l1=new DrugListBean();

		l1.setType("口服药");


		DrugListBean l2=new DrugListBean();

		l2.setType("胰岛素");

		DrugItemBean b1=new DrugItemBean();
		b1.setName("二甲双胍");
		DrugItemBean b2=new DrugItemBean();
		b2.setName("维生素C");
		DrugItemBean b3=new DrugItemBean();
		b3.setName("格列本服");
		DrugItemBean b4=new DrugItemBean();
		b4.setName("得每通胶囊");
		DrugItemBean b5=new DrugItemBean();
		b5.setName("阿卡波糖");
		DrugItemBean b6=new DrugItemBean();
		b6.setName("美卡素");

		List<DrugItemBean> list1=new ArrayList<>();
		List<DrugItemBean> list2=new ArrayList<>();
		list1.add(b1);
		list1.add(b2);
		list1.add(b3);
		list1.add(b4);
		list2.add(b5);
		list2.add(b6);

		l1.setmList(list1);
		l2.setmList(list2);

		List<DrugListBean> li1=new ArrayList<>();
		List<DrugListBean> li2=new ArrayList<>();
		List<DrugListBean> li3=new ArrayList<>();

		li1.add(l1);
		li2.add(l2);
		li3.add(l1);
		li3.add(l2);

		d1.setmList(li1);
		d2.setmList(li2);
		d3.setmList(li3);


		drugBeanList.add(d1);
		drugBeanList.add(d2);
		drugBeanList.add(d3);


		listBeanList.addAll(drugBeanList.get(0).getmList());








	}
}
