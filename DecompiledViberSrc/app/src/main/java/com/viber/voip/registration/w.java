package com.viber.voip.registration;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.f.d;
import com.viber.voip.registration.c.r;
import com.viber.voip.util.t;

public class w extends AsyncTask<String, Integer, r>
{
  private static final Logger a = ViberEnv.getLogger();
  private final d b;
  private final String c;
  private final String d;
  private String e;
  private String f;
  private String g;
  private final boolean h;
  private byte i;
  private a j;
  private t k;

  public w(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, d paramd, a parama, byte paramByte)
  {
    this.c = paramString1;
    this.d = paramString2;
    this.f = paramString3;
    this.g = paramString4;
    b();
    this.h = paramBoolean;
    this.b = paramd;
    this.j = parama;
    this.k = new t();
    this.i = paramByte;
  }

  private void b()
  {
    if (!TextUtils.isEmpty(this.f));
    for (String str = "1"; ; str = "0")
    {
      this.e = str;
      return;
    }
  }

  // ERROR //
  protected r a(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: invokestatic 81	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
    //   3: astore_3
    //   4: aload_3
    //   5: invokevirtual 85	com/viber/voip/ViberApplication:getActivationController	()Lcom/viber/voip/registration/ActivationController;
    //   8: astore 4
    //   10: aload 4
    //   12: invokevirtual 90	com/viber/voip/registration/ActivationController:checkNetworkConnection	()V
    //   15: ldc 68
    //   17: aload_0
    //   18: getfield 70	com/viber/voip/registration/w:e	Ljava/lang/String;
    //   21: invokevirtual 96	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   24: istore 5
    //   26: aload_3
    //   27: invokevirtual 100	com/viber/voip/ViberApplication:getBackupManager	()Lcom/viber/backup/a/e;
    //   30: iload 5
    //   32: invokevirtual 105	com/viber/backup/a/e:a	(Z)Z
    //   35: ifeq +34 -> 69
    //   38: aload_0
    //   39: aload 4
    //   41: invokevirtual 109	com/viber/voip/registration/ActivationController:getKeyChainDeviceKey	()Ljava/lang/String;
    //   44: putfield 43	com/viber/voip/registration/w:f	Ljava/lang/String;
    //   47: aload_0
    //   48: aload 4
    //   50: invokevirtual 112	com/viber/voip/registration/ActivationController:getKeyChainUDID	()Ljava/lang/String;
    //   53: putfield 45	com/viber/voip/registration/w:g	Ljava/lang/String;
    //   56: aload_0
    //   57: aload 4
    //   59: invokevirtual 116	com/viber/voip/registration/ActivationController:getKeyChainDeviceKeySource	()B
    //   62: putfield 60	com/viber/voip/registration/w:i	B
    //   65: aload_0
    //   66: invokespecial 47	com/viber/voip/registration/w:b	()V
    //   69: iload 5
    //   71: ifeq +22 -> 93
    //   74: getstatic 121	com/viber/voip/settings/d$ar:c	Lcom/viber/common/b/d;
    //   77: iconst_0
    //   78: invokevirtual 126	com/viber/common/b/d:a	(I)V
    //   81: aload_0
    //   82: getfield 51	com/viber/voip/registration/w:b	Lcom/viber/voip/analytics/story/f/d;
    //   85: getstatic 131	com/viber/voip/registration/ActivationController$b:e	Lcom/viber/voip/registration/ActivationController$b;
    //   88: invokeinterface 136 2 0
    //   93: getstatic 121	com/viber/voip/settings/d$ar:c	Lcom/viber/common/b/d;
    //   96: invokevirtual 139	com/viber/common/b/d:d	()I
    //   99: istore 6
    //   101: invokestatic 81	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
    //   104: invokevirtual 143	com/viber/voip/ViberApplication:getRequestCreator	()Lcom/viber/voip/registration/ah;
    //   107: aload_0
    //   108: getfield 39	com/viber/voip/registration/w:c	Ljava/lang/String;
    //   111: aload_0
    //   112: getfield 41	com/viber/voip/registration/w:d	Ljava/lang/String;
    //   115: aload_0
    //   116: getfield 43	com/viber/voip/registration/w:f	Ljava/lang/String;
    //   119: aload_0
    //   120: getfield 45	com/viber/voip/registration/w:g	Ljava/lang/String;
    //   123: aload_0
    //   124: getfield 70	com/viber/voip/registration/w:e	Ljava/lang/String;
    //   127: iload 6
    //   129: aload_0
    //   130: getfield 60	com/viber/voip/registration/w:i	B
    //   133: aload_0
    //   134: getfield 49	com/viber/voip/registration/w:h	Z
    //   137: invokevirtual 148	com/viber/voip/registration/ah:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IBZ)Lcom/viber/voip/registration/ag;
    //   140: astore 7
    //   142: new 150	com/viber/voip/registration/ai
    //   145: dup
    //   146: invokespecial 151	com/viber/voip/registration/ai:<init>	()V
    //   149: aload 7
    //   151: aload_0
    //   152: getfield 58	com/viber/voip/registration/w:k	Lcom/viber/voip/util/t;
    //   155: invokevirtual 154	com/viber/voip/registration/ai:a	(Lcom/viber/voip/registration/ag;Lcom/viber/voip/util/t;)Ljava/lang/Object;
    //   158: checkcast 156	com/viber/voip/registration/c/r
    //   161: astore 8
    //   163: invokestatic 161	com/viber/voip/analytics/g:a	()Lcom/viber/voip/analytics/g;
    //   166: aload_0
    //   167: getfield 70	com/viber/voip/registration/w:e	Ljava/lang/String;
    //   170: aload_0
    //   171: getfield 60	com/viber/voip/registration/w:i	B
    //   174: invokestatic 167	java/lang/Byte:toString	(B)Ljava/lang/String;
    //   177: invokestatic 172	com/viber/voip/registration/ao:f	()Z
    //   180: invokestatic 177	com/viber/voip/analytics/story/l/d:a	(Ljava/lang/String;Ljava/lang/String;Z)Lcom/viber/voip/analytics/story/e;
    //   183: invokevirtual 180	com/viber/voip/analytics/g:a	(Lcom/viber/voip/analytics/story/e;)V
    //   186: aload 8
    //   188: ifnull +102 -> 290
    //   191: aload 8
    //   193: invokevirtual 181	com/viber/voip/registration/c/r:f	()Z
    //   196: ifeq +38 -> 234
    //   199: aload 8
    //   201: invokevirtual 183	com/viber/voip/registration/c/r:c	()Ljava/lang/String;
    //   204: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   207: ifeq +64 -> 271
    //   210: aload 8
    //   212: invokevirtual 185	com/viber/voip/registration/c/r:b	()Ljava/lang/String;
    //   215: astore 11
    //   217: aload 4
    //   219: aload 11
    //   221: invokevirtual 189	com/viber/voip/registration/ActivationController:storeRegNumberCanonized	(Ljava/lang/String;)V
    //   224: aload 4
    //   226: aload 8
    //   228: invokevirtual 191	com/viber/voip/registration/c/r:e	()Z
    //   231: invokevirtual 195	com/viber/voip/registration/ActivationController:setAutoDismissTzintukCall	(Z)V
    //   234: aload 8
    //   236: invokevirtual 197	com/viber/voip/registration/c/r:a	()Z
    //   239: ifeq +51 -> 290
    //   242: aload 4
    //   244: aload_0
    //   245: getfield 43	com/viber/voip/registration/w:f	Ljava/lang/String;
    //   248: invokevirtual 200	com/viber/voip/registration/ActivationController:setDeviceKey	(Ljava/lang/String;)V
    //   251: aload 4
    //   253: aload 8
    //   255: invokevirtual 202	com/viber/voip/registration/c/r:d	()Ljava/lang/String;
    //   258: invokevirtual 205	com/viber/voip/registration/ActivationController:setMid	(Ljava/lang/String;)V
    //   261: aload 4
    //   263: iconst_3
    //   264: iconst_0
    //   265: invokevirtual 209	com/viber/voip/registration/ActivationController:setStep	(IZ)V
    //   268: aload 8
    //   270: areturn
    //   271: aload 8
    //   273: invokevirtual 183	com/viber/voip/registration/c/r:c	()Ljava/lang/String;
    //   276: astore 10
    //   278: aload 10
    //   280: astore 11
    //   282: goto -65 -> 217
    //   285: astore_2
    //   286: aconst_null
    //   287: areturn
    //   288: astore 9
    //   290: aload 8
    //   292: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   0	69	285	java/lang/Exception
    //   74	93	285	java/lang/Exception
    //   93	163	285	java/lang/Exception
    //   163	186	288	java/lang/Exception
    //   191	217	288	java/lang/Exception
    //   217	234	288	java/lang/Exception
    //   234	268	288	java/lang/Exception
    //   271	278	288	java/lang/Exception
  }

  public void a()
  {
    this.j = null;
  }

  protected void a(r paramr)
  {
    if (paramr == null)
      if (this.j != null)
        this.j.B();
    label91: 
    do
    {
      do
      {
        do
        {
          return;
          if (!paramr.f())
            break label91;
          if ((ao.f()) && (this.j != null))
            this.j.z();
          if (!paramr.a())
            break;
        }
        while (this.j == null);
        this.j.A();
        return;
      }
      while (this.j == null);
      this.j.g();
      return;
    }
    while (this.j == null);
    this.j.b(paramr.h(), paramr.g());
  }

  protected void onCancelled()
  {
    super.onCancelled();
    a();
    this.k.b();
  }

  public static abstract interface a
  {
    public abstract void A();

    public abstract void B();

    public abstract void b(String paramString1, String paramString2);

    public abstract void g();

    public abstract void z();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.w
 * JD-Core Version:    0.6.2
 */