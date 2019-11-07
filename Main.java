/*************************************************** Carlos Pereira - Banco ***************************************************/

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Funcionario f = new Funcionario("Funcionario", "123");
		Gerente g = new Gerente("Gerente", "456");
		Scanner scanner = new Scanner(System.in);

		String nConta;
		String login;
		double saldo;
		Conta cc;
		Poupanca cp;
		RepositorioContas repContas = new RepositorioContasLista();
		
/******************************************* Condi��es while *******************************************/	
		int cond = 0;
		int cond2 = 0;
		int cond3 = 0;
/******************************************* Inicio do Programa *******************************************/
		do {
			System.out.println(" --------Escolha a Fun��o:--------  ");
			System.out.println(" F - Para Funcion�rio");
			System.out.println(" G - Para Gerente");
			System.out.println(" Outra tecla para finalizar Programa!");
			System.out.println("-----------------------------------");

			String funcao = scanner.next();
/******************************************* Funcionario *******************************************/
			if (funcao.equals("f") || funcao.equals("F")) {
				scanner.nextLine();
				System.out.println(f.getNome());
				do {
					System.out.println("Qual sua senha? ");
					login = scanner.next();
/******************************************* Opera��es *******************************************/
					if (login.equals(f.getSenha())) {
						do {
							System.out.println(" ---Escolha a opera��o:---");
							System.out.println("       1 - Inserir");
							System.out.println("       2 - Procurar");
							System.out.println("       3 - Listar");
							System.out.println("Outra tecla - Finalizar");
							System.out.println("--------------------------");
							String tipo = scanner.next();

/*******************************************Inserir*******************************************/
							if (tipo.equals("1")) {
								System.out.println(" ---Escolha o tipo da conta:---");
								System.out.println("         1 - Poupan�a");
								System.out.println("         2 - Corrente");
								System.out.println("-------------------------------");
								String ct = scanner.next();

								if (ct.equals("1")) {
									System.out.println("Conta Poupan�a");
									System.out.print("Digite o numero da conta: ");
									nConta = scanner.next();
									System.out.print("Digite o saldo da conta: ");
									saldo = scanner.nextDouble();
									cp = new Poupanca(nConta, saldo);
									repContas.inserir(cp);

								} else if (ct.equals("2")) {
									System.out.println("Conta Corrente");
									System.out.print("Digite o numero da conta: ");
									nConta = scanner.next();
									System.out.print("Digite o saldo da conta: ");
									saldo = scanner.nextDouble();
									cc = new Conta(nConta, saldo);
									repContas.inserir(cc);
								} else {
									System.out.println("Op��o errada!");
								}
								cond2 = 2;

/*******************************************Procurar*******************************************/
							} else if (tipo.equals("2")) {
								System.out.print("Digite o numero da conta: ");
								nConta = scanner.next();
								System.out.println(repContas.procurar(nConta));
								cond2 = 2;

/*******************************************Listar*******************************************/
							} else if (tipo.equals("3")) {
								System.out.println(repContas.listarContas());

								cond2 = 2;
/*******************************************Finalizando*******************************************/
							} else {
								System.out.println("Finalizando se��o!");
								cond2 = 0;
								cond3 = 0;
							}

						} while (cond2 != 0);
						cond = 1;
					} else {
						System.out.println("senha incorreta");
						cond3 = 1;
					}
				} while (cond3 != 0);

/*******************************************Gerente*******************************************/
			} else if (funcao.equals("g") || funcao.equals("G")) {
				scanner.nextLine();
				System.out.println(g.getNome());
				do {
					System.out.println("Qual sua senha? ");
					login = scanner.next();
					if (login.equals(g.getSenha())) {
						do {
							System.out.println(" ---Escolha a opera��o:---");
							System.out.println("       1 - Inserir");
							System.out.println("       2 - Procurar");
							System.out.println("       3 - Listar");
							System.out.println("       4 - Remover");
							System.out.println("Outra tecla - Finalizar");
							System.out.println("--------------------------");
							String tipo = scanner.next();
/*******************************************Inserir*******************************************/
							if (tipo.equals("1")) {
								System.out.println(" ---Escolha o tipo da conta:---");
								System.out.println("       1 - Poupan�a");
								System.out.println("       2 - Corrente");

								String ct = scanner.next();
								if (ct.equals("1")) {
									System.out.print("Digite o numero da conta: ");
									nConta = scanner.next();
									System.out.print("Digite o saldo da conta: ");
									saldo = scanner.nextDouble();
									cp = new Poupanca(nConta, saldo);
									repContas.inserir(cp);

								} else if (ct.equals("2")) {
									System.out.print("\nNumero da conta: ");
									nConta = scanner.next();
									System.out.print("Saldo da conta: ");
									saldo = scanner.nextDouble();
									cc = new Conta(nConta, saldo);
									repContas.inserir(cc);
								} else {
									System.out.println("Op��o errada!");
								}
								cond2 = 2;
/*******************************************Procurar*******************************************/
							} else if (tipo.equals("2")) {
								System.out.print("Digite o numero da conta: ");
								nConta = scanner.next();
								System.out.println(repContas.procurar(nConta));
								cond2 = 2;
/*******************************************Listar*******************************************/
							} else if (tipo.equals("3")) {
								System.out.println(repContas.listarContas());

								cond2 = 2;
/*******************************************Remover*******************************************/
							} else if (tipo.equals("4")) {
								System.out.print("Digite o numero da conta: ");
								nConta = scanner.next();
								repContas.remover(nConta);
								if (repContas.procurar(nConta) == null) {
									System.out.println("Conta removida");
								}
								cond2 = 2;
/*******************************************Finalizando*******************************************/
							} else {
								System.out.println("Finalizando se��o!");
								cond2 = 0;
								cond3 = 0;
							}

						} while (cond2 != 0);

						cond = 1;
					} else {
						System.out.println("Senha incorreta");
						cond3 = 1;
					}
				} while (cond3 != 0);
			} else {
				System.out.println("------------- Programa Finalizado!!! -----------\n");
				System.out.println("************ Carlos Pereira - Banco ************");
				cond = 0;
			}

		} while (cond != 0);
	}
}
