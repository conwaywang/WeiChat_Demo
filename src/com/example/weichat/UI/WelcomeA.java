package com.example.weichat.UI;

import com.example.weichat.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/** ������ӭ���� */
public class WelcomeA extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.strat);
		//�ӳ������ִ��run�����е�ҳ����ת
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				Intent intent = new Intent(WelcomeA.this, WhatsnewPagesA.class);
				startActivity(intent);
				WelcomeA.this.finish();
			}
		}, 2000);
	}
}
