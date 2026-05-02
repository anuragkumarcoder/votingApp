package com.votingApplication.votingApp.service;

import com.votingApplication.votingApp.Model.OptionVote;
import com.votingApplication.votingApp.Model.Poll;
import com.votingApplication.votingApp.Repository.PollRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PollService {
    private final PollRepo pollRepo;
    public Poll createPoll(Poll poll) {
        return pollRepo.save(poll);
    }

    public List<Poll> getAllPolls() {
        return pollRepo.findAll();
    }

    public Optional<Poll> getPollById(Long id) {
        return pollRepo.findById(id);
    }

    public void vote(Long pollId, int optionIndex) {
        Poll poll=pollRepo.findById(pollId)
                .orElseThrow(()->new RuntimeException("poll not found"));
        List<OptionVote> options=poll.getOptions();
        if(optionIndex<0 || optionIndex>=options.size()){
            throw new IllegalArgumentException("invalid option index");
        }
        OptionVote selectedOption=options.get(optionIndex);
        selectedOption.setVoteCount(selectedOption.getVoteCount()+1);
        pollRepo.save(poll);


    }
}
