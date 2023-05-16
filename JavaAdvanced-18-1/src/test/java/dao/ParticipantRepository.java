package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import domain.Participant;

@Repository
public class ParticipantRepository {

	private List<Participant> list = new ArrayList<>();

	@PostConstruct
	public void init() {
		Participant p1 = new Participant("Igor", "Igor@gmail.com", "L1", "Power");
		Participant p2 = new Participant("Natali", "Natali@gmail.com", "L3", "Knowledge");
		Participant p3 = new Participant("Taras", "Taras@gmail.com", "L5", "Speed");

		list.add(p1);
		list.add(p2);
		list.add(p3);
	}

	public List<Participant> findAllParticipant() {
		return list;
	}

	public Participant findOne(int id) {
		return list.stream().filter(participant -> participant.getId() == id).findFirst().orElse(null);
	}

	public void save(Participant participant) {
		Participant pToUpdate = null;

		if (participant.getId() != null) {
			pToUpdate = findOne(participant.getId());
			int pIndex = list.indexOf(pToUpdate);
			pToUpdate.setName(participant.getName());
			pToUpdate.setEmail(participant.getEmail());
			pToUpdate.setLevel(participant.getLevel());
			pToUpdate.setPrimarySkill(participant.getPrimarySkill());
			list.set(pIndex, pToUpdate);
		} else {
		
			participant.setId(list.size() + 1);
			list.add(participant);
		}
	}

	public void delete(int id) {
		Iterator<Participant> iter = list.iterator();
		while (iter.hasNext()) {
			if (iter.next().getId() == id) {
				iter.remove();
			}
		}
	}
}
