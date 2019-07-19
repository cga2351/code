package org.ajwcc.pduUtils.gsm3040;

import java.util.Calendar;
import java.util.Date;

public class SmsSubmitPdu extends Pdu
{
  private int messageReference = 0;
  private int validityPeriod = -1;
  private Calendar validityPeriodTimeStamp;

  public int getMessageReference()
  {
    return this.messageReference;
  }

  public int getTpVpf()
  {
    return getFirstOctetField(231);
  }

  public Date getValidityDate()
  {
    return this.validityPeriodTimeStamp.getTime();
  }

  public Calendar getValidityDateAsCalendar()
  {
    return this.validityPeriodTimeStamp;
  }

  public int getValidityPeriod()
  {
    return this.validityPeriod;
  }

  public boolean hasTpRd()
  {
    return getFirstOctetField(251) == 4;
  }

  public boolean hasTpSrr()
  {
    return getFirstOctetField(223) == 32;
  }

  public boolean hasTpVpf()
  {
    return getFirstOctetField(231) != 0;
  }

  protected String pduSubclassInfo()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("Message Reference: " + PduUtils.byteToPdu(getMessageReference()));
    localStringBuffer.append("\n");
    if (getAddress() != null)
    {
      localStringBuffer.append("Destination Address: [Length: " + getAddress().length() + " (" + PduUtils.byteToPdu((byte)getAddress().length()) + ")");
      localStringBuffer.append(", Type: " + PduUtils.byteToPdu(getAddressType()) + " (" + PduUtils.byteToBits((byte)getAddressType()) + ")");
      localStringBuffer.append(", Address: " + getAddress());
      localStringBuffer.append("]");
      localStringBuffer.append("\n");
      localStringBuffer.append("TP-PID: " + PduUtils.byteToPdu(getProtocolIdentifier()) + " (" + PduUtils.byteToBits((byte)getProtocolIdentifier()) + ")");
      localStringBuffer.append("\n");
      localStringBuffer.append("TP-DCS: " + PduUtils.byteToPdu(getDataCodingScheme()) + " (" + PduUtils.decodeDataCodingScheme(this) + ") (" + PduUtils.byteToBits((byte)getDataCodingScheme()) + ")");
      localStringBuffer.append("\n");
      switch (getTpVpf())
      {
      default:
      case 16:
      case 24:
      }
    }
    while (true)
    {
      localStringBuffer.append("\n");
      return localStringBuffer.toString();
      localStringBuffer.append("Destination Address: [Length: 0");
      localStringBuffer.append(", Type: " + PduUtils.byteToPdu(getAddressType()) + " (" + PduUtils.byteToBits((byte)getAddressType()) + ")");
      localStringBuffer.append("]");
      break;
      localStringBuffer.append("TP-VPF: " + getValidityPeriod() + " hours");
      continue;
      localStringBuffer.append("TP-VPF: " + formatTimestamp(getValidityDateAsCalendar()));
    }
  }

  public void setMessageReference(int paramInt)
  {
    this.messageReference = paramInt;
  }

  public void setTpRd(int paramInt)
  {
    setFirstOctetField(251, paramInt, new int[] { 0, 4 });
  }

  public void setTpSrr(int paramInt)
  {
    setFirstOctetField(223, paramInt, new int[] { 0, 32 });
  }

  public void setTpVpf(int paramInt)
  {
    setFirstOctetField(231, paramInt, new int[] { 16, 0, 24 });
  }

  public void setValidityPeriod(int paramInt)
  {
    this.validityPeriod = paramInt;
  }

  public void setValidityTimestamp(Calendar paramCalendar)
  {
    this.validityPeriodTimeStamp = paramCalendar;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.ajwcc.pduUtils.gsm3040.SmsSubmitPdu
 * JD-Core Version:    0.6.2
 */