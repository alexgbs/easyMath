package com.wordpress.priyankvex.easyocrscannerdemo;

import android.util.Log;

import org.mariuszgromada.math.mxparser.*;

/**
 * Created by alex on 28.05.2017.
 */

public class MathProcessor {

    public static String solveExpression(String expression) {

        Expression e = new Expression(expression);
        e.setDescription("Example - verbose mode");
        e.setVerboseMode();


        Log.w("MATHPROCESOOOOOOR", "Res: " + e.getExpressionString() + " = " + e.calculate());

        Log.w("STEPS:", mXparser.getConsoleOutput());

        return e.calculate() + "";
    }

}
