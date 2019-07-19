package com.viber.liblinkparser;

public class DefaultHttpDelegateFactory
  implements Http.DelegateFactory
{
  public Http.Delegate createDelegate()
  {
    return new DefaultHttpDelegate();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.liblinkparser.DefaultHttpDelegateFactory
 * JD-Core Version:    0.6.2
 */