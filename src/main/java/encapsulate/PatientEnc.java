package encapsulate;

public class PatientEnc 
{
     private int id;
     
     private String Name; 
     
     private String Email;
     
     private String Mobile;
     
     private String DOB;
     
     private String Gender;
     
     private String Password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		this.Mobile = mobile;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		this.DOB = dOB;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		this.Gender = gender;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public PatientEnc(String name, String email, String mobile, String dOB, String gender, String password) {
		super();
		this.Name = name;
		this.Email = email;
		this.Mobile = mobile;
		this.DOB = dOB;
		this.Gender = gender;
		this.Password = password;
	}

	public PatientEnc(String name, String password) {
		super();
		Name = name;
		Password = password;
	}

	public PatientEnc(int id, String name, String email, String mobile, String dOB, String gender) {
		super();
		this.id = id;
		Name = name;
		Email = email;
		Mobile = mobile;
		DOB = dOB;
		Gender = gender;
	}

	
	public PatientEnc(int id, String name, String email, String mobile, String dOB, String gender, String password) {
		super();
		this.id = id;
		Name = name;
		Email = email;
		Mobile = mobile;
		DOB = dOB;
		Gender = gender;
		Password = password;
	}

	public PatientEnc() {
		super();
	}
     
	
     
     
}
