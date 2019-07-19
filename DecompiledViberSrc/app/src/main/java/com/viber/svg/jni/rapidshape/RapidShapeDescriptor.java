package com.viber.svg.jni.rapidshape;

public class RapidShapeDescriptor
{
  public final int atlasStartIndex;
  public final int dimension;
  public final int opBufferStartIndex;
  public final int stagingOffsetX;
  public final int stagingOffsetY;

  public RapidShapeDescriptor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.dimension = paramInt1;
    this.opBufferStartIndex = paramInt2;
    this.atlasStartIndex = paramInt3;
    this.stagingOffsetX = paramInt4;
    this.stagingOffsetY = paramInt5;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.rapidshape.RapidShapeDescriptor
 * JD-Core Version:    0.6.2
 */