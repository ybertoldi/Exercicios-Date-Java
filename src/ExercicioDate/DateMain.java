package ExercicioDate;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class DateMain {

	public static void main(String[] args) {
		DateTimeFormatter formataBr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate a = LocalDate.parse("2024-10-11");
		LocalDate b =  LocalDate.now();
		
		System.out.println("a: " + formataBr.format(a));
		System.out.println("b: " + formataBr.format(b));
		
		System.out.println("Sabados entre a e b: " + UtilData.sabadosEntre(a, b)); //1
		System.out.println("Dias uteis entre a e b: " + UtilData.diasUteisEntre(a, b)); //2
		System.out.println("Dia da semana de a: " + UtilData.diaSemana("11/10/2024").toString()); //3
		System.out.println();
		System.out.println("Se o primeiro pagamento for no dia B, o segundo sera " + formataBr.format(UtilData.proximoPagamento(b))); //4
		System.out.println("Lista de dias do mes 12 de 2024: " + UtilData.diasDoMesDoAno(12, 2024)); //5
		
	}
}