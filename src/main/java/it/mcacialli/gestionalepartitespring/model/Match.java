package it.mcacialli.gestionalepartitespring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Match {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int idMatch;

    @Column(name = "dataMatch", nullable = false)
    private LocalDate dataMatch;


    @ManyToOne
    @JoinColumn(name = "id_teamCasa" )
    private Team teamCasa;

    @Column(name = "golCasa", nullable = false)
    private Integer golCasa;

    @ManyToOne
    @JoinColumn(name = "id_teamOspite" )
    private Team teamOspite;

    @Column(name = "golOspite", nullable = false)
    private Integer golOspite;

    @ManyToOne
    @JoinColumn(name = "id_torneo" )
    private Torneo torneo;


}