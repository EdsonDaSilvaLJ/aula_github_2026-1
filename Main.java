import java.util.Arrays;

public class Main {

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
					System.out.println("Cliente selecionado");
					break;
				case 3:
					System.out.println("Operacoes selecionada");
					break;
			}
		}
		System.out.println("Fim");
	}

	private static void exibirMenuConta() {
		Menu contaMenu = new Menu("Menu Conta", Arrays.asList("Criar conta", "Consultar saldo", "Voltar"));
		int op = -1;
		while (op != 3) {
			op = contaMenu.getSelection();
			switch (op) {
				case 1:
					System.out.println("Criar conta selecionado");
					break;
				case 2:
					System.out.println("Consultar saldo selecionado");
					break;
				case 3:
					break;
			}
		}
	}

}