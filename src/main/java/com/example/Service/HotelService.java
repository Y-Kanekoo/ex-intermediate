package com.example.Service;

import com.example.Domain.Hotel;
import com.example.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ホテルに関するサービスクラス.
 */
@Service
@Transactional
public class HotelService {

    //hotelRepositoryのインスタンスをインジェクション（注入）します
    @Autowired
    private HotelRepository hotelRepository;

    /**
     * 指定された値段以下のホテル情報を取得します.
     *
     * @param price ホテルの値段
     * @return 該当するホテル情報
     */
    public Hotel searchByLessThanPrice(Integer price){
        return hotelRepository.findByPrice(price);
    }

    /**
     * すべてのホテル情報を値段順で取得します。
     *
     * @return ホテルのリスト
     */
    public List<Hotel> searchAll(){
        return hotelRepository.findAll();
    }
}
