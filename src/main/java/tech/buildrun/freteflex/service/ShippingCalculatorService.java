package tech.buildrun.freteflex.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tech.buildrun.freteflex.domain.ExpressShippingCalculator;
import tech.buildrun.freteflex.domain.ShippingCalculator;
import tech.buildrun.freteflex.domain.StandartShippingCalculator;

@Service
public class ShippingCalculatorService {

    // princícios de DI e IoC
    // @Qualifier -> qualificar qual bean utilizar das implementações de uma interface pelo nome
    private final ShippingCalculator standartShippingCalculator;
    private final ShippingCalculator expressShippingCalculator;

    public ShippingCalculatorService(@Qualifier("standartShippingCalculator") StandartShippingCalculator standartShippingCalculator,
                                     @Qualifier("expressShippingCalculator") ExpressShippingCalculator expressShippingCalculator) {
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
