package org.jsp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.entity.Education;
import org.jsp.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EducationDao {

	@Autowired
	EducationRepository repository;

	public Education saveEducation(Education e) {
		return repository.save(e);
	}

	public List<Education> findAllEducations() {
		return repository.findAll();
	}

	public List<Education> findAllEducationByUserId(int uid) {
		return repository.findAllEducationsByUSerId(uid);
	}

	public List<Education> findAllEducationByEducationId(int eid) {
		return repository.findAllEductionByEducationId(eid);
	}

	public Optional<Education> deleteEductionByEductionId(int eid) {
		return repository.deleteEductionByEductionId(eid);
	}

	public List<Education> findEducationByUniversity(String unviersity) {
		return repository.findAllEducationsByUniversity(unviersity);
	}

	public Optional<Education> deleteEductionByYOP(int yop) {
		return repository.deleteEducationByYOP(yop);
	}

	public Optional<Education> findUserEducationSummary(int uid) {
		return repository.findUsereducationSummary(uid);
	}

}