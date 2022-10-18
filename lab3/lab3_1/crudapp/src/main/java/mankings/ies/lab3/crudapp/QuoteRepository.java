package mankings.ies.lab3.crudapp;

//import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends CrudRepository<Quote, Long> {
    //List<Quote> findByName(String name);
}