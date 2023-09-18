/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import conexao.Conexao;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.table.DefaultTableModel;//para reconhecimento da JTable
/**
 *
 * @author Admin
 */
public class Controle extends JFrame
{
Conexao con_cliente;
JLabel rotulo1, rotulo2,rotulo3,rotulo4,rotulo5,rotulo6,rotulo7,rotulo8;
JTextField texto1, texto2, texto3, texto4,texto5,texto6,texto7,texto8;
JButton Prim,Ante,Prox,Ultim,NVRG,GRAV,ALTE,EXCL,Peq,sair;
JTable tblaluno;//datagrid
JScrollPane scp_tabela;// container para o datagrid




public Controle()
{   
con_cliente = new Conexao(); 
con_cliente.conecta();   
//fmr_login mostrar = new fmr_login();
//mostrar.setVisible(true);
setTitle("Registros");
Container tela = getContentPane();
tela.setLayout(null);
tela.setBackground(new Color(245, 179, 219));
ImageIcon icone = new ImageIcon("img/imge.png");
setIconImage(icone.getImage());

 rotulo1 = new JLabel("Codigo:: ");
 rotulo2 = new JLabel("Nome:: ");
 rotulo3 = new JLabel("Endereço:: ");
 rotulo4 = new JLabel("Data de nascimento:: ");
 rotulo5 = new JLabel("CPF:: ");
 rotulo7 = new JLabel("RG:: ");
 rotulo8 = new JLabel("Codigo do responsavel:: ");
 rotulo6 = new JLabel("Pesquisa por nome:");
 
 rotulo1.setBounds(50,30,200,20);
 rotulo2.setBounds(50,70,200,20);
 rotulo3.setBounds(50,110,200,20);
 rotulo4.setBounds(50,150,200,20);
 rotulo5.setBounds(50,190,200,20);
 rotulo7.setBounds(50,230,200,20);
 rotulo8.setBounds(50,270,200,20);
 rotulo6.setBounds(550, 370, 300, 20);
 
 rotulo1.setForeground(new Color(255, 255, 255));
 rotulo2.setForeground(new Color(255, 255, 255));
 rotulo3.setForeground(new Color(255, 255, 255));
 rotulo4.setForeground(new Color(255, 255, 255));
 rotulo5.setForeground(new Color(255, 255, 255));
 rotulo6.setForeground(new Color(255, 255, 255));
 rotulo7.setForeground(new Color(255, 255, 255));
 rotulo8.setForeground(new Color(255, 255, 255));
 
 texto1 = new JTextField(5);
 texto2 = new JTextField(5);
 texto3 = new JTextField(5);
 texto4 = new JTextField(5);
 texto5 = new JTextField(5);
 texto6 = new JTextField(5);
 texto7 = new JTextField(5);
 texto8 = new JTextField(5);
 
 texto1.setBounds(220,30,100,30);
 texto2.setBounds(220,70,210,30);
 texto3.setBounds(220,110,250,30);
 texto4.setBounds(220,150,250,30);
 texto5.setBounds(220,190,250,30);
 texto6.setBounds(220,230,250,30);
 texto7.setBounds(220,270,250,30);
 texto8.setBounds(700, 370, 250, 30);




        
  //Botoes=========================================================================================================//
  
        Prim=new JButton("Primeiro");
        Ante=new JButton("Anterior");
        Prox=new JButton("Próximo");
        Ultim=new JButton("Último");
        NVRG=new JButton("Novo Registro");
        GRAV=new JButton("Gravar");
        ALTE=new JButton("Alterar");
        EXCL=new JButton("Excluir");
        sair=new JButton("Sair");
        Peq=new JButton("Pesquisar");
        
        Prim.setBounds(900,40,150,40);
        Ante.setBounds(900,100,150,40);
        Prox.setBounds(900,160,150,40);
        Ultim.setBounds(900,220,150,40);
        NVRG.setBounds(1080,40,150,40);
        GRAV.setBounds(1080,100,150,40);
        ALTE.setBounds(1080,160,150,40);
        EXCL.setBounds(1080,220,150,40);
        Peq.setBounds(1000,370,100,20);
        sair.setBounds(1150,370,100,20);
        
        
        
        Ultim.setBackground(new Color(250, 90, 205));
        Prox.setBackground(new Color(250, 90, 205));
        Ante.setBackground(new Color(250, 90, 205));
        Prim.setBackground(new Color(250, 90, 205));
        NVRG.setBackground(new Color(250, 90, 205));
        GRAV.setBackground(new Color(250, 90, 205));
        ALTE.setBackground(new Color(250, 90, 205));
        EXCL.setBackground(new Color(250, 90, 205));
        
        Peq.setBackground(new Color(250, 90, 205));
        sair.setBackground(new Color(250, 90, 205));
        
        Ultim.setForeground(new Color(255, 255, 255));
        Prox.setForeground(new Color(255, 255, 255));
        Ante.setForeground(new Color(255, 255, 255));
        Prim.setForeground(new Color(255, 255, 255));
        NVRG.setForeground(new Color(255, 255, 255));
        GRAV.setForeground(new Color(255, 255, 255));
        ALTE.setForeground(new Color(255, 255, 255));
        EXCL.setForeground(new Color(255, 255, 255));
        
        Peq.setForeground(new Color(255, 255, 255));
        sair.setForeground(new Color(255, 255, 255));
        
        
        

    
  //================================================================================================================//
  
     //BT PRIMEIRO================================================================================================================//
       Prim.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try {
                    con_cliente.resultset.first();
                    mostrar_Dados();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Não foi possivel acessar o primeiro registro");
                }
                }
       });
    
   //BT ANTERIOR================================================================================================================//
      Ante.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e) {
               try{ if (con_cliente.resultset.previous()){
                    mostrar_Dados();
                } else{
                    JOptionPane.showMessageDialog(null, "\n Não foi possivel acessar o registro anterior pois esse é o primeiro !!","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE); 
                    } 
               }catch (SQLException excecao) {
                    JOptionPane.showMessageDialog(null,"\n Erro no Abterior :\n"+excecao,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
               
                }
        }
        );
      

        
        //BT PROXIMO================================================================================================================//
        Prox.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e) {
               try{ if (con_cliente.resultset.next()){
                    mostrar_Dados();
                } else{
                    JOptionPane.showMessageDialog(null, "\n Não foi possivel acessar proximo registro  pois esse é o ultimo !!","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE); 
                    } 
               }catch (SQLException excecao) {
                    JOptionPane.showMessageDialog(null,"\n Erro no proximo :\n"+excecao,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
               
                }
        }
        );
        
        //BT UTIMO================================================================================================================//

        Ultim.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try {
                    con_cliente.resultset.last();
                    mostrar_Dados();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Não foi possivel acessar o último registro");
                }
                }
        }
        );
        
         // BT NOVO REGISTRO=======================================================================================================//
         
           NVRG.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                texto1.setText("");
                texto2.setText("");
                texto3.setText("");
                texto4.setText("");
                texto5.setText("");
                texto6.setText("");
                texto7.setText("");
                }
           }
         );
           
          // BT GRAVAR=======================================================================================================//
          
          GRAV.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String Cod_aluno = texto1.getText();
                String nome = texto2.getText();
                String endereco = texto3.getText();
                String dt_nasc = texto4.getText();
                String cpf = texto5.getText();
                String rg = texto6.getText();
                String Cod_respon = texto7.getText();
                
                try {
                    String insert_sql="insert into aluno (Cod_aluno,nome,endereco,dt_nasc,cpf,rg,Cod_respon) values ('"+Cod_aluno+"','"+nome+"','"+endereco+"','"+dt_nasc+"','"+cpf+"','"+rg+"','"+Cod_respon+"')";
                    con_cliente.statement.executeUpdate(insert_sql);
                    JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    
                    con_cliente.executaSQL("select * from aluno order by Cod_aluno");
                    preencherTabela();
                    
                } catch (SQLException errosql) {
                    JOptionPane.showMessageDialog(null,"\n Erro na gravação :\n"+errosql,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
                }
          });
          
           // BT ALTERAR=======================================================================================================//
           
            ALTE.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String Cod_aluno = texto1.getText();
                String nome = texto2.getText();
                String endereco = texto3.getText();
                String dt_nasc = texto4.getText();
                String cpf = texto5.getText();
                String rg = texto6.getText();
                String Cod_respon = texto7.getText();
                String sql;
                String msg="";
                try {
                    if(texto1.getText().equals("")){
                    sql="insert into aluno (Cod_aluno,nome,endereco,dt_nasc,cpf,rg,Cod_respon) values ('"+Cod_aluno+"','"+nome+"','"+endereco+"','"+dt_nasc+"','"+cpf+"','"+rg+"','"+Cod_respon+"')";
                    msg="Gravação de um novo registro";
                    }else{
                    sql="update aluno set Cod_respon = '"+Cod_respon+"',nome='"+nome+"',endereco='"+endereco+"',dt_nasc='"+dt_nasc+"',cpf='"+cpf+"',rg='"+rg+"'where Cod_aluno="+texto1.getText();
                    msg="Alteração de registro";    
                    }
                    con_cliente.statement.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    
                    con_cliente.executaSQL("select * from aluno order by Cod_aluno");
                    preencherTabela();
                    
                } catch (SQLException errosql) {
                    JOptionPane.showMessageDialog(null,"\n Erro na gravação :\n"+errosql,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
                }
            });
          
           // BT EXCLUIR=======================================================================================================//
             
              EXCL.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                
                String sql="";
                
                try {
                    int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja excluir o registro: ", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION,3);
                    if(resposta==0){
                    sql="delete from aluno where Cod_aluno ="+texto1.getText();
                    int excluir=con_cliente.statement.executeUpdate(sql);
                    if (excluir==1){
                    JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!!","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    con_cliente.executaSQL("select * from aluno order by Cod_aluno");
                    preencherTabela();
                    posicionarRegistro();
                    }else{
                    JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário!!","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    
                    }
                    }
                                        
                } catch (SQLException excecao) {
                    JOptionPane.showMessageDialog(null,"\n Erro na exclusão :\n"+excecao,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
                }
              });
           
              
           // Bt PESQUISAR=======================================================================================================//
           
           Peq.addActionListener( new ActionListener(){
             public void actionPerformed(ActionEvent e) {
                try{
                    String pesquisa = "select * from aluno where nome like '"+texto4.getText();
                    con_cliente.executaSQL(pesquisa);
                    if(con_cliente.resultset.first()){
                        preencherTabela();
                    }
                    else{
                    JOptionPane.showMessageDialog(null, "\n Não existe dados com este paramêtro!!","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE); 
                    }                      
                } catch (SQLException errosql) {
                    JOptionPane.showMessageDialog(null,"\n Os dados digitados não foram localizados!! :\n"+errosql,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
                }
           }
           );
             
             // Bt SAIR=======================================================================================================//
           
             sair.addActionListener((ActionEvent e) -> {
                    int opcao;
                    Object[] botoes = {"Sim","Não"};
                    opcao = JOptionPane.showOptionDialog(null,"Deseja mesmo fechar a janela?","Fechar",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,botoes,botoes[0]);
                    if (opcao==JOptionPane.YES_OPTION)
                        System.exit(0);
                });
             

tela.add(rotulo1);
tela.add(rotulo2);
tela.add(rotulo3);
tela.add(rotulo4);
tela.add(rotulo5);
tela.add(rotulo6);
tela.add(rotulo7);
tela.add(rotulo8);
tela.add(texto1);
tela.add(texto2);
tela.add(texto3);
tela.add(texto4);
tela.add(texto5);
tela.add(texto6);
tela.add(texto7);
tela.add(texto8);
tela.add(Prim);
tela.add(Ante);
tela.add(Prox);
tela.add(Ultim);
tela.add(NVRG);
tela.add(ALTE);
tela.add(EXCL);
tela.add(GRAV);
tela.add(sair);
tela.add(Peq);


  //configuração do JTable=======================================================================
        
        tblaluno = new javax.swing.JTable();
        scp_tabela = new javax.swing.JScrollPane();
        
        tblaluno.setBounds(50,410,1500,200);
        scp_tabela.setBounds(50,410,1255,180);

        tela.add(tblaluno);
        tela.add(scp_tabela);
        
        tblaluno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(183, 211, 237)));
        tblaluno.setFont(new java.awt.Font("Arial",1, 12));
        
        tblaluno.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null}
        },
        new String [] {"Código", "Nome", "Endereço" , "Data de Nascimento", "CPF" , "RG", "Cogigo do responsavel"})
        {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false};
            
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];}});
        scp_tabela.setViewportView(tblaluno);
        
        tblaluno.setAutoCreateRowSorter(true);//ativa a classificação ordenada da tabela
        
        tblaluno.setBackground(new Color(183, 211, 237));
        scp_tabela.setBackground(new Color(183, 211, 237));
       
     //fim da configuração JTable===================================================================================
        
        
        
