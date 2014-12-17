package sample.entity;

import javax.persistence.*;

/**
 * Created by mokanarangant on 12/17/2014.
 */
@Entity
@Table(name = "users", schema = "", catalog = "tictactoe")
public class UsersEntity {
    private String user;
    private int win;
    private int loss;

    @Id
    @Column(name = "User")
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Basic
    @Column(name = "Win")
    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    @Basic
    @Column(name = "Loss")
    public int getLoss() {
        return loss;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (loss != that.loss) return false;
        if (win != that.win) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + win;
        result = 31 * result + loss;
        return result;
    }
}
