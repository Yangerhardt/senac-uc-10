import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        
        
        conn = new conectaDAO().connectDB();
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    public void venderProduto(int idProduto) {
    try {
        conn = new conectaDAO().connectDB();
        
        String sql = "UPDATE tabela_produtos SET status = 'Vendido' WHERE id = ?";
        prep = conn.prepareStatement(sql);
        prep.setInt(1, idProduto);
        
        prep.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Produto vendido com sucesso!");
    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null, "Erro ao vender produto: " + erro.getMessage());
    }
}
}

