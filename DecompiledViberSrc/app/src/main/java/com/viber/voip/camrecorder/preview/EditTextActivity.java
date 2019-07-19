package com.viber.voip.camrecorder.preview;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.viber.common.d.a;
import com.viber.dexshared.Logger;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.ui.doodle.extras.TextInfo;
import com.viber.voip.ui.doodle.pickers.ColorPickerView;
import com.viber.voip.ui.doodle.pickers.ColorPickerView.a;
import com.viber.voip.util.dj;
import com.viber.voip.widget.KeyPreImeEditText;
import com.viber.voip.widget.KeyPreImeEditText.a;

public class EditTextActivity extends ViberFragmentActivity
{
  private static final Logger a = ViberEnv.getLogger();
  private static final Handler f = av.a(av.e.a);
  private boolean b;
  private KeyPreImeEditText c;
  private View d;
  private ColorPickerView e;
  private ViewTreeObserver.OnGlobalLayoutListener g;
  private View h;
  private int i;
  private TextInfo j;
  private Runnable k = new Runnable()
  {
    public void run()
    {
      EditTextActivity.this.finish();
    }
  };

  public static Intent a(Context paramContext)
  {
    return new Intent(paramContext, EditTextActivity.class);
  }

  public static Intent a(Context paramContext, TextInfo paramTextInfo)
  {
    Intent localIntent = a(paramContext);
    if (paramTextInfo != null)
      localIntent.putExtra("text_info", paramTextInfo);
    return localIntent;
  }

  public static TextInfo a(Intent paramIntent)
  {
    return (TextInfo)paramIntent.getParcelableExtra("text_info");
  }

  private void a()
  {
    Intent localIntent = new Intent("com.viber.voip.action.TEXT_INPUT_FINISHED");
    localIntent.putExtra("text_info", this.j);
    LocalBroadcastManager.getInstance(this).sendBroadcastSync(localIntent);
  }

  private void a(int paramInt)
  {
    Intent localIntent = new Intent("com.viber.voip.action.COLOR_CHANGED");
    localIntent.putExtra("color", paramInt);
    LocalBroadcastManager.getInstance(this).sendBroadcastSync(localIntent);
  }

  private void b()
  {
    c();
    a();
    dj.b(this.d, false);
    setResult(-1);
    dj.b(this.c, this.g);
    dj.c(this.c);
    f.postDelayed(this.k, 300L);
  }

  private void c()
  {
    String str = this.c.getText().toString();
    int m = this.c.getCurrentTextColor();
    this.j.setText(str);
    this.j.setColor(m);
  }

  public void onBackPressed()
  {
    b();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.edit_text_activity);
    if ((0x8000000 & getWindow().getAttributes().flags) > 0)
      this.b = true;
    this.h = findViewById(16908290);
    this.d = findViewById(R.id.root);
    this.h.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        EditTextActivity.a(EditTextActivity.this);
      }
    });
    if (paramBundle == null);
    for (this.j = a(getIntent()); ; this.j = ((TextInfo)paramBundle.getParcelable("text_info")))
    {
      if (this.j == null)
        this.j = new TextInfo("", ContextCompat.getColor(this, R.color.link_text));
      a(this.j.getColor());
      this.c = ((KeyPreImeEditText)findViewById(R.id.edit_text));
      this.c.setTextColor(this.j.getColor());
      this.c.setRawInputType(1);
      this.c.setText(this.j.getText());
      this.c.setSelection(this.j.getText().length());
      this.c.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          if (paramAnonymousInt == 6)
          {
            EditTextActivity.a(EditTextActivity.this);
            return true;
          }
          return false;
        }
      });
      this.c.setKeyPreImeListener(new KeyPreImeEditText.a()
      {
        public boolean a(int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 1))
          {
            EditTextActivity.a(EditTextActivity.this);
            return true;
          }
          return false;
        }
      });
      this.e = ((ColorPickerView)findViewById(R.id.color_picker));
      this.e.setOnColorChangedListener(new ColorPickerView.a()
      {
        public void a(int paramAnonymousInt)
        {
          EditTextActivity.b(EditTextActivity.this).setTextColor(paramAnonymousInt);
          EditTextActivity.a(EditTextActivity.this, paramAnonymousInt);
        }
      });
      this.i = getResources().getDimensionPixelSize(R.dimen.custom_cam_top_controls_underlay_height);
      this.g = new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public void onGlobalLayout()
        {
          Rect localRect = new Rect();
          EditTextActivity.c(EditTextActivity.this).getWindowVisibleDisplayFrame(localRect);
          int i = EditTextActivity.this.getResources().getDisplayMetrics().heightPixels - localRect.bottom;
          if (i > 0)
            if (EditTextActivity.d(EditTextActivity.this))
            {
              localDisplay = EditTextActivity.this.getWindowManager().getDefaultDisplay();
              localPoint = new Point();
              if (a.b())
              {
                localDisplay.getRealSize(localPoint);
                i = localPoint.y - localRect.bottom;
              }
            }
            else
            {
              if (EditTextActivity.c(EditTextActivity.this).getPaddingTop() - EditTextActivity.e(EditTextActivity.this) != i)
              {
                dj.b(EditTextActivity.f(EditTextActivity.this), true);
                EditTextActivity.c(EditTextActivity.this).setPadding(0, i + EditTextActivity.e(EditTextActivity.this), 0, 0);
              }
              EditTextActivity.a(EditTextActivity.this, EditTextActivity.g(EditTextActivity.this).getColor());
            }
          while (i > 0)
            while (true)
            {
              Display localDisplay;
              Point localPoint;
              return;
              localPoint.y = localDisplay.getHeight();
            }
          if (EditTextActivity.c(EditTextActivity.this).getPaddingTop() != 0)
            EditTextActivity.c(EditTextActivity.this).setPadding(0, EditTextActivity.e(EditTextActivity.this), 0, 0);
          EditTextActivity.b(EditTextActivity.this).post(new Runnable()
          {
            public void run()
            {
              EditTextActivity.b(EditTextActivity.this).requestFocus();
              dj.b(EditTextActivity.b(EditTextActivity.this));
            }
          });
        }
      };
      dj.a(this.h, this.g);
      return;
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    dj.b(this.h, this.g);
    dj.c(this.c);
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    c();
    paramBundle.putParcelable("text_info", this.j);
    super.onSaveInstanceState(paramBundle);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camrecorder.preview.EditTextActivity
 * JD-Core Version:    0.6.2
 */