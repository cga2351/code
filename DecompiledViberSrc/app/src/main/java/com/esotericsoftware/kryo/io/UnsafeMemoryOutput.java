package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.util.UnsafeUtil;
import com.esotericsoftware.kryo.util.Util;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import sun.misc.Unsafe;
import sun.nio.ch.DirectBuffer;

public final class UnsafeMemoryOutput extends ByteBufferOutput
{
  private static final boolean isLittleEndian = ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN);
  private long bufaddress;

  public UnsafeMemoryOutput()
  {
    this.varIntsEnabled = false;
  }

  public UnsafeMemoryOutput(int paramInt)
  {
    this(paramInt, paramInt);
  }

  public UnsafeMemoryOutput(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    this.varIntsEnabled = false;
    updateBufferAddress();
  }

  public UnsafeMemoryOutput(long paramLong, int paramInt)
  {
    super(paramLong, paramInt);
    this.varIntsEnabled = false;
    updateBufferAddress();
  }

  public UnsafeMemoryOutput(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
    this.varIntsEnabled = false;
    updateBufferAddress();
  }

  public UnsafeMemoryOutput(OutputStream paramOutputStream, int paramInt)
  {
    super(paramOutputStream, paramInt);
    this.varIntsEnabled = false;
    updateBufferAddress();
  }

  private void updateBufferAddress()
  {
    this.bufaddress = ((DirectBuffer)this.niobuffer).address();
  }

  private final void writeBytes(Object paramObject, long paramLong1, long paramLong2, long paramLong3)
    throws KryoException
  {
    int i = Math.min(this.capacity - this.position, (int)paramLong3);
    while (true)
    {
      UnsafeUtil.unsafe().copyMemory(paramObject, paramLong1 + paramLong2, null, this.bufaddress + this.position, i);
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

  public void setBuffer(ByteBuffer paramByteBuffer, int paramInt)
  {
    super.setBuffer(paramByteBuffer, paramInt);
    updateBufferAddress();
  }

  public final void writeBoolean(boolean paramBoolean)
    throws KryoException
  {
    this.niobuffer.position(this.position);
    super.writeBoolean(paramBoolean);
  }

  public void writeByte(byte paramByte)
    throws KryoException
  {
    this.niobuffer.position(this.position);
    super.writeByte(paramByte);
  }

  public final void writeByte(int paramInt)
    throws KryoException
  {
    this.niobuffer.position(this.position);
    super.writeByte(paramInt);
  }

  public final void writeBytes(Object paramObject, long paramLong1, long paramLong2)
    throws KryoException
  {
    writeBytes(paramObject, 0L, paramLong1, paramLong2);
  }

  public final void writeChar(char paramChar)
    throws KryoException
  {
    this.niobuffer.position(this.position);
    super.writeChar(paramChar);
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
    UnsafeUtil.unsafe().putDouble(this.bufaddress + this.position, paramDouble);
    UnsafeUtil.unsafe().getDouble(this.bufaddress + this.position);
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
    UnsafeUtil.unsafe().putFloat(this.bufaddress + this.position, paramFloat);
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
    if (!this.varIntsEnabled)
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
    UnsafeUtil.unsafe().putInt(this.bufaddress + this.position, paramInt);
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
    if (!this.varIntsEnabled)
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
    if (!this.varIntsEnabled)
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
    UnsafeUtil.unsafe().putLong(this.bufaddress + this.position, paramLong);
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
    if (!this.varIntsEnabled)
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
    UnsafeUtil.unsafe().putShort(this.bufaddress + this.position, (short)paramInt);
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
    long l1 = paramInt;
    if (!paramBoolean)
      l1 = l1 << 1 ^ l1 >> 31;
    long l2 = l1 & 0x7F;
    long l3 = l1 >>> 7;
    if (l3 == 0L)
    {
      writeByte((byte)(int)l2);
      return 1;
    }
    long l4 = 0x80 | l2 | (l3 & 0x7F) << 8;
    long l5 = l3 >>> 7;
    if (l5 == 0L)
    {
      writeLittleEndianInt((int)l4);
      this.position = (-2 + this.position);
      return 2;
    }
    long l6 = l4 | 0x8000 | (l5 & 0x7F) << 16;
    long l7 = l5 >>> 7;
    if (l7 == 0L)
    {
      writeLittleEndianInt((int)l6);
      this.position = (-1 + this.position);
      return 3;
    }
    long l8 = l6 | 0x800000 | (l7 & 0x7F) << 24;
    long l9 = l7 >>> 7;
    if (l9 == 0L)
    {
      writeLittleEndianInt((int)l8);
      this.position = (0 + this.position);
      return 4;
    }
    writeLittleEndianLong(0xFFFFFFFF & (l8 | 0x80000000 | (l9 & 0x7F) << 32));
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
      write(i);
      return 1;
    }
    int j = (int)(i | 0x80 | (0x7F & l1) << 8);
    long l2 = l1 >>> 7;
    if (l2 == 0L)
    {
      writeLittleEndianInt(j);
      this.position = (-2 + this.position);
      return 2;
    }
    int k = (int)(j | 0x8000 | (0x7F & l2) << 16);
    long l3 = l2 >>> 7;
    if (l3 == 0L)
    {
      writeLittleEndianInt(k);
      this.position = (-1 + this.position);
      return 3;
    }
    int m = (int)(k | 0x800000 | (0x7F & l3) << 24);
    long l4 = l3 >>> 7;
    if (l4 == 0L)
    {
      writeLittleEndianInt(m);
      this.position = (0 + this.position);
      return 4;
    }
    long l5 = 0xFFFFFFFF & (m | 0x80000000) | (0x7F & l4) << 32;
    long l6 = l4 >>> 7;
    if (l6 == 0L)
    {
      writeLittleEndianLong(l5);
      this.position = (-3 + this.position);
      return 5;
    }
    long l7 = l5 | 0x0 | (0x7F & l6) << 40;
    long l8 = l6 >>> 7;
    if (l8 == 0L)
    {
      writeLittleEndianLong(l7);
      this.position = (-2 + this.position);
      return 6;
    }
    long l9 = l7 | 0x0 | (0x7F & l8) << 48;
    long l10 = l8 >>> 7;
    if (l10 == 0L)
    {
      writeLittleEndianLong(l9);
      this.position = (-1 + this.position);
      return 7;
    }
    long l11 = l9 | 0x0 | (0x7F & l10) << 56;
    long l12 = l10 >>> 7;
    if (l12 == 0L)
    {
      writeLittleEndianLong(l11);
      return 8;
    }
    writeLittleEndianLong(l11 | 0x0);
    write((byte)(int)(0x7F & l12));
    return 9;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.io.UnsafeMemoryOutput
 * JD-Core Version:    0.6.2
 */