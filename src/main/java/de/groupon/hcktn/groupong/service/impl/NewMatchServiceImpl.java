package de.groupon.hcktn.groupong.service.impl;

import de.groupon.hcktn.groupong.domain.response.MatchDTO;
import de.groupon.hcktn.groupong.service.NewMatchService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class NewMatchServiceImpl implements NewMatchService {

    private Map<Integer, Set<MatchDTO>> newMatchesMap = new HashMap<Integer, Set<MatchDTO>>();

    @Override
    public Set<MatchDTO> fetchNewMatches(Integer userId) {
        Set<MatchDTO> newMatches = newMatchesMap.get(userId);
        if (newMatches != null && !newMatches.isEmpty()) {
            newMatches.remove(userId);
            newMatchesMap.remove(userId);
        }
        return newMatches;
    }

    @Override
    public void putNewMatch(Integer userId, MatchDTO matchDTO) {
        Set<MatchDTO> newMatchesSet = (Set<MatchDTO>) this.newMatchesMap.get(userId);
        if (newMatchesSet == null || newMatchesSet.isEmpty()) {
            newMatchesSet = new HashSet<MatchDTO>();
        }
        newMatchesSet.add(matchDTO);
        newMatchesMap.put(userId, newMatchesSet);

    }

}
