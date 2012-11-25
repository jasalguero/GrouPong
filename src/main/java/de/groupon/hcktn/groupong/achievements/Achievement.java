package de.groupon.hcktn.groupong.achievements;

import de.groupon.hcktn.groupong.model.entity.Match;
import de.groupon.hcktn.groupong.model.entity.User;

public interface Achievement {

    Integer getId();

    Boolean isAchieved(User user, Match match);

}
