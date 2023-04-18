package encapsulate;

public class PBook 
{
      private int id;
      
      private String name;
      
      private String problme;
      
      private String date;
      
      private String time;

	public int getId() {
		return id;
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

	public String getProblme() {
		return problme;
	}

	public void setProblme(String problme) {
		this.problme = problme;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public PBook(String name, String problme, String date, String time) {
		super();
		this.name = name;
		this.problme = problme;
		this.date = date;
		this.time = time;
	}

	public PBook() {
		super();
	}
     
	
      
}
