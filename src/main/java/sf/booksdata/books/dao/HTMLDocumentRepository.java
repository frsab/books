package sf.booksdata.books.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sf.booksdata.books.entities.Balise;
import sf.booksdata.books.entities.HTMLDocument;
import java.util.Optional;

@RepositoryRestResource
public interface HTMLDocumentRepository extends MongoRepository<HTMLDocument,String> {
    Optional<HTMLDocument> findOneByRootBaliseName(String baliseName);
}
