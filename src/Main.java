import java.util.concurrent.*;

public class Main {
	public static double fredHeight = 1;
	public static double wilmaHeight = 7;
	
	public static void main(String[] args) {

		//2 semaphores, one for each variable
		//Thread must grab both semaphores to start
		
		Semaphore fredSem = new Semaphore(1);
		Semaphore wilmaSem = new Semaphore(1);
		
		fredSee fredInstance = new fredSee(fredSem, wilmaSem);
		Thread fredThread = new Thread(fredInstance);
		
		wilmaSaw wilmaInstance = new wilmaSaw(fredSem, wilmaSem);
		Thread wilmaThread = new Thread(wilmaInstance);
		
		fredThread.start();
		wilmaThread.start();
		
		
		try {
			fredThread.join();
			wilmaThread.join();
		} catch (InterruptedException e) {
            e.printStackTrace();
        }
		
	}
}
