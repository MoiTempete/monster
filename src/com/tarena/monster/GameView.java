package com.tarena.monster;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.tarena.monster.engine.Actor;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
	Actor actor;

	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		getHolder().addCallback(this);

	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	public void surfaceCreated(SurfaceHolder holder) {
		actor.initDrawable(this); 
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
	}

	@Override
	protected boolean verifyDrawable(Drawable who) {
		return who != null;
	}

	public void draw() {
		Canvas canvas = getHolder().lockCanvas();
		BitmapDrawable bd = (BitmapDrawable) getResources().getDrawable(
				R.drawable.bk1);
		Bitmap bk = bd.getBitmap();
		canvas.drawBitmap(bk, new Rect(0, 0, bk.getWidth(), bk.getHeight()),
				new Rect(0, 0, getWidth(), getHeight()), null);
		actor.draw(canvas);
		getHolder().unlockCanvasAndPost(canvas);
	}
}
