package riccardomamoli.gestione_eventi_final.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import riccardomamoli.gestione_eventi_final.entities.Utente;
import riccardomamoli.gestione_eventi_final.exceptions.BadRequestException;
import riccardomamoli.gestione_eventi_final.payloads.NewUtenteDTO;
import riccardomamoli.gestione_eventi_final.payloads.UserLoginDTO;
import riccardomamoli.gestione_eventi_final.payloads.UtenteLoginResponseDTO;
import riccardomamoli.gestione_eventi_final.services.AuthService;
import riccardomamoli.gestione_eventi_final.services.UtenteService;


import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private UtenteService utenteService;

    @PostMapping("/login")
    public UtenteLoginResponseDTO login(@RequestBody UserLoginDTO body) {
        return new UtenteLoginResponseDTO(this.authService.checkCredentialsAndGenerateToken(body));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Utente save(@RequestBody @Validated NewUtenteDTO body, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            String message = validationResult.getAllErrors().stream().map(objectError -> objectError.getDefaultMessage())
                    .collect(Collectors.joining(". "));
            throw new BadRequestException("Ci sono stati errori nel payload! " + message);
        }

        return this.utenteService.salvaUtente(body);
    }
}
