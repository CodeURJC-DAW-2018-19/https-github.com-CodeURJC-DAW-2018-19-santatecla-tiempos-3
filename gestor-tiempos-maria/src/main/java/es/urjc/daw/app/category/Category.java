package es.urjc.daw.app.category;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import es.urjc.daw.app.event.Event;
import es.urjc.daw.app.interval.Interval;

/**
 * The persistent class for the category database table.
 *
 */
@Entity
@Table(name="Category")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idCategory;

/*	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;

	@Column(unique=true)
*/
	@Column(unique=true)
	
	private String name;
	
	
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "category")
	private Set<Event> events = new HashSet<Event>();
	
	
	public Category() {
	}
	public Category(String name) {
		this.events= events;
				//Collections.emptySet();   
		this.name = name;
	}

	public Set<Event> getEvents() {
		return events;
	}
	
	public void setEvents(Set<Event> events) {
		this.events = events;
	}
	
	public void addEvent(Event event) {
		  this.events.add(event);
		 }
	
	public Long getIdCategory() {
		return this.idCategory;
	}

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

/*	@OneToMany
	@JoinTable(name="", joinColumns = @JoinColumn(name=""), inverseJoinColumns = @JoinColumn(name=""))
	
	*/
	@Override
	public String toString() {
		return "Category{" + "idCategory=" + idCategory + ", name='" + name + '\''+'}';
	}
}