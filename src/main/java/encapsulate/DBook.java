package encapsulate;

public class DBook 
{
     private String name;
     
     private String date;
     
     private String In;
     
     private String Out;
     
     private String np;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIn() {
		return In;
	}

	public void setIn(String in) {
		In = in;
	}

	public String getOut() {
		return Out;
	}

	public void setOut(String out) {
		Out = out;
	}

	public String getNp() {
		return np;
	}

	public void setNp(String np) {
		this.np = np;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public DBook(String name, String in, String out, String np) {
		super();
		this.name = name;
		In = in;
		Out = out;
		this.np = np;
	}

	public DBook() {
		super();
	}

	public DBook(String name, String date, String in, String out, String np) {
		super();
		this.name = name;
		this.date = date;
		In = in;
		Out = out;
		this.np = np;
	}
     
     
}
