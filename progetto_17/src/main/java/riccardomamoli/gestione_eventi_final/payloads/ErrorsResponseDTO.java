package riccardomamoli.gestione_eventi_final.payloads;

import java.time.LocalDateTime;

public record ErrorsResponseDTO(String message, LocalDateTime timestamp) {
}