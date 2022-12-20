package com.api.eventos.checker;

import com.api.eventos.entity.Event;
import com.api.eventos.repository.IEventDao;
import com.api.eventos.wrapper.EventWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Component
@EnableScheduling
public class EventDisabler  {

    @Autowired
    private IEventDao event;

    private final long SECOND = 1000;
    private final long MINUTE = SECOND * 60;
    private final long HOUR = MINUTE * 60;

    @Scheduled(fixedDelay = MINUTE, initialDelay = SECOND)
    public void eventDisabler() {
        List<Event> events = event.findAll();
        Date today = new Date();

        if (events.size() > 0) {

            events.stream().forEach((e) -> e.setActive(true && today.before(e.getDate()) || false));
            events.stream().forEach((e) -> event.save(e));
            events.stream().forEach((e) -> EventWrapper.entityToDto(e));

        }

    }

}
