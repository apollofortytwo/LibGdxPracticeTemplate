package com.apollo.practice.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity extends Sprite {

	public Entity(MapObjects objects) {
		this.objects = objects;
	}

	protected MapObjects objects;

	protected TextureRegion[] spriteDown;

	protected TextureRegion[] spriteUp;

	protected TextureRegion[] spriteRight;

	protected TextureRegion[] spriteLeft;

	protected TextureRegion[][] spriteSheet;

	protected Animation animation;
	protected Vector2 position = new Vector2(); // The position on the map
	private Vector2 velocity = new Vector2(); // The direction of speed on the
												// map
	private int speed = 0; // The speed of the entity

	public abstract void render(Batch batch);

	public abstract void create(); // What to do when created

	public abstract void dispose(); // delete

	public abstract void update(); // Checks before render

	public void setupAnimations(String path) {
		spriteSheet = new TextureRegion(new Texture(Gdx.files.internal(path))).split(32, 32);
		setupLeftAnimation();
		setupRightAnimation();
		setupUpAnimation();
		setDownAnimation();
	}

	public boolean checkCollision(Vector2 newPosition) {
		Sprite entityTester = new Sprite();

		entityTester.setBounds(newPosition.x, newPosition.y, this.getWidth() - 5, this.getHeight() - 5);
		for (RectangleMapObject rectangleObject : objects.getByType(RectangleMapObject.class)) {

			com.badlogic.gdx.math.Rectangle rectangle = rectangleObject.getRectangle();

			if (Intersector.overlaps(rectangle, entityTester.getBoundingRectangle())) {
				return true;
			}
		}
		return false;
	}

	public void setupLeftAnimation() {
		System.out.println(spriteSheet[0].length);
		spriteLeft = new TextureRegion[spriteSheet[0].length];

		for (int i = 0; i < spriteSheet[0].length; i++) {
			spriteLeft[i] = spriteSheet[1][i];
		}
		// animation = new Animation(5, left);

	}

	public void setupRightAnimation() {
		spriteRight = new TextureRegion[spriteSheet[0].length];

		for (int i = 0; i < spriteSheet[0].length; i++) {

			spriteRight[i] = spriteSheet[2][i];
		}
		System.out.println(spriteRight.length);
		// animation = new Animation(5, right);

	}

	public void setDownAnimation() {
		spriteDown = new TextureRegion[spriteSheet[0].length];

		for (int i = 0; i < spriteSheet[0].length; i++) {
			spriteDown[i] = spriteSheet[0][i];
		}
		// animation = new Animation(5, down);

	}

	public void setupUpAnimation() {

		spriteUp = new TextureRegion[spriteSheet[0].length];

		for (int i = 0; i < spriteSheet[0].length; i++) {
			spriteUp[i] = spriteSheet[3][i];
		}
		animation = new Animation(5, spriteUp);

	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public TextureRegion[] getSpriteDown() {
		return spriteDown;
	}

	public void setSpriteDown(TextureRegion[] spriteDown) {
		this.spriteDown = spriteDown;
	}

	public TextureRegion[] getSpriteUp() {
		return spriteUp;
	}

	public void setSpriteUp(TextureRegion[] spriteUp) {
		this.spriteUp = spriteUp;
	}

	public TextureRegion[] getSpriteRight() {
		return spriteRight;
	}

	public void setSpriteRight(TextureRegion[] spriteRight) {
		this.spriteRight = spriteRight;
	}

	public TextureRegion[] getSpriteLeft() {
		return spriteLeft;
	}

	public void setSpriteLeft(TextureRegion[] spriteLeft) {
		this.spriteLeft = spriteLeft;
	}
}
