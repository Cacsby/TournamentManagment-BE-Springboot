package it.mcacialli.gestionalepartitespring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ruolo")
public class Ruolo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int idRuolo;

    @Column(name = "nomeRuolo", nullable = false)
    private String nomeRuolo;

}
