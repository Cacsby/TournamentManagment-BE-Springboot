package it.mcacialli.gestionalepartitespring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties(allowGetters= true)
public class TeamRegistrazione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idRegistrazione;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    @JsonBackReference
    Utente utente;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonBackReference
    Team team;
}
