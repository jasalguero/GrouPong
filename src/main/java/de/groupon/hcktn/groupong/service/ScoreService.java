package de.groupon.hcktn.groupong.service;

import de.groupon.hcktn.groupong.domain.response.MatchDTO;
import de.groupon.hcktn.groupong.model.entity.Match;

public interface ScoreService {

    void score(Match match, MatchDTO matchDTO);
}
