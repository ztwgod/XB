package cn.com.xb.service.impl;

import cn.com.xb.dao.IStoragestationIntfLogDao;
import cn.com.xb.domain.base.StoragestationIntfLog;
import cn.com.xb.service.InterfaceLogService;
import cn.com.xb.util.Global;

/**
 * 操作日志管理
 * @author DiGua
 *
 */
public class InterfaceLogServiceImpl implements InterfaceLogService
{
	private IStoragestationIntfLogDao silDao;
	
	public void setSilDao(IStoragestationIntfLogDao silDao)
	{
		this.silDao = silDao;
	}



	@Override
	public void addInterfaceLogInfo(String applyCode, int upDown, StoragestationIntfLog sil) throws Exception
	{
		if(sil != null)
		{
			sil.setIntfId(getIntfIdByApplyCodeAndUpDown(applyCode, upDown));
			
			silDao.insert(sil);
		}
	}

	/**
	 * 根据接口Code和上下行获取接口信息ID
	 * @param applyCode
	 * @param upDown
	 * @return
	 */
	public String getIntfIdByApplyCodeAndUpDown(String applyCode, int upDown)
	{
		String intfId = null;
		
		if(Global.XB_001.equals(applyCode))
		{
			if(upDown == Global.INTF_UP)
			{
				intfId = "1";
			} 
			else if (upDown == Global.INTF_DOWN)
			{
				intfId = "2";
			}
		}
		else if(Global.XB_002.equals(applyCode))
		{
			if(upDown == Global.INTF_UP)
			{
				intfId = "3";
			} 
			else if (upDown == Global.INTF_DOWN)
			{
				intfId = "4";
			}
		}
		else if(Global.XB_003.equals(applyCode))
		{
			if(upDown == Global.INTF_UP)
			{
				intfId = "5";
			} 
			else if (upDown == Global.INTF_DOWN)
			{
				intfId = "6";
			}
		}
		else if(Global.XB_004.equals(applyCode))
		{
			if(upDown == Global.INTF_UP)
			{
				intfId = "7";
			} 
			else if (upDown == Global.INTF_DOWN)
			{
				intfId = "8";
			}
		}
		else if(Global.XB_005.equals(applyCode))
		{
			if(upDown == Global.INTF_UP)
			{
				intfId = "9";
			} 
			else if (upDown == Global.INTF_DOWN)
			{
				intfId = "10";
			}
		}
		else if(Global.XB_006.equals(applyCode))
		{
			if(upDown == Global.INTF_UP)
			{
				intfId = "11";
			} 
			else if (upDown == Global.INTF_DOWN)
			{
				intfId = "12";
			}
		}
		else if(Global.XB_007.equals(applyCode))
		{
			if(upDown == Global.INTF_UP)
			{
				intfId = "13";
			} 
			else if (upDown == Global.INTF_DOWN)
			{
				intfId = "14";
			}
		}
		else if(Global.XB_008.equals(applyCode))
		{
			if(upDown == Global.INTF_UP)
			{
				intfId = "15";
			} 
			else if (upDown == Global.INTF_DOWN)
			{
				intfId = "16";
			}
		}
		else if(Global.XB_009.equals(applyCode))
		{
			if(upDown == Global.INTF_UP)
			{
				intfId = "17";
			} 
			else if (upDown == Global.INTF_DOWN)
			{
				intfId = "18";
			}
		}
		else if(Global.XB_010.equals(applyCode))
		{
			if(upDown == Global.INTF_UP)
			{
				intfId = "19";
			} 
			else if (upDown == Global.INTF_DOWN)
			{
				intfId = "20";
			}
		}
		else if(Global.XB_011.equals(applyCode))
		{
			if(upDown == Global.INTF_UP)
			{
				intfId = "21";
			} 
			else if (upDown == Global.INTF_DOWN)
			{
				intfId = "22";
			}
		}
		else if(Global.XB_012.equals(applyCode))
		{
			if(upDown == Global.INTF_UP)
			{
				intfId = "23";
			} 
			else if (upDown == Global.INTF_DOWN)
			{
				intfId = "24";
			}
		}
		else if(Global.XB_013.equals(applyCode))
		{
			if(upDown == Global.INTF_UP)
			{
				intfId = "25";
			} 
			else if (upDown == Global.INTF_DOWN)
			{
				intfId = "26";
			}
		}
		else if(Global.XB_014.equals(applyCode))
		{
			if(upDown == Global.INTF_UP)
			{
				intfId = "27";
			} 
			else if (upDown == Global.INTF_DOWN)
			{
				intfId = "28";
			}
		}
		else if(Global.XB_015.equals(applyCode))
		{
			if(upDown == Global.INTF_UP)
			{
				intfId = "29";
			} 
			else if (upDown == Global.INTF_DOWN)
			{
				intfId = "30";
			}
		}
		else if(Global.XB_GUI.equals(applyCode))
		{
			if(upDown == Global.INTF_UP)
			{
			} 
			else if (upDown == Global.INTF_DOWN)
			{
				intfId = "31";
			}
		}
		else if(Global.XB_APP.equals(applyCode))
		{
			if(upDown == Global.INTF_UP)
			{
			} 
			else if (upDown == Global.INTF_DOWN)
			{
				intfId = "32";
			}
		}
		
		return intfId;
	}
}
