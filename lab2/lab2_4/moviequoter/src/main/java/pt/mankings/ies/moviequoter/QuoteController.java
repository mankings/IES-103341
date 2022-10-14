package pt.mankings.ies.moviequoter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class QuoteController {

    private final String quotefile = "catchphrases.txt";
    private final String defaultmsg = "Hello %s! Ready for some quotes?";

    // @GetMapping("/api")
    // public Quote quote(@RequestParam(name = "user", defaultValue = "World")
    // String user) {
    // return new Quote(counter.incrementAndGet(), String.format(defaultmsg, user));
    // }

    @GetMapping("/api/quote")
    public Quote randomQuote() {
        ArrayList<Quote> quotes = loadQuotes();
        return quotes.get(randInt(quotes.size()));
    }

    // @GetMapping("/api/shows")
    // public Quote getShows() {
    //     ArrayList<Quote> quotes = loadQuotes();
    // }

    @GetMapping("api/quotes")
    public Quote randomQuoteFromShow(@RequestParam(name = "show", defaultValue = "") String show) {
        ArrayList<Quote> quotes = loadQuotes();
        ArrayList<Quote> filteredQuotes = new ArrayList<>();
        for(Quote q : quotes)
            if (q.getShow().matches(show))
                filteredQuotes.add(q);
        
        return filteredQuotes.get(randInt(filteredQuotes.size()));

    }

    private ArrayList<Quote> loadQuotes() {
        ArrayList<Quote> quotes = new ArrayList<>();

        Scanner filesc = null;
        try {
            filesc = new Scanner(new File(quotefile));
            while (filesc.hasNextLine()) {
                String[] data = filesc.nextLine().split(";");
                quotes.add(new Quote(data[0], data[1]));
            }
            filesc.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error: Quote file not found.");
            System.exit(1);
        }

        return quotes;
    }

    private int randInt(int max) {
        return ThreadLocalRandom.current().nextInt(0, max);
    }
}
