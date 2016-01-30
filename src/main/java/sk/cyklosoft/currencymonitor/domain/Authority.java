package sk.cyklosoft.currencymonitor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "AUTHORITIES")
public class Authority {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", nullable = false, columnDefinition = "varchar(32)")
    private String id;


    @Column(name = "username", nullable = false, length = 15)
    private String username;

    @Enumerated(EnumType.STRING)
    @Column(name = "authority", nullable = true, columnDefinition = "varchar(20)")
    private RoleType authority;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User users;


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public User getUsers() {
        return users;
    }


    public void setUsers(User users) {
        this.users = users;
    }


    public RoleType getAuthority() {
        return authority;
    }


    public void setAuthority(RoleType authority) {
        this.authority = authority;
    }
}
