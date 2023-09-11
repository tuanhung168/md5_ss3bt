package ss3.bt.model.service.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ss3.bt.model.dto.PostDto;
import ss3.bt.model.entity.Post;
import ss3.bt.model.service.IGenericService;

public interface IPostService extends IGenericService<Post,Long> {
        void save(PostDto postDto);
        Page<Post> findAll(Pageable pageable);
        Page<Post> findAllByTitleContaining(String title, Pageable pageable);


}
