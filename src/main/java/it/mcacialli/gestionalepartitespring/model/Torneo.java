package it.mcacialli.gestionalepartitespring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Torneo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int idTorneo;

    @Column(name = "nomeTorneo", nullable = false)
    private String nomeTorneo;

    @Column(name = "dataInizio", nullable = false)
    private LocalDate dataInizio;

    @Column(name = "nMaxSquadre", nullable = false)
    private int nMaxSquadre;

    @OneToMany(mappedBy = "torneo")
    List<TorneoRegistrazione> partecipazione;

    @ManyToOne
    @JoinColumn(name = "id_campo" )
    private Campo idCampo;
}
