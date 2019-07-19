package org.ajwcc.pduUtils.gsm3040.ie;

public class InformationElementFactory
{
  public static InformationElement createInformationElement(int paramInt, byte[] paramArrayOfByte)
  {
    byte b = (byte)(paramInt & 0xFF);
    switch (b)
    {
    default:
      return new InformationElement(b, paramArrayOfByte);
    case 0:
    case 8:
      return new ConcatInformationElement(b, paramArrayOfByte);
    case 5:
    }
    return new PortInformationElement(b, paramArrayOfByte);
  }

  public static ConcatInformationElement generateConcatInfo(int paramInt1, int paramInt2)
  {
    return new ConcatInformationElement(ConcatInformationElement.getDefaultConcatType(), paramInt1, 1, paramInt2);
  }

  public static ConcatInformationElement generateConcatInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    return new ConcatInformationElement(paramInt1, paramInt2, 1, paramInt3);
  }

  public static PortInformationElement generatePortInfo(int paramInt1, int paramInt2)
  {
    return new PortInformationElement(5, paramInt1, paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.ajwcc.pduUtils.gsm3040.ie.InformationElementFactory
 * JD-Core Version:    0.6.2
 */