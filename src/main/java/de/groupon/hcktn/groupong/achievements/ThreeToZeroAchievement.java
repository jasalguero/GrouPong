package de.groupon.hcktn.groupong.achievements;

import de.groupon.hcktn.groupong.model.entity.Match;
import de.groupon.hcktn.groupong.model.entity.User;
import org.springframework.stereotype.Component;

@Component("threeToZeroAchievement")
public class ThreeToZeroAchievement implements Achievement {

    @Override
    public Integer getId() {
        return 2;
    }

    @Override
    public Boolean isAchieved(User user, Match match) {
        Integer scoreUser = match.getUser1Id() == user.getId() ? match.getScoreUser1() : match.getScoreUser2();
        Integer scoreOponent = match.getUser1Id() == user.getId() ? match.getScoreUser2() : match.getScoreUser1();
        if (scoreUser != null && scoreUser == 3 && scoreOponent != null && scoreOponent == 0) {
            return true;
        }
        return false;
    }
}
