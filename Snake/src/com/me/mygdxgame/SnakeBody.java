package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class SnakeBody extends Group{
	Texture bodytext = new Texture(Gdx.files.internal("Game/snakebody.png"));	
	
	private SnakeHead head;
	public SnakeBody(SnakeHead head){
		super();		
		this.head = head;	
		genBody();
	}
	
	private void genBody() {
		Image first = new Image(bodytext);
		first.setX(head.getX() - bodytext.getWidth() * head.getvolecityX());
		first.setY(head.getY() - bodytext.getHeight() * head.getvolecityY());
		this.addActor(first);
		
		Actor[] bodys = this.getChildren().begin();
		for (int i = 0; i < 3; i++) {
			Image temp = new Image(bodytext);
			temp.setX(bodys[i].getX() - bodytext.getWidth() * head.getvolecityX());
			temp.setY(bodys[i].getY() - bodytext.getHeight() * head.getvolecityY());
			this.addActor(temp);
		}
	}
	

	
	public void moveBody(float nextX, float nextY) {	
		float bodyX, bodyY;	
		Actor[] bodys = this.getChildren().begin();		
		for (int i = 0; i < this.getChildren().size; i++) {
				bodyX = bodys[i].getX();
				bodyY = bodys[i].getY();
				bodys[i].setX(nextX);
				bodys[i].setY(nextY);
				nextX = bodyX;
				nextY = bodyY;
		}
	}
	
	public void addBody() {
		Image newNode = new Image(bodytext);
		Actor[] bodys = this.getChildren().begin();
		int last = this.getChildren().size;
		newNode.setX(bodys[last-1].getX());
		newNode.setY(bodys[last-1].getY());
		this.addActor(newNode);
	}
}
