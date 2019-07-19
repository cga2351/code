package com.viber.voip.pixie.jni;

import com.viber.common.a.e;
import com.viber.jni.JniUtils;
import com.viber.voip.ViberEnv;
import com.viber.voip.pixie.UnblockerDefines.SocksInfo;
import java.util.concurrent.atomic.AtomicBoolean;

public class UnblockerControllerFacade
{
  private static final boolean CHECK_BROKEN_64BIT_LOADERS = true;
  private static final e L = ViberEnv.getLogger();
  private static AtomicBoolean g_loaded = new AtomicBoolean(false);
  private final UnblockerControllerHelper helper;

  // ERROR //
  static
  {
    // Byte code:
    //   0: invokestatic 23	com/viber/voip/ViberEnv:getLogger	()Lcom/viber/dexshared/Logger;
    //   3: putstatic 25	com/viber/voip/pixie/jni/UnblockerControllerFacade:L	Lcom/viber/common/a/e;
    //   6: new 27	java/util/concurrent/atomic/AtomicBoolean
    //   9: dup
    //   10: iconst_0
    //   11: invokespecial 31	java/util/concurrent/atomic/AtomicBoolean:<init>	(Z)V
    //   14: putstatic 33	com/viber/voip/pixie/jni/UnblockerControllerFacade:g_loaded	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   17: new 35	com/viber/libnativehttp/AndroidHttp
    //   20: dup
    //   21: invokespecial 37	com/viber/libnativehttp/AndroidHttp:<init>	()V
    //   24: pop
    //   25: iconst_3
    //   26: anewarray 39	java/lang/String
    //   29: dup
    //   30: iconst_0
    //   31: ldc 41
    //   33: aastore
    //   34: dup
    //   35: iconst_1
    //   36: ldc 43
    //   38: aastore
    //   39: dup
    //   40: iconst_2
    //   41: ldc 45
    //   43: aastore
    //   44: astore_1
    //   45: ldc 47
    //   47: invokestatic 53	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   50: astore 5
    //   52: iconst_2
    //   53: anewarray 49	java/lang/Class
    //   56: astore 6
    //   58: aload 6
    //   60: iconst_0
    //   61: ldc 39
    //   63: aastore
    //   64: aload 6
    //   66: iconst_1
    //   67: getstatic 59	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   70: aastore
    //   71: aload 5
    //   73: ldc 61
    //   75: aload 6
    //   77: invokevirtual 65	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   80: astore 7
    //   82: aload_1
    //   83: arraylength
    //   84: istore 8
    //   86: iconst_0
    //   87: istore 9
    //   89: iload 9
    //   91: iload 8
    //   93: if_icmpge +67 -> 160
    //   96: aload_1
    //   97: iload 9
    //   99: aaload
    //   100: astore 10
    //   102: iconst_2
    //   103: anewarray 4	java/lang/Object
    //   106: astore 11
    //   108: aload 11
    //   110: iconst_0
    //   111: aload 10
    //   113: aastore
    //   114: aload 11
    //   116: iconst_1
    //   117: iconst_0
    //   118: invokestatic 69	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   121: aastore
    //   122: aload 7
    //   124: aconst_null
    //   125: aload 11
    //   127: invokevirtual 75	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   130: checkcast 55	java/lang/Boolean
    //   133: invokevirtual 79	java/lang/Boolean:booleanValue	()Z
    //   136: istore 12
    //   138: iload 12
    //   140: iconst_1
    //   141: iand
    //   142: istore 13
    //   144: iload 13
    //   146: ifne +8 -> 154
    //   149: aload 10
    //   151: invokestatic 84	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   154: iinc 9 1
    //   157: goto -68 -> 89
    //   160: iconst_1
    //   161: istore_3
    //   162: getstatic 33	com/viber/voip/pixie/jni/UnblockerControllerFacade:g_loaded	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   165: iload_3
    //   166: invokevirtual 87	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   169: return
    //   170: astore_2
    //   171: iconst_1
    //   172: istore_3
    //   173: aload_2
    //   174: astore 4
    //   176: aload 4
    //   178: invokevirtual 90	java/lang/Throwable:printStackTrace	()V
    //   181: goto -19 -> 162
    //   184: astore 14
    //   186: aload 14
    //   188: astore 4
    //   190: iload 13
    //   192: istore_3
    //   193: goto -17 -> 176
    //
    // Exception table:
    //   from	to	target	type
    //   45	86	170	java/lang/Throwable
    //   96	138	170	java/lang/Throwable
    //   149	154	184	java/lang/Throwable
  }

  private UnblockerControllerFacade()
  {
    if (g_loaded.get())
    {
      this.helper = new UnblockerControllerHelper();
      return;
    }
    this.helper = null;
  }

  public static UnblockerControllerFacade newInstance()
  {
    return new UnblockerControllerFacade();
  }

  public void AddRedirect(String paramString1, String paramString2)
  {
    if ((!g_loaded.get()) || (this.helper == null))
      return;
    this.helper.addRedirect(paramString1, paramString2);
  }

  @Deprecated
  public void CrashLibrary()
  {
    if ((!g_loaded.get()) || (this.helper == null))
      return;
    this.helper.crashLibrary();
  }

  public void Done()
  {
    if ((!g_loaded.get()) || (this.helper == null))
      return;
    this.helper.done();
  }

  public int Init(Object paramObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt1, int paramInt2, boolean paramBoolean, String paramString8)
  {
    if ((!g_loaded.get()) || (this.helper == null))
      return -1;
    return this.helper.init(paramObject, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramInt1, paramInt2, paramBoolean, paramString8);
  }

  public void SetPushConfig(String paramString)
  {
    if ((!g_loaded.get()) || (this.helper == null))
      return;
    this.helper.setPushConfig(paramString);
  }

  public void SetSocksProxy(String paramString1, int paramInt, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((!g_loaded.get()) || (this.helper == null))
      return;
    this.helper.setSocksProxy(paramString1, paramInt, paramString2, paramString3, paramBoolean);
  }

  public boolean ShouldCheckGeoInfo()
  {
    if ((!g_loaded.get()) || (this.helper == null))
      return false;
    return this.helper.ShouldCheckGeoInfo();
  }

  public void UpdateGeoInfo()
  {
    if ((!g_loaded.get()) || (this.helper == null))
      return;
    this.helper.updateGeoInfo();
  }

  public void UpdatePhoneNumber(String paramString)
  {
    if ((!g_loaded.get()) || (this.helper == null))
      return;
    this.helper.updatePhoneNumber(paramString);
  }

  public String[] getDomains()
  {
    if ((!g_loaded.get()) || (this.helper == null))
      return null;
    return this.helper.getDomains();
  }

  public String getUnblockerInfo()
  {
    if ((!g_loaded.get()) || (this.helper == null))
      return "";
    return this.helper.getUnblockerInfo();
  }

  public void setProxy(int paramInt, UnblockerDefines.SocksInfo paramSocksInfo, boolean paramBoolean)
  {
    if ((!g_loaded.get()) || (this.helper == null))
      return;
    this.helper.setProxy(paramInt, JniUtils.toBundle(paramSocksInfo), paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.pixie.jni.UnblockerControllerFacade
 * JD-Core Version:    0.6.2
 */