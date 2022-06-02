package motorbikes.server;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MotorbikeRepo extends JpaRepository<Motorbike, Integer> {}