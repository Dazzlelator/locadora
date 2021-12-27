package classes;

public class Teste {

	public static void main(String[] args) {
		Gato gatoVerde = new Gato(true, "Verde", 15, "Mialdo");
		Gato gatoRosa = new Gato(true, "Rosa", 10, "Mialda");
		Gato gatoVermelho = new Gato(true, "Vermelho", 5, "Totó");
		
		gatoVermelho.getTudo().forEach(item->System.out.println(item));
		
		Janela janela1 = new Janela("madeira", "marrom");
		Janela janela2 = new Janela("Aluminio", "prata");
		
		Casa casa1 = new Casa("Amarela", 666, janela1);
		Casa casa2 = new Casa("Branca", 158, janela2);
		
//		System.out.println("A casa de numero " +casa1.getNumero()+ " tem cor "+ casa1.getCor());
//		System.out.println("A casa de numero " + casa2.getNumero()+ " tem cor "+ casa2.getCor());
		
		System.out.println(casa1.getJanela().getMaterial());
		System.out.println(casa2.getJanela().getCor());
	}

}
