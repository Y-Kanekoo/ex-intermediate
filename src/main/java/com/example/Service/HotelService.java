package com.example.Service;

import com.example.Domain.Hotel;
import com.example.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    /**
     *
     * @param price
     * @return
     */
    public Hotel findByPrice(Integer price){
        return hotelRepository.findByPrice(price);
    }

    /**
     *
     * @return
     */
    public List<Hotel> findAll(){
        return hotelRepository.findAll();
    }
}
