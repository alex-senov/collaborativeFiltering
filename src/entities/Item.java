package entities;

/**
 * Created with IntelliJ IDEA, and God's blessing.
 * User: alexsen (Alexander Senov)
 * Date: 7/15/12
 * Time: 12:23 AM
 * Класс - товар
 */
public class Item{
    private final long id;

    public Item(long id){
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
        if(o instanceof Item){
            return ((Item) o).getId() == this.id;
        }
        return false;
    }

    @Override
    public String toString(){
        return "item{" +
                "id=" + id +
                '}';
    }
}
