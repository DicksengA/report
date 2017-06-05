package task;

import com.google.common.base.Preconditions;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import org.fluentlenium.core.annotation.Page;
import pages.Google;
import pages.IMDBPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Created by  on 05/05/2017.
 */
@DefaultUrl("http://www.imdb.com")
public class OpenTheApplication implements Task{

    private Google google;

    private IMDBPage imdbPage;

    private String startingPage;

    @Override
    public <T extends Actor> void performAs(T t) {
        Preconditions.checkNotNull(this.startingPage);
        if(this.startingPage.equalsIgnoreCase("google")){
            t.attemptsTo(Open.browserOn(google));
        }else{
            t.attemptsTo(Open.browserOn(imdbPage));
        }
    }

    public OpenTheApplication(String page){
        this.startingPage = page;
    }



    public static OpenTheApplication google() {
        return Instrumented.instanceOf(OpenTheApplication.class).withProperties("google");
    }
    public static OpenTheApplication imdb() {
        return Instrumented.instanceOf(OpenTheApplication.class).withProperties("imdb");
    }


}
