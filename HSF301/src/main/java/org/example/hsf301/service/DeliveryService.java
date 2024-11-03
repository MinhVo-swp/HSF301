package org.example.hsf301.service;

import org.example.hsf301.model.request.DeliveryRequest;
import org.example.hsf301.pojo.Account;
import org.example.hsf301.pojo.Bookings;
import org.example.hsf301.pojo.Delivery;
import org.example.hsf301.pojo.Deposit;
import org.example.hsf301.repo.*;

import java.time.LocalDateTime;
import java.util.List;

public class DeliveryService implements IDeliveryService{
    private IDeliveryRepository deliveryRepo;
    private IBookingRepository bookingRepo;
    private IDepositRepository depositRepo;
    private Account account;
    public DeliveryService(String name,Account account) {
        deliveryRepo = new DeliveryRepository(name);
        this.account = account;
        depositRepo = new DepositRepository(name);
        bookingRepo = new BookingRepository(name);
    }


    @Override
    public Delivery addDelivery(DeliveryRequest deliveryRequest, Long bookingId) {
        Delivery delivery = new Delivery();
        Bookings bookings = bookingRepo.findById(bookingId);
        if(bookings == null){return null;}
        bookings.setPaymentStatus("complete");
        bookings.setPaymentDate(LocalDateTime.now());
        bookingRepo.update(bookings);

        delivery.setDeliveryStaff(account);
        delivery.setBooking(bookings);
        delivery.setAddress(deliveryRequest.getAddress());
        delivery.setReason(deliveryRequest.getReason());
        delivery.setCustomerName(deliveryRequest.getCustomerName());
        delivery.setHealthKoiDescription(deliveryRequest.getHealthKoiDescription());
        delivery.setStatus(deliveryRequest.getStatus());
        delivery.setReceiveDate(deliveryRequest.getReceiveDate());
        Deposit deposit = depositRepo.findByBookingId(bookingId);
        delivery.setRemainAmount(deposit.getRemainAmount());
        deliveryRepo.save(delivery);
        return delivery;
    }

    @Override
    public Delivery updateDeliveryHistory(Long deliveryId, DeliveryRequest deliveryRequest) throws Exception {
        Delivery delivery = deliveryRepo.findById(deliveryId);
        delivery.setAddress(deliveryRequest.getAddress());
        delivery.setReason(deliveryRequest.getReason());
        delivery.setCustomerName(deliveryRequest.getCustomerName());
        delivery.setHealthKoiDescription(deliveryRequest.getHealthKoiDescription());
        delivery.setStatus(deliveryRequest.getStatus());
        delivery.setReceiveDate(deliveryRequest.getReceiveDate());
        deliveryRepo.update(delivery);
        return delivery;
    }

    @Override
    public void deleteDelivery(Long deliveryId) {
        deliveryRepo.delete(deliveryId);

    }

    @Override
    public Delivery getDelivery(Long deliveryId) {
        return  deliveryRepo.findById(deliveryId);
    }

    @Override
    public List<Delivery> getAllDeliveries() {
        List<Delivery> deliveries = deliveryRepo.getAll();
        return deliveries;
    }
}