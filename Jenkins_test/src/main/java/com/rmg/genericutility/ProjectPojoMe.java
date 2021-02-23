package com.rmg.genericutility;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
@JsonPropertyOrder(value= {"createdby","createdon","projid","projname","status","size"})
public class ProjectPojoMe 
{
	@JsonProperty("createdby")
	String createdby;
	@JsonProperty("createdon")
	String createdon;
	@JsonProperty("projid")
	String projid;
	@JsonProperty("projname")
	String projname;
	@JsonProperty("status")
	String status;
	@JsonProperty("size")
	int size;
	public ProjectPojoMe(String createdby, String createdon, String projid, String projname, String status, int size) {
		super();
		this.createdby = createdby;
		this.createdon = createdon;
		this.projid = projid;
		this.projname = projname;
		this.status = status;
		this.size = size;
	}
	
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public String getCreatedon() {
		return createdon;
	}
	public void setCreatedon(String createdon) {
		this.createdon = createdon;
	}
	public String getProjid() {
		return projid;
	}
	public void setProjid(String projid) {
		this.projid = projid;
	}
	public String getProjname() {
		return projname;
	}
	public void setProjname(String projname) {
		this.projname = projname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}
