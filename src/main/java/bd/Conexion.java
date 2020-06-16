package bd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	Connection cn;
	String bd="bancoone";
	String host="db4free.net";
	String puerto= "3306";
	String url="jdbc:mysql://"+host+":"+puerto+"/"+bd+"?useTimezone=true&serverTimezone=UTC";
	String usuario="bancoone";
	String contra="pswdrootBanco";
	/**
	 * Metodo para conectar el sistema a la Base de Datos
	 * @param bd -usado para ingresar a la base de datos
	 * @param host - usado para saber hacía a donde se va a dirigir y¿e intentar conectarse
	 * @param puerto - usado para indicar la interfaz de entrada
	 * @param url - Cadena completa perteneciente a lo solicitado para realizar una conexión exitosa
	 * @param usuario - Indicar por medio de que usuario se va a acceder a la Base de Datos, se debe tener en cuenta que este usuario debe existir
	 * @param contra - Indica la contraseña del usuariopor el cual se va a aingresar a la Base de Datos
	 * @return 
	 */
public Connection connect() {
		
		try {
			this.cn = DriverManager.getConnection(this.url,this.usuario,this.contra);
		} catch (SQLException e) {
			System.out.println("Conexion Fallida!:\n" + e.getMessage());
		}

		if (cn != null) {
			System.out.println("Conexion establecida");
		} else {
			System.out.println("No se pudo establecer conexion");
		}
		
		return this.cn;
		
	}

}
