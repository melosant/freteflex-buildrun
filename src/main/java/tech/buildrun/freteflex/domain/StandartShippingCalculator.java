package tech.buildrun.freteflex.domain;

import org.springframework.stereotype.Component;

@Component
public class StandartShippingCalculator implements ShippingCalculator {

    @Override
    public double calculate(double distance, double weight) {
        return weight + distance * 0.5;
    }
}
