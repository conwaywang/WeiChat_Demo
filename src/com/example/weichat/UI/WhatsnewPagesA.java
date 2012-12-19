package com.example.weichat.UI;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.example.weichat.R;

public class WhatsnewPagesA extends Activity {
	/** Viewpager���� */
	private ViewPager viewPager;
	private ImageView imageView;
	/** ����һ�����飬�������ÿ��ҳ��Ҫ��ʾ��View */
	private ArrayList<View> pageViews;
	/** ����һ��imageview���͵����飬������ʾ����СԲ�� */
	private ImageView[] imageViews;
	/** װ��ʾͼƬ��viewgroup */
	private ViewGroup viewPictures;
	/** ����СԲ���viewgroup */
	private ViewGroup viewPoints;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		LayoutInflater inflater = getLayoutInflater();
		pageViews = new ArrayList<View>();
		pageViews.add(inflater.inflate(R.layout.viewpager01, null));
		pageViews.add(inflater.inflate(R.layout.viewpager02, null));
		pageViews.add(inflater.inflate(R.layout.viewpager03, null));
		pageViews.add(inflater.inflate(R.layout.viewpager04, null));
		pageViews.add(inflater.inflate(R.layout.viewpager05, null));
		pageViews.add(inflater.inflate(R.layout.viewpager06, null));

		// СԲ�����飬��С��ͼƬ�ĸ���
		imageViews = new ImageView[pageViews.size()];
		// ��ָ����XML�ļ��м�����ͼ
		viewPictures = (ViewGroup) inflater.inflate(R.layout.viewpagers, null);
		viewPager = (ViewPager) viewPictures.findViewById(R.id.guidePagers);
		viewPoints = (ViewGroup) viewPictures.findViewById(R.id.viewPoints);

		// ���СԲ�㵼����ͼƬ
		for (int i = 0; i < pageViews.size(); i++) {
			imageView = new ImageView(WhatsnewPagesA.this);
			imageView.setLayoutParams(new LayoutParams(20, 20));
			imageView.setPadding(5, 0, 5, 0);
			// ��СԲ��Ž�������
			imageViews[i] = imageView;
			// Ĭ��ѡ�е��ǵ�һ��ͼƬ����ʱ��һ��СԲ����ѡ��״̬����������
			if (i == 0)
				imageViews[i].setImageDrawable(getResources().getDrawable(
						R.drawable.page_indicator_focused));
			else
				imageViews[i].setImageDrawable(getResources().getDrawable(
						R.drawable.page_indicator_unfocused));
			// ��imageviews��ӵ�СԲ����ͼ��
			viewPoints.addView(imageViews[i]);
		}

		setContentView(viewPictures);

		viewPager.setAdapter(new NavigationPageAdapter());
		viewPager.setOnPageChangeListener(new NavigationPageChangeListener());
	}

	class NavigationPageAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return pageViews.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}

		@Override
		public Object instantiateItem(View container, int position) {
			// TODO Auto-generated method stub
			((ViewPager) container).addView(pageViews.get(position));
			return pageViews.get(position);
		}

		@Override
		public void destroyItem(View container, int position, Object object) {
			// TODO Auto-generated method stub
			((ViewPager) container).removeView(pageViews.get(position));
		}

	}

	class NavigationPageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageSelected(int position) {
			// TODO Auto-generated method stub
			for (int i = 0; i < imageViews.length; i++) {
				imageViews[i].setImageDrawable(getResources().getDrawable(
						R.drawable.page_indicator_focused));
				if (position != i)
					imageViews[i].setImageDrawable(getResources().getDrawable(
							R.drawable.page_indicator_unfocused));
			}
		}

	}

	public void startbutton(View v) {
		Intent intent = new Intent();
		intent.setClass(WhatsnewPagesA.this, WhatsnewAnimationA.class);
		startActivity(intent);
		WhatsnewPagesA.this.finish();
	}

}
