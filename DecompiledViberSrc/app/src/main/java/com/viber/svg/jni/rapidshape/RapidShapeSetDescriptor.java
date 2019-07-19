package com.viber.svg.jni.rapidshape;

public class RapidShapeSetDescriptor
{
  public final int atlasHeight;
  public final int atlasWidth;
  public final byte[] opBuffer;
  public final RapidShapeDescriptor[] shapes;

  public RapidShapeSetDescriptor(int paramInt1, int paramInt2, RapidShapeDescriptor[] paramArrayOfRapidShapeDescriptor, byte[] paramArrayOfByte)
  {
    this.atlasWidth = paramInt1;
    this.atlasHeight = paramInt2;
    this.shapes = paramArrayOfRapidShapeDescriptor;
    this.opBuffer = paramArrayOfByte;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.rapidshape.RapidShapeSetDescriptor
 * JD-Core Version:    0.6.2
 */