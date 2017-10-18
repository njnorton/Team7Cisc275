package boardMenu;

import unit.turret.TurretModel;

public class BoardMenuController {

	BoardMenuScorePanel boardMenu; // allows for the use of controlling the view of the side panel
	
	public void updateScore(int score){
		boardMenu.updateScore(score);
	}
	
	public void updateSandDollars(int sandDollars){
		boardMenu.updateSandDollars(sandDollars);
	}
	
	public void updateHealth(int healthLost){
		boardMenu.updateHealth(healthLost);
	}
	
	public void purchaseItem(TurretModel model){
		boardMenu.purchaseItem(model);
	}
	
	public void reset(){
		boardMenu.reset();
	}
}
