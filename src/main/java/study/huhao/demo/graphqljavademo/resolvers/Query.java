package study.huhao.demo.graphqljavademo.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import study.huhao.demo.graphqljavademo.models.Link;
import study.huhao.demo.graphqljavademo.repositories.LinkRepository;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    LinkRepository linkRepository;

    public List<Link> allLinks() {
        return linkRepository.getAllLinks();
    }
}
