import java.util.Comparator;

class dataidcomparator implements Comparator<data> {
    public int compare(data D1 ,data D2){
        return Integer.compare(D1.getID(),D2.getID());
    }
}
/**
 * this comparator is used to sort array lists
 */