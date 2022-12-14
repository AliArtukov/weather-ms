package uz.atoy.weatherms.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = UserInfo.TABLE_NAME)
public class UserInfo {
    public static final String TABLE_NAME = "user_info";
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

    @NotNull
    @Lob
    @Column(name = "base_token", nullable = false, columnDefinition = "text")
    private String baseToken;

}