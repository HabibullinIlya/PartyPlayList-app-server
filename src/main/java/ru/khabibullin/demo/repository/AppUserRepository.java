package ru.khabibullin.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.khabibullin.demo.models.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUserName(String userName);
}
