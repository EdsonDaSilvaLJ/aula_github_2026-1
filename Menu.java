import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
	private String title;
	private List<String> options;
	private boolean hasExitOption;

	public Menu(List<String> options) {
		this.title = "Menu";
		this.options = options;
		this.hasExitOption = false;
	}

	public Menu(String title, List<String> options) {
		this.title = title;
		this.options = options;
		this.hasExitOption = false;
	}

	public Menu(String title, List<String> options, boolean hasExitOption) {
		this.title = title;
		this.options = options;
		this.hasExitOption = hasExitOption;
	}

	public int getSelection() {
		int op = 0;
		while (op==0){
			System.out.println(title+"\n");
			if (hasExitOption) {
				System.out.println("0 - Sair");
			}
			int i=1;
			for (String option : options) {
				System.out.println(i++ + " - " + option);
			}

			System.out.println("Informe a opcao desejada. ");
			Scanner s = new Scanner(System.in);
			String str = s.nextLine();
			try {
				op = Integer.parseInt(str);
			}
			catch (NumberFormatException e) {
				op =0;
			}
			if ((hasExitOption && op < 0) || (!hasExitOption && op < 1) || op >= i){
				System.out.println("Opcao errada!");
				op=0;
			}

		}
		return op;
	}
}