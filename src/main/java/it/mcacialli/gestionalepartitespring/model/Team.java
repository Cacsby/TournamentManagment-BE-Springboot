package it.mcacialli.gestionalepartitespring.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties(allowGetters = true)
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTeam;

    @Column(name = "nomeTeam", nullable = false)
    private String nomeTeam;

    @Column(name = "nVittorie", nullable = false)
    private int nVittorie;

    @Column(name = "nSconfitte", nullable = false)
    private int nSconfitte;

    @Column(name = "nPareggi", nullable = false)
    private int nPareggi;

    @OneToMany(mappedBy = "team")
    @JsonIgnore
    List<TeamRegistrazione> registrazione;


    @OneToMany(mappedBy = "team")
    @JsonIgnore
    List<TorneoRegistrazione> partecipazione;


    @ManyToOne
    @JoinColumn(name = "id_capoSquadra")
    private Utente utenteCaposquadra;


}
