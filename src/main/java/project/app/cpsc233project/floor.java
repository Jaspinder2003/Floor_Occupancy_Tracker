package project.app.cpsc233project;
import java.util.HashMap;
import java.util.HashSet;

class floor extends data{
    private int floor_availability;
    private String name;
    private int id;
    private int floor;

    private String area;

    static HashSet<floor> floorObjects = new HashSet<floor>(); 


    public floor(String name,int id,int floor, String area){
        super(name,id, floor, area);
        this.name=name;
        this.id=id;
        this.floor=floor;
        this.area=area;
    }//constructor

    public Integer getFloor(){
        return floor;
    }//used to get floor

    public static void AddUser(floor floor) {
        floorObjects.add(floor);
    }//used to add user to a hashset

    public String toCsvString() {
        return "Floor," + id + "," + name + "," + floor + "," + area;
    }//used to convert the object into a csv string

    public int getFloorAvailability(Integer floor,data data){
        HashMap<Integer,Integer> m =data.getFloor_vacancy();
        this.floor_availability=m.get(floor);
        return floor_availability;
    }
/**
 * usde to get the floor availability and is used in multipole classes like sign in, sign out and stats
 */

    public void new_flr_ava(Integer floor,int flr_ava,data data){
        data.set_floor_vacancy(floor,flr_ava);
    }
/**
 * used to set new floor availability
 */

}
