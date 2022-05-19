package testSuite.search;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

public class SearchResult {
    public static Question<String> errorMsg() {
        return actor -> TextContent.of(SearchResultList.RESULT_ERROR).answeredBy(actor); //viewedBy(actor).value();
    }
}
