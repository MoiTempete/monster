package com.tarena.monster;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;

import com.tarena.monster.engine.Actor;

public class Main extends Activity {
	GameView view;
	Actor actor;
	Handler hanler = new Handler();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		view = (GameView) findViewById(R.id.view);
		actor = ZombActor.createZombActor(this, ZombActor.ZOMB_0);
		actor.setCurrentDrawable(ZombActor.D_1);  
		view.actor = actor;
		actor.pos(300, 0);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		InnerThread t = new InnerThread();
		t.start();
		return super.onTouchEvent(event);
	}

	private class InnerThread extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					view.draw();
					if(actor.getPosX()>0) {
						actor.setPosX(actor.getPosX() - 1);
					}
					Thread.sleep(100);
				} catch (InterruptedException e) {
				}
			}
		}
	}
}