package sf.booksdata.books.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.jsoup.select.Elements;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class HTMLDocument {
    private Balise root;

    public HTMLDocument(Elements elements) {
        Balise root = new Balise();
        this.setRoot(root );

        this.getRoot().setBaliseName("html");
        this.getRoot().setAttributes(elements.get(0));
        this.getRoot()
                .setContenu(
                        elements
                                .get(0)
                                .children()
                );
    }
}
