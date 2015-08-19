package co.edu.uniandes.basicrest.service;

import co.edu.uniandes.basicrest.dtos.BookDTO;
import java.util.ArrayList;
import java.util.List;
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
    
    /** Lista que se usara para el manejo de la información del servicio */
    private final static List<BookDTO> book = new ArrayList<BookDTO>();
    
    /**
     * Metodo POST para la creación de un libro
     * @param dto
     * @return 
     */
    @POST
    public BookDTO createBook(BookDTO dto) {
        book.add(dto);
        return dto;
    }

    /**
     * Metodo GET para obtener los libros
     * @return 
     */
    @GET
    public List<BookDTO> getBooks() {
        return book;
    }
    
    /**
     * Metodo PUT utilizado principalmente para actualizar
     * @return 
     */
    @PUT
    @Path("{id: \\d+}")
    public BookDTO updateBook(@PathParam("id") Long id, BookDTO dto) {
        dto.setId(id);
        for (int i = 0; i < book.size(); i++) {
            if (book.get(i).getId().equals(dto.getId())){
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
     * Metodo DELETE usado para eliminar un elemento
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteBook(@PathParam("id") Long id) {
        for (int i = 0; i < book.size(); i++) {
            if (book.get(i).getId().equals(id)){
                book.remove(i);
            }
        }
    }
}
