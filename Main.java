import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static final List<Cliente> clientes = new ArrayList<>();
	private static final Scanner scanner = new Scanner(System.in);

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
					System.out.println("Operacoes selecionada");
					break;
			}
		}
		System.out.println("Fim");
	}

	private static void exibirMenuCliente() {
		Menu clienteMenu = new Menu("Menu Cliente", Arrays.asList("Cadastrar cliente", "Consultar clientes cadastrados", "Voltar"));
		int op = -1;
		while (op != 3) {
			op = clienteMenu.getSelection();
			switch (op) {
				case 1:
					cadastrarCliente();
					break;
				case 2:
					consultarClientes();
					break;
				case 3:
					break;
			}
		}
	}

	private static void cadastrarCliente() {
		System.out.println("Informe o nome do cliente: ");
		String nome = scanner.nextLine();

		System.out.println("Informe o CPF do cliente: ");
		String cpf = scanner.nextLine();

		if (nome.trim().isEmpty() || cpf.trim().isEmpty()) {
			System.out.println("Nome e CPF sao obrigatorios.");
			return;
		}

		clientes.add(new Cliente(nome, cpf));
		System.out.println("Cliente cadastrado com sucesso!");
		consultarClientes();
	}

	private static void consultarClientes() {
		if (clientes.isEmpty()) {
			System.out.println("Nenhum cliente cadastrado.");
			return;
		}

		System.out.println("Clientes cadastrados:");
		for (int i = 0; i < clientes.size(); i++) {
			System.out.println((i + 1) + " - " + clientes.get(i));
		}
	}

}
