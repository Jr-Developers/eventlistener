package io.github.jr.deveopers.eventlistener.jpa;

import ch.qos.logback.classic.pattern.TargetLengthBasedClassNameAbbreviator;
import org.apache.catalina.connector.RequestFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.UUID;

public class PrePersistEventListener {

    @PrePersist
    public void onPersist(Audit audit) {
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HandlerMethod handlerMethod = (HandlerMethod) req.getAttribute(HandlerMapping.BEST_MATCHING_HANDLER_ATTRIBUTE);
        audit.setId(UUID.randomUUID().toString());
        audit.setInsertTimestamp(new Timestamp(System.currentTimeMillis()));
        audit.setInsertHTTPMethod(req.getMethod());
        audit.setInsertUrl((String) req.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE));
        audit.setInsertMethod(new TargetLengthBasedClassNameAbbreviator(10).abbreviate(handlerMethod.toString()));
    }
}
