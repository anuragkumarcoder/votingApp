package com.votingApplication.votingApp.service;

import com.votingApplication.votingApp.Model.Poll;
import com.votingApplication.votingApp.Repository.PollRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PollService {
    private final PollRepo pollRepo;
    public Poll createPoll(Poll poll) {
        return pollRepo.save(poll);
    }
}
