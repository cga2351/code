package org.webrtc;

class JNILogging
{
  private final Loggable loggable;

  public JNILogging(Loggable paramLoggable)
  {
    this.loggable = paramLoggable;
  }

  @CalledByNative
  public void logToInjectable(String paramString1, Integer paramInteger, String paramString2)
  {
    this.loggable.onLogMessage(paramString1, Logging.Severity.values()[paramInteger.intValue()], paramString2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.JNILogging
 * JD-Core Version:    0.6.2
 */