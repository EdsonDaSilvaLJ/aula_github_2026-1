import java.util.List;

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
		int op = -1;
		boolean opcaoValida = false;
		while (!opcaoValida){
			System.out.println(title+"\n");
			if (hasExitOption) {
				System.out.println("0 - Sair");
			}
			int i=1;
			for (String option : options) {
				System.out.println(i++ + " - " + option);
			}

			System.out.println("Informe a opcao desejada. ");
			String str = Input.readLine();
			try {
				op = Integer.parseInt(str);
			}
			catch (NumberFormatException e) {
				op = -1;
			}
			opcaoValida = (hasExitOption && op >= 0 && op < i) || (!hasExitOption && op >= 1 && op < i);
			if (!opcaoValida){
				System.out.println("Opcao errada!");
			}

		}
		return op;
	}
}
