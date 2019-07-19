package org.ajwcc.pduUtils.gsm3040.ie;

public class PortInformationElement extends InformationElement
{
  public static final int PORT_16BIT = 5;

  PortInformationElement(byte paramByte, byte[] paramArrayOfByte)
  {
    super(paramByte, paramArrayOfByte);
    if (getIdentifier() != 5)
      throw new RuntimeException("Invalid identifier " + getIdentifier() + " in data in: " + getClass().getSimpleName());
    if (paramArrayOfByte.length != 4)
      throw new RuntimeException("Invalid data length in: " + getClass().getSimpleName());
  }

  PortInformationElement(int paramInt1, int paramInt2, int paramInt3)
  {
    switch (paramInt1)
    {
    default:
      throw new RuntimeException("Invalid identifier for " + getClass().getSimpleName());
    case 5:
    }
    byte[] arrayOfByte = new byte[4];
    arrayOfByte[0] = ((byte)((paramInt2 & 0xFF00) >>> 8));
    arrayOfByte[1] = ((byte)(paramInt2 & 0xFF));
    arrayOfByte[2] = ((byte)((paramInt3 & 0xFF00) >>> 8));
    arrayOfByte[3] = ((byte)(paramInt3 & 0xFF));
    initialize((byte)(paramInt1 & 0xFF), arrayOfByte);
  }

  public int getDestPort()
  {
    byte[] arrayOfByte = getData();
    return (0xFF & arrayOfByte[0]) << 8 | 0xFF & arrayOfByte[1];
  }

  public int getSrcPort()
  {
    byte[] arrayOfByte = getData();
    return (0xFF & arrayOfByte[2]) << 8 | 0xFF & arrayOfByte[3];
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(super.toString());
    localStringBuffer.append("[Dst Port: ");
    localStringBuffer.append(getDestPort());
    localStringBuffer.append(", Src Port: ");
    localStringBuffer.append(getSrcPort());
    localStringBuffer.append("]");
    return localStringBuffer.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.ajwcc.pduUtils.gsm3040.ie.PortInformationElement
 * JD-Core Version:    0.6.2
 */