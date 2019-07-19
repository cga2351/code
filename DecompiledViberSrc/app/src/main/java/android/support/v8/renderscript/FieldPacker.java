package android.support.v8.renderscript;

import android.util.Log;
import java.util.BitSet;

public class FieldPacker
{
  private BitSet mAlignment;
  private byte[] mData;
  private int mLen;
  private int mPos;

  public FieldPacker(int paramInt)
  {
    this.mPos = 0;
    this.mLen = paramInt;
    this.mData = new byte[paramInt];
    this.mAlignment = new BitSet();
  }

  public FieldPacker(byte[] paramArrayOfByte)
  {
    this.mPos = paramArrayOfByte.length;
    this.mLen = paramArrayOfByte.length;
    this.mData = paramArrayOfByte;
    this.mAlignment = new BitSet();
  }

  private void addSafely(Object paramObject)
  {
    int i = this.mPos;
    while (true)
    {
      int j = 0;
      try
      {
        addToPack(this, paramObject);
        if (j != 0)
          continue;
        return;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        while (true)
        {
          this.mPos = i;
          resize(2 * this.mLen);
          j = 1;
        }
      }
    }
  }

  private static void addToPack(FieldPacker paramFieldPacker, Object paramObject)
  {
    if ((paramObject instanceof Boolean))
      paramFieldPacker.addBoolean(((Boolean)paramObject).booleanValue());
    do
    {
      return;
      if ((paramObject instanceof Byte))
      {
        paramFieldPacker.addI8(((Byte)paramObject).byteValue());
        return;
      }
      if ((paramObject instanceof Short))
      {
        paramFieldPacker.addI16(((Short)paramObject).shortValue());
        return;
      }
      if ((paramObject instanceof Integer))
      {
        paramFieldPacker.addI32(((Integer)paramObject).intValue());
        return;
      }
      if ((paramObject instanceof Long))
      {
        paramFieldPacker.addI64(((Long)paramObject).longValue());
        return;
      }
      if ((paramObject instanceof Float))
      {
        paramFieldPacker.addF32(((Float)paramObject).floatValue());
        return;
      }
      if ((paramObject instanceof Double))
      {
        paramFieldPacker.addF64(((Double)paramObject).doubleValue());
        return;
      }
      if ((paramObject instanceof Byte2))
      {
        paramFieldPacker.addI8((Byte2)paramObject);
        return;
      }
      if ((paramObject instanceof Byte3))
      {
        paramFieldPacker.addI8((Byte3)paramObject);
        return;
      }
      if ((paramObject instanceof Byte4))
      {
        paramFieldPacker.addI8((Byte4)paramObject);
        return;
      }
      if ((paramObject instanceof Short2))
      {
        paramFieldPacker.addI16((Short2)paramObject);
        return;
      }
      if ((paramObject instanceof Short3))
      {
        paramFieldPacker.addI16((Short3)paramObject);
        return;
      }
      if ((paramObject instanceof Short4))
      {
        paramFieldPacker.addI16((Short4)paramObject);
        return;
      }
      if ((paramObject instanceof Int2))
      {
        paramFieldPacker.addI32((Int2)paramObject);
        return;
      }
      if ((paramObject instanceof Int3))
      {
        paramFieldPacker.addI32((Int3)paramObject);
        return;
      }
      if ((paramObject instanceof Int4))
      {
        paramFieldPacker.addI32((Int4)paramObject);
        return;
      }
      if ((paramObject instanceof Long2))
      {
        paramFieldPacker.addI64((Long2)paramObject);
        return;
      }
      if ((paramObject instanceof Long3))
      {
        paramFieldPacker.addI64((Long3)paramObject);
        return;
      }
      if ((paramObject instanceof Long4))
      {
        paramFieldPacker.addI64((Long4)paramObject);
        return;
      }
      if ((paramObject instanceof Float2))
      {
        paramFieldPacker.addF32((Float2)paramObject);
        return;
      }
      if ((paramObject instanceof Float3))
      {
        paramFieldPacker.addF32((Float3)paramObject);
        return;
      }
      if ((paramObject instanceof Float4))
      {
        paramFieldPacker.addF32((Float4)paramObject);
        return;
      }
      if ((paramObject instanceof Double2))
      {
        paramFieldPacker.addF64((Double2)paramObject);
        return;
      }
      if ((paramObject instanceof Double3))
      {
        paramFieldPacker.addF64((Double3)paramObject);
        return;
      }
      if ((paramObject instanceof Double4))
      {
        paramFieldPacker.addF64((Double4)paramObject);
        return;
      }
      if ((paramObject instanceof Matrix2f))
      {
        paramFieldPacker.addMatrix((Matrix2f)paramObject);
        return;
      }
      if ((paramObject instanceof Matrix3f))
      {
        paramFieldPacker.addMatrix((Matrix3f)paramObject);
        return;
      }
      if ((paramObject instanceof Matrix4f))
      {
        paramFieldPacker.addMatrix((Matrix4f)paramObject);
        return;
      }
    }
    while (!(paramObject instanceof BaseObj));
    paramFieldPacker.addObj((BaseObj)paramObject);
  }

