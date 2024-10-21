package ExercicioDate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class UtilData {

	// 1
	// ---------------------------------------------------------------------------------------------------------------------------------------
	public static int sabadosEntre(LocalDate a, LocalDate b) {
		int x = 0;
		while (a.isBefore(b)) {
			if (a.getDayOfWeek() == DayOfWeek.SATURDAY) {
				x++;
			}
			a = a.plusDays(1);
		}

		return x;
	}

	// 2
	// ---------------------------------------------------------------------------------------------------------------------------------------
	public static int diasUteisEntre(LocalDate a, LocalDate b) {

		int x = 0;
		while (a.isBefore(b)) {
			a = a.plusDays(1);
			if (!(a.getDayOfWeek() == DayOfWeek.SUNDAY || a.getDayOfWeek() == DayOfWeek.SATURDAY || EhFeriado(a))) {
				x++;
			}
		}

		return x;
	}

	static boolean EhFeriado(LocalDate a) {
		int[][] feriados = new int[][] { { 1 }, { 5 }, { 19, 21 }, { 1 }, { 12 }, {}, {}, { 7 }, { 12 }, { 2, 15 },
				{ 25 } };

		if (feriados[a.getMonthValue() - 1].length == 0) {
			return false;
		} else {
			for (int i = 0; i < feriados[a.getMonthValue() - 1].length; i++) {
				if (feriados[a.getMonthValue() - 1][i] == a.getDayOfMonth()) {
					return true;
				}
			}
		}
		return false;
	}

	// 3
	// ---------------------------------------------------------------------------------------------------------------------------------------
	public static String diaSemana(String str) {
		DateTimeFormatter formataBr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dt = LocalDate.parse(str, formataBr);

		int dia = dt.getDayOfWeek().getValue();
		switch (dia) {
		case 1:
			return "Segunda-Feira";
		case 2:
			return "Terca-Feira";
		case 3:
			return "Quarta-Feira";
		case 4:
			return "Quinta-Feira";
		case 5:
			return "Sexta-Feira";
		case 6:
			return "Sabado";
		case 7:
			return "Domingo";
		default:
			return "";
		}
	}

	public static String diaSemana(LocalDate a) {
		int dia = a.getDayOfWeek().getValue();
		switch (dia) {
		case 1:
			return "Segunda-Feira";
		case 2:
			return "Terca-Feira";
		case 3:
			return "Quarta-Feira";
		case 4:
			return "Quinta-Feira";
		case 5:
			return "Sexta-Feira";
		case 6:
			return "Sabado";
		case 7:
			return "Domingo";
		default:
			return "";
		}
	}

	
	// 4  ---------------------------------------------------------------------------------------------------------------------------------------

	public static LocalDate proximoPagamento(LocalDate a) {
		a = a.plusDays(30);
		if (a.getDayOfWeek() == DayOfWeek.SATURDAY) {
			a = a.plusDays(2);
		} else if (a.getDayOfWeek() == DayOfWeek.SUNDAY || EhFeriado(a)) {
			a = a.plusDays(1);
		}

		return a;
	}

	// 5  ---------------------------------------------------------------------------------------------------------------------------------------
	
	public static List<String> diasDoMesDoAno(int mes, int ano) {
		List<String> dias = new ArrayList<String>();
		DateTimeFormatter formataBr = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate dt = LocalDate.of(ano, mes, 1);
		while (dt.getMonthValue() == mes) {
			dias.add(formataBr.format(dt));
			dt = dt.plusDays(1);
		}

		return dias;
	}
}
