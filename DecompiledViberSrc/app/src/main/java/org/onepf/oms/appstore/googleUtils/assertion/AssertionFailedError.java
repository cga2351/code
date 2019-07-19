package org.onepf.oms.appstore.googleUtils.assertion;

class AssertionFailedError extends AssertionError
{
  private static final long serialVersionUID = 1L;

  AssertionFailedError()
  {
  }

  AssertionFailedError(String paramString)
  {
    super(defaultString(paramString));
  }

  private static String defaultString(String paramString)
  {
    if (paramString == null)
      paramString = "";
    return paramString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.appstore.googleUtils.assertion.AssertionFailedError
 * JD-Core Version:    0.6.2
 */