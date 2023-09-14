import java.util.*;

class Human {
    private String name;
    private int age;
    private String gender;

    public Human(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }
    public String getInfo() {
        return "\nName :" + getName() + "\nAge: " + getAge() + "\nGender: " + getGender();
    }
}

class Student extends Human {
    private int roll;
    private String div;
    private int sem;
    private double cpi;

    public Student(String name, int age, String gender, int roll, String div, int sem, double cpi) {
        super(name, age, gender);
        this.roll = roll;
        this.div = div;
        this.sem = sem;
        this.cpi = cpi;
    }

    public int getRoll() {
        return roll;
    }

    public String getDiv() {
        return div;
    }

    public int getSem() {
        return sem;
    }

    public double getCpi() {
        return cpi;
    }
    @Override
    public String getInfo() {
        return super.getInfo() + "\nRoll No :" + getRoll() + "\nClass: " + getDiv() + "\nSemester: " + getSem() + "\nCPI: " + getCpi();
    }
}

class Faculty extends Human {
    private double salary;
    private String special;

    public Faculty(String name, int age, String gender, double salary, String special) {
        super(name, age, gender);
        this.salary = salary;
        this.special = special;
    }

    public double getSalary() {
        return salary;
    }

    public String getSpecial() {
        return special;
    }
    @Override
    public String getInfo() {
        return super.getInfo() + "\nSalary: " + getSalary() + "\nSpecialization: " + getSpecial();
    }
}

public class Question1 {
    public static void main(String[] args) {
        Student st = new Student("Yash", 19, "Male", 19, "IT", 3, 8);
        Faculty fa = new Faculty("Dr. M. Shirole", 45, "Male", 60000.0, "Information Technology");

        System.out.println("Initial Student Info:" + st.getInfo());
        

        System.out.println("\nInitial Faculty Info:" + fa.getInfo());
        

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new Name and CPI of student:");
        String newName = sc.next();
        double newCpi = sc.nextDouble();

        System.out.println("Enter Updated Faculty salary:");
        double newSalary = sc.nextDouble();

        st = new Student(newName, st.getAge(), st.getGender(), st.getRoll(), st.getDiv(), st.getSem(), newCpi);
        fa = new Faculty(fa.getName(), fa.getAge(), fa.getGender(), newSalary, fa.getSpecial());

        System.out.println("\nUpdated Student Info:" + st.getInfo());
        

        System.out.println("\nUpdated Faculty Info:" + fa.getInfo());
    }
}
