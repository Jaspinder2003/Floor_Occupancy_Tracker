public class test {
    int[] indexKeeper = {10, 20, 21, 22, 50};
    
  
    for (int i = 0; i < indexKeeper.length - 1; i++) {
        if (indexKeeper[i] + 1 == indexKeeper[i + 1]) {
            isConsecutive++;
        } else {
            break; // Exit the loop if the next element is not consecutive
        }
    }
    System.out.println("this is "+isConsecutive);
}
