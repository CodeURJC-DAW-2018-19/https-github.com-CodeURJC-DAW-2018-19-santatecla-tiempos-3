package es.urjc.daw.app.interval;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntervalService {
	@Autowired
    private IntervalRepository repository;
	
	public Interval findOne(Long id) {
        return repository.getOne(id);
    }
	
	public Interval findOneByName(String name) {
		return repository.findByName(name);
	}
	public List<Interval> findAll() {
        return repository.findAll();
    }

    public void save(Interval interval) {
        repository.save(interval);
    }

    public void delete(long idInterval) {
        repository.deleteById(idInterval);
    }
}
