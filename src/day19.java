import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class day19 {
    public static void main(String[] args) {
        List<Integer> dataArray = new ArrayList<>();
        dataArray.add(188);
        dataArray.add(162);
        dataArray.add(168);
        for(Integer data : dataArray)
            System.out.print(data + " ");
        System.out.println();
        dataArray.sort(Comparator.reverseOrder());  // Ctrl+b
        for(Integer data : dataArray)
            System.out.print(data + " ");

    }
}
