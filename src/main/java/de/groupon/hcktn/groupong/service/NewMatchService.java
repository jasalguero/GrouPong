package de.groupon.hcktn.groupong.service;

import de.groupon.hcktn.groupong.domain.response.MatchDTO;

import java.util.Set;

public interface NewMatchService {

    Set<MatchDTO> fetchNewMatches(Integer userId);

    void putNewMatch(Integer userId, MatchDTO matchDTO);

}
