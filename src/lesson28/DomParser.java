package lesson28;


import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

public class DomParser {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, TransformerException {
//        parse();

        Catalog catalog = new Catalog();
        Article article = new Article();
        article.id = "12";
        article.author = "Author";
        article.title = "Title";
        article.publishDate = "2019-01-07";
        article.text = "Some Text";
        System.out.println(createXml(catalog));
    }

    public static String createXml(Catalog catalog) throws ParserConfigurationException, TransformerException, FileNotFoundException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.newDocument();
        document.setXmlVersion("1.0");

        // Создаем корневой элемент

        Element element = document.createElement("catalog");
        document.appendChild(element);

        for (Article article: catalog.articleList) {
            Element articleElement = document.createElement("article");
            element.appendChild(articleElement);

            articleElement.setAttribute("id", article.id);

            addNode(document, articleElement, "author", article.author);
            addNode(document, articleElement, "title", article.title);
            addNode(document, articleElement, "genre", article.genre);
            addNode(document, articleElement, "publish_date", article.publishDate);
            addNode(document, articleElement, "text", article.text);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();

        transformerFactory.setAttribute("indent-number", 4);

        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

       FileOutputStream fos = new FileOutputStream("catalog.txt");
        StringWriter writer = new StringWriter();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(writer);

        transformer.transform(source, result);

        return writer.toString();
    }

    public static void addNode(Document document, Element parent, String tagName, String tagValue) {
        Element element = document.createElement(tagName);
        element.appendChild(document.createTextNode(tagValue));
        parent.appendChild(element);
    }

    public static void parse() throws ParserConfigurationException, IOException, SAXException {
        Catalog catalog = new Catalog();

        // Инициализация DOM parser

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = factory.newDocumentBuilder();

        // работа с документом
        Document document = builder.parse(DomParser.class.getClassLoader().getResourceAsStream("articles.xml"));

        // получаем корневой элемент
        Element element = document.getDocumentElement();
        System.out.println(element);

        // Получаем дочерние элементы
        NodeList articlesList = element.getChildNodes();

        for (int i = 0; i < articlesList.getLength(); i++) {
            Node articleNode = articlesList.item(i);
            if (articleNode instanceof Element) {
                Article article = new Article();
                catalog.articleList.add(article);


                // Считываем атрибуты
                NamedNodeMap attrs = articleNode.getAttributes();

                article.id = attrs.getNamedItem("id").getNodeValue();

                NodeList articleProp = articleNode.getChildNodes();

                for (int j = 0; j < articleProp.getLength(); j++){
                    Node prop = articleProp.item(j);
                    if (prop instanceof Element) {
                        String propName = prop.getNodeName();
                        String value = prop.getTextContent();

                        if ("author".equals(propName)) article.author = value;
                        else if ("title".equals(propName)) article.title = value;
                        else if ("genre".equals(propName)) article.genre = value;
                        else if ("publish_date".equals(propName)) article.publishDate = value;
                        else if ("text".equals(propName)) article.text = value;

                    }
                }

            }
        }
        System.out.println(catalog);
    }
}
