package com.example.Controller;

import com.example.Domain.Hotel;
import com.example.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * ホテルに関するHTTPリクエストを処理するコントローラー.
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {

    //soringがhotelServiceのインスタンスを自動的に割り当てます。
    @Autowired
    private HotelService hotelService;

    /**
     * ホテルを表示します.
     *
     * @param model コントローラーからビューへデータを渡すためのオブジェクト
     * @return 表示するビューの名前
     */
    @GetMapping("/searchAll")
    public String searchALL(Model model){
        List<Hotel> hotelList = hotelService.searchAll();
        model.addAttribute("hotellist", hotelList);
        return "";
    }

    /**
     * 指定された値段以下のホテル情報画面を表示します.
     *
     * @param model コントローラーからビューへデータを渡すためのオブジェクト
     * @param price ホテルの値段
     * @return 表示するビューの名前
     */
    @GetMapping("/search-less-than-price")
    public String searchByLessThanPrice(Model model, Integer price){
        //サービスから指定された値段以下のホテル情報を取得します。
        Hotel hotel = hotelService.searchByLessThanPrice(price);
        //見つかったホテル情報を"hotel"という名前でモデルに追加します。
        model.addAttribute("hotel", hotel);
        //表示するビューの名前
        return "";
    }
}
