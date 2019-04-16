import java.util.concurrent.*;

public class wilmaSaw implements Runnable{
	Semaphore sem1;
	Semaphore sem2;
	
	public wilmaSaw(Semaphore sem1, Semaphore sem2) {
		this.sem1 = sem1;
		this.sem2 = sem2;
	}
	
	public void run() {
		for(int j = 0; j < 10; j++) {	
			try {
				Thread.sleep(1000);
				sem1.acquire();
				sem2.acquire();
				
				System.out.println("\nWilma takes control");
				while(true) {
					if(Main.fredHeight == 1) {
						break;
					}
					Main.fredHeight -= 1.5;
					Main.wilmaHeight += 1.5;
					System.out.println("Wilma height " + Main.wilmaHeight + ", Fred height " + Main.fredHeight);
					
					Thread.sleep(1000);
				}
				
				sem1.release();
				sem2.release();
				System.out.println("Wilma releases sems");
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
