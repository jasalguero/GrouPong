package de.groupon.hcktn.groupong.service;

import de.groupon.hcktn.groupong.domain.response.BaseDTO;
import de.groupon.hcktn.groupong.domain.response.MatchDTO;

import java.util.List;

public interface MatchService {

    BaseDTO createMatch(MatchDTO match);

    BaseDTO updateMatch(MatchDTO match);

    List<MatchDTO> fetchMatches();

    List<MatchDTO> fetchMatchesByUserId(Integer userId);

    List<MatchDTO> fetchMatchesByStatusId(Integer statusId);

    List<MatchDTO> fetchMatchesByUserIdStatusId(Integer userId, Integer statusId);

}
