package elevator;

public class FloorPanel {
	public final int floor;
	private Button UP;
	private Button DOWN;
	public FloorPanel(int floor) {
		this.floor = floor;
		UP = new Button();
		DOWN = new Button();
	}
	
	public void requestUP() {
		UP.on = true;
	}
	
	public void requestDOWN() {
		DOWN.on = true;
	}
	
	public void cacnelRequest(int i) {
		if (i == 0) UP.on = false;
		else DOWN.on = false;
	}
}
