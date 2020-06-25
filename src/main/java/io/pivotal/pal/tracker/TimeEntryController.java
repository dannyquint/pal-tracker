package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.MeterRegistry;

import java.util.List;

@RestController
public class TimeEntryController {
    private TimeEntryRepository repository;
    private final DistributionSummary timeEntrySummary;
    private final Counter actionCounter;

    public TimeEntryController(TimeEntryRepository repository, MeterRegistry meterRegistry){
        this.repository = repository;

        timeEntrySummary = meterRegistry.summary("timeEntry.summary");
        actionCounter = meterRegistry.counter("timeEntry.actionCounter");
    }

    @PostMapping("/time-entries")
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate) {
        actionCounter.increment();
        timeEntrySummary.record(repository.list().size());
        return new ResponseEntity<TimeEntry>(this.repository.create(timeEntryToCreate), HttpStatus.CREATED);
    }

    @GetMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long id){
        TimeEntry entry = this.repository.find(id);
        if (entry != null) {
            actionCounter.increment();
        }

        return new ResponseEntity<TimeEntry>(entry, (entry == null? HttpStatus.NOT_FOUND : HttpStatus.OK));
    }

//    public ResponseEntity<TimeEntry> find(long timeEntryId){
//        return new ResponseEntity<TimeEntry>(this.repository.find(timeEntryId), HttpStatus.CREATED);
//    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list(){
        actionCounter.increment();
        return new ResponseEntity<List<TimeEntry>>(this.repository.list(), HttpStatus.OK);
    }

    @PutMapping("/time-entries/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody TimeEntry newEntry){
        TimeEntry entry = this.repository.update(id, newEntry);
        if (entry != null) {
            actionCounter.increment();
        }
        return new ResponseEntity(entry, (entry == null? HttpStatus.NOT_FOUND : HttpStatus.OK));
    }

    @DeleteMapping("/time-entries/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        actionCounter.increment();
        timeEntrySummary.record(this.repository.list().size());
        return new ResponseEntity(this.repository.delete(id), HttpStatus.NO_CONTENT);
    }
}
