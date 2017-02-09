package model;

import javax.persistence.*;

/**
 *
 * Klasa nadrzÄ™dna dla wszystkich klas encyjnych. Ustala wspĂłlne metody:
 * toString() equals() hashCode()
 */
@MappedSuperclass
public abstract class AbstractEntity {
    
    protected static final long serialVersionUID = 1L;

    protected abstract Object getId();

    // Z kolei nie wiadomo co bÄ™dzie kluczem biznesowym w poszczegĂłlnych encjach
    protected abstract Object getBusinessKey();

    @Version
    @Column(name="version")
    private int version;

    @Override
    public String toString() {
         //return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
        return this.getClass().getSimpleName() + "[id=" + getId() + ", key=" + getBusinessKey() + ", version=" + version + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }        
        if(this.getClass().isAssignableFrom(obj.getClass())) {
            return this.getBusinessKey().equals(((AbstractEntity)obj).getBusinessKey());
        } else {
            return false;
        }
    }    

    @Override
    public int hashCode() {
        return getBusinessKey().hashCode(); 
    }
}

