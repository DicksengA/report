package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.UIStateReaderBuilder;
import pages.imdb.IMDBMainPage;

import java.util.List;

/**
 * Created by  on 09/05/2017.
 */
public class TitleResults implements Question<List<String>>{

    @Override
    public List<String> answeredBy(Actor actor) {
        return Text.of(IMDBMainPage.TITLE_RESULTS).viewedBy(actor).asList();
    }

    public static TitleResults displayed(){
        return new TitleResults();
    }
}
