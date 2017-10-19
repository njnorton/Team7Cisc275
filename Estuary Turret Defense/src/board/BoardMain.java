package board;


import java.util.Scanner;

public class BoardMain {
	//Note, traverse enemylist in reverse order, you should damage the thing that is furthest along
	static BoardController Controller;
	static String toPrint;
	
	
	
	public static void setup(){	
		Controller = new BoardController();
		int[] xPath = new int[100];
		int[] yPath = new int[100];
		for (int i = 0; i<100; i++){
			xPath[i] = i;
		}
		for (int i = 0; i<100; i++){
			yPath[i] = 2;
		}
		
		Controller.Board.Path.setxCorArr(xPath);
		Controller.Board.Path.setyCorArr(yPath);
		Controller.Board.Path.setSize(100);
	}
	
	public static void displayGrid(){
		System.out.println("Current Board: ");
		
		//Prints all the Poo bad guys
		for (int i = 0; i < Controller.Board.Path.getSize(); i++){
			toPrint = "-";
			for(int j = 0; j < Controller.Board.EnemyList.size(); j++){
				if (Controller.Board.EnemyList.get(j).getPositionIndex() == i){
					toPrint = "X";
					break;
				}
			}
			System.out.print(toPrint);
		}
		System.out.println("");
		System.out.println("Line of Turrets");
		//Prints all the turrets
		for (int i = 0; i < Controller.Board.Path.getSize(); i++){
			toPrint = "-";
			for(int j = 0; j < Controller.Board.TurretList.size(); j++){
				if (Controller.Board.TurretList.get(j).getxCor() == i){
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
		boolean inputting = true;
		Scanner scanner = new Scanner(System.in);
		while (inputting){
			System.out.println("You have " + Controller.Player.getMoney() +" Sand Dollars to spend");
			System.out.println("Either enter name of turret to place (So type in 'Crab') case sensitive");
			System.out.println("Or input anything else to continue time by a step");
			String input = scanner.nextLine();
			if (input.equals("Crab")){
				if(Controller.checkPrice(input)){
					System.out.println("Input value from 0 to 99 to place the turret on");
					String positionInput = scanner.nextLine();
					int intInput = Integer.parseInt(positionInput);
					if (intInput >= 0 && intInput <= 99){
						Controller.spawnTurret(input, intInput, 2);
						//TODO will not work later on when prices of turrets needs to be checked
						//Should there be a library of turret prices?
						//Other option is having a library of turrets in the controlller it can do lookups on
						Controller.reducePlayerMoney(100);
					}else{
						System.out.println("Invalid Input");
					}
				
				}else{
					System.out.println("Not enough money to afford that");
				}
				
				
			}else{
				inputting = false;
			}
		}
		scanner.close();
	}
	
	public static void resolveTurretActions(){
		//Run through turrets, attempt to damage bad guys
		for (int i =0; i < Controller.Board.TurretList.size(); i++){
			if (Controller.checkReloadCount(i)){
				for (int j = 0; j < Controller.Board.EnemyList.size(); j++){
					if(Controller.checkRange(i, j)){
						if(Controller.damageEnemy(i, j)){
							Controller.removeEnemy(j);
						}
						break;
					}
				}
			}
		}
	}
	
	public static void resolveEnemyActions(){
		for (int i = 0; i < Controller.Board.EnemyList.size(); i++){	
			if (Controller.moveEnemy(i)){
				Controller.reducePlayerHealth(1);
			}
		}
	}
	
	public static boolean checkPlayerIsDead(){
		return Controller.checkPlayerIsDead();
	}
	
	public static void main(String[] FUN){
		
		setup();
			
		//For loop to run the game
		for (int time = 0; time < 300; time++){
			if (time%5 == 0){
				Controller.spawnEnemy("Poo");
			}
			if (time%11 == 0){
				Controller.spawnEnemy("QuickShit");
			}
			
			displayGrid();
		
			playerInput();
			
			//Resolve the round, move things, damage things, etc	
			resolveTurretActions();
			
			resolveEnemyActions();
			
			if (checkPlayerIsDead()){
				System.out.println("You have died!");
				break;
			}
			
			if (time+1 == 300){
				System.out.println("You have won!");
			}
		}
		
		/*
		System.out.println("Enter your username: ");
		Scanner scanner = new Scanner(System.in);
		String username = scanner.nextLine();
		System.out.println("Your username is " + username);
		scanner.close();
		*/
	}
		//This is a subsitute for the time function
		
		
		
		
}

/*

import MainMenu.InitiateGameStartView;

public class BoardMain {
	// Note, traverse enemylist in reverse order, you should damage the thing
	// that is furthest along

	public static void main(String[] args) {
		InitiateGameStartView v1 = new InitiateGameStartView();
		}
	}
	*/

