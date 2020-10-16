package chand.springframework.msscbeerservice;

import chand.springframework.msscbeerservice.web.model.BeerDto;
import chand.springframework.msscbeerservice.web.model.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
                .id(beerId)
                .beerName("Chandana E")
                .lastModifiedDated(OffsetDateTime.now())
                .createdDate(OffsetDateTime.now())
                .upc(222222L)
                .price(new BigDecimal(12.32))
                .version(2)
                .beerStyle(BeerStyleEnum.LAGER).build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        log.debug("Saving the beer " + beerDto.getId().toString());
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Apple Cat")
                .beerStyle(BeerStyleEnum.LAGER).upc(10L).build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        log.debug("Updating the beer " + beerId.toString());
    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.debug("Deleting a beer..." + beerId.toString());
    }


}
