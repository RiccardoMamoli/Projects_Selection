package riccardomamoli.gestione_eventi_final.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import riccardomamoli.gestione_eventi_final.entities.Utente;
import riccardomamoli.gestione_eventi_final.exceptions.UnauthorizedExceptions;
import riccardomamoli.gestione_eventi_final.payloads.UserLoginDTO;
import riccardomamoli.gestione_eventi_final.tools.JWT;

@Service
public class AuthService {
    @Autowired
    private UtenteService utenteService;

    @Autowired
    private JWT jwt;

    @Autowired
    private PasswordEncoder bcrypt;

    public String checkCredentialsAndGenerateToken(UserLoginDTO body) {

        Utente found = this.utenteService.findByEmail(body.email());
        if (bcrypt.matches(body.password(), found.getPassword())) {
            String accessToken = jwt.createToken(found);
            return accessToken;
        } else {
            // 4. Se le credenziali sono errate --> 401 (Unauthorized)
            throw new UnauthorizedExceptions("Credenziali errate!");
        }
    }

}
