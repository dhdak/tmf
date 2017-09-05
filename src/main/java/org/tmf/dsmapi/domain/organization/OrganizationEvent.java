/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.domain.organization;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.tmf.dsmapi.commons.utils.CustomJsonDateSerializer;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

import static org.codehaus.jackson.annotate.JsonAutoDetect.Visibility.ANY;

@XmlRootElement
@Entity
@Table(name="Event_Organization")
//@JsonPropertyOrder(value = {"id", "eventTime", "eventType", "event"})
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class OrganizationEvent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    private Date eventTime;

    @Enumerated(value = EnumType.STRING)
    private OrganizationEventTypeEnum eventType;

    private Organization event; //check for object

    @JsonProperty("eventId")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public OrganizationEventTypeEnum getEventType() {
        return eventType;
    }

    public void setEventType(OrganizationEventTypeEnum eventType) {
        this.eventType = eventType;
    }

    @JsonIgnore
    public Organization getEvent() {
        return event;
    }

    public void setEvent(Organization event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "OrganizationEvent{" + "id=" + id + ", eventTime=" + eventTime + ", eventType=" + eventType + ", event=" + event + '}';
    }

    @JsonAutoDetect(fieldVisibility = ANY)
    class EventBody {
        private Organization organization;
        public Organization getIndividual() {
            return organization;
        }
        public EventBody(Organization organization) {
        this.organization = organization;
    }
    
       
    }
   @JsonProperty("event")
   public OrganizationEvent.EventBody getEventBody() {
       
       return new OrganizationEvent.EventBody(getEvent() );
   }

}
