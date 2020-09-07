package web.Service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import java.util.List;

@Transactional
@Service
@Component
public interface ServiceDTO<T> extends UserDetailsService {
    List<T> allEntity();

    boolean addEntity(T t);

    boolean updateEntity(T t);

    void deleteEntity(Long id);

    T getEntityById(Long id);

    T getEntityByName(String name);
}
