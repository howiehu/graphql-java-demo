package study.huhao.demo.graphqljavademo.repositories;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import study.huhao.demo.graphqljavademo.models.Link;

import java.util.ArrayList;
import java.util.List;

@Component
public class LinkRepository {

    private final List<Link> links;

    public LinkRepository() {
        links = new ArrayList<>();
        //add some links to start off with
        links.add(new Link("http://howtographql.com", "Your favorite GraphQL page"));
        links.add(new Link("http://graphql.org/learn/", "The official docks"));
    }

    public List<Link> getAllLinks() {
        return links;
    }

    public void saveLink(Link link) {
        links.add(link);
    }
}
