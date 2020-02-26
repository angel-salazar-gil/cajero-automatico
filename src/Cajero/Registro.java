package Cajero;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.util.ArrayList;
import java.util.List;

public class Registro {
	
	private ObjectContainer db = null;
	
	private void abrirRegistro() {
		db = Db4oEmbedded.openFile("resgistroUsuario");
	}
	
	private void cerrarRegistro() {
		db.close();
	}
	
	public void insertarRegistro(CrearUsuario usuario) {
		abrirRegistro();
		db.store(usuario);
		cerrarRegistro();
	}
	
	public List<CrearUsuario> seleccionarPersona(){
		abrirRegistro();
		ObjectSet listaUsuarios = db.queryByExample(CrearUsuario.class);
		List<CrearUsuario> liUsua = new ArrayList<>();
		
		for(Object listaUsuarios1 : listaUsuarios) {
			liUsua.add((CrearUsuario) listaUsuarios1);
		}
		cerrarRegistro();
		return liUsua;
	}

}
