package org.ajwcc.pduUtils.gsm3040;

import java.util.Calendar;
import java.util.Date;

public class SmsDeliveryPdu extends Pdu
{
  private Calendar timestamp;

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
    if (getAddress() != null)
    {
      localStringBuffer.append("Originator Address: [Length: " + getAddress().length() + " (" + PduUtils.byteToPdu((byte)getAddress().length()) + ")");
      localStringBuffer.append(", Type: " + PduUtils.byteToPdu(getAddressType()) + " (" + PduUtils.byteToBits((byte)getAddressType()) + ")");
      localStringBuffer.append(", Address: " + getAddress());
      localStringBuffer.append("]");
    }
    while (true)
    {
      localStringBuffer.append("\n");
      localStringBuffer.append("TP-PID: " + PduUtils.byteToPdu(getProtocolIdentifier()) + " (" + PduUtils.byteToBits((byte)getProtocolIdentifier()) + ")");
      localStringBuffer.append("\n");
      localStringBuffer.append("TP-DCS: " + PduUtils.byteToPdu(getDataCodingScheme()) + " (" + PduUtils.decodeDataCodingScheme(this) + ") (" + PduUtils.byteToBits((byte)getDataCodingScheme()) + ")");
      localStringBuffer.append("\n");
      localStringBuffer.append("TP-SCTS: " + formatTimestamp(getTimestampAsCalendar()));
      localStringBuffer.append("\n");
      return localStringBuffer.toString();
      localStringBuffer.append("Originator Address: [Length: 0");
      localStringBuffer.append(", Type: " + PduUtils.byteToPdu(getAddressType()) + " (" + PduUtils.byteToBits((byte)getAddressType()) + ")");
      localStringBuffer.append("]");
    }
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
 * Qualified Name:     org.ajwcc.pduUtils.gsm3040.SmsDeliveryPdu
 * JD-Core Version:    0.6.2
 */