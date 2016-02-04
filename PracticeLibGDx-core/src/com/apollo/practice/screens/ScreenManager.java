package com.apollo.practice.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScreenManager {
	public final static int V_HEIGHT = 320;
	public final static int V_WIDTH = 320;

	private Screens currentScreen = null;
	protected Game game;
	protected PlayScreen playScreen;

	public ScreenManager(Game game) {
		this.game = game;
		this.setCurrentScreen(playScreen = new PlayScreen(game));
	}

	public Screens getCurrentScreen() {
		return currentScreen;
	}

	public void setCurrentScreen(Screens currentScreen) {
		if (this.getCurrentScreen() != null) {
			this.getCurrentScreen().dispose();
		}
		this.currentScreen = currentScreen;
	}

	public void render(SpriteBatch batch) {
		if (this.getCurrentScreen() != null) {
			this.getCurrentScreen().render(batch);
		}
	}

}
