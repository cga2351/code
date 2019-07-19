package com.viber.svg.jni.rapidshape;

class RapidShape extends RapidShapeTraverser
{
  private RapidShapeDescriptor descriptor;

  public RapidShape(RapidShapeDescriptor paramRapidShapeDescriptor, byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte, paramRapidShapeDescriptor.opBufferStartIndex);
    this.descriptor = paramRapidShapeDescriptor;
  }

  public RapidShapeDescriptor getDescriptor()
  {
    return this.descriptor;
  }

  public void traverse(RapidShapeTraverser.Visitor paramVisitor, int paramInt1, int paramInt2)
  {
    traverse(paramVisitor, this.descriptor.dimension, paramInt1, paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.rapidshape.RapidShape
 * JD-Core Version:    0.6.2
 */