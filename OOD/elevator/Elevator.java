package elevator;
import java.util.*;

public class Elevator implements Runnable {
	private final int CAPACITY;
	
	private Status status;
	private Integer currentFloor;
	private Integer targetFloor;
	private PriorityQueue<Request> DesQ;

	public enum Status {
		IDLE, UP, DOWN, BUSY;
	}
	public Elevator(int CAPACITY, int init_floor) {
		this.CAPACITY = CAPACITY;
		this.status = Status.IDLE;
		this.currentFloor = init_floor;
		DesQ = new PriorityQueue<>();
		
	}
	
	public void reset() {
		targetFloor = 0;
		move();
		status = Status.IDLE;
	}
	
	public int getCurrentFloor() {
		return currentFloor;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public synchronized void setDestinationFloor(FloorButton button) {
		DesQ.add(button);
	}
	

	
	public void run() {
		while (true) {
			if (!DesQ.isEmpty()) {
				targetFloor = DesQ.peek().floor;
				move();
			} else {
				status = Status.IDLE;
			}
		}
	}

	public void move() {
		if (targetFloor == null) return;
		if (targetFloor > currentFloor) moveUp();
		else if (targetFloor < currentFloor) moveDown();
		else stop();
	}
	
	private void moveUp() {
		status = Status.MOVINGUP;
		try {
			while (currentFloor != targetFloor) {
				Thread.sleep(500);
				currentFloor++;
				targetFloor = DesQ.peek().floor;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		status = Status.UPIDLE;
		FloorButton button = DesQ.poll();
		button.upButton = false;
		stop();
	}
	
	private void moveDown() {
		status = Status.MOVINGDOWN;
		try {
			while (currentFloor != targetFloor) {
				Thread.sleep(500);
				currentFloor--;
				targetFloor = DesQ.peek().floor;				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		status = Status.DOWNIDLE;
		FloorButton button = DesQ.poll();
		button.downButton = false;
		stop();
	}
	
	public void stop() {
		try {
			Thread.sleep(2000);
			System.out.println(String.format("Elevator Stopping at Floor %d for 2s", currentFloor));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
