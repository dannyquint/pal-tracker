package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.util.List;

public class TimeEntryController {

    public TimeEntryController(TimeEntryRepository repository){}


    public ResponseEntity create(TimeEntry timeEntryToCreate) {
        return null;
    }

    public ResponseEntity<TimeEntry> read(long timeEntryId){
        return null;
    }
    public long find(long timeEntryId){
        return timeEntryId;
    }

    public ResponseEntity<List<TimeEntry>> list(){
        return null;
    }

    public ResponseEntity update(long timeEntryId, TimeEntry any){
        return null;
    }

    public ResponseEntity delete(long timeEntryId) {
        return null;
    }
}
