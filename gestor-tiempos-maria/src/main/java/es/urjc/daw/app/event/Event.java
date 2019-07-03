package es.urjc.daw.app.event;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import es.urjc.daw.app.category.Category;
import es.urjc.daw.app.interval.Interval;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Event")
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idEvent;

    public Event() {
    }
    @JsonView(Basic.class)
    @Column()
    private String name;
    
    @JsonView(Basic.class)
    @Column (length = 429496729)
    private String eventPhoto;
    
    @JsonView(Basic.class)
    @Column(columnDefinition = "")
    private String eventWiki;
    
    @JsonView(Basic.class)
    @Column
   // private Date eventDate;
    private String eventDate;

   
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name="category_id")
	@JsonIgnore
	private Category category;
    
    
    public Event(String name) {
        setName(name);
    }

    public Event(String name, String eventWiki, String eventDate) {
        setName(name);
        setEventWiki(eventWiki);
        setEventDate(eventDate);
    }
    
    public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
    

    public String  getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventPhoto() {
        return eventPhoto;
    }

    public void setEventPhoto(String eventPhoto) {
        if (eventPhoto == null) eventPhoto = "";
        this.eventPhoto = eventPhoto;
    }

    public String getEventWiki() {
        return eventWiki;
    }

    public void setEventWiki(String eventWiki) {
        if (eventWiki == null) eventWiki = "";
        this.eventWiki = eventWiki;
    }

    public Long getIdEvent() {
        return this.idEvent;
    }

    public void setIdEvent(Long idCategory) {
        this.idEvent = idCategory;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null) name = "";
        this.name = name;
    }

}
