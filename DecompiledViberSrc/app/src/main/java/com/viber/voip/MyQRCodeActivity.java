package com.viber.voip;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.a;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.viber.common.permission.b;
import com.viber.common.permission.c;
import com.viber.dexshared.Logger;
import com.viber.voip.api.scheme.i;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.permissions.m;
import com.viber.voip.permissions.n;
import com.viber.voip.registration.af;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ViberActionRunner.aw;
import com.viber.voip.util.at;
import com.viber.voip.util.dv;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.h.a;
import com.viber.voip.util.e.j;
import com.viber.voip.util.q;
import java.io.File;

public class MyQRCodeActivity extends ViberFragmentActivity
  implements View.OnClickListener
{
  static final Logger a = ViberEnv.getLogger();
  private ImageView b;
  private View c;
  private c d;
  private Handler e;
  private final h.a f = new h.a()
  {
    public void onLoadComplete(Uri paramAnonymousUri, Bitmap paramAnonymousBitmap, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousBoolean)
      {
        at.d(MyQRCodeActivity.this.getApplicationContext(), paramAnonymousUri);
        MyQRCodeActivity.a(MyQRCodeActivity.this, MyQRCodeActivity.this.c());
        return;
      }
      MyQRCodeActivity.a(MyQRCodeActivity.this).setVisibility(8);
    }
  };
  private final b g;

  public MyQRCodeActivity()
  {
    Pair[] arrayOfPair = new Pair[1];
    arrayOfPair[0] = m.a(3);
    this.g = new com.viber.voip.permissions.f(this, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        default:
          return;
        case 3:
        }
        MyQRCodeActivity.this.b();
      }
    };
  }

  private static File a(String paramString, Context paramContext)
  {
    return dv.m.b(paramContext, paramString, false);
  }

  private void b(final String paramString)
  {
    this.e.post(new Runnable()
    {
      public void run()
      {
        MyQRCodeActivity.this.a(paramString);
      }
    });
  }

  void a()
  {
    if (this.d.a(n.a))
    {
      b();
      return;
    }
    this.d.a(this, 3, n.a);
  }

  void a(String paramString)
  {
    int i = getResources().getDimensionPixelSize(R.dimen.my_qrcode_size);
    final Bitmap localBitmap = j.a(i.d(paramString), i);
    j.a(localBitmap, a(paramString, this), 80, Bitmap.CompressFormat.PNG, false);
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (!MyQRCodeActivity.this.isFinishing())
        {
          MyQRCodeActivity.b(MyQRCodeActivity.this).setImageBitmap(localBitmap);
          MyQRCodeActivity.a(MyQRCodeActivity.this).setVisibility(8);
        }
      }
    });
  }

  void b()
  {
    ViberActionRunner.aw.a(true, this, getIntent().getStringExtra("analytics_add_contact_entry_point"), getIntent().getStringExtra("analytics_connect_secondary_entry_point"));
  }

  String c()
  {
    return UserManager.from(this).getRegistrationValues().g();
  }

  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.open_scanner)
      a();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.my_qrcode_activity);
    setActionBarTitle(R.string.my_qrcode_title);
    getSupportActionBar().b(true);
    this.d = c.a(this);
    this.e = av.a(av.e.g);
    this.b = ((ImageView)findViewById(R.id.qrcode));
    this.c = findViewById(R.id.progress);
    View localView = findViewById(R.id.open_scanner);
    if (q.a())
    {
      localView.setVisibility(0);
      localView.setOnClickListener(this);
    }
    String str;
    while (true)
    {
      this.c.setVisibility(0);
      str = c();
      File localFile = a(str, this);
      if (!at.a(localFile))
        break;
      e.a(this).a(Uri.fromFile(localFile), this.b, com.viber.voip.util.e.f.a(), this.f);
      return;
      localView.setVisibility(4);
    }
    b(str);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return super.onOptionsItemSelected(paramMenuItem);
    case 16908332:
    }
    onBackPressed();
    return true;
  }

  protected void onStart()
  {
    super.onStart();
    this.d.a(this.g);
  }

  protected void onStop()
  {
    this.d.b(this.g);
    super.onStop();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.MyQRCodeActivity
 * JD-Core Version:    0.6.2
 */