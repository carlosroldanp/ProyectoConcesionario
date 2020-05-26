package modelo;

public class Venta {

	private int idVenta;
	private float precioVenta;
	private Coche cocheVenta;
	private Cliente clienteVenta;
	private Modalidad modalidadVenta;

	public Venta() {
	}

	public Venta(int idVenta, float precioVenta, Coche cocheVenta, Cliente clienteVenta, Modalidad modalidadVenta) {
		this.idVenta = idVenta;
		this.precioVenta = precioVenta;
		this.cocheVenta = cocheVenta;
		this.clienteVenta = clienteVenta;
		this.modalidadVenta = modalidadVenta;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public float getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}

	public Coche getCocheVenta() {
		return cocheVenta;
	}

	public void setCocheVenta(Coche cocheVenta) {
		this.cocheVenta = cocheVenta;
	}

	public Cliente getClienteVenta() {
		return clienteVenta;
	}

	public void setClienteVenta(Cliente clienteVenta) {
		this.clienteVenta = clienteVenta;
	}

	public Modalidad getModalidadVenta() {
		return modalidadVenta;
	}

	public void setModalidadVenta(Modalidad modalidadVenta) {
		this.modalidadVenta = modalidadVenta;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Venta = ");
		builder.append(idVenta);
		builder.append("\n\t precioVenta=");
		builder.append(precioVenta);
		builder.append("\n\t cocheVenta=");
		builder.append(cocheVenta);
		builder.append("\n\t clienteVenta=");
		builder.append(clienteVenta);
		builder.append("\n\t modalidadVenta=");
		builder.append(modalidadVenta);
		return builder.toString();
	}

}
