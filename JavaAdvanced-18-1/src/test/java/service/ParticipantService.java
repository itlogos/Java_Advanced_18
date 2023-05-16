package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ParticipantRepository;
import domain.Participant;

@Service
public class ParticipantService {

	@Autowired
	private ParticipantRepository participantRepository;

	public List<Participant> findAllParticipant() {
		return participantRepository.findAllParticipant();
	}

	public Participant findOne(int id) {
		return participantRepository.findOne(id);
	}

	public void save(Participant participant) {
		participantRepository.save(participant);
	}

	public void delete(int id) {
		participantRepository.delete(id);
	}
}
