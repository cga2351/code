package org.ajwcc.pduUtils.gsm3040;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.ajwcc.pduUtils.gsm3040.ie.ConcatInformationElement;
import org.ajwcc.pduUtils.gsm3040.ie.InformationElement;
import org.ajwcc.pduUtils.gsm3040.ie.PortInformationElement;

public abstract class Pdu
{
  private static final int UDH_CHECK_MODE_ADD_IF_NONE = 0;
  private static final int UDH_CHECK_MODE_EXCEPTION_IF_NONE = 1;
  private static final int UDH_CHECK_MODE_IGNORE_IF_NONE = 2;
  private String address;
  private int addressType;
  private byte[] dataBytes;
  private int dataCodingScheme = 0;
  private String decodedText;
  private int firstOctet = 0;
  private ArrayList<InformationElement> ieList = new ArrayList();
  private HashMap<Integer, InformationElement> ieMap = new HashMap();
  private int protocolIdentifier = 0;
  private String rawPdu;
  private String smscAddress;
  private int smscAddressType;
  private int smscInfoLength;
  private byte[] udData;
  private int udLength;

  private void checkForUDHI(int paramInt)
  {
    if (!hasTpUdhi())
      switch (paramInt)
      {
      default:
        throw new RuntimeException("Invalid UDH check mode");
      case 1:
        throw new IllegalStateException("PDU does not have a UDHI in the first octet");
      case 0:
        setTpUdhi(64);
      case 2:
      }
  }

  private String decodeNonUDHDataAsString()
  {
    switch (PduUtils.extractDcsEncoding(getDataCodingScheme()))
    {
    default:
      throw new RuntimeException("Invalid dataCodingScheme: " + getDataCodingScheme());
    case 0:
      return PduUtils.decode7bitEncoding(getUDHData(), this.udData);
    case 4:
      return PduUtils.decode8bitEncoding(getUDHData(), this.udData);
    case 8:
    }
    return PduUtils.decodeUcs2Encoding(getUDHData(), this.udData);
  }

  private PortInformationElement getPortInfo()
  {
    checkForUDHI(2);
    return (PortInformationElement)getInformationElement(5);
  }

  public void addInformationElement(InformationElement paramInformationElement)
  {
    checkForUDHI(0);
    this.ieMap.put(Integer.valueOf(paramInformationElement.getIdentifier()), paramInformationElement);
    this.ieList.add(paramInformationElement);
  }

  protected void checkTpMti(int paramInt)
  {
    if (getTpMti() != paramInt)
      throw new RuntimeException("Invalid message type : " + getTpMti());
  }

  protected void checkTpMti(int[] paramArrayOfInt)
  {
    int i = getTpMti();
    int j = paramArrayOfInt.length;
    for (int k = 0; k < j; k++)
      if (i == paramArrayOfInt[k])
        return;
    throw new RuntimeException("Invalid message type : " + getTpMti());
  }

