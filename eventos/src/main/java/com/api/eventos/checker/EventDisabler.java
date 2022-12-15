package com.api.eventos.checker;

import com.api.eventos.entity.CasualEvent;
import com.api.eventos.entity.RegularEvent;
import com.api.eventos.repository.ICasualEventDao;
import com.api.eventos.repository.IRegularEventDao;
import com.api.eventos.wrapper.CasualEventWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@EnableScheduling
public class EventDisabler  {

    @Autowired
    private ICasualEventDao event;

    @Autowired
    private IRegularEventDao regularEvent;

    private final long SECOND = 1000;
    private final long MINUTE = SECOND * 60;
    private final long HOUR = MINUTE * 60;

    @Scheduled(fixedDelay = MINUTE, initialDelay = SECOND)
    public void eventDisabler() {
        List<CasualEvent> events = event.findAll();
        LocalDate today = LocalDate.now();

        if (events.size() > 0) {

            events.stream().forEach((e) -> e.setIsActive(true && today.isBefore(e.getDate()) || false));
            events.stream().forEach((e) -> event.save(e));
            events.stream().forEach((e) -> CasualEventWrapper.entityToDto(e));

        }

    }

    @Scheduled(fixedDelay = MINUTE, initialDelay = SECOND)
    public void regularEventDisabler() {
        List<RegularEvent> events = regularEvent.findAll();
        LocalDate today = LocalDate.now();

        if (events.size() > 0) {

            events.stream().forEach((e) -> e.setIsActive(true && today.isBefore(e.getDate()) || false));
            events.stream().forEach((e) -> regularEvent.save(e));
//            events.stream().forEach((e) -> RegularEvent.entityToDto(e));

        }

    }

}
