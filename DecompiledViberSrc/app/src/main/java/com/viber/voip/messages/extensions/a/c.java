package com.viber.voip.messages.extensions.a;

import android.util.Pair;
import android.util.SparseArray;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.slashkey.ServiceSettings;
import com.viber.jni.slashkey.SlashItem;
import com.viber.jni.slashkey.SlashKeyAdapter;
import com.viber.jni.slashkey.SlashKeyAdapterDelegate;
import com.viber.jni.slashkey.SlashKeyAdapterErrorCode;
import com.viber.jni.slashkey.SlashKeyController;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.extensions.model.b;
import com.viber.voip.messages.extensions.model.d;
import com.viber.voip.stickers.i;
import com.viber.voip.util.ar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class c
  implements SlashKeyAdapterDelegate, a
{
  private static final Logger a = ViberEnv.getLogger();
  private final Engine b;
  private final SlashKeyController c;
  private Map<Pair<String, String>, d[]> d;
  private Map<String, SlashKeyAdapter> e;
  private final o f;
  private final SparseArray<Pair<String, String>> g;

  public c(Engine paramEngine)
  {
    this.b = paramEngine;
    this.c = new SlashKeyController();
    this.g = new SparseArray();
    this.e = new HashMap(2);
    this.d = new ar(TimeUnit.MINUTES.toMillis(10L));
    this.f = o.a();
  }

  private SlashKeyAdapter a(String paramString)
  {
    SlashKeyAdapter localSlashKeyAdapter = (SlashKeyAdapter)this.e.get(paramString);
    if (localSlashKeyAdapter == null)
    {
      localSlashKeyAdapter = this.c.createAdapterFor(paramString, this);
      this.e.put(paramString, localSlashKeyAdapter);
    }
    return localSlashKeyAdapter;
  }

  private void a(int paramInt, SlashItem[] paramArrayOfSlashItem, @SlashKeyAdapterErrorCode String paramString)
  {
    Pair localPair = (Pair)this.g.get(paramInt);
    this.g.remove(paramInt);
    if (localPair != null)
    {
      String str1 = (String)localPair.first;
      String str2 = (String)localPair.second;
      d[] arrayOfd = d.a(paramArrayOfSlashItem);
      if ("OK".equals(paramString))
        a(localPair, arrayOfd, str1);
      this.f.a(str1, str2, arrayOfd, paramString);
    }
  }

  private void a(Pair<String, String> paramPair, d[] paramArrayOfd, String paramString)
  {
    if (this.d.size() > 5)
      this.d.clear();
    this.d.put(paramPair, paramArrayOfd);
    if ("stickers".equalsIgnoreCase(paramString))
    {
      int[] arrayOfInt = new int[paramArrayOfd.length];
      for (int i = 0; i < paramArrayOfd.length; i++)
        arrayOfInt[i] = paramArrayOfd[i].k();
      i.a().a(arrayOfInt);
    }
  }

  public void a(String paramString, b paramb)
  {
    Pair localPair = Pair.create(paramString, paramb.b());
    d[] arrayOfd = (d[])this.d.get(localPair);
    if (arrayOfd != null)
    {
      this.f.a(paramString, paramb.b(), arrayOfd, null);
      return;
    }
    int i = this.b.getPhoneController().generateSequence();
    this.g.put(i, localPair);
    a(paramString).requestSlashItems(i, paramb.c());
  }

  @Deprecated
  public com.viber.voip.messages.extensions.model.a[] a()
  {
    HashSet localHashSet = new HashSet(2);
    localHashSet.add("stickers");
    localHashSet.add("giphy");
    return com.viber.voip.messages.extensions.model.a.a(this.c.getServices(), localHashSet);
  }

  public void onInitialServiceSettingsError(int paramInt)
  {
  }

  public void onInitialServiceSettingsReceived(int paramInt, ServiceSettings paramServiceSettings)
  {
  }

  public void onLoginServiceSettingsError(int paramInt)
  {
  }

  public void onLoginServiceSettingsReceived(int paramInt, ServiceSettings paramServiceSettings)
  {
  }

  public void onSlashItemsError(int paramInt, @SlashKeyAdapterErrorCode String paramString)
  {
    a(paramInt, null, paramString);
  }

  public void onSlashItemsReceived(int paramInt, SlashItem[] paramArrayOfSlashItem)
  {
    a(paramInt, paramArrayOfSlashItem, "OK");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.a.c
 * JD-Core Version:    0.6.2
 */