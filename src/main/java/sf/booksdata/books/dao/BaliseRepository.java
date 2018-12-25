package sf.booksdata.books.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sf.booksdata.books.entities.Balise;
import sf.booksdata.books.entities.Chapter;

@RepositoryRestResource
public interface BaliseRepository extends MongoRepository<Balise,String> {
}
