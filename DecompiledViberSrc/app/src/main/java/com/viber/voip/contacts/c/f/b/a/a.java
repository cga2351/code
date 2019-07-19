package com.viber.voip.contacts.c.f.b.a;

import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.jni.CContactInfo;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.CRegisteredContactsMsg;
import com.viber.voip.contacts.c.f.b.c.a;
import com.viber.voip.contacts.c.f.b.d;
import com.viber.voip.contacts.c.f.b.e;
import com.viber.voip.contacts.c.f.b.h;
import com.viber.voip.settings.d.q;
import java.util.Arrays;

public class a extends d
{
  private String A;
  private final com.viber.voip.contacts.c.e.b B;
  private final Handler C;
  private final Runnable D;
  private final Runnable E;
  private final Runnable F;
  private final Logger n;
  private boolean o;
  private boolean p;
  private boolean q;
  private boolean r;
  private boolean s;
  private int t;
  private boolean u;
  private boolean v;
  private boolean w;
  private int x;
  private int y;
  private int z;

  // ERROR //
  public a(android.content.Context paramContext, com.viber.voip.ViberApplication paramViberApplication, c.a parama, com.viber.voip.contacts.c.d.j paramj)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: aload_3
    //   4: aload 4
    //   6: invokespecial 34	com/viber/voip/contacts/c/f/b/d:<init>	(Landroid/content/Context;Lcom/viber/voip/ViberApplication;Lcom/viber/voip/contacts/c/f/b/c$a;Lcom/viber/voip/contacts/c/d/j;)V
    //   9: aload_0
    //   10: aload_0
    //   11: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   14: invokestatic 46	com/viber/voip/ViberEnv:getLogger	(Ljava/lang/Class;)Lcom/viber/dexshared/Logger;
    //   17: putfield 48	com/viber/voip/contacts/c/f/b/a/a:n	Lcom/viber/dexshared/Logger;
    //   20: aload_0
    //   21: iconst_1
    //   22: putfield 50	com/viber/voip/contacts/c/f/b/a/a:s	Z
    //   25: aload_0
    //   26: new 52	com/viber/voip/contacts/c/f/b/a/a$1
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 55	com/viber/voip/contacts/c/f/b/a/a$1:<init>	(Lcom/viber/voip/contacts/c/f/b/a/a;)V
    //   34: putfield 57	com/viber/voip/contacts/c/f/b/a/a:D	Ljava/lang/Runnable;
    //   37: aload_0
    //   38: new 59	com/viber/voip/contacts/c/f/b/a/a$2
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 60	com/viber/voip/contacts/c/f/b/a/a$2:<init>	(Lcom/viber/voip/contacts/c/f/b/a/a;)V
    //   46: putfield 62	com/viber/voip/contacts/c/f/b/a/a:E	Ljava/lang/Runnable;
    //   49: aload_0
    //   50: new 64	com/viber/voip/contacts/c/f/b/a/a$3
    //   53: dup
    //   54: aload_0
    //   55: invokespecial 65	com/viber/voip/contacts/c/f/b/a/a$3:<init>	(Lcom/viber/voip/contacts/c/f/b/a/a;)V
    //   58: putfield 67	com/viber/voip/contacts/c/f/b/a/a:F	Ljava/lang/Runnable;
    //   61: aload_0
    //   62: getfield 70	com/viber/voip/contacts/c/f/b/a/a:e	Z
    //   65: ifeq +12 -> 77
    //   68: aload_0
    //   69: monitorenter
    //   70: aload_0
    //   71: iconst_1
    //   72: putfield 72	com/viber/voip/contacts/c/f/b/a/a:u	Z
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_0
    //   78: aload_1
    //   79: invokestatic 78	com/viber/voip/contacts/c/e/b:a	(Landroid/content/Context;)Lcom/viber/voip/contacts/c/e/b;
    //   82: putfield 80	com/viber/voip/contacts/c/f/b/a/a:B	Lcom/viber/voip/contacts/c/e/b;
    //   85: aload_0
    //   86: getstatic 86	com/viber/voip/av$e:g	Lcom/viber/voip/av$e;
    //   89: invokestatic 91	com/viber/voip/av:a	(Lcom/viber/voip/av$e;)Landroid/os/Handler;
    //   92: putfield 93	com/viber/voip/contacts/c/f/b/a/a:C	Landroid/os/Handler;
    //   95: aload_0
    //   96: monitorenter
    //   97: aload_0
    //   98: aload_0
    //   99: getfield 97	com/viber/voip/contacts/c/f/b/a/a:k	Lcom/viber/voip/contacts/c/f/a;
    //   102: invokevirtual 103	com/viber/voip/contacts/c/f/a:c	()I
    //   105: putfield 105	com/viber/voip/contacts/c/f/b/a/a:y	I
    //   108: aload_0
    //   109: monitorexit
    //   110: return
    //   111: astore 6
    //   113: aload_0
    //   114: monitorexit
    //   115: aload 6
    //   117: athrow
    //   118: astore 5
    //   120: aload_0
    //   121: monitorexit
    //   122: aload 5
    //   124: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   70	77	111	finally
    //   113	115	111	finally
    //   97	110	118	finally
    //   120	122	118	finally
  }

  private void a(int paramInt1, int paramInt2)
  {
    try
    {
      this.s = true;
      if (this.t == paramInt1)
        this.t = 0;
      this.i.d(this.A);
      this.k.b(paramInt1);
      a(paramInt2);
      return;
    }
    finally
    {
    }
  }

  private void a(long paramLong, boolean paramBoolean)
  {
    this.B.postDelayed(new Runnable()
    {
      public void run()
      {
        a.y(a.this);
      }
    }
    , paramLong);
  }

  private void a(final b paramb)
  {
    this.d.post(new Runnable()
    {
      public void run()
      {
        if ((a.f(a.this) == null) || (!a.g(a.this)))
          a.h(a.this);
        do
        {
          return;
          if (paramb == a.b.a)
          {
            a.i(a.this);
            return;
          }
          if (paramb == a.b.b)
          {
            a.j(a.this);
            return;
          }
          if (paramb == a.b.c)
          {
            if (a.k(a.this))
              a.l(a.this).a(2);
            a.m(a.this);
            return;
          }
          if (paramb == a.b.d)
          {
            a.a(a.this, 1000L, true);
            a.n(a.this).q();
            return;
          }
          if (paramb == a.b.g)
          {
            a.p(a.this).b(a.o(a.this));
            a.a(a.this, 10000L, true);
            return;
          }
          if (paramb == a.b.e)
          {
            if (a.q(a.this))
              a.r(a.this).a(3);
            a.t(a.this).a(a.s(a.this));
            a.a(a.this, 10000L, false);
            return;
          }
        }
        while (paramb != a.b.f);
        synchronized (a.this)
        {
          a.d(a.this, true);
          if (a.u(a.this))
            a.w(a.this).postDelayed(a.v(a.this), 15000L);
          a.x(a.this).a(a.s(a.this));
          a.a(a.this, 10000L, false);
          return;
        }
      }
    });
  }

  private boolean a(a parama, boolean paramBoolean)
  {
    CContactInfo[] arrayOfCContactInfo1 = parama.a();
    CContactInfo[] arrayOfCContactInfo2 = parama.b();
    String[] arrayOfString = parama.c();
    h.a(this.n, arrayOfCContactInfo1, arrayOfCContactInfo2, arrayOfString);
    if ((paramBoolean) || (this.e))
      if (this.e)
        this.C.postDelayed(this.D, 30000L);
    int i;
    for (this.s = this.c.getPhoneController().handleShareFullAddressBook(arrayOfCContactInfo1, this.y); ; this.s = this.c.getPhoneController().handleShareDeltaAddressBook(arrayOfCContactInfo1, arrayOfCContactInfo2, arrayOfString, i, this.y))
    {
      return this.s;
      i = d();
    }
  }

  private void k()
  {
    try
    {
      this.q = false;
      this.o = false;
      this.p = false;
      this.x = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private boolean l()
  {
    boolean bool = true;
    try
    {
      if (this.o)
      {
        this.p = true;
        bool = false;
      }
      while (true)
      {
        return bool;
        this.o = true;
        a(b.b);
      }
    }
    finally
    {
    }
  }

  private void m()
  {
    while (true)
    {
      try
      {
        boolean bool = e.a(this.a);
        if (bool)
        {
          this.x = (1 + this.x);
          bool = true;
        }
        if (!this.f)
        {
          a(b.f);
          return;
        }
        if ((bool) && (this.x > 1) && (this.x < 10))
        {
          a(b.e);
          a(b.a);
          continue;
        }
      }
      finally
      {
      }
      a(b.c);
    }
  }

  private void n()
  {
    try
    {
      if (this.p)
      {
        this.p = false;
        a(b.b);
      }
      while (true)
      {
        return;
        this.x = 0;
        this.o = false;
      }
    }
    finally
    {
    }
  }

  // ERROR //
  private void o()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_0
    //   4: putfield 195	com/viber/voip/contacts/c/f/b/a/a:p	Z
    //   7: aload_0
    //   8: getfield 199	com/viber/voip/contacts/c/f/b/a/a:f	Z
    //   11: ifne +13 -> 24
    //   14: aload_0
    //   15: getstatic 241	com/viber/voip/contacts/c/f/b/a/a$b:f	Lcom/viber/voip/contacts/c/f/b/a/a$b;
    //   18: invokespecial 231	com/viber/voip/contacts/c/f/b/a/a:a	(Lcom/viber/voip/contacts/c/f/b/a/a$b;)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 72	com/viber/voip/contacts/c/f/b/a/a:u	Z
    //   28: istore_2
    //   29: aload_0
    //   30: iconst_0
    //   31: putfield 72	com/viber/voip/contacts/c/f/b/a/a:u	Z
    //   34: aload_0
    //   35: getfield 108	com/viber/voip/contacts/c/f/b/a/a:t	I
    //   38: ifeq +15 -> 53
    //   41: iload_2
    //   42: ifeq +11 -> 53
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_0
    //   56: getfield 112	com/viber/voip/contacts/c/f/b/a/a:i	Lcom/viber/voip/contacts/c/f/b/f;
    //   59: iload_2
    //   60: invokevirtual 259	com/viber/voip/contacts/c/f/b/f:b	(Z)Lcom/viber/voip/contacts/c/f/b/a/a$a;
    //   63: astore_3
    //   64: aload_0
    //   65: aload_3
    //   66: invokevirtual 262	com/viber/voip/contacts/c/f/b/a/a$a:d	()Ljava/lang/String;
    //   69: putfield 114	com/viber/voip/contacts/c/f/b/a/a:A	Ljava/lang/String;
    //   72: aload_3
    //   73: invokevirtual 157	com/viber/voip/contacts/c/f/b/a/a$a:a	()[Lcom/viber/jni/CContactInfo;
    //   76: arraylength
    //   77: istore 4
    //   79: aload_3
    //   80: invokevirtual 159	com/viber/voip/contacts/c/f/b/a/a$a:b	()[Lcom/viber/jni/CContactInfo;
    //   83: arraylength
    //   84: istore 5
    //   86: aload_3
    //   87: invokevirtual 162	com/viber/voip/contacts/c/f/b/a/a$a:c	()[Ljava/lang/String;
    //   90: arraylength
    //   91: istore 6
    //   93: iload_2
    //   94: ifne +14 -> 108
    //   97: iload 6
    //   99: iload 4
    //   101: iload 5
    //   103: iadd
    //   104: iadd
    //   105: ifle +126 -> 231
    //   108: aload_0
    //   109: monitorenter
    //   110: aload_0
    //   111: aload_0
    //   112: getfield 173	com/viber/voip/contacts/c/f/b/a/a:c	Lcom/viber/jni/Engine;
    //   115: invokevirtual 179	com/viber/jni/Engine:getPhoneController	()Lcom/viber/jni/controller/PhoneController;
    //   118: invokeinterface 265 1 0
    //   123: putfield 105	com/viber/voip/contacts/c/f/b/a/a:y	I
    //   126: iload_2
    //   127: ifeq +11 -> 138
    //   130: aload_0
    //   131: aload_0
    //   132: getfield 105	com/viber/voip/contacts/c/f/b/a/a:y	I
    //   135: putfield 108	com/viber/voip/contacts/c/f/b/a/a:t	I
    //   138: aload_0
    //   139: getfield 97	com/viber/voip/contacts/c/f/b/a/a:k	Lcom/viber/voip/contacts/c/f/a;
    //   142: aload_0
    //   143: getfield 105	com/viber/voip/contacts/c/f/b/a/a:y	I
    //   146: invokevirtual 267	com/viber/voip/contacts/c/f/a:d	(I)V
    //   149: aload_0
    //   150: getfield 97	com/viber/voip/contacts/c/f/b/a/a:k	Lcom/viber/voip/contacts/c/f/a;
    //   153: aload_0
    //   154: getfield 105	com/viber/voip/contacts/c/f/b/a/a:y	I
    //   157: invokevirtual 269	com/viber/voip/contacts/c/f/a:c	(I)V
    //   160: aload_0
    //   161: monitorexit
    //   162: aload_0
    //   163: getfield 224	com/viber/voip/contacts/c/f/b/a/a:x	I
    //   166: iconst_1
    //   167: if_icmple +8 -> 175
    //   170: aload_0
    //   171: iconst_0
    //   172: putfield 224	com/viber/voip/contacts/c/f/b/a/a:x	I
    //   175: aload_0
    //   176: aload_3
    //   177: iload_2
    //   178: invokespecial 271	com/viber/voip/contacts/c/f/b/a/a:a	(Lcom/viber/voip/contacts/c/f/b/a/a$a;Z)Z
    //   181: ifne +31 -> 212
    //   184: aload_0
    //   185: monitorenter
    //   186: aload_0
    //   187: iload_2
    //   188: putfield 72	com/viber/voip/contacts/c/f/b/a/a:u	Z
    //   191: aload_0
    //   192: getfield 72	com/viber/voip/contacts/c/f/b/a/a:u	Z
    //   195: ifeq +8 -> 203
    //   198: aload_0
    //   199: iconst_0
    //   200: putfield 108	com/viber/voip/contacts/c/f/b/a/a:t	I
    //   203: aload_0
    //   204: ldc_w 273
    //   207: putfield 114	com/viber/voip/contacts/c/f/b/a/a:A	Ljava/lang/String;
    //   210: aload_0
    //   211: monitorexit
    //   212: aload_3
    //   213: invokevirtual 275	com/viber/voip/contacts/c/f/b/a/a$a:e	()V
    //   216: return
    //   217: astore 7
    //   219: aload_0
    //   220: monitorexit
    //   221: aload 7
    //   223: athrow
    //   224: astore 8
    //   226: aload_0
    //   227: monitorexit
    //   228: aload 8
    //   230: athrow
    //   231: aload_0
    //   232: getstatic 277	com/viber/voip/contacts/c/f/b/a/a$b:d	Lcom/viber/voip/contacts/c/f/b/a/a$b;
    //   235: invokespecial 231	com/viber/voip/contacts/c/f/b/a/a:a	(Lcom/viber/voip/contacts/c/f/b/a/a$b;)V
    //   238: aload_0
    //   239: monitorenter
    //   240: aload_0
    //   241: getfield 114	com/viber/voip/contacts/c/f/b/a/a:A	Ljava/lang/String;
    //   244: invokestatic 283	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   247: ifne +15 -> 262
    //   250: aload_0
    //   251: getfield 112	com/viber/voip/contacts/c/f/b/a/a:i	Lcom/viber/voip/contacts/c/f/b/f;
    //   254: aload_0
    //   255: getfield 114	com/viber/voip/contacts/c/f/b/a/a:A	Ljava/lang/String;
    //   258: invokevirtual 120	com/viber/voip/contacts/c/f/b/f:d	(Ljava/lang/String;)I
    //   261: pop
    //   262: aload_0
    //   263: ldc_w 273
    //   266: putfield 114	com/viber/voip/contacts/c/f/b/a/a:A	Ljava/lang/String;
    //   269: aload_0
    //   270: monitorexit
    //   271: return
    //   272: astore 9
    //   274: aload_0
    //   275: monitorexit
    //   276: aload 9
    //   278: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   2	23	48	finally
    //   24	41	48	finally
    //   45	47	48	finally
    //   49	51	48	finally
    //   53	55	48	finally
    //   110	126	217	finally
    //   130	138	217	finally
    //   138	162	217	finally
    //   219	221	217	finally
    //   186	203	224	finally
    //   203	212	224	finally
    //   226	228	224	finally
    //   240	262	272	finally
    //   262	271	272	finally
    //   274	276	272	finally
  }

  private void p()
  {
    if (d.q.e.d())
      i();
  }

  public void a(com.viber.voip.model.a parama)
  {
    com.viber.voip.model.f localf = parama.w();
    if (localf == null)
      return;
    this.B.post(new b(this, localf, parama));
  }

  public void a(boolean paramBoolean)
  {
    int i = 1;
    try
    {
      if ((!this.r) && (paramBoolean));
      while (true)
      {
        this.r = paramBoolean;
        if ((i != 0) && (this.k.d() != 0))
        {
          this.q = true;
          this.B.postDelayed(new Runnable()
          {
            public void run()
            {
              synchronized (a.this)
              {
                a.d(a.this, false);
                a.this.j();
                return;
              }
            }
          }
          , 15000L);
        }
        return;
        i = 0;
      }
    }
    finally
    {
    }
  }

  public int b()
  {
    try
    {
      if (this.v)
        this.w = true;
      while (true)
      {
        int i = this.y;
        return i;
        this.w = false;
        this.v = true;
        this.B.postDelayed(this.F, 300000L);
        if (!this.q)
        {
          if ((this.o) && (this.e))
            this.k.a(2);
          j();
        }
      }
    }
    finally
    {
    }
  }

  public void c()
  {
    try
    {
      this.y = this.c.getPhoneController().generateSequence();
      this.c.getPhoneController().handleShareFullAddressBook(new CContactInfo[0], this.y);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  protected void h()
  {
    while (true)
    {
      try
      {
        if (this.f)
        {
          this.B.removeCallbacks(this.E);
          if (this.q)
          {
            this.q = false;
            if (this.o)
              a(b.b);
          }
          else
          {
            return;
          }
          a(b.a);
          continue;
        }
      }
      finally
      {
      }
      if (this.o)
        this.h.a(this.y);
    }
  }

  public void j()
  {
    a(b.a);
  }

  public void onCRegisteredContactsMsg(CRegisteredContactsMsg paramCRegisteredContactsMsg)
  {
    super.onCRegisteredContactsMsg(paramCRegisteredContactsMsg);
    int i;
    if (paramCRegisteredContactsMsg.seq == 0)
      i = 1;
    while (true)
      try
      {
        this.z = paramCRegisteredContactsMsg.seq;
        if ((paramCRegisteredContactsMsg.lastMsg) && (i == 0))
        {
          a(b.g);
          this.C.removeCallbacks(this.D);
        }
        return;
        i = 0;
      }
      finally
      {
      }
  }

  public void onShareAddressBook()
  {
    p();
    try
    {
      this.u = true;
      if (!this.h.n())
        j();
      return;
    }
    finally
    {
    }
  }

  // ERROR //
  public void onShareAddressBookReply(int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: iload_2
    //   3: iload_3
    //   4: invokespecial 377	com/viber/voip/contacts/c/f/b/d:onShareAddressBookReply	(III)V
    //   7: iload_1
    //   8: tableswitch	default:+40 -> 48, 0:+69->77, 1:+76->84, 2:+76->84, 3:+85->93, 4:+85->93, 5:+41->49
    //   49: aload_0
    //   50: monitorenter
    //   51: aload_0
    //   52: iload_3
    //   53: aload_0
    //   54: invokevirtual 187	com/viber/voip/contacts/c/f/b/a/a:d	()I
    //   57: invokespecial 379	com/viber/voip/contacts/c/f/b/a/a:a	(II)V
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_0
    //   63: getstatic 367	com/viber/voip/contacts/c/f/b/a/a$b:g	Lcom/viber/voip/contacts/c/f/b/a/a$b;
    //   66: invokespecial 231	com/viber/voip/contacts/c/f/b/a/a:a	(Lcom/viber/voip/contacts/c/f/b/a/a$b;)V
    //   69: return
    //   70: astore 6
    //   72: aload_0
    //   73: monitorexit
    //   74: aload 6
    //   76: athrow
    //   77: aload_0
    //   78: iload_3
    //   79: iload_2
    //   80: invokespecial 379	com/viber/voip/contacts/c/f/b/a/a:a	(II)V
    //   83: return
    //   84: aload_0
    //   85: monitorenter
    //   86: aload_0
    //   87: iconst_1
    //   88: putfield 72	com/viber/voip/contacts/c/f/b/a/a:u	Z
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_0
    //   94: monitorenter
    //   95: aload_0
    //   96: iconst_0
    //   97: putfield 50	com/viber/voip/contacts/c/f/b/a/a:s	Z
    //   100: aload_0
    //   101: getfield 108	com/viber/voip/contacts/c/f/b/a/a:t	I
    //   104: iload_3
    //   105: if_icmpne +13 -> 118
    //   108: aload_0
    //   109: iconst_0
    //   110: putfield 108	com/viber/voip/contacts/c/f/b/a/a:t	I
    //   113: aload_0
    //   114: iconst_1
    //   115: putfield 72	com/viber/voip/contacts/c/f/b/a/a:u	Z
    //   118: aload_0
    //   119: monitorexit
    //   120: aload_0
    //   121: getstatic 243	com/viber/voip/contacts/c/f/b/a/a$b:e	Lcom/viber/voip/contacts/c/f/b/a/a$b;
    //   124: invokespecial 231	com/viber/voip/contacts/c/f/b/a/a:a	(Lcom/viber/voip/contacts/c/f/b/a/a$b;)V
    //   127: aload_0
    //   128: getstatic 245	com/viber/voip/contacts/c/f/b/a/a$b:a	Lcom/viber/voip/contacts/c/f/b/a/a$b;
    //   131: invokespecial 231	com/viber/voip/contacts/c/f/b/a/a:a	(Lcom/viber/voip/contacts/c/f/b/a/a$b;)V
    //   134: return
    //   135: astore 5
    //   137: aload_0
    //   138: monitorexit
    //   139: aload 5
    //   141: athrow
    //   142: astore 4
    //   144: aload_0
    //   145: monitorexit
    //   146: aload 4
    //   148: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   51	62	70	finally
    //   72	74	70	finally
    //   86	93	135	finally
    //   137	139	135	finally
    //   95	118	142	finally
    //   118	120	142	finally
    //   144	146	142	finally
  }

  public static final class a
  {
    private CContactInfo[] a;
    private CContactInfo[] b;
    private String[] c;
    private String d;

    public a(CContactInfo[] paramArrayOfCContactInfo1, CContactInfo[] paramArrayOfCContactInfo2, CContactInfo[] paramArrayOfCContactInfo3, String paramString)
    {
      this.a = paramArrayOfCContactInfo1;
      this.b = paramArrayOfCContactInfo2;
      this.c = new String[paramArrayOfCContactInfo3.length];
      int i = 0;
      int j = paramArrayOfCContactInfo3.length;
      while (i < j)
      {
        this.c[i] = paramArrayOfCContactInfo3[i].getClientPhone();
        i++;
      }
      this.d = paramString;
    }

    public CContactInfo[] a()
    {
      return this.a;
    }

    public CContactInfo[] b()
    {
      return this.b;
    }

    public String[] c()
    {
      return this.c;
    }

    public String d()
    {
      return this.d;
    }

    public void e()
    {
      if (this.a != null)
        Arrays.fill(this.a, null);
      if (this.b != null)
        Arrays.fill(this.b, null);
      if (this.c != null)
        Arrays.fill(this.c, null);
      this.d = null;
    }
  }

  private static enum b
  {
    static
    {
      b[] arrayOfb = new b[7];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
      arrayOfb[3] = d;
      arrayOfb[4] = e;
      arrayOfb[5] = f;
      arrayOfb[6] = g;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.f.b.a.a
 * JD-Core Version:    0.6.2
 */