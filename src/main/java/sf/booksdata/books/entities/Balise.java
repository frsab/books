package sf.booksdata.books.entities;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.jsoup.nodes.Element;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.LinkedList;
import java.util.Map;

import java.util.HashMap;
import java.util.List;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;



@Document
@Data @NoArgsConstructor @AllArgsConstructor @ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Balise {

    @Id
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private Boolean commented = false;

    private String baliseName;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private Map<String, String> attributes = new HashMap<String, String>();

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private LinkedList<Balise> contenu = new LinkedList<Balise>();

    // @JsonInclude(JsonInclude.Include.NON_NULL)
 @JsonInclude(JsonInclude.Include.NON_NULL)

    private String texte;

    public Balise(Element element) {
        this.setBaliseName(element.tagName());
        this.setAttributes(element);
        this.setContenu(element.childNodes());
    }

    public Balise(TextNode node) {
        this.setTexte(node.toString());
    }

    public Balise(Comment node) {
        this.setCommented(true);
        this.setTexte(node.toString());
    }

    public Balise(DataNode node) {
        this.setBaliseName(node.nodeName());
        this.setContenu(node.childNodes());
    }

    public String getBaliseName() {
        return baliseName;
    }

    public void setBaliseName(String baliseName) {
        this.baliseName = baliseName;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public LinkedList<Balise> getContenu() {
        return contenu;
    }

    public void setContenu(LinkedList<Balise> contenu) {
        this.contenu = contenu;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    @Override
    public String toString() {
        return "Balise [baliseName=" + baliseName + ", attributes=" + attributes + ", contenu=" + contenu + ", texte="
                + texte + "]";
    }

    public void setAttributes(Element elmnt) {
        Map<String, String> _attributes = new HashMap<String, String>();
        List<Attribute> list = elmnt.attributes().asList();
        for (Attribute attribute : list) {
            attribute.getKey();
            attribute.getValue();
            _attributes.put(attribute.getKey(), attribute.getValue());

        }
        this.setAttributes(_attributes);

    }

    private void setContenu(List<Node> childNodes) {
        LinkedList<Balise> _contenu = new LinkedList<Balise>();

        for (Node node : childNodes) {
            if (node.getClass().equals(org.jsoup.nodes.Element.class)) {
                _contenu.add(new Balise((Element) node));

            } else if (node.getClass().equals(org.jsoup.nodes.DataNode.class)) {
                _contenu.add(new Balise((org.jsoup.nodes.DataNode) node));

            } else if (node.getClass().equals(org.jsoup.nodes.TextNode.class)) {
                _contenu.add(new Balise((TextNode) node));

            } else if (node.getClass().equals(org.jsoup.nodes.Comment.class)) {
                _contenu.add(new Balise((org.jsoup.nodes.Comment) node));
            } else {
                throw new IllegalArgumentException(node.getClass().getName() + " n'est pas suppote ");
            }
        }
        this.setContenu(_contenu);
    }

    public void setContenu(Elements children) {
        LinkedList<Balise> _contenu = new LinkedList<Balise>();

        for (Element element : children) {
            _contenu.add(new Balise(element));
        }
        this.setContenu(_contenu);
    }

    public Boolean getCommented() {
        return commented;
    }

    public void setCommented(Boolean commented) {
        this.commented = commented;
    }
}
