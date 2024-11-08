package org.example.hsf301;

import org.example.hsf301.constants.ResourcePaths;
import org.example.hsf301.dao.IDeliveryHistoryDAO;
import org.example.hsf301.enums.CCSTATUS;
import org.example.hsf301.enums.PaymentMethod;
import org.example.hsf301.model.request.*;
import org.example.hsf301.pojo.*;
import org.example.hsf301.service.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class maintest {
    public static void main(String[] args) throws Exception {
        IBookingKoiService bookingKoiService = new BookingKoiService(ResourcePaths.HIBERNATE_CONFIG);
//        Bookings booking = new Bookings();
        IAccountService accountService = new AccountService(ResourcePaths.HIBERNATE_CONFIG);

//
//        Account account = accountService.findByUserName("minh1"); // Khởi tạo account theo yêu cầu của bạn.
//        Account account = accountService.findByUserName("deliverystaff");
//////
//////
//        BookingKoiRequest bookingKoiRequest = new BookingKoiRequest();
//        bookingKoiRequest.setBookingDate(LocalDate.now());
//        bookingKoiRequest.setDiscountAmount(50);
//        bookingKoiRequest.setVat(0.3f);
//        bookingKoiRequest.setPaymentMethod(PaymentMethod.BANKING);
////
//        BookingKoiDetailRequest bookingKoiDetailRequest = new BookingKoiDetailRequest();
//        bookingKoiDetailRequest.setKoiId(1L);
//        bookingKoiDetailRequest.setFarmId(1L);
//        bookingKoiDetailRequest.setQuantity(10);
//        bookingKoiDetailRequest.setUnitPrice(10);
////
////        BookingKoiDetailRequest bookingKoiDetailRequest2 = new BookingKoiDetailRequest();
////        bookingKoiDetailRequest2.setKoiId(10002L);
////        bookingKoiDetailRequest2.setFarmId(10003L);
////        bookingKoiDetailRequest2.setQuantity(10);
////        bookingKoiDetailRequest2.setUnitPrice(8);
//
//        List<BookingKoiDetailRequest> detailRequests = new ArrayList<>();
//        detailRequests.add(bookingKoiDetailRequest);
////        detailRequests.add(bookingKoiDetailRequest2);
//
//        bookingKoiRequest.setDetails(detailRequests);
//
//        bookingKoiService.createKoiBooking(bookingKoiRequest, 3L, account);
//
    KoiFarmService koiFarmService = new KoiFarmService(ResourcePaths.HIBERNATE_CONFIG);
    KoiService koiService = new KoiService(ResourcePaths.HIBERNATE_CONFIG);
        KoiOfFarmService koiOfFarmService = new KoiOfFarmService(ResourcePaths.HIBERNATE_CONFIG);
//        KoiFarmRequest koiFarmRequest = new KoiFarmRequest();
//        koiFarmRequest.setFarmAddress("Test");
//        koiFarmRequest.setFarmName("Test");
//        koiFarmRequest.setFarmEmail("Test@test.com");
//        koiFarmRequest.setActive(true);
//        koiFarmRequest.setFarmPhoneNumber("012321392");
//        koiFarmRequest.setImages("test.jpg");
//        koiFarmRequest.setDescription("Test");
//        koiFarmRequest.setWebsite("Test");
//    koiFarmService.addKoiFarm(koiFarmRequest);

//    KoiFarms koiFarms= koiFarmService.findById(10002L);
//    Koi koi = koiService.findByKoiId(10002L);
        IDepositService depositService = new DepositService(ResourcePaths.HIBERNATE_CONFIG);
        IDeliveryHistoryService deliveryHistoryService = new DeliveryHistoryService(ResourcePaths.HIBERNATE_CONFIG);
        IDeliveryService deliveryService = new DeliveryService(ResourcePaths.HIBERNATE_CONFIG);
//        DepositRequest depositRequest = new DepositRequest();
//        depositRequest.setDepositPercentage(0.2f);
//        depositRequest.setShippingAddress("vietnam");
//        depositRequest.setDeliveryExpectedDate(LocalDate.now());
//        depositRequest.setShippingFee(20f);
//        depositService.createDeposit(depositRequest,10013L);
//        DeliveryHistoryRequest deliveryHistoryRequest = new DeliveryHistoryRequest();
//        deliveryHistoryRequest.setRoute("Loading...");
//        deliveryHistoryRequest.setHealthKoiDescription("All of kois are good");
//        deliveryHistoryService.addDeliveryHistory(deliveryHistoryRequest,10013L,account);
//        DeliveryRequest deliveryRequest = new DeliveryRequest();
//        deliveryRequest.setAddress("Viet nam");
//        deliveryRequest.setHealthKoiDescription("All good");
//        deliveryRequest.setStatus(CCSTATUS.COMPLETED);
//        deliveryRequest.setCustomerName("Vo Quang Minh");
//        deliveryRequest.setReceiveDate(LocalDate.now());
//        deliveryService.addDelivery(deliveryRequest,10013L,account);
    List<Bookings> list = bookingKoiService.getAllKoiBookings();
    for(Bookings booking : list){
        System.out.println(booking.getId());
    }
    }
}
