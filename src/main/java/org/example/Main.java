package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.h2.command.dml.Insert;


public class Main {

    public static void main(String[] args) throws SQLException {

        String paramsConexao = "jdbc:h2:mem:testdb";
        String usuario = "";
        String senha = "";
        Connection conexao = DriverManager.getConnection(paramsConexao, usuario, senha);

        String criacaoSql = "create table pessoa (id int primary key, nome varchar(150), qtdAcesso int, naturalidade varchar(75) )";
        Statement stmtC = conexao.createStatement();
        stmtC.executeUpdate(criacaoSql);
        stmtC.close();

        Statement stmtInsert = conexao.createStatement();
        String insertpessoas = "insert into pessoa(id, nome, qtdAcesso, naturalidade) values (1, ' Cleiton', 10, 'Brasileiro')";
        stmtInsert.executeUpdate(insertpessoas);
        insertpessoas = "insert into pessoa(id, nome, qtdAcesso, naturalidade) values (2, 'Cacu', 20, 'Brasileiro')";
        stmtInsert.executeUpdate(insertpessoas);
        insertpessoas = "insert into pessoa(id, nome, qtdAcesso, naturalidade) values (3, 'José', 30, 'Brasileiro')";
        stmtInsert.executeUpdate(insertpessoas);
        insertpessoas = "insert into pessoa(id, nome, qtdAcesso, naturalidade) values (4, 'Pedro', 40, 'Brasileiro')";
        stmtInsert.executeUpdate(insertpessoas);
        stmtC.close();

        String consulta = "select * from pessoa";

        Statement stmt = conexao.createStatement();
        ResultSet resultado = stmt.executeQuery(consulta);


        while (resultado.next()) {
            String nome = resultado.getString("nome");
            Integer quantidade = resultado.getInt("qtdAcesso");
            String naturalidade = resultado.getString("naturalidade");

            Pessoa pessoa = new Pessoa();
            pessoa.setNome(nome);
            pessoa.setQuantidadeAcesso(quantidade);
            pessoa.setNaturalidade(naturalidade);

            System.out.println("Nome:" + pessoa.getNome());
            System.out.println("Quantidade:" + pessoa.getQuantidadeAcesso());
            System.out.println("Naturalidade:" + pessoa.getNaturalidade());

        }
    }

}