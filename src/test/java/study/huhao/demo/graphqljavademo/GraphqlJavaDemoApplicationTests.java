package study.huhao.demo.graphqljavademo;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTest;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import net.minidev.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@GraphQLTest
public class GraphqlJavaDemoApplicationTests {

    @Autowired
    private GraphQLTestTemplate testTemplate;

    @Test
    public void all_links() throws IOException {
        GraphQLResponse response = testTemplate.postForResource("graphql/all-links.graphql");
        assertThat(response).isNotNull();
        assertThat(response.isOk()).isTrue();
        assertThat(response.get("$.data.allLinks[*]", JSONArray.class).size()).isEqualTo(2);
        assertThat(response.get("$.data.allLinks[0].url")).isEqualTo("http://howtographql.com");
        assertThat(response.get("$.data.allLinks[0].description")).isEqualTo("Your favorite GraphQL page");
    }

}
