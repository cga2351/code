package com.adsnative.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.SeekBar;
import com.adsnative.c.e;
import com.adsnative.c.e.b;
import com.adsnative.c.e.c;
import com.adsnative.c.i;
import java.io.IOException;
import java.io.InputStream;

public class y extends LinearLayout
{
  private final e a;
  private Context b;
  private int c;
  private int d;

  public y(Context paramContext)
  {
    super(paramContext);
    this.b = paramContext;
    this.a = e.a(paramContext);
  }

  public int a()
  {
    return this.c;
  }

  @TargetApi(17)
  public View a(boolean paramBoolean, String paramString)
  {
    setLayoutParams(new LinearLayout.LayoutParams(-1, -2, 80.0F));
    setOrientation(0);
    if (paramBoolean)
      setBackgroundColor(0);
    while (true)
    {
      setGravity(80);
      setPadding(0, 0, 0, 0);
      SeekBar localSeekBar = new SeekBar(this.b);
      this.c = SeekBar.generateViewId();
      localSeekBar.setId(this.c);
      localSeekBar.setLayoutParams(new LinearLayout.LayoutParams(0, 64, 1.0F));
      localSeekBar.getProgressDrawable().setColorFilter(new PorterDuffColorFilter(-65536, PorterDuff.Mode.SRC_IN));
      addView(localSeekBar);
      final ImageButton localImageButton;
      if (!paramBoolean)
      {
        localImageButton = new ImageButton(this.b);
        this.d = ImageButton.generateViewId();
        localImageButton.setId(this.d);
        localImageButton.setBackgroundColor(0);
      }
      try
      {
        this.a.a(paramString, new e.c()
        {
          public void a()
          {
            try
            {
              InputStream localInputStream = y.a(y.this).getAssets().open("video_expand.png");
              localImageButton.setImageDrawable(Drawable.createFromStream(localInputStream, null));
              return;
            }
            catch (IOException localIOException)
            {
              i.e("Failed to load default expand button in ANMediaControllerView");
              localIOException.printStackTrace();
            }
          }

          public void a(e.b paramAnonymousb)
          {
            localImageButton.setImageBitmap(paramAnonymousb.a());
          }
        });
        localImageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
        localImageButton.setAdjustViewBounds(true);
        addView(localImageButton, new LinearLayout.LayoutParams((int)TypedValue.applyDimension(1, 50.0F, getResources().getDisplayMetrics()), (int)TypedValue.applyDimension(1, 50.0F, getResources().getDisplayMetrics())));
        return this;
        setBackgroundColor(0);
      }
      catch (IOException localIOException1)
      {
        while (true)
          try
          {
            localImageButton.setImageDrawable(Drawable.createFromStream(this.b.getAssets().open("video_expand.png"), null));
          }
          catch (IOException localIOException2)
          {
            i.e("Failed to load default expand button in ANMediaControllerView");
            localIOException2.printStackTrace();
          }
      }
    }
  }

  public int b()
  {
    return this.d;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.ads.y
 * JD-Core Version:    0.6.2
 */