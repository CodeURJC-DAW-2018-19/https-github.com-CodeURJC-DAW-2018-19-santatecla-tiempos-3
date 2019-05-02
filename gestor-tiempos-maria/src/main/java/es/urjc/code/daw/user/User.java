package es.urjc.code.daw.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idUser;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;

	
	
	@Column(unique=true)
	
	private String email;

	private String name;

	@Column(name="password")
	private String passwordHash;


	public User() {
	}
	public User(String name,String email,String password, String... roles) {
	
		this.name = name;
		this.email=email;
		this.passwordHash = new BCryptPasswordEncoder().encode(password);
		this.roles = new ArrayList<String>(Arrays.asList(roles));
	}


	public Long getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswordHash() {
		return this.passwordHash;
	}

	public void setPasswordHash(String password) {
		this.passwordHash = new BCryptPasswordEncoder().encode(password);
	}

	public List<String> getRoles() {
		return roles;
	}
	@ManyToMany
	@JoinTable(name="user_role", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="role_id"))
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User{" +
				"idUser=" + idUser +
				", email='" + email + '\'' +
				", name='" + name + '\'' +
				", password='" + passwordHash + '\'' +
				'}';
	}

}
