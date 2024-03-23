package Model;

import java.io.Serializable;
import java.time.LocalDate;

public class model implements Serializable {
    private static final long serialVersionUID=1L;
	private LocalDate date;
	private String descriptionString;
	
	public LocalDate getDate() {
		return date;
	}
	public String getDescriptionString() {
		return descriptionString;
	}
	public model(LocalDate time,String description){
		this.date=time;
		this.descriptionString=description;
	}
	@Override
	public String toString() {
		return "Task time : "+date+" Task: "+descriptionString;
	}
}

