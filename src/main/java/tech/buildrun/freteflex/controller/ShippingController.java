package tech.buildrun.freteflex.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.buildrun.freteflex.controller.dto.ShippingResponse;
import tech.buildrun.freteflex.service.ShippingCalculatorService;

@RestController
public class ShippingController {

    private final ShippingCalculatorService shippingCalculatorService;

    public ShippingController(ShippingCalculatorService shippingCalculatorService) {
        this.shippingCalculatorService = shippingCalculatorService;
    }

    @GetMapping("/shipping/calculate")
    public ResponseEntity<ShippingResponse> calculateShipping(@RequestParam("type") String type,
                                                              @RequestParam("distance") Double distance,
                                                              @RequestParam("weight") Double weight) {

        double cost = shippingCalculatorService.calculate(type, distance, weight);

        return ResponseEntity.ok(new ShippingResponse(cost));
    }
}
