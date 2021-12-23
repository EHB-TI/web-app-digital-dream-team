package com.ehb.student.plates.events;

import com.ehb.student.plates.entities.User;
import org.springframework.context.ApplicationEvent;

public class OnUserRegisteredEvent extends ApplicationEvent {

    public OnUserRegisteredEvent(User user) {
        super(user);
    }
}
