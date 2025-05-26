package com.example.Service;

import com.example.Domain.BaseballTeams;
import com.example.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 球団情報に関するサービスクラス.
 *
 */
@Service
@Transactional
public class TeamService {

    //teamRepositoryのインスタンスをインジェクション（注入）します
    @Autowired
    private TeamRepository teamRepository;

    /**
     *  指定されたIDに対応する球団情報を取得します.
     *
     * @param id 検索する球団のID
     * @return 該当する球団情報
     */
    public BaseballTeams findById(Integer id){
        return teamRepository.findById(id);
    }

    /**
     * すべての球団情報を発足日順（昇順）で取得します.
     *
     * @return 球団のリスト
     */
    public List<BaseballTeams> findAllOrderByInauguration(){
        return teamRepository.findAllOrderByInauguration();
    }
}
