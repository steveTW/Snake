package screen;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.me.mygdxgame.SnakeGame;


public class GameoverScreen extends GameScreen{
	
	boolean moveToNext;

	public GameoverScreen(SnakeGame game) {
		super(game);
	}
	
	public void render(float delta) {
		// TODO Auto-generated method stub
		if (moveToNext) {
			this.game.setScreen(game.getMenuSreen());
		}
		Gdx.gl.glClearColor( 0, 0, 0, 0);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		this.stage.act();
		this.stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		this.stage = new Stage(800, 480, true);
		this.manager = SnakeGame.getManager();
		this.atlas = manager.get("Game/texture.atlas", TextureAtlas.class);
		Skin skin = new Skin(Gdx.files.internal("UI/skin.json"), this.atlas);
		
		Label label = new Label("Game Over", skin, "title");
		label.setName("label");
		label.setX((800 - label.getWidth())/2);
		label.setY(240);
		
		Label score = new Label("Your score:" + SnakeScreen.getScore(), skin, "default");
		score.setName("score");
		score.setX((800 - score.getWidth())/2);
		score.setY(label.getY() - score.getHeight() - 10);
		
		moveToNext = false;
		stage.addAction(Actions.sequence(Actions.fadeOut(0), Actions.fadeIn(1f), Actions.delay(1.2f), Actions.fadeOut(1f), Actions.run(GameOverRunnable)));
		stage.addActor(label);
		stage.addActor(score);
	}
	
	Runnable GameOverRunnable = new Runnable() {
		@Override
		public void run() {
			// TODO Auto-generated method stub
				moveToNext = true;
		}
	};



}
