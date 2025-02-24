import java.util.ArrayList;
import java.util.List;

public class Log {
    private static List<String> historico = new ArrayList<>();

    // Método para adicionar uma entrada ao log
    public static void registrarAcao(String acao) {
        historico.add(acao);
    }

    // Método para exibir o histórico completo
    public static void mostrarHistorico() {
        System.out.println("Histórico de ações:");
        for (String acao : historico) {
            System.out.println(acao);
        }
    }
    }
