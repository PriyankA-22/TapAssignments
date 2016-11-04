package com.qait.demo.tests;

import com.qait.demo.keywords.IMDbSearchApi;
import com.qait.demo.keywords.IMDbWebLandingPage;
import com.qait.demo.keywords.IMDbWebResultList;
import org.testng.annotations.*;
import static org.assertj.core.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.json.JSONObject;


/* IMDB DSL */

/**
 *
 * @author Ramandeep <RamandeepSingh@QAInfoTech.com>
 */
public class TestLevel4_IMDbApplication_DSLTest {
    
    WebDriver browser;
    
    @BeforeClass
    public void setUp(){
        browser = new ChromeDriver();
    }
    
    @AfterClass
    public void tearDown(){
        browser.quit();
    }
    
    @DataProvider
    public String[][] movieTitles(){
        return new String[][] {
            {"The Dark Knight"}
        };
    }
    
    /**
     * Test for search on IMDb.com
     * @param movie 
     */
    @Test(dataProvider="movieTitles")
    public void web_search_for_title_should_display_list_of_macthing_movies(
            String movie){
        IMDbWebResultList imdbResultList = new IMDbWebLandingPage(browser)
                .searchFor(movie);
        
        assertThat(imdbResultList.getResult(0).getTitle()).startsWith(movie);
    }
    
    /**
     * Test for unofficial IMDB API @ http://www.omdbapi.com 
     * @param movie
     * @throws Exception 
     */
    @Test(dataProvider="movieTitles")
    public void api_search_for_title_should_return_list_of_matching_movies(
            String movie) throws Exception{
        JSONObject resultList = new IMDbSearchApi().searchForMovie(movie);
        
        assertThat(resultList.getJSONArray("Search")
                .getJSONObject(0)
                .get("Title").toString()
        ).startsWith(movie);
    }
}
