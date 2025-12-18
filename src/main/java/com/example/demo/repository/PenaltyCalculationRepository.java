// ❌ Wrong import
import org.springframework.stereotype.repository;

// ✅ Correct import
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface PenaltyCalculationRepository extends JpaRepository<PenaltyCalculation, Long> {
    List<PenaltyCalculation> findByContractId(Long contractId);
}
