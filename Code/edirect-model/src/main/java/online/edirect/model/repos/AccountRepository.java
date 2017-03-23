package online.edirect.model.repos;


import org.springframework.data.jpa.repository.JpaRepository;

import online.edirect.model.domain.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);
}
