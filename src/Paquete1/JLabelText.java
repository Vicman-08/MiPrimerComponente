/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete1;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.BevelBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
/**
 *
 * @author Victor
 */
/*public class JLabelText extends JPanel{
    private JLabel etiqueta;
    private JTextArea cajatexto;
    
    public JLabelText(JLabel etiqueta,JTextArea cajatexto){
        super();
        this.etiqueta = etiqueta;
        this.cajatexto = cajatexto;
        
        this.setBorder(new BevelBorder(HEIGHT));
        this.setLayout(new BorderLayout());
        
        this.add(etiqueta,BorderLayout.WEST );
        this.add(cajatexto,BorderLayout.CENTER );
        
        this.repaint();
    }
    
    public JLabelText(String tituloEtiqueta, String mensajeCajaTexto){
        this(new JLabel(tituloEtiqueta), new JTextArea(mensajeCajaTexto));
    }
    
    public JLabelText(){
        this("Titulo ","Ingrese Texto");
    }

    public void setTituloEtiqueta(String Titulo){
        this.etiqueta.setText(Titulo);
        this.etiqueta.repaint();
    }
    public String getTituloEtiqueta(){
        return this.etiqueta.getText();
    }
    
    public void setCajaTexto(String Titulo){
        this.cajatexto.setText(Titulo);
        this.cajatexto.repaint();
    }
    public String getCajaTexto(){
        return this.cajatexto.getText();
    }
    
    public void setEtiquetaColor(Color color) {
        this.etiqueta.setForeground(color);
        this.etiqueta.repaint();
    }
    
    public Color getEtiquetaColor() {
        return this.etiqueta.getForeground();
    }
    
    public void setEtiquetaBackground(Color color) {
        this.etiqueta.setBackground(color);
        this.etiqueta.setOpaque(true);  
        this.repaint();  
    }
    
    public Color getEtiquetaBackground() {
        return this.etiqueta.getBackground();
    }

    public void setCajatextoColor(Color color) {
        this.cajatexto.setForeground(color);
        this.cajatexto.repaint();
    }
    
    public void setCajatextoBackground(Color color) {
        this.cajatexto.setBackground(color);
        this.cajatexto.setOpaque(true); 
        this.repaint(); 
    }

    public Color getCajatextoBackground() {
        return this.cajatexto.getBackground();
    }
    
}*/
public class JLabelText extends JPanel {
    private JLabel etiqueta;
    private JTextArea cajatexto;

    public JLabelText(JLabel etiqueta, JTextArea cajatexto) {
        super();
        this.etiqueta = etiqueta;
        this.cajatexto = cajatexto;
       
        this.setBorder(new BevelBorder(BevelBorder.RAISED));
        this.setLayout(new BorderLayout());

        this.add(etiqueta, BorderLayout.WEST);
        this.add(cajatexto, BorderLayout.CENTER);

        setEtiquetaBackground(Color.RED);
        setCajatextoBackground(Color.BLUE);

        setLimit(cajatexto, 30);

        etiqueta.setPreferredSize(new Dimension(100, 30)); 
        cajatexto.setPreferredSize(new Dimension(300, 30)); 

        this.repaint();
    }

    public JLabelText(String tituloEtiqueta, String mensajeCajaTexto) {
        this(new JLabel(tituloEtiqueta), new JTextArea(mensajeCajaTexto));
    }

    public JLabelText() {
        this("Titulo: ", "Ingrese Texto");
    }

    public void setTituloEtiqueta(String Titulo) {
        if (Titulo.length() <= 10) {
            this.etiqueta.setText(Titulo);
        } else {
            this.etiqueta.setText(Titulo.substring(0, 30)); // Limitar a 30 caracteres
        }
        this.etiqueta.repaint();
    }

    public String getTituloEtiqueta() {
        return this.etiqueta.getText();
    }

    public void setCajaTexto(String Titulo) {
        if (Titulo.length() <= 10) {
            this.cajatexto.setText(Titulo);
        } else {
            this.cajatexto.setText(Titulo.substring(0, 10)); 
        }
        this.cajatexto.repaint();
    }

    public String getCajaTexto() {
        return this.cajatexto.getText();
    }

    public void setEtiquetaColor(Color color) {
        this.etiqueta.setForeground(color);
        this.etiqueta.repaint();
    }

    public Color getEtiquetaColor() {
        return this.etiqueta.getForeground();
    }

    public void setEtiquetaBackground(Color color) {
        this.etiqueta.setBackground(color);
        this.etiqueta.setOpaque(true);
        this.repaint();
    }

    public Color getEtiquetaBackground() {
        return this.etiqueta.getBackground();
    }

    public void setCajatextoColor(Color color) {
        this.cajatexto.setForeground(color);
        this.cajatexto.repaint();
    }

    public void setCajatextoBackground(Color color) {
        this.cajatexto.setBackground(color);
        this.cajatexto.setOpaque(true);
        this.repaint();
    }

    public Color getCajatextoBackground() {
        return this.cajatexto.getBackground();
    }

    private void setLimit(JTextArea textArea, int limit) {
        PlainDocument doc = (PlainDocument) textArea.getDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string != null && (doc.getLength() + string.length() <= limit)) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text != null && (doc.getLength() - length + text.length() <= limit)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            @Override
            public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
                super.remove(fb, offset, length);
            }
        });
    }
}