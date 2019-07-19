package com.mopub.common.logging;

import android.support.v4.util.Pair;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.common.util.Strings;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MoPubLog
{
  public static final String LOGTAG = "MoPub";
  private static final MoPubLog a = new MoPubLog();
  private LogLevel b = LogLevel.INFO;
  private Map<MoPubLogger, LogLevel> c = new HashMap();
  private MoPubLogger d = new MoPubDefaultLogger();

  private static Pair<String, String> a()
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    return new Pair(arrayOfStackTraceElement[4].getClassName(), arrayOfStackTraceElement[4].getMethodName());
  }

  private static void a(Pair<String, String> paramPair, String paramString, a parama, Object[] paramArrayOfObject)
  {
    Preconditions.checkNotNull(paramPair);
    if (parama == null);
    while (true)
    {
      return;
      Iterator localIterator = a.c.keySet().iterator();
      while (localIterator.hasNext())
      {
        MoPubLogger localMoPubLogger = (MoPubLogger)localIterator.next();
        if ((a.c.get(localMoPubLogger) != null) && (((LogLevel)a.c.get(localMoPubLogger)).intValue() <= parama.getLogLevel().intValue()))
          localMoPubLogger.log((String)paramPair.first, (String)paramPair.second, paramString, parama.getMessage(paramArrayOfObject));
      }
    }
  }

  private static void a(String paramString, Throwable paramThrowable)
  {
    SdkLogEvent localSdkLogEvent = SdkLogEvent.CUSTOM_WITH_THROWABLE;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramString;
    if (paramThrowable != null);
    for (String str = paramThrowable.getMessage(); ; str = "")
    {
      arrayOfObject[1] = str;
      log(localSdkLogEvent, arrayOfObject);
      return;
    }
  }

  public static void addLogger(MoPubLogger paramMoPubLogger)
  {
    addLogger(paramMoPubLogger, a.b);
  }

  public static void addLogger(MoPubLogger paramMoPubLogger, LogLevel paramLogLevel)
  {
    a.c.put(paramMoPubLogger, paramLogLevel);
  }

  @Deprecated
  public static void c(String paramString)
  {
    c(paramString, null);
  }

  @Deprecated
  public static void c(String paramString, Throwable paramThrowable)
  {
    a(paramString, paramThrowable);
  }

  @Deprecated
  public static void d(String paramString)
  {
    d(paramString, null);
  }

  @Deprecated
  public static void d(String paramString, Throwable paramThrowable)
  {
    a(paramString, paramThrowable);
  }

  @Deprecated
  public static void e(String paramString)
  {
    e(paramString, null);
  }

  @Deprecated
  public static void e(String paramString, Throwable paramThrowable)
  {
    a(paramString, paramThrowable);
  }

  public static LogLevel getLogLevel()
  {
    return a.b;
  }

  @Deprecated
  public static void i(String paramString)
  {
    i(paramString, null);
  }

  @Deprecated
  public static void i(String paramString, Throwable paramThrowable)
  {
    a(paramString, paramThrowable);
  }

  public static void log(a parama, Object[] paramArrayOfObject)
  {
    a(a(), null, parama, paramArrayOfObject);
  }

  public static void log(String paramString, a parama, Object[] paramArrayOfObject)
  {
    a(a(), paramString, parama, paramArrayOfObject);
  }

  public static void setLogLevel(LogLevel paramLogLevel)
  {
    Preconditions.checkNotNull(paramLogLevel);
    a.b = paramLogLevel;
    addLogger(a.d, a.b);
  }

  @Deprecated
  public static void v(String paramString)
  {
    v(paramString, null);
  }

  @Deprecated
  public static void v(String paramString, Throwable paramThrowable)
  {
    a(paramString, paramThrowable);
  }

  @Deprecated
  public static void w(String paramString)
  {
    w(paramString, null);
  }

  @Deprecated
  public static void w(String paramString, Throwable paramThrowable)
  {
    a(paramString, paramThrowable);
  }

  public static enum AdLogEvent
    implements MoPubLog.a
  {
    private MoPubLog.LogLevel a;
    private String b;

    static
    {
      LOAD_ATTEMPTED = new AdLogEvent("LOAD_ATTEMPTED", 2, MoPubLog.LogLevel.INFO, "Ad attempting to load");
      LOAD_SUCCESS = new AdLogEvent("LOAD_SUCCESS", 3, MoPubLog.LogLevel.INFO, "Ad loaded");
      LOAD_FAILED = new AdLogEvent("LOAD_FAILED", 4, MoPubLog.LogLevel.INFO, "Ad failed to load: ({0}) {1}");
      SHOW_ATTEMPTED = new AdLogEvent("SHOW_ATTEMPTED", 5, MoPubLog.LogLevel.INFO, "Attempting to show ad");
      SHOW_SUCCESS = new AdLogEvent("SHOW_SUCCESS", 6, MoPubLog.LogLevel.INFO, "Ad shown");
      SHOW_FAILED = new AdLogEvent("SHOW_FAILED", 7, MoPubLog.LogLevel.INFO, "Ad failed to show: ({0}) {1}");
      EXPIRED = new AdLogEvent("EXPIRED", 8, MoPubLog.LogLevel.DEBUG, "Ad expired since it was not shown within {0} seconds of it being loaded");
      CLICKED = new AdLogEvent("CLICKED", 9, MoPubLog.LogLevel.DEBUG, "Ad clicked");
      WILL_APPEAR = new AdLogEvent("WILL_APPEAR", 10, MoPubLog.LogLevel.DEBUG, "Ad will appear");
      DID_APPEAR = new AdLogEvent("DID_APPEAR", 11, MoPubLog.LogLevel.DEBUG, "Ad did appear");
      WILL_DISAPPEAR = new AdLogEvent("WILL_DISAPPEAR", 12, MoPubLog.LogLevel.DEBUG, "Ad will disappear");
      DID_DISAPPEAR = new AdLogEvent("DID_DISAPPEAR", 13, MoPubLog.LogLevel.DEBUG, "Ad did disappear");
      SHOULD_REWARD = new AdLogEvent("SHOULD_REWARD", 14, MoPubLog.LogLevel.DEBUG, "Ad should reward user with {0} {1}");
      WILL_LEAVE_APPLICATION = new AdLogEvent("WILL_LEAVE_APPLICATION", 15, MoPubLog.LogLevel.DEBUG, "Ad will leave application");
      CUSTOM = new AdLogEvent("CUSTOM", 16, MoPubLog.LogLevel.DEBUG, "Ad Log - {0}");
      CUSTOM_WITH_THROWABLE = new AdLogEvent("CUSTOM_WITH_THROWABLE", 17, MoPubLog.LogLevel.DEBUG, "Ad Log With Throwable - {0}, {1}");
      AdLogEvent[] arrayOfAdLogEvent = new AdLogEvent[18];
      arrayOfAdLogEvent[0] = REQUESTED;
      arrayOfAdLogEvent[1] = RESPONSE_RECEIVED;
      arrayOfAdLogEvent[2] = LOAD_ATTEMPTED;
      arrayOfAdLogEvent[3] = LOAD_SUCCESS;
      arrayOfAdLogEvent[4] = LOAD_FAILED;
      arrayOfAdLogEvent[5] = SHOW_ATTEMPTED;
      arrayOfAdLogEvent[6] = SHOW_SUCCESS;
      arrayOfAdLogEvent[7] = SHOW_FAILED;
      arrayOfAdLogEvent[8] = EXPIRED;
      arrayOfAdLogEvent[9] = CLICKED;
      arrayOfAdLogEvent[10] = WILL_APPEAR;
      arrayOfAdLogEvent[11] = DID_APPEAR;
      arrayOfAdLogEvent[12] = WILL_DISAPPEAR;
      arrayOfAdLogEvent[13] = DID_DISAPPEAR;
      arrayOfAdLogEvent[14] = SHOULD_REWARD;
      arrayOfAdLogEvent[15] = WILL_LEAVE_APPLICATION;
      arrayOfAdLogEvent[16] = CUSTOM;
      arrayOfAdLogEvent[17] = CUSTOM_WITH_THROWABLE;
    }

    private AdLogEvent(MoPubLog.LogLevel paramLogLevel, String paramString)
    {
      Preconditions.checkNotNull(paramLogLevel);
      Preconditions.checkNotNull(paramString);
      this.a = paramLogLevel;
      this.b = paramString;
    }

    public MoPubLog.LogLevel getLogLevel()
    {
      return this.a;
    }

    public String getMessage(Object[] paramArrayOfObject)
    {
      return MessageFormat.format(this.b, paramArrayOfObject);
    }
  }

  public static enum AdapterLogEvent
    implements MoPubLog.a
  {
    private MoPubLog.LogLevel a;
    private String b;

    static
    {
      LOAD_FAILED = new AdapterLogEvent("LOAD_FAILED", 2, MoPubLog.LogLevel.DEBUG, "Adapter {0} failed to load ad: ({1}) {2}");
      SHOW_ATTEMPTED = new AdapterLogEvent("SHOW_ATTEMPTED", 3, MoPubLog.LogLevel.DEBUG, "Adapter {0} attempting to show ad");
      SHOW_SUCCESS = new AdapterLogEvent("SHOW_SUCCESS", 4, MoPubLog.LogLevel.DEBUG, "Adapter {0} successfully showed ad");
      SHOW_FAILED = new AdapterLogEvent("SHOW_FAILED", 5, MoPubLog.LogLevel.DEBUG, "Adapter {0} failed to show ad: ({1}) {2}");
      EXPIRED = new AdapterLogEvent("EXPIRED", 6, MoPubLog.LogLevel.DEBUG, "Adapter {0} expired since it was not shown within {1} seconds of it being loaded");
      CLICKED = new AdapterLogEvent("CLICKED", 7, MoPubLog.LogLevel.DEBUG, "Adapter {0} clicked");
      WILL_APPEAR = new AdapterLogEvent("WILL_APPEAR", 8, MoPubLog.LogLevel.DEBUG, "Adapter {0} will appear");
      DID_APPEAR = new AdapterLogEvent("DID_APPEAR", 9, MoPubLog.LogLevel.DEBUG, "Adapter {0} did appear");
      WILL_DISAPPEAR = new AdapterLogEvent("WILL_DISAPPEAR", 10, MoPubLog.LogLevel.DEBUG, "Adapter {0} will disappear");
      DID_DISAPPEAR = new AdapterLogEvent("DID_DISAPPEAR", 11, MoPubLog.LogLevel.DEBUG, "Adapter {0} did disappear");
      SHOULD_REWARD = new AdapterLogEvent("SHOULD_REWARD", 12, MoPubLog.LogLevel.DEBUG, "Adapter {0} should reward user with {1} {2}");
      WILL_LEAVE_APPLICATION = new AdapterLogEvent("WILL_LEAVE_APPLICATION", 13, MoPubLog.LogLevel.DEBUG, "Adapter {0} will leave application");
      CUSTOM = new AdapterLogEvent("CUSTOM", 14, MoPubLog.LogLevel.DEBUG, "Adapter {0} Log - {1}");
      CUSTOM_WITH_THROWABLE = new AdapterLogEvent("CUSTOM_WITH_THROWABLE", 15, MoPubLog.LogLevel.DEBUG, "Adapter Log With Throwable - {0}, {1}");
      AdapterLogEvent[] arrayOfAdapterLogEvent = new AdapterLogEvent[16];
      arrayOfAdapterLogEvent[0] = LOAD_ATTEMPTED;
      arrayOfAdapterLogEvent[1] = LOAD_SUCCESS;
      arrayOfAdapterLogEvent[2] = LOAD_FAILED;
      arrayOfAdapterLogEvent[3] = SHOW_ATTEMPTED;
      arrayOfAdapterLogEvent[4] = SHOW_SUCCESS;
      arrayOfAdapterLogEvent[5] = SHOW_FAILED;
      arrayOfAdapterLogEvent[6] = EXPIRED;
      arrayOfAdapterLogEvent[7] = CLICKED;
      arrayOfAdapterLogEvent[8] = WILL_APPEAR;
      arrayOfAdapterLogEvent[9] = DID_APPEAR;
      arrayOfAdapterLogEvent[10] = WILL_DISAPPEAR;
      arrayOfAdapterLogEvent[11] = DID_DISAPPEAR;
      arrayOfAdapterLogEvent[12] = SHOULD_REWARD;
      arrayOfAdapterLogEvent[13] = WILL_LEAVE_APPLICATION;
      arrayOfAdapterLogEvent[14] = CUSTOM;
      arrayOfAdapterLogEvent[15] = CUSTOM_WITH_THROWABLE;
    }

    private AdapterLogEvent(MoPubLog.LogLevel paramLogLevel, String paramString)
    {
      Preconditions.checkNotNull(paramLogLevel);
      Preconditions.checkNotNull(paramString);
      this.a = paramLogLevel;
      this.b = paramString;
    }

    public MoPubLog.LogLevel getLogLevel()
    {
      return this.a;
    }

    public String getMessage(Object[] paramArrayOfObject)
    {
      MessageFormat localMessageFormat = new MessageFormat(this.b);
      Object[] arrayOfObject1 = Arrays.copyOf(paramArrayOfObject, localMessageFormat.getFormats().length);
      if (this == LOAD_ATTEMPTED)
      {
        if ((paramArrayOfObject.length <= 1) || (paramArrayOfObject[1] == null) || (TextUtils.isEmpty(paramArrayOfObject[1].toString())))
          break label135;
        Object[] arrayOfObject3 = new Object[1];
        arrayOfObject3[0] = paramArrayOfObject[1].toString();
        arrayOfObject1[1] = MessageFormat.format(" with DSP creative ID {0}", arrayOfObject3);
        if ((paramArrayOfObject.length <= 2) || (paramArrayOfObject[2] == null) || (TextUtils.isEmpty(paramArrayOfObject[2].toString())))
          break label143;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = paramArrayOfObject[2].toString();
        arrayOfObject1[2] = MessageFormat.format(" with DSP name {0}", arrayOfObject2);
      }
      while (true)
      {
        return localMessageFormat.format(arrayOfObject1);
        label135: arrayOfObject1[1] = "";
        break;
        label143: arrayOfObject1[2] = "";
      }
    }
  }

  public static enum ConsentLogEvent
    implements MoPubLog.a
  {
    private MoPubLog.LogLevel a;
    private String b;

    static
    {
      SHOULD_SHOW_DIALOG = new ConsentLogEvent("SHOULD_SHOW_DIALOG", 4, MoPubLog.LogLevel.DEBUG, "Consent dialog should be shown");
      LOAD_ATTEMPTED = new ConsentLogEvent("LOAD_ATTEMPTED", 5, MoPubLog.LogLevel.DEBUG, "Consent attempting to load dialog");
      LOAD_SUCCESS = new ConsentLogEvent("LOAD_SUCCESS", 6, MoPubLog.LogLevel.DEBUG, "Consent dialog loaded");
      LOAD_FAILED = new ConsentLogEvent("LOAD_FAILED", 7, MoPubLog.LogLevel.DEBUG, "Consent dialog failed: ({0}) {1}");
      SHOW_ATTEMPTED = new ConsentLogEvent("SHOW_ATTEMPTED", 8, MoPubLog.LogLevel.DEBUG, "Consent dialog attempting to show");
      SHOW_SUCCESS = new ConsentLogEvent("SHOW_SUCCESS", 9, MoPubLog.LogLevel.DEBUG, "Consent successfully showed dialog");
      SHOW_FAILED = new ConsentLogEvent("SHOW_FAILED", 10, MoPubLog.LogLevel.DEBUG, "Consent dialog failed to show: ({0}) {1}");
      CUSTOM = new ConsentLogEvent("CUSTOM", 11, MoPubLog.LogLevel.DEBUG, "Consent Log - {0}");
      CUSTOM_WITH_THROWABLE = new ConsentLogEvent("CUSTOM_WITH_THROWABLE", 12, MoPubLog.LogLevel.DEBUG, "Consent Log With Throwable - {0}, {1}");
      ConsentLogEvent[] arrayOfConsentLogEvent = new ConsentLogEvent[13];
      arrayOfConsentLogEvent[0] = SYNC_ATTEMPTED;
      arrayOfConsentLogEvent[1] = SYNC_COMPLETED;
      arrayOfConsentLogEvent[2] = SYNC_FAILED;
      arrayOfConsentLogEvent[3] = UPDATED;
      arrayOfConsentLogEvent[4] = SHOULD_SHOW_DIALOG;
      arrayOfConsentLogEvent[5] = LOAD_ATTEMPTED;
      arrayOfConsentLogEvent[6] = LOAD_SUCCESS;
      arrayOfConsentLogEvent[7] = LOAD_FAILED;
      arrayOfConsentLogEvent[8] = SHOW_ATTEMPTED;
      arrayOfConsentLogEvent[9] = SHOW_SUCCESS;
      arrayOfConsentLogEvent[10] = SHOW_FAILED;
      arrayOfConsentLogEvent[11] = CUSTOM;
      arrayOfConsentLogEvent[12] = CUSTOM_WITH_THROWABLE;
    }

    private ConsentLogEvent(MoPubLog.LogLevel paramLogLevel, String paramString)
    {
      Preconditions.checkNotNull(paramLogLevel);
      Preconditions.checkNotNull(paramString);
      this.a = paramLogLevel;
      this.b = paramString;
    }

    public MoPubLog.LogLevel getLogLevel()
    {
      return this.a;
    }

    public String getMessage(Object[] paramArrayOfObject)
    {
      if ((this == UPDATED) && (paramArrayOfObject != null) && (paramArrayOfObject.length > 2))
        if ((!(paramArrayOfObject[2] instanceof Boolean)) || (!((Boolean)paramArrayOfObject[2]).booleanValue()))
          break label54;
      label54: for (String str = "can"; ; str = "cannot")
      {
        paramArrayOfObject[2] = str;
        return MessageFormat.format(this.b, paramArrayOfObject);
      }
    }
  }

  public static enum LogLevel
    implements MoPubLog.LogLevelInt
  {
    private int a;
    private String b;

    static
    {
      LogLevel[] arrayOfLogLevel = new LogLevel[3];
      arrayOfLogLevel[0] = DEBUG;
      arrayOfLogLevel[1] = INFO;
      arrayOfLogLevel[2] = NONE;
    }

    private LogLevel(int paramInt, String paramString)
    {
      this.a = paramInt;
      this.b = paramString;
    }

    public static LogLevel valueOf(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return NONE;
      case 20:
        return DEBUG;
      case 30:
      }
      return INFO;
    }

    public int intValue()
    {
      return this.a;
    }

    public String toString()
    {
      return this.b;
    }
  }

  public static abstract interface LogLevelInt
  {
    public static final int DEBUG_INT = 20;
    public static final int INFO_INT = 30;
    public static final int NONE_INT = 70;
  }

  public static enum SdkLogEvent
    implements MoPubLog.a
  {
    private MoPubLog.LogLevel a;
    private String b;

    static
    {
      INIT_FINISHED = new SdkLogEvent("INIT_FINISHED", 1, MoPubLog.LogLevel.INFO, "SDK initialized and ready to display ads.\nInitialized adapters:\n{0}");
      CUSTOM = new SdkLogEvent("CUSTOM", 2, MoPubLog.LogLevel.DEBUG, "SDK Log - {0}");
      CUSTOM_WITH_THROWABLE = new SdkLogEvent("CUSTOM_WITH_THROWABLE", 3, MoPubLog.LogLevel.DEBUG, "SDK Log With Throwable - {0}, {1}");
      ERROR = new SdkLogEvent("ERROR", 4, MoPubLog.LogLevel.DEBUG, "SDK Error Log - {0}, {1}");
      SdkLogEvent[] arrayOfSdkLogEvent = new SdkLogEvent[5];
      arrayOfSdkLogEvent[0] = INIT_STARTED;
      arrayOfSdkLogEvent[1] = INIT_FINISHED;
      arrayOfSdkLogEvent[2] = CUSTOM;
      arrayOfSdkLogEvent[3] = CUSTOM_WITH_THROWABLE;
      arrayOfSdkLogEvent[4] = ERROR;
    }

    private SdkLogEvent(MoPubLog.LogLevel paramLogLevel, String paramString)
    {
      Preconditions.checkNotNull(paramLogLevel);
      Preconditions.checkNotNull(paramString);
      this.a = paramLogLevel;
      this.b = paramString;
    }

    public MoPubLog.LogLevel getLogLevel()
    {
      return this.a;
    }

    public String getMessage(Object[] paramArrayOfObject)
    {
      String str;
      if ((this == INIT_FINISHED) && (paramArrayOfObject.length > 0))
      {
        str = Strings.getDelimitedString(paramArrayOfObject[0], "\n");
        if (!TextUtils.isEmpty(str))
          break label42;
        paramArrayOfObject[0] = "No adapters initialized.";
      }
      while (true)
      {
        return MessageFormat.format(this.b, paramArrayOfObject);
        label42: paramArrayOfObject[0] = str;
      }
    }
  }

  private static abstract interface a
  {
    public abstract MoPubLog.LogLevel getLogLevel();

    public abstract String getMessage(Object[] paramArrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.logging.MoPubLog
 * JD-Core Version:    0.6.2
 */