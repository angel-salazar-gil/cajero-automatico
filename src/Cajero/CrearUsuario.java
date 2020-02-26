package Cajero;

public class CrearUsuario {
	
	private int id;
	private String rol;
	private String nombreU;
	private int NIPU;
	private int numTerjetaU;
	private int fondosU;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getNombreU() {
		return nombreU;
	}
	public void setNombreU(String nombreU) {
		this.nombreU = nombreU;
	}
	public int getNIPU() {
		return NIPU;
	}
	public void setNIPU(int nIPU) {
		NIPU = nIPU;
	}
	public int getNumTerjetaU() {
		return numTerjetaU;
	}
	public void setNumTerjetaU(int numTerjetaU) {
		this.numTerjetaU = numTerjetaU;
	}
	public int getFondosU() {
		return fondosU;
	}
	public void setFondosU(int fondosU) {
		this.fondosU = fondosU;
	}
	
	@Override
	public String toString() {
		return "CrearUsuario [id=" + id + ", rol=" + rol + ", nombreU=" + nombreU + ", NIPU=" + NIPU + ", numTerjetaU=" + numTerjetaU + ", fondosU="
				+ fondosU + "]";
	}

}
