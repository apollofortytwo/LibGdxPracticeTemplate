package com.apollo.practice;

import com.apollo.practice.screens.ScreenManager;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PracticeLibGdx extends Game {
	SpriteBatch batch;
	ScreenManager screenManager;

	@Override
	public void create() {
		batch = new SpriteBatch();
		screenManager = new ScreenManager(this);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		screenManager.render(batch);
		batch.end();
	}
}
