package com.toddmahoney.xenomorpher;

import com.badlogic.gdx.Game;
import com.toddmahoney.xenomorpher.views.EndScreen;
import com.toddmahoney.xenomorpher.views.MainScreen;
import com.toddmahoney.xenomorpher.views.MenuScreen;
import com.toddmahoney.xenomorpher.views.PreferencesScreen;
import com.toddmahoney.xenomorpher.views.LoadingScreen;

public class Xenomorpher extends Game {

	public final static int MENU = 0;
	public final static int PREFERENCES = 1;
	public final static int APPLICATION = 2;
	public final static int ENDGAME = 3;

	private LoadingScreen loadingScreen;
	private PreferencesScreen preferencesScreen;
	private MenuScreen menuScreen;
	private MainScreen mainScreen;
	private EndScreen endScreen;

	public void changeScreen(int screen) {
		switch(screen){
			case MENU:
				if(menuScreen == null) menuScreen = new MenuScreen();
					this.setScreen(menuScreen);
				break;
			case PREFERENCES:
				if(preferencesScreen == null) preferencesScreen = new PreferencesScreen();
					this.setScreen(preferencesScreen );
				break;
			case APPLICATION:
				if(mainScreen == null) mainScreen = new MainScreen();
					this.setScreen(mainScreen);
				break;
			case ENDGAME:
				if(endScreen == null) endScreen = new EndScreen();
					this.setScreen(endScreen);
				break;
		}
	}

	@Override
	public void create() {
		loadingScreen = new LoadingScreen();
		setScreen(loadingScreen);
	}
}
