package tech.buildrun.freteflex.service;

import org.springframework.stereotype.Service;
import tech.buildrun.freteflex.domain.ExpressShippingCalculator;
import tech.buildrun.freteflex.domain.StandartShippingCalculator;

@Service
public class ShippingCalculatorService {

    // princícios de DI e IoC
    private final StandartShippingCalculator standartShippingCalculator;
    private final ExpressShippingCalculator expressShippingCalculator;

    public ShippingCalculatorService(StandartShippingCalculator standartShippingCalculator,
                                     ExpressShippingCalculator expressShippingCalculator) {
        this.standartShippingCalculator = standartShippingCalculator;
        this.expressShippingCalculator = expressShippingCalculator;
    }

    public double calculate(String shippingType,
                            Double distance,
                            Double weight) {

        if (shippingType.equalsIgnoreCase("standart")) {
            return standartShippingCalculator.calculate(distance, weight);
        }
        else if (shippingType.equalsIgnoreCase("express")) {
            return expressShippingCalculator.calculate(distance, weight);
        }
        else {
            throw new RuntimeException("Tipo inválido!");
        }
    }
}
