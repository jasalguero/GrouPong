package de.groupon.hcktn.groupong.model.dao;

import de.groupon.hcktn.groupong.model.entity.Match;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 11/24/12
 * Time: 11:34 AM
 * To change this template use File | Settings | File Templates.
 */
public interface MatchDAO {
    public void createMatch(final Match match);
    public Match readMatch(final Integer matchId);
    public List<Match> readAllMatches();
    public void deleteMatch(final Integer matchId);
    public void updateMatch(final Match match);
}
