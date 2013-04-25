package com.tarena.monster;

import android.content.Context;

import com.tarena.monster.engine.Actor;

public class ZombActor extends Actor {
	// ��ͨ��ʬ
	public static final int ZOMB_0 = 0;
	// ��ñ�ӵĽ�ʬ
	public static final int ZOMB_1 = 1;
	// ����Ͱ�Ľ�ʬ
	public static final int ZOMB_2 = 2;

	// ��ֹ
	public static final int D_0 = 0;
	// �н�
	public static final int D_1 = 1;
	// ����
	public static final int D_2 = 2;

	public ZombActor(Context context, int width, int height) {
		super(context, width, height);
	}

	public static ZombActor createZombActor(Context context, int type) {
		ZombActor actor = null;
		switch (type) {
		case ZOMB_0:
			actor = new ZombActor_0(context, 62, 90);
			break;
		case ZOMB_1:
			break;
		case ZOMB_2:
		}
		return actor;
	}
}
