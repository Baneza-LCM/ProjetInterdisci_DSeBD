/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;
import conexao.Conexao;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

/**
 *
 * @author dti
 */
public class menu extends JFrame
{
Conexao con_cliente;
JLabel imagem;
JButton Prof, aluno, disc, sobre;
Inicial sobrejanela;
public menu(){
con_cliente = new Conexao(); 
con_cliente.conecta(); 

setTitle("Menu de opções");
Container tela = getContentPane();
tela.setBackground(new Color(255, 255, 255));
tela.setBackground(new Color(200, 227, 247));
setLayout(null);
ImageIcon iconee = new ImageIcon("img/infantil.png");//*caminho para a minha imagem na altura do src
imagem = new JLabel(iconee);
imagem.setBounds(150,40,299,140);



Prof = new JButton("Professores");
Prof.setBounds(80,180,150,130);
Prof.setBackground(new Color(245, 245, 179));
Prof.setFont(new Font("Verdana", Font.PLAIN, 20));
Prof.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 102), 3));
Prof.setToolTipText("Abrir registro de professores");


aluno = new JButton("Alunos");
aluno.setBounds(380,180,150,130);
aluno.setBackground(new Color(245, 179, 219));
aluno.setFont(new Font("Verdana", Font.PLAIN, 20));
aluno.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 102), 3));
aluno.setToolTipText("Abrir registro de alunos");


disc = new JButton("Disciplina");
disc.setBounds(80,350,150,130);
disc.setBackground(new Color(199, 245, 179));
disc.setFont(new Font("Verdana", Font.PLAIN, 20));
disc.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 102), 3));
disc.setToolTipText("Abrir registro de disciplinas");

sobre = new JButton("Sobre Nos");
sobre.setBounds(380,350,150,130);
sobre.setBackground(new Color(245, 212, 179));
sobre.setFont(new Font("Verdana", Font.PLAIN, 20));
sobre.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 102), 3));
sobre.setToolTipText("Abrir o sobre criadores");

UIManager.put("ToolTip.background",SystemColor.info);

//========================================================================================================================================================//
Prof.addActionListener((ActionEvent e) -> {
     try{
         if(con_cliente.resultset.first())
         {//acesso ao from de cadastro
             //Controle mostrar = new Controle();
             //mostrar.setVisible(true);
             //dispose();
         }
         else
         {
             JOptionPane.showMessageDialog(null, "\n Pagina Não encontrada!!","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
             con_cliente.desconecta();
             System.exit(0);
         }
     }catch(SQLException errosql){
            JOptionPane.showMessageDialog(null, "Erro no comando SQL! \n Erro: "+errosql,"Messagem do programa", JOptionPane.INFORMATION_MESSAGE);
        }
      }
   );
//========================================================================================================================================================//
aluno.addActionListener((ActionEvent e) -> {
    Controle mostrar = new Controle();
    mostrar.setVisible(true);
      }
   );
//========================================================================================================================================================//
disc.addActionListener((ActionEvent e) -> {
     try{
         if(con_cliente.resultset.first())
         {//acesso ao from de cadastro
             //Controle mostrar = new Controle();
             //mostrar.setVisible(true);
             //dispose();
         }
         else
         {
             JOptionPane.showMessageDialog(null, "\n Pagina Não encontrada!!","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
             con_cliente.desconecta();
             System.exit(0);
         }
     }catch(SQLException errosql){
            JOptionPane.showMessageDialog(null, "Erro no comando SQL! \n Erro: "+errosql,"Messagem do programa", JOptionPane.INFORMATION_MESSAGE);
        }
      }
   );
//========================================================================================================================================================//
sobre.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
sobrejanela = new Inicial(null,"sobre janela",true);
sobrejanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
sobrejanela.setVisible(true);
     }
   }
);
//========================================================================================================================================================//
tela.add(imagem);
tela.add(Prof);
tela.add(aluno);
tela.add(disc);
tela.add(sobre);
setSize(600, 590);
setLocationRelativeTo(null);
setVisible(true);
}


 public class Inicial extends JDialog{
JButton sair;
JLabel rotulo,rotulo2,rotulo3,rotulo4,rot;
public Inicial(Frame owner, String title,boolean modal)
{
super(owner,title,modal);
Container tela1 = getContentPane();
tela1.setLayout(null);
tela1.setBackground(new Color(245, 236, 144));
rot = new JLabel("Sobre Nós!!");
rot.setForeground(new Color(0,0,0));
rot.setFont(new Font("Times new Roman", Font.BOLD, 50));
rotulo = new JLabel("Nome:   Desirée Constantino de Almeida Barboza");
rotulo2 = new JLabel("Nome:  Camilly Demarco dos Santos ");
rotulo3 = new JLabel("Nome:  Baneza Livia Coarite Manzaeda");
rotulo4 = new JLabel("2° Ano de Desenvolvimento de Sistemas");

rot.setBounds(20,10,280,80);
rotulo.setBounds(20,80,280,20);
rotulo2.setBounds(20,110,280,20);
rotulo3.setBounds(20,140,280,20);
rotulo4.setBounds(20,170,280,20);


tela1.add(rot);
tela1.add(rotulo);
tela1.add(rotulo2);
tela1.add(rotulo3);
tela1.add(rotulo4);

sair = new JButton("Voltar");
sair.setBounds(50,250,100,20);

TBesair tesair = new TBesair();
sair.addActionListener(tesair);
tela1.add(sair);
setSize(400,400);
setLocationRelativeTo(null);
}
 
private class TBesair implements ActionListener{ 
public void actionPerformed(ActionEvent evento){
{ 
sobrejanela.setVisible(false);
sobrejanela.dispose();
}
}
}
 }
}














