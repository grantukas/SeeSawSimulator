import java.util.concurrent.*;

public class fredSee implements Runnable {
	Semaphore sem1;
	Semaphore sem2;
	
	public fredSee(Semaphore sem1, Semaphore sem2) {
		this.sem1 = sem1;
		this.sem2 = sem2;
	}
	
	public void run() {
		for(int j = 0; j < 10; j++) {
			try {
				sem1.acquire();
				sem2.acquire();
				
				System.out.println("\nFred takes control");
				while(true) {
					if(Main.wilmaHeight == 1) {
						break;
					}
					Main.fredHeight++;
					Main.wilmaHeight--;
					System.out.println("Fred height " + Main.fredHeight + ", Wilma height " + Main.wilmaHeight);
					
					Thread.sleep(1000);
				}
				
				sem1.release();
				sem2.release();
				System.out.println("Fred releases sems");
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
