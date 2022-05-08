package com.skyscraperbuilding.construction.answer1;

import java.util.LinkedList;
import java.util.Collections;


public class SortingofFloors {

	private LinkedList<Integer> floorSize;

    // get the size of floors and creating clone of this LL by constructor
    public SortingofFloors(LinkedList<Integer> floorSize) {
        this.floorSize = (LinkedList<Integer>) floorSize.clone();
    }

    // method using inbuilt function to sort the clone LL and return the same
    public LinkedList<Integer> sortingFloorsDescending(){
        Collections.sort(floorSize);
        return floorSize;
    }
}
