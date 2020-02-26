package Cajero;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class EliminarUsuario {
	private ObjectContainer db = null;
	
	private void abrirRegistro() {
		db = Db4oEmbedded.openFile("resgistroUsuario");
	}
	
	private void cerrarRegistro() {
		db.close();
	}
	
	public void eliminarRegistro(int id) {
		abrirRegistro();
		CrearUsuario usuario = new CrearUsuario();
		usuario.setId(id);
		ObjectSet resultado = db.queryByExample(usuario);
		CrearUsuario preresultado = (CrearUsuario) resultado.next();
		db.delete(preresultado);
		cerrarRegistro();
	}
}
