package com.wordpress.priyankvex.easyocrscannerdemo;

import android.util.Log;

import org.mariuszgromada.math.mxparser.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;

/**
 * Created by alex on 28.05.2017.
 */

public class MathProcessor {

    public static String solveExpression(String expression) {

        Expression e = new Expression(expression);
        e.setDescription("OCREXP");
        e.setVerboseMode();


        Log.w("MATHPROCESOOOOOOR", "Res: " + e.getExpressionString() + " = " + e.calculate());

        String bigSplit = "[OCREXP][" + e.getExpressionString() + "] Parsing ";

        String consolOutput = mXparser.getConsoleOutput();
        String[] bigSteps = consolOutput.split(Pattern.quote(bigSplit));

        List<String> smalLSteps =  new ArrayList<String>();

        for (int i = 0; i < bigSteps.length; i++) {
            String[] smallStepsTemp = bigSteps[i].split("--->");

            for (int smalli = 0; smalli < smallStepsTemp.length; smalli++) {
                smalLSteps.add(smallStepsTemp[smalli]);
            }

        }

        smalLSteps.remove(smalLSteps.size()-1);

        for (int i2 = 0; i2 < smalLSteps.size(); i2++) {

            smalLSteps.set(i2, smalLSteps.get(i2).replace("[mXparser-v.4.0.0]",""));
            smalLSteps.set(i2, smalLSteps.get(i2).replace("[OCREXP][" + e.getExpressionString() + "]",""));
            smalLSteps.set(i2, smalLSteps.get(i2).replace("Starting",""));
            smalLSteps.set(i2, smalLSteps.get(i2).replace("...",""));
            smalLSteps.set(i2, smalLSteps.get(i2).replace("done",""));
            smalLSteps.set(i2, smalLSteps.get(i2).replace(" ",""));
            smalLSteps.set(i2, smalLSteps.get(i2).replace("\n",""));
            smalLSteps.set(i2, smalLSteps.get(i2).replaceAll("\\(.*?\\) ?", ""));

            Log.w("DASS", smalLSteps.get(i2));

        }


        return smalLSteps.toString();
    }

    public static String difference(String str1, String str2) {
        if (str1 == null) {
            return str2;
        }
        if (str2 == null) {
            return str1;
        }
        int at = indexOfDifference(str1, str2);
        if (at == -1) {
            return "";
        }
        return str2.substring(at);
    }
    public static int indexOfDifference(String str1, String str2) {
        if (str1 == str2) {
            return -1;
        }
        if (str1 == null || str2 == null) {
            return 0;
        }
        int i;
        for (i = 0; i < str1.length() && i < str2.length(); ++i) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
        }
        if (i < str2.length() || i < str1.length()) {
            return i;
        }
        return -1;
    }

}
