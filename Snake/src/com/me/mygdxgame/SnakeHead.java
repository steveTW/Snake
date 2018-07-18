package com.me.mygdxgame;

import listener.ControlListener;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class SnakeHead extends Image {
	private int speed;//移動速度
	private float delay = 0f;
	public ControlListener cL;//the inputprocessor
	private float headWidth = 0f,headHeight = 0f;// 圖片大小
	
	
	public SnakeHead(AtlasRegion head, float x, float y,int speed) {
		super(head);
		this.setX(x);
		this.setY(y);		
		this.speed = (speed * 15 + 5) / 2;
		cL = new ControlListener();
		this.headWidth=getWidth();
		this.headHeight=getHeight();
	}

	public boolean update() {
		delay += Gdx.graphics.getDeltaTime();//上次螢幕刷新( render() )到目前螢幕刷新之時間間隔

		if (delay >= (1f / speed)) {
			setX(getX() + cL.getVolecity().x * headWidth);
			setY(getY() + cL.getVolecity().y * headHeight);
			
			if (getX() >= 800) {
				setX(0);
			}
			else if (getX() <= 0 - headWidth) {
				setX(800);
			}
			else if (getY() >=480) {
				setY(0);
			}
			else if (getY() <= 0 - headWidth){
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
