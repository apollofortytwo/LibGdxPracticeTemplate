package com.apollo.practice.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.apollo.practice.PracticeLibGdx;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 720;
		config.width = 1080;
		config.title = "Testing LIBGDX";
		new LwjglApplication(new PracticeLibGdx(), config);
	}
}
