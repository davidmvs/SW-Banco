package mx.uv.banco;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import controlador.OperacionDAO;
import me.cobrar.banco.CobrarRequest;
import me.cobrar.banco.CobrarResponse;
import me.cobrar.banco.ReembolsoRequest;
import me.cobrar.banco.ReembolsoResponse;

@Endpoint
public class EndPoint {

	@PayloadRoot(namespace="http://cobrar.me/Banco", 
			localPart="CobrarRequest")
	
	@ResponsePayload
	public CobrarResponse getCobro(@RequestPayload CobrarRequest peticion) {
		CobrarResponse respuesta = new CobrarResponse();
		if(peticion.getTarjeta().length()==16) {
			if(peticion.getTarjeta().matches("[0-9]*")) {
				int i = Integer.parseInt(peticion.getTarjeta().substring(0, 4));
		if(i>=1000 && i<=3249) {
					String pin= String.valueOf(peticion.getPin());
						if(pin.length()<4 || pin.length()>4) {
							respuesta.setRespuesta("\n"+"El pin debe estar compuesto por 4 dígitos numéricos, ingrese correctamente el pin"+"\n");
						}else {
							OperacionDAO cobro= new OperacionDAO(peticion.getTarjeta(), peticion.getPin(), peticion.getMonto());
							if(cobro.registrarPago()) {
								respuesta.setRespuesta("\n"+"Banco 1 ha realizado un cargo a la tarjeta con terminacion: "+ "XXXX-XXXX-XXXX-"+peticion.getTarjeta().substring(12, 16) + " por la cantidad de: $"+ peticion.getMonto()  +".00 ");
							}else {
								respuesta.setRespuesta("\n"+"No se ha podido realizar el registro de su pago debido a un problema en la Base de Datos");
							}
						}
				}else {
					
			if(i>= 5500 && i<= 7749) {
						String pin= String.valueOf(peticion.getPin());
						if(pin.length()<4 || pin.length()>4) {
							respuesta.setRespuesta("\n"+"El pin debe estar compuesto por 4 digitos numéricos, ingrese correctamente el pin"+"\n");
						}else {
							respuesta.setRespuesta("\n"+
							"Banco 3 ha realizado un cargo a la tarjeta con terminacion:"+ "XXXX-XXXX-XXXX-"+peticion.getTarjeta().substring(12, 16) + " por la cantidad de: $"+ peticion.getMonto()  +".00 ");
						}
					}else if(i>=3250 && i<=5499) {
							String pin= String.valueOf(peticion.getPin());
							if(pin.length()<4 || pin.length()>4) {
								respuesta.setRespuesta("\n"+"El pin debe estar compuesto por 4 digitos numéricos, ingrese correctamente el pin"+"\n");
							}else {
								respuesta.setRespuesta("\n"+
								"Banco 2 ha realizado un cargo a la tarjeta con terminacion:"+ "XXXX-XXXX-XXXX-"+peticion.getTarjeta().substring(12, 16) + " por la cantidad de: $"+ peticion.getMonto()  +".00 ");
							}
						}else if(i>=7750 && i<= 9999) {
								String pin= String.valueOf(peticion.getPin());
								if(pin.length()<4 || pin.length()>4) {
									respuesta.setRespuesta("\n"+"El pin debe estar compuesto por 4 digitos numéricos, ingrese correctamente el pin"+"\n");
								}else {
									respuesta.setRespuesta("\n"+
									"Banco 4 ha realizado un cargo a la tarjeta con terminacion:"+ "XXXX-XXXX-XXXX-"+peticion.getTarjeta().substring(12, 16) + " por la cantidad de: $"+ peticion.getMonto()  +".00 ");
								}
							}	
				}
			}else {
				respuesta.setRespuesta("\n"+"Transaccion cancelada. "+"\n"+ "El numero de tarjeta que ha ingresado("+peticion.getTarjeta()+") no pertenece al sistema de tarjetas permitido. "
						+"\n"+ "Por favor, ingrese un numero de tarjeta valido (16 digitos numericos)");
			}
		}else {
			respuesta.setRespuesta("\n"+"Transaccion cancelada. "+"\n"+"El numero de tarjeta que ha igresado(" + peticion.getTarjeta() + ") no pertenece al sistema de tarjetas permitido. "
					+"\n"+ "Por favor, ingrese un numero de tarjeta valido (16 digitos)");			
		}
		return respuesta;
	}
	
	@PayloadRoot(namespace="http://cobrar.me/Banco", 
			localPart="ReembolsoRequest")
	
	@ResponsePayload
	public ReembolsoResponse getReembolso(@RequestPayload ReembolsoRequest peticion) {
		ReembolsoResponse respuesta = new ReembolsoResponse();
		if(peticion.getTarjeta().length()==16) {
			if(peticion.getTarjeta().matches("[0-9]*")) {
				int i = Integer.parseInt(peticion.getTarjeta().substring(0, 4));
				if(i>=1000 && i<=3249) {
					OperacionDAO reembolso= new OperacionDAO(peticion.getTarjeta(), peticion.getMonto());
					if(reembolso.realizarReembolso()) {
						respuesta.setRespuesta("\n"+"Banco 1 ha realizado un reembolso a la tarjeta ejecutiva con terminacion: "+"XXXX-XXXX-XXXX-"+ peticion.getTarjeta().substring(12, 16) + " por la cantidad de: $" + peticion.getMonto() + ".00 \n ");
					}else {
						respuesta.setRespuesta("\n"+"No existe un pago registrado con dichos datos, comprueba que los campos ingresados son los correctos"+"\n");
					}
				}else {
					
					if(i>= 5500 && i<= 7749) {
						respuesta.setRespuesta("\n"+
								"Banco 3 ha realizado un reeembolso a la tarjeta con terminacion: "+"XXXX-XXXX-XXXX-"+ peticion.getTarjeta().substring(12, 16) + " por la cantidad de: $"+ peticion.getMonto()  +".00"+ "\n" );
					}else if(i>=3250 && i<=5499) {
						respuesta.setRespuesta("\n"+
								"Banco 2 ha realizado un reembolso a la tarjeta con terminacion: "+"XXXX-XXXX-XXXX-"+ peticion.getTarjeta().substring(12, 16) + " por la cantidad de: $"+ peticion.getMonto()  +".00" +"\n");
					}else if(i>=7750 && i<= 9999) {
						respuesta.setRespuesta("\n"+
								"Banco 4 ha realizado un reembolso a la tarjeta con terminación: "+"XXXX-XXXX-XXXX-"+ peticion.getTarjeta().substring(12, 16) + " por la cantidad de: $"+ peticion.getMonto()  +".00"+ "\n");
					}
				}
			}else {
				respuesta.setRespuesta("\n"+"El reembolso no ha sido realizado." +"\n"+ "El numero de tarjeta ejecutiva que ha ingresado("+peticion.getTarjeta()+") no pertenece al sistema de tarjetas permitido. "
						+"\n"+ "Por favor, ingrese un numero de tarjeta valido (16 digitos numericos)");
			}
		}else {
			respuesta.setRespuesta("\n"+"El reembolso no ha sido realizado."+"\n"+"El numero de tarjeta ejecutiva que ha igresado(" + peticion.getTarjeta() + ") no pertenece al sistema de tarjetas permitido. "
					+"\n"+ "Por favor, ingrese un numero de tarjeta valido (16 digitos)");			
		}
		return respuesta;
	}
}

