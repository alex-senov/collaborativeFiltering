package entities;

/**
 * Created with IntelliJ IDEA, and God's blessing.
 * User: alexsen (Alexander Senov)
 * Date: 7/15/12
 * Time: 1:24 AM
 * Класс, содержающий пользователя и его оценки.
 */
public class UserRates{

    private final User user;

    private final Rates rates;

    public UserRates(User user, Rates rates){
        this.user = user;
        this.rates = rates;
    }

    public User getUser(){
        return user;
    }

    public Rates getRates(){
        return rates;
    }

    @Override
    public int hashCode(){
        return user.hashCode() + rates.hashCode();
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof UserRates){
            UserRates userRates = (UserRates) o;
            return (
                    this.user.equals(userRates.getUser()) &&
                            this.rates.equals(userRates.getRates())
            );
        }
        return false;
    }
}
