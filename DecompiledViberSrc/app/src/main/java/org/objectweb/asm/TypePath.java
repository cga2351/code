package org.objectweb.asm;

public class TypePath
{
  public static final int ARRAY_ELEMENT = 0;
  public static final int INNER_TYPE = 1;
  public static final int TYPE_ARGUMENT = 3;
  public static final int WILDCARD_BOUND = 2;
  byte[] a;
  int b;

  TypePath(byte[] paramArrayOfByte, int paramInt)
  {
    this.a = paramArrayOfByte;
    this.b = paramInt;
  }

  public static TypePath fromString(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return null;
    int i = paramString.length();
    ByteVector localByteVector = new ByteVector(i);
    localByteVector.putByte(0);
    int j = 0;
    if (j < i)
    {
      int k = j + 1;
      int m = paramString.charAt(j);
      if (m == 91)
        localByteVector.a(0, 0);
      while (true)
      {
        j = k;
        break;
        if (m == 46)
        {
          localByteVector.a(1, 0);
        }
        else if (m == 42)
        {
          localByteVector.a(2, 0);
        }
        else if ((m >= 48) && (m <= 57))
        {
          int n = m - 48;
          while (k < i)
          {
            int i1 = paramString.charAt(k);
            if ((i1 < 48) || (i1 > 57))
              break;
            n = -48 + (i1 + n * 10);
            k++;
          }
          if ((k < i) && (paramString.charAt(k) == ';'))
            k++;
          localByteVector.a(3, n);
        }
      }
    }
    localByteVector.a[0] = ((byte)(localByteVector.b / 2));
    return new TypePath(localByteVector.a, 0);
  }

  public int getLength()
  {
    return this.a[this.b];
  }

  public int getStep(int paramInt)
  {
    return this.a[(1 + (this.b + paramInt * 2))];
  }

  public int getStepArgument(int paramInt)
  {
    return this.a[(2 + (this.b + paramInt * 2))];
  }

  public String toString()
  {
    int i = getLength();
    StringBuffer localStringBuffer = new StringBuffer(i * 2);
    int j = 0;
    if (j < i)
    {
      switch (getStep(j))
      {
      default:
        localStringBuffer.append('_');
      case 0:
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        j++;
        break;
        localStringBuffer.append('[');
        continue;
        localStringBuffer.append('.');
        continue;
        localStringBuffer.append('*');
        continue;
        localStringBuffer.append(getStepArgument(j)).append(';');
      }
    }
    return localStringBuffer.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objectweb.asm.TypePath
 * JD-Core Version:    0.6.2
 */