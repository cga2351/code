package org.simpleframework.xml.stream;

final class ProviderFactory
{
  public static Provider getInstance()
  {
    try
    {
      StreamProvider localStreamProvider = new StreamProvider();
      return localStreamProvider;
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        PullProvider localPullProvider = new PullProvider();
        return localPullProvider;
      }
      catch (Throwable localThrowable2)
      {
      }
    }
    return new DocumentProvider();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.ProviderFactory
 * JD-Core Version:    0.6.2
 */