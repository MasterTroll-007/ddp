package ddp.control;

import ddp.entity.User;
import ddp.exception.ResourceNotFoundException;
import ddp.repository.UserRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    /**
     * Creates new {@link User} and save it to the database
     * (BMR and Recommended Caloric Intake calculations are made in js at create_user template)
     * @param user {@link User} to be saved
     * @return Redirects to the template with info of newly saved {@link User}
     */
    @PostMapping("/create")
    public String createUser(@ModelAttribute @Valid final User user) {
        userRepository.save(user);
        return "redirect:/users/" + user.getId();
    }

    /**
     * Shows form for creating new {@link User}
     * @param model Model to be used at Thymeleaf template
     * @return Template for User creation
     */
    @GetMapping("/create")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "create_user";
    }

    /**
     * Loads User from database and shows {@link User} info at template
     * @param id {@link User} id
     * @param model Model to be used at Thymeleaf template
     * @return Template with {@link User} info
     */
    @GetMapping("/{id}")
    public String getUser(
            @NotBlank @PathVariable final Long id,
            Model model
    ) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        model.addAttribute("user", user);
        return "view_user";
    }

}
