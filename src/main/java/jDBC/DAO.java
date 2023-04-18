package jDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import encapsulate.Admin;
import encapsulate.DBook;
import encapsulate.Doctor;
import encapsulate.PBook;
import encapsulate.PatientEnc;

public class DAO 
{
	public static Connection getConnection()
    {
   	 Connection con=null;
   	 
   	 try 
   	 {
   		 Class.forName("com.mysql.cj.jdbc.Driver");
   		 
   		 String url="jdbc:mysql://localhost:3306/hms";
   		 String username="root";
   		 String password="root";
   		 
   		 con=DriverManager.getConnection(url,username,password);
   	 }
   	 
   	 catch(Exception e) 
   	 {
   		System.out.println(e); 
   	 }
   	 
   	 return con;
    }
	
	public static int InsertP(PatientEnc ob)
	{
		int s=0;
		
		try
		{
			Connection con=DAO.getConnection();
			String sql="insert into patient(Name, Email, Mobile, Date_of_Birth, Gender, Password) values (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps= con.prepareStatement(sql);
			
			ps.setString(1, ob.getName());
			ps.setString(2, ob.getEmail());
			ps.setString(3, ob.getMobile());
			ps.setString(4, ob.getDOB());
			ps.setString(5, ob.getGender());
			ps.setString(6, ob.getPassword());
			
			s=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return s;
	}
	
	public static int InsertD(Doctor ob)
	{
		int s=0;
		
		try
		{
			Connection con=DAO.getConnection();
			String sql="insert into doctor(Name, Email, Mobile, Date_of_Birth, Gender, Degree, Year_of_Exp, Salary, Password) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps= con.prepareStatement(sql);
			
			ps.setString(1, ob.getName());
			ps.setString(2, ob.getEmail());
			ps.setString(3, ob.getMob());
			ps.setString(4, ob.getDob());
			ps.setString(5, ob.getGender());
			ps.setString(6, ob.getDeg());
			ps.setInt(7, ob.getYoe());
			ps.setDouble(8, ob.getSalary());
			ps.setString(9, ob.getPass());
			
			s=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return s;
	}
	
	public static int InsertA(Admin ob)
	{
		int s=0;
		
		try
		{
			Connection con=DAO.getConnection();
			String sql="insert into Admin(Name, Email, DOB, Password) values (?, ?, ?, ?)";
			PreparedStatement ps= con.prepareStatement(sql);
			
			ps.setString(1, ob.getName());
			ps.setString(2, ob.getEmail());
			ps.setString(3, ob.getDob());
			ps.setString(4, ob.getPassword());
			
			s=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return s;
	}
	
	public static boolean DLogin(String name, String pass) 
	{
		boolean status=false;
	   	
	   	try
	   	{
	   	   Connection con=DAO.getConnection();
	   	   String sql="select * from doctor where Name=? and Password=?";
	   	   
	   	   PreparedStatement ps= con.prepareStatement(sql);
	   	   ps.setString(1, name);
	   	   ps.setString(2, pass);
	   	  
	   	   ResultSet rs=ps.executeQuery();
	   	   status= rs.next();
	   	}
	   	catch(Exception e)
	   	{
	   		System.out.println(e);
	   	}
	   	
	   	return status;
	}
	
	public static boolean PLogin(String name, String pass) 
	{
		boolean status=false;
	   	
	   	try
	   	{
	   	   Connection con=DAO.getConnection();
	   	   String sql="select * from patient where Name=? and Password=?";
	   	   
	   	   PreparedStatement ps= con.prepareStatement(sql);
	   	   ps.setString(1, name);
	   	   ps.setString(2, pass);
	   	  
	   	   ResultSet rs=ps.executeQuery();
	   	   status= rs.next();
	   	}
	   	catch(Exception e)
	   	{
	   		System.out.println(e);
	   	}
	   	
	   	return status;
	}
	
	public static boolean ALogin(String name, String pass) 
	{
		boolean status=false;
	   	
	   	try
	   	{
	   	   Connection con=DAO.getConnection();
	   	   String sql="select * from Admin where Name=? and Password=?";
	   	   
	   	   PreparedStatement ps= con.prepareStatement(sql);
	   	   ps.setString(1, name);
	   	   ps.setString(2, pass);
	   	  
	   	   ResultSet rs=ps.executeQuery();
	   	   status= rs.next();
	   	}
	   	catch(Exception e)
	   	{
	   		System.out.println(e);
	   	}
	   	
	   	return status;
	}
	
	public static List ShowD()
    {
   	List<Doctor> list = new ArrayList<>();
   	
   	try
   	{
   		Connection con=DAO.getConnection();
   		String sql="select * from doctor";
   		PreparedStatement ps= con.prepareStatement(sql);
   		
   		ResultSet rs=ps.executeQuery();
   		
   		while(rs.next())
   		{
   			Doctor di= new Doctor();
   			
   			di.setId(rs.getInt(1));
   			di.setName(rs.getString(2));
   			di.setEmail(rs.getString(3));
   			di.setMob(rs.getString(4));
   			di.setDob(rs.getString(5));
   			di.setGender(rs.getString(6));
   			di.setDeg(rs.getString(7));
   			di.setYoe(rs.getInt(8));
   			di.setSalary(rs.getDouble(9));
   			
   			list.add(di);
   		}
   	}
   	catch(Exception e)
   	{
   		System.out.println(e);
   	}	
		return list;
    }
	
	public static List ShowP()
    {
   	List<PatientEnc> list = new ArrayList<>();
   	
   	try
   	{
   		Connection con=DAO.getConnection();
   		String sql="select * from patient";
   		PreparedStatement ps= con.prepareStatement(sql);
   		
   		ResultSet rs=ps.executeQuery();
   		
   		while(rs.next())
   		{
   			PatientEnc di= new PatientEnc();
   			
   			di.setId(rs.getInt(1));
   			di.setName(rs.getString(2));
   			di.setEmail(rs.getString(3));
   			di.setMobile(rs.getString(4));
   			di.setDOB(rs.getString(5));
   			di.setGender(rs.getString(6));
   			
   			list.add(di);
   		}
   	}
   	catch(Exception e)
   	{
   		System.out.println(e);
   	}	
		return list;
    }
	
	public static PatientEnc EditP(int id)
    {
		PatientEnc df= new PatientEnc();
   	 
   	 try
   	 {
   		 Connection con= DAO.getConnection();
   		 
   		 String sql="select * from patient where id=?";
   		 
   		 PreparedStatement ps= con.prepareStatement(sql);
   		 
   		 ps.setInt(1, id);
   		 
   		 ResultSet rs= ps.executeQuery();
   		 
   		 if(rs.next())
   		 {
   			 df= new PatientEnc();
   			 
   			 df.setId(rs.getInt(1));
   			 df.setName(rs.getString(2));
   			 df.setEmail(rs.getString(3));
   			 df.setMobile(rs.getString(4));
   			 df.setDOB(rs.getString(5));
   			 df.setGender(rs.getString(6));
   			 df.setPassword(rs.getString(7));
   		 }
   	 }
   	 
   	 catch(Exception e)
   	 {
   		 System.out.println(e);
   	 }
   	 
   	 return df;
    }
	
	public static Doctor EditD(int id)
    {
		Doctor df= new Doctor();
   	 
   	 try
   	 {
   		 Connection con= DAO.getConnection();
   		 
   		 String sql="select * from doctor where id=?";
   		 
   		 PreparedStatement ps= con.prepareStatement(sql);
   		 
   		 ps.setInt(1, id);
   		 
   		 ResultSet rs= ps.executeQuery();
   		 
   		 if(rs.next())
   		 {
   			 df= new Doctor();
   			 
   			 df.setId(rs.getInt(1));
   			 df.setName(rs.getString(2));
   			 df.setEmail(rs.getString(3));
   			 df.setMob(rs.getString(4));
   			 df.setDob(rs.getString(5));
   			 df.setGender(rs.getString(6));
   			 df.setDeg(rs.getString(7));
   			 df.setYoe(rs.getInt(8));
   			 df.setSalary(rs.getDouble(9));
   			 df.setPass(rs.getString(10));
   		 }
   	 }
   	 
   	 catch(Exception e)
   	 {
   		 System.out.println(e);
   	 }
   	 
   	 return df;
    }
	
	public static int updateD(Doctor ob)
    {
   	 int status=0;
   	 
   	 try 
   	 {
   		 Connection con=DAO.getConnection();
   		 String sql="update doctor set Name=?, Email=?, Mobile=?, Date_of_Birth=?, Gender=?, Degree=?, Year_of_Exp=?, Salary=? where id=?";
   		 PreparedStatement ps= con.prepareStatement(sql);
   		 
   		 ps.setString(1, ob.getName());
   		 ps.setString(2, ob.getEmail());
   		 ps.setString(3, ob.getMob());
   		 ps.setString(4, ob.getDob());
   		 ps.setString(5, ob.getGender());
   		 ps.setString(6, ob.getDeg());
   		 ps.setInt(7, ob.getYoe());
   		 ps.setDouble(8, ob.getSalary());
   		 ps.setInt(9, ob.getId());
   		 
   		status=ps.executeUpdate();
   	 }
   	 catch(Exception e)
   	 {
   		 System.out.println(e);
   	 }
   	 return status;
    }
	
	public static int updateP(PatientEnc ob)
    {
   	 int status=0;
   	 
   	 try 
   	 {
   		 Connection con=DAO.getConnection();
   		 String sql="update patient set Name=?, Email=?, Mobile=?, Date_of_Birth=?, Gender=?, Password=? where id=?";
   		 PreparedStatement ps= con.prepareStatement(sql);
   		 
   		 ps.setString(1, ob.getName());
   		 ps.setString(2, ob.getEmail());
   		 ps.setString(3, ob.getMobile());
   		 ps.setString(4, ob.getDOB());
   		 ps.setString(5, ob.getGender());
   		 ps.setString(6, ob.getPassword());
   		 ps.setInt(7, ob.getId());
   		 
   		status=ps.executeUpdate();
   	 }
   	 catch(Exception e)
   	 {
   		 System.out.println(e);
   	 }
   	 return status;
    }
	
	public static int deleteP(int id)
    {
   	    int status=0;
   	 
   	    try
   	    {
   	       Connection con=DAO.getConnection();
   	       String sql="delete from patient where id=?";
   	       PreparedStatement ps= con.prepareStatement(sql);
   	  
   	        ps.setInt(1, id);
   	 
   	      status=ps.executeUpdate();
   	    }
   	     catch(Exception e)
   	     {
   		 System.out.println(e);
   	     }
   	 
   	      return status;
   	 
      }
	
	public static int deleteD(int id)
    {
   	    int status=0;
   	    
   	    try
   	    {
   	       Connection con=DAO.getConnection();
   	       String sql="delete from doctor where id=?";
   	       PreparedStatement ps= con.prepareStatement(sql);
   	  
   	       ps.setInt(1, id);
   	 
   	      status=ps.executeUpdate();
   	    }
   	     catch(Exception e)
   	    {
   		 System.out.println(e);
   	    }
   	 
   	    return status;
    }
	
	public static int bookP(PBook ob)
	{
		int s=0;
		
		try
		{
			Connection con=DAO.getConnection();
			String sql="insert into Patient_Booking(Name, Problem, Date, Time) values (?, ?, ?, ?)";
			PreparedStatement ps= con.prepareStatement(sql);
			
			ps.setString(1, ob.getName());
			ps.setString(2, ob.getProblme());
			ps.setString(3, ob.getDate());
			ps.setString(4, ob.getTime());
			
			s=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return s;
	}
	
	public static int scheduleD(DBook ob)
	{
		int s=0;
		
		try
		{
			Connection con=DAO.getConnection();
			String sql="insert into Doctor_Schedule(Name, Date, InTime, OutTime, Total_Patient_Checked) values (?, ?, ?, ?, ?)";
			PreparedStatement ps= con.prepareStatement(sql);
			
			ps.setString(1, ob.getName());
			ps.setString(2, ob.getDate());
			ps.setString(3, ob.getIn());
			ps.setString(4, ob.getOut());
			ps.setString(5, ob.getNp());
			
			s=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return s;
	}
	
	public static List ShowDschedule(String name)
    {
   	List<DBook> ob = new ArrayList<>();
   	
   	try
   	{
   		Connection con=DAO.getConnection();
   		String sql="select * from doctor_schedule where Name=?";
   		PreparedStatement ps= con.prepareStatement(sql);
   		
   		ps.setString(1, name);
   		
   		ResultSet rs=ps.executeQuery();
   		
   		while(rs.next())
   		{
   			DBook di= new DBook();
   			
   			
   			di.setName(rs.getString(1));
   			di.setDate(rs.getString(2));
   			di.setIn(rs.getString(3));
   			di.setOut(rs.getString(4));
   			di.setNp(rs.getString(5));
   			
   			
   			ob.add(di);
   		}
   	}
   	catch(Exception e)
   	{
   		System.out.println(e);
   	}	
		return ob;
    }
	
	public static List PBookingShow(String name)
    {
    	List<PBook> ob = new ArrayList<>();
   	
   	try
   	{
   		Connection con=DAO.getConnection();
   		String sql="select * from patient_booking where Name=?";
   		PreparedStatement ps= con.prepareStatement(sql);
   		
   		ps.setString(1, name);
   		
   		ResultSet rs=ps.executeQuery();
   		
   		while(rs.next())
   		{
   			PBook di= new PBook();
   			
   			
   			di.setName(rs.getString(1));
   			di.setProblme(rs.getString(2));
   			di.setDate(rs.getString(3));
   			di.setTime(rs.getString(4));
   			
   			
   			ob.add(di);
   		}
   	}
   	catch(Exception e)
   	{
   		System.out.println(e);
   	}	
		return ob;
    }
}
