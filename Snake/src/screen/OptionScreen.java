package screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.me.mygdxgame.SnakeGame;

public class OptionScreen extends GameScreen {
	static int difficulty;
	//static int stageNum;
	
	Label difficultyL;
	CheckBox difficultyCB;
	
	public OptionScreen(SnakeGame game) {
		super(game);
		// TODO Auto-generated constructor stub
		this.stage.act();
		this.stage.draw();
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		super.render(delta);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		super.show();
		this.stage = new Stage(800, 480, true);
		this.manager = SnakeGame.getManager();
		this.atlas = manager.get("Game/texture.atlas", TextureAtlas.class);
		Skin skin = new Skin(Gdx.files.internal("UI/skin.json"), this.atlas);
		
		difficultyL = new Label("Difficulty", skin);
		difficultyCB = new CheckBox("text", skin);
		
		this.stage.addActor(difficultyL);
		this.stage.addActor(difficultyCB);
		
	}
}
