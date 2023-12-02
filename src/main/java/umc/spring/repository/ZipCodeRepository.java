package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.ZipCode;

public interface ZipCodeRepository extends JpaRepository<ZipCode, Long> {

    ZipCode findByContent(String content);
}
