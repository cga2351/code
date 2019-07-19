package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Iterator;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
public final class zzadt extends RelativeLayout
{
  private static final float[] zzcyi = { 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F };
  private AnimationDrawable zzcyj;

  public zzadt(Context paramContext, zzads paramzzads, RelativeLayout.LayoutParams paramLayoutParams)
  {
    super(paramContext);
    Preconditions.checkNotNull(paramzzads);
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(zzcyi, null, null));
    localShapeDrawable.getPaint().setColor(paramzzads.getBackgroundColor());
    setLayoutParams(paramLayoutParams);
    zzk.zzli().setBackground(this, localShapeDrawable);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    if (!TextUtils.isEmpty(paramzzads.getText()))
    {
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      TextView localTextView = new TextView(paramContext);
      localTextView.setLayoutParams(localLayoutParams2);
      localTextView.setId(1195835393);
      localTextView.setTypeface(Typeface.DEFAULT);
      localTextView.setText(paramzzads.getText());
      localTextView.setTextColor(paramzzads.getTextColor());
      localTextView.setTextSize(paramzzads.getTextSize());
      zzyr.zzpa();
      int i = zzazu.zza(paramContext, 4);
      zzyr.zzpa();
      localTextView.setPadding(i, 0, zzazu.zza(paramContext, 4), 0);
      addView(localTextView);
      localLayoutParams1.addRule(1, localTextView.getId());
    }
    ImageView localImageView = new ImageView(paramContext);
    localImageView.setLayoutParams(localLayoutParams1);
    localImageView.setId(1195835394);
    List localList = paramzzads.zzrb();
    if ((localList != null) && (localList.size() > 1))
    {
      this.zzcyj = new AnimationDrawable();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        zzadv localzzadv = (zzadv)localIterator.next();
        try
        {
          Drawable localDrawable = (Drawable)ObjectWrapper.unwrap(localzzadv.zzrf());
          this.zzcyj.addFrame(localDrawable, paramzzads.zzrc());
        }
        catch (Exception localException2)
        {
          zzaxa.zzc("Error while getting drawable.", localException2);
        }
      }
      zzk.zzli().setBackground(localImageView, this.zzcyj);
    }
    while (true)
    {
      addView(localImageView);
      return;
      if (localList.size() == 1)
        try
        {
          localImageView.setImageDrawable((Drawable)ObjectWrapper.unwrap(((zzadv)localList.get(0)).zzrf()));
        }
        catch (Exception localException1)
        {
          zzaxa.zzc("Error while getting drawable.", localException1);
        }
    }
  }

  public final void onAttachedToWindow()
  {
    if (this.zzcyj != null)
      this.zzcyj.start();
    super.onAttachedToWindow();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzadt
 * JD-Core Version:    0.6.2
 */