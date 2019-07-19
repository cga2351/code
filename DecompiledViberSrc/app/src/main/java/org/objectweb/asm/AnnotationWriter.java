package org.objectweb.asm;

final class AnnotationWriter extends AnnotationVisitor
{
  private final ClassWriter a;
  private int b;
  private final boolean c;
  private final ByteVector d;
  private final ByteVector e;
  private final int f;
  AnnotationWriter g;
  AnnotationWriter h;

  AnnotationWriter(ClassWriter paramClassWriter, boolean paramBoolean, ByteVector paramByteVector1, ByteVector paramByteVector2, int paramInt)
  {
    super(327680);
    this.a = paramClassWriter;
    this.c = paramBoolean;
    this.d = paramByteVector1;
    this.e = paramByteVector2;
    this.f = paramInt;
  }

  static void a(int paramInt, TypePath paramTypePath, ByteVector paramByteVector)
  {
    switch (paramInt >>> 24)
    {
    default:
      paramByteVector.b(paramInt >>> 24, (0xFFFF00 & paramInt) >> 8);
    case 0:
    case 1:
    case 22:
    case 19:
    case 20:
    case 21:
    case 71:
    case 72:
    case 73:
    case 74:
    case 75:
    }
    while (paramTypePath == null)
    {
      paramByteVector.putByte(0);
      return;
      paramByteVector.putShort(paramInt >>> 16);
      continue;
      paramByteVector.putByte(paramInt >>> 24);
      continue;
      paramByteVector.putInt(paramInt);
    }
    int i = 1 + 2 * paramTypePath.a[paramTypePath.b];
    paramByteVector.putByteArray(paramTypePath.a, paramTypePath.b, i);
  }

  static void a(AnnotationWriter[] paramArrayOfAnnotationWriter, int paramInt, ByteVector paramByteVector)
  {
    int i = 1 + 2 * (paramArrayOfAnnotationWriter.length - paramInt);
    int j = paramInt;
    if (j < paramArrayOfAnnotationWriter.length)
    {
      if (paramArrayOfAnnotationWriter[j] == null);
      for (int m = 0; ; m = paramArrayOfAnnotationWriter[j].a())
      {
        i += m;
        j++;
        break;
      }
    }
    paramByteVector.putInt(i).putByte(paramArrayOfAnnotationWriter.length - paramInt);
    while (paramInt < paramArrayOfAnnotationWriter.length)
    {
      Object localObject1 = paramArrayOfAnnotationWriter[paramInt];
      Object localObject2 = null;
      int k = 0;
      while (localObject1 != null)
      {
        k++;
        ((AnnotationWriter)localObject1).visitEnd();
        ((AnnotationWriter)localObject1).h = ((AnnotationWriter)localObject2);
        AnnotationWriter localAnnotationWriter = ((AnnotationWriter)localObject1).g;
        Object localObject3 = localObject1;
        localObject1 = localAnnotationWriter;
        localObject2 = localObject3;
      }
      paramByteVector.putShort(k);
      while (localObject2 != null)
      {
        paramByteVector.putByteArray(((AnnotationWriter)localObject2).d.a, 0, ((AnnotationWriter)localObject2).d.b);
        localObject2 = ((AnnotationWriter)localObject2).h;
      }
      paramInt++;
    }
  }

  int a()
  {
    int i = 0;
    while (this != null)
    {
      i += this.d.b;
      this = this.g;
    }
    return i;
  }

  void a(ByteVector paramByteVector)
  {
    Object localObject1 = null;
    int i = 2;
    int j = 0;
    AnnotationWriter localAnnotationWriter;
    for (Object localObject2 = this; localObject2 != null; localObject2 = localAnnotationWriter)
    {
      j++;
      i += ((AnnotationWriter)localObject2).d.b;
      ((AnnotationWriter)localObject2).visitEnd();
      ((AnnotationWriter)localObject2).h = ((AnnotationWriter)localObject1);
      localAnnotationWriter = ((AnnotationWriter)localObject2).g;
      localObject1 = localObject2;
    }
    paramByteVector.putInt(i);
    paramByteVector.putShort(j);
    while (localObject1 != null)
    {
      paramByteVector.putByteArray(((AnnotationWriter)localObject1).d.a, 0, ((AnnotationWriter)localObject1).d.b);
      localObject1 = ((AnnotationWriter)localObject1).h;
    }
  }

