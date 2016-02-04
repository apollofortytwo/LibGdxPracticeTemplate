package com.apollo.practice.entity;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.MapObjects;

public class EntityManager {
	private Player player;
	
	public EntityManager(MapObjects objects) {
		player = new Player(objects);
		
	}

	public void render(Batch batch) {
		player.render(batch);
	}
	
	public void dispose(){
		
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
}
