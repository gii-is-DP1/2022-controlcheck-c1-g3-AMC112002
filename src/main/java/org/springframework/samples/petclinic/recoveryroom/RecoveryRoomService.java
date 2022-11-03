package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RecoveryRoomService {
	
	private RecoveryRoomRepository repo;
	
	public RecoveryRoomService(RecoveryRoomRepository repo) {
		this.repo = repo;
	}
	
    public List<RecoveryRoom> getAll(){
        return repo.findAll();
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return repo.findAllRecoveryRoomTypes();
    }

    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return repo.getRecoveryRoomType(typeName);
    }

//    public RecoveryRoom save(RecoveryRoom p) throws DuplicatedRoomNameException {
//        return repo.save(p);       
//    }
    
    public RecoveryRoom save(RecoveryRoom p) {
    	return repo.save(p);       
    }


    
}
