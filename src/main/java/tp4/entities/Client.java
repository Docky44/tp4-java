package tp4.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    private String prenom;

    private LocalDate dateNaissance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Banques getBanque() {
        return banque;
    }

    public void setBanque(Banques banque) {
        this.banque = banque;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }


    @ManyToOne
    @JoinColumn(name = "id_banque")
    private Banques banque;

    @ManyToMany
    @JoinTable(name = "client_compte",
            joinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_compte", referencedColumnName = "id")
    )
    private Set<Compte> comptes;

    public Client(String nom, String prenom, LocalDate dateNaissance, Adresse adresse, Banques banques) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.banque = banques;
    }

    public Client() {

    }

    @Embedded private Adresse adresse;
}