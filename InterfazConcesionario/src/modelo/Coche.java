package modelo;

public class Coche implements Comparable<Coche> {

	private long idCoche;
	private String marca;
	private String modelo;
	private String tipoCoche;

	public Coche() {
	}

	public Coche(long idCoche, String marca, String modelo, String tipoCoche) {
		this.idCoche = idCoche;
		this.marca = marca;
		this.modelo = modelo;
		this.tipoCoche = tipoCoche;
	}

	public long getIdCoche() {
		return idCoche;
	}

	public void setIdCoche(long idCoche) {
		this.idCoche = idCoche;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipoCoche() {
		return tipoCoche;
	}

	public void setTipoCoche(String tipoCoche) {
		this.tipoCoche = tipoCoche;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Coche [idCoche=");
		builder.append(idCoche);
		builder.append(", marca=");
		builder.append(marca);
		builder.append(", modelo=");
		builder.append(modelo);
		builder.append(", tipoCoche=");
		builder.append(tipoCoche);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Coche coche) {

		return this.getMarca().compareTo(coche.getMarca());
	}

}
