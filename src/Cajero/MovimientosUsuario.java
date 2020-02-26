package Cajero;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class MovimientosUsuario {

private ObjectContainer db = null;
	
	private void abrirRegistro() {
		db = Db4oEmbedded.openFile("resgistroUsuario");
	}
	
	private void cerrarRegistro() {
		db.close();
	}
	
	public CrearUsuario selecionarPersona(CrearUsuario usua) {
		abrirRegistro();
		ObjectSet resultado = db.queryByExample(usua);
		CrearUsuario usuario = (CrearUsuario) resultado.next();
		cerrarRegistro();
		return usuario;
	}
	
	public void Movimiento(int id, int saldo) {
		abrirRegistro();
		CrearUsuario usuario = new CrearUsuario();
		usuario.setId(id);
		ObjectSet resultado = db.queryByExample(usuario);
		CrearUsuario preresultado = (CrearUsuario) resultado.next();
		preresultado.setFondosU(saldo);
		db.store(preresultado);
		cerrarRegistro();
	}
	
}
