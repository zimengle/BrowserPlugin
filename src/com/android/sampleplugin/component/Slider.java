package com.android.sampleplugin.component;

import java.util.List;

import com.android.sampleplugin.R;
import com.android.sampleplugin.utils.Utils;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class Slider extends FrameLayout{

	private List<String> list;
	
	private ViewPager mViewPager;
	
	public Slider(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public Slider(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public Slider(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public void setData(List<String> list){
		this.list = list;
		init();
	}

	private void init() {
		mViewPager = new ViewPager(getContext());
		addView(mViewPager, new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		PagerAdapter adapter = new MyPagerAdapter(getContext(), list);
		mViewPager.setAdapter(adapter);
		adapter.notifyDataSetChanged();
		Log.d("zzm", "slider init");
//		LayoutInflater.from(getContext()).inflate(R.layout.slider, this);
//		mViewPager = (ViewPager) findViewById(R.id.pager);
//		mViewPager.setAdapter(new MyPagerAdapter(getContext(), list));
		
	}
	
	private static class MyPagerAdapter extends PagerAdapter{

		private Context context;
		
		private List<String> list;
		
		private ImageLoader imageLoader;
		
		public MyPagerAdapter(Context context,List<String> list) {
			this.context = context;
			this.list = list;
			imageLoader = Utils.getImageLoader(context);
		}
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			// TODO Auto-generated method stub
			return view == object;
		}
		
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			ImageView imageView = new ImageView(context);
			imageLoader.displayImage(list.get(position), imageView);
			container.addView(imageView,new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
			
			
			return imageView;
		}
		
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View)object);
		}
		
	}
	
	
}
