package twitter4j.internal.logging;

final class SLF4JLoggerFactory extends LoggerFactory
{
  public Logger getLogger(Class paramClass)
  {
    return new SLF4JLogger(org.slf4j.LoggerFactory.getLogger(paramClass));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.logging.SLF4JLoggerFactory
 * JD-Core Version:    0.6.2
 */