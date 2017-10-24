package game;


import java.util.Scanner;
import mainMenuView.*;

public class GameMain {
	//Note, traverse enemyList in reverse order, you should damage the thing that is furthest along
	static GameController controller;
	static String toPrint;
	static InitiateGameStartView view;
	
	
	
	public static void setup(){	
		
		/* Sets up the game, using a dummy path , 
		 * and the controller that actually affects the objects in the game
		 * Also the size of the map  */
		controller = new GameController();
		view = new InitiateGameStartView();
		
		//Do path assignment here
		int[] xpath = new int[1000];
		int[] ypath = new int[1000];
		for (int i = 0; i<1000; i++){
			xpath[i] = i;
		}
		for (int i = 0; i<1000; i++){
			ypath[i] = i;
		}
		
		controller.game.path.setxCorArr(xpath);
		controller.game.path.setyCorArr(ypath);
		controller.game.path.setSize(1000);
	}
	
	public static void displayGrid(){
		/* Does system.out to display the actual objects in the game */
		System.out.flush();
		System.out.println("Current game: ");
		
		//Prints all the Poo bad guys
		for (int i = 0; i < controller.game.path.getSize(); i++){
			toPrint = "-";
			for(int j = 0; j < controller.game.enemyList.size(); j++){
				if (controller.game.enemyList.get(j).getxCor() == i){
					toPrint = "X";
					break;
				}
			}
			System.out.print(toPrint);
		}
		System.out.println("");
		System.out.println("Line of Turrets");
		//Prints all the turrets
		for (int i = 0; i < controller.game.path.getSize(); i++){
			toPrint = "-";
			for(int j = 0; j < controller.game.turretList.size(); j++){
				if (controller.game.turretList.get(j).getxCor() == i){
					toPrint = "O";
					break;
				}
			}
			System.out.print(toPrint);
		}
		System.out.println("");
		
	}
	
	//Lets the player put in string inputs to control the game
	public static void playerInput(){
		/* Let'sthe players do things from the command line inputs  */
		boolean inputting = true;
		Scanner scanner = new Scanner(System.in);
		do{
			System.out.println("You have " + controller.player.getMoney() +" Sand Dollars to spend");
			System.out.println("You have " + controller.player.getHealth() + " Health remaining");
			System.out.println("Either enter name of turret to place (So type in 'Crab') case sensitive");
			System.out.println("Or input anything else to continue time by a step");
			String input = scanner.nextLine();
			if (input.equals("Crab")){
				if(controller.checkPrice(input)){
					System.out.println("Input value from 0 to 99 to place the turret on");
					String positionInput = scanner.nextLine();
					int intInput = Integer.parseInt(positionInput);
					if (intInput >= 0 && intInput <= 99){
						controller.spawnTurret(input, intInput, 2);
						//TODO will not work later on when prices of turrets needs to be checked
						//Should there be a library of turret prices?
						//Other option is having a library of turrets in the controller it can do lookups on
						controller.reducePlayerMoney(100);
						System.out.println("Your current turrets: ");
						
					}else{
						System.out.println("Invalid Input");
					}
				}else{
					System.out.println("Not enough money to afford that");
				}
			}else{
				inputting = false;
				return;
			}
		}while(inputting == true);
		scanner.close();
	}
	
	public static void resolveTurretActions(){
		//Iterates through every turrret
		for (int i =0; i < controller.game.turretList.size(); i++){
			//Sees if the turret is allowed to shoot this round
			if (controller.checkReloadCount(i)){
				//Iterates through every enemy
				for (int j = 0; j < controller.game.enemyList.size(); j++){
					//Checks if that given enemy is in range
					//This may be different for different turrets if they range find differently
					if(controller.checkRange(i, j)){
						//Reset the reload count
						controller.resetReload(i);
						//Damages the enemy, if he dies it'll return true
						if(controller.damageEnemy(i, j)){
							//Gives the player money for defeating the baddie
							controller.gainBounty(j);
							//Removes the enemy 
							controller.removeEnemy(j);
						}
						break;
					}
				}
			}
		}
	}
	
	public static void resolveEnemyActions(){
		//Moves the enemy, if the enemy has successfully gotten out of bounds the player loses life
		for (int i = 0; i < controller.game.enemyList.size(); i++){	
			if (controller.moveEnemy(i)){
				controller.reducePlayerHealth(1);
			}
		}
	}
	
	public static boolean checkPlayerIsDead(){
		//Sees if the player is ded, returns true if he is
		return controller.checkPlayerIsDead();
	}
	
	public static void main(String[] FUN){
		
		setup();
		
		
		/*
		//For loop to run the game
		for (int time = 0; time < 300; time++){
			if (time%5 == 0){
				controller.spawnEnemy("Poo");
			}
			if (time%7 == 0){
				controller.spawnEnemy("QuickShit");
			}
			displayGrid();
			playerInput();
			//Resolve the round, move things, damage things, etc	
			resolveTurretActions();
			resolveEnemyActions();
			
			//Give the players 1 money every count
			controller.increasePlayerMoney(1);
			
			//If the player is ded return true
			if (checkPlayerIsDead()){
				System.out.println("You have died!");
				break;
			}
			
			
			//Does a time check, if the player has survived long enough you win!
			if (time+1 == 300){
				System.out.println("You have won!");
			}
		}
		*/
	}
		//This is a subsitute for the time function
		
		
		
		
}

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

