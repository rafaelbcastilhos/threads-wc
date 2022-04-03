public class WC {
	private boolean isDirty = true;

	public void num1() throws InterruptedException {
		String name = Thread.currentThread().getName();

		System.out.println(name + " knocking on the door");
		synchronized (this) {
			while (this.isDirty) {
				System.out.println(name + " entering the bathroom");
				this.waitOutside(name);
			}
			System.out.println(name + " entering the bathroom");
			System.out.println(name + " will be fast");

			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.isDirty = true;
			System.out.println(name + " leaving the bathroom");
		}
	}

	public void num2() throws InterruptedException {
		String name = Thread.currentThread().getName();

		System.out.println(name + " knocking on the door");
		synchronized (this) {
			while (this.isDirty) {
				System.out.println(name + " entering the bathroom");
				this.waitOutside(name);
			}
			System.out.println(name + " entering the bathroom");
			System.out.println(name + " will be slow");

			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			this.isDirty = true;
			System.out.println(name + " leaving the bathroom");
		}
	}

	public void clear() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " knocking on the door");

		synchronized (this) {
			System.out.println(name + " entering the bathroom");
			if (!this.isDirty) {
				System.out.println(name + ", it's clean, i'm going out");
				return;
			}

			System.out.println(name + " cleaning the bathroom");
			this.isDirty = false;

			try {
				Thread.sleep(13000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(name + " leaving the bathroom");
			this.notifyAll();
		}
	}

	private void waitOutside(String name) {
		System.out.println(name + " bathroom is dirty");
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}