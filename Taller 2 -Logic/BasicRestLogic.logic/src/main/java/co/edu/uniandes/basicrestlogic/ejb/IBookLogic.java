package co.edu.uniandes.basicrestlogic.ejb;


import co.edu.uniandes.basicrestlogic.dtos.BookDTO;
import java.util.List;

public interface IBookLogic {
    public List<BookDTO> getBooks();
    public BookDTO createBook(BookDTO dto);
    public BookDTO updateBook(Long id, BookDTO dto);
    public void deleteBook(Long id);
}
