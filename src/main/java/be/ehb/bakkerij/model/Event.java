package be.ehb.bakkerij.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Datum en tijd zijn verplicht")
    private LocalDateTime tijdstip;

    @NotBlank(message = "Titel is verplicht")
    @Size(max = 100, message = "Titel mag maximaal 100 tekens bevatten")
    private String titel;

    @NotBlank(message = "Omschrijving is verplicht")
    @Column(columnDefinition = "TEXT")
    private String omschrijving;

    @NotBlank(message = "Organisatie is verplicht")
    private String organisatie;

    @NotBlank(message = "E-mailadres is verplicht")
    @Email(message = "Geef een geldig e-mailadres op")
    private String email;

    @ManyToOne
    @JoinColumn(name = "location_id")
    @NotNull(message = "Locatie is verplicht")
    private Location locatie;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTijdstip() {
        return tijdstip;
    }

    public void setTijdstip(LocalDateTime tijdstip) {
        this.tijdstip = tijdstip;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public String getOrganisatie() {
        return organisatie;
    }

    public void setOrganisatie(String organisatie) {
        this.organisatie = organisatie;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Location getLocatie() {
        return locatie;
    }

    public void setLocatie(Location locatie) {
        this.locatie = locatie;
    }
}
