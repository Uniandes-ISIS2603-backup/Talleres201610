package co.edu.uniandes.basicrestlogic.ejb;

import co.edu.uniandes.basicrestlogic.dtos.BookDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 * Clase EJB para el desarrollo de la lógica del negocio y conexión de los
 * servicios con la capa de datos
 */
@Stateless
public class BookLogic implements IBookLogic {

    /**
     * Lista que se usara para el manejo de la información del servicio
     */
    private final static List<BookDTO> book = new ArrayList<BookDTO>();

    /**
     * Metodo para obtener todos los libros
     * @return
     */
    public List<BookDTO> getBooks() {
        return book;
    }

    /**
     * Metodo para crear un libro
     * @param dto
     * @return 
     */
    public BookDTO createBook(BookDTO dto) {
        book.add(dto);
        return dto;
    }

    /**
     * Metodo para actualizar un elemento
     * @param dto
     * @return 
     */
    public BookDTO updateBook(Long id, BookDTO dto) {
        for (int i = 0; i < book.size(); i++) {
            if (book.get(i).getId().equals(id)) {
                book.get(i).setId(id);
                book.get(i).setDescription(dto.getDescription());
                book.get(i).setImage(dto.getImage());
                book.get(i).setIsbn(dto.getIsbn());
                book.get(i).setName(dto.getName());
                book.get(i).setPrice(dto.getPrice());
            }
        }
        return dto;
    }

    /**
     * Metodo utilizado para eliminar un elemento
     * @param id
     */
    public void deleteBook(Long id) {
        for (int i = 0; i < book.size(); i++) {
            if (book.get(i).getId().equals(id)){
                book.remove(i);
            }
        }
    }
}
