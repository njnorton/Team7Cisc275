package unit.enemy.enemytypes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import unit.enemy.EnemyModel;

public class EnemyPoo extends EnemyModel {
	public EnemyPoo(){
		try{
			BufferedImage pooImage = ImageIO.read(new File("Images/Enemies/animal_poop.png"));
			setIcon(pooImage);
		}
		catch (IOException e) {
    		e.printStackTrace();
    	}
		setName("Poo");
		setFactDescription("Clean up after your pets!");
		
		//TODO PG13 the game
		
		setGameDescription("A tough little shit");
		
		setBounty(15);
		setId(0);
		setxCor(1);
		setyCor(1);
		setMaxHealth(150);
		setCurrentHealth(150);
		setScoreValue(50);
		setSpeed(1);
		setPositionIndex(0);
	}
}
