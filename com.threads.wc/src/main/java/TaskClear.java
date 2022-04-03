package main.java;

public class TaskClear implements Runnable {
	private final WC WC;

	public TaskClear(WC WC) {
		this.WC = WC;
	}
	@Override
	public void run() {
		while (true) {
			this.WC.clear();
		}
	}
}
