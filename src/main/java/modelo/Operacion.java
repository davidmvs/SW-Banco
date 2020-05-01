package modelo;

public class Operacion {
	private String tarjeta;
	private String fechacad;
	private int cvv;
	private int monto;
	public Operacion() {
		
	}
	public Operacion(String tarjeta, int monto) {
		this.tarjeta=tarjeta;
		this.monto=monto;
	}
	public Operacion(String tarjeta, String fechacad, int cvv) {
		this.tarjeta=tarjeta;
		this.fechacad=fechacad;
		this.cvv=cvv;
	}
	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}
	public String getTarjeta() {
		return tarjeta;
	}
	public void setFechacad(String fechacad) {
		this.fechacad = fechacad;
	}
	public String getFechacad() {
		return fechacad;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public int getCvv() {
		return cvv;
	}
	public void setMonto(int monto) {
		this.monto = monto;
	}
	public int getMonto() {
		return monto;
	}
}
