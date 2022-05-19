package testSuite.search;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;

public class SearchFor {
    public static Performable traveller(String companyId) {
        return Task.where("{0} attempts to search for #traveller",
                Clear.field(SearchForm.SEARCH_COMPANY_ID),
                Enter.theValue(companyId).into(SearchForm.SEARCH_COMPANY_ID)
        ).with("traveller").of(companyId);
    }
}
