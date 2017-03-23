package online.edirect.model.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import online.edirect.model.domain.RedRunner;

@Component
public interface RedRunnerRepository extends JpaRepository<RedRunner, Long> {
	Optional<RedRunner> findByLongitudeAndLatitude(String longitude, String latitude);
}
