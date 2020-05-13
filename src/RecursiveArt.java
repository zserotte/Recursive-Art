import java.awt.*;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;
import processing.core.PApplet;
/*
 * Recursive Art
 * 
 * This program draws some pretty pictures
 * using recursion
 */

public class RecursiveArt extends PApplet {

	/*
	 * The setup sets the initial size, 
	 * adds smoothing (for pixelated lines)
	 * and noStroke, which takes out outlines of shapes.
	 * This method is called once - when the program starts.
	 */
	public void setup() {
		size(800,800);
		smooth();
		noStroke();
	}

	/*
	 * The draw program is called many times a second.
	 * It draws shapes to the screen.
	 * 
	 * The art should still be correct when the window is resized.
	 */
	public void draw() {
		// Draw background first.
		background(255,255,255);
		// Draw the target
		makeTarget(width/2, height/2);
		// Draw the "dream catcher"
		makeDreamCatcher(width / 2, height / 2, 200, 200, 200, 200);
		// Draw the triangles
		makeTriangle(0, height / 2, width / 2, height / 2);
		// Draw whatever you want as long as its recursive.
		makeMyOwnRecursion(600, 500, 700, 600, 600, 700, 500, 600, 200, 200);
		
	}
	
	public void makeTarget(int width, int height) {
		if (width < 1 || height < 1){
			// does nothing
		}
		else {
			ellipseMode(CENTER);
			fill(255, 0, 0);
			ellipse(200, 200, width, height);
			fill(0, 0, 255);
			ellipse(200, 200, width - 50, height - 50);
			makeTarget(width - 100, height - 100);
		}
	}
	
	public void makeDreamCatcher(int height, int width, int y1, int x2, int y3, int x4) {
		if (height < 1 || width < 1 ) {
			// do nothing
		}
		else {
			rectMode(CENTER);
			fill (128, 0, 128);
			rect(600, 200, height, width);
			fill(255, 255 ,255);
			quad(600, 200 - y1, 600 + x2, 200, 600, 200 + y3, 600 - x4, 200);
			makeDreamCatcher(height / 2, width / 2, y1 / 2, x2 / 2, y3 / 2, x4 /2);
		}
	}
		
	public void makeTriangle(int xCoordinate, int yCoordinate, int width, int  height) {
		if (width <= 20) {
			fill(255, 255, 0);
			triangle(xCoordinate, yCoordinate, xCoordinate, yCoordinate + height, xCoordinate + width, yCoordinate + height);
			fill(0, 0, 255);
			triangle(xCoordinate, yCoordinate, xCoordinate + width, yCoordinate, xCoordinate + width, yCoordinate + height);
		}
		else {
			fill(255, 255, 0);
			triangle(xCoordinate, yCoordinate, xCoordinate, yCoordinate + height, xCoordinate + width, yCoordinate + height);
			fill(0, 0, 255);
			triangle(xCoordinate, yCoordinate, xCoordinate + width, yCoordinate, xCoordinate + width, yCoordinate + height);
			makeTriangle(xCoordinate, yCoordinate, width / 2, height / 2);
			makeTriangle(xCoordinate + (width / 2), yCoordinate, width / 2, height / 2);
			makeTriangle(xCoordinate + (width / 2), yCoordinate + height / 2, width / 2, height / 2);
		}
	}

	public void makeMyOwnRecursion(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int width, int height) {
		if (height < 1 || width < 1) {
			// do nothing
		}
		else {
			fill(255, 0, 0);
			ellipse(x1, y1, width, height);
			fill(0, 0, 255);
			ellipse(x2, y2, width, height);
			fill(0, 255, 0);
			ellipse(x3, y3, width, height);
			fill(255, 255, 0);
			ellipse(x4, y4, width, height);
			makeMyOwnRecursion(x4, y4, x1, y1, x2, y2, x3, y3, width / 2, height / 2);
		}
	}
}
