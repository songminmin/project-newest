package org.song.mongo.repository;

import java.util.List;

import org.song.common.mongo.entity.MUser;
import org.song.common.mongo.entity.TriggerItemRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.WriteResult;

@Repository
public class MongoTemplateRepository {
	
	@Autowired
	MongoTemplate mongoTemplate;

	public List<MUser> searchAllUser() {
		return mongoTemplate.find(new Query(), MUser.class);
	}

	public void testupdate(){
		Criteria c = Criteria.where("dataItemId").is("5a30f6d31ededfc95843c3d2");
		c.and("nextDataItemId").exists(false);
		Query query=new Query(c);
		Update update = new Update();
		update.set("nextDataItemId", "111");
		WriteResult writeR = mongoTemplate.updateMulti(query, update, TriggerItemRecord.class);
		System.out.println(writeR.toString());
		System.out.println(writeR.getN());
	}
	
}
