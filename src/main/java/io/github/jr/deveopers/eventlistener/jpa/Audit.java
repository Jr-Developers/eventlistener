package io.github.jr.deveopers.eventlistener.jpa;

import ch.qos.logback.classic.pattern.TargetLengthBasedClassNameAbbreviator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;


@Setter
@Getter
@NoArgsConstructor
@MappedSuperclass
public class Audit {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "INSERT_TIMESTAMP")
    private Timestamp insertTimestamp;
    @Column(name = "INSERT_HTTP_METHOD")
    private String insertHTTPMethod;
    @Column(name = "INSERT_URL")
    private String insertUrl;
    @Column(name = "INSERT_METHOD")
    private String insertMethod;

    @Column(name = "UPDATE_TIMESTAMP")
    private Timestamp updateTimestamp;
    @Column(name = "UPDATE_HTTP_METHOD")
    private String updateHTTPMethod;
    @Column(name = "UPDATE_URL")
    private String updateUrl;
    @Column(name = "UPDATE_METHOD")
    private String updateMethod;

//    @PrePersist
//    public void onPersist() {
//        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        HandlerMethod handlerMethod = (HandlerMethod) req.getAttribute(HandlerMapping.BEST_MATCHING_HANDLER_ATTRIBUTE);
//        this.id = UUID.randomUUID().toString();
//        this.insertTimestamp = new Timestamp(System.currentTimeMillis());
//        this.insertHTTPMethod = req.getMethod();
//        this.insertUrl = (String) req.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
//        this.insertMethod = new TargetLengthBasedClassNameAbbreviator(10).abbreviate(handlerMethod.toString());
//    }
//
//    @PreUpdate
//    public void onUpdate() {
//        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        HandlerMethod handlerMethod = (HandlerMethod) req.getAttribute(HandlerMapping.BEST_MATCHING_HANDLER_ATTRIBUTE);
//        this.updateTimestamp = new Timestamp(System.currentTimeMillis());
//        this.updateHTTPMethod = req.getMethod();
//        this.updateUrl = (String) req.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
//        this.updateMethod = new TargetLengthBasedClassNameAbbreviator(10).abbreviate(handlerMethod.toString());
//    }
}
