package es.urjc.daw.app.event;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Event")
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event
{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idEvent;

    public Event() {
    }

    @Column()
    private String name;

    @Column (length = 429496729)
    private String eventPhoto;
    @Column(columnDefinition = "")
    private String eventWiki;
    @Column
   // private Date eventDate;
    private String eventDate;

    @OneToMany
    private List<Event> events = new ArrayList<>();

    public Event(String name) {
        setName(name);
    }

    public Event(String name, String eventWiki, String eventDate) {
        setName(name);
        setEventWiki(eventWiki);
        setEventDate(eventDate);
    }

    public List<Event> getEvents() {
        return this.events;
    }

    public void setEvent(List<Event> events) {
        this.events = events;
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
