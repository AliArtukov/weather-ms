package uz.atoy.weatherms.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_info")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "firstname", length = 50)
    private String firstname;

    @Size(max = 50)
    @Column(name = "lastname", length = 50)
    private String lastname;

    @Column(name = "base_token", nullable = false, columnDefinition = "text")
    private String baseToken;

}