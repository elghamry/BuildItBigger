package com.example;

import java.util.Random;

public class JokeProvider {
    private static final String[] jokes = {
            "A programmer walks to the butcher shop and buys a kilo of meat.  An hour later he comes back upset that the butcher shortchanged him by 24 grams.",
            "The generation of random numbers is too important to be left to chance.",
            "There are three kinds of lies: Lies, damned lies, and benchmarks.",
            "How many programmers does it take to change a light bulb ? None, that's a hardware problem",
            "When is a function a bad investment? \"When there's no return\"",
            "How do functions break up? \"They stop calling each other!\"",
            "What do threads do after they make love? \"They go to sleep\"",
            "Firefox: IE with lipstick on."
    };

    public static String getJoke(){
        int size = jokes.length;

        Random r = new Random();
        int index = r.nextInt(size);

        return jokes[index];
    }
}
