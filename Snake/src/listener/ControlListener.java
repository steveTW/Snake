package listener;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

public class ControlListener implements InputProcessor{
	private int keyRestrict;
	private Vector2 vector = new Vector2();
	private Vector2 lastVector = new Vector2();
	
	public ControlListener() {
		this.vector.x = 1;
		this.vector.y = 0;
		this.keyRestrict = Keys.A;//限制玩家按回頭鍵自殺
	}
	
	public Vector2 getVolecity() {
		return this.vector;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
		case Keys.W:
			if (keyRestrict != Keys.W) {
				vector.y = 1;
				vector.x = 0;
				Gdx.app.log("keyrestrict", "S");
				keyRestrict = Keys.S;
			}
			break;
		case Keys.S:
			if (keyRestrict != Keys.S) {
				vector.y = -1;
				vector.x = 0;
				Gdx.app.log("keyrestrict", "W");
				keyRestrict = Keys.W;
			}
			break;
		case Keys.A:
			if (keyRestrict != Keys.A) {
				vector.x = -1;
				vector.y = 0;
				Gdx.app.log("keyrestrict", "D");
				keyRestrict = Keys.D;
			}
			break;
		case Keys.D:
			if (keyRestrict != Keys.D) {
				vector.x = 1;
				vector.y = 0;
				Gdx.app.log("keyrestrict", "A");
				keyRestrict = Keys.A;
			}
			break;
		}
		return true;
	}
	
	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		Gdx.app.log("controllistener","touchdown");
		lastVector.set(screenX,screenY);
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		Gdx.app.log("controllistener","touchup");
		Vector2 resultVector = lastVector.sub(screenX, screenY);//計算
		
		Float absoluteX=Math.abs(resultVector.x);
		Float absoluteY=Math.abs(resultVector.y);
		
		if (absoluteX>absoluteY) {
			vector.y=0;
			if ( resultVector.x >0&&keyRestrict!=Keys.A) {
				vector.x=-1;
				keyRestrict=Keys.D;
			}
			else if (resultVector.x<0&&keyRestrict!=Keys.D) {
				vector.x=1;
				keyRestrict=Keys.A;
			}
		}
		else {
			vector.x=0;
			if (resultVector.y >0&&keyRestrict!=Keys.W){
				vector.y=1;
				keyRestrict=Keys.S;
			}
			else if(resultVector.y<0&&keyRestrict!=Keys.S) {
				vector.y=-1;
				keyRestrict=Keys.W;
			}
		}
		
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return true;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}


}
