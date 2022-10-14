package pt.mankings.ies.moviequoter;

public class Quote {
    
    private final String quote;
    private final String show;

    public Quote(String quote, String show) {
        this.show = show;
        this.quote = quote;
    }

    public String getShow() {
        return show;
    }

    public String getQuote() {
        return quote;
    }
}
