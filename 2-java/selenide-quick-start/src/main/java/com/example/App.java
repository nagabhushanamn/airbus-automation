package com.example;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import org.openqa.selenium.By.ById;

public class App {

	public static void main(String[] args) {

		
		open("http://localhost:3000/");

		$(ById.id("amount")).setValue("100.00");
		$(ById.id("fromAccNumber")).setValue("1");
		$(ById.id("toAccNumber")).setValue("2");
		
		$(ById.id("txr-form")).submit();
		
		System.out.println($(".alert-warning").getText());

	}

}
