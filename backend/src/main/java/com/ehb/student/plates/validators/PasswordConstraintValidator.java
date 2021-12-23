package com.ehb.student.plates.validators;

import com.ehb.student.plates.annotations.validation.ValidPassword;
import com.ehb.student.plates.exceptions.InvalidParameterException;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.EnglishSequenceData;
import org.passay.IllegalSequenceRule;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.Rule;
import org.passay.RuleResult;
import org.passay.WhitespaceRule;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null) {
            throw new InvalidParameterException("Password must be provided.");
        }

        final List<Rule> rules = Arrays.asList(
                new LengthRule(8, 64),
                new CharacterRule(EnglishCharacterData.Digit),
                new CharacterRule(EnglishCharacterData.LowerCase),
                new CharacterRule(EnglishCharacterData.UpperCase),
                new CharacterRule(EnglishCharacterData.Special),
                new IllegalSequenceRule(EnglishSequenceData.Numerical),
                new IllegalSequenceRule(EnglishSequenceData.Alphabetical),
                new WhitespaceRule()
        );

        PasswordValidator validator = new PasswordValidator(rules);
        RuleResult result = validator.validate(new PasswordData(password));

        if (result.isValid()) {
            return true;
        }

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(String.join("\n", validator.getMessages(result)))
                .addConstraintViolation();

        return false;
    }
}
