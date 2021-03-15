package com.ricardohernani.projetogpmo.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PacienteNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Integer registro;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date data;
	
	
	private Integer codigo;
	private Integer tipo;
	private Integer premio;
	
	private Integer codigo1;
	private Integer tipo1;
	private Integer premio1;

	public PacienteNewDTO() {
	}

	public Integer getRegistro() {
		return registro;
	}

	public void setRegistro(Integer registro) {
		this.registro = registro;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Integer getPremio() {
		return premio;
	}

	public void setPremio(Integer premio) {
		this.premio = premio;
	}

	public Integer getCodigo1() {
		return codigo1;
	}

	public void setCodigo1(Integer codigo1) {
		this.codigo1 = codigo1;
	}

	public Integer getTipo1() {
		return tipo1;
	}

	public void setTipo1(Integer tipo1) {
		this.tipo1 = tipo1;
	}

	public Integer getPremio1() {
		return premio1;
	}

	public void setPremio1(Integer premio1) {
		this.premio1 = premio1;
	}
	

}
