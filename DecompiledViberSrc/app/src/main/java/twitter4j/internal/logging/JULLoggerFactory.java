package twitter4j.internal.logging;

final class JULLoggerFactory extends LoggerFactory
{
  public Logger getLogger(Class paramClass)
  {
    return new JULLogger(java.util.logging.Logger.getLogger(paramClass.getName()));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.logging.JULLoggerFactory
 * JD-Core Version:    0.6.2
 */