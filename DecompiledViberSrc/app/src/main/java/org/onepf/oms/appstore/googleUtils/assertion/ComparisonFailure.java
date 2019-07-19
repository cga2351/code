package org.onepf.oms.appstore.googleUtils.assertion;

public class ComparisonFailure extends AssertionFailedError
{
  private static final int MAX_CONTEXT_LENGTH = 20;
  private static final long serialVersionUID = 1L;
  private String fActual;
  private String fExpected;

  public ComparisonFailure(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1);
    this.fExpected = paramString2;
    this.fActual = paramString3;
  }

  public String getActual()
  {
    return this.fActual;
  }

  public String getExpected()
  {
    return this.fExpected;
  }

  public String getMessage()
  {
    return new ComparisonCompactor(20, this.fExpected, this.fActual).compact(super.getMessage());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.appstore.googleUtils.assertion.ComparisonFailure
 * JD-Core Version:    0.6.2
 */