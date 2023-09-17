package kraftheinz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import kraftheinz.model.Adm;
import kraftheinz.model.Enquete;
import kraftheinz.model.Usuario;

public class AdmDAO {

	Connection con;

	public AdmDAO(Connection con) {
		this.con = con;
	}

	// metodos de inserção, deletar e alterar na table adm.
	public void insert(Adm adm) throws SQLException {

		PreparedStatement stmt = con
				.prepareStatement("INSERT INTO tbl_adm (id_adm, cod_adm,senha_adm) VALUES (?, ?, ?)");

		stmt.setInt(1, adm.getIdAdm());
		stmt.setString(2, adm.getCodigoAdm());
		stmt.setInt(3, adm.getSenhaAdm());

		stmt.executeUpdate();
	}

	public void deletar(int Id) throws SQLException {

		PreparedStatement stmt = con.prepareStatement("DELETE FROM tbl_adm WHERE id_adm = ?");
		stmt.setInt(1, Id);
		int qtd = stmt.executeUpdate();
		if (qtd == 0)
			throw new SQLException("Id não encontrado para remoção");
	}

	public void altera(String codigo, int senha, int id) throws SQLException {

		PreparedStatement stmt = con.prepareStatement("UPDATE tbl_adm SET cod_adm = ?, senha_adm = ? WHERE id_adm = ?");
		stmt.setString(1, codigo);
		stmt.setInt(2, senha);
		stmt.setInt(3, id);
		stmt.executeUpdate();
	}

	public List<Enquete> selecionaPorCidade(String cidade) throws SQLException {

		List<Enquete> retorno = new LinkedList<>();

		PreparedStatement stmt = con.prepareStatement("SELECT * FROM tbl_enquete WHERE cidade_tbl = ?");

		stmt.setString(1, cidade);

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {

			Enquete enquete = new Enquete();

			enquete.setId(rs.getInt("id_tbl"));
			enquete.setEstado(rs.getString("estado_tbl"));
			enquete.setCidade(rs.getString("cidade_tbl"));
			enquete.setFreqMercado(rs.getInt("freq_tbl"));
			enquete.setProduto(rs.getString("produto_tbl"));
			enquete.setProdMaisGosta(rs.getString("prodMaisGosta_tbl"));

			retorno.add(enquete);
		}

		return retorno;
	}

	// metodo para selecionar p/ estado
	public List<Enquete> selecionaPorEstado(String estado) throws SQLException {

		List<Enquete> retorno = new LinkedList<>();

		PreparedStatement stmt = con.prepareStatement("SELECT * FROM tbl_enquete WHERE estado_tbl = ?");

		stmt.setString(1, estado);

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {

			Enquete enquete = new Enquete();

			enquete.setId(rs.getInt("id_tbl"));
			enquete.setEstado(rs.getString("estado_tbl"));
			enquete.setCidade(rs.getString("cidade_tbl"));
			enquete.setFreqMercado(rs.getInt("freq_tbl"));
			enquete.setProduto(rs.getString("produto_tbl"));
			enquete.setProdMaisGosta(rs.getString("prodMaisGosta_tbl"));

			retorno.add(enquete);
		}

		return retorno;
	}

	// metodo para selecionar p/ produto
	public List<Enquete> selecionaPorProduto(String produto) throws SQLException {

		List<Enquete> retorno = new LinkedList<>();

		PreparedStatement stmt = con.prepareStatement("SELECT * FROM tbl_enquete WHERE produto_tbl = ?");

		stmt.setString(1, produto);

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {

			Enquete enquete = new Enquete();

			enquete.setId(rs.getInt("id_tbl"));
			enquete.setEstado(rs.getString("estado_tbl"));
			enquete.setCidade(rs.getString("cidade_tbl"));
			enquete.setFreqMercado(rs.getInt("freq_tbl"));
			enquete.setProduto(rs.getString("produto_tbl"));
			enquete.setProdMaisGosta(rs.getString("prodMaisGosta_tbl"));
			retorno.add(enquete);
		}

		return retorno;
	}

//	// metodo de retornar usuario
//	public Usuario voltaUsuario(int id) throws SQLException {
//
////		List<Enquete> retorno = new LinkedList<>();
//
//		PreparedStatement stmt = con.prepareStatement("SELECT * FROM tbl_usuario WHERE id_usu = ?");
//
//		stmt.setInt(1, id);
//
//		ResultSet rs = stmt.executeQuery();
//		
//		Usuario usuario = new Usuario();
//		
//		usuario.setId(rs.getInt("id_usu"));
//		usuario.setNome(rs.getString("nome_usu"));
//		usuario.setIdade(rs.getInt("idade_usu"));
//		usuario.setEmail(rs.getString("email_usu"));
//	
//		return usuario;
//	}

	public List<Usuario> selecionaUsuario(int id) throws SQLException {

		List<Usuario> retorno = new LinkedList<>();

		PreparedStatement stmt = con.prepareStatement("SELECT * FROM tbl_usuario WHERE id_usu = ?");

		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {

			Usuario usuario = new Usuario();

			usuario.setId(rs.getInt("id_usu"));
			usuario.setNome(rs.getString("nome_usu"));
			usuario.setIdade(rs.getInt("idade_usu"));
			usuario.setEmail(rs.getString("email_usu"));

			retorno.add(usuario);
		}

		return retorno;
	}

}
