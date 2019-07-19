package com.viber.svg.jni.rapidshape;

class RapidShapeTraverser
{
  static final int ATOM_DIMENSION = 8;
  static final int OP_BITMAP = 2;
  static final int OP_OPAQUE = 1;
  static final int OP_RECURSE = 3;
  static final int OP_TRANSPARENT;
  protected int curBlockBits;
  protected int curBlockIndex;
  protected int curBlockOpCount;
  protected byte[] opBuffer;
  protected int opBufferStartIndex;

  public RapidShapeTraverser(byte[] paramArrayOfByte, int paramInt)
  {
    this.opBuffer = paramArrayOfByte;
    this.opBufferStartIndex = paramInt;
  }

  private void doTraverse(Visitor paramVisitor, int paramInt1, int paramInt2, int paramInt3)
  {
    switch (readOp())
    {
    default:
      int i = paramInt1 >> 1;
      doTraverse(paramVisitor, i, paramInt2, paramInt3);
      doTraverse(paramVisitor, i, paramInt2 + i, paramInt3);
      doTraverse(paramVisitor, i, paramInt2, paramInt3 + i);
      doTraverse(paramVisitor, i, paramInt2 + i, paramInt3 + i);
      return;
    case 0:
      paramVisitor.visitTransparent(paramInt1, paramInt2, paramInt3);
      return;
    case 1:
      paramVisitor.visitOpaque(paramInt1, paramInt2, paramInt3);
      return;
    case 2:
    }
    paramVisitor.visitBitmap(paramInt1, paramInt2, paramInt3);
  }

  private int readOp()
  {
    if (this.curBlockOpCount == 0)
    {
      this.curBlockOpCount = 4;
      byte[] arrayOfByte = this.opBuffer;
      int j = this.curBlockIndex;
      this.curBlockIndex = (j + 1);
      this.curBlockBits = (0xFF & arrayOfByte[j]);
    }
    int i = 0x3 & this.curBlockBits;
    this.curBlockBits >>= 2;
    this.curBlockOpCount = (-1 + this.curBlockOpCount);
    return i;
  }

  public int traverse(Visitor paramVisitor, int paramInt1, int paramInt2, int paramInt3)
  {
    this.curBlockIndex = this.opBufferStartIndex;
    this.curBlockOpCount = 0;
    doTraverse(paramVisitor, paramInt1, paramInt2, paramInt3);
    return this.curBlockIndex - this.opBufferStartIndex;
  }

  public static abstract interface Visitor
  {
    public abstract void visitBitmap(int paramInt1, int paramInt2, int paramInt3);

    public abstract void visitOpaque(int paramInt1, int paramInt2, int paramInt3);

    public abstract void visitTransparent(int paramInt1, int paramInt2, int paramInt3);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.rapidshape.RapidShapeTraverser
 * JD-Core Version:    0.6.2
 */