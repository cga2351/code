package org.ajwcc.pduUtils.gsm3040;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import org.ajwcc.pduUtils.gsm3040.ie.ConcatInformationElement;
import org.ajwcc.pduUtils.gsm3040.ie.InformationElement;
import org.ajwcc.pduUtils.gsm3040.ie.InformationElementFactory;

public class PduGenerator
{
  private ByteArrayOutputStream baos;
  private int firstOctetPosition = -1;
  private boolean updateFirstOctet = false;

  private byte[] getUnencodedSeptetsForPart(Pdu paramPdu, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte1 = PduUtils.stringToUnencodedSeptets(paramPdu.getDecodedText());
    int i = 1 + arrayOfByte1.length / paramInt1;
    if ((paramPdu.hasTpUdhi()) && (paramPdu.getConcatInfo() != null) && (paramInt2 > 0))
      paramPdu.getConcatInfo().setMpMaxNo(i);
    if ((i > 1) && (paramInt2 > 0))
      if (paramInt2 > i)
        throw new RuntimeException("Invalid partNo: " + paramInt2 + ", maxParts=" + i);
    for (int j = paramInt1 * (paramInt2 - 1); ; j = 0)
    {
      byte[] arrayOfByte2 = new byte[Math.min(paramInt1, arrayOfByte1.length - j)];
      System.arraycopy(arrayOfByte1, j, arrayOfByte2, 0, arrayOfByte2.length);
      return arrayOfByte2;
    }
  }

