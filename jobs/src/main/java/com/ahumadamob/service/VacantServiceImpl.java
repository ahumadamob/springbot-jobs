package com.ahumadamob.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ahumadamob.model.Vacant;

@Service
public class VacantServiceImpl implements IVacantService {
	
	private List<Vacant> vacants = null;
	
	public VacantServiceImpl() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		vacants = new LinkedList<Vacant>();
		
		try {
			// Creamos la oferta de trabajo 1
			Vacant vacant1 = new Vacant();
			vacant1.setId(1);
			vacant1.setName("Ingeniero Civil");
			vacant1.setDescription("Se solicita Ing. Civil para diseñar puente peatonal");
			vacant1.setPostDate(sdf.parse("15-12-2020"));
			vacant1.setSalary(8400.0);
			vacant1.setHighlight(1);
			
			
			// Creamos la oferta de trabajo 2
			Vacant vacant2 = new Vacant();
			vacant2.setId(2);
			vacant2.setName("Arquero");
			vacant2.setDescription("Solicitamos arquero que no se coma goles como Armani");
			vacant2.setPostDate(sdf.parse("03-01-2021"));
			vacant2.setSalary(7500000.0);	
			vacant2.setHighlight(0);
			
			// Creamos la oferta de trabajo 2
			Vacant vacant3 = new Vacant();
			vacant3.setId(3);
			vacant3.setName("Lateral Izquierdo");
			vacant3.setDescription("Solicitamos marcador de punta izquierdo que juegue además como win y recorte para adentro");
			vacant3.setPostDate(sdf.parse("05-01-2021"));
			vacant3.setSalary(17500000.0);
			vacant3.setHighlight(0);
			vacant3.setImage("river.png");
			
			// Creamos la oferta de trabajo 4
			Vacant vacant4 = new Vacant();
			vacant4.setId(4);
			vacant4.setName("Delantero nivel Dios");
			vacant4.setDescription("Solicitamos delantero que le haga tres goles o más al Palmeiras");
			vacant4.setPostDate(sdf.parse("08-01-2021"));
			vacant4.setSalary(57500000.0);
			vacant4.setHighlight(1);
			vacant4.setImage("river.png");
			
			vacants.add(vacant1);
			vacants.add(vacant2);
			vacants.add(vacant3);
			vacants.add(vacant4);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error:" + e.getMessage());
		}	
		
	}
	
	@Override
	public List<Vacant> fetchAll() {		
		return vacants;
	}

	@Override
	public Vacant fetchById(Integer idVacant) {
		for(Vacant vacant : vacants) {
			if(vacant.getId() == idVacant) {
				return vacant;
			}
		}
		return null;
	}

}
