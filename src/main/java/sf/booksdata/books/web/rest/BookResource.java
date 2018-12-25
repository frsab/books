package sf.booksdata.books.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sf.booksdata.books.dao.HTMLDocumentRepository;
import sf.booksdata.books.entities.Balise;
import sf.booksdata.books.entities.HTMLDocument;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookResource {
    @Autowired
    HTMLDocumentRepository htmlDocumentRepository;//.save(docHtml);

    @GetMapping("/all-world")
    public List<HTMLDocument>  getListeLivre(){
        return htmlDocumentRepository.findAll();

    }
    @GetMapping("/one-world")
    public HTMLDocument  getFirstLivre(){
        Example<HTMLDocument> exemple = Example.of(createExampleHTMLDocument());

//        Optional<HTMLDocument> optionalHTMLDocument = htmlDocumentRepository.findOne(exemple);
        Optional<HTMLDocument> optionalHTMLDocument = htmlDocumentRepository.findOneByRootBaliseName("html");
        if (optionalHTMLDocument.isPresent()){
            return  optionalHTMLDocument.get();
        }else{
            return new HTMLDocument();
        }
//        return optionalHTMLDocument.get();

    }

    private HTMLDocument createExampleHTMLDocument() {
        HTMLDocument htmlDocument = new HTMLDocument();
        htmlDocument.setRoot(createExampleBalise());
        return htmlDocument;
    }

    private Balise createExampleBalise() {
        return  new Balise();
    }

    @GetMapping("/hello-world")
    public String testGet(){
        return "hello";
    }
}