  public void visit(String paramString, Object paramObject)
  {
    int i = 1;
    int j = 0;
    this.b = (1 + this.b);
    if (this.c)
      this.d.putShort(this.a.newUTF8(paramString));
    if ((paramObject instanceof String))
      this.d.b(115, this.a.newUTF8((String)paramObject));
    while (true)
    {
      return;
      if ((paramObject instanceof Byte))
      {
        this.d.b(66, this.a.a(((Byte)paramObject).byteValue()).a);
        return;
      }
      if ((paramObject instanceof Boolean))
      {
        if (((Boolean)paramObject).booleanValue());
        while (true)
        {
          this.d.b(90, this.a.a(i).a);
          return;
          i = 0;
        }
      }
      if ((paramObject instanceof Character))
      {
        this.d.b(67, this.a.a(((Character)paramObject).charValue()).a);
        return;
      }
      if ((paramObject instanceof Short))
      {
        this.d.b(83, this.a.a(((Short)paramObject).shortValue()).a);
        return;
      }
      if ((paramObject instanceof Type))
      {
        this.d.b(99, this.a.newUTF8(((Type)paramObject).getDescriptor()));
        return;
      }
      if ((paramObject instanceof byte[]))
      {
        byte[] arrayOfByte = (byte[])paramObject;
        this.d.b(91, arrayOfByte.length);
        while (j < arrayOfByte.length)
        {
          this.d.b(66, this.a.a(arrayOfByte[j]).a);
          j++;
        }
      }
      else
      {
        if ((paramObject instanceof boolean[]))
        {
          boolean[] arrayOfBoolean = (boolean[])paramObject;
          this.d.b(91, arrayOfBoolean.length);
          int k = 0;
          label348: ByteVector localByteVector;
          ClassWriter localClassWriter;
          if (k < arrayOfBoolean.length)
          {
            localByteVector = this.d;
            localClassWriter = this.a;
            if (arrayOfBoolean[k] == 0)
              break label403;
          }
          label403: for (int m = i; ; m = 0)
          {
            localByteVector.b(90, localClassWriter.a(m).a);
            k++;
            break label348;
            break;
          }
        }
        if ((paramObject instanceof short[]))
        {
          short[] arrayOfShort = (short[])paramObject;
          this.d.b(91, arrayOfShort.length);
          while (j < arrayOfShort.length)
          {
            this.d.b(83, this.a.a(arrayOfShort[j]).a);
            j++;
          }
        }
        else if ((paramObject instanceof char[]))
        {
          char[] arrayOfChar = (char[])paramObject;
          this.d.b(91, arrayOfChar.length);
          while (j < arrayOfChar.length)
          {
            this.d.b(67, this.a.a(arrayOfChar[j]).a);
            j++;
          }
        }
        else if ((paramObject instanceof int[]))
        {
          int[] arrayOfInt = (int[])paramObject;
          this.d.b(91, arrayOfInt.length);
          while (j < arrayOfInt.length)
          {
            this.d.b(73, this.a.a(arrayOfInt[j]).a);
            j++;
          }
        }
        else if ((paramObject instanceof long[]))
        {
          long[] arrayOfLong = (long[])paramObject;
          this.d.b(91, arrayOfLong.length);
          while (j < arrayOfLong.length)
          {
            this.d.b(74, this.a.a(arrayOfLong[j]).a);
            j++;
          }
        }
        else if ((paramObject instanceof float[]))
        {
          float[] arrayOfFloat = (float[])paramObject;
          this.d.b(91, arrayOfFloat.length);
          while (j < arrayOfFloat.length)
          {
            this.d.b(70, this.a.a(arrayOfFloat[j]).a);
            j++;
          }
        }
        else
        {
          if (!(paramObject instanceof double[]))
            break;
          double[] arrayOfDouble = (double[])paramObject;
          this.d.b(91, arrayOfDouble.length);
          while (j < arrayOfDouble.length)
          {
            this.d.b(68, this.a.a(arrayOfDouble[j]).a);
            j++;
          }
        }
      }
    }
    Item localItem = this.a.a(paramObject);
    this.d.b(".s.IFJDCS".charAt(localItem.b), localItem.a);
  }

  public AnnotationVisitor visitAnnotation(String paramString1, String paramString2)
  {
    this.b = (1 + this.b);
    if (this.c)
      this.d.putShort(this.a.newUTF8(paramString1));
    this.d.b(64, this.a.newUTF8(paramString2)).putShort(0);
    return new AnnotationWriter(this.a, true, this.d, this.d, -2 + this.d.b);
  }

  public AnnotationVisitor visitArray(String paramString)
  {
    this.b = (1 + this.b);
    if (this.c)
      this.d.putShort(this.a.newUTF8(paramString));
    this.d.b(91, 0);
    return new AnnotationWriter(this.a, false, this.d, this.d, -2 + this.d.b);
  }

  public void visitEnd()
  {
    if (this.e != null)
    {
      byte[] arrayOfByte = this.e.a;
      arrayOfByte[this.f] = ((byte)(this.b >>> 8));
      arrayOfByte[(1 + this.f)] = ((byte)this.b);
    }
  }

  public void visitEnum(String paramString1, String paramString2, String paramString3)
  {
    this.b = (1 + this.b);
    if (this.c)
      this.d.putShort(this.a.newUTF8(paramString1));
    this.d.b(101, this.a.newUTF8(paramString2)).putShort(this.a.newUTF8(paramString3));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objectweb.asm.AnnotationWriter
 * JD-Core Version:    0.6.2
 */