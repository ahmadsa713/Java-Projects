
import java.time.LocalDate;
import java.util.Date;


public class LocalEvent {
    
    private String description;
    private LocalDate Date;

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the Date
     */
    public LocalDate getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(LocalDate Date) {
        this.Date = Date;
    }

    public LocalEvent(LocalDate Date,String Description){
    this.setDate(Date);
    this.setDescription(Description);
    }

    @Override
    public String toString(){
    
        return "At: " + this.getDate() + " " + this.getDescription();
    
    }
}

