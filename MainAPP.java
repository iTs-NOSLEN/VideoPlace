package nelsonLozada;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MainAPP {

	Factura f1 = new Factura() ;
	ImageIcon foto = new ImageIcon("Foto.png") ;

	public MainAPP() throws Exception {

		while(true) {

			int confirm = JOptionPane.showConfirmDialog(null,"¿Desea crear una factura? " 
					,"VIDEO PLACE LEVITTOWN", 
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, foto ) ;

			if (confirm == 1 || confirm == 2) {
				break;

			} // if


			String ans = JOptionPane.showInputDialog("Nombre del socio: ");
			f1.setNombre(ans);

			ans = JOptionPane.showInputDialog("Número del socio: ");
			f1.setNumeroSocio(ans);

			ans = JOptionPane.showInputDialog("Nombre del empleado: ");
			f1.setTransaccionPor(ans);

			ans = JOptionPane.showInputDialog("Método de pago (Credito o Efectivo): ");
			f1.setMetPago(ans);

			f1.printFactura();

		} // while loop

	} // constructor

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		new MainAPP() ;

	} // main

} //class