  static FieldPacker createFieldPack(Object[] paramArrayOfObject)
  {
    int i = 0;
    int j = paramArrayOfObject.length;
    int k = 0;
    int m = 0;
    while (k < j)
    {
      m += getPackedSize(paramArrayOfObject[k]);
      k++;
    }
    FieldPacker localFieldPacker = new FieldPacker(m);
    int n = paramArrayOfObject.length;
    while (i < n)
    {
      addToPack(localFieldPacker, paramArrayOfObject[i]);
      i++;
    }
    return localFieldPacker;
  }

  static FieldPacker createFromArray(Object[] paramArrayOfObject)
  {
    FieldPacker localFieldPacker = new FieldPacker(8 * RenderScript.sPointerSize);
    int i = paramArrayOfObject.length;
    for (int j = 0; j < i; j++)
      localFieldPacker.addSafely(paramArrayOfObject[j]);
    localFieldPacker.resize(localFieldPacker.mPos);
    return localFieldPacker;
  }

  private static int getPackedSize(Object paramObject)
  {
    if ((paramObject instanceof Boolean));
    while ((paramObject instanceof Byte))
      return 1;
    if ((paramObject instanceof Short))
      return 2;
    if ((paramObject instanceof Integer))
      return 4;
    if ((paramObject instanceof Long))
      return 8;
    if ((paramObject instanceof Float))
      return 4;
    if ((paramObject instanceof Double))
      return 8;
    if ((paramObject instanceof Byte2))
      return 2;
    if ((paramObject instanceof Byte3))
      return 3;
    if ((paramObject instanceof Byte4))
      return 4;
    if ((paramObject instanceof Short2))
      return 4;
    if ((paramObject instanceof Short3))
      return 6;
    if ((paramObject instanceof Short4))
      return 8;
    if ((paramObject instanceof Int2))
      return 8;
    if ((paramObject instanceof Int3))
      return 12;
    if ((paramObject instanceof Int4))
      return 16;
    if ((paramObject instanceof Long2))
      return 16;
    if ((paramObject instanceof Long3))
      return 24;
    if ((paramObject instanceof Long4))
      return 32;
    if ((paramObject instanceof Float2))
      return 8;
    if ((paramObject instanceof Float3))
      return 12;
    if ((paramObject instanceof Float4))
      return 16;
    if ((paramObject instanceof Double2))
      return 16;
    if ((paramObject instanceof Double3))
      return 24;
    if ((paramObject instanceof Double4))
      return 32;
    if ((paramObject instanceof Matrix2f))
      return 16;
    if ((paramObject instanceof Matrix3f))
      return 36;
    if ((paramObject instanceof Matrix4f))
      return 64;
    if ((paramObject instanceof BaseObj))
    {
      if (RenderScript.sPointerSize == 8)
        return 32;
      return 4;
    }
    return 0;
  }

