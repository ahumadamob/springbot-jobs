package com.ahumadamob.service;

import java.util.List;

import com.ahumadamob.model.Vacant;

public interface IVacantService {
	List<Vacant> fetchAll();
	Vacant fetchById(Integer idVacant);
}
