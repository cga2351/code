package com.adjust.sdk;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InstallReferrer
  implements InvocationHandler
{
  private static final String PACKAGE_BASE_NAME = "com.android.installreferrer.";
  private static final int STATUS_DEVELOPER_ERROR = 3;
  private static final int STATUS_FEATURE_NOT_SUPPORTED = 2;
  private static final int STATUS_OK = 0;
  private static final int STATUS_SERVICE_DISCONNECTED = -1;
  private static final int STATUS_SERVICE_UNAVAILABLE = 1;
  private WeakReference<IActivityHandler> activityHandlerWeakRef;
  private Context context;
  private final Object flagLock;
  private boolean hasInstallReferrerBeenRead;
  private ILogger logger = AdjustFactory.getLogger();
  private Object referrerClient;
  private int retries;
  private TimerOnce retryTimer;
  private int retryWaitTime = 3000;

  public InstallReferrer(Context paramContext, IActivityHandler paramIActivityHandler)
  {
    this.context = paramContext;
    this.flagLock = new Object();
    this.hasInstallReferrerBeenRead = false;
    this.retries = 0;
    this.retryTimer = new TimerOnce(new Runnable()
    {
      public void run()
      {
        InstallReferrer.this.startConnection();
      }
    }
    , "InstallReferrer");
    this.activityHandlerWeakRef = new WeakReference(paramIActivityHandler);
  }

  private void closeReferrerClient()
  {
    if (this.referrerClient == null)
      return;
    try
    {
      Reflection.invokeInstanceMethod(this.referrerClient, "endConnection", null, new Object[0]);
      this.referrerClient = null;
      return;
    }
    catch (Exception localException)
    {
      while (true)
      {
        ILogger localILogger = this.logger;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = localException.getMessage();
        arrayOfObject[1] = localException.getClass().getCanonicalName();
        localILogger.error("closeReferrerClient error (%s) thrown by (%s)", arrayOfObject);
      }
    }
  }

  private Object createInstallReferrerClient(Context paramContext)
  {
    try
    {
      Object localObject = Reflection.invokeInstanceMethod(Reflection.invokeStaticMethod("com.android.installreferrer.api.InstallReferrerClient", "newBuilder", new Class[] { Context.class }, new Object[] { paramContext }), "build", null, new Object[0]);
      return localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      ILogger localILogger2 = this.logger;
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = localClassNotFoundException.getMessage();
      arrayOfObject2[1] = localClassNotFoundException.getClass().getCanonicalName();
      localILogger2.warn("InstallReferrer not integrated in project (%s) thrown by (%s)", arrayOfObject2);
      return null;
    }
    catch (Exception localException)
    {
      ILogger localILogger1 = this.logger;
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = localException.getMessage();
      arrayOfObject1[1] = localException.getClass().getCanonicalName();
      localILogger1.error("createInstallReferrerClient error (%s) from (%s)", arrayOfObject1);
    }
    return null;
  }

  private Object createProxyInstallReferrerStateListener(Class paramClass)
  {
    try
    {
      Object localObject = Proxy.newProxyInstance(paramClass.getClassLoader(), new Class[] { paramClass }, this);
      return localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.logger.error("InstallReferrer proxy violating parameter restrictions", new Object[0]);
      return null;
    }
    catch (NullPointerException localNullPointerException)
    {
      this.logger.error("Null argument passed to InstallReferrer proxy", new Object[0]);
    }
    return null;
  }

  private long getInstallBeginTimestampSeconds(Object paramObject)
  {
    if (paramObject == null)
      return -1L;
    try
    {
      long l = ((Long)Reflection.invokeInstanceMethod(paramObject, "getInstallBeginTimestampSeconds", null, new Object[0])).longValue();
      return l;
    }
    catch (Exception localException)
    {
      ILogger localILogger = this.logger;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localException.getMessage();
      arrayOfObject[1] = localException.getClass().getCanonicalName();
      localILogger.error("getInstallBeginTimestampSeconds error (%s) thrown by (%s)", arrayOfObject);
    }
    return -1L;
  }

  private Object getInstallReferrer()
  {
    if (this.referrerClient == null)
      return null;
    try
    {
      Object localObject = Reflection.invokeInstanceMethod(this.referrerClient, "getInstallReferrer", null, new Object[0]);
      return localObject;
    }
    catch (Exception localException)
    {
      ILogger localILogger = this.logger;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localException.getMessage();
      arrayOfObject[1] = localException.getClass().getCanonicalName();
      localILogger.error("getInstallReferrer error (%s) thrown by (%s)", arrayOfObject);
    }
    return null;
  }

  private Class getInstallReferrerStateListenerClass()
  {
    try
    {
      Class localClass = Class.forName("com.android.installreferrer.api.InstallReferrerStateListener");
      return localClass;
    }
    catch (Exception localException)
    {
      ILogger localILogger = this.logger;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localException.getMessage();
      arrayOfObject[1] = localException.getClass().getCanonicalName();
      localILogger.error("getInstallReferrerStateListenerClass error (%s) from (%s)", arrayOfObject);
    }
    return null;
  }

  private long getReferrerClickTimestampSeconds(Object paramObject)
  {
    if (paramObject == null)
      return -1L;
    try
    {
      long l = ((Long)Reflection.invokeInstanceMethod(paramObject, "getReferrerClickTimestampSeconds", null, new Object[0])).longValue();
      return l;
    }
    catch (Exception localException)
    {
      ILogger localILogger = this.logger;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localException.getMessage();
      arrayOfObject[1] = localException.getClass().getCanonicalName();
      localILogger.error("getReferrerClickTimestampSeconds error (%s) thrown by (%s)", arrayOfObject);
    }
    return -1L;
  }

  private String getStringInstallReferrer(Object paramObject)
  {
    if (paramObject == null)
      return null;
    try
    {
      String str = (String)Reflection.invokeInstanceMethod(paramObject, "getInstallReferrer", null, new Object[0]);
      return str;
    }
    catch (Exception localException)
    {
      ILogger localILogger = this.logger;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localException.getMessage();
      arrayOfObject[1] = localException.getClass().getCanonicalName();
      localILogger.error("getStringInstallReferrer error (%s) thrown by (%s)", arrayOfObject);
    }
    return null;
  }

  // ERROR //
  private void onInstallReferrerSetupFinishedInt(int paramInt)
  {
    // Byte code:
    //   0: iload_1
    //   1: tableswitch	default:+35 -> 36, -1:+299->300, 0:+71->72, 1:+259->260, 2:+243->244, 3:+279->280
    //   37: getfield 52	com/adjust/sdk/InstallReferrer:logger	Lcom/adjust/sdk/ILogger;
    //   40: astore 16
    //   42: iconst_1
    //   43: anewarray 4	java/lang/Object
    //   46: astore 17
    //   48: aload 17
    //   50: iconst_0
    //   51: iload_1
    //   52: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: aastore
    //   56: aload 16
    //   58: ldc 206
    //   60: aload 17
    //   62: invokeinterface 209 3 0
    //   67: aload_0
    //   68: invokespecial 211	com/adjust/sdk/InstallReferrer:closeReferrerClient	()V
    //   71: return
    //   72: aload_0
    //   73: invokespecial 213	com/adjust/sdk/InstallReferrer:getInstallReferrer	()Ljava/lang/Object;
    //   76: astore 5
    //   78: aload_0
    //   79: aload 5
    //   81: invokespecial 215	com/adjust/sdk/InstallReferrer:getStringInstallReferrer	(Ljava/lang/Object;)Ljava/lang/String;
    //   84: astore 6
    //   86: aload_0
    //   87: aload 5
    //   89: invokespecial 217	com/adjust/sdk/InstallReferrer:getReferrerClickTimestampSeconds	(Ljava/lang/Object;)J
    //   92: lstore 7
    //   94: aload_0
    //   95: aload 5
    //   97: invokespecial 219	com/adjust/sdk/InstallReferrer:getInstallBeginTimestampSeconds	(Ljava/lang/Object;)J
    //   100: lstore 9
    //   102: aload_0
    //   103: getfield 52	com/adjust/sdk/InstallReferrer:logger	Lcom/adjust/sdk/ILogger;
    //   106: astore 11
    //   108: iconst_3
    //   109: anewarray 4	java/lang/Object
    //   112: astore 12
    //   114: aload 12
    //   116: iconst_0
    //   117: aload 6
    //   119: aastore
    //   120: aload 12
    //   122: iconst_1
    //   123: lload 7
    //   125: invokestatic 222	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   128: aastore
    //   129: aload 12
    //   131: iconst_2
    //   132: lload 9
    //   134: invokestatic 222	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   137: aastore
    //   138: aload 11
    //   140: ldc 224
    //   142: aload 12
    //   144: invokeinterface 209 3 0
    //   149: aload_0
    //   150: getfield 81	com/adjust/sdk/InstallReferrer:activityHandlerWeakRef	Ljava/lang/ref/WeakReference;
    //   153: invokevirtual 227	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   156: checkcast 229	com/adjust/sdk/IActivityHandler
    //   159: astore 13
    //   161: aload 13
    //   163: ifnull +16 -> 179
    //   166: aload 13
    //   168: lload 7
    //   170: lload 9
    //   172: aload 6
    //   174: invokeinterface 233 6 0
    //   179: aload_0
    //   180: getfield 56	com/adjust/sdk/InstallReferrer:flagLock	Ljava/lang/Object;
    //   183: astore 14
    //   185: aload 14
    //   187: monitorenter
    //   188: aload_0
    //   189: iconst_1
    //   190: putfield 58	com/adjust/sdk/InstallReferrer:hasInstallReferrerBeenRead	Z
    //   193: aload 14
    //   195: monitorexit
    //   196: aload_0
    //   197: invokespecial 211	com/adjust/sdk/InstallReferrer:closeReferrerClient	()V
    //   200: return
    //   201: astore_2
    //   202: aload_0
    //   203: getfield 52	com/adjust/sdk/InstallReferrer:logger	Lcom/adjust/sdk/ILogger;
    //   206: astore_3
    //   207: iconst_1
    //   208: anewarray 4	java/lang/Object
    //   211: astore 4
    //   213: aload 4
    //   215: iconst_0
    //   216: aload_2
    //   217: invokevirtual 98	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   220: aastore
    //   221: aload_3
    //   222: ldc 235
    //   224: aload 4
    //   226: invokeinterface 137 3 0
    //   231: aload_0
    //   232: invokespecial 238	com/adjust/sdk/InstallReferrer:retry	()V
    //   235: return
    //   236: astore 15
    //   238: aload 14
    //   240: monitorexit
    //   241: aload 15
    //   243: athrow
    //   244: aload_0
    //   245: getfield 52	com/adjust/sdk/InstallReferrer:logger	Lcom/adjust/sdk/ILogger;
    //   248: ldc 240
    //   250: iconst_0
    //   251: anewarray 4	java/lang/Object
    //   254: invokeinterface 209 3 0
    //   259: return
    //   260: aload_0
    //   261: getfield 52	com/adjust/sdk/InstallReferrer:logger	Lcom/adjust/sdk/ILogger;
    //   264: ldc 242
    //   266: iconst_0
    //   267: anewarray 4	java/lang/Object
    //   270: invokeinterface 209 3 0
    //   275: aload_0
    //   276: invokespecial 238	com/adjust/sdk/InstallReferrer:retry	()V
    //   279: return
    //   280: aload_0
    //   281: getfield 52	com/adjust/sdk/InstallReferrer:logger	Lcom/adjust/sdk/ILogger;
    //   284: ldc 244
    //   286: iconst_0
    //   287: anewarray 4	java/lang/Object
    //   290: invokeinterface 209 3 0
    //   295: aload_0
    //   296: invokespecial 238	com/adjust/sdk/InstallReferrer:retry	()V
    //   299: return
    //   300: aload_0
    //   301: getfield 52	com/adjust/sdk/InstallReferrer:logger	Lcom/adjust/sdk/ILogger;
    //   304: ldc 246
    //   306: iconst_0
    //   307: anewarray 4	java/lang/Object
    //   310: invokeinterface 209 3 0
    //   315: aload_0
    //   316: invokespecial 238	com/adjust/sdk/InstallReferrer:retry	()V
    //   319: return
    //
    // Exception table:
    //   from	to	target	type
    //   72	161	201	java/lang/Exception
    //   166	179	201	java/lang/Exception
    //   179	188	201	java/lang/Exception
    //   196	200	201	java/lang/Exception
    //   241	244	201	java/lang/Exception
    //   188	196	236	finally
    //   238	241	236	finally
  }

  private void retry()
  {
    synchronized (this.flagLock)
    {
      if (this.hasInstallReferrerBeenRead)
      {
        this.logger.debug("Install referrer has already been read", new Object[0]);
        return;
      }
      this.retries = (1 + this.retries);
      if (this.retries > 2)
      {
        this.logger.debug("Limit number of retry for install referrer surpassed", new Object[0]);
        return;
      }
    }
    long l = this.retryTimer.getFireIn();
    if (l > 0L)
    {
      ILogger localILogger = this.logger;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Long.valueOf(l);
      localILogger.debug("Already waiting to retry to read install referrer in %d milliseconds", arrayOfObject);
      return;
    }
    this.retryTimer.startIn(this.retryWaitTime);
  }

  private void startConnection(Class paramClass, Object paramObject)
  {
    try
    {
      Reflection.invokeInstanceMethod(this.referrerClient, "startConnection", new Class[] { paramClass }, new Object[] { paramObject });
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      while (!Util.hasRootCause(localInvocationTargetException));
      ILogger localILogger2 = this.logger;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Util.getRootCause(localInvocationTargetException);
      localILogger2.error("InstallReferrer encountered an InvocationTargetException %s", arrayOfObject2);
      return;
    }
    catch (Exception localException)
    {
      ILogger localILogger1 = this.logger;
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = localException.getMessage();
      arrayOfObject1[1] = localException.getClass().getCanonicalName();
      localILogger1.error("startConnection error (%s) thrown by (%s)", arrayOfObject1);
    }
  }

  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    throws Throwable
  {
    if (paramMethod == null)
      this.logger.error("InstallReferrer invoke method null", new Object[0]);
    String str;
    do
    {
      return null;
      str = paramMethod.getName();
      if (str == null)
      {
        this.logger.error("InstallReferrer invoke method name null", new Object[0]);
        return null;
      }
      this.logger.debug("InstallReferrer invoke method name: %s", new Object[] { str });
      if (paramArrayOfObject == null)
        this.logger.warn("InstallReferrer invoke args null", new Object[0]);
      for (Object localObject2 : new Object[0])
        this.logger.debug("InstallReferrer invoke arg: %s", new Object[] { localObject2 });
      if (str.equals("onInstallReferrerSetupFinished"))
      {
        if (paramArrayOfObject.length != 1)
        {
          ILogger localILogger = this.logger;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Integer.valueOf(paramArrayOfObject.length);
          localILogger.error("InstallReferrer invoke onInstallReferrerSetupFinished args lenght not 1: %d", arrayOfObject);
          return null;
        }
        Object localObject1 = paramArrayOfObject[0];
        if (!(localObject1 instanceof Integer))
        {
          this.logger.error("InstallReferrer invoke onInstallReferrerSetupFinished arg not int", new Object[0]);
          return null;
        }
        Integer localInteger = (Integer)localObject1;
        if (localInteger == null)
        {
          this.logger.error("InstallReferrer invoke onInstallReferrerSetupFinished responseCode arg is null", new Object[0]);
          return null;
        }
        onInstallReferrerSetupFinishedInt(localInteger.intValue());
        return null;
      }
    }
    while (!str.equals("onInstallReferrerServiceDisconnected"));
    this.logger.debug("InstallReferrer onInstallReferrerServiceDisconnected", new Object[0]);
    return null;
  }

  public void startConnection()
  {
    if (!AdjustFactory.getTryInstallReferrer());
    Class localClass;
    Object localObject3;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            closeReferrerClient();
            synchronized (this.flagLock)
            {
              if (this.hasInstallReferrerBeenRead)
              {
                this.logger.debug("Install referrer has already been read", new Object[0]);
                return;
              }
            }
          }
          while (this.context == null);
          this.referrerClient = createInstallReferrerClient(this.context);
        }
        while (this.referrerClient == null);
        localClass = getInstallReferrerStateListenerClass();
      }
      while (localClass == null);
      localObject3 = createProxyInstallReferrerStateListener(localClass);
    }
    while (localObject3 == null);
    startConnection(localClass, localObject3);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.InstallReferrer
 * JD-Core Version:    0.6.2
 */