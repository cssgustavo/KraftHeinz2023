package kraftheinz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kraftheinz.model.Usuario;

public class UsuarioDAO {

	Connection con;

	public UsuarioDAO(Connection con) {
		this.con = con;
	}

	// metodos de inserção, deletar e alterar na table adm.
	public void insert(Usuario usu) throws SQLException {

		PreparedStatement stmt = con.prepareStatement(
				"INSERT INTO tbl_usuario (id_usu, nome_usu, idade_usu, email_usu) VALUES (?, ?, ?, ?)");

		stmt.setInt(1, usu.getId());
		stmt.setString(2, usu.getNome());
		stmt.setInt(3, usu.getIdade());
		stmt.setString(4, usu.getEmail());

		stmt.executeUpdate();
	}

	public void deletar(int Id) throws SQLException {

		PreparedStatement stmt = con.prepareStatement("DELETE FROM tbl_usuario WHERE id_usu = ?");
		stmt.setInt(1, Id);
		int qtd = stmt.executeUpdate();
		if (qtd == 0)
			throw new SQLException("Id não encontrado para remoção");
	}

	public void altera(String nome, int idade, String email, int id) throws SQLException {

		PreparedStatement stmt = con
				.prepareStatement("UPDATE tbl_usuario SET nome_usu = ?, idade_usu = ?, email_usu = ? WHERE id_usu = ?");
		stmt.setString(1, nome);
		stmt.setInt(2, idade);
		stmt.setString(3, email);
		stmt.setInt(4, id);
		stmt.executeUpdate();
	}

}
