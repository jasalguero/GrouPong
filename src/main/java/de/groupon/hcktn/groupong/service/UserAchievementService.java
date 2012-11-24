package de.groupon.hcktn.groupong.service;

import java.util.List;

public interface UserAchievementService {

    List<Integer> fetchUserAchievementsByUserId(Integer userId);

}
