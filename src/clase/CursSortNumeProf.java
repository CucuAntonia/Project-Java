package clase;

import java.util.Comparator;

public class CursSortNumeProf implements Comparator<Curs> {
    @Override
    public int compare(Curs o1, Curs o2) {
        int r = o1.getProfu().nume.compareTo(o2.getProfu().nume);
        if (r==0)
        {
            int r2 = o1.getProfu().prenume.compareTo(o2.getProfu().prenume);
            return r2;
        }
        else
            return r;
    }
}
