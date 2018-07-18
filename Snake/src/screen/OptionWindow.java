package screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
public class OptionWindow
  extends Window
{
  private Label difficultyL;
  private SelectBox difficultySB;
  private TextButton exit;
  
  public OptionWindow(String title, Skin skin, String styleName)
  {
    super(title, skin, styleName);
  }
  
  public OptionWindow(String title, Skin skin)
  {
    super(title, skin);
    String[] array = { " Easy", " Normal", " Hard" };
    
    Preferences pref=Gdx.app.getPreferences("Snake");
    this.difficultyL = new Label("Difficulty", skin);
    this.difficultySB = new SelectBox(array, skin);
    this.difficultySB.setSelection(pref.getInteger("Difficulty",0));
    this.difficultySB.addListener(new ChangeListener()
    {
      public void changed(ChangeListener.ChangeEvent event, Actor actor)
      {
        int difficulty = OptionWindow.this.difficultySB.getSelectionIndex() + 1;
        Preferences spref=Gdx.app.getPreferences("Snake");
        spref.putInteger("Difficulty", difficulty);
        spref.flush();// update preferences;
        OptionWindow.this.difficultySB.setSelection(OptionWindow.this.difficultySB.getSelectionIndex());
      }
    });
    this.exit = new TextButton("Back", skin);
    this.exit.setSize(150.0F, 30.0F);
    this.exit.setName("exit");
    
	Pixmap windowBg = new Pixmap(450, 30, Pixmap.Format.RGB888);
	windowBg.setColor(Color.GRAY);
	windowBg.fill();
	this.setBackground(new Image(new Texture(windowBg)).getDrawable());
    
    add(this.difficultyL).padRight(5.0F);
    add(this.difficultySB);
    row();
    add(this.exit).padTop(50.0F).center();
  }
 
}
