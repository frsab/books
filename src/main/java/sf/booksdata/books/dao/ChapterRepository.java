package sf.booksdata.books.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import sf.booksdata.books.entities.Book;
import sf.booksdata.books.entities.Chapter;
@RepositoryRestResource
public interface ChapterRepository extends MongoRepository<Chapter,String> {
}
