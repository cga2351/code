package twitter4j.internal.logging;

final class StdOutLoggerFactory extends LoggerFactory
{
  private static final Logger SINGLETON = new StdOutLogger();

  public Logger getLogger(Class paramClass)
  {
    return SINGLETON;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.logging.StdOutLoggerFactory
 * JD-Core Version:    0.6.2
 */