package com.ssafy.eggmoney.user.entity;

import com.ssafy.eggmoney.common.entity.BaseTime;
import com.ssafy.eggmoney.family.entity.Family;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import static jakarta.persistence.FetchType.*;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = PROTECTED)
public class User extends BaseTime {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "family_id")
    private Family family;

    private String email;
    private String name;
    private String role;
    private String realAccount;
    private String bank;
    private String simplePwd;

    @ColumnDefault("50")
    private int stockRatio;

    @Builder
    private User(String email, String name, String role, String realAccount, String bank,
                 String simplePwd) {
        this.email = email;
        this.name = name;
        this.role = role;
        this.realAccount = realAccount;
        this.bank = bank;
        this.simplePwd = simplePwd;
    }

//    가족 넣기
    public void setFamily(Family family){
        this.family = family;
    }

//    간편비밀번호 설정
    public void setSimplePwd(String simplePwd){
        this.simplePwd = simplePwd;
    }

//    주식 제한 비율 설정
    public void setStockRatio(int ratio) {
        this.stockRatio = ratio;
    }

}
