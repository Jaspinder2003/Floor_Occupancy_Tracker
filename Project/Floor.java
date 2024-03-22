import java.util.HashMap;

class floor extends data{
    private int floor_availability;
    private String name;
    private int id;
    private int floor;
    public floor(String name,int id,int floor){
        super(name,id);
        this.floor=floor;
    }

    public int getFloorAvailability(data data){
        HashMap<Integer,Integer> m =data.getFloor_vacancy();
        if (!m.containsKey(floor)) {
            throw new IllegalArgumentException("Floor does not exist.");
        }
        this.floor_availability=m.get(this.floor);
        return floor_availability;
    }
    public void new_flr_ava(int flr_ava,data data){
        data.set_floor_vacancy(this.floor,flr_ava);
    }


}
