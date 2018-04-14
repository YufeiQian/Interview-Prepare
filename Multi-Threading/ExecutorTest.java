import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorTest {
	 public static void main(String[] args) {
		 int numThreads = 4;
		 ExecutorService executor = Executors.newFixedThreadPool(numThreads);
		 for (int i = 0; i < numThreads; i++) {
			 executor.submit(new doStuff(executor));
		 }
	 }

}

class doStuff implements Runnable {
	private static int id = 0;
	private int workerId;
	private ExecutorService executor;
	private State state = new State();
	public doStuff(ExecutorService executor) {
		this.executor = executor;
		this.workerId = doStuff.id++;
	}
	
	@Override
	public void run() {
		System.out.println(workerId + " Worker Started!");
		System.out.println("I am worker " + workerId);
		executor.submit(new doStuff(executor));
		try {
			Thread.sleep(new Random().nextInt(4000));
		} catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Worker " + workerId + " has completed");
	}
}

class doAnotherStuff implements Runnable {
	private int id;
	private State state;
	public doAnotherStuff(int id, State state) {
		this.id = id;
		this.state = state;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("I am inside Another Runnable, id = " + id);
		if (id == 99) {
			state.setComplete(true);
		}
	}
}

class State {
	private boolean complete;
	public boolean getComplete() {
		return this.complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
}