  private boolean resize(int paramInt)
  {
    if (paramInt == this.mLen)
      return false;
    byte[] arrayOfByte = new byte[paramInt];
    System.arraycopy(this.mData, 0, arrayOfByte, 0, this.mPos);
    this.mData = arrayOfByte;
    this.mLen = paramInt;
    return true;
  }

  public void addBoolean(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      addI8((byte)i);
      return;
    }
  }

  public void addF32(float paramFloat)
  {
    addI32(Float.floatToRawIntBits(paramFloat));
  }

  public void addF32(Float2 paramFloat2)
  {
    addF32(paramFloat2.x);
    addF32(paramFloat2.y);
  }

  public void addF32(Float3 paramFloat3)
  {
    addF32(paramFloat3.x);
    addF32(paramFloat3.y);
    addF32(paramFloat3.z);
  }

  public void addF32(Float4 paramFloat4)
  {
    addF32(paramFloat4.x);
    addF32(paramFloat4.y);
    addF32(paramFloat4.z);
    addF32(paramFloat4.w);
  }

  public void addF64(double paramDouble)
  {
    addI64(Double.doubleToRawLongBits(paramDouble));
  }

  public void addF64(Double2 paramDouble2)
  {
    addF64(paramDouble2.x);
    addF64(paramDouble2.y);
  }

  public void addF64(Double3 paramDouble3)
  {
    addF64(paramDouble3.x);
    addF64(paramDouble3.y);
    addF64(paramDouble3.z);
  }

  public void addF64(Double4 paramDouble4)
  {
    addF64(paramDouble4.x);
    addF64(paramDouble4.y);
    addF64(paramDouble4.z);
    addF64(paramDouble4.w);
  }

  public void addI16(Short2 paramShort2)
  {
    addI16(paramShort2.x);
    addI16(paramShort2.y);
  }

  public void addI16(Short3 paramShort3)
  {
    addI16(paramShort3.x);
    addI16(paramShort3.y);
    addI16(paramShort3.z);
  }

  public void addI16(Short4 paramShort4)
  {
    addI16(paramShort4.x);
    addI16(paramShort4.y);
    addI16(paramShort4.z);
    addI16(paramShort4.w);
  }

  public void addI16(short paramShort)
  {
    align(2);
    byte[] arrayOfByte1 = this.mData;
    int i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte1[i] = ((byte)(paramShort & 0xFF));
    byte[] arrayOfByte2 = this.mData;
    int j = this.mPos;
    this.mPos = (j + 1);
    arrayOfByte2[j] = ((byte)(paramShort >> 8));
  }

  public void addI32(int paramInt)
  {
    align(4);
    byte[] arrayOfByte1 = this.mData;
    int i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte1[i] = ((byte)(paramInt & 0xFF));
    byte[] arrayOfByte2 = this.mData;
    int j = this.mPos;
    this.mPos = (j + 1);
    arrayOfByte2[j] = ((byte)(0xFF & paramInt >> 8));
    byte[] arrayOfByte3 = this.mData;
    int k = this.mPos;
    this.mPos = (k + 1);
    arrayOfByte3[k] = ((byte)(0xFF & paramInt >> 16));
    byte[] arrayOfByte4 = this.mData;
    int m = this.mPos;
    this.mPos = (m + 1);
    arrayOfByte4[m] = ((byte)(0xFF & paramInt >> 24));
  }

  public void addI32(Int2 paramInt2)
  {
    addI32(paramInt2.x);
    addI32(paramInt2.y);
  }

  public void addI32(Int3 paramInt3)
  {
    addI32(paramInt3.x);
    addI32(paramInt3.y);
    addI32(paramInt3.z);
  }

  public void addI32(Int4 paramInt4)
  {
    addI32(paramInt4.x);
    addI32(paramInt4.y);
    addI32(paramInt4.z);
    addI32(paramInt4.w);
  }

  public void addI64(long paramLong)
  {
    align(8);
    byte[] arrayOfByte1 = this.mData;
    int i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte1[i] = ((byte)(int)(paramLong & 0xFF));
    byte[] arrayOfByte2 = this.mData;
    int j = this.mPos;
    this.mPos = (j + 1);
    arrayOfByte2[j] = ((byte)(int)(0xFF & paramLong >> 8));
    byte[] arrayOfByte3 = this.mData;
    int k = this.mPos;
    this.mPos = (k + 1);
    arrayOfByte3[k] = ((byte)(int)(0xFF & paramLong >> 16));
    byte[] arrayOfByte4 = this.mData;
    int m = this.mPos;
    this.mPos = (m + 1);
    arrayOfByte4[m] = ((byte)(int)(0xFF & paramLong >> 24));
    byte[] arrayOfByte5 = this.mData;
    int n = this.mPos;
    this.mPos = (n + 1);
    arrayOfByte5[n] = ((byte)(int)(0xFF & paramLong >> 32));
    byte[] arrayOfByte6 = this.mData;
    int i1 = this.mPos;
    this.mPos = (i1 + 1);
    arrayOfByte6[i1] = ((byte)(int)(0xFF & paramLong >> 40));
    byte[] arrayOfByte7 = this.mData;
    int i2 = this.mPos;
    this.mPos = (i2 + 1);
    arrayOfByte7[i2] = ((byte)(int)(0xFF & paramLong >> 48));
    byte[] arrayOfByte8 = this.mData;
    int i3 = this.mPos;
    this.mPos = (i3 + 1);
    arrayOfByte8[i3] = ((byte)(int)(0xFF & paramLong >> 56));
  }

  public void addI64(Long2 paramLong2)
  {
    addI64(paramLong2.x);
    addI64(paramLong2.y);
  }

  public void addI64(Long3 paramLong3)
  {
    addI64(paramLong3.x);
    addI64(paramLong3.y);
    addI64(paramLong3.z);
  }

  public void addI64(Long4 paramLong4)
  {
    addI64(paramLong4.x);
    addI64(paramLong4.y);
    addI64(paramLong4.z);
    addI64(paramLong4.w);
  }

  public void addI8(byte paramByte)
  {
    byte[] arrayOfByte = this.mData;
    int i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte[i] = paramByte;
  }

  public void addI8(Byte2 paramByte2)
  {
    addI8(paramByte2.x);
    addI8(paramByte2.y);
  }

  public void addI8(Byte3 paramByte3)
  {
    addI8(paramByte3.x);
    addI8(paramByte3.y);
    addI8(paramByte3.z);
  }

  public void addI8(Byte4 paramByte4)
  {
    addI8(paramByte4.x);
    addI8(paramByte4.y);
    addI8(paramByte4.z);
    addI8(paramByte4.w);
  }

  public void addMatrix(Matrix2f paramMatrix2f)
  {
    for (int i = 0; i < paramMatrix2f.mMat.length; i++)
      addF32(paramMatrix2f.mMat[i]);
  }

  public void addMatrix(Matrix3f paramMatrix3f)
  {
    for (int i = 0; i < paramMatrix3f.mMat.length; i++)
      addF32(paramMatrix3f.mMat[i]);
  }

  public void addMatrix(Matrix4f paramMatrix4f)
  {
    for (int i = 0; i < paramMatrix4f.mMat.length; i++)
      addF32(paramMatrix4f.mMat[i]);
  }

  public void addObj(BaseObj paramBaseObj)
  {
    if (paramBaseObj != null)
    {
      if (RenderScript.sPointerSize == 8)
      {
        addI64(paramBaseObj.getID(null));
        addI64(0L);
        addI64(0L);
        addI64(0L);
        return;
      }
      addI32((int)paramBaseObj.getID(null));
      return;
    }
    if (RenderScript.sPointerSize == 8)
    {
      addI64(0L);
      addI64(0L);
      addI64(0L);
      addI64(0L);
      return;
    }
    addI32(0);
  }

  public void addU16(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 65535))
    {
      Log.e("rs", "FieldPacker.addU16( " + paramInt + " )");
      throw new IllegalArgumentException("Saving value out of range for type");
    }
    align(2);
    byte[] arrayOfByte1 = this.mData;
    int i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte1[i] = ((byte)(paramInt & 0xFF));
    byte[] arrayOfByte2 = this.mData;
    int j = this.mPos;
    this.mPos = (j + 1);
    arrayOfByte2[j] = ((byte)(paramInt >> 8));
  }

  public void addU16(Int2 paramInt2)
  {
    addU16(paramInt2.x);
    addU16(paramInt2.y);
  }

  public void addU16(Int3 paramInt3)
  {
    addU16(paramInt3.x);
    addU16(paramInt3.y);
    addU16(paramInt3.z);
  }

  public void addU16(Int4 paramInt4)
  {
    addU16(paramInt4.x);
    addU16(paramInt4.y);
    addU16(paramInt4.z);
    addU16(paramInt4.w);
  }

  public void addU32(long paramLong)
  {
    if ((paramLong < 0L) || (paramLong > 4294967295L))
    {
      Log.e("rs", "FieldPacker.addU32( " + paramLong + " )");
      throw new IllegalArgumentException("Saving value out of range for type");
    }
    align(4);
    byte[] arrayOfByte1 = this.mData;
    int i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte1[i] = ((byte)(int)(paramLong & 0xFF));
    byte[] arrayOfByte2 = this.mData;
    int j = this.mPos;
    this.mPos = (j + 1);
    arrayOfByte2[j] = ((byte)(int)(0xFF & paramLong >> 8));
    byte[] arrayOfByte3 = this.mData;
    int k = this.mPos;
    this.mPos = (k + 1);
    arrayOfByte3[k] = ((byte)(int)(0xFF & paramLong >> 16));
    byte[] arrayOfByte4 = this.mData;
    int m = this.mPos;
    this.mPos = (m + 1);
    arrayOfByte4[m] = ((byte)(int)(0xFF & paramLong >> 24));
  }

  public void addU32(Long2 paramLong2)
  {
    addU32(paramLong2.x);
    addU32(paramLong2.y);
  }

  public void addU32(Long3 paramLong3)
  {
    addU32(paramLong3.x);
    addU32(paramLong3.y);
    addU32(paramLong3.z);
  }

  public void addU32(Long4 paramLong4)
  {
    addU32(paramLong4.x);
    addU32(paramLong4.y);
    addU32(paramLong4.z);
    addU32(paramLong4.w);
  }

  public void addU64(long paramLong)
  {
    if (paramLong < 0L)
    {
      Log.e("rs", "FieldPacker.addU64( " + paramLong + " )");
      throw new IllegalArgumentException("Saving value out of range for type");
    }
    align(8);
    byte[] arrayOfByte1 = this.mData;
    int i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte1[i] = ((byte)(int)(paramLong & 0xFF));
    byte[] arrayOfByte2 = this.mData;
    int j = this.mPos;
    this.mPos = (j + 1);
    arrayOfByte2[j] = ((byte)(int)(0xFF & paramLong >> 8));
    byte[] arrayOfByte3 = this.mData;
    int k = this.mPos;
    this.mPos = (k + 1);
    arrayOfByte3[k] = ((byte)(int)(0xFF & paramLong >> 16));
    byte[] arrayOfByte4 = this.mData;
    int m = this.mPos;
    this.mPos = (m + 1);
    arrayOfByte4[m] = ((byte)(int)(0xFF & paramLong >> 24));
    byte[] arrayOfByte5 = this.mData;
    int n = this.mPos;
    this.mPos = (n + 1);
    arrayOfByte5[n] = ((byte)(int)(0xFF & paramLong >> 32));
    byte[] arrayOfByte6 = this.mData;
    int i1 = this.mPos;
    this.mPos = (i1 + 1);
    arrayOfByte6[i1] = ((byte)(int)(0xFF & paramLong >> 40));
    byte[] arrayOfByte7 = this.mData;
    int i2 = this.mPos;
    this.mPos = (i2 + 1);
    arrayOfByte7[i2] = ((byte)(int)(0xFF & paramLong >> 48));
    byte[] arrayOfByte8 = this.mData;
    int i3 = this.mPos;
    this.mPos = (i3 + 1);
    arrayOfByte8[i3] = ((byte)(int)(0xFF & paramLong >> 56));
  }

  public void addU64(Long2 paramLong2)
  {
    addU64(paramLong2.x);
    addU64(paramLong2.y);
  }

  public void addU64(Long3 paramLong3)
  {
    addU64(paramLong3.x);
    addU64(paramLong3.y);
    addU64(paramLong3.z);
  }

  public void addU64(Long4 paramLong4)
  {
    addU64(paramLong4.x);
    addU64(paramLong4.y);
    addU64(paramLong4.z);
    addU64(paramLong4.w);
  }

  public void addU8(Short2 paramShort2)
  {
    addU8(paramShort2.x);
    addU8(paramShort2.y);
  }

  public void addU8(Short3 paramShort3)
  {
    addU8(paramShort3.x);
    addU8(paramShort3.y);
    addU8(paramShort3.z);
  }

  public void addU8(Short4 paramShort4)
  {
    addU8(paramShort4.x);
    addU8(paramShort4.y);
    addU8(paramShort4.z);
    addU8(paramShort4.w);
  }

  public void addU8(short paramShort)
  {
    if ((paramShort < 0) || (paramShort > 255))
    {
      Log.e("rs", "FieldPacker.addU8( " + paramShort + " )");
      throw new IllegalArgumentException("Saving value out of range for type");
    }
    byte[] arrayOfByte = this.mData;
    int i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte[i] = ((byte)paramShort);
  }

  public void align(int paramInt)
  {
    if ((paramInt <= 0) || ((paramInt & paramInt - 1) != 0))
      throw new RSIllegalArgumentException("argument must be a non-negative non-zero power of 2: " + paramInt);
    while ((this.mPos & paramInt - 1) != 0)
    {
      this.mAlignment.flip(this.mPos);
      byte[] arrayOfByte = this.mData;
      int i = this.mPos;
      this.mPos = (i + 1);
      arrayOfByte[i] = 0;
    }
  }

  public final byte[] getData()
  {
    return this.mData;
  }

  public int getPos()
  {
    return this.mPos;
  }

  public void reset()
  {
    this.mPos = 0;
  }

  public void reset(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.mLen))
      throw new RSIllegalArgumentException("out of range argument: " + paramInt);
    this.mPos = paramInt;
  }

  public void skip(int paramInt)
  {
    int i = paramInt + this.mPos;
    if ((i < 0) || (i > this.mLen))
      throw new RSIllegalArgumentException("out of range argument: " + paramInt);
    this.mPos = i;
  }

  public boolean subBoolean()
  {
    return subI8() == 1;
  }

  public Byte2 subByte2()
  {
    Byte2 localByte2 = new Byte2();
    localByte2.y = subI8();
    localByte2.x = subI8();
    return localByte2;
  }

  public Byte3 subByte3()
  {
    Byte3 localByte3 = new Byte3();
    localByte3.z = subI8();
    localByte3.y = subI8();
    localByte3.x = subI8();
    return localByte3;
  }

  public Byte4 subByte4()
  {
    Byte4 localByte4 = new Byte4();
    localByte4.w = subI8();
    localByte4.z = subI8();
    localByte4.y = subI8();
    localByte4.x = subI8();
    return localByte4;
  }

  public Double2 subDouble2()
  {
    Double2 localDouble2 = new Double2();
    localDouble2.y = subF64();
    localDouble2.x = subF64();
    return localDouble2;
  }

  public Double3 subDouble3()
  {
    Double3 localDouble3 = new Double3();
    localDouble3.z = subF64();
    localDouble3.y = subF64();
    localDouble3.x = subF64();
    return localDouble3;
  }

  public Double4 subDouble4()
  {
    Double4 localDouble4 = new Double4();
    localDouble4.w = subF64();
    localDouble4.z = subF64();
    localDouble4.y = subF64();
    localDouble4.x = subF64();
    return localDouble4;
  }

  public float subF32()
  {
    return Float.intBitsToFloat(subI32());
  }

  public double subF64()
  {
    return Double.longBitsToDouble(subI64());
  }

  public Float2 subFloat2()
  {
    Float2 localFloat2 = new Float2();
    localFloat2.y = subF32();
    localFloat2.x = subF32();
    return localFloat2;
  }

  public Float3 subFloat3()
  {
    Float3 localFloat3 = new Float3();
    localFloat3.z = subF32();
    localFloat3.y = subF32();
    localFloat3.x = subF32();
    return localFloat3;
  }

  public Float4 subFloat4()
  {
    Float4 localFloat4 = new Float4();
    localFloat4.w = subF32();
    localFloat4.z = subF32();
    localFloat4.y = subF32();
    localFloat4.x = subF32();
    return localFloat4;
  }

  public short subI16()
  {
    subalign(2);
    byte[] arrayOfByte1 = this.mData;
    int i = -1 + this.mPos;
    this.mPos = i;
    int j = (short)((0xFF & arrayOfByte1[i]) << 8);
    byte[] arrayOfByte2 = this.mData;
    int k = -1 + this.mPos;
    this.mPos = k;
    return (short)(j | (short)(0xFF & arrayOfByte2[k]));
  }

  public int subI32()
  {
    subalign(4);
    byte[] arrayOfByte1 = this.mData;
    int i = -1 + this.mPos;
    this.mPos = i;
    int j = (0xFF & arrayOfByte1[i]) << 24;
    byte[] arrayOfByte2 = this.mData;
    int k = -1 + this.mPos;
    this.mPos = k;
    int m = j | (0xFF & arrayOfByte2[k]) << 16;
    byte[] arrayOfByte3 = this.mData;
    int n = -1 + this.mPos;
    this.mPos = n;
    int i1 = m | (0xFF & arrayOfByte3[n]) << 8;
    byte[] arrayOfByte4 = this.mData;
    int i2 = -1 + this.mPos;
    this.mPos = i2;
    return i1 | 0xFF & arrayOfByte4[i2];
  }

  public long subI64()
  {
    subalign(8);
    byte[] arrayOfByte1 = this.mData;
    int i = -1 + this.mPos;
    this.mPos = i;
    long l1 = 0L | (0xFF & arrayOfByte1[i]) << 56;
    byte[] arrayOfByte2 = this.mData;
    int j = -1 + this.mPos;
    this.mPos = j;
    long l2 = l1 | (0xFF & arrayOfByte2[j]) << 48;
    byte[] arrayOfByte3 = this.mData;
    int k = -1 + this.mPos;
    this.mPos = k;
    long l3 = l2 | (0xFF & arrayOfByte3[k]) << 40;
    byte[] arrayOfByte4 = this.mData;
    int m = -1 + this.mPos;
    this.mPos = m;
    long l4 = l3 | (0xFF & arrayOfByte4[m]) << 32;
    byte[] arrayOfByte5 = this.mData;
    int n = -1 + this.mPos;
    this.mPos = n;
    long l5 = l4 | (0xFF & arrayOfByte5[n]) << 24;
    byte[] arrayOfByte6 = this.mData;
    int i1 = -1 + this.mPos;
    this.mPos = i1;
    long l6 = l5 | (0xFF & arrayOfByte6[i1]) << 16;
    byte[] arrayOfByte7 = this.mData;
    int i2 = -1 + this.mPos;
    this.mPos = i2;
    long l7 = l6 | (0xFF & arrayOfByte7[i2]) << 8;
    byte[] arrayOfByte8 = this.mData;
    int i3 = -1 + this.mPos;
    this.mPos = i3;
    return l7 | 0xFF & arrayOfByte8[i3];
  }

  public byte subI8()
  {
    subalign(1);
    byte[] arrayOfByte = this.mData;
    int i = -1 + this.mPos;
    this.mPos = i;
    return arrayOfByte[i];
  }

  public Int2 subInt2()
  {
    Int2 localInt2 = new Int2();
    localInt2.y = subI32();
    localInt2.x = subI32();
    return localInt2;
  }

  public Int3 subInt3()
  {
    Int3 localInt3 = new Int3();
    localInt3.z = subI32();
    localInt3.y = subI32();
    localInt3.x = subI32();
    return localInt3;
  }

  public Int4 subInt4()
  {
    Int4 localInt4 = new Int4();
    localInt4.w = subI32();
    localInt4.z = subI32();
    localInt4.y = subI32();
    localInt4.x = subI32();
    return localInt4;
  }

  public Long2 subLong2()
  {
    Long2 localLong2 = new Long2();
    localLong2.y = subI64();
    localLong2.x = subI64();
    return localLong2;
  }

  public Long3 subLong3()
  {
    Long3 localLong3 = new Long3();
    localLong3.z = subI64();
    localLong3.y = subI64();
    localLong3.x = subI64();
    return localLong3;
  }

  public Long4 subLong4()
  {
    Long4 localLong4 = new Long4();
    localLong4.w = subI64();
    localLong4.z = subI64();
    localLong4.y = subI64();
    localLong4.x = subI64();
    return localLong4;
  }

  public Matrix2f subMatrix2f()
  {
    Matrix2f localMatrix2f = new Matrix2f();
    for (int i = -1 + localMatrix2f.mMat.length; i >= 0; i--)
      localMatrix2f.mMat[i] = subF32();
    return localMatrix2f;
  }

  public Matrix3f subMatrix3f()
  {
    Matrix3f localMatrix3f = new Matrix3f();
    for (int i = -1 + localMatrix3f.mMat.length; i >= 0; i--)
      localMatrix3f.mMat[i] = subF32();
    return localMatrix3f;
  }

  public Matrix4f subMatrix4f()
  {
    Matrix4f localMatrix4f = new Matrix4f();
    for (int i = -1 + localMatrix4f.mMat.length; i >= 0; i--)
      localMatrix4f.mMat[i] = subF32();
    return localMatrix4f;
  }

  public Short2 subShort2()
  {
    Short2 localShort2 = new Short2();
    localShort2.y = subI16();
    localShort2.x = subI16();
    return localShort2;
  }

  public Short3 subShort3()
  {
    Short3 localShort3 = new Short3();
    localShort3.z = subI16();
    localShort3.y = subI16();
    localShort3.x = subI16();
    return localShort3;
  }

  public Short4 subShort4()
  {
    Short4 localShort4 = new Short4();
    localShort4.w = subI16();
    localShort4.z = subI16();
    localShort4.y = subI16();
    localShort4.x = subI16();
    return localShort4;
  }

  public void subalign(int paramInt)
  {
    if ((paramInt & paramInt - 1) != 0)
      throw new RSIllegalArgumentException("argument must be a non-negative non-zero power of 2: " + paramInt);
    while ((this.mPos & paramInt - 1) != 0)
      this.mPos = (-1 + this.mPos);
    if (this.mPos > 0)
      while (this.mAlignment.get(-1 + this.mPos) == true)
      {
        this.mPos = (-1 + this.mPos);
        this.mAlignment.flip(this.mPos);
      }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.FieldPacker
 * JD-Core Version:    0.6.2
 */