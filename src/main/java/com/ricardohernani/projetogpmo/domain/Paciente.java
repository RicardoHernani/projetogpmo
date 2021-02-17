package com.ricardohernani.projetogpmo.domain;

import java.io.Serializable;
import java.util.Date;

public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer registro;
	private Date data;
	
	public Paciente() {
	}

	public Paciente(Integer id, Integer registro, Date data) {
		super();
		this.id = id;
		this.registro = registro;
		this.data = data;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
