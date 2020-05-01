package controlador;

import java.sql.SQLException;

import bd.Conexion;

public class OperacionDAO {
	private String tarjeta;
	private String fechacad;
	private int cvv;
	private int monto;
	private Conexion conexion;
	public OperacionDAO() {
		
	}
	//Constructor para realizar un pago y registrarlo en la BD
	public OperacionDAO(String tarjeta, String fechacad, int cvv, int monto) {
		this.tarjeta=tarjeta;
		this.fechacad=fechacad;
		this.cvv=cvv;
		this.monto=monto;
	}
	
	//Constructor para realizar un reembolso y eliminarlo de la BD
	public OperacionDAO(String tarjeta, int monto) {
		this.tarjeta=tarjeta;
		this.monto=monto;
	}
	
	public boolean registrarPago() {
		boolean resultado=false;
		conexion= new Conexion();
		try {
			conexion.getConnection().createStatement().execute(
					"INSERT INTO pagos (tarjeta, fechacad, cvv, monto) VALUES "+ "('"+this.tarjeta+"','"+this.fechacad+"',"+this.cvv+","+
							this.monto+");");
			resultado=true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	public boolean realizarReembolso() {
		boolean resultado=false;
		conexion= new Conexion();
		try {
			conexion.getConnection().createStatement().execute(
					"DELETE FROM pagos WHERE tarjeta="+this.tarjeta+" AND monto="+this.monto+";");
			resultado=true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
}
