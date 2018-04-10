package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.GoogleBasePage;
import java.util.List;

public class GoogleSearchTest extends GoogleBaseTest {

    String searchTerm = "Selenium";

 @Test
 public void basicSearchTest () {

     GoogleBasePage basePage = searchPage.searchByTerm(searchTerm);
     List<String> results = searchPage.getResults();

     Assert.assertEquals(results.size(), 11, "Number of results is wrong");

     for (String result : results) {
         Assert.assertTrue(result.toLowerCase().contains(searchTerm.toLowerCase()),
                 "Searchterm " + searchTerm + " not found in cart");
     }
 }

 @Test
 public void nextPageSearchTest(){

     GoogleBasePage basePage = searchPage.searchByTerm(searchTerm);
     List<String> results = searchPage.getResults();
     basePage=searchPage.clickToNextPage();
     List<String> resultsForNextPage = searchPage.getResults();

     Assert.assertEquals(resultsForNextPage.size(), 10,"Number of results is wrong");

     for (String result : resultsForNextPage) {
         Assert.assertTrue(result.toLowerCase().contains(searchTerm.toLowerCase()),
                 "Searchterm "+searchTerm+ " not found in cart");
     }
   }
}