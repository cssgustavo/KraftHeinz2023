package kraftheinz.view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import kraftheinz.dao.AdmDAO;
import kraftheinz.dao.EnqueteDAO;
import kraftheinz.dao.UsuarioDAO;
import kraftheinz.jdbc.Conexao;
import kraftheinz.model.Adm;
import kraftheinz.model.Enquete;
import kraftheinz.model.Usuario;
import kraftheinz.random.GerarNumAleatorio;

public class Play {

	public static void main(String[] args) throws SQLException {

		try {

			Scanner entrada = new Scanner(System.in);

			// criar Daos com a conexao
			UsuarioDAO usuariodao = new UsuarioDAO(Conexao.getConexao());
			EnqueteDAO enquetedao = new EnqueteDAO(Conexao.getConexao());
			AdmDAO admdao = new AdmDAO(Conexao.getConexao());

			System.out.printf("%80s", "Bem Vindo a KraftFutures 2023!");
			System.out.println();
			System.out.printf("%80s", "------------------------------");
			System.out.println();
			System.out.println();
			System.out.printf("%77s", "Digite a opcao que deseja: ");
			System.out.println();
			System.out.println("");
			System.out.printf("%80s", "1. Quero responder a enquete !");
			System.out.println();
			System.out.printf("%64s", "2. Sou um ADM!");
			System.out.println();

			// opcao menu
			int opcaoMenu = entrada.nextInt();

			GerarNumAleatorio gerar = new GerarNumAleatorio();
			switch (opcaoMenu) {
			case 1:
				// invoca um usuario
				Usuario usuario = new Usuario();
				Enquete enq = new Enquete();

				System.out.printf("%76s", "Vamos comecar a enquete...");
				System.out.println();
				System.out.println("");

				int idRandom = gerar.gerarNumeroAleatorio();
				System.out.printf("%67s", "Id atribuido: " + idRandom);
				System.out.println();

				usuario.setId(idRandom);
				enq.setId(idRandom);

				System.out.printf("%67s", "Digite seu nome: ");
				String nomeUsuario = entrada.next();
				usuario.setNome(nomeUsuario);

				System.out.printf("%68s", "Digite sua idade: ");
				int idadeUsuario = entrada.nextInt();
				usuario.setIdade(idadeUsuario);

				System.out.printf("%68s", "Digite seu email: ");
				String emailUsuario = entrada.next();
				usuario.setEmail(emailUsuario);
				System.out.println("");
				System.out.println("");

				System.out.printf("%77s", "Certo, Vamos as perguntas: ");
				System.out.println();
				System.out.printf("%80s", "------------------------------");
				System.out.println();
				System.out.println("");

				System.out.printf("%78s", "Use siglas (ex.: sp, mg, rj)");
				System.out.println();
				System.out.printf("%71s", "Digite o seu Estado: ");
				String estadoEnq = entrada.next();
				enq.setEstado(estadoEnq);

				System.out.printf("%71s", "Digite a sua Cidade: ");
				String cidadeEnq = entrada.next();
				enq.setCidade(cidadeEnq);

				System.out.printf("%76s", "Quantas vezes você vai ao ");
				System.out.println();
				System.out.printf("%68s", "mercado por mes? :");
				int freqEnq = entrada.nextInt();
				enq.setFreqMercado(freqEnq);

				System.out.printf("%74s", "Qual produto nosso sente");
				System.out.println();
				System.out.printf("%69s", "falta no mercado?: ");
				String produtoEnq = entrada.next();
				enq.setProduto(produtoEnq);

				System.out.printf("%75s", "E qual voce mais gosta?: ");
				String prodMaisGosta = entrada.next();
				enq.setProdMaisGosta(prodMaisGosta);

				usuariodao.insert(usuario);
				enquetedao.insert(enq);
				usuario.setEnquete(enq);

				System.out.println("");
				System.out.printf("%68s", "Deseja confirmar? ");
				System.out.println();
				System.out.printf("%63s", "1. Confirmar ");
				System.out.println();
				System.out.printf("%60s", "2. Deletar");
				System.out.println();
				System.out.printf("%61s", "3. Alterar ");
				System.out.println();
				int opcaoConfirmar = entrada.nextInt();

				if (opcaoConfirmar == 2) {
					usuariodao.deletar(idRandom);
					enquetedao.deletar(idRandom);
					System.out.println("");
					System.out.printf("%70s", "Respostas Deletadas!");
					System.out.println();
				} else if (opcaoConfirmar == 3) {

					System.out.printf("%78s", "Use siglas (ex.: sp, mg, rj)");
					System.out.println();
					System.out.printf("%71s", "Digite o seu Estado: ");
					String estadoEnqAlt = entrada.next();

					System.out.printf("%71s", "Digite a sua Cidade: ");
					String cidadeEnqAlt = entrada.next();

					System.out.printf("%76s", "Quantas vezes você vai ao ");
					System.out.println();
					System.out.printf("%68s", "mercado por mes?: ");
					int freqEnqAlt = entrada.nextInt();

					System.out.printf("%74s", "Qual produto nosso sente");
					System.out.println();
					System.out.printf("%69s", "falta no mercado?: ");
					String produtoEnqAlt = entrada.next();

					System.out.printf("%75s", "E qual voce mais gosta?: ");
					String prodMaisGostaAlt = entrada.next();

					enquetedao.altera(estadoEnqAlt, cidadeEnqAlt, freqEnqAlt, produtoEnqAlt, prodMaisGostaAlt,
							idRandom);

					System.out.println("");
					System.out.printf("%70s", "Respostas alteradas!");
					System.out.println();

				}
				// fim if alterar
				else {
					System.out.println("");
					System.out.printf("%70s", "Respostas Confirmadas!");
					System.out.println();
				}
				System.out.println("");
				System.out.printf("%70s", "Obrigado por ajudar!");
				System.out.println();

				// fim case 1 opcaomenu
				break;

			case 2:

				Adm adm = new Adm();
				int idRandomAdm = gerar.gerarNumeroAleatorio();
				adm.setIdAdm(idRandomAdm);

				System.out.println("");
				System.out.printf("%76s", "Digite seu codigo de ADM: ");
				String codigoAdm = entrada.next();

				while (codigoAdm.length() != 5) {
					System.out.printf("%83s", "Digite seu codigo de *5* Digitos:");
					codigoAdm = entrada.next();
				}

				adm.setCodigoAdm(codigoAdm);

				System.out.printf("%68s", "Digite sua senha: ");
				int senha = entrada.nextInt();
				adm.setSenhaAdm(senha);

				admdao.insert(adm);

				System.out.println("");
				System.out.printf("%64s", "BEM VINDO ADM!");
				System.out.println();

				int opcaoCase = 1;
				do {

					System.out.printf("%71s", "Qual operacao deseja?");
					System.out.println();
					System.out.printf("%73s", "1. Pesquisar por Cidade");
					System.out.println();
					System.out.printf("%73s", "2. Pesquisar por Estado");
					System.out.println();

					int opcaoAdm = entrada.nextInt();

					switch (opcaoAdm) {
					case 1:

						System.out.printf("%67s", "Digite a cidade: ");
						String cidadeBuscada = entrada.next();

						List<Enquete> listaCidade = admdao.selecionaPorCidade(cidadeBuscada);

						System.out.println(
								"------------------------------------------------------------------------------------------------------------------------");
						System.out.printf("%5s %10s %10s %14s %20s %21s %10s %9s %10s", "ID", "ESTADO", "CIDADE",
								"FREQUENCIA", "PRODUTO EM FALTA", "PRODUTO QUE GOSTA", "NOME", "IDADE", "EMAIL");
						System.out.println();
						System.out.println(
								"------------------------------------------------------------------------------------------------------------------------");
						for (Enquete enquete1 : listaCidade) {

							int idEncontrado = enquete1.getId();
							List<Usuario> listaUsuario = admdao.selecionaUsuario(idEncontrado);

							for (Usuario usuarioEncontrado : listaUsuario) {

								System.out.format("%5s %10s %10s %14s %20s %21s %10s %9s %10s", enquete1.getId(),
										enquete1.getEstado(), enquete1.getCidade(), enquete1.getFreqMercado(),
										enquete1.getProduto(), enquete1.getProdMaisGosta(), usuarioEncontrado.getNome(),
										usuarioEncontrado.getIdade(), usuarioEncontrado.getEmail());
								System.out.println();
							}

						}
						System.out.println(
								"------------------------------------------------------------------------------------------------------------------------");

						// fim case 1
						break;
					case 2:

						System.out.printf("%67s", "Digite a estado: ");
						String estadoBuscado = entrada.next();

						List<Enquete> listaEstado = admdao.selecionaPorEstado(estadoBuscado);

						System.out.println(
								"------------------------------------------------------------------------------------------------------------------------");
						System.out.printf("%5s %10s %10s %14s %20s %21s %10s %9s %10s", "ID", "ESTADO", "CIDADE",
								"FREQUENCIA", "PRODUTO EM FALTA", "PRODUTO QUE GOSTA", "NOME", "IDADE", "EMAIL");
						System.out.println();
						System.out.println(
								"------------------------------------------------------------------------------------------------------------------------");
						for (Enquete enquete1 : listaEstado) {

							int idEncontrado = enquete1.getId();
							List<Usuario> listaUsuario = admdao.selecionaUsuario(idEncontrado);

							for (Usuario usuarioEncontrado : listaUsuario) {

								System.out.format("%5s %10s %10s %14s %20s %21s %10s %9s %10s", enquete1.getId(),
										enquete1.getEstado(), enquete1.getCidade(), enquete1.getFreqMercado(),
										enquete1.getProduto(), enquete1.getProdMaisGosta(), usuarioEncontrado.getNome(),
										usuarioEncontrado.getIdade(), usuarioEncontrado.getEmail());
								System.out.println();
							}

						}
						System.out.println(
								"------------------------------------------------------------------------------------------------------------------------");

						// fim case 2
						break;
					
					default:
						System.out.println("Opção inválida");
						break;
					}

					System.out.println("");
					System.out.printf("%77s", "Deseja pesquisar novamente?");
					System.out.println();
					System.out.printf("%67s", "1. Sim | 2. Nao: ");
					opcaoCase = entrada.nextInt();

				} while (opcaoCase == 1);
				// fim opcaocase

				System.out.println("");
				System.out.printf("%70s", "Obrigado por ajudar!");
				System.out.println();

				// fim case 2 opcaomenu
				break;

			default:
				System.out.println("Opção inválida");
				break;
			// fim switch opcao menu
			}

			System.out.println("");
			System.out.printf("%70s", "Obrigado por ajudar!");
			System.out.println();

		} catch (Exception e) {
			System.out.println("Erro ao executar codigo!");
		}
		// trycatch main

	}
}
