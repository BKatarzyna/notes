/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.note;

import endpoint.NoteEndpoint;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Note;

@Named(value = "notePageBean")
@RequestScoped
//@ManagedBean(name = "notePageBean")
//@ViewScoped
public class NotePageBean {
    @Inject
    private NoteEndpoint noteEndpoint;
    
    private Note note = new Note();
    private String insertedText;
    private Date timeOfCreation;
    
    public void createNote(){
        timeOfCreation = new Date();
        note.setText(insertedText);
        note.setTimeOfCreation(timeOfCreation);
        noteEndpoint.createNote(note);
    }

    public List showNotes(){
        return noteEndpoint.findAllNotes();
    }
    public String getInsertedText() {
        return insertedText;
    }

    public void setInsertedText(String insertedText) {
        this.insertedText = insertedText;
    }

    public Date getTimeOfCreation() {
        return timeOfCreation;
    }

    public void setTimeOfCreation(Date timeOfCreation) {
        this.timeOfCreation = timeOfCreation;
    }
    
    
}
