package com.zhongmeng.rxjava2test.utils;

import android.text.TextUtils;
import android.util.Log;

/**
 * author : rcw
 * time   : 2017/7/28 11:39
 * version: 1.0
 * desc   :  日志打印工具类
 */
public final class LogUtils {
	private static final String TAG = "ZHONGMENG";
	private static final String RCW = "RCW";

	private static final boolean ENABLE = true;// 日志开关
	public static final boolean isPrint = true;//是否打印崩溃日志

	public static void i(String tag, String msg) {
		if (ENABLE&&(!TextUtils.isEmpty(msg))) {
			Log.i(tag, msg);
		}
	}

	public static void i(String msg) {
		if (ENABLE&&(!TextUtils.isEmpty(msg))) {
			Log.i(TAG, msg);
		}
	}

	public static void i(Class<?> cls, String msg) {
		if (ENABLE&&(!TextUtils.isEmpty(msg))) {
			Log.i(TAG + cls.getSimpleName(), msg);
		}
	}

	public static void d(String tag, String msg) {
		if (ENABLE&&(!TextUtils.isEmpty(msg))) {
			Log.i(tag, msg);
		}
	}

	public static void d(String msg) {
		if (ENABLE&&(!TextUtils.isEmpty(msg))) {
			Log.i(TAG, msg);
		}
	}

	public static void d(Class<?> cls, String msg) {
		if (ENABLE&&(!TextUtils.isEmpty(msg))) {
			Log.i(TAG + cls.getSimpleName(), msg);
		}
	}

	public static void e(String msg) {
		if (ENABLE&&(!TextUtils.isEmpty(msg))) {
			Log.e(TAG, msg);
		}
	}

	public static void e(Class<?> cls, String msg) {
		if (ENABLE&&(!TextUtils.isEmpty(msg))) {
			Log.e(TAG + cls.getSimpleName(), msg);
		}
	}

	public static void e(String tag, String msg) {
		if (ENABLE&&(!TextUtils.isEmpty(msg))) {
			Log.i(tag, msg);
		}
	}

	public static void z(String msg) {
		if (ENABLE&&(!TextUtils.isEmpty(msg))) {
			Log.i(RCW, msg);
		}
	}

	public static void z(Class<?> cls, String msg) {
		if (ENABLE&&(!TextUtils.isEmpty(msg))) {
			Log.e(RCW + cls.getSimpleName(), msg);
		}
	}

	public static void z(String tag, String msg) {
		if (ENABLE&&(!TextUtils.isEmpty(msg))) {
			Log.i(tag, msg);
		}
	}

}
