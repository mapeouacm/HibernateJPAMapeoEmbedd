package mx.edu.uacm.dominio;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Direccion {
	
	@Column(nullable = false)
	private String via;
	
	@Column(nullable = false, length = 5)
	private String codigoPostal;
	
	@Column(nullable = false)
	private String poblacion;
	
	@Column(nullable = false)
	private String provincia;
	
	public Direccion() {
		// TODO Auto-generated constructor stub
	}
	
	public Direccion(String via, String codigoPostal, String poblacion, String provincia) {
		this.via = via;
		this.codigoPostal=codigoPostal;
		this.poblacion=poblacion;
		this.provincia=provincia;
	}

}
