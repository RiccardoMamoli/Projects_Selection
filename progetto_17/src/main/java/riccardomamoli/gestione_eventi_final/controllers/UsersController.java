package riccardomamoli.gestione_eventi_final.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import riccardomamoli.gestione_eventi_final.entities.Utente;
import riccardomamoli.gestione_eventi_final.exceptions.BadRequestException;
import riccardomamoli.gestione_eventi_final.payloads.NewUtenteDTO;
import riccardomamoli.gestione_eventi_final.services.UtenteService;


@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UtenteService utenteService;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public Page<Utente> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
                                @RequestParam(defaultValue = "id") String sortBy) {
        return this.utenteService.findAll(page, size, sortBy);
    }

    @GetMapping("/me")
    public Utente getProfile(@AuthenticationPrincipal Utente currentAuthenticatedUser) {
        return currentAuthenticatedUser;
    }

    @PutMapping("/me")
    public Utente updateProfile(@AuthenticationPrincipal Utente currentAuthenticatedUser, @RequestBody @Validated NewUtenteDTO body) {
        return this.utenteService.findByIdAndUpdate(currentAuthenticatedUser.getId(), body);
    }

    @DeleteMapping("/me")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProfile(@AuthenticationPrincipal Utente currentAuthenticatedUser) {
        this.utenteService.findByIdAndDelete(currentAuthenticatedUser.getId());
    }

    @GetMapping("/{userId}")
    public Utente findById(@PathVariable Long userId) {
        return this.utenteService.findById(userId);
    }

    @PutMapping("/{userId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Utente findByIdAndUpdate(@PathVariable Long userId, @RequestBody @Validated NewUtenteDTO body, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            validationResult.getAllErrors().forEach(System.out::println);
            throw new BadRequestException("Ci sono stati errori nel payload!");
        }
        return this.utenteService.findByIdAndUpdate(userId, body);
    }

    @DeleteMapping("/{userId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable Long userId) {
        this.utenteService.findByIdAndDelete(userId);
    }

}
