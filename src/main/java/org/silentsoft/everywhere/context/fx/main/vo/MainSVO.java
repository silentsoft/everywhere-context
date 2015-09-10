package org.silentsoft.everywhere.context.fx.main.vo;

import java.util.List;

public class MainSVO {
	
	private Notice001DVO notice001DVO;

	private List<Notice002DVO> notice002DVOList;
	
	private Cloud001DVO cloud001DVO;
	
	private List<Cloud002DVO> cloud002DVOList;
	
	private CloudDirectoryInDVO cloudDirectoryInDVO;
	
	private List<CloudDirectoryOutDVO> cloudDirectoryOutDVOList;

	public Notice001DVO getNotice001DVO() {
		return notice001DVO;
	}

	public void setNotice001DVO(Notice001DVO notice001dvo) {
		notice001DVO = notice001dvo;
	}

	public List<Notice002DVO> getNotice002DVOList() {
		return notice002DVOList;
	}

	public void setNotice002DVOList(List<Notice002DVO> notice002dvoList) {
		notice002DVOList = notice002dvoList;
	}

	public Cloud001DVO getCloud001DVO() {
		return cloud001DVO;
	}

	public void setCloud001DVO(Cloud001DVO cloud001dvo) {
		cloud001DVO = cloud001dvo;
	}

	public List<Cloud002DVO> getCloud002DVOList() {
		return cloud002DVOList;
	}

	public void setCloud002DVOList(List<Cloud002DVO> cloud002dvoList) {
		cloud002DVOList = cloud002dvoList;
	}

	public CloudDirectoryInDVO getCloudDirectoryInDVO() {
		return cloudDirectoryInDVO;
	}

	public void setCloudDirectoryInDVO(CloudDirectoryInDVO cloudDirectoryInDVO) {
		this.cloudDirectoryInDVO = cloudDirectoryInDVO;
	}

	public List<CloudDirectoryOutDVO> getCloudDirectoryOutDVOList() {
		return cloudDirectoryOutDVOList;
	}

	public void setCloudDirectoryOutDVOList(List<CloudDirectoryOutDVO> cloudDirectoryOutDVOList) {
		this.cloudDirectoryOutDVOList = cloudDirectoryOutDVOList;
	}
	
}
