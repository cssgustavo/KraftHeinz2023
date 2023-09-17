package kraftheinz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kraftheinz.model.Enquete;

public class EnqueteDAO {

	Connection con;

	public EnqueteDAO(Connection con) {
		this.con = con;
	}

	// metodos de inserção, deletar e alterar na table adm.
	public void insert(Enquete enq) throws SQLException {

		PreparedStatement stmt = con.prepareStatement(
				"INSERT INTO tbl_enquete(id_tbl, estado_tbl, cidade_tbl, freq_tbl, produto_tbl, prodMaisGosta_tbl) VALUES (?, ?, ?, ?, ?, ?)");

		stmt.setInt(1, enq.getId());
		stmt.setString(2, enq.getEstado());
		stmt.setString(3, enq.getCidade());
		stmt.setInt(4, enq.getFreqMercado());
		stmt.setString(5, enq.getProduto());
		stmt.setString(6, enq.getProdMaisGosta());

		stmt.executeUpdate();
	}

	public void deletar(int Id) throws SQLException {

		PreparedStatement stmt = con.prepareStatement("DELETE FROM tbl_enquete WHERE id_tbl = ?");
		stmt.setInt(1, Id);
		int qtd = stmt.executeUpdate();
		if (qtd == 0)
			throw new SQLException("Id não encontrado para remoção");
	}

	public void altera(String estado, String cidade, int freq, String produto, String prodMaisGosta, int id)
			throws SQLException {

		PreparedStatement stmt = con.prepareStatement(
				"UPDATE tbl_enquete SET estado_tbl = ?, cidade_tbl = ?, freq_tbl = ?, produto_tbl = ?, prodMaisGosta_tbl = ? WHERE id_tbl = ?");
		stmt.setString(1, estado);
		stmt.setString(2, cidade);
		stmt.setInt(3, freq);
		stmt.setString(4, produto);
		stmt.setString(5, prodMaisGosta);
		stmt.setInt(6, id);

		stmt.executeUpdate();
	}

}
