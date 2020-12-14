package io.github.jr.deveopers.eventlistener.jpa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.context.event.EventListener;

import javax.persistence.*;

@Table(name = "USER")
@Entity
@Setter
@Getter
@NoArgsConstructor
@EntityListeners({PrePersistEventListener.class, PreUpdateEventListener.class})
public class User extends Audit {
    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "NAME")
    private String name;
}
