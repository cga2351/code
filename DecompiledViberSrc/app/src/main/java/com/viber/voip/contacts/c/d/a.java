package com.viber.voip.contacts.c.d;

import android.os.Handler;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.ArraySet;
import com.viber.common.a.e;
import com.viber.jni.connection.ConnectionDelegate;
import com.viber.jni.connection.ConnectionListener;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.CGetEncryptedMIDsMsg;
import com.viber.jni.im2.CGetEncryptedMIDsReplyMsg;
import com.viber.jni.im2.CGetEncryptedMIDsReplyMsg.Receiver;
import com.viber.jni.im2.EncryptedMIDMap;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.d;
import com.viber.voip.messages.m;
import com.viber.voip.settings.d.al;
import com.viber.voip.util.da;
import com.viber.voip.util.u;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class a<T extends o>
{
  protected final e a = ViberEnv.getLogger(getClass());
  protected final com.viber.common.b.d b;
  protected final PhoneController c;
  protected final Handler d;
  d.al e;
  ConnectionDelegate f = new ConnectionDelegate()
  {
    public void onConnect()
    {
      a.this.c();
    }

    public void onConnectionStateChange(int paramAnonymousInt)
    {
    }
  };
  bv.d g = new bv.d()
  {
    public void onChange(Set<Long> paramAnonymousSet, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
      if (!m.b(paramAnonymousInt))
        return;
      a.this.d.post(new c(this));
    }
  };
  private final Im2Exchanger h;
  private bv i;
  private ConnectionListener j;

  public a(Im2Exchanger paramIm2Exchanger, com.viber.common.b.d paramd, PhoneController paramPhoneController, Handler paramHandler)
  {
    this.h = paramIm2Exchanger;
    this.b = paramd;
    this.c = paramPhoneController;
    this.d = paramHandler;
  }

  private void a(final Map<String, T> paramMap, final String[] paramArrayOfString, final int paramInt, final boolean paramBoolean)
  {
    final int k = this.c.generateSequence();
    int m;
    final int n;
    if (paramBoolean)
    {
      m = 150;
      n = Math.min(-1 + paramArrayOfString.length, -1 + (m + paramInt));
      if (n != -1 + paramArrayOfString.length)
        break label121;
    }
    label121: for (final boolean bool = true; ; bool = false)
    {
      final String[] arrayOfString = (String[])Arrays.copyOfRange(paramArrayOfString, paramInt, n + 1);
      this.h.registerDelegate(new CGetEncryptedMIDsReplyMsg.Receiver()
      {
        public void onCGetEncryptedMIDsReplyMsg(CGetEncryptedMIDsReplyMsg paramAnonymousCGetEncryptedMIDsReplyMsg)
        {
          if (paramAnonymousCGetEncryptedMIDsReplyMsg.seq != k)
            return;
          a.a(a.this).removeDelegate(this);
          if (paramAnonymousCGetEncryptedMIDsReplyMsg.status == 0)
          {
            ArraySet localArraySet = new ArraySet(arrayOfString.length);
            for (EncryptedMIDMap localEncryptedMIDMap : paramAnonymousCGetEncryptedMIDsReplyMsg.encryptedMids)
            {
              o localo = (o)paramMap.get(localEncryptedMIDMap.mid);
              if (localo != null)
              {
                localo.a(localEncryptedMIDMap.encryptedMID);
                localArraySet.add(localo);
              }
            }
            if (!u.a(localArraySet))
              a.this.a(localArraySet);
            if (bool)
            {
              a.this.e();
              return;
            }
            a.a(a.this, paramMap, paramArrayOfString, 1 + n, paramBoolean);
            return;
          }
          if (3 == paramAnonymousCGetEncryptedMIDsReplyMsg.status)
          {
            if (paramBoolean)
            {
              a.this.f();
              return;
            }
            a.a(a.this, paramMap, paramArrayOfString, paramInt, true);
            return;
          }
          a.this.b.a(0);
        }
      }
      , this.d);
      this.h.handleCGetEncryptedMIDsMsg(new CGetEncryptedMIDsMsg(k, arrayOfString));
      return;
      m = 300;
      break;
    }
  }

  private void g()
  {
    if (this.e == null)
    {
      Handler localHandler = this.d;
      com.viber.common.b.a[] arrayOfa = new com.viber.common.b.a[1];
      arrayOfa[0] = this.b;
      this.e = new d.al(localHandler, arrayOfa)
      {
        public void onPreferencesChanged(com.viber.common.b.a paramAnonymousa)
        {
          switch (a.this.b.d())
          {
          default:
            return;
          case 0:
            if (a.this.c.isConnected())
              a.this.c();
            break;
          case 1:
          }
          com.viber.voip.settings.d.b(a.this.e);
          a.this.a();
        }
      };
    }
    com.viber.voip.settings.d.a(this.e);
  }

  private void h()
  {
    if (this.i != null)
      this.i.b(this.g);
    if (this.j != null)
      this.j.removeDelegate(this.f);
  }

  private void i()
  {
    Collection localCollection = d();
    ArrayMap localArrayMap = new ArrayMap(localCollection.size());
    String[] arrayOfString = new String[localCollection.size()];
    Iterator localIterator = localCollection.iterator();
    int k = 0;
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      if (!a(localo))
      {
        localArrayMap.put(localo.a(), localo);
        int m = k + 1;
        arrayOfString[k] = localo.a();
        k = m;
      }
    }
    if (localArrayMap.size() > 0)
    {
      a(localArrayMap, arrayOfString, 0, false);
      return;
    }
    e();
  }

  protected void a()
  {
    if (this.i != null)
      this.i.a(this.g);
    if (this.j != null)
      this.j.registerDelegate(this.f, this.d);
  }

  public void a(bv parambv, ConnectionListener paramConnectionListener)
  {
    this.d.post(new b(this, parambv, paramConnectionListener));
  }

  protected abstract void a(Set<T> paramSet);

  protected boolean a(T paramT)
  {
    return (da.a(paramT.a())) || (!da.a(paramT.b()));
  }

  protected boolean b()
  {
    return true;
  }

  protected final void c()
  {
    if (this.b.d() == 0)
    {
      this.b.a(2);
      i();
    }
  }

  protected abstract Collection<T> d();

  protected void e()
  {
    this.b.a(3);
    h();
    if (this.e != null)
      com.viber.voip.settings.d.b(this.e);
  }

  protected void f()
  {
    this.a.a(new RuntimeException("mid to emid mapping error - input too long"), "mid to emid mapping error - input too long");
    this.b.a(4);
    h();
    if (this.e != null)
      com.viber.voip.settings.d.b(this.e);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.d.a
 * JD-Core Version:    0.6.2
 */