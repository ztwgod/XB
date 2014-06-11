package cn.com.xb.daox;

import cn.com.xb.domain.base.StoragestationModel;

public interface IStoragestationModelDaox {

	public StoragestationModel getStoragestationModelByCode(String moduleCode) throws Exception;
}
