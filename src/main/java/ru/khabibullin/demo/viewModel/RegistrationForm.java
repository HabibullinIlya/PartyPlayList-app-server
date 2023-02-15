package ru.khabibullin.demo.viewModel;

import org.springframework.security.crypto.password.PasswordEncoder;
import ru.khabibullin.demo.models.AppUser;

public class RegistrationForm {

    private Long id;
    private String userName;
    private String email;

    public AppUser toUser(PasswordEncoder encoder) {
        AppUser user = new AppUser();
        user.setUserName(this.userName);
        user.setEmail(this.email);
        user.setPassword(encoder.encode(this.getPassword()));
        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

}
