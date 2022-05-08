package com.skyscraperbuilding.construction.answer1;

import java.util.LinkedList;
import java.util.Scanner;

public class ConstructionofFloors {

	

    private LinkedList <Integer> floorSize;
    
    //total number of floors in the building
    private Integer totalFloors;
    
    // User to provide the input 
    Scanner input;
    public ConstructionofFloors(){
        input= new Scanner(System.in);
    }

    // User should enter the total floors for each day
    public void inputTotalFloors(){
        System.out.println("enter the total no of floors in the building");
        totalFloors= input.nextInt();
    }

    // User should enter the total floors for each day
    public void inputFloorSize() {
        floorSize = new LinkedList<Integer>();
        int day= 1;
        int currentFloorSize;
        while (day<=totalFloors){
            System.out.println("enter the floor size given on a day :"+ day);
            currentFloorSize = input.nextInt();
            floorSize.add (currentFloorSize);
            day++;
        }
    }

    // calling method ot find the order of floor construction
    public void outputFloorConstruction(LinkedList<Integer> floorSize, Integer totalFloors){
    	CaclulatorForDailyFloorConstruction calculator= new CaclulatorForDailyFloorConstruction(floorSize,totalFloors);
        calculator.calculateDailyFloors();
    }

    public void buildingUI (){
        inputTotalFloors();
        inputFloorSize();
        outputFloorConstruction(floorSize, totalFloors);
    }
}
