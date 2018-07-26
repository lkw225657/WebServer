package net.transino.lms.modules.ext.ws.server.constraint;

import jodd.vtor.ValidationConstraint;
import jodd.vtor.ValidationConstraintContext;

import java.util.regex.Pattern;

/**
 * @author lee
 * @since 5.0
 */
public class RegexMatchConstraint implements ValidationConstraint<RegexMatch> {
    public RegexMatchConstraint() {}

    public RegexMatchConstraint(String pattern) {
        this.pattern = pattern;
    }

    protected String pattern;

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public void configure(RegexMatch annotation) {
        pattern = annotation.value();
    }

    @Override
    public boolean isValid(ValidationConstraintContext vcc, Object value) {
        return validate(value, pattern);
    }

    private boolean validate(Object value, String regex) {
        if (value == null) {
            return true;
        }

        String str = value.toString();
        if (str.length() == 0) {
            return true;
        }
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(str).matches();
    }
}