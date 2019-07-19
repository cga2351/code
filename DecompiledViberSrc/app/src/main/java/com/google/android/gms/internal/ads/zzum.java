package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
public final class zzum
{
  private final Object lock = new Object();
  private int score;
  private final int zzbua;
  private final int zzbub;
  private final int zzbuc;
  private final boolean zzbud;
  private final zzuz zzbue;
  private final zzvi zzbuf;
  private ArrayList<String> zzbug = new ArrayList();
  private ArrayList<String> zzbuh = new ArrayList();
  private ArrayList<zzux> zzbui = new ArrayList();
  private int zzbuj = 0;
  private int zzbuk = 0;
  private int zzbul = 0;
  private String zzbum = "";
  private String zzbun = "";
  private String zzbuo = "";

  public zzum(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean)
  {
    this.zzbua = paramInt1;
    this.zzbub = paramInt2;
    this.zzbuc = paramInt3;
    this.zzbud = paramBoolean;
    this.zzbue = new zzuz(paramInt4);
    this.zzbuf = new zzvi(paramInt5, paramInt6, paramInt7);
  }

  private static String zza(ArrayList<String> paramArrayList, int paramInt)
  {
    String str;
    if (paramArrayList.isEmpty())
      str = "";
    do
    {
      return str;
      StringBuilder localStringBuilder = new StringBuilder();
      ArrayList localArrayList = (ArrayList)paramArrayList;
      int i = localArrayList.size();
      int j = 0;
      do
      {
        if (j >= i)
          break;
        Object localObject = localArrayList.get(j);
        j++;
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(' ');
      }
      while (localStringBuilder.length() <= 100);
      localStringBuilder.deleteCharAt(-1 + localStringBuilder.length());
      str = localStringBuilder.toString();
    }
    while (str.length() < 100);
    return str.substring(0, 100);
  }

  private final void zzc(String paramString, boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((paramString == null) || (paramString.length() < this.zzbuc))
      return;
    synchronized (this.lock)
    {
      this.zzbug.add(paramString);
      this.zzbuj += paramString.length();
      if (paramBoolean)
      {
        this.zzbuh.add(paramString);
        this.zzbui.add(new zzux(paramFloat1, paramFloat2, paramFloat3, paramFloat4, -1 + this.zzbuh.size()));
      }
      return;
    }
  }

  @VisibleForTesting
  private final int zzh(int paramInt1, int paramInt2)
  {
    if (this.zzbud)
      return this.zzbub;
    return paramInt1 * this.zzbua + paramInt2 * this.zzbub;
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzum));
    zzum localzzum;
    do
    {
      return false;
      if (paramObject == this)
        return true;
      localzzum = (zzum)paramObject;
    }
    while ((localzzum.zzbum == null) || (!localzzum.zzbum.equals(this.zzbum)));
    return true;
  }

  public final int getScore()
  {
    return this.score;
  }

  public final int hashCode()
  {
    return this.zzbum.hashCode();
  }

  public final String toString()
  {
    int i = this.zzbuk;
    int j = this.score;
    int k = this.zzbuj;
    String str1 = zza(this.zzbug, 100);
    String str2 = zza(this.zzbuh, 100);
    String str3 = this.zzbum;
    String str4 = this.zzbun;
    String str5 = this.zzbuo;
    return 165 + String.valueOf(str1).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + "ActivityContent fetchId: " + i + " score:" + j + " total_length:" + k + "\n text: " + str1 + "\n viewableText" + str2 + "\n signture: " + str3 + "\n viewableSignture: " + str4 + "\n viewableSignatureForVertical: " + str5;
  }

  public final void zza(String paramString, boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    zzc(paramString, paramBoolean, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    synchronized (this.lock)
    {
      if (this.zzbul < 0)
        zzaxa.zzdp("ActivityContent: negative number of WebViews.");
      zzmt();
      return;
    }
  }

  public final void zzb(String paramString, boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    zzc(paramString, paramBoolean, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }

  public final void zzbw(int paramInt)
  {
    this.zzbuk = paramInt;
  }

  public final boolean zzml()
  {
    while (true)
    {
      synchronized (this.lock)
      {
        if (this.zzbul == 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  public final String zzmm()
  {
    return this.zzbum;
  }

  public final String zzmn()
  {
    return this.zzbun;
  }

  public final String zzmo()
  {
    return this.zzbuo;
  }

  public final void zzmp()
  {
    synchronized (this.lock)
    {
      this.score = (-100 + this.score);
      return;
    }
  }

  public final void zzmq()
  {
    synchronized (this.lock)
    {
      this.zzbul = (-1 + this.zzbul);
      return;
    }
  }

  public final void zzmr()
  {
    synchronized (this.lock)
    {
      this.zzbul = (1 + this.zzbul);
      return;
    }
  }

  public final void zzms()
  {
    synchronized (this.lock)
    {
      int i = zzh(this.zzbuj, this.zzbuk);
      if (i > this.score)
        this.score = i;
      return;
    }
  }

  public final void zzmt()
  {
    synchronized (this.lock)
    {
      int i = zzh(this.zzbuj, this.zzbuk);
      if (i > this.score)
      {
        this.score = i;
        if (!zzk.zzlk().zzvc().zzvl())
        {
          this.zzbum = this.zzbue.zza(this.zzbug);
          this.zzbun = this.zzbue.zza(this.zzbuh);
        }
        if (!zzk.zzlk().zzvc().zzvn())
          this.zzbuo = this.zzbuf.zza(this.zzbuh, this.zzbui);
      }
      return;
    }
  }

  @VisibleForTesting
  final int zzmu()
  {
    return this.zzbuj;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzum
 * JD-Core Version:    0.6.2
 */