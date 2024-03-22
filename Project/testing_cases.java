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
//jaspinder singh maan


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
