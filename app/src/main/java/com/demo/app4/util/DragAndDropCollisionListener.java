package com.demo.app4.util;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

public class DragAndDropCollisionListener extends DragAndDropListenerLogic {

	// For collision detection
	private View targetImageView;	// target to watch for intersect from dragItem

	public DragAndDropCollisionListener(WindowManager windowManager, View targetImageView) {

		super(windowManager);

		this.targetImageView = targetImageView;
	}

	public void onMove(MotionEvent event) {

		boolean isCollision = isCollision();
		String msg = "isCollision : " + isCollision;
		Log.d("dbg", msg);
	}

	protected boolean isCollision () {

		boolean isCollision = false;

		Rect dragItem_viewRect = new Rect();
		dragItemImageView.getHitRect(dragItem_viewRect);

		Rect target_viewRect = new Rect();
		targetImageView.getHitRect(target_viewRect);

		if (Rect.intersects(dragItem_viewRect, target_viewRect)) {

			isCollision = true;
		}

		return isCollision;
	}

}
