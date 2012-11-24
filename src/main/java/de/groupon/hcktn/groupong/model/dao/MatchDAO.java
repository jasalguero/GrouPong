package de.groupon.hcktn.groupong.model.dao;

import de.groupon.hcktn.groupong.model.entity.Match;

import java.util.List;

public interface MatchDAO {
    public void createMatch(final Match match);
    public Match readMatch(final Integer matchId);
    public List<Match> readAllMatches();
    public void deleteMatch(final Integer matchId);
    public void updateMatch(final Match match);
}
