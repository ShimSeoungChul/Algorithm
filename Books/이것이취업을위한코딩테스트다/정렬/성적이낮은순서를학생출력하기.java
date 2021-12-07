import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/*
4
가 3
나 5
다 2
라 1
 */
public class 성적이낮은순서를학생출력하기 {
	public static void main(String[] args){
		class Student implements Comparable<Student>{
			private String name;
			private int age;

			Student(String name, int age){
				this.name = name;
				this.age = age;
			}

			public String getName() {
				return name;
			}

			// 성적이 낮은 순서대로 정렬
			@Override
			public int compareTo(Student o) {
				return this.age - o.age;
			}
		}

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		List<Student> students = new ArrayList<>();

		// 입력
		for(int i = 0; i < num; i++){
			String name = sc.next();
			int score = sc.nextInt();
			students.add(new Student(name, score));
		}

		// 정렬
		Collections.sort(students);
		// students.sort(Student::compareTo);

		// 출력
		students.stream()
			.forEach(student -> System.out.print(student.getName() + " "));
	}


}
