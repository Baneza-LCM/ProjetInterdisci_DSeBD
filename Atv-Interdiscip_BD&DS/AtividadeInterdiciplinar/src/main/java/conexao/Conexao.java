/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

/**
 *
 * @author Admin
 */
import java.sql.*;
import javax.swing.JOptionPane;

public class Conexao {  final private String driver = "com.mysql.cj.jdbc.Driver";
    final private String url = "jdbc:mysql://localhost/escolaedu";
    final private String usuario = "root";
    final private String senha = "";
    private Connection conexao;
    public Statement statement;
    public ResultSet resultset;
    
    public boolean conecta(){
        boolean result = true;
        try{
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,usuario,senha);
            JOptionPane.showMessageDialog(null, "Conexão estabelecida!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }catch(ClassNotFoundException Driver){
            JOptionPane.showMessageDialog(null, "Driver não localizado!"+Driver,"Messagem do programa", JOptionPane.INFORMATION_MESSAGE);
            result = false;
        }catch(SQLException Fonte){
            JOptionPane.showMessageDialog(null, "Fonte de dados não localizada!"+Fonte,"Messagem do programa", JOptionPane.INFORMATION_MESSAGE);
            result = false;
        }
        return result;
}
    
    public void desconecta() {
        try{
            conexao.close();
            JOptionPane.showMessageDialog(null, "Conexao com banco fechada!","Messagem do programa", JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (SQLException fecha){   
            JOptionPane.showMessageDialog(null, "Erro ao fechar o banco!","Messagem do programa", JOptionPane.INFORMATION_MESSAGE);
 
        }
    }
    
    public void executaSQL(String sql){
        try{
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(sql);
        }
        catch(SQLException excecao){
            JOptionPane.showMessageDialog(null, "Erro no comando SQL! \n Erro: "+excecao,"Messagem do programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}

