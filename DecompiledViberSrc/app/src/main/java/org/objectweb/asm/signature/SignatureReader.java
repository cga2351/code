package org.objectweb.asm.signature;

public class SignatureReader
{
  private final String a;

  public SignatureReader(String paramString)
  {
    this.a = paramString;
  }

  private static int a(String paramString, int paramInt, SignatureVisitor paramSignatureVisitor)
  {
    int i = paramInt + 1;
    char c1 = paramString.charAt(paramInt);
    int k;
    int m;
    int n;
    int i1;
    switch (c1)
    {
    case 'E':
    case 'G':
    case 'H':
    case 'K':
    case 'L':
    case 'M':
    case 'N':
    case 'O':
    case 'P':
    case 'Q':
    case 'R':
    case 'U':
    case 'W':
    case 'X':
    case 'Y':
    default:
      k = 0;
      m = i;
      n = i;
      i1 = 0;
    case 'B':
    case 'C':
    case 'D':
    case 'F':
    case 'I':
    case 'J':
    case 'S':
    case 'V':
    case 'Z':
    case '[':
    case 'T':
    }
    int i2;
    while (true)
    {
      i2 = n + 1;
      int i3 = paramString.charAt(n);
      switch (i3)
      {
      default:
        n = i2;
        continue;
        paramSignatureVisitor.visitBaseType(c1);
        return i;
        return a(paramString, i, paramSignatureVisitor.visitArrayType());
        int j = paramString.indexOf(';', i);
        paramSignatureVisitor.visitTypeVariable(paramString.substring(i, j));
        return j + 1;
      case 46:
      case 59:
        String str2;
        if (k == 0)
        {
          str2 = paramString.substring(m, i2 - 1);
          if (i1 == 0)
            break label288;
          paramSignatureVisitor.visitInnerClassType(str2);
        }
        while (i3 == 59)
        {
          paramSignatureVisitor.visitEnd();
          return i2;
          label288: paramSignatureVisitor.visitClassType(str2);
        }
        i1 = 1;
        m = i2;
        n = i2;
        k = 0;
      case 60:
      }
    }
    String str1 = paramString.substring(m, i2 - 1);
    int i4;
    if (i1 != 0)
    {
      paramSignatureVisitor.visitInnerClassType(str1);
      i4 = i2;
    }
    while (true)
    {
      char c2 = paramString.charAt(i4);
      switch (c2)
      {
      default:
        i4 = a(paramString, i4, paramSignatureVisitor.visitTypeArgument('='));
        continue;
        paramSignatureVisitor.visitClassType(str1);
        break;
      case '>':
        n = i4;
        k = 1;
        break;
      case '*':
        i4++;
        paramSignatureVisitor.visitTypeArgument();
        break;
      case '+':
      case '-':
        i4 = a(paramString, i4 + 1, paramSignatureVisitor.visitTypeArgument(c2));
      }
    }
  }

  public void accept(SignatureVisitor paramSignatureVisitor)
  {
    String str = this.a;
    int i = str.length();
    int j = str.charAt(0);
    int k = 0;
    int i3;
    int i5;
    if (j == 60)
    {
      k = 2;
      int i2 = str.indexOf(':', k);
      paramSignatureVisitor.visitFormalTypeParameter(str.substring(k - 1, i2));
      i3 = i2 + 1;
      int i4 = str.charAt(i3);
      if ((i4 != 76) && (i4 != 91) && (i4 != 84))
        break label258;
      i5 = a(str, i3, paramSignatureVisitor.visitClassBound());
    }
    while (true)
    {
      k = i5 + 1;
      int i6 = str.charAt(i5);
      if (i6 == 58)
      {
        i5 = a(str, k, paramSignatureVisitor.visitInterfaceBound());
      }
      else
      {
        if (i6 != 62)
          break;
        if (str.charAt(k) == '(')
        {
          for (int n = k + 1; str.charAt(n) != ')'; n = a(str, n, paramSignatureVisitor.visitParameterType()));
          for (int i1 = a(str, n + 1, paramSignatureVisitor.visitReturnType()); i1 < i; i1 = a(str, i1 + 1, paramSignatureVisitor.visitExceptionType()));
        }
        for (int m = a(str, k, paramSignatureVisitor.visitSuperclass()); m < i; m = a(str, m, paramSignatureVisitor.visitInterface()));
        return;
        label258: i5 = i3;
      }
    }
  }

  public void acceptType(SignatureVisitor paramSignatureVisitor)
  {
    a(this.a, 0, paramSignatureVisitor);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objectweb.asm.signature.SignatureReader
 * JD-Core Version:    0.6.2
 */