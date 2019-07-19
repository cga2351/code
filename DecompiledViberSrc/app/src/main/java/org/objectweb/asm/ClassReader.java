package org.objectweb.asm;

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
    if (readShort(paramInt1 + 6) > 52)
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

  private int a()
  {
    int i = 8 + this.header + 2 * readUnsignedShort(6 + this.header);
    for (int j = readUnsignedShort(i); j > 0; j--)
    {
      for (int i1 = readUnsignedShort(i + 8); i1 > 0; i1--)
        i += 6 + readInt(i + 12);
      i += 8;
    }
    int k = i + 2;
    for (int m = readUnsignedShort(k); m > 0; m--)
    {
      for (int n = readUnsignedShort(k + 8); n > 0; n--)
        k += 6 + readInt(k + 12);
      k += 8;
    }
    return k + 2;
  }

  private int a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, Context paramContext)
  {
    char[] arrayOfChar = paramContext.c;
    Label[] arrayOfLabel = paramContext.h;
    int j;
    int i;
    if (paramBoolean1)
    {
      byte[] arrayOfByte = this.b;
      j = paramInt + 1;
      i = 0xFF & arrayOfByte[paramInt];
      paramContext.r = 0;
      if (i >= 64)
        break label111;
      paramContext.p = 3;
      paramContext.t = 0;
    }
    while (true)
    {
      paramContext.o += i + 1;
      readLabel(paramContext.o, arrayOfLabel);
      return j;
      paramContext.o = -1;
      i = 255;
      j = paramInt;
      break;
      label111: if (i < 128)
      {
        i -= 64;
        j = a(paramContext.u, 0, j, arrayOfChar, arrayOfLabel);
        paramContext.p = 4;
        paramContext.t = 1;
      }
      else
      {
        int k = readUnsignedShort(j);
        j += 2;
        if (i == 247)
        {
          j = a(paramContext.u, 0, j, arrayOfChar, arrayOfLabel);
          paramContext.p = 4;
          paramContext.t = 1;
          i = k;
        }
        else if ((i >= 248) && (i < 251))
        {
          paramContext.p = 2;
          paramContext.r = (251 - i);
          paramContext.q -= paramContext.r;
          paramContext.t = 0;
          i = k;
        }
        else if (i == 251)
        {
          paramContext.p = 3;
          paramContext.t = 0;
          i = k;
        }
        else if (i < 255)
        {
          if (paramBoolean2);
          for (int i10 = paramContext.q; ; i10 = 0)
          {
            int i11 = i - 251;
            int i13;
            for (int i12 = i10; i11 > 0; i12 = i13)
            {
              Object[] arrayOfObject3 = paramContext.s;
              i13 = i12 + 1;
              j = a(arrayOfObject3, i12, j, arrayOfChar, arrayOfLabel);
              i11--;
            }
          }
          paramContext.p = 1;
          paramContext.r = (i - 251);
          paramContext.q += paramContext.r;
          paramContext.t = 0;
          i = k;
        }
        else
        {
          paramContext.p = 0;
          int m = readUnsignedShort(j);
          int n = j + 2;
          paramContext.r = m;
          paramContext.q = m;
          int i1 = 0;
          int i9;
          for (int i2 = m; i2 > 0; i2 = i9)
          {
            Object[] arrayOfObject2 = paramContext.s;
            int i8 = i1 + 1;
            n = a(arrayOfObject2, i1, n, arrayOfChar, arrayOfLabel);
            i9 = i2 - 1;
            i1 = i8;
          }
          int i3 = readUnsignedShort(n);
          j = n + 2;
          paramContext.t = i3;
          int i4 = 0;
          int i7;
          for (int i5 = i3; i5 > 0; i5 = i7)
          {
            Object[] arrayOfObject1 = paramContext.u;
            int i6 = i4 + 1;
            j = a(arrayOfObject1, i4, j, arrayOfChar, arrayOfLabel);
            i7 = i5 - 1;
            i4 = i6;
          }
          i = k;
        }
      }
    }
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

  private int a(ClassVisitor paramClassVisitor, Context paramContext, int paramInt)
  {
    char[] arrayOfChar = paramContext.c;
    int i = readUnsignedShort(paramInt);
    String str1 = readUTF8(paramInt + 2, arrayOfChar);
    String str2 = readUTF8(paramInt + 4, arrayOfChar);
    int j = paramInt + 6;
    String str3 = null;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    Object localObject1 = null;
    Object localObject2 = null;
    int i2 = readUnsignedShort(j);
    int i3 = j;
    String str4;
    int i26;
    label120: Object localObject3;
    int i15;
    int i16;
    int i17;
    int i18;
    int i19;
    if (i2 > 0)
    {
      str4 = readUTF8(i3 + 2, arrayOfChar);
      if ("ConstantValue".equals(str4))
      {
        i26 = readUnsignedShort(i3 + 8);
        if (i26 == 0)
        {
          localObject1 = null;
          localObject3 = localObject2;
          i15 = i1;
          i16 = n;
          i17 = m;
          i18 = k;
          i19 = i;
        }
      }
    }
    while (true)
    {
      int i20 = i3 + (6 + readInt(i3 + 4));
      i2--;
      i1 = i15;
      n = i16;
      m = i17;
      k = i18;
      i = i19;
      i3 = i20;
      localObject2 = localObject3;
      break;
      localObject1 = readConst(i26, arrayOfChar);
      break label120;
      if ("Signature".equals(str4))
      {
        str3 = readUTF8(i3 + 8, arrayOfChar);
        localObject3 = localObject2;
        i15 = i1;
        i16 = n;
        i17 = m;
        i18 = k;
        i19 = i;
      }
      else if ("Deprecated".equals(str4))
      {
        int i25 = 0x20000 | i;
        i15 = i1;
        i16 = n;
        i17 = m;
        i18 = k;
        i19 = i25;
        localObject3 = localObject2;
      }
      else if ("Synthetic".equals(str4))
      {
        int i24 = 0x41000 | i;
        i15 = i1;
        i16 = n;
        i17 = m;
        i18 = k;
        i19 = i24;
        localObject3 = localObject2;
      }
      else if ("RuntimeVisibleAnnotations".equals(str4))
      {
        int i23 = i3 + 8;
        i15 = i1;
        i16 = n;
        i17 = m;
        i18 = i23;
        i19 = i;
        localObject3 = localObject2;
      }
      else if ("RuntimeVisibleTypeAnnotations".equals(str4))
      {
        int i22 = i3 + 8;
        i15 = i1;
        i16 = i22;
        i17 = m;
        i18 = k;
        i19 = i;
        localObject3 = localObject2;
      }
      else if ("RuntimeInvisibleAnnotations".equals(str4))
      {
        int i21 = i3 + 8;
        i15 = i1;
        i16 = n;
        i17 = i21;
        i18 = k;
        i19 = i;
        localObject3 = localObject2;
      }
      else if ("RuntimeInvisibleTypeAnnotations".equals(str4))
      {
        i15 = i3 + 8;
        i16 = n;
        i17 = m;
        i18 = k;
        i19 = i;
        localObject3 = localObject2;
      }
      else
      {
        localObject3 = a(paramContext.a, str4, i3 + 8, readInt(i3 + 4), arrayOfChar, -1, null);
        if (localObject3 != null)
        {
          ((Attribute)localObject3).a = localObject2;
          i15 = i1;
          i16 = n;
          i17 = m;
          i18 = k;
          i19 = i;
          continue;
          int i4 = i3 + 2;
          FieldVisitor localFieldVisitor = paramClassVisitor.visitField(i, str1, str2, str3, localObject1);
          if (localFieldVisitor == null)
            return i4;
          if (k != 0)
          {
            int i13 = readUnsignedShort(k);
            int i14 = k + 2;
            while (i13 > 0)
            {
              i14 = a(i14 + 2, arrayOfChar, true, localFieldVisitor.visitAnnotation(readUTF8(i14, arrayOfChar), true));
              i13--;
            }
          }
          if (m != 0)
          {
            int i11 = readUnsignedShort(m);
            int i12 = m + 2;
            while (i11 > 0)
            {
              i12 = a(i12 + 2, arrayOfChar, true, localFieldVisitor.visitAnnotation(readUTF8(i12, arrayOfChar), false));
              i11--;
            }
          }
          if (n != 0)
          {
            int i8 = readUnsignedShort(n);
            int i9 = n + 2;
            while (i8 > 0)
            {
              int i10 = a(paramContext, i9);
              i9 = a(i10 + 2, arrayOfChar, true, localFieldVisitor.visitTypeAnnotation(paramContext.i, paramContext.j, readUTF8(i10, arrayOfChar), true));
              i8--;
            }
          }
          if (i1 != 0)
          {
            int i5 = readUnsignedShort(i1);
            int i6 = i1 + 2;
            while (i5 > 0)
            {
              int i7 = a(paramContext, i6);
              i6 = a(i7 + 2, arrayOfChar, true, localFieldVisitor.visitTypeAnnotation(paramContext.i, paramContext.j, readUTF8(i7, arrayOfChar), false));
              i5--;
            }
          }
          while (localObject2 != null)
          {
            Attribute localAttribute = localObject2.a;
            localObject2.a = null;
            localFieldVisitor.visitAttribute(localObject2);
            localObject2 = localAttribute;
          }
          localFieldVisitor.visitEnd();
          return i4;
        }
        else
        {
          localObject3 = localObject2;
          i15 = i1;
          i16 = n;
          i17 = m;
          i18 = k;
          i19 = i;
        }
      }
    }
  }

  private int a(Context paramContext, int paramInt)
  {
    int i = -16777216;
    int j = readInt(paramInt);
    int k;
    int m;
    int n;
    switch (j >>> 24)
    {
    default:
      if (j >>> 24 < 67)
        i = -256;
      k = i & j;
      m = paramInt + 3;
      n = readByte(m);
      paramContext.i = k;
      if (n != 0)
        break;
    case 0:
    case 1:
    case 22:
    case 19:
    case 20:
    case 21:
    case 64:
    case 65:
    case 71:
    case 72:
    case 73:
    case 74:
    case 75:
    }
    for (TypePath localTypePath = null; ; localTypePath = new TypePath(this.b, m))
    {
      paramContext.j = localTypePath;
      return m + 1 + n * 2;
      k = 0xFFFF0000 & j;
      m = paramInt + 2;
      break;
      k = i & j;
      m = paramInt + 1;
      break;
      k = i & j;
      int i1 = readUnsignedShort(paramInt + 1);
      paramContext.l = new Label[i1];
      paramContext.m = new Label[i1];
      paramContext.n = new int[i1];
      m = paramInt + 3;
      int i2 = 0;
      while (i2 < i1)
      {
        int i3 = readUnsignedShort(m);
        int i4 = readUnsignedShort(m + 2);
        paramContext.l[i2] = readLabel(i3, paramContext.h);
        paramContext.m[i2] = readLabel(i3 + i4, paramContext.h);
        paramContext.n[i2] = readUnsignedShort(m + 4);
        int i5 = m + 6;
        i2++;
        m = i5;
      }
      k = 0xFF0000FF & j;
      m = paramInt + 4;
      break;
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

  private Attribute a(Attribute[] paramArrayOfAttribute, String paramString, int paramInt1, int paramInt2, char[] paramArrayOfChar, int paramInt3, Label[] paramArrayOfLabel)
  {
    for (int i = 0; i < paramArrayOfAttribute.length; i++)
      if (paramArrayOfAttribute[i].type.equals(paramString))
        return paramArrayOfAttribute[i].read(this, paramInt1, paramInt2, paramArrayOfChar, paramInt3, paramArrayOfLabel);
    return new Attribute(paramString).read(this, paramInt1, paramInt2, null, -1, null);
  }

  private void a(ClassWriter paramClassWriter, Item[] paramArrayOfItem, char[] paramArrayOfChar)
  {
    int i = a();
    int j = readUnsignedShort(i);
    int k = i;
    if (j > 0)
      if (!"BootstrapMethods".equals(readUTF8(k + 2, paramArrayOfChar)));
    for (int m = 1; ; m = 0)
    {
      if (m == 0)
      {
        return;
        int i8 = k + (6 + readInt(k + 4));
        j--;
        k = i8;
        break;
      }
      int n = readUnsignedShort(k + 8);
      int i1 = k + 10;
      for (int i2 = 0; i2 < n; i2++)
      {
        int i4 = -10 + (i1 - k);
        int i5 = readConst(readUnsignedShort(i1), paramArrayOfChar).hashCode();
        for (int i6 = readUnsignedShort(i1 + 2); i6 > 0; i6--)
        {
          i5 ^= readConst(readUnsignedShort(i1 + 4), paramArrayOfChar).hashCode();
          i1 += 2;
        }
        i1 += 4;
        Item localItem = new Item(i2);
        localItem.a(i4, i5 & 0x7FFFFFFF);
        int i7 = localItem.j % paramArrayOfItem.length;
        localItem.k = paramArrayOfItem[i7];
        paramArrayOfItem[i7] = localItem;
      }
      int i3 = readInt(k + 4);
      ByteVector localByteVector = new ByteVector(i3 + 62);
      localByteVector.putByteArray(this.b, k + 10, i3 - 2);
      paramClassWriter.z = n;
      paramClassWriter.A = localByteVector;
      return;
    }
  }

  private void a(Context paramContext)
  {
    int i = 1;
    String str = paramContext.g;
    Object[] arrayOfObject = paramContext.s;
    int j = 0x8 & paramContext.e;
    int k = 0;
    if (j == 0)
    {
      if (!"<init>".equals(paramContext.f))
        break label159;
      arrayOfObject[0] = Opcodes.UNINITIALIZED_THIS;
      k = i;
    }
    while (true)
    {
      int m = i + 1;
      switch (str.charAt(i))
      {
      default:
        paramContext.q = k;
        return;
        arrayOfObject[0] = readClass(2 + this.header, paramContext.c);
        k = i;
        break;
      case 'B':
      case 'C':
      case 'I':
      case 'S':
      case 'Z':
        int i7 = k + 1;
        arrayOfObject[k] = Opcodes.INTEGER;
        k = i7;
        i = m;
        break;
      case 'F':
        int i6 = k + 1;
        arrayOfObject[k] = Opcodes.FLOAT;
        k = i6;
        i = m;
        break;
      case 'J':
        int i5 = k + 1;
        arrayOfObject[k] = Opcodes.LONG;
        k = i5;
        i = m;
        break;
      case 'D':
        int i4 = k + 1;
        arrayOfObject[k] = Opcodes.DOUBLE;
        k = i4;
        i = m;
        break;
      case '[':
        while (str.charAt(m) == '[')
          m++;
        if (str.charAt(m) == 'L')
        {
          m++;
          while (str.charAt(m) != ';')
            m++;
        }
        int i2 = k + 1;
        int i3 = m + 1;
        arrayOfObject[k] = str.substring(i, i3);
        i = i3;
        k = i2;
        break;
      case 'L':
        label159: 
        while (str.charAt(m) != ';')
          m++;
        int n = k + 1;
        int i1 = i + 1;
        i = m + 1;
        arrayOfObject[k] = str.substring(i1, m);
        k = n;
      }
    }
  }

  private void a(MethodVisitor paramMethodVisitor, Context paramContext, int paramInt)
  {
    byte[] arrayOfByte = this.b;
    char[] arrayOfChar = paramContext.c;
    int i = readUnsignedShort(paramInt);
    int j = readUnsignedShort(paramInt + 2);
    int k = readInt(paramInt + 4);
    int m = paramInt + 8;
    int n = m + k;
    Label[] arrayOfLabel1 = new Label[k + 2];
    paramContext.h = arrayOfLabel1;
    readLabel(k + 1, arrayOfLabel1);
    int i1 = m;
    if (i1 < n)
    {
      int i116 = i1 - m;
      int i117 = 0xFF & arrayOfByte[i1];
      int i118;
      switch (ClassWriter.a[i117])
      {
      case 16:
      default:
        i118 = i1 + 4;
      case 0:
      case 4:
      case 9:
      case 10:
      case 17:
      case 14:
      case 15:
      case 1:
      case 3:
      case 11:
      case 2:
      case 5:
      case 6:
      case 12:
      case 13:
      case 7:
      case 8:
      }
      while (true)
      {
        i1 = i118;
        break;
        i118 = i1 + 1;
        continue;
        readLabel(i116 + readShort(i1 + 1), arrayOfLabel1);
        i118 = i1 + 3;
        continue;
        readLabel(i116 + readInt(i1 + 1), arrayOfLabel1);
        i118 = i1 + 5;
        continue;
        if ((0xFF & arrayOfByte[(i1 + 1)]) == 132)
        {
          i118 = i1 + 6;
        }
        else
        {
          i118 = i1 + 4;
          continue;
          int i121 = i1 + 4 - (i116 & 0x3);
          readLabel(i116 + readInt(i121), arrayOfLabel1);
          for (int i122 = 1 + (readInt(i121 + 8) - readInt(i121 + 4)); i122 > 0; i122--)
          {
            readLabel(i116 + readInt(i121 + 12), arrayOfLabel1);
            i121 += 4;
          }
          i118 = i121 + 12;
          continue;
          int i119 = i1 + 4 - (i116 & 0x3);
          readLabel(i116 + readInt(i119), arrayOfLabel1);
          for (int i120 = readInt(i119 + 4); i120 > 0; i120--)
          {
            readLabel(i116 + readInt(i119 + 12), arrayOfLabel1);
            i119 += 8;
          }
          i118 = i119 + 8;
          continue;
          i118 = i1 + 2;
          continue;
          i118 = i1 + 3;
          continue;
          i118 = i1 + 5;
        }
      }
    }
    for (int i2 = readUnsignedShort(i1); i2 > 0; i2--)
    {
      paramMethodVisitor.visitTryCatchBlock(readLabel(readUnsignedShort(i1 + 2), arrayOfLabel1), readLabel(readUnsignedShort(i1 + 4), arrayOfLabel1), readLabel(readUnsignedShort(i1 + 6), arrayOfLabel1), readUTF8(this.a[readUnsignedShort(i1 + 8)], arrayOfChar));
      i1 += 8;
    }
    int i3 = i1 + 2;
    Object localObject1 = null;
    Object localObject2 = null;
    int i4 = -1;
    int i5 = -1;
    int i6 = 0;
    int i7 = 0;
    boolean bool1 = true;
    if ((0x8 & paramContext.b) != 0);
    int i8;
    int i9;
    int i10;
    Object localObject3;
    int i11;
    String str5;
    int i110;
    for (boolean bool2 = true; ; bool2 = false)
    {
      i8 = 0;
      i9 = 0;
      i10 = 0;
      localObject3 = null;
      i11 = readUnsignedShort(i3);
      if (i11 <= 0)
        break label1695;
      str5 = readUTF8(i3 + 2, arrayOfChar);
      if (!"LocalVariableTable".equals(str5))
        break label934;
      if ((0x2 & paramContext.b) != 0)
        break label4293;
      i110 = i3 + 8;
      int i111 = readUnsignedShort(i3 + 8);
      int i112 = i3;
      while (i111 > 0)
      {
        int i114 = readUnsignedShort(i112 + 10);
        if (arrayOfLabel1[i114] == null)
        {
          Label localLabel6 = readLabel(i114, arrayOfLabel1);
          localLabel6.a = (0x1 | localLabel6.a);
        }
        int i115 = i114 + readUnsignedShort(i112 + 12);
        if (arrayOfLabel1[i115] == null)
        {
          Label localLabel5 = readLabel(i115, arrayOfLabel1);
          localLabel5.a = (0x1 | localLabel5.a);
        }
        i112 += 10;
        i111--;
      }
    }
    int i94 = i9;
    int i95 = i8;
    boolean bool4 = bool1;
    int i96 = i7;
    int i98 = i5;
    int i99 = i4;
    Object localObject8 = localObject2;
    Object localObject9 = localObject1;
    int i113 = i10;
    int i97 = i110;
    Object localObject7 = localObject3;
    int i93 = i113;
    label1695: 
    while (true)
    {
      i3 += 6 + readInt(i3 + 4);
      i11--;
      i7 = i96;
      i6 = i97;
      localObject2 = localObject8;
      localObject1 = localObject9;
      bool1 = bool4;
      i10 = i93;
      i5 = i98;
      i4 = i99;
      localObject3 = localObject7;
      i9 = i94;
      i8 = i95;
      break;
      label934: if ("LocalVariableTypeTable".equals(str5))
      {
        int i109 = i3 + 8;
        i94 = i9;
        i95 = i8;
        bool4 = bool1;
        i96 = i109;
        localObject7 = localObject3;
        i98 = i5;
        i99 = i4;
        i93 = i10;
        localObject8 = localObject2;
        localObject9 = localObject1;
        i97 = i6;
      }
      else if ("LineNumberTable".equals(str5))
      {
        if ((0x2 & paramContext.b) == 0)
        {
          int i104 = readUnsignedShort(i3 + 8);
          int i105 = i3;
          int i106 = i104;
          while (i106 > 0)
          {
            int i107 = readUnsignedShort(i105 + 10);
            if (arrayOfLabel1[i107] == null)
            {
              Label localLabel4 = readLabel(i107, arrayOfLabel1);
              localLabel4.a = (0x1 | localLabel4.a);
            }
            for (Label localLabel3 = arrayOfLabel1[i107]; localLabel3.b > 0; localLabel3 = localLabel3.k)
              if (localLabel3.k == null)
                localLabel3.k = new Label();
            localLabel3.b = readUnsignedShort(i105 + 12);
            int i108 = i105 + 4;
            i106--;
            i105 = i108;
          }
          localObject7 = localObject3;
          i94 = i9;
          i95 = i8;
          bool4 = bool1;
          i96 = i7;
          i93 = i10;
          i98 = i5;
          i99 = i4;
          i97 = i6;
          localObject8 = localObject2;
          localObject9 = localObject1;
        }
      }
      else
      {
        if ("RuntimeVisibleTypeAnnotations".equals(str5))
        {
          int[] arrayOfInt4 = a(paramMethodVisitor, paramContext, i3 + 8, true);
          if ((arrayOfInt4.length == 0) || (readByte(arrayOfInt4[0]) < 67));
          for (int i103 = -1; ; i103 = readUnsignedShort(1 + arrayOfInt4[0]))
          {
            i95 = i8;
            bool4 = bool1;
            i96 = i7;
            localObject9 = arrayOfInt4;
            i94 = i9;
            i99 = i103;
            i98 = i5;
            localObject7 = localObject3;
            i93 = i10;
            localObject8 = localObject2;
            i97 = i6;
            break;
          }
        }
        if ("RuntimeInvisibleTypeAnnotations".equals(str5))
        {
          int[] arrayOfInt3 = a(paramMethodVisitor, paramContext, i3 + 8, false);
          if ((arrayOfInt3.length == 0) || (readByte(arrayOfInt3[0]) < 67));
          for (int i102 = -1; ; i102 = readUnsignedShort(1 + arrayOfInt3[0]))
          {
            i95 = i8;
            bool4 = bool1;
            i96 = i7;
            localObject8 = arrayOfInt3;
            i94 = i9;
            i99 = i4;
            i98 = i102;
            localObject9 = localObject1;
            localObject7 = localObject3;
            i93 = i10;
            i97 = i6;
            break;
          }
        }
        if ("StackMapTable".equals(str5))
        {
          if ((0x4 & paramContext.b) == 0)
          {
            i95 = i3 + 10;
            i94 = readInt(i3 + 4);
            int i101 = readUnsignedShort(i3 + 8);
            bool4 = bool1;
            i96 = i7;
            i97 = i6;
            i98 = i5;
            i99 = i4;
            localObject8 = localObject2;
            localObject9 = localObject1;
            localObject7 = localObject3;
            i93 = i101;
          }
        }
        else if ("StackMap".equals(str5))
        {
          if ((0x4 & paramContext.b) == 0)
          {
            i95 = i3 + 10;
            i94 = readInt(i3 + 4);
            int i100 = readUnsignedShort(i3 + 8);
            i96 = i7;
            i97 = i6;
            i98 = i5;
            i99 = i4;
            localObject8 = localObject2;
            localObject9 = localObject1;
            Object localObject10 = localObject3;
            i93 = i100;
            localObject7 = localObject10;
            bool4 = false;
          }
        }
        else
        {
          int i91 = 0;
          Object localObject6 = localObject3;
          while (true)
          {
            int i92 = paramContext.a.length;
            if (i91 >= i92)
              break;
            if (paramContext.a[i91].type.equals(str5))
            {
              Attribute localAttribute2 = paramContext.a[i91].read(this, i3 + 8, readInt(i3 + 4), arrayOfChar, m - 8, arrayOfLabel1);
              if (localAttribute2 != null)
              {
                localAttribute2.a = localObject6;
                localObject6 = localAttribute2;
              }
            }
            i91++;
          }
          (i3 + 2);
          if (i8 != 0)
          {
            paramContext.o = -1;
            paramContext.p = 0;
            paramContext.q = 0;
            paramContext.r = 0;
            paramContext.t = 0;
            paramContext.s = new Object[j];
            paramContext.u = new Object[i];
            if (bool2)
              a(paramContext);
            for (int i89 = i8; i89 < -2 + (i8 + i9); i89++)
              if (arrayOfByte[i89] == 8)
              {
                int i90 = readUnsignedShort(i89 + 1);
                if ((i90 >= 0) && (i90 < k) && ((0xFF & arrayOfByte[(m + i90)]) == 187))
                  readLabel(i90, arrayOfLabel1);
              }
          }
          for (Object localObject4 = paramContext; ; localObject4 = null)
          {
            int i12 = i10;
            int i13 = i8;
            int i14 = i5;
            int i15 = i4;
            int i16 = 0;
            int i17 = 0;
            int i18 = m;
            int i36;
            if (i18 < n)
            {
              i36 = i18 - m;
              Label localLabel1 = arrayOfLabel1[i36];
              if (localLabel1 == null)
                break label4225;
              Label localLabel2 = localLabel1.k;
              localLabel1.k = null;
              paramMethodVisitor.visitLabel(localLabel1);
              if (((0x2 & paramContext.b) != 0) || (localLabel1.b <= 0))
                break label4225;
              paramMethodVisitor.visitLineNumber(localLabel1.b, localLabel1);
              while (localLabel2 != null)
              {
                paramMethodVisitor.visitLineNumber(localLabel2.b, localLabel1);
                localLabel2 = localLabel2.k;
              }
            }
            while (true)
            {
              Object localObject5;
              int i37;
              int i38;
              if ((localObject5 != null) && ((((Context)localObject5).o == i36) || (((Context)localObject5).o == -1)))
              {
                if (((Context)localObject5).o != -1)
                {
                  if ((bool1) && (!bool2))
                    break label2065;
                  paramMethodVisitor.visitFrame(-1, ((Context)localObject5).q, ((Context)localObject5).s, ((Context)localObject5).t, ((Context)localObject5).u);
                }
                while (true)
                {
                  if (i37 <= 0)
                    break label2097;
                  int i88 = a(i38, bool1, bool2, (Context)localObject5);
                  i37--;
                  i38 = i88;
                  break;
                  paramMethodVisitor.visitFrame(((Context)localObject5).p, ((Context)localObject5).r, ((Context)localObject5).s, ((Context)localObject5).t, ((Context)localObject5).u);
                }
                label2097: localObject5 = null;
              }
              else
              {
                int i39 = 0xFF & arrayOfByte[i18];
                int i41;
                int i42;
                int i43;
                int i47;
                switch (ClassWriter.a[i39])
                {
                case 16:
                default:
                  paramMethodVisitor.visitMultiANewArrayInsn(readClass(i18 + 1, arrayOfChar), 0xFF & arrayOfByte[(i18 + 3)]);
                  int i87 = i18 + 4;
                  i41 = i15;
                  i42 = i17;
                  i43 = i87;
                  if ((localObject1 == null) || (i42 >= localObject1.length) || (i41 > i36))
                    break label4214;
                  if (i41 == i36)
                  {
                    int i49 = a(paramContext, localObject1[i42]);
                    a(i49 + 2, arrayOfChar, true, paramMethodVisitor.visitInsnAnnotation(paramContext.i, paramContext.j, readUTF8(i49, arrayOfChar), true));
                  }
                  i47 = i42 + 1;
                  if ((i47 < localObject1.length) && (readByte(localObject1[i47]) >= 67))
                    break;
                case 0:
                case 4:
                case 9:
                case 10:
                case 17:
                case 14:
                case 15:
                case 3:
                case 1:
                case 2:
                case 11:
                case 12:
                case 6:
                case 7:
                case 8:
                case 5:
                case 13:
                }
                for (int i48 = -1; ; i48 = readUnsignedShort(1 + localObject1[i47]))
                {
                  i41 = i48;
                  i42 = i47;
                  break;
                  paramMethodVisitor.visitInsn(i39);
                  int i86 = i18 + 1;
                  i41 = i15;
                  i42 = i17;
                  i43 = i86;
                  break;
                  if (i39 > 54)
                  {
                    int i85 = i39 - 59;
                    paramMethodVisitor.visitVarInsn(54 + (i85 >> 2), i85 & 0x3);
                  }
                  while (true)
                  {
                    int i84 = i18 + 1;
                    i41 = i15;
                    i42 = i17;
                    i43 = i84;
                    break;
                    int i83 = i39 - 26;
                    paramMethodVisitor.visitVarInsn(21 + (i83 >> 2), i83 & 0x3);
                  }
                  paramMethodVisitor.visitJumpInsn(i39, arrayOfLabel1[(i36 + readShort(i18 + 1))]);
                  int i82 = i18 + 3;
                  i41 = i15;
                  i42 = i17;
                  i43 = i82;
                  break;
                  paramMethodVisitor.visitJumpInsn(i39 - 33, arrayOfLabel1[(i36 + readInt(i18 + 1))]);
                  int i81 = i18 + 5;
                  i41 = i15;
                  i42 = i17;
                  i43 = i81;
                  break;
                  int i78 = 0xFF & arrayOfByte[(i18 + 1)];
                  if (i78 == 132)
                  {
                    paramMethodVisitor.visitIincInsn(readUnsignedShort(i18 + 2), readShort(i18 + 4));
                    int i80 = i18 + 6;
                    i41 = i15;
                    i42 = i17;
                    i43 = i80;
                    break;
                  }
                  paramMethodVisitor.visitVarInsn(i78, readUnsignedShort(i18 + 2));
                  int i79 = i18 + 4;
                  i41 = i15;
                  i42 = i17;
                  i43 = i79;
                  break;
                  int i72 = i18 + 4 - (i36 & 0x3);
                  int i73 = i36 + readInt(i72);
                  int i74 = readInt(i72 + 4);
                  int i75 = readInt(i72 + 8);
                  Label[] arrayOfLabel3 = new Label[1 + (i75 - i74)];
                  int i76 = i72 + 12;
                  for (int i77 = 0; i77 < arrayOfLabel3.length; i77++)
                  {
                    arrayOfLabel3[i77] = arrayOfLabel1[(i36 + readInt(i76))];
                    i76 += 4;
                  }
                  paramMethodVisitor.visitTableSwitchInsn(i74, i75, arrayOfLabel1[i73], arrayOfLabel3);
                  i41 = i15;
                  i42 = i17;
                  i43 = i76;
                  break;
                  int i67 = i18 + 4 - (i36 & 0x3);
                  int i68 = i36 + readInt(i67);
                  int i69 = readInt(i67 + 4);
                  int[] arrayOfInt2 = new int[i69];
                  Label[] arrayOfLabel2 = new Label[i69];
                  int i70 = i67 + 8;
                  for (int i71 = 0; i71 < i69; i71++)
                  {
                    arrayOfInt2[i71] = readInt(i70);
                    arrayOfLabel2[i71] = arrayOfLabel1[(i36 + readInt(i70 + 4))];
                    i70 += 8;
                  }
                  paramMethodVisitor.visitLookupSwitchInsn(arrayOfLabel1[i68], arrayOfInt2, arrayOfLabel2);
                  i41 = i15;
                  i42 = i17;
                  i43 = i70;
                  break;
                  paramMethodVisitor.visitVarInsn(i39, 0xFF & arrayOfByte[(i18 + 1)]);
                  int i66 = i18 + 2;
                  i41 = i15;
                  i42 = i17;
                  i43 = i66;
                  break;
                  paramMethodVisitor.visitIntInsn(i39, arrayOfByte[(i18 + 1)]);
                  int i65 = i18 + 2;
                  i41 = i15;
                  i42 = i17;
                  i43 = i65;
                  break;
                  paramMethodVisitor.visitIntInsn(i39, readShort(i18 + 1));
                  int i64 = i18 + 3;
                  i41 = i15;
                  i42 = i17;
                  i43 = i64;
                  break;
                  paramMethodVisitor.visitLdcInsn(readConst(0xFF & arrayOfByte[(i18 + 1)], arrayOfChar));
                  int i63 = i18 + 2;
                  i41 = i15;
                  i42 = i17;
                  i43 = i63;
                  break;
                  paramMethodVisitor.visitLdcInsn(readConst(readUnsignedShort(i18 + 1), arrayOfChar));
                  int i62 = i18 + 3;
                  i41 = i15;
                  i42 = i17;
                  i43 = i62;
                  break;
                  int i58 = this.a[readUnsignedShort(i18 + 1)];
                  boolean bool3;
                  label3126: String str2;
                  String str3;
                  String str4;
                  if (arrayOfByte[(i58 - 1)] == 11)
                  {
                    bool3 = true;
                    str2 = readClass(i58, arrayOfChar);
                    int i59 = this.a[readUnsignedShort(i58 + 2)];
                    str3 = readUTF8(i59, arrayOfChar);
                    str4 = readUTF8(i59 + 2, arrayOfChar);
                    if (i39 >= 182)
                      break label3228;
                    paramMethodVisitor.visitFieldInsn(i39, str2, str3, str4);
                  }
                  while (true)
                  {
                    if (i39 != 185)
                      break label3245;
                    int i61 = i18 + 5;
                    i41 = i15;
                    i42 = i17;
                    i43 = i61;
                    break;
                    bool3 = false;
                    break label3126;
                    paramMethodVisitor.visitMethodInsn(i39, str2, str3, str4, bool3);
                  }
                  label3245: int i60 = i18 + 3;
                  i41 = i15;
                  i42 = i17;
                  i43 = i60;
                  break;
                  int i51 = this.a[readUnsignedShort(i18 + 1)];
                  int i52 = paramContext.d[readUnsignedShort(i51)];
                  Handle localHandle = (Handle)readConst(readUnsignedShort(i52), arrayOfChar);
                  int i53 = readUnsignedShort(i52 + 2);
                  Object[] arrayOfObject = new Object[i53];
                  int i54 = i52 + 4;
                  for (int i55 = 0; i55 < i53; i55++)
                  {
                    arrayOfObject[i55] = readConst(readUnsignedShort(i54), arrayOfChar);
                    i54 += 2;
                  }
                  int i56 = this.a[readUnsignedShort(i51 + 2)];
                  paramMethodVisitor.visitInvokeDynamicInsn(readUTF8(i56, arrayOfChar), readUTF8(i56 + 2, arrayOfChar), localHandle, arrayOfObject);
                  int i57 = i18 + 5;
                  i41 = i15;
                  i42 = i17;
                  i43 = i57;
                  break;
                  paramMethodVisitor.visitTypeInsn(i39, readClass(i18 + 1, arrayOfChar));
                  int i50 = i18 + 3;
                  i41 = i15;
                  i42 = i17;
                  i43 = i50;
                  break;
                  paramMethodVisitor.visitIincInsn(0xFF & arrayOfByte[(i18 + 1)], arrayOfByte[(i18 + 2)]);
                  int i40 = i18 + 3;
                  i41 = i15;
                  i42 = i17;
                  i43 = i40;
                  break;
                }
                while (true)
                {
                  int i45;
                  int i44;
                  if ((localObject2 != null) && (i45 < localObject2.length) && (i44 <= i36))
                  {
                    if (i44 == i36)
                    {
                      int i46 = a(paramContext, localObject2[i45]);
                      a(i46 + 2, arrayOfChar, true, paramMethodVisitor.visitInsnAnnotation(paramContext.i, paramContext.j, readUTF8(i46, arrayOfChar), false));
                    }
                    i45++;
                    if ((i45 >= localObject2.length) || (readByte(localObject2[i45]) < 67))
                      i44 = -1;
                    else
                      i44 = readUnsignedShort(1 + localObject2[i45]);
                  }
                  else
                  {
                    i14 = i44;
                    i15 = i41;
                    i16 = i45;
                    i17 = i42;
                    i18 = i43;
                    i13 = i38;
                    localObject4 = localObject5;
                    i12 = i37;
                    break;
                    if (arrayOfLabel1[k] != null)
                      paramMethodVisitor.visitLabel(arrayOfLabel1[k]);
                    if (((0x2 & paramContext.b) == 0) && (i6 != 0))
                    {
                      int[] arrayOfInt1 = null;
                      if (i7 != 0)
                      {
                        int i32 = i7 + 2;
                        arrayOfInt1 = new int[3 * readUnsignedShort(i7)];
                        int i33 = arrayOfInt1.length;
                        while (i33 > 0)
                        {
                          int i34 = i33 - 1;
                          arrayOfInt1[i34] = (i32 + 6);
                          int i35 = i34 - 1;
                          arrayOfInt1[i35] = readUnsignedShort(i32 + 8);
                          i33 = i35 - 1;
                          arrayOfInt1[i33] = readUnsignedShort(i32);
                          i32 += 10;
                        }
                      }
                      int i23 = i6 + 2;
                      int i24 = readUnsignedShort(i6);
                      int i25 = i23;
                      int i26 = i24;
                      if (i26 > 0)
                      {
                        int i27 = readUnsignedShort(i25);
                        int i28 = readUnsignedShort(i25 + 2);
                        int i29 = readUnsignedShort(i25 + 8);
                        String str1 = null;
                        if (arrayOfInt1 != null);
                        for (int i30 = 0; ; i30 += 3)
                        {
                          int i31 = arrayOfInt1.length;
                          str1 = null;
                          if (i30 < i31)
                          {
                            if ((arrayOfInt1[i30] == i27) && (arrayOfInt1[(i30 + 1)] == i29))
                              str1 = readUTF8(arrayOfInt1[(i30 + 2)], arrayOfChar);
                          }
                          else
                          {
                            paramMethodVisitor.visitLocalVariable(readUTF8(i25 + 4, arrayOfChar), readUTF8(i25 + 6, arrayOfChar), str1, arrayOfLabel1[i27], arrayOfLabel1[(i27 + i28)], i29);
                            i25 += 10;
                            i26--;
                            break;
                          }
                        }
                      }
                    }
                    if (localObject1 != null)
                      for (int i21 = 0; i21 < localObject1.length; i21++)
                        if (readByte(localObject1[i21]) >> 1 == 32)
                        {
                          int i22 = a(paramContext, localObject1[i21]);
                          a(i22 + 2, arrayOfChar, true, paramMethodVisitor.visitLocalVariableAnnotation(paramContext.i, paramContext.j, paramContext.l, paramContext.m, paramContext.n, readUTF8(i22, arrayOfChar), true));
                        }
                    if (localObject2 != null)
                      for (int i19 = 0; i19 < localObject2.length; i19++)
                        if (readByte(localObject2[i19]) >> 1 == 32)
                        {
                          int i20 = a(paramContext, localObject2[i19]);
                          a(i20 + 2, arrayOfChar, true, paramMethodVisitor.visitLocalVariableAnnotation(paramContext.i, paramContext.j, paramContext.l, paramContext.m, paramContext.n, readUTF8(i20, arrayOfChar), false));
                        }
                    while (localObject3 != null)
                    {
                      Attribute localAttribute1 = localObject3.a;
                      localObject3.a = null;
                      paramMethodVisitor.visitAttribute(localObject3);
                      localObject3 = localAttribute1;
                    }
                    paramMethodVisitor.visitMaxs(i, j);
                    return;
                    label4214: i44 = i14;
                    i45 = i16;
                  }
                }
                localObject5 = localObject4;
                i37 = i12;
                i38 = i13;
              }
            }
          }
          localObject7 = localObject6;
          i93 = i10;
          i94 = i9;
          i95 = i8;
          bool4 = bool1;
          i96 = i7;
          i97 = i6;
          i98 = i5;
          i99 = i4;
          localObject8 = localObject2;
          localObject9 = localObject1;
          continue;
          label4293: localObject7 = localObject3;
          i94 = i9;
          i95 = i8;
          bool4 = bool1;
          i96 = i7;
          i93 = i10;
          i98 = i5;
          i99 = i4;
          i97 = i6;
          localObject8 = localObject2;
          localObject9 = localObject1;
        }
      }
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

  private int[] a(MethodVisitor paramMethodVisitor, Context paramContext, int paramInt, boolean paramBoolean)
  {
    char[] arrayOfChar = paramContext.c;
    int[] arrayOfInt = new int[readUnsignedShort(paramInt)];
    int i = paramInt + 2;
    int j = 0;
    if (j < arrayOfInt.length)
    {
      arrayOfInt[j] = i;
      int k = readInt(i);
      int m;
      label170: int n;
      TypePath localTypePath;
      label196: int i1;
      switch (k >>> 24)
      {
      default:
        m = i + 3;
        n = readByte(m);
        if (k >>> 24 == 66)
          if (n == 0)
          {
            localTypePath = null;
            i1 = m + (1 + n * 2);
          }
        break;
      case 0:
      case 1:
      case 22:
      case 19:
      case 20:
      case 21:
      case 64:
      case 65:
      case 71:
      case 72:
      case 73:
      case 74:
      case 75:
      }
      for (i = a(i1 + 2, arrayOfChar, true, paramMethodVisitor.visitTryCatchAnnotation(k, localTypePath, readUTF8(i1, arrayOfChar), paramBoolean)); ; i = a(m + 3 + n * 2, arrayOfChar, true, null))
      {
        j++;
        break;
        m = i + 2;
        break label170;
        m = i + 1;
        break label170;
        int i2 = readUnsignedShort(i + 1);
        int i3 = i;
        for (int i4 = i2; i4 > 0; i4--)
        {
          int i5 = readUnsignedShort(i3 + 3);
          int i6 = readUnsignedShort(i3 + 5);
          readLabel(i5, paramContext.h);
          readLabel(i5 + i6, paramContext.h);
          i3 += 6;
        }
        m = i3 + 3;
        break label170;
        m = i + 4;
        break label170;
        localTypePath = new TypePath(this.b, m);
        break label196;
      }
    }
    return arrayOfInt;
  }

  private int b(ClassVisitor paramClassVisitor, Context paramContext, int paramInt)
  {
    char[] arrayOfChar = paramContext.c;
    paramContext.e = readUnsignedShort(paramInt);
    paramContext.f = readUTF8(paramInt + 2, arrayOfChar);
    paramContext.g = readUTF8(paramInt + 4, arrayOfChar);
    int i = paramInt + 6;
    int j = 0;
    int k = 0;
    String[] arrayOfString = null;
    String str1 = null;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i6 = 0;
    Object localObject1 = null;
    int i7 = readUnsignedShort(i);
    int i8 = i;
    String str2;
    int i26;
    int i27;
    int i28;
    int i29;
    int i30;
    int i31;
    int i32;
    int i33;
    int i35;
    Object localObject2;
    int i34;
    if (i7 > 0)
    {
      str2 = readUTF8(i8 + 2, arrayOfChar);
      if ("Code".equals(str2))
      {
        if ((0x1 & paramContext.b) != 0)
          break label1814;
        int i48 = i8 + 8;
        i26 = i6;
        i27 = i5;
        i28 = i4;
        i29 = i3;
        i30 = i2;
        i31 = i1;
        i32 = n;
        i33 = m;
        i35 = i48;
        localObject2 = localObject1;
        i34 = k;
      }
    }
    while (true)
    {
      int i36 = i8 + (6 + readInt(i8 + 4));
      i7--;
      i3 = i29;
      i2 = i30;
      i1 = i31;
      n = i32;
      m = i33;
      k = i34;
      j = i35;
      i8 = i36;
      localObject1 = localObject2;
      i6 = i26;
      i5 = i27;
      i4 = i28;
      break;
      if ("Exceptions".equals(str2))
      {
        arrayOfString = new String[readUnsignedShort(i8 + 8)];
        int i44 = i8 + 10;
        int i45 = 0;
        while (i45 < arrayOfString.length)
        {
          arrayOfString[i45] = readClass(i44, arrayOfChar);
          int i47 = i44 + 2;
          i45++;
          i44 = i47;
        }
        i26 = i6;
        i27 = i5;
        i28 = i4;
        i29 = i3;
        i30 = i2;
        i31 = i1;
        i32 = n;
        i33 = m;
        i35 = j;
        int i46 = i44;
        localObject2 = localObject1;
        i34 = i46;
      }
      else if ("Signature".equals(str2))
      {
        str1 = readUTF8(i8 + 8, arrayOfChar);
        localObject2 = localObject1;
        i26 = i6;
        i27 = i5;
        i28 = i4;
        i29 = i3;
        i30 = i2;
        i31 = i1;
        i32 = n;
        i33 = m;
        i34 = k;
        i35 = j;
      }
      else if ("Deprecated".equals(str2))
      {
        paramContext.e = (0x20000 | paramContext.e);
        localObject2 = localObject1;
        i26 = i6;
        i27 = i5;
        i28 = i4;
        i29 = i3;
        i30 = i2;
        i31 = i1;
        i32 = n;
        i33 = m;
        i34 = k;
        i35 = j;
      }
      else if ("RuntimeVisibleAnnotations".equals(str2))
      {
        int i43 = i8 + 8;
        i26 = i6;
        i27 = i5;
        i28 = i4;
        i29 = i3;
        i30 = i2;
        i31 = i1;
        i32 = i43;
        i33 = m;
        localObject2 = localObject1;
        i35 = j;
        i34 = k;
      }
      else if ("RuntimeVisibleTypeAnnotations".equals(str2))
      {
        int i42 = i8 + 8;
        i26 = i6;
        i27 = i5;
        i28 = i4;
        i29 = i3;
        i30 = i42;
        i31 = i1;
        i32 = n;
        i33 = m;
        localObject2 = localObject1;
        i35 = j;
        i34 = k;
      }
      else if ("AnnotationDefault".equals(str2))
      {
        int i41 = i8 + 8;
        i26 = i6;
        i27 = i5;
        i28 = i41;
        i29 = i3;
        i30 = i2;
        i31 = i1;
        i32 = n;
        i33 = m;
        localObject2 = localObject1;
        i35 = j;
        i34 = k;
      }
      else if ("Synthetic".equals(str2))
      {
        paramContext.e = (0x41000 | paramContext.e);
        localObject2 = localObject1;
        i26 = i6;
        i27 = i5;
        i28 = i4;
        i29 = i3;
        i30 = i2;
        i31 = i1;
        i32 = n;
        i33 = m;
        i34 = k;
        i35 = j;
      }
      else if ("RuntimeInvisibleAnnotations".equals(str2))
      {
        int i40 = i8 + 8;
        i26 = i6;
        i27 = i5;
        i28 = i4;
        i29 = i3;
        i30 = i2;
        i31 = i40;
        i32 = n;
        i33 = m;
        localObject2 = localObject1;
        i35 = j;
        i34 = k;
      }
      else if ("RuntimeInvisibleTypeAnnotations".equals(str2))
      {
        int i39 = i8 + 8;
        i26 = i6;
        i27 = i5;
        i28 = i4;
        i29 = i39;
        i30 = i2;
        i31 = i1;
        i32 = n;
        i33 = m;
        localObject2 = localObject1;
        i35 = j;
        i34 = k;
      }
      else if ("RuntimeVisibleParameterAnnotations".equals(str2))
      {
        int i38 = i8 + 8;
        i26 = i6;
        i27 = i38;
        i28 = i4;
        i29 = i3;
        i30 = i2;
        i31 = i1;
        i32 = n;
        i33 = m;
        localObject2 = localObject1;
        i35 = j;
        i34 = k;
      }
      else if ("RuntimeInvisibleParameterAnnotations".equals(str2))
      {
        i26 = i8 + 8;
        i27 = i5;
        i28 = i4;
        i29 = i3;
        i30 = i2;
        i31 = i1;
        i32 = n;
        i33 = m;
        i35 = j;
        localObject2 = localObject1;
        i34 = k;
      }
      else if ("MethodParameters".equals(str2))
      {
        int i37 = i8 + 8;
        i26 = i6;
        i27 = i5;
        i28 = i4;
        i29 = i3;
        i30 = i2;
        i31 = i1;
        i32 = n;
        i33 = i37;
        localObject2 = localObject1;
        i35 = j;
        i34 = k;
      }
      else
      {
        localObject2 = a(paramContext.a, str2, i8 + 8, readInt(i8 + 4), arrayOfChar, -1, null);
        if (localObject2 != null)
        {
          ((Attribute)localObject2).a = localObject1;
          i26 = i6;
          i27 = i5;
          i28 = i4;
          i29 = i3;
          i30 = i2;
          i31 = i1;
          i32 = n;
          i33 = m;
          i34 = k;
          i35 = j;
          continue;
          int i9 = i8 + 2;
          MethodVisitor localMethodVisitor = paramClassVisitor.visitMethod(paramContext.e, paramContext.f, paramContext.g, str1, arrayOfString);
          if (localMethodVisitor == null)
            return i9;
          if ((localMethodVisitor instanceof MethodWriter))
          {
            MethodWriter localMethodWriter = (MethodWriter)localMethodVisitor;
            if ((localMethodWriter.b.M == this) && (str1 == localMethodWriter.g))
            {
              int i24;
              if (arrayOfString == null)
                if (localMethodWriter.j == 0)
                  i24 = 1;
              label1368: 
              while (i24 != 0)
              {
                localMethodWriter.h = i;
                localMethodWriter.i = (i9 - i);
                return i9;
                i24 = 0;
                continue;
                int i22 = arrayOfString.length;
                int i23 = localMethodWriter.j;
                i24 = 0;
                if (i22 == i23)
                {
                  i24 = 1;
                  for (int i25 = -1 + arrayOfString.length; ; i25--)
                  {
                    if (i25 < 0)
                      break label1368;
                    k -= 2;
                    if (localMethodWriter.k[i25] != readUnsignedShort(k))
                    {
                      i24 = 0;
                      break;
                    }
                  }
                }
              }
            }
          }
          if (m != 0)
          {
            int i20 = 0xFF & this.b[m];
            for (int i21 = m + 1; i20 > 0; i21 += 4)
            {
              localMethodVisitor.visitParameter(readUTF8(i21, arrayOfChar), readUnsignedShort(i21 + 2));
              i20--;
            }
          }
          if (i4 != 0)
          {
            AnnotationVisitor localAnnotationVisitor = localMethodVisitor.visitAnnotationDefault();
            a(i4, arrayOfChar, null, localAnnotationVisitor);
            if (localAnnotationVisitor != null)
              localAnnotationVisitor.visitEnd();
          }
          if (n != 0)
          {
            int i18 = readUnsignedShort(n);
            int i19 = n + 2;
            while (i18 > 0)
            {
              i19 = a(i19 + 2, arrayOfChar, true, localMethodVisitor.visitAnnotation(readUTF8(i19, arrayOfChar), true));
              i18--;
            }
          }
          if (i1 != 0)
          {
            int i16 = readUnsignedShort(i1);
            int i17 = i1 + 2;
            while (i16 > 0)
            {
              i17 = a(i17 + 2, arrayOfChar, true, localMethodVisitor.visitAnnotation(readUTF8(i17, arrayOfChar), false));
              i16--;
            }
          }
          if (i2 != 0)
          {
            int i13 = readUnsignedShort(i2);
            int i14 = i2 + 2;
            while (i13 > 0)
            {
              int i15 = a(paramContext, i14);
              i14 = a(i15 + 2, arrayOfChar, true, localMethodVisitor.visitTypeAnnotation(paramContext.i, paramContext.j, readUTF8(i15, arrayOfChar), true));
              i13--;
            }
          }
          if (i3 != 0)
          {
            int i10 = readUnsignedShort(i3);
            int i11 = i3 + 2;
            while (i10 > 0)
            {
              int i12 = a(paramContext, i11);
              i11 = a(i12 + 2, arrayOfChar, true, localMethodVisitor.visitTypeAnnotation(paramContext.i, paramContext.j, readUTF8(i12, arrayOfChar), false));
              i10--;
            }
          }
          if (i5 != 0)
            b(localMethodVisitor, paramContext, i5, true);
          if (i6 != 0)
            b(localMethodVisitor, paramContext, i6, false);
          while (localObject1 != null)
          {
            Attribute localAttribute = localObject1.a;
            localObject1.a = null;
            localMethodVisitor.visitAttribute(localObject1);
            localObject1 = localAttribute;
          }
          if (j != 0)
          {
            localMethodVisitor.visitCode();
            a(localMethodVisitor, paramContext, j);
          }
          localMethodVisitor.visitEnd();
          return i9;
        }
        else
        {
          label1814: localObject2 = localObject1;
          i26 = i6;
          i27 = i5;
          i28 = i4;
          i29 = i3;
          i30 = i2;
          i31 = i1;
          i32 = n;
          i33 = m;
          i34 = k;
          i35 = j;
        }
      }
    }
  }

  private void b(MethodVisitor paramMethodVisitor, Context paramContext, int paramInt, boolean paramBoolean)
  {
    byte[] arrayOfByte = this.b;
    int i = paramInt + 1;
    int j = 0xFF & arrayOfByte[paramInt];
    int k = Type.getArgumentTypes(paramContext.g).length - j;
    for (int m = 0; m < k; m++)
    {
      AnnotationVisitor localAnnotationVisitor2 = paramMethodVisitor.visitParameterAnnotation(m, "Ljava/lang/Synthetic;", false);
      if (localAnnotationVisitor2 != null)
        localAnnotationVisitor2.visitEnd();
    }
    char[] arrayOfChar = paramContext.c;
    for (int n = m; n < j + k; n++)
    {
      int i1 = readUnsignedShort(i);
      i += 2;
      while (i1 > 0)
      {
        AnnotationVisitor localAnnotationVisitor1 = paramMethodVisitor.visitParameterAnnotation(n, readUTF8(i, arrayOfChar), paramBoolean);
        i = a(i + 2, arrayOfChar, true, localAnnotationVisitor1);
        i1--;
      }
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
    int i = this.header;
    char[] arrayOfChar = new char[this.d];
    Context localContext = new Context();
    localContext.a = paramArrayOfAttribute;
    localContext.b = paramInt;
    localContext.c = arrayOfChar;
    int j = readUnsignedShort(i);
    String str1 = readClass(i + 2, arrayOfChar);
    String str2 = readClass(i + 4, arrayOfChar);
    String[] arrayOfString = new String[readUnsignedShort(i + 6)];
    int k = i + 8;
    for (int m = 0; m < arrayOfString.length; m++)
    {
      arrayOfString[m] = readClass(k, arrayOfChar);
      k += 2;
    }
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    Object localObject7 = null;
    int i5 = a();
    int i6 = readUnsignedShort(i5);
    int i7 = i5;
    String str3;
    int i24;
    int i25;
    int i26;
    int i27;
    int i28;
    Object localObject9;
    Object localObject11;
    Object localObject12;
    int i29;
    Object localObject8;
    Object localObject13;
    Object localObject14;
    Object localObject10;
    label422: String str6;
    Object localObject16;
    Object localObject15;
    if (i6 > 0)
    {
      str3 = readUTF8(i7 + 2, arrayOfChar);
      if ("SourceFile".equals(str3))
      {
        String str7 = readUTF8(i7 + 8, arrayOfChar);
        i24 = i4;
        i25 = i3;
        i26 = i2;
        i27 = i1;
        i28 = n;
        localObject9 = localObject6;
        localObject11 = str7;
        localObject12 = localObject1;
        i29 = j;
        localObject8 = localObject7;
        localObject13 = localObject5;
        localObject14 = localObject4;
      }
      for (localObject10 = localObject3; ; localObject10 = localObject3)
      {
        int i30 = i7 + (6 + readInt(i7 + 4));
        i6--;
        localObject6 = localObject9;
        localObject5 = localObject13;
        localObject4 = localObject14;
        localObject3 = localObject10;
        localObject2 = localObject11;
        i7 = i30;
        localObject7 = localObject8;
        i4 = i24;
        i1 = i27;
        localObject1 = localObject12;
        j = i29;
        n = i28;
        i3 = i25;
        i2 = i26;
        break;
        if (!"InnerClasses".equals(str3))
          break label422;
        i24 = i7 + 8;
        i25 = i3;
        i26 = i2;
        i27 = i1;
        i28 = n;
        localObject9 = localObject6;
        localObject11 = localObject2;
        localObject8 = localObject7;
        localObject12 = localObject1;
        i29 = j;
        localObject13 = localObject5;
        localObject14 = localObject4;
      }
      if ("EnclosingMethod".equals(str3))
      {
        str6 = readClass(i7 + 8, arrayOfChar);
        int i40 = readUnsignedShort(i7 + 10);
        if (i40 == 0)
          break label1955;
        localObject16 = readUTF8(this.a[i40], arrayOfChar);
        localObject15 = readUTF8(2 + this.a[i40], arrayOfChar);
      }
    }
    while (true)
    {
      i26 = i2;
      i27 = i1;
      i28 = n;
      localObject9 = localObject15;
      localObject8 = localObject7;
      i29 = j;
      localObject13 = localObject16;
      localObject10 = localObject3;
      i24 = i4;
      localObject11 = localObject2;
      i25 = i3;
      localObject12 = localObject1;
      localObject14 = str6;
      break;
      if ("Signature".equals(str3))
      {
        String str5 = readUTF8(i7 + 8, arrayOfChar);
        localObject8 = localObject7;
        i24 = i4;
        i25 = i3;
        i26 = i2;
        i27 = i1;
        i28 = n;
        localObject9 = localObject6;
        localObject10 = localObject3;
        localObject11 = localObject2;
        localObject12 = str5;
        i29 = j;
        localObject13 = localObject5;
        localObject14 = localObject4;
        break;
      }
      if ("RuntimeVisibleAnnotations".equals(str3))
      {
        int i39 = i7 + 8;
        i24 = i4;
        i25 = i3;
        i26 = i2;
        i27 = i1;
        i28 = i39;
        localObject9 = localObject6;
        localObject8 = localObject7;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i29 = j;
        localObject13 = localObject5;
        localObject14 = localObject4;
        localObject10 = localObject3;
        break;
      }
      if ("RuntimeVisibleTypeAnnotations".equals(str3))
      {
        int i38 = i7 + 8;
        i24 = i4;
        i25 = i3;
        i26 = i38;
        i27 = i1;
        i28 = n;
        localObject9 = localObject6;
        i29 = j;
        localObject13 = localObject5;
        localObject11 = localObject2;
        localObject12 = localObject1;
        localObject8 = localObject7;
        localObject10 = localObject3;
        localObject14 = localObject4;
        break;
      }
      if ("Deprecated".equals(str3))
      {
        int i37 = j | 0x20000;
        localObject8 = localObject7;
        i24 = i4;
        i25 = i3;
        i26 = i2;
        i27 = i1;
        i28 = n;
        localObject9 = localObject6;
        localObject10 = localObject3;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i29 = i37;
        localObject13 = localObject5;
        localObject14 = localObject4;
        break;
      }
      if ("Synthetic".equals(str3))
      {
        int i36 = j | 0x41000;
        localObject8 = localObject7;
        i24 = i4;
        i25 = i3;
        i26 = i2;
        i27 = i1;
        i28 = n;
        localObject9 = localObject6;
        localObject10 = localObject3;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i29 = i36;
        localObject13 = localObject5;
        localObject14 = localObject4;
        break;
      }
      if ("SourceDebugExtension".equals(str3))
      {
        int i35 = readInt(i7 + 4);
        String str4 = a(i7 + 8, i35, new char[i35]);
        i24 = i4;
        i25 = i3;
        i26 = i2;
        i27 = i1;
        i28 = n;
        localObject9 = localObject6;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i29 = j;
        localObject13 = localObject5;
        localObject14 = localObject4;
        localObject8 = localObject7;
        localObject10 = str4;
        break;
      }
      if ("RuntimeInvisibleAnnotations".equals(str3))
      {
        int i34 = i7 + 8;
        i24 = i4;
        i25 = i3;
        i26 = i2;
        i27 = i34;
        i28 = n;
        localObject9 = localObject6;
        localObject8 = localObject7;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i29 = j;
        localObject13 = localObject5;
        localObject14 = localObject4;
        localObject10 = localObject3;
        break;
      }
      if ("RuntimeInvisibleTypeAnnotations".equals(str3))
      {
        int i33 = i7 + 8;
        i24 = i4;
        i25 = i33;
        i26 = i2;
        i27 = i1;
        i28 = n;
        localObject9 = localObject6;
        localObject12 = localObject1;
        localObject14 = localObject4;
        localObject11 = localObject2;
        localObject8 = localObject7;
        i29 = j;
        localObject10 = localObject3;
        localObject13 = localObject5;
        break;
      }
      if ("BootstrapMethods".equals(str3))
      {
        int[] arrayOfInt = new int[readUnsignedShort(i7 + 8)];
        int i31 = 0;
        int i32 = i7 + 10;
        while (i31 < arrayOfInt.length)
        {
          arrayOfInt[i31] = i32;
          i32 += (2 + readUnsignedShort(i32 + 2) << 1);
          i31++;
        }
        localContext.d = arrayOfInt;
        localObject8 = localObject7;
        i24 = i4;
        i25 = i3;
        i26 = i2;
        i27 = i1;
        i28 = n;
        localObject9 = localObject6;
        localObject10 = localObject3;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i29 = j;
        localObject13 = localObject5;
        localObject14 = localObject4;
        break;
      }
      localObject8 = a(paramArrayOfAttribute, str3, i7 + 8, readInt(i7 + 4), arrayOfChar, -1, null);
      if (localObject8 != null)
      {
        ((Attribute)localObject8).a = localObject7;
        i24 = i4;
        i25 = i3;
        i26 = i2;
        i27 = i1;
        i28 = n;
        localObject9 = localObject6;
        localObject10 = localObject3;
        localObject11 = localObject2;
        localObject12 = localObject1;
        i29 = j;
        localObject13 = localObject5;
        localObject14 = localObject4;
        break;
        paramClassVisitor.visit(readInt(-7 + this.a[1]), j, str1, localObject1, str2, arrayOfString);
        if (((paramInt & 0x2) == 0) && ((localObject2 != null) || (localObject3 != null)))
          paramClassVisitor.visitSource(localObject2, localObject3);
        if (localObject4 != null)
          paramClassVisitor.visitOuterClass(localObject4, localObject5, localObject6);
        if (n != 0)
        {
          int i22 = readUnsignedShort(n);
          int i23 = n + 2;
          while (i22 > 0)
          {
            i23 = a(i23 + 2, arrayOfChar, true, paramClassVisitor.visitAnnotation(readUTF8(i23, arrayOfChar), true));
            i22--;
          }
        }
        if (i1 != 0)
        {
          int i20 = readUnsignedShort(i1);
          int i21 = i1 + 2;
          while (i20 > 0)
          {
            i21 = a(i21 + 2, arrayOfChar, true, paramClassVisitor.visitAnnotation(readUTF8(i21, arrayOfChar), false));
            i20--;
          }
        }
        if (i2 != 0)
        {
          int i17 = readUnsignedShort(i2);
          int i18 = i2 + 2;
          while (i17 > 0)
          {
            int i19 = a(localContext, i18);
            i18 = a(i19 + 2, arrayOfChar, true, paramClassVisitor.visitTypeAnnotation(localContext.i, localContext.j, readUTF8(i19, arrayOfChar), true));
            i17--;
          }
        }
        if (i3 != 0)
        {
          int i14 = readUnsignedShort(i3);
          int i15 = i3 + 2;
          while (i14 > 0)
          {
            int i16 = a(localContext, i15);
            i15 = a(i16 + 2, arrayOfChar, true, paramClassVisitor.visitTypeAnnotation(localContext.i, localContext.j, readUTF8(i16, arrayOfChar), false));
            i14--;
          }
        }
        while (localObject7 != null)
        {
          Attribute localAttribute = localObject7.a;
          localObject7.a = null;
          paramClassVisitor.visitAttribute(localObject7);
          localObject7 = localAttribute;
        }
        if (i4 != 0)
        {
          int i12 = i4 + 2;
          for (int i13 = readUnsignedShort(i4); i13 > 0; i13--)
          {
            paramClassVisitor.visitInnerClass(readClass(i12, arrayOfChar), readClass(i12 + 2, arrayOfChar), readUTF8(i12 + 4, arrayOfChar), readUnsignedShort(i12 + 6));
            i12 += 8;
          }
        }
        int i8 = 10 + this.header + 2 * arrayOfString.length;
        for (int i9 = readUnsignedShort(i8 - 2); i9 > 0; i9--)
          i8 = a(paramClassVisitor, localContext, i8);
        int i10 = i8 + 2;
        for (int i11 = readUnsignedShort(i10 - 2); i11 > 0; i11--)
          i10 = b(paramClassVisitor, localContext, i10);
        paramClassVisitor.visitEnd();
        return;
      }
      localObject8 = localObject7;
      i24 = i4;
      i25 = i3;
      i26 = i2;
      i27 = i1;
      i28 = n;
      localObject9 = localObject6;
      localObject10 = localObject3;
      localObject11 = localObject2;
      localObject12 = localObject1;
      i29 = j;
      localObject13 = localObject5;
      localObject14 = localObject4;
      break;
      label1955: localObject15 = localObject6;
      localObject16 = localObject5;
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
    return readClass(4 + this.header, new char[this.d]);
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
    String str1;
    if ((paramInt == 0) || (i == 0))
      str1 = null;
    do
    {
      return str1;
      str1 = this.c[i];
    }
    while (str1 != null);
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

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objectweb.asm.ClassReader
 * JD-Core Version:    0.6.2
 */