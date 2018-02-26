package threads;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One
	// robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String[] args) {
		Robot one = new Robot(200, 400);
		Robot two = new Robot(500, 400);
		Robot three = new Robot(800, 400);
		Robot four = new Robot(350, 600);
		Robot five = new Robot(650, 600);

		one.penDown();
		two.penDown();
		three.penDown();
		four.penDown();
		five.penDown();

		one.setPenColor(Color.BLUE);
		two.setPenColor(Color.BLACK);
		three.setPenColor(Color.RED);
		four.setPenColor(Color.YELLOW);
		five.setPenColor(Color.GREEN);

		one.setSpeed(10);
		two.setSpeed(10);
		three.setSpeed(10);
		four.setSpeed(10);
		five.setSpeed(10);

		Thread BOTone = new Thread(() -> {
			Circle(one);
		});
		Thread BOTtwo = new Thread(() -> {
			Circle(two);
		});
		Thread BOTthree = new Thread(() -> {
			Circle(three);
		});
		Thread BOTfour = new Thread(() -> {
			Circle(four);
		});
		Thread BOTfive = new Thread(() -> {
			Circle(five);
		});

		BOTone.start();
		BOTtwo.start();
		BOTthree.start();
		BOTfour.start();
		BOTfive.start();
	}

	static void Circle(Robot turning) {
		for (int i = 0; i < 360; i++) {
			turning.move(4);
			turning.turn(1);
		}
	}
}
