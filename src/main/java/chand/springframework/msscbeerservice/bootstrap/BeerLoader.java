package chand.springframework.msscbeerservice.bootstrap;

import chand.springframework.msscbeerservice.domain.Beer;
import chand.springframework.msscbeerservice.repository.BeerRepository;
import chand.springframework.msscbeerservice.web.model.BeerStyleEnum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }


    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {

            beerRepository.save(Beer.builder()
                .beerName("First Beer")
                .beerStyle(BeerStyleEnum.LAGER)
                .quantityOnHand(12)
                .upc(31231231422L)
                .price(new BigDecimal("232.21"))
                .build());
            beerRepository.save(Beer.builder()
                    .beerName("Second Beer")
                    .beerStyle(BeerStyleEnum.ALE)
                    .quantityOnHand(145)
                    .upc(23221422L)
                    .price(new BigDecimal("532.21"))
                    .build());
            beerRepository.save(Beer.builder()
                    .beerName("Third Beer")
                    .beerStyle(BeerStyleEnum.PILSNER)
                    .quantityOnHand(112)
                    .upc(13231422L)
                    .price(new BigDecimal("32.21"))
                    .build());
        }
    }
}
