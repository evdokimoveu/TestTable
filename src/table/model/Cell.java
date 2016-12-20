package table.model;

import java.util.Objects;

/**
 *
 * @author evdokimoveu
 */
public class Cell {
    private String text;
    private String imgSrc;

    public Cell() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.text);
        hash = 97 * hash + Objects.hashCode(this.imgSrc);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cell other = (Cell) obj;
        if (!Objects.equals(this.text, other.text)) {
            return false;
        }
        if (!Objects.equals(this.imgSrc, other.imgSrc)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cell{" + "text=" + text + ", imgSrc=" + imgSrc + '}';
    }
    
    
}
