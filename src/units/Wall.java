package units;

public class Wall extends Unit{

	public Wall(){
		this.setiUnitID(15);
		
		this.setiMobility(0);
		
		this.setbAlly(true);
	}
	
	@Override
	public void iLevelInc() {
	}

}
