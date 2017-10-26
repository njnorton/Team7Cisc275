package factory;

import unit.turret.*;
import unit.turret.turrettypes.*;

public class TurretFactory {
	public TurretModel makeTurret(String turretName){
		
		TurretModel newTurret = null;
		
		switch (turretName){
			case "Crab" :
				newTurret = new TurretCrab();
				break;
			default:
				//TODO Throw exception
				break;
		}
		
		return newTurret;
		
		
		
		/*
		if (turretName.equals("Crab")){
			return new TurretCrab();
		}else
		*/
		
	}

}
