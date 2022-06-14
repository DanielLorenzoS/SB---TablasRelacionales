package com.clientes.test.services;

import com.clientes.test.models.Factura;
import com.clientes.test.repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Ventas {

    @Autowired
    FacturaRepository facturaRepository;

    public Factura guardarFactura(Factura factura){
        return facturaRepository.save(factura);
    }

    public ArrayList<Factura> findFacturas(){
        return (ArrayList<Factura>) facturaRepository.findAll();
    }
    public boolean deleteById(Long id) {
        try {
            facturaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
