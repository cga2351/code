package com.esotericsoftware.reflectasm.shaded.org.objectweb.asm;

public abstract class FieldVisitor
{
  protected final int api;
  protected FieldVisitor fv;

  public FieldVisitor(int paramInt)
  {
    this(paramInt, null);
  }

  public FieldVisitor(int paramInt, FieldVisitor paramFieldVisitor)
  {
    this.api = paramInt;
    this.fv = paramFieldVisitor;
  }

  public AnnotationVisitor visitAnnotation(String paramString, boolean paramBoolean)
  {
    if (this.fv != null)
      return this.fv.visitAnnotation(paramString, paramBoolean);
    return null;
  }

  public void visitAttribute(Attribute paramAttribute)
  {
    if (this.fv != null)
      this.fv.visitAttribute(paramAttribute);
  }

  public void visitEnd()
  {
    if (this.fv != null)
      this.fv.visitEnd();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.reflectasm.shaded.org.objectweb.asm.FieldVisitor
 * JD-Core Version:    0.6.2
 */