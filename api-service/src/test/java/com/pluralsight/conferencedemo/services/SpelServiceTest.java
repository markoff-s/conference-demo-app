package com.pluralsight.conferencedemo.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class SpelServiceTest {

    class User {
        private String name;
        private String country;

        // this is evaluated by the BeanPostProcessor, so in this case this won't work since it's not injected
        // it works in com.pluralsight.conferencedemo.controllers.HealthController
        @Value("#{systemProperties['user.language']}")
        private String language;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }
    }

    @Test
    public void parseSpELExpressions() {
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("'Hello World!'");
        System.out.println(expression.getValue());

        expression = parser.parseExpression("'Hello World!'.length()");
        System.out.println(expression.getValue());

        expression = parser.parseExpression("'Hello World!'.length() * 10");
        System.out.println(expression.getValue());

        expression = parser.parseExpression("'Hello World!'.length() > 10");
        System.out.println(expression.getValue());
    }

    @Test
    public void dynamicallyWireBeans() {
        SpelExpressionParser parser = new SpelExpressionParser();
        User user = new User();
        StandardEvaluationContext ctx = new StandardEvaluationContext(user);

        parser.parseExpression("name").setValue(ctx, "Gena");
        parser.parseExpression("country").setValue(ctx, "USA");

        System.out.println(user.getName());
        System.out.println(user.getCountry());
    }
}


















