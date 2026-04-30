package com.votingApplication.votingApp.Repository;

import com.votingApplication.votingApp.Model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepo extends JpaRepository<Poll,Long> {
}
