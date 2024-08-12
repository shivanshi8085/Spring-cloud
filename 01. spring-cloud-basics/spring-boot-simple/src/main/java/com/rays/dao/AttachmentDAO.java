package com.rays.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.rays.dto.AttachmentDTO;

@Repository
public class AttachmentDAO {

	@PersistenceContext
	public EntityManager entityManager;

	public long add(AttachmentDTO dto) {
		entityManager.persist(dto);
		return dto.getId();
	}

	public void update(AttachmentDTO dto) {
		entityManager.merge(dto);
	}

	public void delete(AttachmentDTO dto) {
		entityManager.remove(dto);
	}

	public AttachmentDTO findByPk(long pk) {
		AttachmentDTO dto = entityManager.find(AttachmentDTO.class, pk);
		return dto;
	}

}
