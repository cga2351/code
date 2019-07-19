package com.viber.voip.backup.ui;

import android.app.Application;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import com.viber.common.dialogs.h.a;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberAppCompatActivity;
import com.viber.voip.ViberApplication;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.backup.c.i;
import com.viber.voip.backup.f.e;
import com.viber.voip.backup.j;
import com.viber.voip.backup.l;
import com.viber.voip.registration.af;
import com.viber.voip.settings.d.j;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ax;
import java.io.IOException;

public class RestoreActivity extends ViberAppCompatActivity
  implements j
{
  private com.viber.voip.backup.g a;
  private com.viber.voip.backup.b.b b;
  private a c;
  private com.viber.voip.backup.k d;
  private boolean e;
  private boolean f;
  private String g;
  private ViewFlipper h;
  private TextView i;
  private DialogInterface.OnCancelListener j = new DialogInterface.OnCancelListener()
  {
    public void onCancel(DialogInterface paramAnonymousDialogInterface)
    {
      RestoreActivity.this.finish();
    }
  };

  private void a(CharSequence paramCharSequence)
  {
    Toast.makeText(getApplicationContext(), paramCharSequence, 1).show();
    finish();
  }

  private boolean a()
  {
    return ax.a(this);
  }

  private void b()
  {
    com.viber.voip.ui.dialogs.t.k().d();
    finish();
  }

  private void c()
  {
    this.h.setDisplayedChild(1);
    this.f = true;
    av.a(av.e.a).postDelayed(new Runnable()
    {
      public void run()
      {
        RestoreActivity.this.finish();
      }
    }
    , 1000L);
  }

  private void d()
  {
    if (ax.a(this, null, this.j, 1002))
    {
      this.e = true;
      Application localApplication = ViberApplication.getApplication();
      ViberApplication localViberApplication = ViberApplication.getInstance();
      af localaf = UserManager.from(localApplication).getRegistrationValues();
      e locale = new e(this.g, localaf.l(), localaf.g(), this.b.b());
      this.a.a(localaf.g(), locale, new com.viber.voip.backup.g.b().a(localApplication, 2), localViberApplication.getMessagesManager().k(), localViberApplication.getEngine(false));
    }
  }

  private boolean d(Uri paramUri)
  {
    return (this.e) && (!this.f) && (com.viber.voip.backup.t.d(paramUri));
  }

  public void a(Uri paramUri, int paramInt)
  {
    if (d(paramUri))
    {
      int k = l.a(com.viber.voip.backup.t.h(paramUri), paramInt);
      TextView localTextView = this.i;
      int m = R.string.restore_percents_format;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(k);
      localTextView.setText(getString(m, arrayOfObject));
    }
  }

  public void a(Uri paramUri, com.viber.voip.backup.c.d paramd)
  {
    if (d(paramUri))
      this.c.b(paramd);
  }

  public boolean a(Uri paramUri)
  {
    return d(paramUri);
  }

  public void b(Uri paramUri)
  {
    if (d(paramUri))
      c();
  }

  public void c(Uri paramUri)
  {
    if (d(paramUri))
      finish();
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default:
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    case 1001:
    case 1002:
    }
    do
      return;
    while (paramInt2 == -1);
    finish();
  }

  public void onBackPressed()
  {
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_restore);
    if (paramBundle != null)
      this.e = paramBundle.getBoolean("restore_started");
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("account");
    this.g = localIntent.getStringExtra("drive_file_id");
    this.h = ((ViewFlipper)findViewById(R.id.view_flipper));
    this.i = ((TextView)findViewById(R.id.restore_percents));
    TextView localTextView = this.i;
    int k = R.string.restore_percents_format;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(0);
    localTextView.setText(getString(k, arrayOfObject));
    this.a = com.viber.voip.backup.g.a();
    this.b = new com.viber.voip.backup.b.b(this, new com.viber.voip.k.c(str));
    this.c = new a(null);
    this.d = new com.viber.voip.backup.k(this, av.e.a.a());
  }

  public void onPause()
  {
    super.onPause();
    this.d.c(this.a);
    ax.a(getSupportFragmentManager());
  }

  public void onResume()
  {
    super.onResume();
    if (this.f);
    do
    {
      boolean bool;
      do
      {
        return;
        bool = this.e;
        this.e = true;
      }
      while (this.d.a(this.a, 2));
      this.e = bool;
      if (d.j.n.d())
      {
        c();
        return;
      }
      if (!this.e)
        break;
    }
    while (com.viber.voip.backup.g.a().c() == 2);
    b();
    return;
    if (a())
    {
      d();
      return;
    }
    a(getString(R.string.google_play_services_unavailable_message));
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("restore_started", this.e);
  }

  public void startActivities(Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    com.viber.common.app.a.a(new c(this, paramArrayOfIntent, paramBundle), paramArrayOfIntent);
  }

  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    com.viber.common.app.a.a(new a(this, paramIntent, paramBundle), new Intent[] { paramIntent });
  }

  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    com.viber.common.app.a.a(new b(this, paramIntent, paramInt), new Intent[] { paramIntent });
  }

  private class a extends com.viber.voip.backup.c.g
  {
    private a()
    {
    }

    protected void a(com.google.a.a.b.a.a.b.a.c paramc)
    {
      RestoreActivity.a(RestoreActivity.this, RestoreActivity.this.getString(R.string.google_play_services_unavailable_message));
    }

    protected void a(com.google.a.a.b.a.a.b.a.d paramd)
    {
      RestoreActivity.a(RestoreActivity.this, false);
      ax.a(paramd, RestoreActivity.this, 1001);
    }

    protected void a(i parami)
    {
      RestoreActivity.a(RestoreActivity.this);
    }

    protected void a(IOException paramIOException)
    {
      RestoreActivity.a(RestoreActivity.this);
    }

    protected void c(com.viber.voip.backup.c.d paramd)
    {
      RestoreActivity.a(RestoreActivity.this);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.ui.RestoreActivity
 * JD-Core Version:    0.6.2
 */