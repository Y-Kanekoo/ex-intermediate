package com.example.Controller;

import com.example.Domain.BaseballTeams;
import com.example.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 球団情報に関するHTTPリクエストを処理するコントローラーです.
 *
 */
@Controller
@RequestMapping("/baseball-team")
public class BaseballTeamController {

    //springがteamServiceのインスタンスを自動的に割り当てます。
    @Autowired
    private TeamService teamService;

    /**
     * 球団一覧画面を表示します.
     *
     * @param model コントローラーからビューへデータを渡すためのオブジェクト
     * @return 表示するためビューの名前
     */
    @GetMapping("show-list")
    public String showList(Model model){
        //サービスを通じて全部の球団のリストを発足日順に取得します。
        List<BaseballTeams> baseballTeamsList = teamService.findAllOrderByInauguration();
        //取得するリストを"baseballTeamList"という名前でモデルに追加します。
        model.addAttribute("baseballTeamList", baseballTeamsList);
        //表示するビューの名前を返します。
        return "teams";
    }

    /**
     * 指定されたIDの球団詳細情報画面を表示します.
     *
     * @param id 球団ID
     * @param model コントローラーからビューへデータを渡すためのオブジェクト
     * @return 表示するビューの名前
     */
    @GetMapping("show-detail")
    public String showDetail(Integer id, Model model){
        // サービスを通じて指定されたIDの球団情報を取得します。
        BaseballTeams baseballTeams = teamService.findById(id);
        // 見つかった球団情報を "baseballTeams" という名前でモデルに追加します。
        model.addAttribute("baseballTeams", baseballTeams);
        //表示するビュー
        return "team_detail";
    }

}
