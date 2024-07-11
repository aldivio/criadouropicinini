package br.com.criadouropicinini.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "passaro")
public class PassaroPai {

    @Id
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "passaroPai")
    private List<Passaro> filhos = new ArrayList<>();




}
