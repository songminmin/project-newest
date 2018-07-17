package org.song.common.mongo.entity;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author songmm
 *
 */
@Document
public class TriggerItemRecord {

	@Id
	private String dataItemId;
	
	private String nextDataItemId;
	
	@Indexed
	private Long triggerId;
	
	private Map<String, ?> custData;

	private Map<String, ?> maskingCustData;

	@Indexed(direction = IndexDirection.DESCENDING)
	private Long createTime;
	
	@Indexed
	private String reqId;
	
	public TriggerItemRecord() {
		
	}

	public String getDataItemId() {
		return dataItemId;
	}

	public void setDataItemId(String dataItemId) {
		this.dataItemId = dataItemId;
	}

	public String getNextDataItemId() {
		return nextDataItemId;
	}

	public void setNextDataItemId(String nextDataItemId) {
		this.nextDataItemId = nextDataItemId;
	}

	public Long getTriggerId() {
		return triggerId;
	}

	public void setTriggerId(Long triggerId) {
		this.triggerId = triggerId;
	}

	public Map<String, ?> getCustData() {
		return custData;
	}

	public void setCustData(Map<String, ?> custData) {
		this.custData = custData;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Map<String, ?> getMaskingCustData() {
		return maskingCustData;
	}

	public void setMaskingCustData(Map<String, ?> maskingCustData) {
		this.maskingCustData = maskingCustData;
	}

	public String getReqId() {
		return reqId;
	}

	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
	
}
