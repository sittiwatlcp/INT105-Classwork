package int105.enumerate;

import int105.abstraction.HasNext;

public enum DayOfWeek implements HasNext<DayOfWeek> {
    SUNDAY(false),
    MONDAY(true),
    TUESDAY(true),
    WEDNESDAY(true),
    THURSDAY(true),
    FRIDAY(true),
    SATURDAY(false);

    private boolean midweek;
    private final boolean weekday;
    //private final static DayOfWeek[] VALUES = DayOfWeek.values();

    static {
        SUNDAY.midweek = false;
        MONDAY.midweek = false;
        TUESDAY.midweek = false;
        WEDNESDAY.midweek = true;
        THURSDAY.midweek = false;
        FRIDAY.midweek = false;
        SATURDAY.midweek = false;
    }

    private DayOfWeek(boolean weekday) {
        this.weekday = weekday;
    }

    public boolean isWeekday() {
        return weekday;
    }

    public boolean isMidweek() {
        return midweek;
    }

    public DayOfWeek next() {
        switch (this) {
            case SUNDAY:
                return MONDAY;
            case MONDAY:
                return TUESDAY;
            case TUESDAY:
                return WEDNESDAY;
            case WEDNESDAY:
                return THURSDAY;
            case THURSDAY:
                return FRIDAY;
            case FRIDAY:
                return SATURDAY;
            case SATURDAY:
                return SUNDAY;
        }
        return null;
        //return VALUES[(this.ordinal()+1)%VALUES.length];
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(name()).append(" ");
        if (midweek) {
            s.append("(midweek)");
        } else if (!weekday) {
            s.append("(holiday)");
        }
        return s.toString();
    }

    public String shortForm() {
        return name().substring(0, 3);
    }
}
