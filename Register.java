package pendelum_pack;
import java.util.*;

public class Register {
	List<Student> stuReg = new ArrayList<Student>();
	List<Course> courReg = new ArrayList<Course>();
	
	public boolean checkStuReg(Student student) {
		int k = 0;
		for(int i = 0; i < stuReg.size(); i++) {
			if(stuReg.get(i).getsID() == student.getsID()) {
				k = 1;
			}
		}
		if(k == 1) {
			return true;
		} else {
			return false;
		}
	}
	public boolean addStuReg(Student student) {
		if(!checkStuReg(student)) {
			stuReg.add(student);
			StudentCRUD.create(student);
			return true;
		}
		return false;
	}
	public boolean updateStuReg(String sID) {
		for(int i = 0; i < stuReg.size(); i++) {
		if(stuReg.get(i).getsID() == sID) {
			StudentCRUD.update(stuReg.get(i));
			stuReg = StudentCRUD.retrieveAll();
			return true;
		}
		}
		return false;
	}
	public Student retrieveStuReg(String sID) {
		for(int i = 0; i < stuReg.size(); i++) {
			if(stuReg.get(i).getsID() == sID) {
				return stuReg.get(i);
			}
		}
		return null;
	}
	public boolean deleteStuReg(String sID) {
		
		for(int i = 0; i < stuReg.size(); i++) {
			if(stuReg.get(i).getsID() == sID) {
				StudentCRUD.delete(sID);
				stuReg.remove(i);
				return true;
			}
		}
		return false;
	}
	public boolean retrieveAllStuReg() {
		if(StudentCRUD.retrieveAll() != null) {
			return true;
		}
		return false;
	}
	
	public boolean checkCourReg(Course course) {
		int k = 0;
		for(int i = 0; i < courReg.size(); i++) {
			if(courReg.get(i).getcID() == course.getcID()) {
				k = 1;
			}
		}
		if(k == 1) {
			return true;
		} else {
			return false;
		}
	}
	public boolean addStuReg(Course course) {
		if(!checkCourReg(course)) {
			courReg.add(course);
			CourseCRUD.create(course);
			return true;
		}
		return false;
	}
	public boolean updateCourReg(String cID) {
		for(int i = 0; i < courReg.size(); i++) {
		if(courReg.get(i).getcID() == cID) {
			CourseCRUD.update(courReg.get(i));
			courReg = CourseCRUD.retrieveAll();
			return true;
		}
		}
		return false;
	}
	public Course retrieveCourReg(String cID) {
		for(int i = 0; i < courReg.size(); i++) {
			if(courReg.get(i).getcID() == cID) {
				return courReg.get(i);
			}
		}
		return null;
	}
	public boolean deleteCourReg(String cID) {
		
		for(int i = 0; i < courReg.size(); i++) {
			if(courReg.get(i).getcID() == cID) {
				CourseCRUD.delete(cID);
				courReg.remove(i);
				return true;
			}
		}
		return false;
	}
	public boolean retrieveAllcourReg() {
		if(CourseCRUD.retrieveAll() != null) {
			return true;
		}
		return false;
	}
}
