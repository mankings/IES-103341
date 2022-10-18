package mankings.ies.lab3.crudapp;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QuoteController {
    
    private final QuoteRepository quoteRepository;

    @Autowired
    public QuoteController(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @GetMapping("/index") 
    public String showQuoteList(Model model) {
        model.addAttribute("quotes", quoteRepository.findAll());
        return "index";
    }

    @GetMapping("/enterquote")
    public String showSignUpForm(Quote quote) {
        return "add-quote";
    }

    @PostMapping("/addquote")
    public String addUser(@Valid Quote quote, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-quote";
        }
        
        quoteRepository.save(quote);
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        Quote quote = quoteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid quote Id: " + id));
        model.addAttribute("quote", quote);

        return "update-quote";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid Quote quote, BindingResult result, Model model) {
        if (result.hasErrors()) {
            quote.setId(id);
            return "update-quote";
        }
        
        quoteRepository.save(quote);

        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteQuote(@PathVariable("id") long id, Model model) {
        Quote quote = quoteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid quote Id: " + id));
        quoteRepository.delete(quote);

        return "redirect:/index";
    }
}
