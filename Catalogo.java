import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Catalogo {

	public static void main(String[] args) {

		int opcao = 0;

		String tituloDoFilme = null;
		String diretorDoFilme = null;
		String atorPrincipal = null;
		String generoDoFilme = null;
		int codigoDoFilme = 0;

		String menu = "Escolha a Opção: [1]- Incluir Filme\n, [2]- Alterar Filme \n, [3] - Excluir Filme\n, [4] - Listar Filmes\n, [5] - Sair\n";

		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

			switch (opcao) {

			case 1: // INCLUIR

				tituloDoFilme = JOptionPane.showInputDialog(null, "Qual o título do filme?");
				diretorDoFilme = JOptionPane.showInputDialog(null, "Qual o nome do diretor?");
				atorPrincipal = JOptionPane.showInputDialog(null, "Qual o ator principal?");
				generoDoFilme = JOptionPane.showInputDialog(null, "Qual o genero do filme?");

				Filme filme = new Filme();
				filme.setTitulo(tituloDoFilme);
				filme.setDiretor(diretorDoFilme);
				filme.setAtorPrincipal(atorPrincipal);
				filme.setGenero(generoDoFilme);
				filme.inserir();
				JOptionPane.showMessageDialog(null, "Filme criado com sucesso!");

				break;

			case 2: // ALTERAR

				codigoDoFilme = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual filme você deseja alterar?"));
				String novoTituloDoFilme = JOptionPane.showInputDialog(null, "Qual o novo título do filme?");
				String novoDiretorDoFilme = JOptionPane.showInputDialog("Qual o novo diretor do filme?");
				String novoAtorPrincipal = JOptionPane.showInputDialog("Qual o novo ator principal do filme?");
				String novoGeneroDoFilme = JOptionPane.showInputDialog("Qual o novo genero do filme?");
				boolean filmeAlterado = false;
				
				Filme filmeAtualizado = new Filme();
				filmeAtualizado.setTitulo(novoTituloDoFilme);
				filmeAtualizado.setDiretor(novoDiretorDoFilme);
				filmeAtualizado.setAtorPrincipal(novoAtorPrincipal);
				filmeAtualizado.setGenero(novoGeneroDoFilme);
				filmeAtualizado.setCodigo(codigoDoFilme);
				filmeAtualizado.atualizar();

				JOptionPane.showMessageDialog(null, "Filme Alterado! ");
				break;

			case 3: // EXCLUIR

				codigoDoFilme = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual filme você deseja excluir?"));
				boolean filmeExcluido = false;

				Filme filmeApagado = new Filme();
				filmeApagado.setCodigo(codigoDoFilme);
				filmeApagado.apagar();

				JOptionPane.showMessageDialog(null,  "Filme Excluido!");

				break;

			case 4: // LISTAR

				Filme f = new Filme();
				f.listar();

				break;

			case 5: // SAIR
				JOptionPane.showMessageDialog(null, "Você saiu do catalogo");
				return;

			default: // Opção Inválida

				JOptionPane.showMessageDialog(null, "Opção Inválida! Tente novamente");

			}

		} while (opcao != 5);
	}
}
