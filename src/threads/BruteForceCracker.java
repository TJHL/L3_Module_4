package threads;

// Below is a completed program that uses brute force to crack a 9-digit passcode. 
// On average, the program takes about 0.125 seconds to find the passcode.
// Your goal is to re-write the algorithm using Threads. Try to shorten the time it takes 
// to find the code to be as little as possible.
// Let's see who can crack the code the fastest!

// Pro-tip: Do not include the creation of the threads as part of the time. 

import java.util.Random;

public class BruteForceCracker {
	static long code = (long) (new Random().nextDouble() * 1_000_000_000);

	static long startTime;
	static long endTime;
	static float elapsedTime;

	public static void main(String[] args) {
		System.out.println("Starting Brute Force Checker");
	
		Thread FourthCheck = new Thread(() -> {
			for (int i = 0; i<250000000; i++) {
				if(checkCode(i)) {
					endTime = System.currentTimeMillis();
				}
			}
		});
		Thread HalfCheck = new Thread(() -> {
			for (int i = 250000000; i<500000000; i++) {
				if(checkCode(i)) {
					endTime = System.currentTimeMillis();
				}
			}
		});
		Thread ThreeCheck = new Thread(() -> {
			for (int i = 500000000; i<750000000; i++) {
				if(checkCode(i)) {
					endTime = System.currentTimeMillis();
				}
			}
		});
		Thread FinalCheck = new Thread(() -> {
			for (int i = 750000000; i<1000000001; i++) {
				if(checkCode(i)) {
					endTime = System.currentTimeMillis();
				}
			}
			
		});
		
		startTime = System.currentTimeMillis();
		
		FourthCheck.start();
		HalfCheck.start();
		ThreeCheck.start();
		FinalCheck.start();
		
		try {
			FourthCheck.join();
			HalfCheck.join();
			ThreeCheck.join();
			FinalCheck.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		elapsedTime = (float) (endTime - startTime);
		elapsedTime /= 1000.f;
		System.out.println("Total time taken: " + elapsedTime + " seconds");
	}

	public static boolean checkCode(long p) {
		if (p == code) {
			return true;
		} else {
			return false;
		}
	}
}
