package com.company.dto;

import com.company.domain.Payment;
import com.company.domain.PointOfSale;

public class PaymentsOfPointSale {

    private Payment payment;
    private PointOfSale pointOfSale;

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public PointOfSale getPointOfSale() {
        return pointOfSale;
    }

    public void setPointOfSale(PointOfSale pointOfSale) {
        this.pointOfSale = pointOfSale;
    }
}
