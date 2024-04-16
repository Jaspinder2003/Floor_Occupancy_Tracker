package project.app.cpsc233project;

/**
 * 
 * @author Yadwinder Singh Dhaliwal @tutorial T05
 * @author Jaspinder Singh Maan @tutorial T15
 * @author Navpreet Singh @tutorial T08
 * @created 2024-04-15
 * 
 */

import java.util.Comparator;

class dataidcomparator implements Comparator<data> {
    public int compare(data D1 ,data D2){
        return Integer.compare(D1.getID(),D2.getID());
    }
}
/**
 * this comparator is used to sort array lists
 */