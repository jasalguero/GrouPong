package de.groupon.hcktn.groupong.service.impl;

import de.groupon.hcktn.groupong.domain.exception.NotFoundException;
import de.groupon.hcktn.groupong.domain.mappers.MatchDTOMapper;
import de.groupon.hcktn.groupong.domain.response.BaseDTO;
import de.groupon.hcktn.groupong.domain.response.MatchDTO;
import de.groupon.hcktn.groupong.model.dao.MatchDAO;
import de.groupon.hcktn.groupong.model.entity.Match;
import de.groupon.hcktn.groupong.service.MatchService;
import de.groupon.hcktn.groupong.service.ScoreService;
import de.groupon.hcktn.groupong.service.UserAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchDAO matchDAO;

    @Autowired
    private MatchDTOMapper matchDTOMapper;

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private UserAchievementService userAchievementService;

    @Override
    public BaseDTO createMatch(final MatchDTO matchDTO) {
        matchDTO.setId(null);
        matchDTO.setStatusId(1);
        Match match = matchDTOMapper.mapToMatch(matchDTO);
        match = matchDAO.create(match);
        return matchDTOMapper.mapToMatchDTO(match);
    }

    @Override
    public BaseDTO updateMatch(final MatchDTO matchDTO) {
        Match match = matchDAO.retrieve(matchDTO.getId());
        if (match == null) {
            throw new NotFoundException("Match found with id: " + matchDTO.getId() + " not found");
        }

        scoreService.score(match, matchDTO);
        userAchievementService.processUserAchievements(match, matchDTO);

        match = matchDTOMapper.update(match, matchDTO);
        match = matchDAO.update(match);

        return matchDTOMapper.mapToMatchDTO(match);
    }

    @Override
    public List<MatchDTO> fetchMatches() {
        final List<MatchDTO> matchesDTO = new ArrayList<MatchDTO>();
        final List<Match> matches = matchDAO.retrieveAll();
        for (Match match : matches) {
            matchesDTO.add(matchDTOMapper.mapToMatchDTO(match));
        }
        return matchesDTO;
    }

    @Override
    public List<MatchDTO> fetchMatchesByUserId(final Integer userId) {
        final List<MatchDTO> matchesDTO = new ArrayList<MatchDTO>();
        final List<Match> matches = matchDAO.retrieveAll();
        for (Match match : matches) {
            if (match.getUser1Id().equals(userId) || match.getUser2Id().equals(userId)) {
                matchesDTO.add(matchDTOMapper.mapToMatchDTO(match));
            }
        }
        return matchesDTO;
    }

    @Override
    public List<MatchDTO> fetchMatchesByStatusId(final Integer statusId) {
        final List<MatchDTO> matchesDTO = new ArrayList<MatchDTO>();
        final List<Match> matches = matchDAO.retrieveAll();
        for (Match match : matches) {
            if (match.getStatusId().equals(statusId)) {
                matchesDTO.add(matchDTOMapper.mapToMatchDTO(match));
            }
        }
        return matchesDTO;
    }

    @Override
    public List<MatchDTO> fetchMatchesByUserIdStatusId(final Integer userId, final Integer statusId) {
        final List<MatchDTO> matchesDTO = new ArrayList<MatchDTO>();
        final List<Match> matches = matchDAO.retrieveAll();
        for (Match match : matches) {
            if (match.getStatusId().equals(statusId) && ( (match.getUser1Id().equals(userId) || match.getUser2Id().equals(userId)) )) {
                matchesDTO.add(matchDTOMapper.mapToMatchDTO(match));
            }
        }
        return matchesDTO;
    }

}
