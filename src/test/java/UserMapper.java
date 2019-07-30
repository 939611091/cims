import com.cims.entity.User;

import java.util.List;

public interface UserMapper {
    int insert(User user);
    List<User> selectAll();
}
