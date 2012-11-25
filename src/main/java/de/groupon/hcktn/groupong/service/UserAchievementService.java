package de.groupon.hcktn.groupong.service;

import de.groupon.hcktn.groupong.domain.response.MatchDTO;
import de.groupon.hcktn.groupong.model.entity.Match;

import java.util.List;

public interface UserAchievementService {

    List<Integer> fetchUserAchievementsByUserId(Integer userId);

    void processUserAchievements(Match match, MatchDTO matchDTO);

}
