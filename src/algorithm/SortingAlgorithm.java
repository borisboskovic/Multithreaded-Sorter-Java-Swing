/***********************************************************************
 * Module:  SortingAlgorithm.java
 * Author:  Milica Milosevic, Boris Boskovic
 * Purpose: Defines the Interface SortingAlgorithm
 ***********************************************************************/

package algorithm;

import java.util.ArrayList;

public interface SortingAlgorithm {
   /** @param args */
   public long sort(String[] args);
   
   public ArrayList<Integer> getArray();
   
   public void setArray(ArrayList<Integer> array);

}