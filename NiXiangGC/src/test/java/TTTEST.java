import cn.pojo.Group;
import cn.pojo.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TTTEST {

    public static void main(String[] args) {
        Group group = new Group();
        group.setId(0L);
        group.setName("admin");

        User guestUser = new User();
        guestUser.setId(2L);
        guestUser.setName("guest");

        User rootUser = new User();
        rootUser.setId(3L);
        rootUser.setName("root");

        group.getUsers().add(guestUser);
        group.getUsers().add(rootUser);
        String jsonString = JSON.toJSONString(group);
        Group group1 = JSON.parseObject(jsonString, Group.class);
        JSONObject jsonObject;
        System.out.println(group1);
    }
}
