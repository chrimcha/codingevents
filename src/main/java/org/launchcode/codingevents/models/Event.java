package org.launchcode.codingevents.models;

import jakarta.validation.constraints.*;

import java.util.Objects;

/**
 * Created by Chris Bay
 */
public class Event {

    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Name is required!")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters!")
    private String name;
    @NotBlank(message = "Location cannot be left blank!")
    @NotNull(message = "Location cannot be Null!")
    private String eventLocation;
    @Size(max = 500, message = "Message too long!")
    private String description;
    @NotNull(message = "Must provide number of attendees!")
    @Positive(message = "Must have at least 1 attendee!")
    private int numberOfAttendees;
    @AssertTrue(message = "Must be registered!")
    @NotNull(message = "Registration cannot be left blank!")
    private Boolean registered;
    @NotBlank(message = "Email is required!")
    @Email(message = "Invalid email.Try again.")
    private String contactEmail;

    public Event(String name, String eventLocation, String description, int numberOfAttendees, Boolean registered, String contactEmail) {
        this();
        this.name = name;
        this.eventLocation = eventLocation;
        this.description = description;
        this.numberOfAttendees = numberOfAttendees;
        this.registered = registered;
        this.contactEmail = contactEmail;
    }

    public Event() {
        this.id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public Boolean getRegistered() {
        return registered;
    }

    public void setRegistered(Boolean registered) {
        this.registered = registered;
    }

    public int getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public void setNumberOfAttendees(int numberOfAttendees) {
        this.numberOfAttendees = numberOfAttendees;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}