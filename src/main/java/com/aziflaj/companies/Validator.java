package com.aziflaj.companies;

import ru.lanwen.verbalregex.VerbalExpression;

public class Validator {
    public static boolean validName(String fullName) {
        VerbalExpression nameRegex = VerbalExpression.regex()
                .startOfLine()
                .capt().word().endCapt()
                .then(" ")
                .capt().word().endCapt()
                .anything()
                .endOfLine()
                .build();

        return nameRegex.testExact(fullName);
    }

    public static boolean validEmail(String email) {
        VerbalExpression emailRegex = VerbalExpression.regex()
                .startOfLine()
                .anything()
                .then("@")
                .anything()
                .then(".")
                .word()
                .endOfLine()
                .build();

        return emailRegex.testExact(email);
    }

    public static boolean validSsn(String ssn) {
        VerbalExpression ssnRegex = VerbalExpression.regex()
                .startOfLine()
                .capt().wordChar().count(3).endCapt() // area code
                .then("-")
                .capt().digit().count(2).endCapt() // group number
                .then("-")
                .capt().digit().count(4).endCapt() // serial numbers
                .endOfLine()
                .build();

        return ssnRegex.testExact(ssn);
    }

    public static boolean validNipt(String nipt) {
        VerbalExpression niptRegex = VerbalExpression.regex()
                .startOfLine()
                .capt().wordChar().endCapt() // a single char
                .capt().digit().count(8).endCapt() // eight numbers
                .capt().wordChar().endCapt() // a single char
                .endOfLine()
                .build();

        return niptRegex.testExact(nipt);
    }
}
