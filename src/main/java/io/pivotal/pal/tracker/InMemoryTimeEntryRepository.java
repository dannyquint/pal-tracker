package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private List<TimeEntry> timeEntries = new ArrayList<TimeEntry>();

    @Override
    public TimeEntry create(TimeEntry any, int hours) {
        TimeEntry entry = new TimeEntry(any.getId(), any.getProjectId(), any.getUserId(), any.getDate(), hours);
        this.timeEntries.add(entry);
       return entry;
    }

    public List<TimeEntry> list(){
        return new ArrayList<>();
    }

    public long read(long timeEntryId){
        return timeEntryId;
    }

    public TimeEntry find(long timeEntryId){
        for (TimeEntry entry : this.timeEntries){
            if(Long.compare(entry.getId(), timeEntryId) == 0){
                return entry;
            }
        }
    return null;
    }

    public void delete(long timeEntryId){

    }
    public TimeEntry update(long timeEntryId, TimeEntry expected){
        return null;
    }

    public TimeEntry create(TimeEntry timeEntry) {
        return timeEntry;
    }
}
