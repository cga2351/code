package com.esotericsoftware.reflectasm.shaded.org.objectweb.asm;

import java.io.IOException;
import java.io.InputStream;

public class ClassReader
{
  public static final int EXPAND_FRAMES = 8;
  public static final int SKIP_CODE = 1;
  public static final int SKIP_DEBUG = 2;
  public static final int SKIP_FRAMES = 4;
  private final int[] a;
  public final byte[] b;
  private final String[] c;
  private final int d;
  public final int header;

  public ClassReader(InputStream paramInputStream)
    throws IOException
  {
    this(a(paramInputStream, false));
  }

  public ClassReader(String paramString)
    throws IOException
  {
    this(a(ClassLoader.getSystemResourceAsStream(paramString.replace('.', '/') + ".class"), true));
  }

  public ClassReader(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public ClassReader(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.b = paramArrayOfByte;
    if (readShort(6) > 51)
      throw new IllegalArgumentException();
    this.a = new int[readUnsignedShort(paramInt1 + 8)];
    int i = this.a.length;
    this.c = new String[i];
    int j = 0;
    int k = paramInt1 + 10;
    int m = 1;
    int n = k;
    if (m < i)
    {
      this.a[m] = (n + 1);
      int i1;
      switch (paramArrayOfByte[n])
      {
      case 2:
      case 7:
      case 8:
      case 13:
      case 14:
      case 16:
      case 17:
      default:
        i1 = 3;
      case 3:
      case 4:
      case 9:
      case 10:
      case 11:
      case 12:
      case 18:
      case 5:
      case 6:
      case 1:
      case 15:
      }
      while (true)
      {
        int i2 = i1 + n;
        m++;
        n = i2;
        break;
        i1 = 5;
        continue;
        i1 = 9;
        m++;
        continue;
        i1 = 3 + readUnsignedShort(n + 1);
        if (i1 > j)
        {
          j = i1;
          continue;
          i1 = 4;
        }
      }
    }
    this.d = j;
    this.header = n;
  }

  private int a(int paramInt, char[] paramArrayOfChar, String paramString, AnnotationVisitor paramAnnotationVisitor)
  {
    int i = 0;
    if (paramAnnotationVisitor == null)
    {
      switch (0xFF & this.b[paramInt])
      {
      default:
        return paramInt + 3;
      case 101:
        return paramInt + 5;
      case 64:
        return a(paramInt + 3, paramArrayOfChar, true, null);
      case 91:
      }
      return a(paramInt + 1, paramArrayOfChar, false, null);
    }
    byte[] arrayOfByte1 = this.b;
    int j = paramInt + 1;
    switch (0xFF & arrayOfByte1[paramInt])
    {
    default:
      return j;
    case 68:
    case 70:
    case 73:
    case 74:
      paramAnnotationVisitor.visit(paramString, readConst(readUnsignedShort(j), paramArrayOfChar));
      return j + 2;
    case 66:
      paramAnnotationVisitor.visit(paramString, new Byte((byte)readInt(this.a[readUnsignedShort(j)])));
      return j + 2;
    case 90:
      if (readInt(this.a[readUnsignedShort(j)]) == 0);
      for (Boolean localBoolean = Boolean.FALSE; ; localBoolean = Boolean.TRUE)
      {
        paramAnnotationVisitor.visit(paramString, localBoolean);
        return j + 2;
      }
    case 83:
      paramAnnotationVisitor.visit(paramString, new Short((short)readInt(this.a[readUnsignedShort(j)])));
      return j + 2;
    case 67:
      paramAnnotationVisitor.visit(paramString, new Character((char)readInt(this.a[readUnsignedShort(j)])));
      return j + 2;
    case 115:
      paramAnnotationVisitor.visit(paramString, readUTF8(j, paramArrayOfChar));
      return j + 2;
    case 101:
      paramAnnotationVisitor.visitEnum(paramString, readUTF8(j, paramArrayOfChar), readUTF8(j + 2, paramArrayOfChar));
      return j + 4;
    case 99:
      paramAnnotationVisitor.visit(paramString, Type.getType(readUTF8(j, paramArrayOfChar)));
      return j + 2;
    case 64:
      return a(j + 2, paramArrayOfChar, true, paramAnnotationVisitor.visitAnnotation(paramString, readUTF8(j, paramArrayOfChar)));
    case 91:
    }
    int k = readUnsignedShort(j);
    int m = j + 2;
    if (k == 0)
      return a(m - 2, paramArrayOfChar, false, paramAnnotationVisitor.visitArray(paramString));
    byte[] arrayOfByte2 = this.b;
    int n = m + 1;
    switch (0xFF & arrayOfByte2[m])
    {
    default:
      return a(n - 3, paramArrayOfChar, false, paramAnnotationVisitor.visitArray(paramString));
    case 66:
      byte[] arrayOfByte3 = new byte[k];
      while (i < k)
      {
        arrayOfByte3[i] = ((byte)readInt(this.a[readUnsignedShort(n)]));
        n += 3;
        i++;
      }
      paramAnnotationVisitor.visit(paramString, arrayOfByte3);
      return n - 1;
    case 90:
      boolean[] arrayOfBoolean = new boolean[k];
      int i1 = 0;
      int i2 = n;
      if (i1 < k)
      {
        if (readInt(this.a[readUnsignedShort(i2)]) != 0);
        for (int i3 = 1; ; i3 = 0)
        {
          arrayOfBoolean[i1] = i3;
          i2 += 3;
          i1++;
          break;
        }
      }
      paramAnnotationVisitor.visit(paramString, arrayOfBoolean);
      return i2 - 1;
    case 83:
      short[] arrayOfShort = new short[k];
      while (i < k)
      {
        arrayOfShort[i] = ((short)readInt(this.a[readUnsignedShort(n)]));
        n += 3;
        i++;
      }
      paramAnnotationVisitor.visit(paramString, arrayOfShort);
      return n - 1;
    case 67:
      char[] arrayOfChar = new char[k];
      while (i < k)
      {
        arrayOfChar[i] = ((char)readInt(this.a[readUnsignedShort(n)]));
        n += 3;
        i++;
      }
      paramAnnotationVisitor.visit(paramString, arrayOfChar);
      return n - 1;
    case 73:
      int[] arrayOfInt = new int[k];
      while (i < k)
      {
        arrayOfInt[i] = readInt(this.a[readUnsignedShort(n)]);
        n += 3;
        i++;
      }
      paramAnnotationVisitor.visit(paramString, arrayOfInt);
      return n - 1;
    case 74:
      long[] arrayOfLong = new long[k];
      while (i < k)
      {
        arrayOfLong[i] = readLong(this.a[readUnsignedShort(n)]);
        n += 3;
        i++;
      }
      paramAnnotationVisitor.visit(paramString, arrayOfLong);
      return n - 1;
    case 70:
      float[] arrayOfFloat = new float[k];
      while (i < k)
      {
        arrayOfFloat[i] = Float.intBitsToFloat(readInt(this.a[readUnsignedShort(n)]));
        n += 3;
        i++;
      }
      paramAnnotationVisitor.visit(paramString, arrayOfFloat);
      return n - 1;
    case 68:
    }
    double[] arrayOfDouble = new double[k];
    while (i < k)
    {
      arrayOfDouble[i] = Double.longBitsToDouble(readLong(this.a[readUnsignedShort(n)]));
      n += 3;
      i++;
    }
    paramAnnotationVisitor.visit(paramString, arrayOfDouble);
    return n - 1;
  }

  private int a(int paramInt, char[] paramArrayOfChar, boolean paramBoolean, AnnotationVisitor paramAnnotationVisitor)
  {
    int i = readUnsignedShort(paramInt);
    int j = paramInt + 2;
    int k;
    if (paramBoolean)
    {
      k = j;
      int i1 = i;
      while (i1 > 0)
      {
        int i2 = a(k + 2, paramArrayOfChar, readUTF8(k, paramArrayOfChar), paramAnnotationVisitor);
        i1--;
        k = i2;
      }
    }
    while (true)
    {
      int m;
      if (m > 0)
      {
        int n = a(k, paramArrayOfChar, null, paramAnnotationVisitor);
        m--;
        k = n;
      }
      else
      {
        if (paramAnnotationVisitor != null)
          paramAnnotationVisitor.visitEnd();
        return k;
        k = j;
        m = i;
      }
    }
  }

  private int a(Object[] paramArrayOfObject, int paramInt1, int paramInt2, char[] paramArrayOfChar, Label[] paramArrayOfLabel)
  {
    byte[] arrayOfByte = this.b;
    int i = paramInt2 + 1;
    switch (0xFF & arrayOfByte[paramInt2])
    {
    default:
      paramArrayOfObject[paramInt1] = readLabel(readUnsignedShort(i), paramArrayOfLabel);
      return i + 2;
    case 0:
      paramArrayOfObject[paramInt1] = Opcodes.TOP;
      return i;
    case 1:
      paramArrayOfObject[paramInt1] = Opcodes.INTEGER;
      return i;
    case 2:
      paramArrayOfObject[paramInt1] = Opcodes.FLOAT;
      return i;
    case 3:
      paramArrayOfObject[paramInt1] = Opcodes.DOUBLE;
      return i;
    case 4:
      paramArrayOfObject[paramInt1] = Opcodes.LONG;
      return i;
    case 5:
      paramArrayOfObject[paramInt1] = Opcodes.NULL;
      return i;
    case 6:
      paramArrayOfObject[paramInt1] = Opcodes.UNINITIALIZED_THIS;
      return i;
    case 7:
    }
    paramArrayOfObject[paramInt1] = readClass(i, paramArrayOfChar);
    return i + 2;
  }

  private Attribute a(Attribute[] paramArrayOfAttribute, String paramString, int paramInt1, int paramInt2, char[] paramArrayOfChar, int paramInt3, Label[] paramArrayOfLabel)
  {
    for (int i = 0; i < paramArrayOfAttribute.length; i++)
      if (paramArrayOfAttribute[i].type.equals(paramString))
        return paramArrayOfAttribute[i].read(this, paramInt1, paramInt2, paramArrayOfChar, paramInt3, paramArrayOfLabel);
    return new Attribute(paramString).read(this, paramInt1, paramInt2, null, -1, null);
  }

  private String a(int paramInt1, int paramInt2, char[] paramArrayOfChar)
  {
    int i = paramInt1 + paramInt2;
    byte[] arrayOfByte = this.b;
    int j = 0;
    int k = 0;
    int m = 0;
    if (paramInt1 < i)
    {
      int n = paramInt1 + 1;
      int i1 = arrayOfByte[paramInt1];
      int i2;
      switch (k)
      {
      default:
        i2 = m;
      case 0:
      case 1:
      case 2:
      }
      while (true)
      {
        m = i2;
        paramInt1 = n;
        break;
        int i4 = i1 & 0xFF;
        if (i4 < 128)
        {
          i2 = m + 1;
          paramArrayOfChar[m] = ((char)i4);
        }
        else if ((i4 < 224) && (i4 > 191))
        {
          j = (char)(i4 & 0x1F);
          k = 1;
          i2 = m;
        }
        else
        {
          j = (char)(i4 & 0xF);
          k = 2;
          i2 = m;
          continue;
          int i3 = m + 1;
          paramArrayOfChar[m] = ((char)(j << 6 | i1 & 0x3F));
          i2 = i3;
          k = 0;
          continue;
          j = (char)(j << 6 | i1 & 0x3F);
          k = 1;
          i2 = m;
        }
      }
    }
    return new String(paramArrayOfChar, 0, m);
  }

  private void a(int paramInt, String paramString, char[] paramArrayOfChar, boolean paramBoolean, MethodVisitor paramMethodVisitor)
  {
    byte[] arrayOfByte = this.b;
    int i = paramInt + 1;
    int j = 0xFF & arrayOfByte[paramInt];
    int k = Type.getArgumentTypes(paramString).length - j;
    int m = 0;
    int n;
    while (m < k)
    {
      AnnotationVisitor localAnnotationVisitor2 = paramMethodVisitor.visitParameterAnnotation(m, "Ljava/lang/Synthetic;", false);
      if (localAnnotationVisitor2 != null)
        localAnnotationVisitor2.visitEnd();
      m++;
      continue;
      n++;
    }
    while (true)
    {
      if (n < j + k)
      {
        int i1 = readUnsignedShort(i);
        i += 2;
        while (i1 > 0)
        {
          AnnotationVisitor localAnnotationVisitor1 = paramMethodVisitor.visitParameterAnnotation(n, readUTF8(i, paramArrayOfChar), paramBoolean);
          i = a(i + 2, paramArrayOfChar, true, localAnnotationVisitor1);
          i1--;
        }
        break;
      }
      return;
      n = m;
    }
  }

  private void a(ClassWriter paramClassWriter, Item[] paramArrayOfItem, char[] paramArrayOfChar)
  {
    int i = this.header;
    int j = i + (8 + (readUnsignedShort(i + 6) << 1));
    int k = readUnsignedShort(j);
    int m = j + 2;
    for (int n = k; n > 0; n--)
    {
      int i17 = readUnsignedShort(m + 6);
      m += 8;
      while (i17 > 0)
      {
        m += 6 + readInt(m + 2);
        i17--;
      }
    }
    int i1 = readUnsignedShort(m);
    int i2 = m + 2;
    for (int i3 = i1; i3 > 0; i3--)
    {
      int i16 = readUnsignedShort(i2 + 6);
      i2 += 8;
      while (i16 > 0)
      {
        i2 += 6 + readInt(i2 + 2);
        i16--;
      }
    }
    int i4 = readUnsignedShort(i2);
    int i7;
    for (int i5 = i2 + 2; ; i5 = i7)
    {
      int i6;
      if (i4 > 0)
      {
        String str = readUTF8(i5, paramArrayOfChar);
        i6 = readInt(i5 + 2);
        if ("BootstrapMethods".equals(str))
        {
          int i8 = readUnsignedShort(i5 + 6);
          int i9 = i5 + 8;
          int i15;
          for (int i10 = 0; i10 < i8; i10 = i15)
          {
            int i11 = readConst(readUnsignedShort(i9), paramArrayOfChar).hashCode();
            int i12 = readUnsignedShort(i9 + 2);
            int i13 = i9 + 4;
            while (i12 > 0)
            {
              i11 ^= readConst(readUnsignedShort(i13), paramArrayOfChar).hashCode();
              i13 += 2;
              i12--;
            }
            Item localItem = new Item(i10);
            localItem.a(-8 + (i9 - i5), i11 & 0x7FFFFFFF);
            int i14 = localItem.j % paramArrayOfItem.length;
            localItem.k = paramArrayOfItem[i14];
            paramArrayOfItem[i14] = localItem;
            i15 = i10 + 1;
            i9 = i13;
          }
          paramClassWriter.z = i8;
          ByteVector localByteVector = new ByteVector(i6 + 62);
          localByteVector.putByteArray(this.b, i5 + 8, i6 - 2);
          paramClassWriter.A = localByteVector;
        }
      }
      else
      {
        return;
      }
      i7 = i5 + (i6 + 6);
      i4--;
    }
  }

  private static byte[] a(InputStream paramInputStream, boolean paramBoolean)
    throws IOException
  {
    if (paramInputStream == null)
      throw new IOException("Class not found");
    while (true)
    {
      Object localObject2;
      int k;
      try
      {
        localObject2 = new byte[paramInputStream.available()];
        int i = 0;
        int j = paramInputStream.read((byte[])localObject2, i, localObject2.length - i);
        if (j == -1)
        {
          if (i >= localObject2.length)
            break label176;
          localObject3 = new byte[i];
          System.arraycopy(localObject2, 0, localObject3, 0, i);
          return localObject3;
        }
        k = i + j;
        if (k == localObject2.length)
        {
          int n = paramInputStream.read();
          if (n < 0)
            return localObject2;
          byte[] arrayOfByte = new byte[1000 + localObject2.length];
          System.arraycopy(localObject2, 0, arrayOfByte, 0, k);
          m = k + 1;
          arrayOfByte[k] = ((byte)n);
          localObject2 = arrayOfByte;
          i = m;
          continue;
        }
      }
      finally
      {
        if (paramBoolean)
          paramInputStream.close();
      }
      int m = k;
      continue;
      label176: Object localObject3 = localObject2;
    }
  }

  void a(ClassWriter paramClassWriter)
  {
    char[] arrayOfChar = new char[this.d];
    int i = this.a.length;
    Item[] arrayOfItem = new Item[i];
    int j = 1;
    if (j < i)
    {
      int m = this.a[j];
      int n = this.b[(m - 1)];
      Item localItem = new Item(j);
      int i2;
      switch (n)
      {
      case 2:
      case 7:
      case 8:
      case 13:
      case 14:
      case 16:
      case 17:
      default:
        localItem.a(n, readUTF8(m, arrayOfChar), null, null);
        i2 = j;
      case 9:
      case 10:
      case 11:
      case 3:
      case 4:
      case 12:
      case 5:
      case 6:
      case 1:
      case 15:
      case 18:
      }
      while (true)
      {
        int i3 = localItem.j % arrayOfItem.length;
        localItem.k = arrayOfItem[i3];
        arrayOfItem[i3] = localItem;
        j = i2 + 1;
        break;
        int i7 = this.a[readUnsignedShort(m + 2)];
        localItem.a(n, readClass(m, arrayOfChar), readUTF8(i7, arrayOfChar), readUTF8(i7 + 2, arrayOfChar));
        i2 = j;
        continue;
        localItem.a(readInt(m));
        i2 = j;
        continue;
        localItem.a(Float.intBitsToFloat(readInt(m)));
        i2 = j;
        continue;
        localItem.a(n, readUTF8(m, arrayOfChar), readUTF8(m + 2, arrayOfChar), null);
        i2 = j;
        continue;
        localItem.a(readLong(m));
        i2 = j + 1;
        continue;
        localItem.a(Double.longBitsToDouble(readLong(m)));
        i2 = j + 1;
        continue;
        String str = this.c[j];
        if (str == null)
        {
          int i6 = this.a[j];
          String[] arrayOfString = this.c;
          str = a(i6 + 2, readUnsignedShort(i6), arrayOfChar);
          arrayOfString[j] = str;
        }
        localItem.a(n, str, null, null);
        i2 = j;
        continue;
        int i4 = this.a[readUnsignedShort(m + 1)];
        int i5 = this.a[readUnsignedShort(i4 + 2)];
        localItem.a(20 + readByte(m), readClass(i4, arrayOfChar), readUTF8(i5, arrayOfChar), readUTF8(i5 + 2, arrayOfChar));
        i2 = j;
        continue;
        if (paramClassWriter.A == null)
          a(paramClassWriter, arrayOfItem, arrayOfChar);
        int i1 = this.a[readUnsignedShort(m + 2)];
        localItem.a(readUTF8(i1, arrayOfChar), readUTF8(i1 + 2, arrayOfChar), readUnsignedShort(m));
        i2 = j;
      }
    }
    int k = -1 + this.a[1];
    paramClassWriter.d.putByteArray(this.b, k, this.header - k);
    paramClassWriter.e = arrayOfItem;
    paramClassWriter.f = ((int)(0.75D * i));
    paramClassWriter.c = i;
  }

  public void accept(ClassVisitor paramClassVisitor, int paramInt)
  {
    accept(paramClassVisitor, new Attribute[0], paramInt);
  }

  public void accept(ClassVisitor paramClassVisitor, Attribute[] paramArrayOfAttribute, int paramInt)
  {
    byte[] arrayOfByte = this.b;
    char[] arrayOfChar = new char[this.d];
    int i = 0;
    int j = 0;
    Object localObject1 = null;
    int k = this.header;
    int m = readUnsignedShort(k);
    String str = readClass(k + 2, arrayOfChar);
    int n = this.a[readUnsignedShort(k + 4)];
    if (n == 0)
    {
      Object localObject2 = null;
      String[] arrayOfString = new String[readUnsignedShort(k + 6)];
      int i1 = 0;
      int i2 = k + 8;
      int i3 = 0;
      int i4 = i2;
      if (i3 >= arrayOfString.length)
        break label157;
      arrayOfString[i3] = readClass(i4, arrayOfChar);
      int i5 = i4 + 2;
    }
  }

  public int getAccess()
  {
    return readUnsignedShort(this.header);
  }

  public String getClassName()
  {
    return readClass(2 + this.header, new char[this.d]);
  }

  public String[] getInterfaces()
  {
    int i = 6 + this.header;
    int j = readUnsignedShort(i);
    String[] arrayOfString = new String[j];
    if (j > 0)
    {
      char[] arrayOfChar = new char[this.d];
      for (int k = 0; k < j; k++)
      {
        i += 2;
        arrayOfString[k] = readClass(i, arrayOfChar);
      }
    }
    return arrayOfString;
  }

  public int getItem(int paramInt)
  {
    return this.a[paramInt];
  }

  public int getItemCount()
  {
    return this.a.length;
  }

  public int getMaxStringLength()
  {
    return this.d;
  }

  public String getSuperName()
  {
    int i = this.a[readUnsignedShort(4 + this.header)];
    if (i == 0)
      return null;
    return readUTF8(i, new char[this.d]);
  }

  public int readByte(int paramInt)
  {
    return 0xFF & this.b[paramInt];
  }

  public String readClass(int paramInt, char[] paramArrayOfChar)
  {
    return readUTF8(this.a[readUnsignedShort(paramInt)], paramArrayOfChar);
  }

  public Object readConst(int paramInt, char[] paramArrayOfChar)
  {
    int i = this.a[paramInt];
    switch (this.b[(i - 1)])
    {
    case 9:
    case 10:
    case 11:
    case 12:
    case 13:
    case 14:
    case 15:
    default:
      int j = readByte(i);
      int[] arrayOfInt = this.a;
      int k = arrayOfInt[readUnsignedShort(i + 1)];
      String str = readClass(k, paramArrayOfChar);
      int m = arrayOfInt[readUnsignedShort(k + 2)];
      return new Handle(j, str, readUTF8(m, paramArrayOfChar), readUTF8(m + 2, paramArrayOfChar));
    case 3:
      return new Integer(readInt(i));
    case 4:
      return new Float(Float.intBitsToFloat(readInt(i)));
    case 5:
      return new Long(readLong(i));
    case 6:
      return new Double(Double.longBitsToDouble(readLong(i)));
    case 7:
      return Type.getObjectType(readUTF8(i, paramArrayOfChar));
    case 8:
      return readUTF8(i, paramArrayOfChar);
    case 16:
    }
    return Type.getMethodType(readUTF8(i, paramArrayOfChar));
  }

  public int readInt(int paramInt)
  {
    byte[] arrayOfByte = this.b;
    return (0xFF & arrayOfByte[paramInt]) << 24 | (0xFF & arrayOfByte[(paramInt + 1)]) << 16 | (0xFF & arrayOfByte[(paramInt + 2)]) << 8 | 0xFF & arrayOfByte[(paramInt + 3)];
  }

  protected Label readLabel(int paramInt, Label[] paramArrayOfLabel)
  {
    if (paramArrayOfLabel[paramInt] == null)
      paramArrayOfLabel[paramInt] = new Label();
    return paramArrayOfLabel[paramInt];
  }

  public long readLong(int paramInt)
  {
    long l = readInt(paramInt);
    return 0xFFFFFFFF & readInt(paramInt + 4) | l << 32;
  }

  public short readShort(int paramInt)
  {
    byte[] arrayOfByte = this.b;
    return (short)((0xFF & arrayOfByte[paramInt]) << 8 | 0xFF & arrayOfByte[(paramInt + 1)]);
  }

  public String readUTF8(int paramInt, char[] paramArrayOfChar)
  {
    int i = readUnsignedShort(paramInt);
    String str1 = this.c[i];
    if (str1 != null)
      return str1;
    int j = this.a[i];
    String[] arrayOfString = this.c;
    String str2 = a(j + 2, readUnsignedShort(j), paramArrayOfChar);
    arrayOfString[i] = str2;
    return str2;
  }

  public int readUnsignedShort(int paramInt)
  {
    byte[] arrayOfByte = this.b;
    return (0xFF & arrayOfByte[paramInt]) << 8 | 0xFF & arrayOfByte[(paramInt + 1)];
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.reflectasm.shaded.org.objectweb.asm.ClassReader
 * JD-Core Version:    0.6.2
 */