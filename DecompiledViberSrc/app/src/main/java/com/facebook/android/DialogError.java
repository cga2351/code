package com.facebook.android;

public class DialogError extends Throwable
{
  private static final long serialVersionUID = 1L;
  private int mErrorCode;
  private String mFailingUrl;

  @Deprecated
  public DialogError(String paramString1, int paramInt, String paramString2)
  {
    super(paramString1);
    this.mErrorCode = paramInt;
    this.mFailingUrl = paramString2;
  }

  @Deprecated
  public int getErrorCode()
  {
    return this.mErrorCode;
  }

  @Deprecated
  public String getFailingUrl()
  {
    return this.mFailingUrl;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.android.DialogError
 * JD-Core Version:    0.6.2
 */