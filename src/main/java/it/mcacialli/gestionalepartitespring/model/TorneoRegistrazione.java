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
public class TorneoRegistrazione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idRegistrazione;

    @ManyToOne
    @JoinColumn(name = "torneo_id")
    @JsonBackReference
    Torneo torneo;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonBackReference
    Team team;
}
