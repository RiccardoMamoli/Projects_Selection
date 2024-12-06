package riccardomamoli.gestione_eventi_final.payloads;

import jakarta.validation.constraints.*;
import riccardomamoli.gestione_eventi_final.enums.Ruolo;

import java.time.LocalDate;


public record NewUtenteDTO(

        @NotEmpty(message = "Il nome dell'utente è obbligatorio!")
        String nomeUtente,

        @NotEmpty(message = "Il cognome dell'utente è obbligatorio!")
        String cognomeUtente,

        @Past(message = "La data di nascita deve essere nel passato!")
        LocalDate dataNascita,

        @NotEmpty(message = "Lo username è obbligatorio!")
        @Size(min = 3, max = 30, message = "Lo username deve essere lungo almeno 3 caratteri e al massimo 30.")
        String usernameUtente,

        @NotEmpty(message = "L'email è un campo obbligatorio!")
        @Email(message = "L'email inserita non è un'email valida")
        String emailUtente,

        @NotNull(message = "Il ruolo è obbligatorio!")
        Ruolo ruolo,

        @NotEmpty(message = "La password è obbligatoria!")
        @Size(min = 8, message = "La password deve essere lunga almeno 8 caratteri.")
        String passwordUtente) {
}
