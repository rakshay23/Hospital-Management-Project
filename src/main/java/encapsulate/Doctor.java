package encapsulate;

public class Doctor 
{
     private int id;
     
     private String name;
     
     private String email;
     
     private String mob;
     
     private String dob;
     
     private String gender;
     
     private String deg;
     
     private int yoe;
     
     private double salary;
     
     private String pass;

	public int getId() {
		return id;
	}
    
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDeg() {
		return deg;
	}

	public void setDeg(String deg) {
		this.deg = deg;
	}

	public int getYoe() {
		return yoe;
	}

	public void setYoe(int yoe) {
		this.yoe = yoe;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	
	public Doctor(String name, String email, String mob, String dob, String gender, String deg, int yoe, double salary,
			String pass) {
		super();
		this.name = name;
		this.email = email;
		this.mob = mob;
		this.dob = dob;
		this.gender = gender;
		this.deg = deg;
		this.yoe = yoe;
		this.salary = salary;
		this.pass = pass;
	}

	public Doctor(String name, String pass) {
		super();
		this.name = name;
		this.pass = pass;
	}

	public Doctor(int id, String name, String email, String mob, String dob, String gender, String deg, int yoe,
			double salary, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mob = mob;
		this.dob = dob;
		this.gender = gender;
		this.deg = deg;
		this.yoe = yoe;
		this.salary = salary;
		this.pass = pass;
	}

	public Doctor() {
		super();
	}

	public Doctor(int id, String name, String email, String mob, String dob, String gender, String deg, int yoe,
			double salary) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mob = mob;
		this.dob = dob;
		this.gender = gender;
		this.deg = deg;
		this.yoe = yoe;
		this.salary = salary;
	}
     
     
     
     
}
