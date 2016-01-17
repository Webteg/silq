package br.ufsc.silq.core.entities;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@SequenceGenerator(name = "Token_generator", sequenceName = "sq_grupo", allocationSize = 1, initialValue = 1)
@Table(name = "tb_grupo")
@NoArgsConstructor
public class Grupo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Token_generator")
	@Column(name = "co_seq_grupo")
	private Long id;

	@NotBlank(message = "Campo obrigatório")
	@Column(name = "no_grupo")
	private String nomeGrupo;

	@NotBlank(message = "Campo obrigatório")
	@Column(name = "no_instituicao")
	private String nomeInstituicao;

	@NotBlank(message = "Campo obrigatório")
	@Column(name = "no_area")
	private String nomeArea;

	@ManyToOne
	@JoinColumn(name = "co_usuario")
	private DadoGeral coordenador;

	@OneToMany(mappedBy = "grupo", orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<Pesquisador> pesquisadores = new LinkedHashSet<>();

}