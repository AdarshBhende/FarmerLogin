package com.example.Farmerlogin.controller;

import com.example.Farmerlogin.model.Dispatch;
import com.example.Farmerlogin.service.DispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dispatch")
public class DispatchController {

    @Autowired
    private DispatchService dispatchService;

    // Add a new Dispatch
    @PostMapping("/add")
    public Dispatch createDispatch(@RequestBody Dispatch dispatch) {
        return dispatchService.saveDispatch(dispatch);
    }

    // Get all Dispatches
    @GetMapping("/all")
    public List<Dispatch> getAllDispatches() {
        return dispatchService.getAllDispatches();
    }

    // Get a Dispatch by ID
    @GetMapping("/{id}")
    public Optional<Dispatch> getDispatchById(@PathVariable Long id) {
        return dispatchService.getDispatchById(id);
    }

    // Update a Dispatch
    @PutMapping("/{id}")
    public Dispatch updateDispatch(@PathVariable Long id, @RequestBody Dispatch updatedDispatch) {
        return dispatchService.updateDispatch(id, updatedDispatch);
    }

    // Delete a Dispatch
    @DeleteMapping("/{id}")
    public String deleteDispatch(@PathVariable Long id) {
        dispatchService.deleteDispatch(id);
        return "Dispatch deleted successfully";
    }

    // Assign Lot to Dispatch
    @PostMapping("/{dispatchId}/assign-lot/{lotId}")
    public Dispatch assignLotToDispatch(@PathVariable Long dispatchId, @PathVariable Long lotId) {
        return dispatchService.assignLotToDispatch(dispatchId, lotId);
    }
}