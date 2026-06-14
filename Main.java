import java.util.Arrays;

public class Main {
	private static double saldo = 0.0;

	public static void main(String[] args) {
		Menu mainMenu = new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes"), true);
		int selection = -1;
		while (selection != 0) {
			selection = mainMenu.getSelection();
			switch (selection) {
				case 1:
					System.out.println("Conta selecionada");
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
					System.out.println("Cadastrar cliente selecionado");
					break;
				case 2:
					System.out.println("Listar clientes selecionado");
					break;
				case 3:
					break;
			}
		}
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
