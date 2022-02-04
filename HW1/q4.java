
import java.util.List;


public class q4 {

    

    public void addFront(ArrayList<int> list, int n) {
        for (int i=0; i<n; i++) {
            list.add(i, 1); // a
        }
    }

    public void addEnd(List list, int n) {
        for (int i=n; i>0; i--) {
            list.add(i, 1);
        }
    }

    public void delFront(List list, int n) {
        for (int i=0; i<n; i++) {
            list.remove(i);
        }
    }

    public void delEnd(List list, int n) {
        for (int i=n; i>0; i--) {
            list.remove(i);
        }
    }

    public static void Main(String[] args) {

    }

}
