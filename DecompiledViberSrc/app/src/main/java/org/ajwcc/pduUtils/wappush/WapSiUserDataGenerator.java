package org.ajwcc.pduUtils.wappush;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.ajwcc.pduUtils.gsm3040.PduUtils;

public class WapSiUserDataGenerator
{
  private ByteArrayOutputStream baos = new ByteArrayOutputStream();
  private WapSiPdu pdu;

  private void writeActionAttribute(int paramInt)
  {
    if (paramInt != 7)
      this.baos.write(paramInt);
  }

  private void writeCreatedAttribute(Date paramDate)
    throws Exception
  {
    if (paramDate != null)
    {
      this.baos.write(10);
      writeDate(paramDate);
    }
  }

  private void writeDate(Date paramDate)
    throws Exception
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat();
    localSimpleDateFormat.applyPattern("yyyyMMddHHmmss");
    String str = localSimpleDateFormat.format(paramDate);
    for (int i = 6; (i >= 0) && (str.endsWith("00")); i--)
      str = str.substring(0, i * 2);
    byte[] arrayOfByte = PduUtils.pduToBytes(str);
    this.baos.write(195);
    this.baos.write(arrayOfByte.length);
    this.baos.write(arrayOfByte);
  }

  private void writeExpiresAttribute(Date paramDate)
    throws Exception
  {
    if (paramDate != null)
    {
      this.baos.write(16);
      writeDate(paramDate);
    }
  }

  private void writeHrefAttribute(String paramString)
    throws Exception
  {
    if ((paramString == null) || (paramString.trim().equals("")))
      throw new RuntimeException("Invalid URL: '" + paramString + "'");
    Iterator localIterator1 = WapPushUtils.getProtocols().iterator();
    while (localIterator1.hasNext())
    {
      String str4 = (String)localIterator1.next();
      if (paramString.startsWith(str4))
      {
        this.baos.write(WapPushUtils.getProtocolByteFor(str4));
        paramString = paramString.substring(str4.length());
      }
    }
    for (int i = 1; ; i = 0)
    {
      if (i == 0)
        this.baos.write(11);
      this.baos.write(3);
      int j = 0;
      int k = 0;
      label156: String str1;
      int m;
      int n;
      if (k < paramString.length())
      {
        Iterator localIterator2 = WapPushUtils.getDomains().iterator();
        if (!localIterator2.hasNext())
          break label357;
        str1 = (String)localIterator2.next();
        if (k + str1.length() > paramString.length())
        {
          String str3 = paramString.substring(j, paramString.length());
          this.baos.write(str3.getBytes("UTF-8"));
          int i1 = k + str1.length();
          m = j;
          n = i1;
        }
      }
      while (true)
      {
        k = n + 1;
        j = m;
        break;
        if (!paramString.substring(k, k + str1.length()).equalsIgnoreCase(str1))
          break label156;
        if (j < k)
        {
          String str2 = paramString.substring(j, k);
          this.baos.write(str2.getBytes("UTF-8"));
        }
        this.baos.write(0);
        this.baos.write(WapPushUtils.getDomainByteFor(str1));
        this.baos.write(3);
        n = k + str1.length();
        m = n;
        continue;
        this.baos.write(0);
        return;
        label357: m = j;
        n = k;
      }
    }
  }

  private void writeSiIdAttribute(String paramString)
  {
    if ((paramString != null) && (paramString.trim().equals("")))
    {
      this.baos.write(17);
      writeText(paramString);
    }
  }

  private void writeText(String paramString)
  {
    try
    {
      this.baos.write(3);
      this.baos.write(paramString.getBytes("UTF-8"));
      this.baos.write(0);
      return;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  private void writeWapSiData()
    throws Exception
  {
    this.baos.write(2);
    this.baos.write(5);
    this.baos.write(106);
    this.baos.write(0);
    this.baos.write(69);
    this.baos.write(198);
    writeHrefAttribute(this.pdu.getUrl());
    writeCreatedAttribute(this.pdu.getCreateDate());
    writeExpiresAttribute(this.pdu.getExpireDate());
    writeActionAttribute(this.pdu.getWapSignal());
    writeSiIdAttribute(this.pdu.getSiId());
    this.baos.write(1);
    writeText(this.pdu.getIndicationText());
    this.baos.write(1);
    this.baos.write(1);
  }

  private void writeWspHeader()
  {
    this.baos.write(1);
    this.baos.write(6);
    this.baos.write(4);
    this.baos.write(3);
    this.baos.write(174);
    this.baos.write(129);
    this.baos.write(234);
  }

  public byte[] generateWapSiUDBytes()
  {
    try
    {
      this.baos = new ByteArrayOutputStream();
      writeWspHeader();
      writeWapSiData();
      byte[] arrayOfByte = this.baos.toByteArray();
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  public void setWapSiPdu(WapSiPdu paramWapSiPdu)
  {
    this.pdu = paramWapSiPdu;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.ajwcc.pduUtils.wappush.WapSiUserDataGenerator
 * JD-Core Version:    0.6.2
 */