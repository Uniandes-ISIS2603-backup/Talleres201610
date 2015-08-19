package co.edu.uniandes.basicrest.dtos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase que contiene el DTO 
 */
@XmlRootElement
public class BookDTO {
    
    /** Atributos de la clase */
    private Long id;
    private String name;
    private String description;
    private String image;
    private String isbn;
    private int price;
        
    /** Metodos set y get de los atributos */    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
