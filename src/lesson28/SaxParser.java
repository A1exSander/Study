package lesson28;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

public class SaxParser {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        InputStream in = SaxParser.class.getClassLoader().getResourceAsStream("articles.xml");

        // Создание парсера

        SAXParser saxParser = factory.newSAXParser();

        // Инициализация обработчика

        ArticleHandler handler = new ArticleHandler();

        // start parser

        saxParser.parse(in, handler);

        in.close();
       System.out.println(handler.catalog);
    }

    private static class ArticleHandler extends DefaultHandler {

        Catalog catalog = new Catalog();
        Article article;
        StringBuilder value = new StringBuilder();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

            if ("article".equals(qName)) {
                article = new Article();
                article.id = attributes.getValue("id");
                catalog.articleList.add(article);

            }

        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            String val = value.toString().trim();
            if ("author".equals(qName)) article.author = val;
            else if ("title".equals(qName)) article.title = val;
            else if ("genre".equals(qName)) article.genre = val;
            else if ("publish_date".equals(qName)) article.publishDate = val;
            else if ("text".equals(qName)) article.text = val;

            value.setLength(0);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            value.append(ch, start, length);
        }
    }

}
