package entities;

/**
 * Created with IntelliJ IDEA, and God's blessing.
 * User: alexsen (Alexander Senov)
 * Date: 7/15/12
 * Time: 12:16 AM
 * Класс-пользователь
 */
public class User{

    private final long id;

    public User(long id){
        this.id = id;
    }

    public long getId(){
        return id;
    }

    @Override
    public int hashCode(){
        return (int) id;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof User){
            return ((User) o).getId() == this.id;
        }
        return false;
    }

    @Override
    public String toString(){
        return "user{" +
                "id=" + id +
                '}';
    }
}
