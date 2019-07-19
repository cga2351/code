package com.adsnative.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import com.adsnative.b.f;
import com.adsnative.c.e;
import com.adsnative.c.e.b;
import com.adsnative.c.e.c;
import com.adsnative.c.i;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FullscreenVideoActivity extends Activity
{
  private Context a;
  private ac b;
  private int c = 0;

  public void finish()
  {
    ac.a(this.b.getCurrentPosition(), true);
    super.finish();
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.c != paramConfiguration.orientation)
      this.c = paramConfiguration.orientation;
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = this;
    requestWindowFeature(1);
    Intent localIntent = getIntent();
    String str1 = localIntent.getStringExtra("videoUrl");
    int i;
    if (paramBundle != null)
      i = paramBundle.getInt("seekTo");
    String str6;
    e locale;
    FrameLayout localFrameLayout1;
    final ImageButton localImageButton;
    while (true)
    {
      boolean bool = localIntent.getBooleanExtra("targetState", false);
      String str2 = localIntent.getStringExtra("quartileTrackingData");
      final HashMap localHashMap1 = new HashMap();
      String str3;
      final ArrayList localArrayList;
      try
      {
        JSONObject localJSONObject = new JSONObject(str2);
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str7 = (String)localIterator.next();
          localHashMap1.put(str7, localJSONObject.optJSONArray(str7));
        }
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
        str3 = localIntent.getStringExtra("vidCompleteTrackingData");
        localArrayList = new ArrayList();
      }
      try
      {
        JSONArray localJSONArray = new JSONArray(str3);
        if (localJSONArray != null)
        {
          int j = 0;
          while (j < localJSONArray.length())
          {
            localArrayList.add(localJSONArray.optString(j));
            j++;
            continue;
            i = localIntent.getIntExtra("seekTo", 0);
          }
        }
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
        String str4 = localIntent.getStringExtra("playButtonUrl");
        String str5 = localIntent.getStringExtra("expandButtonUrl");
        str6 = localIntent.getStringExtra("closeButtonUrl");
        locale = e.a(this);
        localFrameLayout1 = new FrameLayout(this);
        localFrameLayout1.setBackgroundColor(-16777216);
        HashMap localHashMap2 = new HashMap();
        localHashMap2.put("playButtonUrl", str4);
        localHashMap2.put("expandButtonUrl", str5);
        this.b = new ac(this, localHashMap2);
        FrameLayout localFrameLayout2 = new FrameLayout(this);
        localFrameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-1, -2, 16));
        localFrameLayout2.addView(this.b, new FrameLayout.LayoutParams(-1, -2));
        localFrameLayout1.addView(localFrameLayout2);
        this.b.setTrackersListener(new h.c()
        {
          public void a()
          {
          }

          public void a(String paramAnonymousString)
          {
            i.e("FullscreenVideoActivity -> MediaViewTrackersListener -> videoQuartiles() : " + paramAnonymousString);
            if ("100".equals(paramAnonymousString))
            {
              Iterator localIterator = localArrayList.iterator();
              while (localIterator.hasNext())
              {
                String str = (String)localIterator.next();
                new FullscreenVideoActivity.a(FullscreenVideoActivity.this, str).execute(new String[0]);
              }
            }
            if ((localHashMap1 != null) && (localHashMap1.size() > 0))
            {
              JSONArray localJSONArray = (JSONArray)localHashMap1.get(paramAnonymousString);
              if ((localJSONArray != null) && (localJSONArray.length() > 0))
                for (int i = 0; i < localJSONArray.length(); i++)
                  new FullscreenVideoActivity.a(FullscreenVideoActivity.this, localJSONArray.optString(i)).execute(new String[0]);
            }
          }

          public void b()
          {
          }

          public void c()
          {
          }
        });
        this.b.setQuartilesToTrack(localHashMap1);
        this.b.setMediaLoadListener(new h.a()
        {
          public void a(View paramAnonymousView)
          {
            h.b(paramAnonymousView);
            FullscreenVideoActivity.this.finish();
          }
        });
        this.b.setFullScreenByDefault(true);
        this.b.setTargetStateToPlay(bool);
        ac.a(i, true);
        this.b.setVideoPath(str1);
        x localx = new x(this);
        localx.setVideoConfigs(localHashMap2);
        localx.setAnchorView(localFrameLayout1);
        this.b.setMediaController(localx);
        localImageButton = new ImageButton(this);
        localImageButton.setBackgroundColor(0);
      }
    }
    try
    {
      locale.a(str6, new e.c()
      {
        public void a()
        {
          try
          {
            InputStream localInputStream = FullscreenVideoActivity.this.getAssets().open("video_close.png");
            localImageButton.setImageDrawable(Drawable.createFromStream(localInputStream, null));
            return;
          }
          catch (IOException localIOException)
          {
            i.e("Failed to load default close button in FullscreenVideoActivity");
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
      localImageButton.setLayoutParams(new FrameLayout.LayoutParams((int)TypedValue.applyDimension(1, 50.0F, getResources().getDisplayMetrics()), (int)TypedValue.applyDimension(1, 50.0F, getResources().getDisplayMetrics()), 53));
      localImageButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          FullscreenVideoActivity.this.finish();
        }
      });
      localFrameLayout1.addView(localImageButton);
      localFrameLayout1.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
      setContentView(localFrameLayout1);
      return;
    }
    catch (IOException localIOException1)
    {
      while (true)
        try
        {
          localImageButton.setImageDrawable(Drawable.createFromStream(getAssets().open("video_close.png"), null));
        }
        catch (IOException localIOException2)
        {
          i.e("Failed to load default close button in FullscreenVideoActivity");
          localIOException2.printStackTrace();
        }
    }
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putInt("seekTo", this.b.getCurrentPosition());
    super.onSaveInstanceState(paramBundle);
  }

  private class a extends AsyncTask<String, Void, Boolean>
  {
    private final String b;
    private final f c;

    public a(String arg2)
    {
      Object localObject;
      this.b = localObject;
      this.c = f.a(FullscreenVideoActivity.a(FullscreenVideoActivity.this));
    }

    protected Boolean a(String[] paramArrayOfString)
    {
      try
      {
        Boolean localBoolean = new Boolean(this.c.a(FullscreenVideoActivity.a(FullscreenVideoActivity.this), this.b));
        return localBoolean;
      }
      catch (ClientProtocolException localClientProtocolException)
      {
        i.e("ClientProtocolException firing the tracking url: " + localClientProtocolException.getMessage());
        return Boolean.valueOf(false);
      }
      catch (IOException localIOException)
      {
        while (true)
          i.e("IOException firing the tracking url: " + localIOException.getMessage());
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        while (true)
          i.e("IllegalArgumentException firing the tracking url: " + localIllegalArgumentException.getMessage());
      }
      catch (Exception localException)
      {
        while (true)
          i.e("Unknown Exception firing the tracking url: " + localException.getMessage());
      }
    }

    protected void a(Boolean paramBoolean)
    {
      super.onPostExecute(paramBoolean);
      if (!paramBoolean.booleanValue())
        i.e("Failed to fire the tracking url: " + this.b);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.ads.FullscreenVideoActivity
 * JD-Core Version:    0.6.2
 */