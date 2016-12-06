package wikiXtractor;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import wikiXtractor.factory.PageFactory;
import wikiXtractor.model.Article;
import wikiXtractor.model.Categorisation;
import wikiXtractor.model.Category;
import wikiXtractor.model.Page;
import wikiXtractor.neo4j.factory.Neo4jSessionFactory;
import wikiXtractor.output.PageExport;
import wikiXtractor.service.CategoryService;
import wikiXtractor.service.PageService;
import wikiXtractor.util.Loggable;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * The outstanding MAIN CLAAAASSS :D
 * <p>
 * Defines the entire workflow
 * <p>
 * This will grow into a strong Monolith.
 *
 * @author Dinu Ganea
 */
public class Main implements Loggable {

    public static final String DOMAIN_NAME = "wikiXtractor";

    public static void main(String args[]) {

        // Get console arguments and evaluate operation type
        Neo4jSessionFactory sFactory = new Neo4jSessionFactory("file:/home/dinu/graph", DOMAIN_NAME);
        Session session = sFactory.getNeo4jSession();


        // session.query("CREATE CONSdTRAINT ON (p:Page) ASSERT p.namespaceID IS UNIQUE", new HashMap<String, String>());


        session.beginTransaction();

        try {
            PageService ps = new PageService<>(session, Page.class);

            Article article = new Article(0, "123", "title_article");
            Category category = new Category(14, "124", "title_category");
            Category caat2 = new Category(14, "125", "title_subcategory");

            category.addSubcategory(caat2);

            //cs.createOrUpdate(category);

            article.addCategory(category);

            ps.createOrUpdate(article);

            Article a = (Article) ps.find(0, "title_article");

            System.out.println(a);

            for (Category c : a.getCategories()) {
                System.out.println(c);
                System.out.println("Subcategories:");
                for (Category c1: c.getSubcategories()) {
                    System.out.println(c1);
                }
            }


        } catch (Exception e) {
            System.out.println("WTF?");
            e.printStackTrace();
        }

        System.out.println("\n");


        /* try {
            session.beginTransaction();

            PageService ps = new PageService(session);

            Page page = new Page(1, "id-321", "title_4");

            Category cat = new Category();
            cat.setName("test");


            Set<Category> cats = new HashSet<Category>();
            cats.add(cat);

            page.setCategories(cats);

            Page p2 = ps.createOrUpdate(page);

            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("TESTS");
        } */



        /*
        // The last try-catch hope of this application. Log every exception that it's thrown and print the stack trace
        try {

            // Mark the start of a new session
            // Nice to have a delimited logging for each run
            logger.info("==========================================================");
            logger.info("====================STARTING A NEW RUN====================");
            logger.info("==========================================================");

            // input
            String input = args[0];
            // output
            String output = args[1];

            // Create the path
            Path path = Paths.get(input);

            // get the pages
            Set<Page> pages = PageFactory.build(path);

            // create an export instance
            PageExport ep = new PageExport(output);

            // export files to xml
            ep.exportToXML(pages);

        } catch (ArrayIndexOutOfBoundsException e) {
            // Catch explicitly the input parameter exception
            logger.error("Please make sure to provide the path to the input file and the name of the output file");
        } catch (Exception e) {
            logger.error("An error occurred!");
            logger.error(e.getMessage(), e);
        }
        */

    }
}