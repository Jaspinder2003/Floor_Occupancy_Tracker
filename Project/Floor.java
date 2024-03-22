import java.util.HashMap;
import java.util.HashSet;

class floor extends data{
    private int floor_availability;
    private String name;
    private int id;
    private int floor;

    private static HashSet<floor> floorObjects = new HashSet<floor>(); 


    public floor(String name,int id,int floor){
        super(name,id);
        this.floor=floor;
    }

    public Integer getFloor(){
        return floor;
    }

    public static void AddUser(floor floor) {
        floorObjects.add(floor);
    }

    public int getFloorAvailability(Integer floor,data data){
        HashMap<Integer,Integer> m =data.getFloor_vacancy();
        this.floor_availability=m.get(floor);
        return floor_availability;
    }
    public void new_flr_ava(Integer floor,int flr_ava,data data){
        data.set_floor_vacancy(floor,flr_ava);
    }


}
