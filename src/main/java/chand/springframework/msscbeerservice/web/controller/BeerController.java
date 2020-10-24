package chand.springframework.msscbeerservice.web.controller;

import chand.springframework.msscbeerservice.BeerService;
import chand.springframework.msscbeerservice.BeerServiceImpl;
import chand.springframework.msscbeerservice.web.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {


    @Autowired
    private BeerService beerService;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveBeer(@Valid @RequestBody BeerDto beerDto) {
        beerService.saveNewBeer(beerDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeer(@PathVariable("beerId") UUID beerId,@Valid @RequestBody BeerDto beerDto) {
        beerService.updateBeer(beerId, beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    public ResponseEntity deleteBeer(@PathVariable("beerId") UUID beerId) {
        beerService.deleteBeer(beerId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
