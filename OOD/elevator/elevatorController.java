package elevator;

import java.util.*;

import elevator.Elevator.Status;

public class elevatorController implements Runnable {
	List<Integer> upList;
	List<Integer> downList;
	List<FloorPanel> FloorPanel;
	Elevator elevator;
	
	
	public elevatorController(List<FloorPanel> buttons) {
		upList = new ArrayList<>();
		downList = new ArrayList<>();
		this.FloorPanel = buttons;
		elevator = new Elevator(1000, 0);
	}
	
	public synchronized void assignRequest() {
		if (upList.size() == 0 && downList.size() == 0) return;
		Status status = e.getStatus();
		
		//if (status == Status.MOVINGDOWN || status == Status.MOVINGUP) return;
		if (status == Status.BUSY) return;
		if (status == Status.UPIDLE || status == Status.MOVINGUP) {
			for (FloorPanel button : buttons) {
				if (button.floor > elevator.getCurrentFloor() && button.upButton) {
					elevator.setDestinationFloor(button);
				}
			}
		}
		else if (status == Status.DOWNIDLE || status == Status.MOVINGDOWN) {
			for (FloorButton button : buttons) {
				if (button.floor < elevator.getCurrentFloor() && button.downButton) {
					elevator.setDestinationFloor(button);
				}
			}
		}
		else {
			FloorButton target = null;
			int distance = Integer.MAX_VALUE;
			for (FloorButton button : buttons) {
				if (!button.upButton && !button.downButton)
				if (Math.abs(button.floor - elevator.getCurrentFloor()) < distance) {
					distance = 
				}
			}
		}
			
	}
	
	public void run() {
		while (true) {
			assignRequest();
			try {
				Thread.sleep(100);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void addRequest(Request r) {
		if (r.direction == Direction.UP) upList.add(r.currentFloor);
		else downList.add(r.currentFloor);
	}
	
	
	public static void main(String[] args) {
		elevatorController e1 = new elevatorController();
		Thread t1 = new Thread(e1);
		t1.setDaemon(true);
		t1.start();
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		while (cnt++ < 100) {
			int floor = sc.nextInt();
			Direction direction = sc.nextLine() == "DOWN" ? Direction.DOWN : Direction.UP;
			
		}
		sc.close();
	}
	
}
