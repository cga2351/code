package com.viber.svg.jni.rapidshape;

class RapidShapeOpsBuilder
{
  private int blockCount = 0;
  private int curBlockBits = 0;
  private int curBlockOpCount = 0;
  private byte[] opBuffer;
  private byte[] pixels;
  private int pixelsDimension;

  public RapidShapeOpsBuilder(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    this.pixelsDimension = paramInt;
    this.pixels = paramArrayOfByte1;
    this.opBuffer = paramArrayOfByte2;
  }

  private void buildInternal(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = calculateOp(paramInt1, paramInt2, paramInt3);
    writeOp(i);
    if (i == 3)
    {
      int j = paramInt3 >> 1;
      buildInternal(paramInt1, paramInt2, j);
      buildInternal(paramInt1 + j, paramInt2, j);
      buildInternal(paramInt1, paramInt2 + j, j);
      buildInternal(paramInt1 + j, paramInt2 + j, j);
    }
  }

  private int calculateAtomOp(int paramInt1, int paramInt2)
  {
    int i = 1;
    int j = paramInt1 + 8;
    int k = paramInt2 + 8;
    int m = 0;
    int n = 0;
    if (paramInt2 < k)
    {
      i1 = paramInt1;
      if (i1 < j)
      {
        i2 = getPixel(i1, paramInt2);
        if (i2 == 0)
          if (n != 0)
            i = 2;
      }
    }
    label87: 
    while (m == 0)
    {
      int i1;
      int i2;
      return i;
      m = i;
      while (true)
      {
        i1++;
        break;
        if (i2 != -1)
          break label87;
        if (m != 0)
          return 2;
        n = i;
      }
      return 2;
      paramInt2++;
      break;
    }
    return 0;
  }

  private int calculateOp(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 < 8)
      throw new IllegalArgumentException("dimension is below atom dimension: " + paramInt3);
    if (paramInt3 == 8)
      return calculateAtomOp(paramInt1, paramInt2);
    int i = paramInt3 >> 1;
    return calculateQuadOp(calculateOp(paramInt1, paramInt2, i), calculateOp(paramInt1 + i, paramInt2, i), calculateOp(paramInt1, paramInt2 + i, i), calculateOp(paramInt1 + i, paramInt2 + i, i));
  }

  private int calculateQuadOp(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 == 3)
      paramInt1 = 3;
    do
    {
      return paramInt1;
      if (paramInt2 != paramInt1)
        return 3;
      if (paramInt3 != paramInt1)
        return 3;
    }
    while (paramInt4 == paramInt1);
    return 3;
  }

  private byte getPixel(int paramInt1, int paramInt2)
  {
    return this.pixels[(paramInt1 + paramInt2 * this.pixelsDimension)];
  }

  private void writeOp(int paramInt)
  {
    this.curBlockBits |= paramInt << 2 * this.curBlockOpCount;
    this.curBlockOpCount = (1 + this.curBlockOpCount);
    if (this.curBlockOpCount == 4)
    {
      byte[] arrayOfByte = this.opBuffer;
      int i = this.blockCount;
      this.blockCount = (i + 1);
      arrayOfByte[i] = ((byte)this.curBlockBits);
      this.curBlockBits = 0;
      this.curBlockOpCount = 0;
    }
  }

  public int build(int paramInt1, int paramInt2, int paramInt3)
  {
    this.blockCount = 0;
    this.curBlockOpCount = 0;
    buildInternal(paramInt1, paramInt2, paramInt3);
    if (this.curBlockOpCount > 0)
    {
      byte[] arrayOfByte = this.opBuffer;
      int i = this.blockCount;
      this.blockCount = (i + 1);
      arrayOfByte[i] = ((byte)this.curBlockBits);
    }
    return this.blockCount;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.rapidshape.RapidShapeOpsBuilder
 * JD-Core Version:    0.6.2
 */