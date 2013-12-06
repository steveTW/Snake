package com.me.mygdxgame;

import screen.GameoverScreen;
import screen.MenuScreen;
import screen.SplashScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;

public class SnakeGame extends Game{
	public static AssetManager manager;
	
	public static SplashScreen splash;
	public static MenuScreen menu;
	public static GameoverScreen gameover;
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		manager = new AssetManager();
		this.setScreen(getSplashScreen());
	}
	
	public static AssetManager getManager() {
		if (manager == null) {
			manager = new AssetManager();
		}
		return manager;
	}
	
	public SplashScreen getSplashScreen() {
		if (splash == null) {
			splash = new SplashScreen(this);
		}
		return splash;
	}
	
	public  MenuScreen getMenuSreen() {
		if (menu == null) {
			menu = new MenuScreen(this);
		}
		return menu;
	}
	
	public GameoverScreen getGameoverScreen() {
		if (gameover == null) {
			gameover = new GameoverScreen(this);
		}
		return gameover;
	}
}
