package com.eljhoset.application;

import com.eljhoset.sharedkernel.DomainEvent;
import com.eljhoset.sharedkernel.EventDispatcher;
import org.springframework.context.ApplicationEventPublisher;

public class SpringBootEventDispatcher implements EventDispatcher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public SpringBootEventDispatcher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void dispatch(DomainEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

}
