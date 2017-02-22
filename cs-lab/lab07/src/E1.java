import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class E1 {

	public static void main(String [] str) {
		Collection<String> set = new HashSet<String>();
		
		boolean ret;
		
		set.add("aaa");
		set.add("bbb");
		set.add("ccc");
		ret = set.add("aaa");
		
		if(!ret) {
			System.err.println("Error duplicated");
		}
		
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		///////////////////////////////////
		Collection<Student> setStudents = new HashSet<Student>();
		Student s = new Student("S0", 11);
		setStudents.add(s);
		setStudents.add(new Student("S1", 10));
		setStudents.add(new Student("S2", 10));
		setStudents.add(new Student("S3", 10));
		setStudents.add(new Student("S1", 10));
		setStudents.add(s);
		
		Iterator<Student> itS = setStudents.iterator();
		while(itS.hasNext()) {
			Student st = itS.next();
			System.out.println(st);
			System.out.println(st.equals(st));
			System.out.println(((Student)st).equals(st));
		}
	}
}
