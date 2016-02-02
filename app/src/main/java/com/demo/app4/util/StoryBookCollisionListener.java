package com.demo.app4.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

public class StoryBookCollisionListener extends DragAndDropCollisionListener {

	private Activity activity;

	private ViewPager mViewPager;

	private int nextPageIdx;

	private AlertDialog alertDialog;

	public StoryBookCollisionListener(WindowManager windowManager, View targetImageView) {

		super(windowManager, targetImageView);
	}

	public void setViewPager(ViewPager mViewPager, int curSectionNumber) {

		this.mViewPager	 = mViewPager;
		this.nextPageIdx = curSectionNumber;  // sectionNumber always +1 current item
	}

	public void setActivity(Activity activity) {

		this.activity = activity;
	}

	public void onMove(MotionEvent event) {

		boolean isCollision = isCollision();
		String msg = "isCollision : " + isCollision;
		Log.d("dbg", msg);

		if (isCollision) {

			if (alertDialog != null) {

				return;
			}

			alertDialog = new AlertDialog.Builder(activity).create();
			alertDialog.setTitle("You Win!");
			alertDialog.setMessage("Great job, you found the orange square. Advance to next page.");
			alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							// mViewPager.setCurrentItem(nextPageIdx);
							mViewPager.setCurrentItem(nextPageIdx, true);
							dialog.dismiss();

							alertDialog = null;
						}
					});
			alertDialog.show();

		}
	}


}
