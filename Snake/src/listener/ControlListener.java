package listener;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

public class ControlListener implements InputProcessor{
	private int keyRestrict;
	private Vector2 volecity = new Vector2();
	
	public ControlListener() {
		this.volecity.x = 1;
		this.volecity.y = 0;
		this.keyRestrict = Keys.A;
	}
	
	public Vector2 getVolecity() {
		return this.volecity;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		switch (keycode) {
		case Keys.W:
			if (keyRestrict != Keys.W) {
				volecity.y = 1;
				volecity.x = 0;
				Gdx.app.log("keyrestrict", "S");
				keyRestrict = Keys.S;
			}
			break;
		case Keys.S:
			if (keyRestrict != Keys.S) {
				volecity.y = -1;
				volecity.x = 0;
				Gdx.app.log("keyrestrict", "W");
				keyRestrict = Keys.W;
			}
			break;
		case Keys.A:
			if (keyRestrict != Keys.A) {
				volecity.x = -1;
				volecity.y = 0;
				Gdx.app.log("keyrestrict", "D");
				keyRestrict = Keys.D;
			}
			break;
		case Keys.D:
			if (keyRestrict != Keys.D) {
				volecity.x = 1;
				volecity.y = 0;
				Gdx.app.log("keyrestrict", "A");
				keyRestrict = Keys.A;
			}
			break;
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}


}
