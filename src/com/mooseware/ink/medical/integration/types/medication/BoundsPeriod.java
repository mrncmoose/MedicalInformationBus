package com.mooseware.ink.medical.integration.types.medication;

import java.time.ZonedDateTime;

public class BoundsPeriod {
	private ZonedDateTime start;
	private ZonedDateTime end;
	public ZonedDateTime getStart() {
		return start;
	}
	public void setStart(ZonedDateTime start) {
		this.start = start;
	}
	public ZonedDateTime getEnd() {
		return end;
	}
	public void setEnd(ZonedDateTime end) {
		this.end = end;
	}

}
