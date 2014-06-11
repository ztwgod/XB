package cn.com.xb.util.box;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.com.xb.domain.base.BoxInfo;
import cn.com.xb.domain.base.Cabinet;
import cn.com.xb.domain.base.Storagestation;
import cn.com.xb.http.comet.TomcatHttpServlet;
import cn.com.xb.util.StringUtil;

public class WriterBox {

	/**
	 * 根据物箱信息画出物箱GUI界面
	 */

	public String writer(List<Cabinet> cabinetList,Storagestation storagestation,Map<String, BoxInfo> boxMap) throws Exception {
		int mainBoxIndex = storagestation.getControlCabinetLocation(); // 主控柜子所在位置
		String ssCode = storagestation.getSsCode();
		Map<String, Object> root = new HashMap<String, Object>();
		String context = new FreemarkerUtil().getContext(root,"V100R001C00.ftl");
		StringBuffer buffer = new StringBuffer();
		
		for (int i = 0; i < cabinetList.size(); i++) {
			Cabinet cabinet = cabinetList.get(i);
			int sIndex = 0;
			int cabIndex = Integer.parseInt(cabinet.getCabinetIndex());
			if (cabIndex < mainBoxIndex) {
				sIndex = cabIndex;
				String tableText = this.parserHtml(context,sIndex,ssCode,cabinet.getCabinetIndex(),boxMap);
				buffer.append(tableText);
				
				//判断该柜子是否为主控柜前一个柜子
				if(cabIndex+1==mainBoxIndex){
					String mainBox = this.initMainBox(ssCode,storagestation.getRunStatus());
					buffer.append(mainBox);
				}
			} else {
				sIndex = cabIndex - 1;
				String tableText = this.parserHtml(context,sIndex,ssCode,cabinet.getCabinetIndex(),boxMap);
				buffer.append(tableText);
			}
		}
		return buffer.toString();
	}
	
	/**
	 * 主控柜
	 */
	public String initMainBox(String ssCode,int runStatus) throws Exception{
		//System.out.println("runStatus===>"+runStatus);
		//先判断物箱是否断链
		String className = "";
		if(TomcatHttpServlet.isContainsConnection(ssCode)){
			if(runStatus==1){ //正常
				className = "_main-normal";
			}else if(runStatus==5){ //故障
				className = "_main-error";
			}
		}else{//断链
			className = "_main-close";
		}
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("className", className);
		String context = new FreemarkerUtil().getContext(root,"BOX_MAIN.ftl");
		return context;
	}

	
	/**
	 * 获取箱子状态
	 * @param boxMap
	 * @param boxCode
	 * @return
	 * @throws Exception
	 */
	private String getClassName(Map<String, BoxInfo> boxMap,String boxCode) throws Exception{
		BoxInfo boxInfo = boxMap.get(boxCode);
		String className = "_default";
		if(null==boxInfo){ //未找到
			className =  "_undefined";
		}else{
			if(boxInfo.getLoadStatus()==1){ //空闲
				className = "_idle";
			}else if(boxInfo.getLoadStatus()==2){ //占用
				className = "_occupation";
			}else if(boxInfo.getLoadStatus()==3){//占用超时
				className = "_timeout";
			}else if(boxInfo.getLoadStatus()==4){//弃件（占用超期）
				className = "_extended";
			}
		}
		return className;
	}
	
	public String parserHtml(String context,int index,String ssCode,String cabIndex,Map<String, BoxInfo> boxMap) throws Exception {
		Document doc = Jsoup.parse(context);
		Elements datas = doc.getElementsByTag("table");
		
		for (Element data : datas) {
			Elements trs = data.getElementsByTag("tr");
			for (int i = 0; i < trs.size(); i++) {
				Elements tds = trs.get(i).getElementsByTag("td");
				for (int j = 0; j < tds.size(); j++) {
					Element td = tds.get(j);
					//String tdClass = td.attr("class"); // 获取TD的class属性
					String value = td.text();
					String param = this.getBoxCode(ssCode,value,cabIndex);
					td.attr("id","box_"+param);
					td.addClass(getClassName(boxMap, param));
					td.text(cabIndex+"-"+StringUtil.appendZero(2, value));
				}
			}
		}
		return datas.toString();
	}
	
	/**
	 * 根据物箱代码与箱子序号获取箱子代码
	 * @param ssCode
	 * @return
	 */
	public String getBoxCode(String ssCode,String boxId,String cabIndex){
		StringBuffer buffer = new StringBuffer(boxId);
		if(boxId.length()<3){
			for (int i = 0; i < 3-boxId.length(); i++) {
				buffer.insert(0, "0");
			}
		}
		
		StringBuffer sbf = new StringBuffer(cabIndex);
		if(cabIndex.length()<2){
			for (int i = 0; i < 2-cabIndex.length(); i++) {
				sbf.insert(0, "0");
			}
		}
		buffer.insert(0, sbf.toString());
		buffer.insert(0, ssCode);
		return buffer.toString();
	}
}
