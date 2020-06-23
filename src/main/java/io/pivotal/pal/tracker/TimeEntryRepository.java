package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
    List<TimeEntry> list();

    TimeEntry create(TimeEntry any, int hours);
    TimeEntry create(TimeEntry any);

    TimeEntry find(long timeEntryId);
    long read(long timeEntryId);


    TimeEntry update(long timeEntryId, TimeEntry expected);

    void delete(long timeEntryId);


}
