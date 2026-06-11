import java.util.Arrays;

public class Main {

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

}