setSize(1380, 800); 
setVisible(true);
setLocationRelativeTo(null);
 con_cliente.executaSQL("select * from aluno order by Cod_aluno");
 preencherTabela();
 posicionarRegistro();
}
       public void preencherTabela()
    {
        tblaluno.getColumnModel().getColumn(0).setPreferredWidth(4);
        tblaluno.getColumnModel().getColumn(1).setPreferredWidth(130);
        tblaluno.getColumnModel().getColumn(2).setPreferredWidth(130);
        tblaluno.getColumnModel().getColumn(3).setPreferredWidth(55);
        tblaluno.getColumnModel().getColumn(4).setPreferredWidth(55);
        tblaluno.getColumnModel().getColumn(4).setPreferredWidth(4);
        
        DefaultTableModel modelo = (DefaultTableModel) tblaluno.getModel();
        modelo.setNumRows(0);
        
        try {
            con_cliente.resultset.beforeFirst();
            while(con_cliente.resultset.next()){
                modelo.addRow(new Object[]{
                    con_cliente.resultset.getString("Cod_aluno"),con_cliente.resultset.getString("nome"),con_cliente.resultset.getString("endereco"),con_cliente.resultset.getString("dt_nasc"),con_cliente.resultset.getString("cpf"),con_cliente.resultset.getString("rg"),con_cliente.resultset.getString("Cod_respon")
                });
            }
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "\n Erro ao listar dados da tabela!!:\n"+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    //=====================================================================
       
       public void posicionarRegistro() {
        try{
        con_cliente.resultset.first(); // posiciona no 1º registro da tabela
        mostrar_Dados(); 
        }catch(SQLException erro) {
        JOptionPane.showMessageDialog(null, "Não foi possivel posicionar no primeiro registro: "+erro,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }
        public void mostrar_Dados() {
        try {
            texto1.setText(con_cliente.resultset.getString("Cod_aluno"));
            texto2.setText(con_cliente.resultset.getString("nome")); 
            texto3.setText(con_cliente.resultset.getString("endereco"));
            texto4.setText(con_cliente.resultset.getString("dt_nasc"));
            texto5.setText(con_cliente.resultset.getString("cpf"));
            texto6.setText(con_cliente.resultset.getString("rg"));
            texto7.setText(con_cliente.resultset.getString("Cod_respon"));
        }
        catch(SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não localizou dados: "+erro,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
        }
        
   
   

}
