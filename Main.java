import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Menu mainMenu =  new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes"), true);
		int selection = -1;
		while (selection != 0) {
			selection = mainMenu.getSelection();
			if (selection != 0) {
				System.out.println(selection + " foi selecionada");
			}
		}
		System.out.println("Fim");
	}

}