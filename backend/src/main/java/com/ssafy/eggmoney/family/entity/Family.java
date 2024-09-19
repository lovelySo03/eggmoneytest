package com.ssafy.eggmoney.family.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ssafy.eggmoney.common.entity.BaseTime;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@Table(name = "families")
@NoArgsConstructor(access = PROTECTED)
public class Family extends BaseTime {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "family_id")
    private Long id;

    private String intro;
    private String qrCode;
    private Long presentId;

//    대표 ID 설정하기
    public void setPresentId(Long userId) {
        this.presentId = userId;
    }

    @Builder
    private Family(String intro, String qrCode, Long presentId) {
        this.intro = intro;
        this.qrCode = qrCode;
        this.presentId = presentId;
    }
}
