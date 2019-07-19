package com.google.android.gms.common.api;

public class Response<T extends Result>
{
  private T zzao;

  public Response()
  {
  }

  protected Response(T paramT)
  {
    this.zzao = paramT;
  }

  protected T getResult()
  {
    return this.zzao;
  }

  public void setResult(T paramT)
  {
    this.zzao = paramT;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.Response
 * JD-Core Version:    0.6.2
 */