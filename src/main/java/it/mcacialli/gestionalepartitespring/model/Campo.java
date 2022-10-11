package it.mcacialli.gestionalepartitespring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Campo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int idCampo;

    @Column(name = "nomeCampo", nullable = false)
    private String nomeCampo;

    @Column(name = "indirizzoCampo", nullable = false)
    private String indirizzoCampo;

}
