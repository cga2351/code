package com.viber.voip.camrecorder.preview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.viber.common.permission.c;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.permissions.m;
import com.viber.voip.permissions.n;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.at;
import com.viber.voip.util.dj;
import com.viber.voip.util.dk;
import com.viber.voip.util.dv;
import com.viber.voip.util.e.j;
import java.io.File;

public class b extends e
{
  private static final Logger i = ViberEnv.getLogger();
  private Uri j;
  private View k;
  private c l;
  private com.viber.common.permission.b m;

  public b()
  {
    Pair[] arrayOfPair = new Pair[2];
    arrayOfPair[0] = m.a(8);
    arrayOfPair[1] = m.a(126);
    this.m = new com.viber.voip.permissions.e(this, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        default:
          return;
        case 8:
          b.a(b.this);
          return;
        case 126:
        }
        b.b(b.this);
      }
    };
  }

  private void p()
  {
    if (this.l.a(n.c))
    {
      q();
      return;
    }
    this.l.a(this, 8, n.c);
  }

  private void q()
  {
    this.j = dv.h.a(getActivity(), null, true);
    if (this.j != null)
      ViberActionRunner.a(this, this.j, 443);
  }

  private void r()
  {
    if (this.l.a(n.m))
    {
      s();
      return;
    }
    this.l.a(this, 126, n.m);
  }

  private void s()
  {
    startActivityForResult(ViberActionRunner.a(new Intent().setType("image/*").setAction("android.intent.action.GET_CONTENT"), getString(R.string.msg_options_take_photo), new Intent[0]), 123);
  }

  protected Bitmap a(Context paramContext)
  {
    if (this.d == null)
    {
      Bitmap localBitmap = Bitmap.createBitmap(720, com.viber.voip.messages.extras.image.b.a(getActivity(), 720), Bitmap.Config.ARGB_8888);
      new Canvas(localBitmap).drawColor(-1);
      File localFile = dv.h.a(getActivity(), "blank_doodle");
      if (localFile != null)
      {
        j.a(localBitmap, localFile, 80, false);
        this.d = Uri.fromFile(localFile);
      }
      return localBitmap;
    }
    return super.a(paramContext);
  }

  protected DoodleDataContainer a()
  {
    DoodleDataContainer localDoodleDataContainer = super.a();
    if (localDoodleDataContainer != null)
      localDoodleDataContainer.emptyBackground = dk.a(this.d, dv.h.a(getActivity(), "blank_doodle", true));
    return localDoodleDataContainer;
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (-1 == paramInt2)
    {
      switch (paramInt1)
      {
      default:
        return;
      case 123:
      case 443:
      }
      if ((paramIntent != null) && (paramIntent.getData() != null))
      {
        Uri localUri1 = paramIntent.getData();
        Uri localUri2 = j.a(getContext(), localUri1, "image");
        if (!localUri2.equals(this.j))
          at.d(getActivity(), this.j);
        this.d = localUri2;
      }
      while (true)
      {
        k();
        return;
        if (this.j != null)
          this.d = this.j;
      }
    }
    at.d(getActivity(), this.j);
  }

  public void onClick(View paramView)
  {
    if (paramView == this.k)
    {
      getActivity().openContextMenu(this.k);
      return;
    }
    super.onClick(paramView);
  }

  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    int n = paramMenuItem.getItemId();
    if (n == R.id.remove_pic)
    {
      this.d = null;
      k();
    }
    while (true)
    {
      return super.onContextItemSelected(paramMenuItem);
      if (n == R.id.select_pic)
        r();
      else if (n == R.id.take_pic)
        p();
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null);
    for (Uri localUri = (Uri)paramBundle.getParcelable("temp_uri"); ; localUri = null)
    {
      this.j = localUri;
      this.l = c.a(getActivity());
      return;
    }
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    getActivity().getMenuInflater().inflate(R.menu.context_menu_doodle_image, paramContextMenu);
    if (!dk.a(this.d, dv.h.a(getActivity(), "blank_doodle", true)))
    {
      paramContextMenu.setHeaderTitle(R.string.menu_title_change_canvas);
      return;
    }
    paramContextMenu.removeItem(R.id.remove_pic);
    paramContextMenu.setHeaderTitle(R.string.menu_title_select_canvas);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putParcelable("temp_uri", this.j);
    super.onSaveInstanceState(paramBundle);
  }

  public void onStart()
  {
    super.onStart();
    this.l.a(this.m);
  }

  public void onStop()
  {
    super.onStop();
    this.l.b(this.m);
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.k = paramView.findViewById(R.id.btn_gallery);
    if (this.k != null)
    {
      this.k.setOnClickListener(this);
      registerForContextMenu(this.k);
      dj.c(this.k, 0);
    }
    e();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camrecorder.preview.b
 * JD-Core Version:    0.6.2
 */