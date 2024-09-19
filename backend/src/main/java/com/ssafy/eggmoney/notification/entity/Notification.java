package com.ssafy.eggmoney.notification.entity;

import com.ssafy.eggmoney.common.entity.BaseTime;
import com.ssafy.eggmoney.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.EnumType.*;
import static jakarta.persistence.FetchType.*;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@Table(name = "notifications")
@NoArgsConstructor(access = PROTECTED)
public class Notification extends BaseTime {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "pub_user_id")
    private User pub;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name ="sub_user_id")
    private User sub;

    @Enumerated(value = STRING)
    private NotificationType notificationType;

    private String message;
    private Boolean isRead;
    private Boolean isValid;

    // 리다이렉트 url 인데 알림 하는 사람이 로직 구상해서 필요하면 추가하기.
    // private String url;
}
