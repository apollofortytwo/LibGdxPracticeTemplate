package com.apollo.practice.screens;

import com.apollo.practice.entity.EntityManager;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

public class PlayScreen extends Screens {

	protected Game game;
	protected EntityManager entityManager;
	protected OrthographicCamera camera;
	protected TiledMap map;
	protected OrthogonalTiledMapRenderer renderer;
	public MapObjects objects;

	public PlayScreen(Game game) {
		this.game = game;

		camera = new OrthographicCamera();
		map = new TmxMapLoader().load("map.tmx");
		renderer = new OrthogonalTiledMapRenderer(map);
	
	
		camera.viewportHeight = ScreenManager.V_HEIGHT;
		camera.viewportWidth = ScreenManager.V_WIDTH;

		objects = map.getLayers().get(1).getObjects(); 
		entityManager = new EntityManager(objects);
	}

	@Override
	public void show() {

	}

	@Override
	public void render(SpriteBatch batch) {
		camera.update();
		camera.position.x = this.entityManager.getPlayer().getPosition().x;
		camera.position.y = this.entityManager.getPlayer().getPosition().y;

		batch.setProjectionMatrix(camera.combined);

		renderer.setView(camera);

		renderer.render();
		renderer.getBatch().begin();
		entityManager.render(renderer.getBatch());

		renderer.getBatch().end();

	}


	@Override
	public void resize(int width, int height) {
		camera.viewportHeight = height;
		camera.viewportWidth = width;

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {

	}

}
