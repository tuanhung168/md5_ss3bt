package ss3.bt.model.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import ss3.bt.model.entity.Feedback;

public interface IFeedbackRepository extends PagingAndSortingRepository<Feedback, Long> {

}
