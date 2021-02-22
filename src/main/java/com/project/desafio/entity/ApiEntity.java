package com.project.desafio.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Entity
@Table(name = "tabela_entidades")
public class ApiEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
	private Integer logic;
	@NotNull
	private String serial;
	private Integer sam;
	private String ptid;
	@NotNull
	private String model;
	private Integer plat;
	@NotNull
	private String version;
	private Integer mxr;
	private Integer mxf;
	private String verfm;

}
