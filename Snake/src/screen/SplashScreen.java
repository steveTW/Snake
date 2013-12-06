package screen;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.me.mygdxgame.SnakeGame;

public class SplashScreen extends GameScreen{
	

	Image splashImage;
	boolean moveToNext;
	
	public SplashScreen(SnakeGame game) {
		// TODO Auto-generated constructor stub
		super(game);
	}
	
	public void render(float delta) {
		Gdx.gl.glClearColor( 0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		if (SnakeGame.getManager().update()) {
			if (moveToNext) {
				this.game.setScreen(game.getMenuSreen());
			}
		}
		this.stage.act();
		this.stage.draw();
	}
	
	public void show() {
		this.stage = new Stage(800, 480, true);
		Texture.setEnforcePotImages(false);	
		this.manager = SnakeGame.getManager();
		this.manager.load("Game/texture.atlas", TextureAtlas.class);
		this.manager.load("Game/Collision.ogg", Sound.class);
		this.manager.load("Game/eat.ogg", Sound.class);
		Texture r = new Texture(Gdx.files.internal("UI/splashimage.png"));
		splashImage = new Image(r);
		moveToNext = false;
		splashImage.addAction(Actions.sequence(Actions.fadeOut(0), Actions.fadeIn(1f), Actions.delay(1.5f), Actions.fadeOut(1f), Actions.run(SplashRunnable)));		
		this.stage.addActor(splashImage);
	}

	Runnable SplashRunnable = new Runnable() {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			if (SnakeGame.getManager().update()) {
				moveToNext = true;
			}
		}
	};

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		super.hide();
		Gdx.app.log("splashscreen ",  "hiding");
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		super.resume();
		Gdx.app.log("splashscreen ", "reuse");
	}
	

}
