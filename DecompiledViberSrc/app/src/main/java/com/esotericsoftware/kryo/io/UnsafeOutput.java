package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.util.UnsafeUtil;
import com.esotericsoftware.kryo.util.Util;
import java.io.OutputStream;
import java.nio.ByteOrder;
import sun.misc.Unsafe;

public final class UnsafeOutput extends Output
{
  private static final boolean isLittleEndian = ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN);
  private boolean supportVarInts = false;

  public UnsafeOutput()
  {
  }

  public UnsafeOutput(int paramInt)
  {
    this(paramInt, paramInt);
  }

  public UnsafeOutput(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }

  public UnsafeOutput(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }

  public UnsafeOutput(OutputStream paramOutputStream, int paramInt)
  {
    super(paramOutputStream, paramInt);
  }

  public UnsafeOutput(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, paramArrayOfByte.length);
  }

  public UnsafeOutput(byte[] paramArrayOfByte, int paramInt)
  {
    super(paramArrayOfByte, paramInt);
  }

  private final void writeBytes(Object paramObject, long paramLong1, long paramLong2, long paramLong3)
    throws KryoException
  {
    int i = Math.min(this.capacity - this.position, (int)paramLong3);
    while (true)
    {
      UnsafeUtil.unsafe().copyMemory(paramObject, paramLong1 + paramLong2, this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position, i);
      this.position = (i + this.position);
      paramLong3 -= i;
      if (paramLong3 == 0L)
        return;
      paramLong2 += i;
      i = Math.min(this.capacity, (int)paramLong3);
      require(i);
    }
  }

  private final void writeLittleEndianInt(int paramInt)
  {
    if (isLittleEndian)
    {
      writeInt(paramInt);
      return;
    }
    writeInt(Util.swapInt(paramInt));
  }

  private final void writeLittleEndianLong(long paramLong)
  {
    if (isLittleEndian)
    {
      writeLong(paramLong);
      return;
    }
    writeLong(Util.swapLong(paramLong));
  }

  public void supportVarInts(boolean paramBoolean)
  {
    this.supportVarInts = paramBoolean;
  }

  public boolean supportVarInts()
  {
    return this.supportVarInts;
  }

  public final void writeBytes(Object paramObject, long paramLong1, long paramLong2)
    throws KryoException
  {
    writeBytes(paramObject, 0L, paramLong1, paramLong2);
  }

  public final void writeChars(char[] paramArrayOfChar)
    throws KryoException
  {
    int i = paramArrayOfChar.length << 1;
    writeBytes(paramArrayOfChar, UnsafeUtil.charArrayBaseOffset, 0L, i);
  }

  public final void writeDouble(double paramDouble)
    throws KryoException
  {
    require(8);
    UnsafeUtil.unsafe().putDouble(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position, paramDouble);
    this.position = (8 + this.position);
  }

  public final void writeDoubles(double[] paramArrayOfDouble)
    throws KryoException
  {
    int i = paramArrayOfDouble.length << 3;
    writeBytes(paramArrayOfDouble, UnsafeUtil.doubleArrayBaseOffset, 0L, i);
  }

  public final void writeFloat(float paramFloat)
    throws KryoException
  {
    require(4);
    UnsafeUtil.unsafe().putFloat(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position, paramFloat);
    this.position = (4 + this.position);
  }

  public final void writeFloats(float[] paramArrayOfFloat)
    throws KryoException
  {
    int i = paramArrayOfFloat.length << 2;
    writeBytes(paramArrayOfFloat, UnsafeUtil.floatArrayBaseOffset, 0L, i);
  }

  public final int writeInt(int paramInt, boolean paramBoolean)
    throws KryoException
  {
    if (!this.supportVarInts)
    {
      writeInt(paramInt);
      return 4;
    }
    return writeVarInt(paramInt, paramBoolean);
  }

  public final void writeInt(int paramInt)
    throws KryoException
  {
    require(4);
    UnsafeUtil.unsafe().putInt(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position, paramInt);
    this.position = (4 + this.position);
  }

  public final void writeInts(int[] paramArrayOfInt)
    throws KryoException
  {
    int i = paramArrayOfInt.length << 2;
    writeBytes(paramArrayOfInt, UnsafeUtil.intArrayBaseOffset, 0L, i);
  }

  public final void writeInts(int[] paramArrayOfInt, boolean paramBoolean)
    throws KryoException
  {
    if (!this.supportVarInts)
    {
      int i = paramArrayOfInt.length << 2;
      writeBytes(paramArrayOfInt, UnsafeUtil.intArrayBaseOffset, 0L, i);
      return;
    }
    super.writeInts(paramArrayOfInt, paramBoolean);
  }

  public final int writeLong(long paramLong, boolean paramBoolean)
    throws KryoException
  {
    if (!this.supportVarInts)
    {
      writeLong(paramLong);
      return 8;
    }
    return writeVarLong(paramLong, paramBoolean);
  }

  public final void writeLong(long paramLong)
    throws KryoException
  {
    require(8);
    UnsafeUtil.unsafe().putLong(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position, paramLong);
    this.position = (8 + this.position);
  }

  public final void writeLongs(long[] paramArrayOfLong)
    throws KryoException
  {
    int i = paramArrayOfLong.length << 3;
    writeBytes(paramArrayOfLong, UnsafeUtil.longArrayBaseOffset, 0L, i);
  }

  public final void writeLongs(long[] paramArrayOfLong, boolean paramBoolean)
    throws KryoException
  {
    if (!this.supportVarInts)
    {
      int i = paramArrayOfLong.length << 3;
      writeBytes(paramArrayOfLong, UnsafeUtil.longArrayBaseOffset, 0L, i);
      return;
    }
    super.writeLongs(paramArrayOfLong, paramBoolean);
  }

  public final void writeShort(int paramInt)
    throws KryoException
  {
    require(2);
    UnsafeUtil.unsafe().putShort(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position, (short)paramInt);
    this.position = (2 + this.position);
  }

  public final void writeShorts(short[] paramArrayOfShort)
    throws KryoException
  {
    int i = paramArrayOfShort.length << 1;
    writeBytes(paramArrayOfShort, UnsafeUtil.shortArrayBaseOffset, 0L, i);
  }

  public final int writeVarInt(int paramInt, boolean paramBoolean)
    throws KryoException
  {
    if (!paramBoolean)
      paramInt = paramInt << 1 ^ paramInt >> 31;
    int i = paramInt & 0x7F;
    int j = paramInt >>> 7;
    if (j == 0)
    {
      write(i);
      return 1;
    }
    int k = i | 0x80 | (j & 0x7F) << 8;
    int m = j >>> 7;
    if (m == 0)
    {
      writeLittleEndianInt(k);
      this.position = (-2 + this.position);
      return 2;
    }
    int n = k | 0x8000 | (m & 0x7F) << 16;
    int i1 = m >>> 7;
    if (i1 == 0)
    {
      writeLittleEndianInt(n);
      this.position = (-1 + this.position);
      return 3;
    }
    int i2 = n | 0x800000 | (i1 & 0x7F) << 24;
    int i3 = i1 >>> 7;
    if (i3 == 0)
    {
      writeLittleEndianInt(i2);
      this.position = (0 + this.position);
      return 4;
    }
    int i4 = i2 | 0x80000000;
    long l = i4 | (i3 & 0x7F) << 32;
    ((int)(0xFFFFFFFF & i4));
    writeLittleEndianLong(l);
    this.position = (-3 + this.position);
    return 5;
  }

  public final int writeVarLong(long paramLong, boolean paramBoolean)
    throws KryoException
  {
    if (!paramBoolean)
      paramLong = paramLong << 1 ^ paramLong >> 63;
    int i = (int)(0x7F & paramLong);
    long l1 = paramLong >>> 7;
    if (l1 == 0L)
    {
      writeByte(i);
      return 1;
    }
    int j = (int)(i | 0x80 | l1 << 8);
    long l2 = l1 >>> 7;
    if (l2 == 0L)
    {
      writeLittleEndianInt(j);
      this.position = (-2 + this.position);
      return 2;
    }
    int k = (int)(j | 0x8000 | l2 << 16);
    long l3 = l2 >>> 7;
    if (l3 == 0L)
    {
      writeLittleEndianInt(k);
      this.position = (-1 + this.position);
      return 3;
    }
    int m = (int)(k | 0x800000 | l3 << 24);
    long l4 = l3 >>> 7;
    if (l4 == 0L)
    {
      writeLittleEndianInt(m);
      this.position = (0 + this.position);
      return 4;
    }
    int n = m | 0x80000000;
    long l5 = n | l4 << 32;
    long l6 = l4 >>> 7;
    if (l6 == 0L)
    {
      writeLittleEndianLong(l5);
      this.position = (-3 + this.position);
      return 5;
    }
    (l5 | 0x80);
    long l7 = n | l6 << 40;
    long l8 = l6 >>> 7;
    if (l8 == 0L)
    {
      writeLittleEndianLong(l7);
      this.position = (-2 + this.position);
      return 6;
    }
    (l7 | 0x8000);
    long l9 = n | l8 << 48;
    long l10 = l8 >>> 7;
    if (l10 == 0L)
    {
      writeLittleEndianLong(l9);
      this.position = (-1 + this.position);
      return 7;
    }
    (l9 | 0x800000);
    long l11 = n | l10 << 56;
    long l12 = l10 >>> 7;
    if (l12 == 0L)
    {
      writeLittleEndianLong(l11);
      return 8;
    }
    writeLittleEndianLong(0x80000000 | l11);
    write((byte)(int)(l12 >>> 7));
    return 9;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.io.UnsafeOutput
 * JD-Core Version:    0.6.2
 */