import java.util.HashMap;

class floor extends data{
    private int floor_availability;
    private String name;
    private int id;
    private String floor;
    public floor(String name,int id,String floor){
        super(name,id);
        this.floor=floor;
    }

    public int getFloorAvailability(String floor,data data){
        HashMap<String,Integer> m =data.getFloor_vacancy();
        this.floor_availability=m.get(floor);
        return floor_availability;
    }
    public void new_flr_ava(String floor,int flr_ava,data data){
        data.set_floor_vacancy(floor,flr_ava);
    }


}
