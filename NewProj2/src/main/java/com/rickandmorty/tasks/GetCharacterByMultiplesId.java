package com.rickandmorty.tasks;

import java.util.Iterator;
import java.util.List;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetCharacterByMultiplesId implements Task {
	
	private List<String> listaIds;
	
	public GetCharacterByMultiplesId(List<String> listaIds) {
		this.listaIds = listaIds;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		String ids = listaIds.get(0);
		for (int i = 1; i < listaIds.size(); i++) {
			ids = "," + listaIds.get(i);
		}
		actor.attemptsTo(Get.resource("/character/"+ ids));
		
	}
	public static GetCharacterByMultiplesId withNumber(List<String> listaIds) {
		
		return Tasks.instrumented(GetCharacterByMultiplesId.class, listaIds);
	}

}
