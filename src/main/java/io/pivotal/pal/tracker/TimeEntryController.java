package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeEntryController {
    private TimeEntryRepository repository;

    public TimeEntryController(TimeEntryRepository repository){
        this.repository = repository;
    }

    @PostMapping("/time-entries")
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate) {
        return new ResponseEntity<TimeEntry>(this.repository.create(timeEntryToCreate), HttpStatus.CREATED);
    }

    @GetMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long id){
        TimeEntry entry = this.repository.find(id);
        return new ResponseEntity<TimeEntry>(entry, (entry == null? HttpStatus.NOT_FOUND : HttpStatus.OK));
    }

//    public ResponseEntity<TimeEntry> find(long timeEntryId){
//        return new ResponseEntity<TimeEntry>(this.repository.find(timeEntryId), HttpStatus.CREATED);
//    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list(){
        return new ResponseEntity<List<TimeEntry>>(this.repository.list(), HttpStatus.OK);
    }

    @PutMapping("/time-entries/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody TimeEntry newEntry){
        TimeEntry entry = this.repository.update(id, newEntry);
        return new ResponseEntity(entry, (entry == null? HttpStatus.NOT_FOUND : HttpStatus.OK));
    }

    @DeleteMapping("/time-entries/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        return new ResponseEntity(this.repository.delete(id), HttpStatus.NO_CONTENT);
    }
}
