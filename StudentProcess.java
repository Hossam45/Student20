package Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StudentProcess {
	
	private static StudentObject[] students = {
			new StudentObject("Hossam", "Hassan", 70.6,"programmer"),
			new StudentObject("Max", "Hassan", 88.2, "programmer"),
			new StudentObject("Hany","Hassan",28.1,"nothing"),
			new StudentObject("Mama","Hassan", 94.0,"everything")
	};
    private static List<StudentObject> student_list = Arrays.asList(students);
    
    public static void task1() {
    	System.out.println("Task1\n");
    	student_list.forEach(System.out::println);
    	System.out.println("\n");
    	
    }
    
    public static void task2() {
    	System.out.println("Task2\n");
    	System.out.println("Student who get 50.0 _ 100.0 Sorted by grade");
    	student_list.stream().filter(g->g.getGrade() >= 50).sorted(Comparator.comparing(StudentObject::getGrade)).forEach(s->System.out.println(s));
    	System.out.println("\n");
    }
    
    public static void task3() {
    	System.out.println("\n");
    	System.out.println("the first Student get 50.0 _ 100.0 ");
    	Optional<StudentObject> firstStudent = student_list.stream().filter(g->g.getGrade() >= 50).findFirst();
    	
    	System.out.println(firstStudent.get());
    	System.out.println("\n");
    }
    
    public static void task4() {
    	System.out.println("Task4\n");
    	System.out.println("Students in ascendding order by last name then first name : \n");
    	System.out.println("________________________________");
    	student_list.stream().sorted(Comparator.comparing(StudentObject::getLastname).thenComparing(StudentObject::getFirstname)).forEach(s->System.out.println(s));
    	
    	System.out.println("________________________________");
    	
    	System.out.println("Students in descending order by last name then first");
    	System.out.println("_______________________________");
    	student_list.stream().sorted(Comparator.comparing(StudentObject::getLastname).thenComparing(StudentObject::getFirstname).reversed()).forEach(s->System.out.println(s));
    	System.out.println("_______________________________");
    	
    }
    public static void task5() {
    	System.out.println("task5\n");
    	System.out.println("Uniqe Students by List Name");
    	student_list.stream().sorted(Comparator.comparing(StudentObject::getLastname)).map(StudentObject::getFirstname).distinct().forEach(s->System.out.println(s));
    	System.out.println("\n");
    }
    
    public static void task6() {
    	System.out.println("Task6\n");
    	System.out.println("Student names order by last name and then first name\n");
    	student_list.stream().sorted(Comparator.comparing(StudentObject::getLastname).thenComparing(StudentObject::getFirstname)).map(StudentObject::getName).forEachOrdered(s ->System.out.println(s));
    	System.out.println("\n");
    }
    
    public static void task7() {
    	System.out.println("task7\n");
    	System.out.println("Students by departments");
    Map<String,List<StudentObject>> map = student_list.stream().collect(Collectors.groupingBy(s ->s.getDepartment()));
    map.forEach((s,a) ->{
    	System.out.print(s + "\n");
    	a.forEach(q->System.out.print("\t" + q));
    });
    	System.out.println("\n");
    	
    }
    public static void task8() {
    	System.out.println("task8\n");
    	System.out.println("Count of student deparments");
    	Map<String,Long> map = student_list.stream().collect(Collectors.groupingBy(s-> s.getDepartment(),TreeMap::new,Collectors.counting()));
    	map.forEach((s,a) ->System.out.println(s + " has " + a + "Student(s)"));
    	System.out.println("\n");
    }
    
    public static void task9() {
    	System.out.println("Task9\n");
    	Double grades = student_list.stream().mapToDouble(StudentObject::getGrade).sum();
    	System.out.println("Sum of Students Grades : " + grades + "\n");
    	System.out.println("\n");
    }
    public static void task10() {
    	
    	System.out.println("Task10\n");
    	Double average = student_list.stream().mapToDouble(StudentObject::getGrade).average().orElse(0.0);
    	System.out.println("Average from the Student geades :  " + average + "\n");
    	System.out.println("\n");
    	
    }
	public static void main(String[] args) {
		
		task1();
		task2();
		task3();
		task4();
		task5();
		task6();
		task7();
		task8();
		task9();
		task10();
		
		

	}

}




















