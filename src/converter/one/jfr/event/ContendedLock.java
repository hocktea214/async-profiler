/*
 * Copyright The async-profiler authors
 * SPDX-License-Identifier: Apache-2.0
 */

package one.jfr.event;

public class ContendedLock extends Event {
    public final long duration;
    public final int classId;

    public ContendedLock(long time, int tid, int stackTraceId, long duration, int classId) {
        super(time, tid, stackTraceId);
        this.duration = duration;
        this.classId = classId;
    }

    @Override
    public int hashCode() {
        return classId * 127 + stackTraceId;
    }

    @Override
    public boolean sameGroup(Event o) {
        if (o instanceof ContendedLock) {
            ContendedLock c = (ContendedLock) o;
            return classId == c.classId;
        }
        return false;
    }

    @Override
    public long value() {
        return duration;
    }
}
