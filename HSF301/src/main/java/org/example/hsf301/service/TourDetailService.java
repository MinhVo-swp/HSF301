package org.example.hsf301.service;
import org.example.hsf301.model.request.TourDetailRequest;
import org.example.hsf301.pojo.TourDetail;
import org.example.hsf301.repo.*;

import java.util.List;

public class TourDetailService implements ITourDetailService {
    private ITourDetailRepository tourDetailRepository;
    private ITourRepository tourRepository;
    private IKoiFarmsRepository koiFarmsRepository;
    public TourDetailService(String name) {
        tourDetailRepository = new TourDetailRepository(name);
        tourRepository = new TourRepository(name);
        koiFarmsRepository = new KoiFarmsRepository(name);
    }
    @Override
    public TourDetail addTourDetail(TourDetailRequest tourDetailRequest, Long tourDetailId) {
        TourDetail tourDetail = new TourDetail();
        if (tourDetailRequest == null) {
            throw new IllegalArgumentException("tourDetailRequest can not be null");
        }
        tourDetail.setDescription(tourDetailRequest.getDescription());
        tourDetail.setTour(tourRepository.findById(tourDetailRequest.getTourID()));
        tourDetail.setFarm(koiFarmsRepository.findById(tourDetailRequest.getFarmID()));
        tourDetailRepository.save(tourDetail);
        return tourDetail;
    }



    @Override
    public TourDetail updateTourDetailHistory(Long tourDetailId, TourDetailRequest tourDetailRequest) throws Exception {
        TourDetail tourDetail = tourDetailRepository.findById(tourDetailId);
        if (tourDetail == null) {
            throw new IllegalArgumentException("tourDetail can not be null");
        }
        if(tourDetailRequest == null) {
            throw new IllegalArgumentException("tourDetailRequest can not be null");
        }
        tourDetail.setDescription(tourDetailRequest.getDescription());
        tourDetail.setTour(tourRepository.findById(tourDetailRequest.getTourID()));
        tourDetail.setFarm(koiFarmsRepository.findById(tourDetailRequest.getFarmID()));
        tourDetailRepository.update(tourDetail);
        return tourDetail;
    }

    @Override
    public void deleteTourDetail(Long tourDetailId) {
        TourDetail tourDetail = tourDetailRepository.findById(tourDetailId);
        if (tourDetail == null) {
            throw new IllegalArgumentException("tourDetail can not be null");
        }
        tourDetailRepository.delete(tourDetailId);

    }

    @Override
    public TourDetail getTourDetail(Long tourDetailId) {
        TourDetail tourDetail = tourDetailRepository.findById(tourDetailId);
        if (tourDetail == null) {
            throw new IllegalArgumentException("tourDetail can not be null");
        }
        return tourDetail;
    }

    @Override
    public List<TourDetail> getAllTourDetails() {
        List<TourDetail> tourDetails = tourDetailRepository.findAll();
        if (tourDetails == null) {
            throw new IllegalArgumentException("no tour details found");
        }
        return tourDetails;
    }
}
