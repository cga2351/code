package org.onepf.oms.appstore.googleUtils.assertion;

public class ComparisonCompactor
{
  private static final String DELTA_END = "]";
  private static final String DELTA_START = "[";
  private static final String ELLIPSIS = "...";
  private String fActual;
  private int fContextLength;
  private String fExpected;
  private int fPrefix;
  private int fSuffix;

  public ComparisonCompactor(int paramInt, String paramString1, String paramString2)
  {
    this.fContextLength = paramInt;
    this.fExpected = paramString1;
    this.fActual = paramString2;
  }

  private boolean areStringsEqual()
  {
    return this.fExpected.equals(this.fActual);
  }

  private String compactString(String paramString)
  {
    String str = "[" + paramString.substring(this.fPrefix, 1 + (paramString.length() - this.fSuffix)) + "]";
    if (this.fPrefix > 0)
      str = computeCommonPrefix() + str;
    if (this.fSuffix > 0)
      str = str + computeCommonSuffix();
    return str;
  }

  private String computeCommonPrefix()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.fPrefix > this.fContextLength);
    for (String str = "..."; ; str = "")
      return str + this.fExpected.substring(Math.max(0, this.fPrefix - this.fContextLength), this.fPrefix);
  }

  private String computeCommonSuffix()
  {
    int i = Math.min(1 + (this.fExpected.length() - this.fSuffix) + this.fContextLength, this.fExpected.length());
    StringBuilder localStringBuilder = new StringBuilder().append(this.fExpected.substring(1 + (this.fExpected.length() - this.fSuffix), i));
    if (1 + (this.fExpected.length() - this.fSuffix) < this.fExpected.length() - this.fContextLength);
    for (String str = "..."; ; str = "")
      return str;
  }

  private void findCommonPrefix()
  {
    this.fPrefix = 0;
    int i = Math.min(this.fExpected.length(), this.fActual.length());
    while (true)
    {
      if ((this.fPrefix >= i) || (this.fExpected.charAt(this.fPrefix) != this.fActual.charAt(this.fPrefix)))
        return;
      this.fPrefix = (1 + this.fPrefix);
    }
  }

  private void findCommonSuffix()
  {
    int i = -1 + this.fExpected.length();
    int j = -1 + this.fActual.length();
    while (true)
    {
      if ((j < this.fPrefix) || (i < this.fPrefix) || (this.fExpected.charAt(i) != this.fActual.charAt(j)))
      {
        this.fSuffix = (this.fExpected.length() - i);
        return;
      }
      j--;
      i--;
    }
  }

  private static String format(String paramString, Object paramObject1, Object paramObject2)
  {
    String str = "";
    if ((paramString != null) && (paramString.length() > 0))
      str = paramString + " ";
    return str + "expected:<" + paramObject1 + "> but was:<" + paramObject2 + ">";
  }

  public String compact(String paramString)
  {
    if ((this.fExpected == null) || (this.fActual == null) || (areStringsEqual()))
      return format(paramString, this.fExpected, this.fActual);
    findCommonPrefix();
    findCommonSuffix();
    return format(paramString, compactString(this.fExpected), compactString(this.fActual));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.appstore.googleUtils.assertion.ComparisonCompactor
 * JD-Core Version:    0.6.2
 */