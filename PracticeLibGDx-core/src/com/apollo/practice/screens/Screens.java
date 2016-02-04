package com.apollo.practice.screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Screens {

	public abstract void show();

	public abstract void render(SpriteBatch batch);

	public abstract void resize(int width, int height);

	public abstract void pause();

	public abstract void resume();

	public abstract void hide();

	public abstract void dispose();

}
