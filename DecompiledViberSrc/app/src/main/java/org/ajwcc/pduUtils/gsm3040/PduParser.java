package org.ajwcc.pduUtils.gsm3040;

import java.util.Calendar;
import java.util.TimeZone;
import org.ajwcc.pduUtils.gsm3040.ie.InformationElementFactory;

public class PduParser
{
  private byte[] pduByteArray;
  private int position;

  private void parseSmsDeliverMessage(SmsDeliveryPdu paramSmsDeliveryPdu)
  {
    int i = readByte();
    int j = readByte();
    String str = readAddress(i, j);
    paramSmsDeliveryPdu.setAddressType(j);
    if (str != null)
      paramSmsDeliveryPdu.setAddress(str);
    paramSmsDeliveryPdu.setProtocolIdentifier(readByte());
    paramSmsDeliveryPdu.setDataCodingScheme(readByte());
    paramSmsDeliveryPdu.setTimestamp(readTimeStamp());
    parseUserData(paramSmsDeliveryPdu);
  }

  private void parseSmsStatusReportMessage(SmsStatusReportPdu paramSmsStatusReportPdu)
  {
    paramSmsStatusReportPdu.setMessageReference(readByte());
    int i = readByte();
    int j = readByte();
    String str = readAddress(i, j);
    paramSmsStatusReportPdu.setAddressType(j);
    paramSmsStatusReportPdu.setAddress(str);
    paramSmsStatusReportPdu.setTimestamp(readTimeStamp());
    paramSmsStatusReportPdu.setDischargeTime(readTimeStamp());
    paramSmsStatusReportPdu.setStatus(readByte());
  }

  private void parseSmsSubmitMessage(SmsSubmitPdu paramSmsSubmitPdu)
  {
    paramSmsSubmitPdu.setMessageReference(readByte());
    int i = readByte();
    int j = readByte();
    String str = readAddress(i, j);
    paramSmsSubmitPdu.setAddressType(j);
    paramSmsSubmitPdu.setAddress(str);
    paramSmsSubmitPdu.setProtocolIdentifier(readByte());
    paramSmsSubmitPdu.setDataCodingScheme(readByte());
    switch (paramSmsSubmitPdu.getTpVpf())
    {
    case 0:
    default:
    case 16:
    case 24:
    }
    while (true)
    {
      parseUserData(paramSmsSubmitPdu);
      return;
      paramSmsSubmitPdu.setValidityPeriod(readValidityPeriodInt() / 60);
      continue;
      paramSmsSubmitPdu.setValidityTimestamp(readTimeStamp());
    }
  }

  private Pdu parseStart()
  {
    int i = readByte();
    if (i > 0)
    {
      int j = readByte();
      String str = readAddress(2 * (i - 1), j);
      Pdu localPdu = PduFactory.createPdu(readByte());
      localPdu.setSmscAddressType(j);
      localPdu.setSmscAddress(str);
      localPdu.setSmscInfoLength(i);
      return localPdu;
    }
    return PduFactory.createPdu(readByte());
  }

  private void parseUserData(Pdu paramPdu)
  {
    paramPdu.setUDLength(readByte());
    int i = this.pduByteArray.length - this.position;
    byte[] arrayOfByte1 = new byte[i];
    System.arraycopy(this.pduByteArray, this.position, arrayOfByte1, 0, i);
    paramPdu.setUDData(arrayOfByte1);
    if (paramPdu.hasTpUdhi())
    {
      int j = readByte() + this.position;
      while (this.position < j)
      {
        int k = readByte();
        int m = readByte();
        byte[] arrayOfByte2 = new byte[m];
        System.arraycopy(this.pduByteArray, this.position, arrayOfByte2, 0, m);
        paramPdu.addInformationElement(InformationElementFactory.createInformationElement(k, arrayOfByte2));
        this.position = (m + this.position);
        if (this.position > j)
          throw new RuntimeException("UDH is shorter than expected endUdh=" + j + ", position=" + this.position);
      }
    }
  }

