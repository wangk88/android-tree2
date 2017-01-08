package com.zhy.tree_view;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.zhy.bean.Bean;
import com.zhy.bean.FileBean;
import com.zhy.tree.bean.Node;
import com.zhy.tree.bean.TreeListViewAdapter;
import com.zhy.tree.bean.TreeListViewAdapter.OnTreeNodeClickListener;

public class MainActivity extends Activity {
	private List<Bean> mDatas = new ArrayList<Bean>();
	private List<Bean> mDatas2 = new ArrayList<Bean>();
	private ListView mTree, mTree2;
	private SimpleTreeAdapter mAdapter, mAdapter2;
	ImageView iv = null;

	// 在这里实现onTouchEvent
	public boolean onTouchEvent(MotionEvent event) {
		// 在这里判断一下如果是按下操作就获取坐标然后执行方法
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			// displayXY(event.getX(), event.getY());
		}
		return super.onTouchEvent(event);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initDatas();
		// initDatas2();
		
		mTree = (ListView) findViewById(R.id.id_tree);

		mTree2 = (ListView) findViewById(R.id.id_tree2);

		try {
			mAdapter = new SimpleTreeAdapter<Bean>(mTree, this, mDatas, 10,false);
			mAdapter2 = new SimpleTreeAdapter<Bean>(mTree2, this, mDatas2, 10,true);
			mAdapter2.SetTarget(true);
/*			mAdapter.setOnTreeNodeClickListener(new OnTreeNodeClickListener() {
				@Override
				public void onClick(final Node node, int position) {

					
					if (node.isLeaf()) {
                         
						mAdapter.notifyDataSetChanged();
						Toast.makeText(getApplicationContext(), node.getName(),
								100).show();
					}
				}

			});*/

		} catch (Exception e) {
			e.printStackTrace();
		}
		mTree.setAdapter(mAdapter);
		mTree2.setAdapter(mAdapter2);
	}

	private void initDatas() {
		mDatas.add(new Bean(1, 0, "根目录1"));
		mDatas.add(new Bean(5, 1, "子目录1-1"));
		mDatas.add(new Bean(6, 1, "子目录1-2"));
		mDatas.add(new Bean(7, 5, "子目录1-1-1"));
		mDatas.add(new Bean(17, 6, "子目录1-2-1"));
		mDatas.add(new Bean(18, 6, "子目录1-2-2"));
          
		mDatas2.add(new Bean(1, 0, "目标1"));
		mDatas2.add(new Bean(2, 0, "目标2"));
	
		
	}


}
