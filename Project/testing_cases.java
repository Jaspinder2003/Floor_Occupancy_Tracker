import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;

class tests {



@org.junit.jupiter.api.Test
    public void floortest1() {
    data D1=new data("hi",1234);
    data D2=new data("hello",12345);
    D1.set_floor_vacancy(1,23);
    floor floor=new floor("hi",1234,1);
    int a = floor.getFloorAvailability(D1);
    floor.new_flr_ava(24,D1);
    a=floor.getFloorAvailability(D2);
    assertEquals(24,a);
    }

    @org.junit.jupiter.api.Test
    public void floortest2() {
        data D1=new data("hi",1234);
        D1.set_floor_vacancy(1,23);
        floor floor=new floor("hi",1234,4);
        int a = floor.getFloorAvailability(D1);
        assertThrows(IllegalArgumentException.class, () -> {
            floor.getFloorAvailability(D1);
        }, "Expected getFloorAvailability to throw IllegalArgumentException for non-existent floor.");
    }

    @org.junit.jupiter.api.Test
    public void Comptest1() {
        data D1=new data("hi",1234);
        data D2=new data("hello",12345);
        D1.set_computer_vacancy(1,23);
        Computers computer=new Computers("hi",1234,1);
        int a = computer.getComputerAvailability(D1);
        computer.new_computer_ava(30,D2);
        a=computer.getComputerAvailability(D1);
        assertEquals(30,a);
    }

    @org.junit.jupiter.api.Test
    public void Comptest2() {
        data D1=new data("hi",1234);
        D1.set_computer_vacancy(1,23);
        Computers computer=new Computers("hi",1234,4);
        int a = computer.getComputerAvailability(D1);
        assertThrows(IllegalArgumentException.class, () -> {
            computer.getComputerAvailability(D1);
        }, "Expected getComputer availability to throw IllegalArgumentException for non-existent floor.");
    }

    @org.junit.jupiter.api.Test
    public void comparatorTest() {
        data D1=new data("hi",1);
        data D2=new data("hello",5);
        data D3=new data("hey",6);
        ArrayList<data> lst=new ArrayList<>();
        lst.add(D3);
        lst.add(D1);
        lst.add(D2);
        Collections.sort(lst,new dataidcomparator());
        assertEquals(1,lst.get(0).getID());
        assertEquals(5,lst.get(1).getID());
        assertEquals(6,lst.get(2).getID());
    }

   @org.junit.jupiter.api.Test
    public void gridformatTest() {
        data D1=new data("hi",1);
        data D2=new data("hello",3);
        data D3=new data("hey",4);
        data D4=new data("hmm",2);
        data D5=new data("yes!!",5);
        ArrayList<data> name = new ArrayList<>();
        name.add(D1);
        name.add(D2);
        name.add(D3);
        name.add(D4);
        name.add(D5);
        stats formatter=new stats();
        String Grid = formatter.formatAsGrid(name);
        String a="[hi] [hello] [hey] [hmm]\n[yes!!]";
        assertEquals(a,Grid);
        Collections.sort(name,new dataidcomparator());
        String Grid2=formatter.formatAsGrid(name);
        String b="[hi] [hmm] [hello] [hey]\n[yes!!]";
        assertEquals(b,Grid2);
    }


    }



