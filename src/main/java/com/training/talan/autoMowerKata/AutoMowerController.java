package com.training.talan.autoMowerKata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.training.talan.types.Direction;
import com.training.talan.types.Orientation;

public class AutoMowerController {

	private File inputFile;
	private Lawn lawn;


	public AutoMowerController(String inputFileLocation) {
		this.inputFile = new File(inputFileLocation);
		this.lawn = null;
	}




	public void launchMowersProgram() throws IOException  {
		
			BufferedReader br = null;  
			  
			try { 
				  br = new BufferedReader(new FileReader(inputFile));
				  
				  //get upper right corner to get the dimensions of the lawn
				  String upperRightCorner = br.readLine();
				  
				  if (upperRightCorner != null && upperRightCorner.length() == 3) {
					  lawn = new Lawn(Integer.parseInt(upperRightCorner.substring(0, 1)),
							  	Integer.parseInt(upperRightCorner.substring(2)));
				  }
				  
				  
				  // get the position and orientation of the mower
				  String mowerPosition;
				  String instructions;
				  String nextMove;
				  AutoMower autoMower = null;
				  int mowerNumber = 1;
				  
				  while ((mowerPosition = br.readLine()) != null && (instructions = br.readLine()) != null) {
					  
						 autoMower = new AutoMower(Integer.parseInt(mowerPosition.substring(0, 1))
							  , Integer.parseInt(mowerPosition.substring(2 ,3)), 
							  Orientation.valueOf(mowerPosition.substring(4)));
					  
					    for (int i= 0; i < instructions.length(); i++) {
					    	nextMove = String.valueOf(instructions.charAt(i));
					    	if ("R".equals(nextMove.toUpperCase()) ||
					    			"L".equals(nextMove.toUpperCase())) {
					    		autoMower = changeOrientation(autoMower, Direction.valueOf(nextMove));
					    	}else if("F".equals(nextMove.toUpperCase())) {
					    		autoMower = moveForword(autoMower, lawn);
					    	}
					    }
					
					  // Mower has finished  
					  System.out.println("The final position of mower number "+ mowerNumber + " is : " + autoMower.getFinalPosition());
					  mowerNumber ++;
					 
				  }
					  
				  
				  
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(br != null)
					br.close();
			}		
			
	}


	public AutoMower changeOrientation(AutoMower autoMower, Direction d) {
	
		switch (autoMower.getO()){
		case N :
			if (d.equals(Direction.L))
				autoMower.setO(Orientation.W);
			else if (d.equals(Direction.R))
				autoMower.setO(Orientation.E);
			break;
		case E :
			if (d.equals(Direction.L))
				autoMower.setO(Orientation.N);
			else if (d.equals(Direction.R))
				autoMower.setO(Orientation.S);
			break;
		case W :
			if (d.equals(Direction.L))
				autoMower.setO(Orientation.S);
			else if (d.equals(Direction.R))
				autoMower.setO(Orientation.N);
			break;
		case S :
			if (d.equals(Direction.L))
				autoMower.setO(Orientation.E);
			else if (d.equals(Direction.R))
				autoMower.setO(Orientation.W);
			break;
		}

		return autoMower;
	}
	
	public AutoMower moveForword(AutoMower autoMower, Lawn lawn) {
		
		switch (autoMower.getO()){
		case N :
			if(autoMower.getY() < lawn.getLawnHeight())
				autoMower.setY(autoMower.getY() + 1);
			break;
		case E :
			if(autoMower.getX() < lawn.getLawnWidth())
				autoMower.setX(autoMower.getX() + 1);
			break;
		case W :
			if(autoMower.getX() > 0)
				autoMower.setX(autoMower.getX() - 1);
			break;
		case S :
			if(autoMower.getY() > 0) 
				autoMower.setY(autoMower.getY() - 1);
			break;
		}

		return autoMower;
	}


	public File getInputFile() {
		return inputFile;
	}




	public void setInputFile(File inputFile) {
		this.inputFile = inputFile;
	}




	public Lawn getLawn() {
		return lawn;
	}




	public void setLawn(Lawn lawn) {
		this.lawn = lawn;
	}
	
}
