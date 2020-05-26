package modelo;

public class Modalidad {

	private int idModalidad;
	private String tipoModalidad;

	public Modalidad() {
	}

	public Modalidad(int idModalidad, String tipoModalidad) {
		this.idModalidad = idModalidad;
		this.tipoModalidad = tipoModalidad;
	}

	public int getIdModalidad() {
		return idModalidad;
	}

	public void setIdModalidad(int idModalidad) {
		this.idModalidad = idModalidad;
	}

	public String getTipoModalidad() {
		return tipoModalidad;
	}

	public void setTipoModalidad(String tipoModalidad) {
		this.tipoModalidad = tipoModalidad;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Modalidad [idModalidad=");
		builder.append(idModalidad);
		builder.append(", tipoModalidad=");
		builder.append(tipoModalidad);
		builder.append("]");
		return builder.toString();
	}

}
