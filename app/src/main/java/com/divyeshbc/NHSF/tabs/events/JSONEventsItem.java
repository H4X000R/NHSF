package com.divyeshbc.NHSF.tabs.events;

import java.io.Serializable;

/**
 * Created by DivyeshBC on 09/11/15.
 */
public class JSONEventsItem implements Serializable {

    private String EventName;
    private String EventID;
    private String EventDate;
    private String EventTime;
    private String EventLocation;
    private String EventPostcode;

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String EventName) {
        this.EventName = EventName;
    }

    public String getEventID() {
        return EventID;
    }

    public void setEventID(String EventID) {
        this.EventID = EventID;
    }

    public String getEventDate() {
        return EventDate;
    }

    public void setEventDate(String EventDate) {
        this.EventDate = EventDate;
    }

    public String getEventTime() {
        return EventTime;
    }

    public void setEventTime(String EventTime) {
        this.EventTime = EventTime;
    }

    public String getEventLocation() {
        return EventLocation;
    }

    public void setEventLocation(String EventLocation) {
        this.EventLocation = EventLocation;
    }

    public String getEventPostcode() { return EventPostcode; }

    public void setEventPostcode(String EventPostcode) { this.EventPostcode = EventPostcode; }
}
