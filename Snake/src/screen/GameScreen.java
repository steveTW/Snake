package screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.me.mygdxgame.SnakeGame;

public class GameScreen implements Screen{
	
	public Stage stage;
	SnakeGame game;
	TextureAtlas atlas;
	AssetManager manager;
	
	public GameScreen(SnakeGame game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		stage.dispose();
		atlas.dispose();
	}
}
