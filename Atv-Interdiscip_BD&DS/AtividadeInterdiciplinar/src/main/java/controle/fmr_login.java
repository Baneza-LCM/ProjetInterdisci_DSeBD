/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import javax.swing.JFrame;
import conexao.Conexao;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import javax.swing.JButton;

/**
 *
 * @author desiree
 */
public class fmr_login extends JFrame
{
Conexao con_cliente;
JLabel rotulo1, rotulo2, rotulo3, rotulo4,imagem, imag;
JTextField texto1;
JPasswordField texto2;
JButton logar;
public fmr_login()
{
con_cliente = new Conexao(); 
con_cliente.conecta();   
setTitle("login");
Container tela1 = getContentPane();
tela1.setLayout(null);
tela1.setBackground(new Color(214, 181, 245));
ImageIcon icone = new ImageIcon("img/registrado.png");
imagem =new JLabel(icone);
imagem.setBounds(100,1,199,150);

rotulo1 = new JLabel("Usuario: ");
rotulo2 = new JLabel("Senha: ");
rotulo3 = new JLabel("Login ");
rotulo4 = new JLabel("Faça login para acessar registros ");
rotulo1.setBounds(50,200,100,30);
rotulo2.setBounds(50,250,100,30);
rotulo3.setBounds(130,30,200,200);
rotulo3.setForeground(new Color(0,0,0));
rotulo3.setFont(new Font("Times new Roman", Font.BOLD, 50));
rotulo4.setBounds(90,70,260,200);
rotulo4.setForeground(new Color(0,0,0));
rotulo4.setFont(new Font("Verdana", Font.PLAIN, 12));
//rotulo5 = new JLabel("ATENÇÃO!! Sua senha deve ser apenas numerica!");
//rotulo5.setBounds(70,330,290,30);
rotulo4.setFont(new Font("Verdana", Font.BOLD, 12));

ImageIcon iconee = new ImageIcon("img/atencao.png");
imag =new JLabel(iconee);
imag.setBounds(40,330,30,30);

texto1 = new JTextField(5);
texto2 = new JPasswordField(5);
texto1.setBounds(100,200,210,30);
texto2.setBounds(100,250,210,30);

logar = new JButton("Logar");
logar.setBounds(150,300,90,30);
logar.setBackground(new Color(138, 147, 255));

 

tela1.add(rotulo1);
tela1.add(rotulo2);
tela1.add(rotulo3);
tela1.add(rotulo4);
//tela1.add(rotulo5);
tela1.add(texto1);
tela1.add(texto2);
tela1.add(logar);
tela1.add(imagem);
tela1.add(imag);

logar.addActionListener((ActionEvent e) -> {
     try{
           String pesquisa = "select * from tblusuario where Usuario like '" + texto1.getText() + "' && Senha like '" + texto2.getText() + "'";
         con_cliente.executaSQL(pesquisa);
         
         if(con_cliente.resultset.first())
         {//acesso ao from de cadastro
             menu mostrar = new menu();
             mostrar.setVisible(true);
             dispose();
         }
         else
         {
             JOptionPane.showMessageDialog(null, "\n Usuario não cadastrado!!","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
             con_cliente.desconecta();
             System.exit(0);
         }
     }catch(SQLException errosql){
            JOptionPane.showMessageDialog(null, "Erro no comando SQL! \n Erro: "+errosql,"Messagem do programa", JOptionPane.INFORMATION_MESSAGE);
        }
      }
   );

setSize(400, 500);
setVisible(true);
setLocationRelativeTo(null);

}
public static void main(String args[]){
fmr_login app = new fmr_login();
app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
