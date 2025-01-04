package nelsonLozada;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Factura {

	public  static final String PATH = "/users/nelsonjr/desktop/" ;
	private String nombre, transaccionPor, numeroSocio, credito, efectivo, metPago;
	LocalDate fecha = LocalDate.now();
	private int counter = 0, restantes = 10;
	private double total = 0   ;

	Pelicula p1 = new Pelicula() ;
	File fFile = new File (PATH + "factura.doc") ;
	Pelicula[ ] videos = new Pelicula[ 10 ];

	public void setNombre(String nom) {
		this.nombre = nom ;

	} // setter nombre

	public void setTransaccionPor(String t) {
		this.transaccionPor = t ;

	} // setter transaccionPor

	public void setNumeroSocio(String num) {
		this.numeroSocio = num ;

	} // setter numSocio

	public void setMetPago(String metPago) {

		if (metPago.equalsIgnoreCase("credito")) {
			credito = "X"  ;
			efectivo = " ";
		}
		else if (metPago.equalsIgnoreCase("efectivo")) {
			efectivo = "X" ;
			credito = " " ;
		}

		else {
			efectivo = " ";
			credito = " " ;
		}

	} // setter metPago

	public double getTotal() {

		return this.total += p1.getSubTotal() ;  

	} // getter Total

	public void printFactura() throws Exception {

		ImageIcon foto = new ImageIcon("Foto.png") ;

		PrintWriter pw = new PrintWriter(fFile) ;

		pw.write(toString()) ;

		this.counter = 0 ;
		this.restantes = 10 ;
		this.total = 0 ;

		do {
			counter += 1 ;

			String ans = JOptionPane.showInputDialog("Cantidad de videos: ");
			p1.setCantidad( Integer.parseInt(ans)) ;

			ans = JOptionPane.showInputDialog("Nombre del video: ");
			p1.setDescripcion(ans);

			ans = JOptionPane.showInputDialog("Precio de la unidad: ");
			p1.setPreciounidad(Double.parseDouble(ans));

			getTotal() ;

			pw.write(counter + ") " + p1.toString() + "\n\n")  ;

			

			int confirm = JOptionPane.showConfirmDialog(null,"¿Desea añadir más videos? \nTiene " 
					+ --restantes + " espacios disponibles.", "VIDEO PLACE LEVITTOWN", 
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, foto ) ;

			if (confirm == 1 || confirm == 2 || ans == null) {
				JOptionPane.showMessageDialog(null, "Su recibo ha sido guardado exitosamente."
						+ "\n¡Gracias por su compra!", "VIDEO PLACE LEVITTOWN", 0, foto) ;
				
				if (counter != 10) {
					
					while (counter < 10) {
						counter++;
						
						pw.write(counter + ") " 
						+ "\n_____________________________________________________________________|\n\n" );
								
					} 
					
				}
					
				break;

			} // if


		}  while ( counter < videos.length )  ;


		pw.write("HORA DE REGRESAR SU VIDEO SIN RECARGO: 9:00PM." 
				+ "      TOTAL: $" + String.format("%.2f" , this.total) 
				+ "\n_____________________________________________________________________|");

		pw.write("\n\n***SE ME HA HECHO ENTREGA DE LOS VIDEO PELICULAS EN BUEN ESTADO, ME COMPRETO"
				+ " A CUMPLIR CON LOS TERMINOS Y CONDICIONES DE MI PLAN DE MEMBRESIA.***") ;

		pw.close() ;

	} // método printFactura


	@Override
	public String toString() {

		String pattern = "%-26s%-26s%-26s" ;
		String patron = "%-18s%-20s%-18s%-18s" ;

		return  "FACTURA\t\t\t\t PLAZA DAVISON, LEVITOWN P.R\n\n" 
		+ "VIDEO PLACE\n".repeat(5) + "\n(787)-784-1365 \t\t\t FECHA: " + fecha 
		+ "\n\nNOMBRE: " + nombre + "\nNO. SOCIO: " + numeroSocio 
		+ "\n_____________________________________________________________________\n" 
		+ String.format( pattern , "TRANSACCION POR ","EFECTIVO", "CREDITO")
		+ String.format( pattern , "\n--------------" ,"--------------", "--------------")
		+ String.format( pattern , this.transaccionPor, "      "+ efectivo, "      " + credito)
		+ "\n_____________________________________________________________________|"
		+ String.format( patron , "\nCANTIDAD", "DESCRIPCION", "PRECIO UNIDAD", "SUB-TOTAL") 
		+ String.format( patron , "\n--------" ,"------------", "-------------", "----------") ;

	} // toString()

} // class
