package by.svetilnik.twitter.repos;

import by.svetilnik.twitter.entities.Twit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public interface TwitRepo extends JpaRepository<Twit, Long> {
    List<Twit> findByUserId(Long userId);
}
