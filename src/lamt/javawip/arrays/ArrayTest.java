package lamt.javawip.arrays;

import java.util.Arrays;
import java.util.List;

public class ArrayTest {

    public static void main(String[] args) {
        
        List<String> data = Arrays.asList("1", "2", "3");
        String[] dataArr = data.toArray(new String[data.size()]);
        for (String dstring : dataArr) {
            System.out.println(dstring);
        }
    }

}
