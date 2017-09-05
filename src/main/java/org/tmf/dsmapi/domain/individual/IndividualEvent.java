/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.domain.individual;


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
@Table(name="Event_Individual")
//@JsonPropertyOrder(value = {"eventTime", "eventType", "event"})
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class IndividualEvent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    private Date eventTime;

    @Enumerated(value = EnumType.STRING)
    private IndividualEventTypeEnum eventType;

    
    private Individual event; //check for object

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

    public IndividualEventTypeEnum getEventType() {
        return eventType;
    }

    public void setEventType(IndividualEventTypeEnum eventType) {
        this.eventType = eventType;
    }
    
    @JsonIgnore
    public Individual getEvent() {
        return event;
    }
 
    public void setEvent(Individual event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "IndividualEvent{" + "id=" + id + ", eventTime=" + eventTime + ", eventType=" + eventType + ", event=" + event + '}';
    }
    
    @JsonAutoDetect(fieldVisibility = ANY)
    class EventBody {
        private Individual individual;
        public Individual getIndividual() {
            return individual;
        }
        public EventBody(Individual individual) {
        this.individual = individual;
    }
    
       
    }
   @JsonProperty("event")
   public EventBody getEventBody() {
       
       return new EventBody(getEvent() );
   }

}
