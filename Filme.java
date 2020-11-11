import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Filme {

	private String titulo;
	private String diretor;
	private int codigoDoFilme;
	private String atorPrincipal;
	private String genero;

	public Filme() {
		
	}

	public String getTitulo() {
		return titulo;
	}

	public String setTitulo(String titulo) {
		return this.titulo = titulo;
	}

	public String getDiretor() {
		return diretor;
	}

	public String setDiretor(String diretor) {
		return this.diretor = diretor;
	}

	public int getCodigo() {
		return codigoDoFilme;
	}

	public void setCodigo(int codigoDoFilme) {
		this.codigoDoFilme = codigoDoFilme;
	}

	public String getAtorPrincipal() {
		return atorPrincipal;
	}

	public String setAtorPrincipal(String atorPrincipal) {
		return this.atorPrincipal = atorPrincipal;
	}

	public String getGenero() {
		return genero;
	}

	public String setGenero(String genero) {
		return this.genero = genero;
	}

	public String toString() {
		return String.format("Titulo: %s, Diretor: %s\n, Código de Registro: %s\n, Ator Principal: %s\n, Gênero: %s\n",
				this.titulo, this.diretor, this.atorPrincipal, this.codigoDoFilme, this.genero);
	}

	public void inserir() { // isso significa que o filme sabe se inserir no banco de dados//
		// 1: Definir o comando SQL
		String sql = "INSERT INTO tb_filme(titulo, diretor, ator_principal, genero) VALUES (?, ?, ?, ?)";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Preenche os dados faltantes
			ps.setString(1, this.titulo);
			ps.setString(2, this.diretor);
			ps.setString(3, this.atorPrincipal);
			ps.setString(4, this.genero);
			// 5: Executa o comando
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualizar() {
		// 1: Definir o comando SQL
		//"UPDATE tb_filme SET titulo = grease, diretor = JT, ator_principal = JT, genero = terror WHERE codigo = 3"
		
		String sql = "UPDATE tb_filme SET titulo = ?, diretor = ?, ator_principal = ?, genero = ? WHERE codigo = ?";

		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();

		try (Connection c = factory.obterConexao()) {

			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);

			// 4: Preenche os dados faltantes
			ps.setString(1, this.titulo);
			ps.setString(2, this.diretor);
			ps.setString(3, this.atorPrincipal);
			ps.setString(4, this.genero);
			ps.setInt(5, this.codigoDoFilme);
			// 5: Executa o comando

			ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void apagar() {

		// 1: Definir o comando SQL
		String sql = "DELETE FROM tb_filme WHERE codigo = ?";

		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()) {

			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);

			// 4: Preenche os dados faltantes
			ps.setInt(1, codigoDoFilme);

			// 5: Executa o comando
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void listar() {
		// 1: Definir o comando SQL
		String sql = "SELECT * FROM tb_filme";

		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()) {

			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);

			// 4: Executa o comando e guarda
			// o resultado em um ResultSet
			ResultSet rs = ps.executeQuery();

			// 5: itera sobre o resultado
			String lista = "";
			while (rs.next()) {
				int codigo = rs.getInt("codigo");
				String titulo = rs.getString("titulo");
				String diretor = rs.getString("diretor");
				String atorPrincipal = rs.getString("ator_principal");
				String genero = rs.getString("genero");
				String aux = String.format("Código: %d, Titulo: %s, Diretor: %s, Ator Principal: %s, Genero: %s", codigo, titulo, diretor,
						atorPrincipal, genero);
				lista = lista + "\n" + aux;
				
			}
				JOptionPane.showMessageDialog(null, lista);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
