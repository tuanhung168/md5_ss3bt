package ss3.bt.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import ss3.bt.model.entity.Feedback;
import ss3.bt.model.dto.FeedbackDto;

import java.util.List;
import java.util.Optional;

public interface IFeedbackService {
    Iterable<Feedback> findAll();
    Optional<Feedback> findById(Long id);
    void save(FeedbackDto t);
    void delete(Long id);
    void like(Long id);

    @Query("select f from Feedback f where f.creationDate = current_date()")
    Page<Feedback> findAll(Pageable pageable);


}
