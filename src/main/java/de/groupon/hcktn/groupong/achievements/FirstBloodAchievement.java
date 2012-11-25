package de.groupon.hcktn.groupong.achievements;

import de.groupon.hcktn.groupong.domain.response.MatchDTO;
import de.groupon.hcktn.groupong.model.dao.MatchDAO;
import de.groupon.hcktn.groupong.model.entity.Match;
import de.groupon.hcktn.groupong.model.entity.User;
import de.groupon.hcktn.groupong.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("firstBloodAchievement")
public class FirstBloodAchievement implements Achievement {

    @Autowired
    private MatchService matchService;

    @Autowired
    private MatchDAO matchDAO;

    @Override
    public Integer getId() {
        return 1;
    }

    @Override
    public Boolean isAchieved(User user, Match match) {
        List<MatchDTO> oldMatches = matchService.fetchMatchesByUserIdStatusId(user.getId(), 6);

        if (oldMatches == null || oldMatches.isEmpty()) {
            return true;
        }

        return false;
    }

}
