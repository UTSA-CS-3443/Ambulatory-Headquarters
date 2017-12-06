package units;

import javafx.scene.image.Image;
import map.Map;

/**Small initialization for wall. We used this for mobility restriction by using unit detection
 * @author Alec
 *
 */
public class Wall extends Unit{
	
	private Image image = new Image("file:Wall.PNG");

	public Wall(){
		this.setiUnitID(15);
		this.setUImage(image);
		
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
