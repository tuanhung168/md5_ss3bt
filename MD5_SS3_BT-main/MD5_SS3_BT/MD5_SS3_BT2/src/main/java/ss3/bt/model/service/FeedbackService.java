package ss3.bt.model.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ss3.bt.model.dto.FeedbackDto;
import ss3.bt.model.entity.Feedback;
import ss3.bt.model.repository.IFeedbackRepository;

import java.util.Optional;

@Service
public class FeedbackService implements IFeedbackService {
    @Autowired
    private IFeedbackRepository feedbackRepository;


    @Override
    public Iterable<Feedback> findAll() {
        return feedbackRepository.findAll();
    }

    @Override
    public Page<Feedback> findAll(Pageable pageable) {

        return feedbackRepository.findAll(pageable);
    }

    @Override
    public Optional<Feedback> findById(Long id) {
        return feedbackRepository.findById(id);
    }


    @Override
    public void delete(Long id) {
        feedbackRepository.deleteById(id);

    }

    public void save(FeedbackDto feedbackDto) {
        Feedback feedback = new Feedback(feedbackDto.getId(),
                feedbackDto.getRate(), feedbackDto.getAuthor(),
                feedbackDto.getContent(), feedbackDto.getCreationDate(), feedbackDto.getLikes());
        feedbackRepository.save(feedback);
    }

    public void like(Long id) {
        Feedback feedback = feedbackRepository.findById(id).get();
        feedback.setLikes(feedback.getLikes() + 1);
        feedbackRepository.save(feedback);
    }
}
