package ss3.bt.model.service.category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import ss3.bt.model.entity.Category;
import ss3.bt.model.entity.Post;
import ss3.bt.model.service.IGenericService;

public interface ICategoryService extends IGenericService<Category,Long> {

}
