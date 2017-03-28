package avalond.note.utils;

import avalond.note.BuildConfig;

import android.util.Log;

/**
 * @author kevin.
 */

public class Logger {

	/**
	 * i  method.
	 */
	public static void i(String tag, String msg) {

		if (BuildConfig.DEBUG) {
			Log.i(tag, msg);
		}
	}


	/**
	 * d  method.
	 */
	public static void d(String tag, String msg) {

		if (BuildConfig.DEBUG) {
			Log.d(tag, msg);
		}
	}


	/**
	 * e  method,get throwable.
	 */
	public static void e(String tag, String msg, Throwable tr) {

		if (BuildConfig.DEBUG) {
			Log.e(tag, msg, tr);
		}
	}


	/**
	 * w  method.
	 */
	public static void w(String tag, String msg) {

		if (BuildConfig.DEBUG) {
			Log.w(tag, msg);
		}
	}


	/**
	 * e  method.
	 */
	public static void e(String tag, String msg, Exception e) {

		if (BuildConfig.DEBUG) {
			Log.e(tag, msg, e);
		}
	}


	/**
	 * e  method.
	 */
	public static void e(String tag, String msg) {

		if (BuildConfig.DEBUG) {
			Log.e(tag, msg);
		}
	}
}
