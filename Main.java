import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static final List<Cliente> clientes = new ArrayList<>();
	private static double saldo = 0.0;

	public static void main(String[] args) {
		Menu mainMenu = new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes"), true);
		int selection = -1;
		while (selection != 0) {
			selection = mainMenu.getSelection();
			switch (selection) {
				case 1:
					exibirMenuConta();
					break;
				case 2:
					exibirMenuCliente();
					break;
				case 3:
					exibirMenuOperacoes();
					break;
			}
		}
		System.out.println("Fim");
	}

	private static void exibirMenuCliente() {
		Menu clienteMenu = new Menu("Menu Cliente", Arrays.asList("Cadastrar cliente", "Listar clientes", "Voltar"));
		int op = -1;
		while (op != 3) {
			op = clienteMenu.getSelection();
			switch (op) {
				case 1:
					cadastrarCliente();
					break;
				case 2:
					listarClientes();
					break;
				case 3:
					break;
			}
		}
	}

	private static void exibirMenuConta() {
		Menu contaMenu = new Menu("Menu Conta", Arrays.asList("Criar conta", "Consultar saldo", "Voltar"));
		int op = -1;
		while (op != 3) {
			op = contaMenu.getSelection();
			switch (op) {
				case 1:
					criarConta();
					break;
				case 2:
					exibirSaldo();
					break;
				case 3:
					break;
			}
		}
	}

	private static void cadastrarCliente() {
		System.out.println("Informe o nome do cliente: ");
		String nome = Input.readLine();

		System.out.println("Informe o CPF do cliente: ");
		String cpf = Input.readLine();

		if (nome.trim().isEmpty() || cpf.trim().isEmpty()) {
			System.out.println("Nome e CPF sao obrigatorios.");
			return;
		}

		clientes.add(new Cliente(nome, cpf));
		System.out.println("Cliente cadastrado com sucesso!");
	}

	private static void listarClientes() {
		if (clientes.isEmpty()) {
			System.out.println("Nenhum cliente cadastrado.");
			return;
		}

		System.out.println("Clientes cadastrados:");
		for (int i = 0; i < clientes.size(); i++) {
			System.out.println((i + 1) + " - " + clientes.get(i));
		}
	}

	private static void criarConta() {
		saldo = 0.0;
		System.out.printf("Conta criada com sucesso. Saldo inicial: R$ %.2f%n", saldo);
	}

	private static void exibirMenuOperacoes() {
		Menu operacoesMenu = new Menu("Menu Operacoes", Arrays.asList("Depositar", "Sacar", "Voltar"));
		int op = -1;
		while (op != 3) {
			op = operacoesMenu.getSelection();
			switch (op) {
				case 1:
					depositar();
					break;
				case 2:
					sacar();
					break;
				case 3:
					break;
			}
		}
	}

	private static void depositar() {
		double valor = lerValor("Informe o valor para deposito: ");
		if (valor <= 0) {
			System.out.println("Valor invalido.");
			return;
		}

		saldo += valor;
		System.out.println("Deposito concluido com sucesso.");
		exibirSaldo();
	}

	private static void sacar() {
		double valor = lerValor("Informe o valor para saque: ");
		if (valor <= 0) {
			System.out.println("Valor invalido.");
			return;
		}
		if (valor > saldo) {
			System.out.println("Saldo insuficiente.");
			return;
		}

		saldo -= valor;
		System.out.println("Saque concluido com sucesso.");
		exibirSaldo();
	}

	private static double lerValor(String mensagem) {
		System.out.println(mensagem);
		String valor = Input.readLine().replace(",", ".");
		try {
			return Double.parseDouble(valor);
		}
		catch (NumberFormatException e) {
			return -1;
		}
	}

	private static void exibirSaldo() {
		System.out.printf("Saldo atual: R$ %.2f%n", saldo);
	}

}
