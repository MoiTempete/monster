package com.tarena.monster;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class ZombActor_0 extends ZombActor {

	public ZombActor_0(Context context, int width, int height) {
		super(context, width, height);
	}

	@Override
	public void initDrawable() {
		// D_0
		Drawable d0 = createDrawable(R.drawable.zomb_0, 62, 90);
		addDrawable(d0, D_0);
		// D_1
		Drawable d1 = createDrawable(R.drawable.zomb_0, 62, 90, 8);
		addDrawable(d1, D_1);
	}
}
