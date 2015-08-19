package co.edu.uniandes.basicrestlogic.service;

import co.edu.uniandes.basicrestlogic.dtos.BookDTO;
import co.edu.uniandes.basicrestlogic.ejb.IBookLogic;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * Clase que contiene lo relacionado con el servicio REST
 */
@Path("/books")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookService {
    
    @Context 
    private HttpServletResponse response;
    
    @Inject
    private IBookLogic bookLogic;
    
    /**
     * Metodo POST para la creación de un libro
     * @param dto
     * @return 
     */
    @POST
    public BookDTO createBook(BookDTO dto) {
        return bookLogic.createBook(dto);
    }

    /**
     * Metodo GET para obtener los libros
     * @return 
     */
    @GET
    public List<BookDTO> getBooks() {
        return bookLogic.getBooks();
    }
    
    /**
     * Metodo PUT utilizado principalmente para actualizar
     * @return 
     */
    @PUT
    @Path("{id: \\d+}")
    public BookDTO updateBook(@PathParam("id") Long id, BookDTO dto) {
        return bookLogic.updateBook(id,dto);
    }

    /**
     * Metodo DELETE usado para eliminar un elemento
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteBook(@PathParam("id") Long id) {
        bookLogic.deleteBook(id);
    }
}
