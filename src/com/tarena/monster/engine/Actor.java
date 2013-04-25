package com.tarena.monster.engine;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;

public class Actor {
	// 绘画资源大小
	protected int width;
	protected int height;

	protected int posX = 0;
	protected int posY = 0;

	protected Drawable currentDrawable;

	private Map<Integer, Drawable> drawables = new HashMap<Integer, Drawable>();

	protected Context context;

	public void pos(int x, int y) {
		this.posX = x;
		this.posY = y;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void addDrawable(Drawable drawable, int id) {
		drawables.put(id, drawable);
	}

	public Actor(Context context, int width, int height) {
		this.width = width;
		this.height = height;
		this.context = context;
		initDrawable();
	}

	public void initDrawable() {
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Drawable getCurrentDrawable() {
		return currentDrawable;
	}

	public void setCurrentDrawable(Drawable currentDrawable) {
		this.currentDrawable = currentDrawable;
	}

	public void setCurrentDrawable(int id) {
		currentDrawable = drawables.get(id);
	}

	/**
	 * 
	 * @param canvas
	 */
	public void draw(Canvas canvas) {
		currentDrawable.setBounds(posX, posY, posX + width, posY + height);
		currentDrawable.draw(canvas);
	}

	/**
	 * 
	 * @param view
	 */
	public void initDrawable(View view) {
		currentDrawable.setCallback(view);
		if (currentDrawable != null) {
			if (currentDrawable instanceof AnimationDrawable) {
				((AnimationDrawable) currentDrawable).start();
			}
		}
	}

	protected Drawable createDrawable(int resId, int width, int height) {
		Bitmap src = BitmapFactory
				.decodeResource(context.getResources(), resId);
		Log.i("monster", src.getWidth() + "," + src.getHeight());
		Bitmap bm = Bitmap.createBitmap(src, 0, 0, width, height);
		return new BitmapDrawable(bm);
	}

	protected Drawable createDrawable(int resId, int width, int height,
			int frameCount) {
		Bitmap src = BitmapFactory
				.decodeResource(context.getResources(), resId);
		Log.i("monster", src.getWidth() + "," + src.getHeight());
		AnimationDrawable ad = new AnimationDrawable();
		ad.setOneShot(false);
		for (int i = 0; i < frameCount; i++) {
			Bitmap bm = Bitmap.createBitmap(src, i * width, 0, width, height);
			ad.addFrame(new BitmapDrawable(bm), 200);
		}
		return ad;
	}

}