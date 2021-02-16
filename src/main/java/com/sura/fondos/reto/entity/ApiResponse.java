package com.sura.fondos.reto.entity;

public class ApiResponse<T> {

	private T datos;
	private Respuesta resultado;

	public T getDatos() {
		return datos;
	}

	public void setDatos(T datos) {
		this.datos = datos;
	}

	public Respuesta getResultado() {
		return resultado;
	}

	public void setResultado(Respuesta resultado) {
		this.resultado = resultado;
	}
}
