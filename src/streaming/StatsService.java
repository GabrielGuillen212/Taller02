package streaming;

import java.util.List;
import java.util.stream.Collectors;

public class StatsService {
    
    public static void mostrarEstadisticas(Transmision transmision) {
        //cambio de estructurado a poo (
        System.out.println("\n=== ESTADÍSTICAS DE LA TRANSMISIÓN ===" + "\n" +
                            "Título: " + transmision.getTitulo() + "\n" +
                            "Profesor: " + transmision.getProfesor().getNombre() + "\n" +
                            "Total de asistentes: " + transmision.getAsistentes().size() + "\n" +
                            "Total de mensajes: " + transmision.getMensajes().size());
        //hasta aqui 
        long estudiantes = transmision.getAsistentes().stream()
                .filter(u -> "estudiante".equals(u.getRol()))
                .count();
        System.out.println("Estudiantes conectados: " + estudiantes);
        
        System.out.println("\n=== MENSAJES ===");
        transmision.getMensajes().forEach(m -> 
            System.out.println(m.getUsuario().getNombre() + ": " + m.getTexto())
        );
    }
    
    public static void mostrarAsistentes(Transmision transmision) {
        System.out.println("\n=== ASISTENTES ===");
        transmision.getAsistentes().forEach(u -> 
            System.out.println("- " + u.getNombre() + " (" + u.getRol() + ")")
        );
    }
}
