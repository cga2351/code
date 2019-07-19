package com.e.a;

import com.e.a.d.c;
import java.io.Serializable;
import java.text.ParseException;

public abstract class e
  implements Serializable
{
  private l a = null;
  private c[] b = null;

  public static c[] a(String paramString)
    throws ParseException
  {
    String str = paramString.trim();
    int i = str.indexOf(".");
    if (i == -1)
      throw new ParseException("Invalid serialized unsecured/JWS/JWE object: Missing part delimiters", 0);
    int j = str.indexOf(".", i + 1);
    if (j == -1)
      throw new ParseException("Invalid serialized unsecured/JWS/JWE object: Missing second delimiter", 0);
    int k = str.indexOf(".", j + 1);
    if (k == -1)
    {
      c[] arrayOfc2 = new c[3];
      arrayOfc2[0] = new c(str.substring(0, i));
      arrayOfc2[1] = new c(str.substring(i + 1, j));
      arrayOfc2[2] = new c(str.substring(j + 1));
      return arrayOfc2;
    }
    int m = str.indexOf(".", k + 1);
    if (m == -1)
      throw new ParseException("Invalid serialized JWE object: Missing fourth delimiter", 0);
    if ((m != -1) && (str.indexOf(".", m + 1) != -1))
      throw new ParseException("Invalid serialized unsecured/JWS/JWE object: Too many part delimiters", 0);
    c[] arrayOfc1 = new c[5];
    arrayOfc1[0] = new c(str.substring(0, i));
    arrayOfc1[1] = new c(str.substring(i + 1, j));
    arrayOfc1[2] = new c(str.substring(j + 1, k));
    arrayOfc1[3] = new c(str.substring(k + 1, m));
    arrayOfc1[4] = new c(str.substring(m + 1));
    return arrayOfc1;
  }

  public l a()
  {
    return this.a;
  }

  protected void a(l paraml)
  {
    this.a = paraml;
  }

  protected void a(c[] paramArrayOfc)
  {
    this.b = paramArrayOfc;
  }

  public String b()
  {
    if (this.b == null)
      return null;
    StringBuilder localStringBuilder = new StringBuilder();
    c[] arrayOfc = this.b;
    int i = arrayOfc.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return localStringBuilder.toString();
      c localc = arrayOfc[j];
      if (localStringBuilder.length() > 0)
        localStringBuilder.append('.');
      if (localc != null)
        localStringBuilder.append(localc.toString());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.a.e
 * JD-Core Version:    0.6.2
 */