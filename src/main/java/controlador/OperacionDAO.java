package controlador;

import java.sql.SQLException;

import bd.Conexion;

public class OperacionDAO {
	private String tarjeta;
	private int pin;
	private int monto;
	private Conexion conexion;
	public OperacionDAO() {
		
	}
	//Constructor para realizar un pago y registrarlo en la BD
	public OperacionDAO(String tarjeta, int pin, int monto) {
		this.tarjeta=tarjeta;
		this.pin=pin;
		this.monto=monto;
	}
	
	//Constructor para realizar un reembolso y eliminarlo de la BD
	public OperacionDAO(String tarjeta, int monto) {
		this.tarjeta=tarjeta;
		this.monto=monto;
	}
	
	public boolean registrarPago() {
		boolean resultado=false;
		this.conexion= new Conexion();
		try {
			this.conexion.connect().createStatement().execute(
					"INSERT INTO pagos (tarjeta, pin, monto) VALUES "+ "('"+this.tarjeta+"',"+this.pin+","+
							this.monto+");");
			resultado=true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	public boolean realizarReembolso() {
		boolean resultado=false;
		this.conexion= new Conexion();
		try {
			this.conexion.connect().createStatement().execute(
					"DELETE FROM pagos WHERE tarjeta="+this.tarjeta+" AND monto="+this.monto+";");
			resultado=true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
}
