package mason.beale.achievements.Controllers;

import org.springframework.web.bind.annotation.*;

// TODO: Implement globally
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping
    public String getUser() {
        return "MasonStone";
    }
}