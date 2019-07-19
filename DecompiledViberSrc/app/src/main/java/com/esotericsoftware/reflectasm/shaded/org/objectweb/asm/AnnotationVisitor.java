package com.esotericsoftware.reflectasm.shaded.org.objectweb.asm;

public abstract class AnnotationVisitor
{
  protected final int api;
  protected AnnotationVisitor av;

  public AnnotationVisitor(int paramInt)
  {
    this(paramInt, null);
  }

  public AnnotationVisitor(int paramInt, AnnotationVisitor paramAnnotationVisitor)
  {
    this.api = paramInt;
    this.av = paramAnnotationVisitor;
  }

  public void visit(String paramString, Object paramObject)
  {
    if (this.av != null)
      this.av.visit(paramString, paramObject);
  }

  public AnnotationVisitor visitAnnotation(String paramString1, String paramString2)
  {
    if (this.av != null)
      return this.av.visitAnnotation(paramString1, paramString2);
    return null;
  }

  public AnnotationVisitor visitArray(String paramString)
  {
    if (this.av != null)
      return this.av.visitArray(paramString);
    return null;
  }

  public void visitEnd()
  {
    if (this.av != null)
      this.av.visitEnd();
  }

  public void visitEnum(String paramString1, String paramString2, String paramString3)
  {
    if (this.av != null)
      this.av.visitEnum(paramString1, paramString2, paramString3);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.reflectasm.shaded.org.objectweb.asm.AnnotationVisitor
 * JD-Core Version:    0.6.2
 */