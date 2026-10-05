package tech.buildrun.freteflex.domain;

import org.springframework.stereotype.Component;

@Component
public class ExpressShippingCalculator implements ShippingCalculator {

    @Override
    public double calculate(double distance, double weight) {
        return weight * 1.5 + distance * 0.75;
    }
}
