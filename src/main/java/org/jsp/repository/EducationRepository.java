package org.jsp.repository;

import java.util.List;
import java.util.Optional;

import org.jsp.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EducationRepository extends JpaRepository<Education, Integer> {

	@Query("Select e from Education e where e.user.id=?1")
	List<Education> findAllEducationsByUSerId(int uid);

	@Query("Select e from Eduction e where e.education.id=?1")
	List<Education> findAllEductionByEducationId(int eid);

	@Query("Select e from Eduction e Where e.eduction.id=?1")
	Optional<Education> deleteEductionByEductionId(int eid);

	@Query("Select e from Education e Where e.education.university=?1")
	List<Education> findAllEducationsByUniversity(String unviersity);

	@Query("Select e from Education e where e.education.yop=?1")
	Optional<Education> deleteEducationByYOP(int yop);

	@Query("Select e from Education e Where e.education.summary=?1")
	Optional<Education> findUsereducationSummary(int uid);

}