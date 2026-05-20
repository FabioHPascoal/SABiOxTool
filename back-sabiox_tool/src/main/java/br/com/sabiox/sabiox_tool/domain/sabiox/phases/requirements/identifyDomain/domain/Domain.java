package br.com.sabiox.sabiox_tool.domain.sabiox.phases.requirements.identifyDomain.domain;

import br.com.sabiox.sabiox_tool.domain.sabiox.phases.requirements.identifyDomain.IdentifyDomain;
import br.com.sabiox.sabiox_tool.domain.sabiox.phases.requirements.identifySubdomains.IdentifySubdomains;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "domain")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "horizontal_dimension", columnDefinition = "TEXT")
    private String horizontalDimension;

    @Column(name = "vertical_dimension", columnDefinition = "TEXT")
    private String verticalDimension;

    @OneToOne
    @JoinColumn(name = "identify_domain_id")
    private IdentifyDomain identifyDomain;
}
