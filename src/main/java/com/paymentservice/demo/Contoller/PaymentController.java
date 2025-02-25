package com.paymentservice.demo.Contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paymentservice.demo.DTO.PaymentRequest;
import com.paymentservice.demo.DTO.PaymentResponse;
import com.paymentservice.demo.Service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    
    @Autowired
    PaymentService paymentService;

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponse> getPaymentById(@PathVariable Long id){

        //map incoming data to inteerrnal requests DTO
        PaymentRequest internalRequestObj = new PaymentRequest();
        internalRequestObj.setPaymentId(id);

        //pass this internal RequestObj
        PaymentResponse payment = paymentService.getPaymentDetailsById(internalRequestObj);

        return ResponseEntity.ok(payment);
    }
}
