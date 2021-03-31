package com.rickandmorty.runners;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
//indicarle a la clase que va ser un runner // el runner ejecuta pruebas 
@RunWith(CucumberWithSerenity.class) 
// Son parametros de configuracion de ejecucion del runner
@CucumberOptions(features="src\\test\\resources\\com\\rickandmorty\\features\\GetCharacter.feature", 
        glue="com.rickandmorty.stepdefinitions",
        snippets= SnippetType.CAMELCASE)

public class GetCharacterRunner {

}
