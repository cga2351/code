package twitter4j.internal.logging;

import org.apache.commons.logging.LogFactory;

final class CommonsLoggingLoggerFactory extends LoggerFactory
{
  public Logger getLogger(Class paramClass)
  {
    return new CommonsLoggingLogger(LogFactory.getLog(paramClass));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.logging.CommonsLoggingLoggerFactory
 * JD-Core Version:    0.6.2
 */