package sf.booksdata.books.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sf.booksdata.books.entities.Book;
@RepositoryRestResource
public interface BookRepository extends MongoRepository<Book,String> {
}
