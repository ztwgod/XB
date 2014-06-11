package cn.com.xb.inter.domain;

import java.io.Serializable;
import java.util.Date;

public class ICourierCardInfo implements Serializable {

	/**
	 * 快递员使用的卡信息
	 */
	private static final long serialVersionUID = 1L;

	private String cardId; // 卡的ID编号
	private String cardCode; // 卡的Code编号
	private String cardPwd; // 卡绑定的密码
	private String courierId; // 快递员ID编号
	private String description; // 卡的描述信息
	private int cardType; // 卡类型
	private String issuedAgency; // 颁发机构
	private Date expirationDate; // 有效期
	private int validFlag; // 是否有效（0，无效；1，有效）

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getCardCode() {
		return cardCode;
	}

	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}

	public String getCardPwd() {
		return cardPwd;
	}

	public void setCardPwd(String cardPwd) {
		this.cardPwd = cardPwd;
	}

	public String getCourierId() {
		return courierId;
	}

	public void setCourierId(String courierId) {
		this.courierId = courierId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCardType() {
		return cardType;
	}

	public void setCardType(int cardType) {
		this.cardType = cardType;
	}

	public String getIssuedAgency() {
		return issuedAgency;
	}

	public void setIssuedAgency(String issuedAgency) {
		this.issuedAgency = issuedAgency;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int getValidFlag() {
		return validFlag;
	}

	public void setValidFlag(int validFlag) {
		this.validFlag = validFlag;
	}

}
