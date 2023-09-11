package ss3.bt.model.service.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import ss3.bt.model.dto.PostDto;
import ss3.bt.model.entity.Post;
import ss3.bt.model.repository.IPostRepository;

import java.io.File;
import java.io.IOException;
import java.util.Optional;


@Service
public class PostService implements IPostService {
    @Autowired
    private IPostRepository blogRepository;



    private String uploadPath = "C:\\Users\\ADMIN\\Desktop\\blog_withSpringData\\src\\main\\webapp\\WEB-INF\\upload\\";
    @Override
    public void save(PostDto postDto) {
        String imageFile = null;
        if(!(postDto.getImage().isEmpty())){
            imageFile = postDto.getImage().getOriginalFilename();
            try {
                FileCopyUtils.copy(postDto.getImage().getBytes(),new File(uploadPath+imageFile));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        Post post = new Post(postDto.getId(),
                postDto.getTitle(), postDto.getContent(),
                imageFile, postDto.getCreationDate(),postDto.getCategory());
        blogRepository.save(post);
    }

    @Autowired
    private IPostRepository postRepository;

    @Override
    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }


    @Override
    public Page<Post> findAll(Pageable pageable) {

        return postRepository.findAll( pageable);
    }

    @Override
    public Page<Post> findAllByTitleContaining(String title, Pageable pageable) {
        return postRepository.findAllByTitleContaining(title,pageable);
    }
}
