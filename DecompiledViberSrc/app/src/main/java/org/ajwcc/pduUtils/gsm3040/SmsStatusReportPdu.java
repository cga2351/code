package org.ajwcc.pduUtils.gsm3040;

import java.util.Calendar;
import java.util.Date;

public class SmsStatusReportPdu extends Pdu
{
  private Calendar dischargeTime;
  private int messageReference = 0;
  private int status = 0;
  private Calendar timestamp;

  public Date getDischargeTime()
  {
    return this.dischargeTime.getTime();
  }

  public Calendar getDischargeTimeAsCalendar()
  {
    return this.dischargeTime;
  }

  public int getMessageReference()
  {
    return this.messageReference;
  }

  public int getStatus()
  {
    return this.status;
  }

  public Date getTimestamp()
  {
    return this.timestamp.getTime();
  }

  public Calendar getTimestampAsCalendar()
  {
    return this.timestamp;
  }

  public boolean hasTpMms()
  {
    checkTpMti(new int[] { 0, 2 });
    return getFirstOctetField(251) == 4;
  }

  public boolean hasTpSri()
  {
    return getFirstOctetField(223) == 32;
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
    }
    while (true)
    {
      localStringBuffer.append("\n");
      localStringBuffer.append("TP-SCTS: " + formatTimestamp(getTimestampAsCalendar()));
      localStringBuffer.append("\n");
      localStringBuffer.append("Discharge Time: " + formatTimestamp(getDischargeTimeAsCalendar()));
      localStringBuffer.append("\n");
      localStringBuffer.append("Status: " + PduUtils.byteToPdu(getStatus()));
      localStringBuffer.append("\n");
      return localStringBuffer.toString();
      localStringBuffer.append("Destination Address: [Length: 0");
      localStringBuffer.append(", Type: " + PduUtils.byteToPdu(getAddressType()) + " (" + PduUtils.byteToBits((byte)getAddressType()) + ")");
      localStringBuffer.append("]");
    }
  }

  public void setDischargeTime(Calendar paramCalendar)
  {
    this.dischargeTime = paramCalendar;
  }

  public void setMessageReference(int paramInt)
  {
    this.messageReference = paramInt;
  }

  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }

  public void setTimestamp(Calendar paramCalendar)
  {
    this.timestamp = paramCalendar;
  }

  public void setTpMms(int paramInt)
  {
    checkTpMti(new int[] { 0, 2 });
    setFirstOctetField(251, paramInt, new int[] { 4, 0 });
  }

  public void setTpSri(int paramInt)
  {
    setFirstOctetField(223, paramInt, new int[] { 0, 32 });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.ajwcc.pduUtils.gsm3040.SmsStatusReportPdu
 * JD-Core Version:    0.6.2
 */