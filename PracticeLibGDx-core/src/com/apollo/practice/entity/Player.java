package com.apollo.practice.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.math.Vector2;

public class Player extends Entity {
	protected float elaspedTime;

	public Player(MapObjects objects) {
		super(objects);
		this.setSpeed(2); // Change the absolute speed the player can move
		this.setupAnimations("BryanS.png"); // Initiate all the spites for
												// animations

		getPosition().set(42, 1102);
		this.setBounds(this.getPosition().x, this.getPosition().y, 32, 32);
		
	}

	/**
	 * Listens to the keyboard for changes in Velocity Velocity doesn't change
	 * into position until it can pass the collision test
	 * 
	 */
	private void inputHandler() {
		Vector2 newPosition = new Vector2();
		newPosition = position.cpy();
		if (Gdx.input.isKeyPressed(Keys.W)) {
			this.getVelocity().set(0, this.getSpeed());
			animation = new Animation(1 / 3f, spriteUp);

		} else if (Gdx.input.isKeyPressed(Keys.D)) {
			this.getVelocity().set(this.getSpeed(), 0);
			System.out.println(spriteRight.length);
			animation = new Animation(1 / 3f, spriteRight);

		} else if (Gdx.input.isKeyPressed(Keys.S)) {
			this.getVelocity().set(0, -this.getSpeed());
			animation = new Animation(1 / 3f, spriteDown);

		} else if (Gdx.input.isKeyPressed(Keys.A)) {
			this.getVelocity().set(-this.getSpeed(), 0);
			animation = new Animation(1 / 3f, spriteLeft);
		} else {
			this.getVelocity().set(0, 0);
			animation = new Animation(1 / 3f, animation.getKeyFrames()[0]);
		}
		newPosition.add(getVelocity());

		if (!super.checkCollision(newPosition)) {
			this.position = newPosition;
		}
		this.setBounds(this.getPosition().x, this.getPosition().y, 32, 32);
		

	}

	/**
	 * Checks and updates to be made before sent to be rendered
	 */
	@Override
	public void update() {
		inputHandler();
		System.out.println(this.position);
	}

	@Override
	public void render(Batch batch) {
		update();
		elaspedTime += Gdx.graphics.getDeltaTime();
	
		batch.draw(animation.getKeyFrame(elaspedTime, true), this.getPosition().x, this.getPosition().y);
	}

	@Override
	public void create() {

	}

	@Override
	public void dispose() {

	}

}
