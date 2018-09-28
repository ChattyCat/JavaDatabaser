package pendelum_pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CourseCRUD {
	public static Course getCourseFromDB(ResultSet rs) throws SQLException {
		Course course = new Course();
		
		course.setcID(rs.getString("cID"));
		course.setcName(rs.getString("cName"));
		
		return course;
	}
	public static boolean create(Course course) {
		dbConnection dbCon = new dbConnection();
		
		Connection con = dbCon.getConnection();
		
		try {
	    PreparedStatement ps = con.prepareStatement("insert into Course values(?, ?, ?)");
	    ps.setString(0, course.getcID());
	    ps.setString(1, course.getcName());
		
	    if (ps.executeUpdate() == 1) {
	    	return true;
	    }
	    
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return false;
	}
	public Course retrieve(String cID) {
		dbConnection dbCon = new dbConnection();
		
		Connection con = dbCon.getConnection();
		
		try {
		String query = "select * from Course where cID = " + cID;
		Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    
	    if (rs.next()) {
	    	return getCourseFromDB(rs);
	    }
	    
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return null;
	}
	public static boolean update(Course course) {
		dbConnection dbCon = new dbConnection();
		
		Connection con = dbCon.getConnection();
		
		try {
	    PreparedStatement ps = con.prepareStatement("update Course set cName = ? where cID = ?");
	    ps.setString(0, course.getcName());
	    ps.setString(1, course.getcID());
		
	    if (ps.executeUpdate() == 1) {
	    	return true;
	    }
	    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static boolean delete(String cID) {
		dbConnection dbCon = new dbConnection();
		Connection con = dbCon.getConnection();
		
		try {
		Statement stmt = con.createStatement();
		
	    if (stmt.executeUpdate("delete from Course where cID = " + cID) == 1) {
	    	return true;
	    }
	    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static List<Course> retrieveAll() {
		dbConnection dbCon = new dbConnection();
		
		Connection con = dbCon.getConnection();
		
		//Statement stmt = null; 
		try {
		String query = "select * from Course";
		Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    
	    List<Course> courses = new ArrayList<Course>();
	    
	    while (rs.next()) {
	    	Course course = getCourseFromDB(rs);
	    	courses.add(course);
	    }
	    return courses;
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return null;
	}
}
