package org.silentsoft.everywhere.context.fx.update.vo;

public class UpdateOutDVO {

	private String buildVersion;
	
	private String buildTime;
	
	private String targetIp;
	
	private String deployFileTag;
	
	private String deployType;
	
	private String includeJreYn;

	public String getBuildVersion() {
		return buildVersion;
	}

	public void setBuildVersion(String buildVersion) {
		this.buildVersion = buildVersion;
	}

	public String getBuildTime() {
		return buildTime;
	}

	public void setBuildTime(String buildTime) {
		this.buildTime = buildTime;
	}

	public String getTargetIp() {
		return targetIp;
	}

	public void setTargetIp(String targetIp) {
		this.targetIp = targetIp;
	}

	public String getDeployFileTag() {
		return deployFileTag;
	}

	public void setDeployFileTag(String deployFileTag) {
		this.deployFileTag = deployFileTag;
	}

	public String getDeployType() {
		return deployType;
	}

	public void setDeployType(String deployType) {
		this.deployType = deployType;
	}

	public String getIncludeJreYn() {
		return includeJreYn;
	}

	public void setIncludeJreYn(String includeJreYn) {
		this.includeJreYn = includeJreYn;
	}
	
}
