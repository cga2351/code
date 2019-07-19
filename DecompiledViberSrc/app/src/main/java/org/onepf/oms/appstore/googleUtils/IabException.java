package org.onepf.oms.appstore.googleUtils;

public class IabException extends Exception
{
  IabResult mResult;

  public IabException(int paramInt, String paramString)
  {
    this(new IabResult(paramInt, paramString));
  }

  public IabException(int paramInt, String paramString, Exception paramException)
  {
    this(new IabResult(paramInt, paramString), paramException);
  }

  public IabException(IabResult paramIabResult)
  {
    this(paramIabResult, null);
  }

  public IabException(IabResult paramIabResult, Exception paramException)
  {
    super(paramIabResult.getMessage(), paramException);
    this.mResult = paramIabResult;
  }

  public IabResult getResult()
  {
    return this.mResult;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.appstore.googleUtils.IabException
 * JD-Core Version:    0.6.2
 */