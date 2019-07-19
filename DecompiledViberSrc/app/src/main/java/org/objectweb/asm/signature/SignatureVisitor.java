package org.objectweb.asm.signature;

public abstract class SignatureVisitor
{
  public static final char EXTENDS = '+';
  public static final char INSTANCEOF = '=';
  public static final char SUPER = '-';
  protected final int api;

  public SignatureVisitor(int paramInt)
  {
    if ((paramInt != 262144) && (paramInt != 327680))
      throw new IllegalArgumentException();
    this.api = paramInt;
  }

  public SignatureVisitor visitArrayType()
  {
    return this;
  }

  public void visitBaseType(char paramChar)
  {
  }

  public SignatureVisitor visitClassBound()
  {
    return this;
  }

  public void visitClassType(String paramString)
  {
  }

  public void visitEnd()
  {
  }

  public SignatureVisitor visitExceptionType()
  {
    return this;
  }

  public void visitFormalTypeParameter(String paramString)
  {
  }

  public void visitInnerClassType(String paramString)
  {
  }

  public SignatureVisitor visitInterface()
  {
    return this;
  }

  public SignatureVisitor visitInterfaceBound()
  {
    return this;
  }

  public SignatureVisitor visitParameterType()
  {
    return this;
  }

  public SignatureVisitor visitReturnType()
  {
    return this;
  }

  public SignatureVisitor visitSuperclass()
  {
    return this;
  }

  public SignatureVisitor visitTypeArgument(char paramChar)
  {
    return this;
  }

  public void visitTypeArgument()
  {
  }

  public void visitTypeVariable(String paramString)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objectweb.asm.signature.SignatureVisitor
 * JD-Core Version:    0.6.2
 */