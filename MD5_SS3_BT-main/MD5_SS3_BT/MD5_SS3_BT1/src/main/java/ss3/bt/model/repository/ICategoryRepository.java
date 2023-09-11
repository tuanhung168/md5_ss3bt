package ss3.bt.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ss3.bt.model.entity.Category;
import ss3.bt.model.entity.Post;

@Repository
public interface ICategoryRepository  extends PagingAndSortingRepository<Category, Long> {

}
