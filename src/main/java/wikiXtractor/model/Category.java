package wikiXtractor.model;


import javafx.scene.Parent;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Category extends Page {

    public static final int NAMESPACE_ID = 14;

    @Relationship(type = Parenthood.TYPE, direction = Relationship.OUTGOING)
    private Set<Category> subcategories;

    public Category() {

    }

    public Category(int namespaceID, String pageTitle) {
        this(namespaceID, "", pageTitle);
    }


    public Category(int namespaceID, String pageID, String pageTitle) {
        this.namespaceID = namespaceID;
        this.pageID = pageID;
        this.pageTitle = pageTitle;
        this.customID = hashCode();

        subcategories = new HashSet<>();
    }


    public Set<Category> getSubcategories() {
        return subcategories;
    }

    public Category setSubcategories(Set<Category> subcategories) {
        this.subcategories = subcategories;
        return this;
    }

    public Category addSubcategory(Category subcategory) {

        subcategories.add(subcategory);
        return this;
    }
}