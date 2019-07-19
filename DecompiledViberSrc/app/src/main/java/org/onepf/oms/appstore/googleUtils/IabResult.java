package org.onepf.oms.appstore.googleUtils;

public class IabResult
{
  String mMessage;
  int mResponse;

  public IabResult(int paramInt, String paramString)
  {
    this.mResponse = paramInt;
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      this.mMessage = IabHelper.getResponseDesc(paramInt);
      return;
    }
    this.mMessage = (paramString + " (response: " + IabHelper.getResponseDesc(paramInt) + ")");
  }

  public String getMessage()
  {
    return this.mMessage;
  }

  public int getResponse()
  {
    return this.mResponse;
  }

  public boolean isFailure()
  {
    return !isSuccess();
  }

  public boolean isSuccess()
  {
    return this.mResponse == 0;
  }

  public String toString()
  {
    return "IabResult: " + this.mResponse + ", " + getMessage();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.appstore.googleUtils.IabResult
 * JD-Core Version:    0.6.2
 */