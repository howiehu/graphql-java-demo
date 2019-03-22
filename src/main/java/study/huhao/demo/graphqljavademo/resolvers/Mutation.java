package study.huhao.demo.graphqljavademo.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import study.huhao.demo.graphqljavademo.models.Link;
import study.huhao.demo.graphqljavademo.repositories.LinkRepository;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private LinkRepository linkRepository;

    public Link createLink(String url, String description) {
        Link newLink = new Link(url, description);
        linkRepository.saveLink(newLink);
        return newLink;
    }
}
