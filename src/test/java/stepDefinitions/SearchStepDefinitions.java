package stepDefinitions;

import Pages.SearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import java.util.*;
import java.util.stream.Collectors;
import java.util.List;

import static Base.BaseStepDefinition.driver;
public class SearchStepDefinitions {
    public SearchPage searchPage;

    @Given("The user is on the homepage")
    public void the_user_is_on_the_homepage() throws InterruptedException {
            searchPage=new SearchPage(driver);
            searchPage.returnHome();
    }
    @When("they type a search query into the search bar")
    public void they_type_a_search_query_into_the_search_bar() {
        searchPage.searchItem("laptop");
        searchPage.clickEnter();
    }

    @Then("the search query should be accepted and processed")
    public void the_search_query_should_be_accepted_and_processed() {
        String actualText=searchPage.getTextInSearchField();
        String expectedText="laptop";
        Assert.assertTrue(actualText.contains(expectedText));
    }

    @Given("The user has entered a search query")
    public void the_user_has_entered_a_search_query() {
        searchPage.searchItem("laptop");
    }

    @When("they click the Search button or press Enter key")
    public void they_click_the_button_or_press_enter_key() {
        searchPage.clickEnter();
    }

    @Then("the search results page should display items matching the search query")
    public void the_search_results_page_should_display_items_matching_the_search_query() {
        List<String>names=searchPage.getResultsNames();
        int i=0;
        for (String name:names){
            i++;
            System.out.println(i+" - "+name.toLowerCase());
            Assert.assertTrue(name.toLowerCase().contains("laptop"));
        }
    }

    @Given("The search results are displayed")
    public void the_search_results_are_displayed() {
        searchPage.searchItem("laptop");
        searchPage.clickEnter();
    }

    @When("the user applies filters \\(eg brand)")
    public void the_user_applies_filters_e_g_category_price_brand(){
        searchPage.clickDell();
    }

    @Then("the search results should be filtered accordingly")
    public void the_search_results_should_be_filtered_accordingly() {
        List<String>names=searchPage.getResultsNames();
        int i=0;
        for (String name:names){
            i++;
            System.out.println(i+" - "+name.toLowerCase());
            Assert.assertTrue(name.toLowerCase().contains("dell"));
        }
    }

    @When("the user chooses to sort the results \\(eg price)")
    public void the_user_chooses_to_sort_the_results_e_g_by_relevance_price_popularity() throws InterruptedException {
            searchPage.clickSortBy("price low to high");
    }

    @Then("the search results should be sorted accordingly")
    public void the_search_results_should_be_sorted_accordingly() {
            List<String>Prices=searchPage.getResultsPrice();
        List<String> sorted = Prices.stream()
                .sorted((a, b) -> b.compareTo(a))
                .collect(Collectors.toList());
        sorted=sorted.reversed();
        System.out.println(sorted);
        System.out.println(Prices);
        Assert.assertEquals(sorted,Prices,"not sorted by popularity");
    }

    @Given("The user enters a search query")
    public void the_user_enters_a_search_query() {
        searchPage.searchItem("رئيس جمهورية للبيع");

    }

    @When("no items match the search query")
    public void no_items_match_the_search_query() {
        searchPage.clickEnter();
    }

    @Then("a {string} message should be displayed")
    public void a_message_should_be_displayed(String string) {
        List<String>results=searchPage.getResultsNames();
        Assert.assertEquals(results.size(),0, "فيه عندهم رئيس للبيع");
    }

    @Given("the user enters Company  name in the search field")
    public void the_user_enters_company_name_in_the_search_field() {
        searchPage.searchItem("dell");
    }

    @Then("company products should be displayed")
    public void compny_products_should_be_displayed() {
        List<String>names=searchPage.getResultsNames();
        int i=0;
        for (String name:names){
            i++;
            System.out.println(i+" - "+name.toLowerCase());
            Assert.assertTrue(name.toLowerCase().contains("dell"));
        }
    }

    @Given("the user enters product name partially in the search field")
    public void the_user_enters_product_name_partially_in_the_search_field() {
            searchPage.searchItem("lapt");
            searchPage.clickEnter();
    }

    @Then("products relevant to that name should be displayed")
    public void products_relevant_to_that_name_should_be_displayed() {
        List<String>names=searchPage.getResultsNames();
        int i=0;
        for (String name:names){
            i++;
            System.out.println(i+" - "+name.toLowerCase());
            Assert.assertTrue(name.toLowerCase().contains("laptop"));
        }
    }
}
