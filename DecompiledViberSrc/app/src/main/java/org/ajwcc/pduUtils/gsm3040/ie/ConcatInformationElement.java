package org.ajwcc.pduUtils.gsm3040.ie;

public class ConcatInformationElement extends InformationElement
{
  public static final int CONCAT_16BIT_REF = 8;
  public static final int CONCAT_8BIT_REF = 0;
  private static final int CONCAT_IE_LENGTH_16BIT = 6;
  private static final int CONCAT_IE_LENGTH_8BIT = 5;
  private static int defaultConcatLength = 5;
  private static int defaultConcatType = 0;

  ConcatInformationElement(byte paramByte, byte[] paramArrayOfByte)
  {
    super(paramByte, paramArrayOfByte);
    if (getIdentifier() == 0)
    {
      if (paramArrayOfByte.length != 3)
        throw new RuntimeException("Invalid data length in: " + getClass().getSimpleName());
    }
    else if (getIdentifier() == 8)
    {
      if (paramArrayOfByte.length != 4)
        throw new RuntimeException("Invalid data length in: " + getClass().getSimpleName());
    }
    else
      throw new RuntimeException("Invalid identifier in data in: " + getClass().getSimpleName());
    validate();
  }

  ConcatInformationElement(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    byte[] arrayOfByte;
    switch (paramInt1)
    {
    default:
      throw new RuntimeException("Invalid identifier for " + getClass().getSimpleName());
    case 0:
      arrayOfByte = new byte[3];
      arrayOfByte[0] = ((byte)(paramInt2 & 0xFF));
      arrayOfByte[1] = ((byte)(paramInt3 & 0xFF));
      arrayOfByte[2] = ((byte)(paramInt4 & 0xFF));
    case 8:
    }
    while (true)
    {
      initialize((byte)(paramInt1 & 0xFF), arrayOfByte);
      validate();
      return;
      arrayOfByte = new byte[4];
      arrayOfByte[0] = ((byte)((0xFF00 & paramInt2) >>> 8));
      arrayOfByte[1] = ((byte)(paramInt2 & 0xFF));
      arrayOfByte[2] = ((byte)(paramInt3 & 0xFF));
      arrayOfByte[3] = ((byte)(paramInt4 & 0xFF));
    }
  }

  public static int getDefaultConcatLength()
  {
    return defaultConcatLength;
  }

  public static int getDefaultConcatType()
  {
    return defaultConcatType;
  }

  public static void setDefaultConcatType(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new RuntimeException("Invalid Concat type");
    case 0:
      defaultConcatType = 0;
      defaultConcatLength = 5;
      return;
    case 8:
    }
    defaultConcatType = 8;
    defaultConcatLength = 6;
  }

  private void validate()
  {
    if (getMpMaxNo() == 0)
      throw new RuntimeException("mpMaxNo must be > 0");
    if (getMpSeqNo() == 0)
      throw new RuntimeException("mpSeqNo must be > 0");
  }

  public int getMpMaxNo()
  {
    byte[] arrayOfByte = getData();
    if (getIdentifier() == 0)
      return 0xFF & arrayOfByte[1];
    if (getIdentifier() == 8)
      return 0xFF & arrayOfByte[2];
    throw new RuntimeException("Invalid identifier");
  }

  public int getMpRefNo()
  {
    byte[] arrayOfByte = getData();
    if (getIdentifier() == 0)
      return 0xFF & arrayOfByte[0];
    if (getIdentifier() == 8)
      return 0xFFFF & (arrayOfByte[0] << 8 | arrayOfByte[1]);
    throw new RuntimeException("Invalid identifier");
  }

  public int getMpSeqNo()
  {
    byte[] arrayOfByte = getData();
    if (getIdentifier() == 0)
      return 0xFF & arrayOfByte[2];
    if (getIdentifier() == 8)
      return 0xFF & arrayOfByte[3];
    throw new RuntimeException("Invalid identifier");
  }

  public void setMpMaxNo(int paramInt)
  {
    byte[] arrayOfByte = getData();
    if (getIdentifier() == 0)
    {
      arrayOfByte[1] = ((byte)(paramInt & 0xFF));
      return;
    }
    if (getIdentifier() == 8)
    {
      arrayOfByte[2] = ((byte)(paramInt & 0xFF));
      return;
    }
    throw new RuntimeException("Invalid identifier");
  }

  public void setMpRefNo(int paramInt)
  {
    byte[] arrayOfByte = getData();
    if (getIdentifier() == 0)
    {
      arrayOfByte[0] = ((byte)(paramInt & 0xFF));
      return;
    }
    if (getIdentifier() == 8)
    {
      arrayOfByte[0] = ((byte)(0xFF & paramInt >>> 8));
      arrayOfByte[1] = ((byte)(paramInt & 0xFF));
      return;
    }
    throw new RuntimeException("Invalid identifier");
  }

  public void setMpSeqNo(int paramInt)
  {
    byte[] arrayOfByte = getData();
    if (getIdentifier() == 0)
    {
      arrayOfByte[2] = ((byte)(paramInt & 0xFF));
      return;
    }
    if (getIdentifier() == 8)
    {
      arrayOfByte[3] = ((byte)(paramInt & 0xFF));
      return;
    }
    throw new RuntimeException("Invalid identifier");
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(super.toString());
    localStringBuffer.append("[MpRefNo: ");
    localStringBuffer.append(getMpRefNo());
    localStringBuffer.append(", MpMaxNo: ");
    localStringBuffer.append(getMpMaxNo());
    localStringBuffer.append(", MpSeqNo: ");
    localStringBuffer.append(getMpSeqNo());
    localStringBuffer.append("]");
    return localStringBuffer.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.ajwcc.pduUtils.gsm3040.ie.ConcatInformationElement
 * JD-Core Version:    0.6.2
 */