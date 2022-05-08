package com.skyscraperbuilding.construction.answer1;

import java.util.LinkedList;

public class CaclulatorForDailyFloorConstruction {
	
	//the distinct size of the floors which will be factories to the on the ith day
    private LinkedList <Integer> floorSize;
    
    //total number of floors in the building
    private Integer totalFloors;
    
    //floor's size in sorted order
    private LinkedList <Integer> sortedFloorSize;

    // called the constructor
    public CaclulatorForDailyFloorConstruction(LinkedList<Integer> floorSize, Integer totalFloors) {
    	
        this.floorSize = floorSize;
        this.totalFloors = totalFloors;
    }

    // to find the size for floor which constructed in every day    
    public void calculateDailyFloors(){

        // finds the sorted order of floor size
        SortingofFloors sorted= new SortingofFloors(floorSize);
        sortedFloorSize = sorted.sortingFloorsDescending();

        // size for for those floors which already constructed bu not assembled as the larger floor is not ready
        LinkedList <Integer> pastFloors= new LinkedList<Integer>();

        // index for the current maximum floor size
        int index_of_max=totalFloors-1;
        
        // current maximum floor size
        int current_max= sortedFloorSize.get(index_of_max);
        
        // stores the ith day
        int day=1;
        System.out.println("Contruction order-------");

        // loop for total number of floors and total number of days
        while (day<=totalFloors){
            System.out.println("Day: "+day);

            // current max floor size delivered on the day stored in var "day"
            if (current_max== floorSize.get(day-1)){

                // printing max(floorsize) if matched then searches for subsequent maximum floor sizes from past floor size list
                System.out.print (current_max+" ");
                if (index_of_max>0){
                    index_of_max--;
                    current_max= sortedFloorSize.get(index_of_max);
                    while (pastFloors.contains(current_max)){

                        //printing the past floor size which can be assembled now, if found
                        System.out.print (current_max+" ");
                        if (index_of_max>0){
                            index_of_max--;
                            current_max= sortedFloorSize.get(index_of_max);
                        }
                        else
                            break;
                    }
                }
            }
            else
            {
                // if current max floor size is not equal to the present day floor size then stored in linkedlist of the pass floor for assembling in coming days
                pastFloors.add(floorSize.get(day-1));
            }
            day++;
        }
    }
}
