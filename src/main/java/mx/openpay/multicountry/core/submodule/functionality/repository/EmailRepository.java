package mx.openpay.multicountry.core.submodule.functionality.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.openpay.multicountry.core.submodule.functionality.entity.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

}
