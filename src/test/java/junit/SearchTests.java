package junit;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Issue;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import questions.TitleResults;
import task.OpenTheApplication;
import task.imdb.SearchMovieTitle;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;


/**
 * Created by  on 05/05/2017.
 */
@RunWith(SerenityRunner.class)
public class SearchTests {

    @Before
    public void annaCanBrowseTheWeb() {
        OnStage.setTheStage(new OnlineCast());
    }


    @Test
    @Issue("#AAA-172")
    public void abc() {
        Actor anna = OnStage.theActorCalled("Private Bank user");
        Actor tom = OnStage.theActorCalled("Wealth Management user");
        anna.attemptsTo(OpenTheApplication.imdb());
        tom.attemptsTo(OpenTheApplication.google());
        anna.attemptsTo(
                SearchMovieTitle.searchTitle("Hulk")
        );
        anna.should(
                seeThat(TitleResults.displayed(), Matchers.hasItem("Hulk (2003)")),
                seeThat(TitleResults.displayed(), Matchers.hasItem("Hulk (2017)")),
                seeThat(TitleResults.displayed(), Matchers.hasItem("The Death of the Incredible Hulk (1990) (TV Movie)"))
        );



    }


    @Test
    @Issue("#AAA-172")
    public void test2() {
        Actor anna = OnStage.theActorCalled("Private Bank user");
        Actor candice = OnStage.theActorCalled("Wealth Management user");
        anna.attemptsTo(OpenTheApplication.imdb());
        candice.attemptsTo(OpenTheApplication.google());
        anna.attemptsTo(
                SearchMovieTitle.searchTitle("Hulk")
        );
        anna.should(
                seeThat(TitleResults.displayed(), Matchers.hasItem("Hulk (2003)")),
                seeThat(TitleResults.displayed(), Matchers.hasItem("Hulk (2017)")),
                seeThat(TitleResults.displayed(), Matchers.hasItem("The Death of the Incredible Hulk (1990) (TV Movie)"))
        );


    }
}
