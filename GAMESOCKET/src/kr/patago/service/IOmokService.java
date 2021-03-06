package kr.patago.service;

import java.util.List;

import kr.patago.vo.OmokVO;

public interface IOmokService {
	public int insert(OmokVO mv);
	
	public List<OmokVO> selectList();
	
	public OmokVO selectMax();
	
	public List<OmokVO> selectListPan();
	
	public List<OmokVO> selectListPans(OmokVO vo);
	
	public List<OmokVO> selectListHist(OmokVO vo);

	public List<OmokVO> selectListNext2(OmokVO vo);
}
