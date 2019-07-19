package com.viber.voip.registration;

import android.os.AsyncTask;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.registration.c.d;
import com.viber.voip.util.t;

public class f extends AsyncTask<String, Integer, d>
{
  private static final Logger a = ViberEnv.getLogger();
  private String b;
  private a c;
  private t d;

  public f(String paramString, a parama)
  {
    this.b = paramString;
    this.c = parama;
    this.d = new t();
  }

  private int a(ActivationController paramActivationController)
  {
    if (paramActivationController.getStep() == 9)
      return 13;
    return 2;
  }

  // ERROR //
  protected d a(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: invokestatic 52	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
    //   3: astore_2
    //   4: aload_2
    //   5: invokevirtual 56	com/viber/voip/ViberApplication:getActivationController	()Lcom/viber/voip/registration/ActivationController;
    //   8: astore_3
    //   9: aload_2
    //   10: invokevirtual 60	com/viber/voip/ViberApplication:getRequestCreator	()Lcom/viber/voip/registration/ah;
    //   13: aload_0
    //   14: getfield 29	com/viber/voip/registration/f:b	Ljava/lang/String;
    //   17: invokevirtual 65	com/viber/voip/registration/ah:b	(Ljava/lang/String;)Lcom/viber/voip/registration/ag;
    //   20: astore 4
    //   22: new 67	com/viber/voip/registration/ai
    //   25: dup
    //   26: invokespecial 68	com/viber/voip/registration/ai:<init>	()V
    //   29: astore 5
    //   31: aload_3
    //   32: invokevirtual 71	com/viber/voip/registration/ActivationController:checkNetworkConnection	()V
    //   35: aload 5
    //   37: aload 4
    //   39: aload_0
    //   40: getfield 36	com/viber/voip/registration/f:d	Lcom/viber/voip/util/t;
    //   43: invokevirtual 74	com/viber/voip/registration/ai:a	(Lcom/viber/voip/registration/ag;Lcom/viber/voip/util/t;)Ljava/lang/Object;
    //   46: checkcast 76	com/viber/voip/registration/c/d
    //   49: astore 7
    //   51: invokestatic 81	com/viber/voip/rakuten/a:a	()Lcom/viber/voip/rakuten/a;
    //   54: aload 7
    //   56: invokevirtual 84	com/viber/voip/rakuten/a:a	(Lcom/viber/voip/registration/c/h;)V
    //   59: aload 7
    //   61: astore 8
    //   63: aload 8
    //   65: ifnull +72 -> 137
    //   68: aload 8
    //   70: invokevirtual 88	com/viber/voip/registration/c/d:f	()Z
    //   73: ifeq +64 -> 137
    //   76: aload_0
    //   77: aload_3
    //   78: invokespecial 90	com/viber/voip/registration/f:a	(Lcom/viber/voip/registration/ActivationController;)I
    //   81: istore 9
    //   83: aload_3
    //   84: aload 8
    //   86: invokevirtual 93	com/viber/voip/registration/c/d:b	()Ljava/lang/String;
    //   89: invokevirtual 97	com/viber/voip/registration/ActivationController:setDeviceKey	(Ljava/lang/String;)V
    //   92: aload_3
    //   93: aload 8
    //   95: invokevirtual 93	com/viber/voip/registration/c/d:b	()Ljava/lang/String;
    //   98: invokevirtual 100	com/viber/voip/registration/ActivationController:setKeyChainDeviceKey	(Ljava/lang/String;)V
    //   101: invokestatic 103	com/viber/voip/registration/ao:f	()Z
    //   104: ifeq +48 -> 152
    //   107: getstatic 108	com/viber/voip/settings/b/e$a$a:c	Lcom/viber/voip/settings/b/f;
    //   110: invokevirtual 112	com/viber/voip/settings/b/f:d	()Ljava/lang/String;
    //   113: astore 10
    //   115: aload_3
    //   116: aload 10
    //   118: invokevirtual 115	com/viber/voip/registration/ActivationController:setKeyChainUDID	(Ljava/lang/String;)V
    //   121: aload_3
    //   122: aload 8
    //   124: invokevirtual 117	com/viber/voip/registration/c/d:a	()Ljava/lang/String;
    //   127: invokevirtual 120	com/viber/voip/registration/ActivationController:setMid	(Ljava/lang/String;)V
    //   130: aload_3
    //   131: iload 9
    //   133: iconst_1
    //   134: invokevirtual 124	com/viber/voip/registration/ActivationController:setStep	(IZ)V
    //   137: aload 8
    //   139: areturn
    //   140: astore 6
    //   142: aconst_null
    //   143: astore 7
    //   145: aload 7
    //   147: astore 8
    //   149: goto -86 -> 63
    //   152: getstatic 129	com/viber/voip/settings/b/e$a:l	Lcom/viber/voip/settings/b/f;
    //   155: invokevirtual 112	com/viber/voip/settings/b/f:d	()Ljava/lang/String;
    //   158: astore 10
    //   160: goto -45 -> 115
    //   163: astore 11
    //   165: goto -20 -> 145
    //
    // Exception table:
    //   from	to	target	type
    //   31	51	140	java/lang/Exception
    //   51	59	163	java/lang/Exception
  }

  protected void a(d paramd)
  {
    ActivationController localActivationController = ViberApplication.getInstance().getActivationController();
    if ((paramd != null) && (!paramd.f()) && ("109".equals(paramd.g())))
      localActivationController.resetActivationCode();
    if (this.c != null)
      this.c.a(this.b, paramd);
  }

  protected void onCancelled()
  {
    super.onCancelled();
    this.d.b();
    this.c = null;
  }

  public static abstract interface a
  {
    public abstract void a(String paramString, d paramd);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.f
 * JD-Core Version:    0.6.2
 */