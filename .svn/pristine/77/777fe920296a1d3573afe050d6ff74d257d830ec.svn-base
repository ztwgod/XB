package cn.com.xb.service.impl;

import java.util.List;

import cn.com.xb.daox.IFlagDictionaryDaox;
import cn.com.xb.domain.base.FlagDictionary;
import cn.com.xb.service.FlagDictionaryService;

public class FlagDictionaryServiceImpl implements FlagDictionaryService {
	
	private IFlagDictionaryDaox flagDictionaryDaox;

	public void setFlagDictionaryDaox(IFlagDictionaryDaox flagDictionaryDaox) {
		this.flagDictionaryDaox = flagDictionaryDaox;
	}


	public List<FlagDictionary> loadDictionaryByTypeIdAndStauts(String typeId,int status)throws Exception {
		return flagDictionaryDaox.loadDictionaryByTypeIdAndStauts(typeId,status);
	}


	public List<FlagDictionary> loadDictionaryByTypeId(String typeId)throws Exception{
		return flagDictionaryDaox.loadDictionaryByTypeId(typeId);
	}

}
