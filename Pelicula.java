package nelsonLozada;

public class Pelicula {

	private int cantidad;
	private String descripcion ;
	private double precioUnidad; 

	public Pelicula() {

	} // no-args

	public Pelicula(int a, String b, double c) throws Exception {

		this.setCantidad(a);
		this.setDescripcion(b);
		this.setPreciounidad(c);

	} // constructor

	public void setCantidad(int cantidad) throws Exception {

		if (cantidad < 0) {
			throw new Exception("La cantidad no puede ser menor a 0") ;
		}
		this.cantidad = cantidad ;

	} // setter cantidad

	public void setDescripcion(String descripcion) {

		this.descripcion = descripcion ;

	} // setter descripcion 

	public void setPreciounidad(double precioUnidad) {

		this.precioUnidad = precioUnidad ;

	} // setter precioUnidad

	public double getSubTotal() {

		return  this.precioUnidad * this.cantidad  ;

	} // getter Total

	@Override
	public String toString() {

		String patron = "%-18s%-20s%-18s%-18s" ;

		return  String.format(patron, this.cantidad, this.descripcion, 
				String.format("$%.2f", this.precioUnidad), String.format("$%.2f", getSubTotal())) 
				+ "_____________________________________________________________________|"   ;

	} // toString()


} // class