  private String readAddress(int paramInt1, int paramInt2)
  {
    int i = 1;
    if (paramInt1 > 0)
    {
      int j = paramInt1 / 2;
      if (paramInt1 % 2 == i);
      byte[] arrayOfByte;
      while (true)
      {
        int k = i + j;
        arrayOfByte = new byte[k];
        System.arraycopy(this.pduByteArray, this.position, arrayOfByte, 0, k);
        this.position = (k + this.position);
        switch (PduUtils.extractAddressType(paramInt2))
        {
        default:
          return PduUtils.readBCDNumbers(paramInt1, arrayOfByte);
          i = 0;
        case 80:
        }
      }
      return stripAddressFieldPadding(paramInt1, PduUtils.decode7bitEncoding(arrayOfByte));
    }
    return null;
  }

  private int readByte()
  {
    int i = 0xFF & this.pduByteArray[this.position];
    this.position = (1 + this.position);
    return i;
  }

  private int readSwappedNibbleBCDByte()
  {
    int i = PduUtils.swapNibbles((byte)readByte());
    return 0 + 10 * (0xF & i >>> 4) + (i & 0xF);
  }

  private Calendar readTimeStamp()
  {
    int i = readSwappedNibbleBCDByte();
    int j = readSwappedNibbleBCDByte();
    int k = readSwappedNibbleBCDByte();
    int m = readSwappedNibbleBCDByte();
    int n = readSwappedNibbleBCDByte();
    int i1 = readSwappedNibbleBCDByte();
    int i2 = readByte();
    int i3;
    int i4;
    int i10;
    StringBuilder localStringBuilder2;
    if ((i2 & 0x8) == 8)
    {
      i3 = 1;
      i4 = 0x7F & PduUtils.swapNibbles(i2);
      if (i3 == 0)
        break label236;
      int i8 = 15 * (0 + 10 * (0xF & i4 >>> 4) + (i4 & 0xF));
      int i9 = i8 / 60;
      i10 = i8 % 60;
      localStringBuilder2 = new StringBuilder().append("GMT-").append(i9).append(":");
      if (i10 >= 10)
        break label229;
    }
    TimeZone localTimeZone;
    label229: for (String str2 = "0"; ; str2 = "")
    {
      localTimeZone = TimeZone.getTimeZone(str2 + i10);
      Calendar localCalendar = Calendar.getInstance(localTimeZone);
      localCalendar.set(1, i + 2000);
      localCalendar.set(2, j - 1);
      localCalendar.set(5, k);
      localCalendar.set(11, m);
      localCalendar.set(12, n);
      localCalendar.set(13, i1);
      return localCalendar;
      i3 = 0;
      break;
    }
    label236: int i5 = 15 * (0 + 10 * (0xF & i4 >>> 4) + (i4 & 0xF));
    int i6 = i5 / 60;
    int i7 = i5 % 60;
    StringBuilder localStringBuilder1 = new StringBuilder().append("GMT+").append(i6).append(":");
    if (i7 < 10);
    for (String str1 = "0"; ; str1 = "")
    {
      localTimeZone = TimeZone.getTimeZone(str1 + i7);
      break;
    }
  }

  private int readValidityPeriodInt()
  {
    int i = readByte();
    int j;
    if ((i > 0) && (i <= 143))
      j = 5 * (i + 1);
    do
    {
      do
      {
        return j;
        if ((i > 143) && (i <= 167))
          return 720 + 30 * (i - 143);
        if ((i > 167) && (i <= 196))
          return 60 * (24 * (i - 166));
        j = 0;
      }
      while (i <= 197);
      j = 0;
    }
    while (i > 255);
    return 60 * (24 * (7 * (i - 192)));
  }

  private String stripAddressFieldPadding(int paramInt, String paramString)
  {
    return paramString.substring(0, paramInt * 4 / 7);
  }

  public Pdu parsePdu(String paramString)
  {
    this.pduByteArray = PduUtils.pduToBytes(paramString);
    this.position = 0;
    Pdu localPdu = parseStart();
    localPdu.setRawPdu(paramString);
    switch (localPdu.getTpMti())
    {
    default:
      return localPdu;
    case 0:
      parseSmsDeliverMessage((SmsDeliveryPdu)localPdu);
      return localPdu;
    case 1:
      parseSmsSubmitMessage((SmsSubmitPdu)localPdu);
      return localPdu;
    case 2:
    }
    parseSmsStatusReportMessage((SmsStatusReportPdu)localPdu);
    return localPdu;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.ajwcc.pduUtils.gsm3040.PduParser
 * JD-Core Version:    0.6.2
 */