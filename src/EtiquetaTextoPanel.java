import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.AttributeSet;
import javax.swing.text.DocumentFilter;
import java.awt.*;

public class EtiquetaTextoPanel extends JPanel {
    private JLabel etiqueta;
    private JTextField cuadroTexto;

    public EtiquetaTextoPanel(String textoEtiqueta, int limiteCaracteres) {
        setLayout(new FlowLayout()); // Usar FlowLayout para disposición horizontal
        etiqueta = new JLabel(textoEtiqueta);
        cuadroTexto = new JTextField(15); // 15 es el número de columnas

        // Configurar el JTextField
        cuadroTexto.setBackground(Color.LIGHT_GRAY);
        cuadroTexto.setFont(new Font("Arial", Font.PLAIN, 14));

        // Limitar la cantidad de caracteres
        ((AbstractDocument) cuadroTexto.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (fb.getDocument().getLength() + string.length() <= limiteCaracteres) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (fb.getDocument().getLength() - length + text.length() <= limiteCaracteres) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            @Override
            public void remove(DocumentFilter.FilterBypass fb, int offset, int length) throws BadLocationException {
                super.remove(fb, offset, length);
            }
        });

        // Agregar componentes al panel
        add(etiqueta);
        add(cuadroTexto);
    }

    // Métodos para personalizar el panel
    public void setColorFondo(Color color) {
        cuadroTexto.setBackground(color);
    }

    public void setTamanoFuente(Font font) {
        cuadroTexto.setFont(font);
    }

    public String getTexto() {
        return cuadroTexto.getText();
    }

    public void setTexto(String texto) {
        cuadroTexto.setText(texto);
    }
    /*public EtiquetaTextoPanel(String textoEtiqueta, String textoCaja){
    this(new JLabel(textoEtiqueta), new JTextArea(textoCaja));
    }*/
}