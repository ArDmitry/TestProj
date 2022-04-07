import org.junit.jupiter.api.Test;

public class TestCases {

    static Requests requests = new Requests();

    @Test
    public void getOnePost() {
        requests.requestGet("/posts/","53", 200, "title", "ut quo aut ducimus alias");
    }

    @Test
    public void getNonePost() {
        requests.negativeRequestGet("/posts/","101", 404);
    }

    @Test
    public void createOnePost() {
        requests.requestPost("/posts/",
                "{\n" +
                "        \"userId\": 10,\n" +
                "        \"id\": 101,\n" +
                "        \"title\": \"111\",\n" +
                "        \"body\": \"222\"\n" +
                "    }" ,
                201);
    }

    @Test
    public void createEmptyPost() {
        requests.requestPost("/posts/","{}" ,201);
    }

}
