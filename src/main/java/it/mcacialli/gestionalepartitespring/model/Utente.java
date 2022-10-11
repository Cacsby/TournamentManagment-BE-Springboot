package it.mcacialli.gestionalepartitespring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    @Column(name = "nomeUtente", nullable = false)
    private String nomeUtente;

    @Column(name = "password", nullable = false)
    private String password;

    /*
    @Column(name = "isAdmin")
    private boolean isAdmin;

    @Column(name = "isPlayer")
    private boolean isPlayer;

*/

    @OneToMany(mappedBy = "utente", fetch = FetchType.LAZY)
    List<TeamRegistrazione> registratione;

    @ManyToOne
    @JoinColumn(name = "id_ruolo" )
    private Ruolo idRuolo;
}
