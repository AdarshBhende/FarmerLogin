package com.example.Farmerlogin.service;

import com.example.Farmerlogin.model.Dispatch;
import com.example.Farmerlogin.model.Lot;
import com.example.Farmerlogin.repository.DispatchRepository;
import com.example.Farmerlogin.repository.LotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DispatchService {

    @Autowired
    private DispatchRepository dispatchRepository;

    @Autowired
    private LotRepository lotRepository;

    // Save a new Dispatch
    public Dispatch saveDispatch(Dispatch dispatch) {
        return dispatchRepository.save(dispatch);
    }

    // Fetch all dispatches
    public List<Dispatch> getAllDispatches() {
        return dispatchRepository.findAll();
    }

    // Get a dispatch by ID
    public Optional<Dispatch> getDispatchById(Long id) {
        return dispatchRepository.findById(id);
    }

    // Update a dispatch
    public Dispatch updateDispatch(Long id, Dispatch updatedDispatch) {
        return dispatchRepository.findById(id).map(dispatch -> {
            dispatch.setCommodityCode(updatedDispatch.getCommodityCode());
            dispatch.setSeason(updatedDispatch.getSeason());
            dispatch.setDispatchQty(updatedDispatch.getDispatchQty());
            dispatch.setDispatchBags(updatedDispatch.getDispatchBags());
            dispatch.setDispatchValue(updatedDispatch.getDispatchValue());
            dispatch.setDispatchStatus(updatedDispatch.getDispatchStatus());
            dispatch.setRemark(updatedDispatch.getRemark());
            return dispatchRepository.save(dispatch);
        }).orElseThrow(() -> new RuntimeException("Dispatch not found"));
    }

    // Delete a dispatch
    public void deleteDispatch(Long id) {
        dispatchRepository.deleteById(id);
    }

    // Assign a Lot to a Dispatch
    public Dispatch assignLotToDispatch(Long dispatchId, Long lotId) {
        Dispatch dispatch = dispatchRepository.findById(dispatchId)
                .orElseThrow(() -> new RuntimeException("Dispatch not found"));
        Lot lot = lotRepository.findById(lotId)
                .orElseThrow(() -> new RuntimeException("Lot not found"));


        return dispatchRepository.save(dispatch);
    }
}