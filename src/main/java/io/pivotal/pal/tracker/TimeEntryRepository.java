package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
    List<TimeEntry> list();

    TimeEntry create(TimeEntry any);

    TimeEntry find(long timeEntryId);

    TimeEntry read(long timeEntryId);

    TimeEntry update(long timeEntryId, TimeEntry expected);

    TimeEntry delete(long timeEntryId);


}
