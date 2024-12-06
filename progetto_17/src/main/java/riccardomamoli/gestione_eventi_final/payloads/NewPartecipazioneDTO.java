package riccardomamoli.gestione_eventi_final.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NewPartecipazioneDTO(
        @NotNull(message = "L'ID dell'utente è obbligatorio!")
        Long idUtente,

        @NotNull(message = "L'ID dell'evento è obbligatorio!")
        Long idEvento
) {
}
