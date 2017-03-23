package online.edirect.model.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import online.edirect.model.domain.StreetIntersection;

@Component
public interface StreetIntersectionRepository extends JpaRepository<StreetIntersection, Long> {
	public Optional<StreetIntersection> findByLongitudeAndLatitude(String longitude, String latitude);
}
