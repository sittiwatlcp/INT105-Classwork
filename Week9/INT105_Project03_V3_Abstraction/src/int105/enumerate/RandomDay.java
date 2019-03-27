package int105.enumerate;

import int105.abstraction.HasNext;
import java.util.Random;

public class RandomDay implements HasNext<DayOfWeek> {
    
    private static final DayOfWeek[] DAYS = DayOfWeek.values();

    @Override
    public DayOfWeek next() {
        Random r = new Random();
        return DAYS[r.nextInt(DAYS.length)];
    }
}
