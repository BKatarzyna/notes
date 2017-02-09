/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Note;

@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class NoteFacade extends AbstractFacade<Note>{
    
    @PersistenceContext
    private EntityManager em;

    public NoteFacade() {
        super(Note.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
