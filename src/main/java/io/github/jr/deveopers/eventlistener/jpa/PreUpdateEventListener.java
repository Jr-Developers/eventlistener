package io.github.jr.deveopers.eventlistener.jpa;

import ch.qos.logback.classic.pattern.TargetLengthBasedClassNameAbbreviator;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.UUID;

public class PreUpdateEventListener {

    @PreUpdate
    public void onPersist(Audit audit) {
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HandlerMethod handlerMethod = (HandlerMethod) req.getAttribute(HandlerMapping.BEST_MATCHING_HANDLER_ATTRIBUTE);
        audit.setUpdateTimestamp(new Timestamp(System.currentTimeMillis()));
        audit.setUpdateHTTPMethod(req.getMethod());
        audit.setUpdateUrl((String) req.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE));
        audit.setUpdateMethod(new TargetLengthBasedClassNameAbbreviator(10).abbreviate(handlerMethod.toString()));
    }
}
