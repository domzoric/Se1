package org.hbrs.se1.ss24.uebung1.businesslogic;

import java.text.DecimalFormat;

public class GermanFormatNumberTransformer implements NumberTransformer{
    @Override
    public String transformNumber(int number) {
        if (number < 1 || number > 3000) {
            return ErrorMessage;
        }
        DecimalFormat germanFormat = new DecimalFormat("#,###");
        return germanFormat.format(number);
    }

    @Override
    public String getTransformerType() {
        return "Transformer für deutsche Zahlenformatierungen";
    }
}
