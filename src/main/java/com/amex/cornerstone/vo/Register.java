package com.amex.cornerstone.vo;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;


@Service
public class Register {
		/**
		 * "trsf_name": "unique name for this tool",
	"trsf_id": 123, 
	"trsf_desc": "�",
		 */
	
	/**
	 * {
    "trsf_name": "unique name for this tool",
    "trsf_id": 123,
    "trsf_desc": "�",
    "trsf_info": {
        "src_name": "datameer",
        "src_id": "f15837b7-ad26-4ef5-9216-d31a48ce1a9f",
        "version": "5.7.0",
        "business_unit": "datameer",
        "business_owner_id": "wz1234",
        "business_purpose": "marketing",
        "data_interaction": "no",
        "reg_compliance": "yes",
        "status": "initial",
        "notification": "jhon@yahoo.com",
        "notification_on_success": "jhon@yahoo.com"
    }
}
	 */
	private String trsf_name;
	
	private int trsf_id;
	private String trsf_desc;
	private TransInfo trsf_info;
	
	
	public String getTrsf_name() {
			return trsf_name;
		}
		public void setTrsf_name(String trsf_name) {
			this.trsf_name = trsf_name;
		}
		public int getTrsf_id() {
			return trsf_id;
		}
		public void setTrsf_id(int trsf_id) {
			this.trsf_id = trsf_id;
		}
		public String getTrsf_desc() {
			return trsf_desc;
		}
		public void setTrsf_desc(String trsf_desc) {
			this.trsf_desc = trsf_desc;
		}
		public TransInfo getTrsf_info() {
			return trsf_info;
		}
		public void setTrsf_info(TransInfo trsf_info) {
			this.trsf_info = trsf_info;
		}
		@Override
		public String toString() {
			return "sampleVO [trsf_name=" + trsf_name + ", trsf_id=" + trsf_id
					+ ", trsf_desc=" + trsf_desc + ", trsf_info=" + trsf_info.toString()
					+ "]";
		}
		
		
	
}
