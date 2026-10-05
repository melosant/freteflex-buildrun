package tech.buildrun.freteflex.domain;

import org.springframework.stereotype.Component;

// @Component -> indica que esta classe é um Bean para ser gerenciado pelo Spring
@Component("expressShippingCalculator")
public class ExpressShippingCalculator implements ShippingCalculator {

    @Override
    public double calculate(double distance, double weight) {
        return weight * 1.5 + distance * 0.75;
    }
}
