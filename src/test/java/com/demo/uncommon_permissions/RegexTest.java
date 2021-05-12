package com.demo.uncommon_permissions;


import org.junit.Assert;
import org.junit.Test;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

	@Test
	public void reg1(){
		String expression = "(https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|www\\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9]+\\.[^\\s]{2,}|www\\.[a-zA-Z0-9]+\\.[^\\s]{2,})";
		Pattern pattern = Pattern.compile(expression);
		Matcher match = pattern.matcher("http://www.foufos.gr");
		Assert.assertTrue(match.matches());


		System.out.printf(Pattern.quote("http://www.foufos.gr"));
	}

}