  protected void checkForConcat(Pdu paramPdu, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramInt1 <= paramInt3) || ((paramInt1 > paramInt3) && (paramInt1 <= paramInt2)))
      return;
    if (paramPdu.getConcatInfo() != null)
    {
      paramPdu.getConcatInfo().setMpRefNo(paramInt4);
      paramPdu.getConcatInfo().setMpSeqNo(paramInt5);
      return;
    }
    paramPdu.addInformationElement(InformationElementFactory.generateConcatInfo(paramInt4, paramInt5));
    this.updateFirstOctet = true;
  }

  protected int computeOffset(Pdu paramPdu, int paramInt1, int paramInt2)
  {
    if (!paramPdu.isBinary());
    for (int i = 1 + paramPdu.getDecodedText().length() / paramInt1; ; i = 1 + paramPdu.getDataBytes().length / paramInt1)
    {
      if ((paramPdu.hasTpUdhi()) && (paramPdu.getConcatInfo() != null) && (paramInt2 > 0))
        paramPdu.getConcatInfo().setMpMaxNo(i);
      if ((i <= 1) || (paramInt2 <= 0))
        break label120;
      if (paramInt2 <= i)
        break;
      throw new RuntimeException("Invalid partNo: " + paramInt2 + ", maxParts=" + i);
    }
    return paramInt1 * (paramInt2 - 1);
    label120: return 0;
  }

  protected int computePotentialUdhLength(Pdu paramPdu)
  {
    int i = paramPdu.getTotalUDHLength();
    if (i == 0)
      return 1 + ConcatInformationElement.getDefaultConcatLength();
    return i + ConcatInformationElement.getDefaultConcatLength();
  }

  public List<String> generatePduList(Pdu paramPdu, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 1; i <= paramPdu.getMpMaxNo(); i++)
      localArrayList.add(generatePduString(paramPdu, paramInt, i));
    return localArrayList;
  }

  public String generatePduString(Pdu paramPdu)
  {
    return generatePduString(paramPdu, -1, -1);
  }

  public String generatePduString(Pdu paramPdu, int paramInt1, int paramInt2)
  {
    while (true)
    {
      try
      {
        this.baos = new ByteArrayOutputStream();
        this.firstOctetPosition = -1;
        this.updateFirstOctet = false;
        switch (paramPdu.getTpMti())
        {
        default:
          byte[] arrayOfByte = this.baos.toByteArray();
          if (this.updateFirstOctet)
            arrayOfByte[this.firstOctetPosition] = ((byte)(0xFF & paramPdu.getFirstOctet()));
          return PduUtils.bytesToPdu(arrayOfByte);
        case 0:
          generateSmsDeliverPduString((SmsDeliveryPdu)paramPdu, paramInt1, paramInt2);
          continue;
        case 1:
        case 2:
        }
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
      generateSmsSubmitPduString((SmsSubmitPdu)paramPdu, paramInt1, paramInt2);
      continue;
      generateSmsStatusReportPduString((SmsStatusReportPdu)paramPdu);
    }
  }

  protected void generateSmsDeliverPduString(SmsDeliveryPdu paramSmsDeliveryPdu, int paramInt1, int paramInt2)
    throws Exception
  {
    writeSmscInfo(paramSmsDeliveryPdu);
    writeFirstOctet(paramSmsDeliveryPdu);
    writeAddress(paramSmsDeliveryPdu.getAddress(), paramSmsDeliveryPdu.getAddressType(), paramSmsDeliveryPdu.getAddress().length());
    writeByte(paramSmsDeliveryPdu.getProtocolIdentifier());
    writeByte(paramSmsDeliveryPdu.getDataCodingScheme());
    writeTimeStampStringForDate(paramSmsDeliveryPdu.getTimestamp());
    writeUDData(paramSmsDeliveryPdu, paramInt1, paramInt2);
  }

  protected void generateSmsStatusReportPduString(SmsStatusReportPdu paramSmsStatusReportPdu)
    throws Exception
  {
    writeSmscInfo(paramSmsStatusReportPdu);
    writeFirstOctet(paramSmsStatusReportPdu);
    writeByte(paramSmsStatusReportPdu.getMessageReference());
    writeAddress(paramSmsStatusReportPdu.getAddress(), paramSmsStatusReportPdu.getAddressType(), paramSmsStatusReportPdu.getAddress().length());
    writeTimeStampStringForDate(paramSmsStatusReportPdu.getTimestamp());
    writeTimeStampStringForDate(paramSmsStatusReportPdu.getDischargeTime());
    writeByte(paramSmsStatusReportPdu.getStatus());
  }

  protected void generateSmsSubmitPduString(SmsSubmitPdu paramSmsSubmitPdu, int paramInt1, int paramInt2)
    throws Exception
  {
    writeSmscInfo(paramSmsSubmitPdu);
    writeFirstOctet(paramSmsSubmitPdu);
    writeByte(paramSmsSubmitPdu.getMessageReference());
    writeAddress(paramSmsSubmitPdu.getAddress(), paramSmsSubmitPdu.getAddressType(), paramSmsSubmitPdu.getAddress().length());
    writeByte(paramSmsSubmitPdu.getProtocolIdentifier());
    writeByte(paramSmsSubmitPdu.getDataCodingScheme());
    switch (paramSmsSubmitPdu.getTpVpf())
    {
    default:
    case 16:
    case 24:
    }
    while (true)
    {
      writeUDData(paramSmsSubmitPdu, paramInt1, paramInt2);
      return;
      writeValidityPeriodInteger(paramSmsSubmitPdu.getValidityPeriod());
      continue;
      writeTimeStampStringForDate(paramSmsSubmitPdu.getValidityDate());
    }
  }

  protected void writeAddress(String paramString, int paramInt1, int paramInt2)
    throws Exception
  {
    switch (PduUtils.extractAddressType(paramInt1))
    {
    default:
      writeBCDAddress(paramString, paramInt1, paramInt2);
      return;
    case 80:
    }
    byte[] arrayOfByte = PduUtils.encode7bitUserData(null, PduUtils.stringToUnencodedSeptets(paramString));
    this.baos.write(2 * arrayOfByte.length);
    this.baos.write(paramInt1);
    this.baos.write(arrayOfByte);
  }

  protected void writeBCDAddress(String paramString, int paramInt1, int paramInt2)
    throws Exception
  {
    this.baos.write(paramInt2);
    this.baos.write(paramInt1);
    if (paramString.length() % 2 == 1)
      paramString = paramString + "F";
    int i = 0;
    int j = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (i % 2 == 1)
      {
        int k = j | Integer.parseInt(Character.toString(c), 16) << 4;
        this.baos.write(k);
        j = 0;
      }
      while (true)
      {
        i++;
        break;
        j |= 0xF & Integer.parseInt(Character.toString(c), 16);
      }
    }
  }

  protected void writeByte(int paramInt)
  {
    this.baos.write(paramInt);
  }

  protected void writeBytes(byte[] paramArrayOfByte)
    throws Exception
  {
    this.baos.write(paramArrayOfByte);
  }

  protected void writeFirstOctet(Pdu paramPdu)
  {
    this.firstOctetPosition = (1 + paramPdu.getSmscInfoLength());
    writeByte(paramPdu.getFirstOctet());
  }

  protected void writeSmscInfo(Pdu paramPdu)
    throws Exception
  {
    if (paramPdu.getSmscAddress() != null)
    {
      writeBCDAddress(paramPdu.getSmscAddress(), paramPdu.getSmscAddressType(), paramPdu.getSmscInfoLength());
      return;
    }
    writeByte(0);
  }

  protected void writeTimeStampStringForDate(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    int i = -2000 + localCalendar.get(1);
    int j = 1 + localCalendar.get(2);
    int k = localCalendar.get(5);
    int m = localCalendar.get(11);
    int n = localCalendar.get(12);
    int i1 = localCalendar.get(13);
    int i2 = localCalendar.getTimeZone().getOffset(paramDate.getTime()) / 60000 / 15;
    if (i2 < 0)
      i2 = 128 - i2;
    this.baos.write(PduUtils.createSwappedBCD(i));
    this.baos.write(PduUtils.createSwappedBCD(j));
    this.baos.write(PduUtils.createSwappedBCD(k));
    this.baos.write(PduUtils.createSwappedBCD(m));
    this.baos.write(PduUtils.createSwappedBCD(n));
    this.baos.write(PduUtils.createSwappedBCD(i1));
    this.baos.write(PduUtils.createSwappedBCD(i2));
  }

  protected void writeUDData(Pdu paramPdu, int paramInt1, int paramInt2)
  {
    int i = paramPdu.getDataCodingScheme();
    try
    {
      switch (PduUtils.extractDcsEncoding(i))
      {
      default:
        throw new RuntimeException("Invalid DCS encoding: " + PduUtils.extractDcsEncoding(i));
      case 0:
      case 4:
      case 8:
      }
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
    writeUDData7bit(paramPdu, paramInt1, paramInt2);
    return;
    writeUDData8bit(paramPdu, paramInt1, paramInt2);
    return;
    writeUDDataUCS2(paramPdu, paramInt1, paramInt2);
  }

  protected void writeUDData7bit(Pdu paramPdu, int paramInt1, int paramInt2)
    throws Exception
  {
    byte[] arrayOfByte1 = PduUtils.stringToUnencodedSeptets(paramPdu.getDecodedText());
    int i = PduUtils.getNumSeptetsForOctets(computePotentialUdhLength(paramPdu));
    checkForConcat(paramPdu, arrayOfByte1.length, 160 - PduUtils.getNumSeptetsForOctets(paramPdu.getTotalUDHLength()), 160 - i, paramInt1, paramInt2);
    int j = paramPdu.getTotalUDHLength();
    byte[] arrayOfByte2 = getUnencodedSeptetsForPart(paramPdu, 160 - PduUtils.getNumSeptetsForOctets(j), paramInt2);
    int k = PduUtils.getNumSeptetsForOctets(j) + arrayOfByte2.length;
    this.baos.write(k);
    boolean bool = paramPdu.hasTpUdhi();
    byte[] arrayOfByte3 = null;
    if (bool)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      writeUDH(paramPdu, localByteArrayOutputStream);
      arrayOfByte3 = localByteArrayOutputStream.toByteArray();
    }
    byte[] arrayOfByte4 = PduUtils.encode7bitUserData(arrayOfByte3, arrayOfByte2);
    this.baos.write(arrayOfByte4);
  }

  protected void writeUDData8bit(Pdu paramPdu, int paramInt1, int paramInt2)
    throws Exception
  {
    if (paramPdu.isBinary());
    for (byte[] arrayOfByte1 = paramPdu.getDataBytes(); ; arrayOfByte1 = PduUtils.encode8bitUserData(paramPdu.getDecodedText()))
    {
      int i = computePotentialUdhLength(paramPdu);
      checkForConcat(paramPdu, arrayOfByte1.length, 140 - paramPdu.getTotalUDHLength(), 140 - i, paramInt1, paramInt2);
      int j = paramPdu.getTotalUDHLength();
      int k = 140 - j;
      int m = computeOffset(paramPdu, k, paramInt2);
      byte[] arrayOfByte2 = new byte[Math.min(k, arrayOfByte1.length - m)];
      System.arraycopy(arrayOfByte1, m, arrayOfByte2, 0, arrayOfByte2.length);
      int n = j + arrayOfByte2.length;
      this.baos.write(n);
      if (paramPdu.hasTpUdhi())
        writeUDH(paramPdu, this.baos);
      this.baos.write(arrayOfByte2);
      return;
    }
  }

  protected void writeUDDataUCS2(Pdu paramPdu, int paramInt1, int paramInt2)
    throws Exception
  {
    String str1 = paramPdu.getDecodedText();
    int i = computePotentialUdhLength(paramPdu);
    checkForConcat(paramPdu, str1.length(), (140 - paramPdu.getTotalUDHLength()) / 2, (140 - i) / 2, paramInt1, paramInt2);
    int j = paramPdu.getTotalUDHLength();
    int k = (140 - j) / 2;
    int m = computeOffset(paramPdu, k, paramInt2);
    String str2 = str1.substring(m, Math.min(k + m, str1.length()));
    int n = j + 2 * str2.length();
    this.baos.write(n);
    if (paramPdu.hasTpUdhi())
      writeUDH(paramPdu, this.baos);
    this.baos.write(PduUtils.encodeUcs2UserData(str2));
  }

  protected void writeUDH(Pdu paramPdu)
    throws IOException
  {
    writeUDH(paramPdu, this.baos);
  }

  protected void writeUDH(Pdu paramPdu, ByteArrayOutputStream paramByteArrayOutputStream)
    throws IOException
  {
    paramByteArrayOutputStream.write(paramPdu.getUDHLength());
    Iterator localIterator = paramPdu.getInformationElements();
    while (localIterator.hasNext())
    {
      InformationElement localInformationElement = (InformationElement)localIterator.next();
      paramByteArrayOutputStream.write(localInformationElement.getIdentifier());
      paramByteArrayOutputStream.write(localInformationElement.getLength());
      paramByteArrayOutputStream.write(localInformationElement.getData());
    }
  }

  protected void writeValidityPeriodInteger(int paramInt)
  {
    if (paramInt == -1)
    {
      this.baos.write(255);
      return;
    }
    int i;
    if (paramInt <= 12)
      i = -1 + paramInt * 12;
    while (true)
    {
      this.baos.write(i);
      return;
      if (paramInt <= 24)
        i = 143 + 2 * (paramInt - 12);
      else if (paramInt <= 720)
        i = 166 + paramInt / 24;
      else
        i = 192 + paramInt / 168;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.ajwcc.pduUtils.gsm3040.PduGenerator
 * JD-Core Version:    0.6.2
 */