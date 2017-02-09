/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package endpoint;

import facade.NoteFacade;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import model.Note;

@Stateful
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class NoteEndpoint extends AbstractEndpoint{
    
    @Inject
    private NoteFacade noteFacade;
    
    public Note findNote(long id){
        return noteFacade.find(id);
    }
    public List findAllNotes(){
        return noteFacade.findAll();
    }
    
    public void createNote(Note note){
        noteFacade.create(note);
    }
}
