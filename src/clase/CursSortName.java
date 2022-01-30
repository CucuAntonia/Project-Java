package clase;

import java.util.Comparator;

public class CursSortName implements Comparator<Curs> {
    @Override
    public int compare(Curs o1, Curs o2) {
        int r = o1.getNume().compareTo(o2.getNume());
        return r;

    }
}
