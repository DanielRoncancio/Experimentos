package com.rickandmorty.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;


import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

import org.hamcrest.Matchers;

import com.rickandmorty.tasks.GetCharacterById;

public class GetCharacterStepDefinitions {

	private static final String Daniel = "DANIEL";

	@Given("^the user can get characters from the rick and morty api$")
	public void theUserCanGetCharactersFromTheRickAndMortyApi() throws Exception {
		OnStage.setTheStage(new OnlineCast());
		theActorCalled(Daniel).whoCan(CallAnApi.at("https://rickandmortyapi.com/api"));
	}

	@When("^he asks for the charater with id \"([^\"]*)\"$")
	public void heAsksForTheCharaterWithId(String characterID) throws Exception {
		theActorInTheSpotlight().attemptsTo(GetCharacterById.withNumber(characterID));
	}

	@Then("^he verifies the status code is \"([^\"]*)\"$")
	public void heVerifiesTheStatusCodeIs(String code) throws Exception {
		theActorInTheSpotlight().should(seeThatResponse("The status code should be "+ code ,
                response -> response.statusCode(Integer.parseInt(code))
                .body("origin.name", Matchers.equalTo("unknown"))
                ));
		System.out.println(SerenityRest.lastResponse().asString());
	
	}
	@Then("^he verifies the name is \"([^\"]*)\"$")
	public void heVerifiesTheNameIs(String name) throws Exception {
	    theActorInTheSpotlight().should(seeThatResponse("the name should be "+ name,
	           response -> response.body("name", Matchers.equalTo(name))));
	}
}
