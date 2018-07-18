package screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.me.mygdxgame.SnakeGame;

public class OptionScreen extends GameScreen {
	static int difficulty;
	
	Label difficultyL;
	SelectBox difficultySB;
	
	public OptionScreen(SnakeGame game) {
		super(game);
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		this.stage.act();
		this.stage.draw();
	}

	@Override
	public void show() {
		super.show();
		this.stage = new Stage(800, 480, true);
		this.manager = SnakeGame.getManager();
		this.atlas = manager.get("Game/texture.atlas", TextureAtlas.class);
		Skin skin = new Skin(Gdx.files.internal("UI/skin.json"), this.atlas);
		
		difficultyL = new Label("Difficulty", skin);
		difficultySB = new SelectBox(new String[] {"easy", "normal", "hard"}, skin);
		
		
		this.stage.addActor(difficultyL);
		this.stage.addActor(difficultySB);
	}
}