  protected String formatTimestamp(Calendar paramCalendar)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat();
    localSimpleDateFormat.applyPattern("EEE dd-MMM-yyyy HH:mm:ss z");
    localSimpleDateFormat.setTimeZone(paramCalendar.getTimeZone());
    return localSimpleDateFormat.format(paramCalendar.getTime());
  }

  public String getAddress()
  {
    return this.address;
  }

  public int getAddressType()
  {
    return this.addressType;
  }

  public ConcatInformationElement getConcatInfo()
  {
    checkForUDHI(2);
    ConcatInformationElement localConcatInformationElement = (ConcatInformationElement)getInformationElement(0);
    if (localConcatInformationElement == null)
      localConcatInformationElement = (ConcatInformationElement)getInformationElement(8);
    return localConcatInformationElement;
  }

  public byte[] getDataBytes()
  {
    return this.dataBytes;
  }

  public int getDataCodingScheme()
  {
    return this.dataCodingScheme;
  }

  public String getDecodedText()
  {
    if (this.decodedText != null)
      return this.decodedText;
    if (this.udData == null)
      throw new NullPointerException("No udData to decode");
    try
    {
      String str = decodeNonUDHDataAsString();
      return str;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  public int getDestPort()
  {
    PortInformationElement localPortInformationElement = getPortInfo();
    if (localPortInformationElement == null)
      return -1;
    return localPortInformationElement.getDestPort();
  }

  public int getFirstOctet()
  {
    return this.firstOctet;
  }

  protected int getFirstOctetField(int paramInt)
  {
    return this.firstOctet & (paramInt ^ 0xFFFFFFFF);
  }

  public InformationElement getInformationElement(int paramInt)
  {
    checkForUDHI(2);
    return (InformationElement)this.ieMap.get(Integer.valueOf(paramInt));
  }

  public Iterator<InformationElement> getInformationElements()
  {
    checkForUDHI(2);
    return this.ieList.iterator();
  }

  public int getMpMaxNo()
  {
    ConcatInformationElement localConcatInformationElement = getConcatInfo();
    if (localConcatInformationElement != null)
      return localConcatInformationElement.getMpMaxNo();
    return 1;
  }

  public int getMpRefNo()
  {
    ConcatInformationElement localConcatInformationElement = getConcatInfo();
    if (localConcatInformationElement != null)
      return localConcatInformationElement.getMpRefNo();
    return 0;
  }

  public int getMpSeqNo()
  {
    ConcatInformationElement localConcatInformationElement = getConcatInfo();
    if (localConcatInformationElement != null)
      return localConcatInformationElement.getMpSeqNo();
    return 0;
  }

  public int getProtocolIdentifier()
  {
    return this.protocolIdentifier;
  }

  public String getRawPdu()
  {
    return this.rawPdu;
  }

  public String getSmscAddress()
  {
    return this.smscAddress;
  }

  public int getSmscAddressType()
  {
    return this.smscAddressType;
  }

  public int getSmscInfoLength()
  {
    return this.smscInfoLength;
  }

  public int getSrcPort()
  {
    PortInformationElement localPortInformationElement = getPortInfo();
    if (localPortInformationElement == null)
      return -1;
    return localPortInformationElement.getSrcPort();
  }

  public int getTotalUDHLength()
  {
    int i = getUDHLength();
    if (i == 0)
      return 0;
    return i + 1;
  }

  public int getTpMti()
  {
    return getFirstOctetField(252);
  }

  public byte[] getUDData()
  {
    return this.udData;
  }

  public byte[] getUDHData()
  {
    checkForUDHI(2);
    int i = getTotalUDHLength();
    if (i == 0)
      return null;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.udData, 0, arrayOfByte, 0, i);
    return arrayOfByte;
  }

  public int getUDHLength()
  {
    Iterator localIterator = this.ieMap.values().iterator();
    for (int i = 0; localIterator.hasNext(); i = 2 + (i + ((InformationElement)localIterator.next()).getLength()));
    return i;
  }

  public int getUDLength()
  {
    return this.udLength;
  }

  public byte[] getUserDataAsBytes()
  {
    int i = this.udData.length - getTotalUDHLength();
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.udData, getTotalUDHLength(), arrayOfByte, 0, i);
    return arrayOfByte;
  }

  public boolean hasTpUdhi()
  {
    return getFirstOctetField(191) == 64;
  }

  public boolean isBinary()
  {
    return (((0xF0 & this.dataCodingScheme) == 240) || ((0x4 & this.dataCodingScheme) == 4)) && ((0x4 & this.dataCodingScheme) == 4);
  }

  public boolean isConcatMessage()
  {
    return getConcatInfo() != null;
  }

  public boolean isPortedMessage()
  {
    return getPortInfo() != null;
  }

  protected String pduSubclassInfo()
  {
    return null;
  }

  public void setAddress(String paramString)
  {
    if (paramString == null)
    {
      this.address = "";
      return;
    }
    if (paramString.startsWith("+"));
    for (this.address = paramString.substring(1); ; this.address = paramString)
    {
      setAddressType(PduUtils.getAddressTypeFor(paramString));
      return;
    }
  }

  public void setAddressType(int paramInt)
  {
    this.addressType = PduUtils.createAddressType(paramInt);
  }

  public void setDataBytes(byte[] paramArrayOfByte)
  {
    this.dataBytes = paramArrayOfByte;
    this.decodedText = null;
  }

  public void setDataCodingScheme(int paramInt)
  {
    switch (paramInt & 0xFFFFFF0C)
    {
    default:
      throw new RuntimeException("Invalid encoding value: " + PduUtils.byteToPdu(paramInt));
    case 0:
    case 4:
    case 8:
    }
    this.dataCodingScheme = paramInt;
  }

  public void setDecodedText(String paramString)
  {
    this.decodedText = paramString;
    this.dataBytes = null;
    int i = PduUtils.extractDcsFlash(this.dataCodingScheme);
    int j = 0;
    if (i == 16)
      j = 1;
    this.dataCodingScheme = (0xF & this.dataCodingScheme);
    if (j != 0)
      this.dataCodingScheme = (0x10 | this.dataCodingScheme);
  }

  public void setFirstOctet(int paramInt)
  {
    this.firstOctet = paramInt;
  }

  protected void setFirstOctetField(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    for (int j = 0; j < i; j++)
      if (paramArrayOfInt[j] == paramInt2)
      {
        this.firstOctet = (paramInt1 & this.firstOctet);
        this.firstOctet = (paramInt2 | this.firstOctet);
        return;
      }
    throw new RuntimeException("Invalid value for fieldName.");
  }

  public void setProtocolIdentifier(int paramInt)
  {
    this.protocolIdentifier = paramInt;
  }

  public void setRawPdu(String paramString)
  {
    this.rawPdu = paramString;
  }

  public void setSmscAddress(String paramString)
  {
    if (paramString.equals(""))
    {
      this.smscAddress = null;
      this.smscAddressType = 0;
      this.smscInfoLength = 0;
      return;
    }
    if (paramString.startsWith("+"))
    {
      this.smscAddress = paramString.substring(1);
      return;
    }
    this.smscAddress = paramString;
  }

  public void setSmscAddressType(int paramInt)
  {
    this.smscAddressType = PduUtils.createAddressType(paramInt);
  }

  public void setSmscInfoLength(int paramInt)
  {
    this.smscInfoLength = paramInt;
  }

  public void setTpMti(int paramInt)
  {
    setFirstOctetField(252, paramInt, new int[] { 0, 2, 1 });
  }

  public void setTpUdhi(int paramInt)
  {
    setFirstOctetField(191, paramInt, new int[] { 0, 64 });
  }

  public void setUDData(byte[] paramArrayOfByte)
  {
    this.udData = paramArrayOfByte;
  }

  public void setUDLength(int paramInt)
  {
    this.udLength = paramInt;
  }

  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("=================================================\n");
    localStringBuffer.append("<< " + getClass().getSimpleName() + " >>");
    localStringBuffer.append("\n");
    localStringBuffer.append("Raw Pdu: ");
    localStringBuffer.append(this.rawPdu);
    localStringBuffer.append("\n");
    localStringBuffer.append("\n");
    if (this.smscAddress != null)
    {
      localStringBuffer.append("SMSC Address: [Length: " + getSmscInfoLength() + " (" + PduUtils.byteToPdu((byte)getSmscInfoLength()) + ") octets");
      localStringBuffer.append(", Type: " + PduUtils.byteToPdu(this.smscAddressType) + " (" + PduUtils.byteToBits((byte)this.smscAddressType) + ")");
      localStringBuffer.append(", Address: " + this.smscAddress);
      localStringBuffer.append("]");
      localStringBuffer.append("\n");
      localStringBuffer.append(PduUtils.decodeFirstOctet(this));
      String str = pduSubclassInfo();
      if (str != null)
        localStringBuffer.append(str);
      localStringBuffer.append("\n");
      if (this.udData == null)
        break label775;
      switch (PduUtils.extractDcsEncoding(getDataCodingScheme()))
      {
      default:
      case 0:
      case 4:
      case 8:
      }
    }
    while (true)
    {
      localStringBuffer.append("User Data (pdu) : " + PduUtils.bytesToPdu(getUDData()));
      localStringBuffer.append("\n");
      if (!hasTpUdhi())
        break label788;
      localStringBuffer.append("User Data Header (pdu) : " + PduUtils.bytesToPdu(getUDHData()));
      localStringBuffer.append("\n");
      int i = getUDHLength();
      localStringBuffer.append("User Data Header Length: " + i + " (" + PduUtils.byteToPdu(i) + ") octets");
      localStringBuffer.append("\n");
      localStringBuffer.append("\n");
      localStringBuffer.append("UDH Information Elements:\n");
      Iterator localIterator = this.ieMap.values().iterator();
      while (localIterator.hasNext())
      {
        localStringBuffer.append(((InformationElement)localIterator.next()).toString());
        localStringBuffer.append("\n");
      }
      localStringBuffer.append("SMSC Address: [Length: 0 octets]");
      break;
      localStringBuffer.append("User Data Length: " + getUDLength() + " (" + PduUtils.byteToPdu(getUDLength()) + ") septets");
      localStringBuffer.append("\n");
      continue;
      localStringBuffer.append("User Data Length: " + getUDLength() + " (" + PduUtils.byteToPdu(getUDLength()) + ") octets");
      localStringBuffer.append("\n");
    }
    localStringBuffer.append("\n");
    localStringBuffer.append("Non UDH Data (pdu)    : " + PduUtils.bytesToPdu(getUserDataAsBytes()));
    localStringBuffer.append("\n");
    if (!isBinary())
    {
      localStringBuffer.append("Non UDH Data (decoded): [" + getDecodedText() + "]");
      localStringBuffer.append("\n");
    }
    while (true)
    {
      label775: localStringBuffer.append("=================================================\n");
      return localStringBuffer.toString();
      label788: if (!isBinary())
      {
        localStringBuffer.append("User Data (decoded): [" + getDecodedText() + "]");
        localStringBuffer.append("\n");
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.ajwcc.pduUtils.gsm3040.Pdu
 * JD-Core Version:    0.6.2
 */