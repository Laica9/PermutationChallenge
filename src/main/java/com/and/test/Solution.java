package com.and.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Ioanna Pashalidi Kozelj
 */
public class Solution {
    /**
     * This method takes string,checks whether there are valid integers, 
     * then converts the string to an array. Calls the method to find the combinations until 
     * it is done and adds it to resultList array for the display. 
     * @param input, input string to find all the possible combinations 
     * @return returns the string of all possible integer combinations 
     * @throws NumberFormatException, if there is invalid input
     */
    public static String solution(String input) throws NumberFormatException {
    	
    	String returnStr = null;
    	input = input.replaceAll("\\D+", "");
    	
    	// NumberFormatException is thrown if there is no valid integer.
    	try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException Occurred."
            		+ " No Valid Numbers");
        }
    	
    	
    	ArrayList<Character> currentArr = new ArrayList<Character>(); // Converts given String to char array
        for (char c : input.toCharArray()) { 
        	currentArr.add(c); 
        } 
        Collections.sort(currentArr); 
        ArrayList<String> resultList =  new ArrayList<String>(); // Creates new array list for results
        premuteString(0, currentArr, resultList); // Call method
        
        String[] result = resultList.toArray(new String[0]);
        Arrays.sort(result, Collections.reverseOrder()); // Sorts final array in descending order
        
        for (String object : result) {
        	returnStr = object + " ";
        	System.out.print(returnStr);
        }
        return returnStr;
    } 
        
    /**
     * This method contains permutation function using recursion where it iterates 
     * through a given array, gets the position index and swaps the element 
     * with the next element calling the swap method.
     * @param pos, position of an element
     * @param currentArr, current array that is being processed 
     * @param resultList, final array
     */
    public static void premuteString(int pos, ArrayList<Character> currentArr, ArrayList<String> resultList) {
    	if (currentArr.size()-1 == pos) { 
            String str = ""; 
            for (char c : currentArr){ 
                str+= c; 
            } 
            resultList.add(str); 
        }else { 
            for (int i=pos;i<currentArr.size() ;i++) { 
                if (i!= (currentArr.size()-1) && currentArr.get(i) == currentArr.get(i+1)) { 
                    continue; 
                } 
                 
                swap(i, pos, currentArr); // Calls method to swap character at index
                premuteString(pos+1, currentArr, resultList); // Keeps moving to next position
                swap(i, pos, currentArr); 
            } 
        } 
	}

    /**
     * This method swaps the element of specified index with another element
     * @param i, initial position
     * @param j
     * @param Arrlist, swap in a given ArrayList
     */
    public static void swap(int i, int j, ArrayList<Character> arrlist) {
    	char temp = arrlist.get(i); 
    	arrlist.set(i, arrlist.get(j)); 
    	arrlist.set(j, temp); 
	}

	public static void main(String args[]) {
		solution("A 3B2 C6D");
    }

}