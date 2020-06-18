package com.example.jersey;

import com.example.jersey.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
class JerseyApplicationTests {

	private WebTarget target;

	@BeforeEach
	void init() {
		Client client = ClientBuilder.newClient();
		target = client.target("http://localhost:8080/MyRestService");
	}

	@Test
	void clientApi_Get_Test() {
		String user = "john";

		target = target.path("/welcome");
		target = target.queryParam("user", user);

		Response response = target.request().get();
		String responseData = response.readEntity(String.class);

		assertThat(responseData, equalTo("Welcome "+user));
	}

	@Test
	void clientApi_Post_Test() {
		String name = "john";
		String id = "johnny's*ID";

		target = target.path("/params/form");

		MultivaluedMap<String, String> postForm = new MultivaluedHashMap<>();
		postForm.add("name", name);
		postForm.add("id", id);

		String responseData = target.request().post(Entity.form(postForm), String.class);

		assertThat(responseData, equalTo("name: "+name+", id: "+id));
	}

	@Test
	void clientApi_Put_Test() {
		String name = "sunny";
		String id = "sunny_id";

		target = target.path("/params/form");

		MultivaluedMap<String, String> postForm = new MultivaluedHashMap<>();
		postForm.add("name", name);
		postForm.add("id", id);

		String responseData = target.request().put(Entity.form(postForm), String.class);

		assertThat(responseData, equalTo("name: "+name+", id: "+id));
	}

	@Test
	void clientApi_Delete_Test() {
		long id = 5;

		target = target.path("/params/"+id);
		Response response = target.request().delete(Response.class);
		List<User> users = response.readEntity(new GenericType<List<User>>(){});

		List<Long> ids = users.stream().map(user -> user.getId()).collect(Collectors.toList());

		assertThat(id, not(in(ids)));
	}

	@Test
	void clientApi_resolveTemplate_test(){
		String name = "jersey";
		int age = 10;

		Map<String, Object> pathParams = new HashMap<>();
		pathParams.put("name", name);
		pathParams.put("age", age);

		target = target.path("/params/multiPath/{name}/{age}")
				.resolveTemplates(pathParams);
		String responseData = target.request().get().readEntity(String.class);

		assertThat(responseData, equalTo("name : "+name+", age : "+age));
	}

	@Test
	void clientApi_cookieParam_Test(){
		String sessionId = "1101";

		target = target.path("/params/cookies");
		Cookie cookie = new Cookie("sessionId", sessionId);

		String responseData = target.request().cookie(cookie).get().readEntity(String.class);

		assertThat(responseData, equalTo("Session id: " + sessionId));
	}

	@Test
	void clientApi_matrixParam_test(){
		String name = "john";
		String address = "seoul";

		target = target.path("/params/matrix");
		String responseData = target.matrixParam("name", name)
									.matrixParam("address", address)
									.request().get().readEntity(String.class);
		assertThat(responseData, equalTo("이름 : " + name + ", 주소지 : " + address));
	}

	@Test
	void clientApi_invocation_test(){
		String name = "jersey";

		//응답 타입 설정해 Builder 인스턴스 생성
		Invocation.Builder builder = target.path("/params/query")
										.queryParam("name", name)
										.request("text/plain");

		//Invocation으로 래핑
		Invocation invocation = builder.buildGet();

		//웹 서비스 호출
		String responseData = invocation.invoke(String.class);

		assertThat(responseData, equalTo("pathParam -> " + name));
	}

}
