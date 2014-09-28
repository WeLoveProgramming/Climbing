package com.example.testandroid;

import com.example.testandroid.Graphics.ImageFormat;

public class LoadingScreen extends Screen {
 public LoadingScreen(Game game) {
         super(game);
     }
 public void update(float deltaTime) {
     Graphics g = game.getGraphics();
     Assets.menu = g.newImage("menu.png", ImageFormat.RGB565);
     game.setScreen(new MainMenuScreen(game));

 }
 public void paint(float deltaTime) {
     Graphics g = game.getGraphics();
     g.drawImage(Assets.splash, 0, 0);
 }

 @Override
 public void pause() {

 }

 @Override
 public void resume() {

 }

 @Override
 public void dispose() {

 }

 @Override
 public void backButton() {

 }

}
