package com.project.desafio.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "tabela_entidades")
public class ApiEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull(message="Campo logic não deve estar em branco")
	private Integer logic;
	
	@NotBlank(message="Campo serial não deve estar em branco")
	private String serial;
	
	@NotBlank(message="Campo model não deve estar em branco")
	private String model;
	
	@Min(value=0, message="Valor minimo deve ser 0")
	private Integer sam;
	
	private String ptid;
	private Integer plat;
	
	@NotBlank(message="Campo version não deve estar em branco")
	private String version;
	
	
	private Integer mxr;
	private Integer mxf;
	private String verfm;

}
