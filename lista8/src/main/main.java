package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Sineek
 */
public class main {

    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/lista8";
    public static int escolha;
    public static Statement stm;
    public static Connection conexao;

    public static void iniciarConexao() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        conexao = DriverManager.getConnection(DATABASE_URL, "postgres", "postgres");
        stm = conexao.createStatement();
        System.out.println("Conexão efetuada com sucesso \n");
    }

    public static void fecharConexao() throws SQLException {
        stm.close();
        System.out.println("Conexão fechada com sucesso\n");
    }

    public static int contarLinhas() throws ClassNotFoundException, SQLException {
        int quantidadeDeProdutos = 0;
        iniciarConexao();
        String qtdProdutos = "SELECT count(codigo) FROM Produtos";
        ResultSet result = stm.executeQuery(qtdProdutos);
        result.next();
        quantidadeDeProdutos = Integer.parseInt(result.getArray(1).toString());

        fecharConexao();
        return quantidadeDeProdutos;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        escolha = 0;
        while (escolha != 4) {
            int escolha = Integer.parseInt(JOptionPane.showInputDialog(null, "O que você deseja fazer no sistema?\n"
                    + "[1] Listar todos os produtos cadastrados\n"
                    + "[2] Cadastrar um novo produto\n"
                    + "[3] Realizar uma venda\n"
                    + "[4] Sair"));
            switch (escolha) {
                case 1:
                    iniciarConexao();
                    String consulta = "SELECT * FROM Produtos";
                    ResultSet result = stm.executeQuery(consulta);

                    result.next();
                    String aux = "";
                    for (int j = 1; j <= contarLinhas(); j++) {
                        aux += "Código do produto: " + result.getArray(1) + "\n"
                                + "Nome do produto: " + result.getArray(2) + "\n"
                                + "Quantidade em estoque:" + result.getArray(3) + "\n"
                                + "Valor unitário: " + result.getArray(4) + "\n"
                                + "\n";
                        result.getArray(1);
                        result.next();
                    }
                    JOptionPane.showMessageDialog(null, aux);
                    fecharConexao();
                    break;
                case 2:
                    iniciarConexao();
                    int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o Código do Produto"));
                    String nome = JOptionPane.showInputDialog(null, "Digite o Nome do Produto");
                    int qtd = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a Quantidade em Estoque do Produto"));
                    int preco = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o Preço Unitário do Produto"));
                    String insercao = "INSERT INTO produtos VALUES (" + codigo + ", '" + nome + "', " + qtd + ", " + preco + ")";
                    stm.execute(insercao);
                    fecharConexao();
                    break;
                case 3:
                    iniciarConexao();
                    conexao.setAutoCommit(false);
                    conexao.commit();
                    //Criando a instância de Venda
                    String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do vendedor");
                    int codigoVenda = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o Código da Venda"));
                    String data = JOptionPane.showInputDialog(null, "Digite a data");
                    int codigoProd = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o código do Produto"));
                    int qtdProd = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a Quantidade de Produtos"));
                    float valor_total = codigoProd * qtdProd;

                    //insert venda
                    String insercaoVenda = "INSERT INTO vendas VALUES (" + codigoVenda + ", '" + valor_total + "', '" + cpf + "', '" + data + "')";
                    stm.execute(insercaoVenda);

                    //atualizar estoque do produto
                    String removeProdutoEstoque = "SELECT quant_estoque FROM produtos WHERE codigo = " + codigoProd;
                    ResultSet resultAux = stm.executeQuery(removeProdutoEstoque);
                    resultAux.next();
                    String auxFinal = resultAux.getString("quant_estoque");
                    int auxFinalMesmo = Integer.parseInt(auxFinal);
                    auxFinalMesmo = auxFinalMesmo - qtdProd;
                    String atualizaEstoque = "UPDATE produtos SET quant_estoque = '" + auxFinalMesmo + "' WHERE codigo = " + codigoProd;
                    stm.execute(atualizaEstoque);

                    //insert itens_venda
                    String insercaoItensVenda = "INSERT INTO itens_venda VALUES (" + codigoVenda + ", " + codigoProd + ", " + qtdProd + ")";
                    stm.execute(insercaoItensVenda);
                    conexao.commit();
                    fecharConexao();
                    break;
                case 4:
                    escolha = 4;
                    return;
            }
        }
    }

}
