package org.silentsoft.everywhere.context.fx.update.vo;

import java.util.List;

public class UpdateSVO {

	private UpdateInDVO updateInDVO;
	
	private List<UpdateOutDVO> updateOutDVOList;

	public UpdateInDVO getUpdateInDVO() {
		return updateInDVO;
	}

	public void setUpdateInDVO(UpdateInDVO updateInDVO) {
		this.updateInDVO = updateInDVO;
	}

	public List<UpdateOutDVO> getUpdateOutDVOList() {
		return updateOutDVOList;
	}

	public void setUpdateOutDVOList(List<UpdateOutDVO> updateOutDVOList) {
		this.updateOutDVOList = updateOutDVOList;
	}
	
}
