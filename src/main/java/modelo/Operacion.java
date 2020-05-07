package modelo;

public class Operacion {
	private String tarjeta;
	private int pin;
	private int monto;
	public Operacion() {
		
	}
	public Operacion(String tarjeta, int monto) {
		this.tarjeta=tarjeta;
		this.monto=monto;
	}
	public Operacion(String tarjeta, String fechacad, int pin) {
		this.tarjeta=tarjeta;
		this.pin=pin;
	}
	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}
	public String getTarjeta() {
		return tarjeta;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public int getPin() {
		return pin;
	}
	public void setMonto(int monto) {
		this.monto = monto;
	}
	public int getMonto() {
		return monto;
	}
}
