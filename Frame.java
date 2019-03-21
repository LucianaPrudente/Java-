package javaapplication11luh;
//import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
        
public class Javaaplicacao1 extends JFrame implements ActionListener {
    
    JLabel lNome,lEnd,lBairro,lEst,lCidade,lPeso, lAltura, lIMC;
    JTextField tfNome,tfEnd,tfBairro,tfEst,tfCidade, tfPeso, tfAltura, tfIMC; //Campo de texto
    JComboBox cbEst,cbCidade;
    JButton bGravar, bLimpar, bSair, bCalcularIMC;
    
    public Javaaplicacao1() { //Método construtor 
        setLayout(new FlowLayout());
        
        lNome = new JLabel("Nome:");     
        add(lNome);
        tfNome = new JTextField(20);//Instância de tfNome 
        tfNome.addActionListener(this);     
        add(tfNome);
        
        lEnd = new JLabel("Endereço:");     
        add(lEnd);
        tfEnd = new JTextField(18);
        tfEnd.addActionListener(this);     
        add(tfEnd);
        
        lBairro = new JLabel("Bairro:");    add(lBairro);
        tfBairro = new JTextField(20);
        tfBairro.addActionListener(this);   
        add(tfBairro);
        
        lPeso = new JLabel ("Peso:");       add(lPeso); 
        tfPeso = new JTextField(20);
        tfPeso.addActionListener(this);     add(tfPeso);
        
        lAltura = new JLabel ("Altura:");   add(lAltura); 
        tfAltura = new JTextField(20);
        tfAltura.addActionListener(this);   add(tfAltura);
        
        lIMC = new JLabel ("IMC:");         add(lIMC); 
        tfIMC = new JTextField(20);
        tfIMC.setEditable(false);           add(tfIMC);
        
        //BOTÃO PARA LEITURA DO IMC
        bCalcularIMC = new JButton ("Calcular IMC");
        bCalcularIMC.addActionListener(this);   add(bCalcularIMC);
        
        
        lEst = new JLabel("Estado:");       add(lEst);
        
        String estado [] = {"","AC","AL","AP","AM","BA","CE","DF","ES","GO","MA"};
        cbEst = new JComboBox(estado);      add(cbEst);
        
        lCidade = new JLabel("Cidade:");    add(lCidade);
        
        String cidade [] = {"","Rio Branco","Maceió","Macapá","Manaus","Salvador",
                 "Fortaleza","Brasília","Vitória","Goiânia","São Luís","Imperatriz"};
        cbCidade = new JComboBox(cidade);   add(cbCidade);
        
        bGravar = new JButton("Gravar");       
        bGravar.addActionListener(this);  
        add(bGravar);
        
        bLimpar = new JButton("Limpar");        
        bLimpar.addActionListener(this);
         add(bLimpar);//Correção
        
        bSair = new JButton("Sair");       
        bSair.addActionListener(this); 
        add(bSair);
      
        setTitle("Aplicação");
        setSize(700, 300);
        setVisible(true);
}
   
    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == tfNome){
            if(tfNome.getText().length() == 0 ){
                JOptionPane.showMessageDialog(null, "*Campo de preenchimento vazio*");
                } else if (ae.getSource() == tfNome){
                    tfEnd.requestFocus();
                    } else if (ae.getSource() == tfEnd){
                         tfBairro.requestFocus();
                           
        
                    }
        }
        
        if (ae.getSource () == bGravar){
              JOptionPane.showConfirmDialog( null, "Vamos gravar"); 
              //JOptionPane.showInputDialog(null, "arroz");
        }
        
        if(ae.getSource () == bLimpar){
            tfNome.setText("");
            tfEnd.setText("");
            tfBairro.setText("");
            cbEst.setSelectedIndex(0);
            cbCidade.setSelectedIndex(0);
            } else if(ae.getSource () == bSair){
                JOptionPane.showConfirmDialog( null, "Vamos sair"); 
                JOptionPane.showInputDialog(null, "Por quê?");
                System.exit(0);
                }else if (ae.getSource() ==  bCalcularIMC){
                    CalculoIMC c = new CalculoIMC(); 
                    int x = c.texto(3); 
                    JOptionPane.showMessageDialog(null, x);
                   // double IMC = c.calculo(20, 5);
                   //double IMC = c.calculo(Double.parseDouble((tfAltura.getText()), Double.parseDouble(tfPeso.getText())));
                    //OUTRA FORMA PARA RECEPÇAÕ E CÁLCULO: 
                    double peso = Double.parseDouble(tfPeso.getText()); 
                    double alt = Double.parseDouble(tfAltura.getText()); 
                    double IMC = c.calculo(alt, peso); 
                    tfIMC.setText(String.valueOf(IMC));
                 
                    c.valor();
                }
        }
    
    public static void main(String[] args) {
          Javaaplicacao1 a = new Javaaplicacao1(); //Instância
          a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }
}

    //  System.out.println(ae);
    
/*          (ae.getSource() == tfEnd){
            tfBairro.requestFocus();
        }*/
        
 //-----------------------------------------------------------------------------------
        
//        CÁLCULO DE IMC (CLASSE): 

package javaapplication11luh;

import javax.swing.JOptionPane;

public class CalculoIMC { // no projeto e no pacote 
// Como não tem uma funcao principal, será uma classe de uso. Herdar/ Herança     
    public int texto(int x){ //MÉTODO 
        //JOptionPane.showMessageDialog(null, "");
        return 2+x;
    }
    
    public double calculo (double a, double p){
        
        return p/(a*a);
}
  
    protected void valor (){// no pacote ........ private retorno na classe. 
        //
        JOptionPane.showMessageDialog(null," ");
    }
