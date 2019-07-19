package com.viber.libnativehttp;

public class DefaultHttpDelegateFactory
  implements Http.DelegateFactory
{
  public Http.Delegate createDelegate()
  {
    return new OkHttp3HttpDelegate();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.libnativehttp.DefaultHttpDelegateFactory
 * JD-Core Version:    0.6.2
 */