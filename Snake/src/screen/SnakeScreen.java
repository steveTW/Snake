package screen;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.me.mygdxgame.SnakeBody;
import com.me.mygdxgame.SnakeGame;
import com.me.mygdxgame.SnakeHead;



public class SnakeScreen extends GameScreen {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private SnakeHead player;
	private SnakeBody snakeBody;
	private Image food;
	//private Image extra;
	private boolean existfood;
	private static int score;
	
	private Sound eat;
	private Sound collision;
	
	private Label label;
	
	public SnakeScreen(SnakeGame game){
		super(game);		
	}

	@Override
	//this is from implement screen
	public void show() {		
		int height = 480, width = 800;
		float h = Gdx.graphics.getHeight(), w = Gdx.graphics.getWidth();
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		this.stage = new Stage(width, height, true);
		Texture.setEnforcePotImages(false);				
		this.manager = SnakeGame.getManager();	
		this.atlas = manager.get("Game/texture.atlas", TextureAtlas.class);	
		Skin skin = new Skin(Gdx.files.internal("UI/skin.json"), this.atlas);
		
		label = new Label("Score:", skin, "normal");
		label.setName("score");
		label.setX(10);
		label.setY(height-label.getHeight() - 10);

		player = new SnakeHead(this.atlas.findRegion("snakehead"), 400, 240);//getImageheight only return 0
		snakeBody = new SnakeBody(player);
		placefood();
		existfood = true;
		
		score = 0;
		
		eat = manager.get("Game/eat.ogg", Sound.class);
		collision = manager.get("Game/Collision.ogg", Sound.class);
		
		
		stage.addActor(player);
		stage.addActor(snakeBody);
		stage.addActor(label);
		
		Gdx.input.setInputProcessor(player.getControlListener());//set player as default inputprocessor	
	}

	@Override
	public void dispose() {
		batch.dispose();
		stage.dispose();
	}

	@Override
	//this is from implement screen
	public void render(float delta) {		
		Gdx.gl.glClearColor( 0.5f, 0.75f, 0.5f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.end();
		
		if (checkCollide(player, snakeBody)) {
			collision.play();
			this.game.setScreen(game.getGameoverScreen());
		}
		else {
			float x = player.getX(); 
			float y = player.getY();
			if (player.update()) {//update snake head position
				snakeBody.moveBody(x, y);//move snake body
			}
			
			if (eatfood(player, food)) {
				eat.play();
				stage.getRoot().removeActor(food);
				snakeBody.addBody();
				score+=10;
				existfood = false;
			}
			
			if (!existfood) {
				placefood();
				existfood = true;
			}
			
			Label label = (Label) stage.getRoot().findActor("score");
			label.setText("Score:" + score);
			label.setX(10);
		}
			stage.act();
			stage.draw();		
		
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
	
	private void placefood() {
		int x = MathUtils.random(0, 39) * 20;
		int y = MathUtils.random(0, 23) * 20;
		
		food = new Image(this.atlas.findRegion("food"));
		food.setX(x);
		food.setY(y);
		
		stage.addActor(food);
	}
	
	private boolean checkCollide(SnakeHead head, SnakeBody body) {
		Rectangle tangle = new Rectangle(head.getX(), head.getY(), head.getWidth(), head.getHeight());
		
		Actor[] temp = body.getChildren().begin();
		for(int i = 0; i < body.getChildren().size; i++)  {
			Rectangle r = new Rectangle(temp[i].getX(), temp[i].getY(), temp[i].getWidth(), temp[i].getHeight());
			if (tangle.overlaps(r)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean eatfood(SnakeHead head, Image food) {
		Rectangle tangle = new Rectangle(head.getX(), head.getY(), head.getWidth(), head.getHeight());
		Rectangle r = new Rectangle(food.getX(), food.getY(), food.getWidth(), food.getHeight());
		if (tangle.overlaps(r)) {
			return true;
		}
		return false;
	}
	
	public static int getScore() {
		return score;
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
		
	}
}
