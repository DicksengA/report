package pages.imdb;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.targets.TargetBuilder;

/**
 * Created by on 08/05/2017.
 */
public class IMDBMainPage {

    public static Target SEARCH_BAR
            = Target.the("SEARCH BAR").locatedBy("#navbar-query");

    public static Target TITLE_RESULTS = Target.the("Title Results").locatedBy("//h3[@class='findSectionHeader' and text()='Titles']/..//td[@class='result_text']");

}
