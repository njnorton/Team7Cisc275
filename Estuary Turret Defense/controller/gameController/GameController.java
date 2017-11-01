package gameController;


import java.awt.Graphics;
import java.awt.Image;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import java.awt.Image;
import boardMenuView.*;
import game.GameModel;
import mainMenuView.*;

public class GameController {
	//Note, traverse enemyList in reverse order, you should damage the thing that is furthest along
	static GameModel model;
	static String toPrint;
	static BoardMenuView view;
	static int roundTime;
	
	public GameController(){
		view = new BoardMenuView();

		
	}
	
	public static void gameInitialize(){
		/* Sets up the game, using a dummy path , 
		 * and the model that actually affects the objects in the game
		 * Also the size of the map  */
		model = new GameModel();
		//view = new BoardMenuView();
		
		//Do path assignment here
		int[] xpath = new int[1000];
		int[] ypath = new int[1000];
		for (int i = 0; i<1000; i++){
			xpath[i] = i;
		}
		for (int i = 0; i<1000; i++){
			ypath[i] = i;
		}
		
		model.game.path.setxCorArr(xpath);
		model.game.path.setyCorArr(ypath);
		model.game.path.setSize(1000);
		
		roundTime = 45;
	}
	
	public static void displayGrid(){
		/* Does system.out to display the actual objects in the game */
		System.out.flush();
		System.out.println("Current game: ");
		
		//Prints all the Poo bad guys
	    for(int i = 0; i < model.game.enemyList.size(); i++){
	    	//TODO Draw method for
	    	ImageIcon img = new ImageIcon(model.game.enemyList.get(i).geticon());
	    	JLabel label = new JLabel(img);
	    	view.centerPanel.add(label);
	    	
		}
	    	//img.drawImage(model.game.enemyList.get(i).geticon(),75,75,null);
	    	//BoardMenuCenterPanel.draw(img,model.game.enemyList.get(i).getxCor(),model.game.enemyList.get(i).getyCor());
	    
		//System.out.println("Line of Turrets");
		//Prints all the turrets
	    /*
		for (int i = 0; i < model.game.path.getSize(); i++){
			toPrint = "-";
			for(int j = 0; j < model.game.turretList.size(); j++){
				if (model.game.turretList.get(j).getxCor() == i){
					toPrint = "O";
					break;
				}
			}
			
			System.out.print(toPrint);
		}
		System.out.println("");
		*/
		
	}
	
	
	public static void resolveTurretActions(){
		//Iterates through every turrret
		for (int i =0; i < model.game.turretList.size(); i++){
			//Sees if the turret is allowed to shoot this round
			if (model.checkReloadCount(i)){
				//Iterates through every enemy
				for (int j = 0; j < model.game.enemyList.size(); j++){
					//Checks if that given enemy is in range
					//This may be different for different turrets if they range find differently
					if(model.checkRange(i, j)){
						//Reset the reload count
						model.resetReload(i);
						//Damages the enemy, if he dies it'll return true
						if(model.damageEnemy(i, j)){
							//Gives the player money for defeating the baddie
							model.gainBounty(j);
							//Removes the enemy 
							model.removeEnemy(j);
						}
						break;
					}
				}
			}
		}
	}
	
	public static void resolveEnemyActions(){
		//Moves the enemy, if the enemy has successfully gotten out of bounds the player loses life
		for (int i = 0; i < model.game.enemyList.size(); i++){	
			if (model.moveEnemy(i)){
				model.removeEnemy(i);
				model.reducePlayerHealth(1);
			}
		}
	}
	
	public static boolean checkPlayerIsDead(){
		//Sees if the player is ded, returns true if he is
		
		return model.checkPlayerIsDead();
	}

	public static void startRound(){
		//Sets up the game model for a round
		gameInitialize();
		view.sidePanel.timerPanel.setTime(roundTime);
		while (roundTime > 0){
			System.out.println(roundTime);
			view.sidePanel.timerPanel.setTime(roundTime);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			roundTime--;
			view.centerPanel.repaint();
			view.sidePanel.repaint();
		}
	}
	
	//TODO incorperate things here into the actual start round
	/*
	public static void startRound() {
		//For loop to run the game
		
		int time = 45;
		while(time > 0){
			time--;
			view.sidePanel.timerPanel.setTime(time);
			System.out.println(time);
			if (time%5 == 0){
				model.spawnEnemy("Poo");
			}
			if (time%7 == 0){
				model.spawnEnemy("QuickShit");				
			}
			displayGrid();
			//playerInput();
			//Resolve the round, move things, damage things, etc	
			resolveTurretActions();
			resolveEnemyActions();
			
			//Give the players 1 money every count
			model.increasePlayerMoney(1);
		
			//If the player is ded return true
			if (checkPlayerIsDead()){
				System.out.println("You have died!");
			break;
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	*/
	public static void endRound(){
		model.resetScorePanel(); // resets the scorePanel in the game
		System.out.println("Game over man!");
	}
}
		
		// TODO Auto-generated method stub


	
	
	/*
	public static void main(String[] FUN){
		
		
		
		
		
		
		
	}
		//This is a subsitute for the time function
	*/
		
	
		


/*

import MainMenu.InitiateGameStartView;

public class gameMain {
	// Note, traverse enemyList in reverse order, you should damage the thing
	// that is furthest along

	public static void main(String[] args) {
		InitiateGameStartView v1 = new InitiateGameStartView();
		}
	}
	*/

