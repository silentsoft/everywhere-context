package org.silentsoft.everywhere.context.fx.main.vo;

import java.util.List;

public class MainSVO {
	
	private NoticeInDVO noticeInDVO;

	private List<NoticeOutDVO> noticeOutDVOList;
	
	private CloudDirectoryInDVO cloudDirectoryInDVO;
	
	private List<CloudDirectoryOutDVO> cloudDirectoryOutDVOList;

	public NoticeInDVO getNoticeInDVO() {
		return noticeInDVO;
	}

	public void setNoticeInDVO(NoticeInDVO noticeInDVO) {
		this.noticeInDVO = noticeInDVO;
	}

	public List<NoticeOutDVO> getNoticeOutDVOList() {
		return noticeOutDVOList;
	}

	public void setNoticeOutDVOList(List<NoticeOutDVO> noticeOutDVOList) {
		this.noticeOutDVOList = noticeOutDVOList;
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
