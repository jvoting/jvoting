package modele;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="utilisateur")
public class Utilisateur implements Serializable{

	
		private  static  final  long serialVersionUID = 1L;
		
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@Column(name="login")
		private String login;
		
		@Column(name="password")
		private String password;
		
		@Column(name="prenom")
		private String prenom;
		
		@Column(name="nom")
		private String nom;
		
		@Column(name="email")
		private String email;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		
}
