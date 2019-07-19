package org.objectweb.asm.signature;

public class SignatureWriter extends SignatureVisitor
{
  private final StringBuffer a = new StringBuffer();
  private boolean b;
  private boolean c;
  private int d;

  public SignatureWriter()
  {
    super(327680);
  }

  private void a()
  {
    if (this.b)
    {
      this.b = false;
      this.a.append('>');
    }
  }

  private void b()
  {
    if (this.d % 2 != 0)
      this.a.append('>');
    this.d /= 2;
  }

  public String toString()
  {
    return this.a.toString();
  }

  public SignatureVisitor visitArrayType()
  {
    this.a.append('[');
    return this;
  }

  public void visitBaseType(char paramChar)
  {
    this.a.append(paramChar);
  }

  public SignatureVisitor visitClassBound()
  {
    return this;
  }

  public void visitClassType(String paramString)
  {
    this.a.append('L');
    this.a.append(paramString);
    this.d = (2 * this.d);
  }

  public void visitEnd()
  {
    b();
    this.a.append(';');
  }

  public SignatureVisitor visitExceptionType()
  {
    this.a.append('^');
    return this;
  }

  public void visitFormalTypeParameter(String paramString)
  {
    if (!this.b)
    {
      this.b = true;
      this.a.append('<');
    }
    this.a.append(paramString);
    this.a.append(':');
  }

  public void visitInnerClassType(String paramString)
  {
    b();
    this.a.append('.');
    this.a.append(paramString);
    this.d = (2 * this.d);
  }

  public SignatureVisitor visitInterface()
  {
    return this;
  }

  public SignatureVisitor visitInterfaceBound()
  {
    this.a.append(':');
    return this;
  }

  public SignatureVisitor visitParameterType()
  {
    a();
    if (!this.c)
    {
      this.c = true;
      this.a.append('(');
    }
    return this;
  }

  public SignatureVisitor visitReturnType()
  {
    a();
    if (!this.c)
      this.a.append('(');
    this.a.append(')');
    return this;
  }

  public SignatureVisitor visitSuperclass()
  {
    a();
    return this;
  }

  public SignatureVisitor visitTypeArgument(char paramChar)
  {
    if (this.d % 2 == 0)
    {
      this.d = (1 + this.d);
      this.a.append('<');
    }
    if (paramChar != '=')
      this.a.append(paramChar);
    return this;
  }

  public void visitTypeArgument()
  {
    if (this.d % 2 == 0)
    {
      this.d = (1 + this.d);
      this.a.append('<');
    }
    this.a.append('*');
  }

  public void visitTypeVariable(String paramString)
  {
    this.a.append('T');
    this.a.append(paramString);
    this.a.append(';');
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objectweb.asm.signature.SignatureWriter
 * JD-Core Version:    0.6.2
 */