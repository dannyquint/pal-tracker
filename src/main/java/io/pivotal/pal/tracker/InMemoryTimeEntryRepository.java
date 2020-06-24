package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private List<TimeEntry> timeEntries = new ArrayList<TimeEntry>();
    long id = 1L;

    public List<TimeEntry> list(){
        return this.timeEntries;
    }

    public TimeEntry read(long timeEntryId){
        return null;
    }

    public TimeEntry find(long timeEntryId){
        for (TimeEntry entry : this.timeEntries){
            if(Long.compare(entry.getId(), timeEntryId) == 0){
                return entry;
            }
        }
    return null;
    }

    public TimeEntry delete(long timeEntryId){
        this.timeEntries.removeIf(entry -> (entry.getId() == timeEntryId));
        return null;
    }

    public TimeEntry update(long timeEntryId, TimeEntry expected){
        for (TimeEntry entry : this.timeEntries){
            if(Long.compare(entry.getId(), timeEntryId) == 0){
                entry.setProjectId(expected.getProjectId());
                entry.setUserId(expected.getUserId());
                entry.setDate(expected.getDate());
                entry.setHours(expected.getHours());
                return entry;
            }
        }
        return null;
    }

    public TimeEntry create(TimeEntry timeEntry) {
        this.id=this.id++;
        TimeEntry entry = new TimeEntry(this.id++, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        this.timeEntries.add(entry);
        return entry;
    }
}
