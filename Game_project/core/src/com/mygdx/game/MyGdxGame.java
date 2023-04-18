package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture fon;
	Music music;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		fon = new Texture("фоны/" + Backgrounds.values()
				[new Random().nextInt(Backgrounds.values().length)] + ".png");
		music = Gdx.audio.newMusic(Gdx.files.internal("Музыка/" +
				Sounds.values()[new Random().nextInt(Sounds.values().length)] + ".mp3"));
		music.setLooping(true);
		music.setVolume(0.125f);
		music.play();
	}



	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(fon, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		fon.dispose();
	}
}
