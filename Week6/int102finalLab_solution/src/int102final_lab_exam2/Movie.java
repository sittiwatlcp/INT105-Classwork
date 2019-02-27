package int102final_lab_exam2;

import java.util.Comparator;

/**
 * Movie class ภาพยนตร์ มี title, hours, grade
 */
public class Movie implements Comparable<Movie>{

    private final String title; // ชื่อภาพยนตร์
    private final double hours; // ความยาวของภาพยนตร์เป็นชั่วโมง
    private final int grade; // ระดับคุณภาพเป็นเกรดของภาพยนตร์ 1 คือ ดีมาก; 5 คือ แย่มาก

    public Movie(String title, double hours, int grade) throws NewMovieException {
        if(title == null || hours <= 0 || grade < 1 || grade > 5)
            throw new NewMovieException();
        
        this.title = title;
        this.hours = hours;
        this.grade = grade;
    }
    
    private static class NameComparator implements Comparator<Movie>{

        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.title.compareTo(o2.title);
        }
        
    }
    
    private static Comparator<Movie> nameComparator = new NameComparator();

    public String getTitle() {
        return title;
    }

    public double getHours() {
        return hours;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return String.format("Movie: %s (%.2f hours, grade:%d)", title, hours, grade);
    }

    public boolean equals(Movie m) {
        return m != null && this.title.equals(m.title) && this.hours == m.hours && this.grade == m.grade;
    }

    @Override
    public int compareTo(Movie m) {
        if (m == null) {
            throw new IllegalArgumentException();
        }
        int val = this.grade - m.grade;
        return (val > 0) ? -1 : (val < 0) ? 1 : 0;
    }

}
