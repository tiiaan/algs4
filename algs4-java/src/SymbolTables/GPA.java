package SymbolTables;

public class GPA {
    public static void main(String[] args) {
        ST<String, Double> grades = new ST<String, Double>();
        grades.put("A",  4.00);
        grades.put("B",  3.00);
        grades.put("C",  2.00);
        grades.put("D",  1.00);
        grades.put("F",  0.00);
        grades.put("A+", 4.33);
        grades.put("B+", 3.33);
        grades.put("C+", 2.33);
        grades.put("A-", 3.67);
        grades.put("B-", 2.67);

        int n = 0;
        double total = 0.0;
        for (int n = 0; !StdIn.isEmpty(); n++) {
            String grade = StdIn.readString();
            double value = grades.get(grade);
            total += value;
        }
        double gpa = total / n;
        StdOut.println("GPA = " + gpa);
    }
}
