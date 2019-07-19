package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Map;
import java.util.Set;

@zzare
public final class zzaps extends zzaqc
{
  private static final Set<String> zzdhz = CollectionUtils.setOf(new String[] { "top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center" });
  private int height = -1;
  private final Object lock = new Object();
  private int width = -1;
  private zzaqd zzdal;
  private final zzbha zzdbu;
  private final Activity zzdhp;
  private String zzdia = "top-right";
  private boolean zzdib = true;
  private int zzdic = 0;
  private int zzdid = 0;
  private int zzdie = 0;
  private int zzdif = 0;
  private zzbio zzdig;
  private ImageView zzdih;
  private LinearLayout zzdii;
  private PopupWindow zzdij;
  private RelativeLayout zzdik;
  private ViewGroup zzdil;

  public zzaps(zzbha paramzzbha, zzaqd paramzzaqd)
  {
    super(paramzzbha, "resize");
    this.zzdbu = paramzzbha;
    this.zzdhp = paramzzbha.zzyd();
    this.zzdal = paramzzaqd;
  }

  public final void zza(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    synchronized (this.lock)
    {
      this.zzdic = paramInt1;
      this.zzdid = paramInt2;
      return;
    }
  }

  public final void zzg(Map<String, String> paramMap)
  {
    synchronized (this.lock)
    {
      if (this.zzdhp == null)
      {
        zzdh("Not an activity context. Cannot resize.");
        return;
      }
      if (this.zzdbu.zzaag() == null)
      {
        zzdh("Webview is not yet available, size is not set.");
        return;
      }
    }
    if (this.zzdbu.zzaag().zzabx())
    {
      zzdh("Is interstitial. Cannot resize an interstitial.");
      return;
    }
    if (this.zzdbu.zzaan())
    {
      zzdh("Cannot resize an expanded banner.");
      return;
    }
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("width")))
    {
      zzk.zzlg();
      this.width = zzaxj.zzdy((String)paramMap.get("width"));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("height")))
    {
      zzk.zzlg();
      this.height = zzaxj.zzdy((String)paramMap.get("height"));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("offsetX")))
    {
      zzk.zzlg();
      this.zzdie = zzaxj.zzdy((String)paramMap.get("offsetX"));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("offsetY")))
    {
      zzk.zzlg();
      this.zzdif = zzaxj.zzdy((String)paramMap.get("offsetY"));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("allowOffscreen")))
      this.zzdib = Boolean.parseBoolean((String)paramMap.get("allowOffscreen"));
    String str1 = (String)paramMap.get("customClosePosition");
    if (!TextUtils.isEmpty(str1))
      this.zzdia = str1;
    int i;
    Window localWindow;
    int m;
    Object localObject3;
    int i12;
    label975: int i8;
    int i9;
    int i10;
    label1080: int i11;
    label1095: label1137: int n;
    int i1;
    label1325: PopupWindow localPopupWindow1;
    if ((this.width >= 0) && (this.height >= 0))
    {
      i = 1;
      if (i == 0)
      {
        zzdh("Invalid width and height options. Cannot resize.");
        return;
      }
      localWindow = this.zzdhp.getWindow();
      if ((localWindow == null) || (localWindow.getDecorView() == null))
      {
        zzdh("Activity context is not ready, cannot get window or decor view.");
        return;
      }
      int[] arrayOfInt1 = zzk.zzlg().zze(this.zzdhp);
      int[] arrayOfInt2 = zzk.zzlg().zzf(this.zzdhp);
      int j = arrayOfInt1[0];
      int k = arrayOfInt1[1];
      if ((this.width < 50) || (this.width > j))
      {
        zzaxa.zzep("Width is too small or too large.");
        m = 0;
        break label2122;
      }
      while (localObject3 == null)
      {
        zzdh("Resize location out of screen or close button is not visible.");
        return;
        if ((this.height < 50) || (this.height > k))
        {
          zzaxa.zzep("Height is too small or too large.");
          m = 0;
          break label2122;
        }
        if ((this.height == k) && (this.width == j))
        {
          zzaxa.zzep("Cannot resize to a full-screen ad.");
          m = 0;
          break label2122;
        }
        if (!this.zzdib)
          break label2182;
        String str5 = this.zzdia;
        int i13;
        int i14;
        switch (str5.hashCode())
        {
        case -1012429441:
          i13 = -50 + (this.zzdic + this.zzdie + this.width);
          i14 = this.zzdid + this.zzdif;
        case 1755462605:
        case -1364013995:
        case -655373719:
        case 1288627767:
        case 1163912186:
          while (true)
          {
            if ((i13 < 0) || (i13 + 50 > j) || (i14 < arrayOfInt2[0]))
              break label2176;
            if (i14 + 50 <= arrayOfInt2[1])
              break label2182;
            break label2176;
            if (!str5.equals("top-left"))
              break;
            i12 = 0;
            break label2136;
            if (!str5.equals("top-center"))
              break;
            i12 = 1;
            break label2136;
            if (!str5.equals("center"))
              break;
            i12 = 2;
            break label2136;
            if (!str5.equals("bottom-left"))
              break;
            i12 = 3;
            break label2136;
            if (!str5.equals("bottom-center"))
              break;
            i12 = 4;
            break label2136;
            if (!str5.equals("bottom-right"))
              break;
            i12 = 5;
            break label2136;
            i13 = this.zzdic + this.zzdie;
            i14 = this.zzdid + this.zzdif;
            continue;
            i13 = -25 + (this.zzdic + this.zzdie + this.width / 2);
            i14 = this.zzdid + this.zzdif;
            continue;
            i13 = -25 + (this.zzdic + this.zzdie + this.width / 2);
            i14 = -25 + (this.zzdid + this.zzdif + this.height / 2);
            continue;
            i13 = this.zzdic + this.zzdie;
            i14 = -50 + (this.zzdid + this.zzdif + this.height);
            continue;
            i13 = -25 + (this.zzdic + this.zzdie + this.width / 2);
            i14 = -50 + (this.zzdid + this.zzdif + this.height);
            continue;
            i13 = -50 + (this.zzdic + this.zzdie + this.width);
            i14 = -50 + (this.zzdid + this.zzdif + this.height);
          }
          if (this.zzdib)
          {
            int[] arrayOfInt5 = new int[2];
            arrayOfInt5[0] = (this.zzdic + this.zzdie);
            arrayOfInt5[1] = (this.zzdid + this.zzdif);
            localObject3 = arrayOfInt5;
          }
          else
          {
            int[] arrayOfInt3 = zzk.zzlg().zze(this.zzdhp);
            int[] arrayOfInt4 = zzk.zzlg().zzf(this.zzdhp);
            int i7 = arrayOfInt3[0];
            i8 = this.zzdic + this.zzdie;
            i9 = this.zzdid + this.zzdif;
            if (i8 < 0)
            {
              i10 = 0;
              if (i9 >= arrayOfInt4[0])
                break label1137;
            }
            for (i11 = arrayOfInt4[0]; ; i11 = arrayOfInt4[1] - this.height)
            {
              localObject3 = new int[] { i10, i11 };
              break;
              if (i8 + this.width <= i7)
                break label2109;
              i10 = i7 - this.width;
              break label1080;
              if (i9 + this.height <= arrayOfInt4[1])
                break label2102;
            }
          }
          break;
        }
      }
      zzyr.zzpa();
      n = zzazu.zza(this.zzdhp, this.width);
      zzyr.zzpa();
      i1 = zzazu.zza(this.zzdhp, this.height);
      ViewParent localViewParent = this.zzdbu.getView().getParent();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup)))
      {
        ((ViewGroup)localViewParent).removeView(this.zzdbu.getView());
        if (this.zzdij == null)
        {
          this.zzdil = ((ViewGroup)localViewParent);
          zzk.zzlg();
          Bitmap localBitmap = zzaxj.zzk(this.zzdbu.getView());
          this.zzdih = new ImageView(this.zzdhp);
          this.zzdih.setImageBitmap(localBitmap);
          this.zzdig = this.zzdbu.zzaag();
          this.zzdil.addView(this.zzdih);
          this.zzdik = new RelativeLayout(this.zzdhp);
          this.zzdik.setBackgroundColor(0);
          this.zzdik.setLayoutParams(new ViewGroup.LayoutParams(n, i1));
          zzk.zzlg();
          this.zzdij = zzaxj.zza(this.zzdik, n, i1, false);
          this.zzdij.setOutsideTouchable(true);
          this.zzdij.setTouchable(true);
          localPopupWindow1 = this.zzdij;
          if (this.zzdib)
            break label2232;
        }
      }
    }
    label1582: label2102: label2232: for (boolean bool = true; ; bool = false)
    {
      String str3;
      while (true)
      {
        localPopupWindow1.setClippingEnabled(bool);
        this.zzdik.addView(this.zzdbu.getView(), -1, -1);
        this.zzdii = new LinearLayout(this.zzdhp);
        zzyr.zzpa();
        int i2 = zzazu.zza(this.zzdhp, 50);
        zzyr.zzpa();
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i2, zzazu.zza(this.zzdhp, 50));
        String str2 = this.zzdia;
        switch (str2.hashCode())
        {
        case -1012429441:
          localLayoutParams.addRule(10);
          localLayoutParams.addRule(11);
          this.zzdii.setOnClickListener(new zzapt(this));
          this.zzdii.setContentDescription("Close button");
          this.zzdik.addView(this.zzdii, localLayoutParams);
        case 1755462605:
        case -1364013995:
        case -655373719:
        case 1288627767:
        case 1163912186:
          try
          {
            PopupWindow localPopupWindow2 = this.zzdij;
            View localView = localWindow.getDecorView();
            zzyr.zzpa();
            int i4 = zzazu.zza(this.zzdhp, localObject3[0]);
            zzyr.zzpa();
            localPopupWindow2.showAtLocation(localView, 0, i4, zzazu.zza(this.zzdhp, localObject3[1]));
            int i5 = localObject3[0];
            int i6 = localObject3[1];
            if (this.zzdal != null)
              this.zzdal.zzc(i5, i6, this.width, this.height);
            this.zzdbu.zza(zzbio.zzr(n, i1));
            zza(localObject3[0], localObject3[1] - zzk.zzlg().zzf(this.zzdhp)[0], this.width, this.height);
            zzdj("resized");
            return;
            this.zzdij.dismiss();
            break label1325;
            zzdh("Webview is detached, probably in the middle of a resize or expand.");
            return;
            if (!str2.equals("top-left"))
              break label2188;
            i3 = 0;
            break label2191;
            if (!str2.equals("top-center"))
              break label2188;
            i3 = 1;
            break label2191;
            if (!str2.equals("center"))
              break label2188;
            i3 = 2;
            break label2191;
            if (!str2.equals("bottom-left"))
              break label2188;
            i3 = 3;
            break label2191;
            if (!str2.equals("bottom-center"))
              break label2188;
            i3 = 4;
            break label2191;
            if (!str2.equals("bottom-right"))
              break label2188;
            i3 = 5;
            break label2191;
            localLayoutParams.addRule(10);
            localLayoutParams.addRule(9);
            break label1582;
            localLayoutParams.addRule(10);
            localLayoutParams.addRule(14);
            break label1582;
            localLayoutParams.addRule(13);
            break label1582;
            localLayoutParams.addRule(12);
            localLayoutParams.addRule(9);
            break label1582;
            localLayoutParams.addRule(12);
            localLayoutParams.addRule(14);
            break label1582;
            localLayoutParams.addRule(12);
            localLayoutParams.addRule(11);
          }
          catch (RuntimeException localRuntimeException)
          {
            str3 = String.valueOf(localRuntimeException.getMessage());
            if (str3.length() == 0);
          }
        }
      }
      for (String str4 = "Cannot show popup window: ".concat(str3); ; str4 = new String("Cannot show popup window: "))
      {
        zzdh(str4);
        this.zzdik.removeView(this.zzdbu.getView());
        if (this.zzdil != null)
        {
          this.zzdil.removeView(this.zzdih);
          this.zzdil.addView(this.zzdbu.getView());
          this.zzdbu.zza(this.zzdig);
        }
        return;
      }
      i11 = i9;
      break label1095;
      label2109: i10 = i8;
      break label1080;
      i = 0;
      break;
      while (true)
      {
        label2122: if (m != 0)
          break label975;
        localObject3 = null;
        break;
        i12 = -1;
        label2136: switch (i12)
        {
        default:
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        }
        m = 0;
        continue;
        m = 1;
      }
      int i3 = -1;
      switch (i3)
      {
      default:
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      }
    }
  }

  public final void zzi(int paramInt1, int paramInt2)
  {
    this.zzdic = paramInt1;
    this.zzdid = paramInt2;
  }

  public final boolean zztb()
  {
    while (true)
    {
      synchronized (this.lock)
      {
        if (this.zzdij != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  public final void zzw(boolean paramBoolean)
  {
    synchronized (this.lock)
    {
      if (this.zzdij != null)
      {
        this.zzdij.dismiss();
        this.zzdik.removeView(this.zzdbu.getView());
        if (this.zzdil != null)
        {
          this.zzdil.removeView(this.zzdih);
          this.zzdil.addView(this.zzdbu.getView());
          this.zzdbu.zza(this.zzdig);
        }
        if (paramBoolean)
        {
          zzdj("default");
          if (this.zzdal != null)
            this.zzdal.zztc();
        }
        this.zzdij = null;
        this.zzdik = null;
        this.zzdil = null;
        this.zzdii = null;
      }
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaps
 * JD-Core Version:    0.6.2
 */