package cn.pojo;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private Long id;
    private String name;
    private List<User> Users;

    public Group(Long id, String name, List<User> users) {
        this.id = id;
        this.name = name;
        Users = users;
    }

    public List<User> getUsers() {
        return Users;
    }

    public void setUsers(List<User> users) {
        Users = users;
    }

    public Group(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Users=" + Users +
                '}';
    }

    public Group() {
        this.Users = new ArrayList<User>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
