package com.me.mygdxgame;

import listener.ControlListener;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class SnakeHead extends Image {
	private int speed;//this control moves per second;
	private float delay = 0;
	public ControlListener cL;//the inputprocessor
	
	public SnakeHead(AtlasRegion head, float x, float y) {
		super(head);
		this.setX(x);
		this.setY(y);		
		this.speed = 10;
		cL = new ControlListener();
	}

	public boolean update() {
		delay += Gdx.graphics.getDeltaTime();//

		if (delay >= (1f / speed)) {
			setX(getX() + cL.getVolecity().x * getWidth());
			setY(getY() + cL.getVolecity().y * getHeight());
			
			if (getX() >= 800) {
				setX(0);
			}
			else if (getX() <= 0 - getWidth()) {
				setX(800);
			}
			else if (getY() >=480) {
				setY(0);
			}
			else if (getY() <= 0 - getHeight()){
				setY(480);
			}
			delay = 0f;

			return true;
			
		}
		return false;
	}
	
	public float getvolecityX() {
		return cL.getVolecity().x;
	}
	
	public float getvolecityY() {
		return cL.getVolecity().y;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public ControlListener getControlListener() {
		return cL;
	}



}
