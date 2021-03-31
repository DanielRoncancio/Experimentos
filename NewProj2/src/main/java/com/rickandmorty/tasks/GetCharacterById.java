package com.rickandmorty.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetCharacterById implements Task {

	private String characterID;
	
	public GetCharacterById(String characterID) {
		this.characterID = characterID;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Get.resource("/character/"+ characterID));
		
	}
	
	public static GetCharacterById withNumber(String characterID) {
		
		return Tasks.instrumented(GetCharacterById.class, characterID);
	}

}
