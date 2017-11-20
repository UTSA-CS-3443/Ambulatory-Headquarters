package units;

import map.Map;

public class Wall extends Unit{

	public Wall(){
		this.setiUnitID(15);
		
		this.setiMobility(0);
		
		this.setbAlly(false);
	}
	
	@Override
	public void iLevelInc() {
	}

	@Override
	public void useSkill(Map map, int row, int col) {
		// TODO Auto-generated method stub
		
	}

}
