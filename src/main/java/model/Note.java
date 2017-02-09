/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Note extends AbstractEntity implements Serializable{

    @Id
    @GeneratedValue
    private Long noteId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeOfCreation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date alarmTime;
    private String text;

    @Override
    protected Object getId() {
        return noteId;
    }

    public Date getTimeOfCreation() {
        return timeOfCreation;
    }

    public void setTimeOfCreation(Date timeOfCreation) {
        this.timeOfCreation = timeOfCreation;
    }

    public Date getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Date alarmTime) {
        this.alarmTime = alarmTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
   
    @Override
    protected Object getBusinessKey() {
        return noteId;
    }

}
