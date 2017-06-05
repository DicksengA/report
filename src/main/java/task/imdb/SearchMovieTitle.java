package task.imdb;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import pages.imdb.IMDBMainPage;

/**
 * Created by  on 08/05/2017.
 */
public class SearchMovieTitle implements Task {

    IMDBMainPage mainPage;

    String movieTitle;

    @Override
    @Step("{0} search for a movie title #movieTitle")
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                Enter.theValue(movieTitle).into(IMDBMainPage.SEARCH_BAR),
                Hit.the(Keys.ENTER).into(IMDBMainPage.SEARCH_BAR)
        );
    }

    public SearchMovieTitle(String movieTitle){
        this.movieTitle = movieTitle;
    }

    public static SearchMovieTitle searchTitle(String title){
        return Instrumented.instanceOf(SearchMovieTitle.class).withProperties(title);
    }
}
