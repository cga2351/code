package org.ajwcc.pduUtils.wappush;

import java.util.Date;
import org.ajwcc.pduUtils.gsm3040.SmsSubmitPdu;

public class WapSiPdu extends SmsSubmitPdu
{
  public static final int WAP_SIGNAL_DELETE = 9;
  public static final int WAP_SIGNAL_HIGH = 8;
  public static final int WAP_SIGNAL_LOW = 6;
  public static final int WAP_SIGNAL_MEDIUM = 7;
  public static final int WAP_SIGNAL_NONE = 5;
  private Date createDate;
  private Date expireDate;
  private String indicationText;
  private String siClass;
  private String siId;
  private String url;
  private int wapSignal = 7;

  public WapSiPdu()
  {
    setDataCodingScheme(244);
  }

  public Date getCreateDate()
  {
    return this.createDate;
  }

  public byte[] getDataBytes()
  {
    if (super.getDataBytes() == null)
    {
      WapSiUserDataGenerator localWapSiUserDataGenerator = new WapSiUserDataGenerator();
      localWapSiUserDataGenerator.setWapSiPdu(this);
      setDataBytes(localWapSiUserDataGenerator.generateWapSiUDBytes());
    }
    return super.getDataBytes();
  }

  public Date getExpireDate()
  {
    return this.expireDate;
  }

  public String getIndicationText()
  {
    return this.indicationText;
  }

  public String getSiClass()
  {
    return this.siClass;
  }

  public String getSiId()
  {
    return this.siId;
  }

  public String getUrl()
  {
    return this.url;
  }

  public int getWapSignal()
  {
    return this.wapSignal;
  }

  public void setCreateDate(Date paramDate)
  {
    this.createDate = paramDate;
  }

  public void setExpireDate(Date paramDate)
  {
    this.expireDate = paramDate;
  }

  public void setIndicationText(String paramString)
  {
    this.indicationText = paramString;
  }

  public void setSiClass(String paramString)
  {
    this.siClass = paramString;
  }

  public void setSiId(String paramString)
  {
    this.siId = paramString;
  }

  public void setUrl(String paramString)
  {
    this.url = paramString;
  }

  public void setWapSignal(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new RuntimeException("Invalid wap signal value: " + paramInt);
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    }
    this.wapSignal = paramInt;
  }

  public void setWapSignalFromString(String paramString)
  {
    if (paramString == null)
    {
      this.wapSignal = 7;
      return;
    }
    String str = paramString.trim();
    if (str.equalsIgnoreCase("none"))
    {
      this.wapSignal = 5;
      return;
    }
    if (str.equalsIgnoreCase("low"))
    {
      this.wapSignal = 6;
      return;
    }
    if ((str.equalsIgnoreCase("medium")) || (str.equals("")))
    {
      this.wapSignal = 7;
      return;
    }
    if (str.equalsIgnoreCase("high"))
    {
      this.wapSignal = 8;
      return;
    }
    if (str.equalsIgnoreCase("delete"))
    {
      this.wapSignal = 9;
      return;
    }
    throw new RuntimeException("Cannot determine WAP signal to use");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.ajwcc.pduUtils.wappush.WapSiPdu
 * JD-Core Version:    0.6.2
 */