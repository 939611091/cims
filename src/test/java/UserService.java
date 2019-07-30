import com.cims.entity.Course_category;
import com.cims.entity.User;

import java.util.List;

public interface UserService {
    //查询所有
    List<User> selectAll();
    //添加
    int insert(User user);
}
