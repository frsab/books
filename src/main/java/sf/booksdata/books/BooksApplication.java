package sf.booksdata.books;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import sf.booksdata.books.dao.BaliseRepository;
import sf.booksdata.books.dao.BookRepository;
import sf.booksdata.books.dao.ChapterRepository;
import sf.booksdata.books.dao.HTMLDocumentRepository;
import sf.booksdata.books.entities.Book;


import java.io.File;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import sf.booksdata.books.entities.HTMLDocument;


import java.util.ArrayList;
import java.util.stream.Stream;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class BooksApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksApplication.class, args);
    }
    @Bean
    CommandLineRunner start(
            BookRepository bookRepository,
            ChapterRepository chapterRepository,
        BaliseRepository baliseRepository,
                    HTMLDocumentRepository htmlDocumentRepository

    ) {
        return args -> {
            String fileName="C:/Users/saber/Google Drive/livres/ABCD/3ds_Max_2018/3ds_Max_2018.html";
            System.out.print(fileName);
            Document docLocal = Jsoup.parse(new File(fileName), "utf-8");
            Elements elementsHTMLtag = docLocal.select("html");
            HTMLDocument docHtml = new HTMLDocument(elementsHTMLtag);
          //  System.out.println(docHtml);
            htmlDocumentRepository.deleteAll();
            htmlDocumentRepository.save(docHtml);
            bookRepository.deleteAll();
            Stream.of("livre1", "Livre2")
                    .forEach(livre -> {
                        bookRepository.save(new
                                Book("id_livre", "type serveur", "mon titre de mon livre preferé", new ArrayList<>()
                        ));
                    });
            bookRepository.findAll().forEach(System.out::println);
            bookRepository.findAll().forEach(xx->{System.out.println("www"+xx);});

        };
    }
}

