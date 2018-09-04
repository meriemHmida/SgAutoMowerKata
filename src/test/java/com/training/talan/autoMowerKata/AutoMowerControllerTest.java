package com.training.talan.autoMowerKata;

import java.io.IOException;

import com.training.talan.types.Direction;
import com.training.talan.types.Orientation;

import junit.framework.TestCase;

public class AutoMowerControllerTest extends TestCase {

	String inputFileLocation = "C:\\Users\\may\\eclipse-workspace\\autoMowerKata\\src\\inputs\\inputFile.txt";
	AutoMowerController  amc = new AutoMowerController(inputFileLocation);

	public void testLaunchMowersProgram() {
		try {
			amc.launchMowersProgram();
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void testChangeOrientation1() {
		AutoMower autoMower = new AutoMower(3, 4, Orientation.S);
		
		amc.changeOrientation(autoMower, Direction.R);
		
		assertEquals("3 4 W", autoMower.getFinalPosition());
	}
	
	public void testChangeOrientation2() {
		AutoMower autoMower = new AutoMower(3, 4, Orientation.S);
		
		amc.changeOrientation(autoMower, Direction.L);
		
		assertEquals("3 4 E", autoMower.getFinalPosition());
		
		amc.changeOrientation(autoMower, Direction.L);
		
		assertEquals("3 4 N", autoMower.getFinalPosition());
	}

	public void testMoveForword() {
		
		AutoMower autoMower = new AutoMower(3, 4, Orientation.E);
		
		Lawn lawn = new Lawn(9, 6);
		
		amc.moveForword(autoMower, lawn);
		
		assertEquals("4 4 E", autoMower.getFinalPosition());
		
		amc.changeOrientation(autoMower, Direction.L);
		amc.moveForword(autoMower, lawn);
		
		assertEquals("4 5 N", autoMower.getFinalPosition());
		
		amc.moveForword(autoMower, lawn);
		amc.moveForword(autoMower, lawn);
		amc.moveForword(autoMower, lawn);
		
		assertEquals("4 6 N", autoMower.getFinalPosition());
		
		amc.changeOrientation(autoMower, Direction.L);
		amc.moveForword(autoMower, lawn);
		
		assertEquals("3 6 W", autoMower.getFinalPosition());
	}

}
