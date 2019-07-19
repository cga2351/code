package org.objectweb.asm;

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
    if ((paramInt != 262144) && (paramInt != 327680))
      throw new IllegalArgumentException();
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

  public AnnotationVisitor visitTypeAnnotation(int paramInt, TypePath paramTypePath, String paramString, boolean paramBoolean)
  {
    if (this.api < 327680)
      throw new RuntimeException();
    if (this.fv != null)
      return this.fv.visitTypeAnnotation(paramInt, paramTypePath, paramString, paramBoolean);
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objectweb.asm.FieldVisitor
 * JD-Core Version:    0.6.2
 */