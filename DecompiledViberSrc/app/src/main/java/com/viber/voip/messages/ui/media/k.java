package com.viber.voip.messages.ui.media;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.viber.common.app.a;
import com.viber.voip.R.string;
import com.viber.voip.an.c;
import com.viber.voip.util.dv;
import com.viber.voip.util.dx;

public class k extends Fragment
{
  protected Uri a(Uri paramUri)
  {
    if (!dx.d(paramUri))
      return paramUri;
    return dv.n.a(getActivity().getApplicationContext(), paramUri.toString(), false);
  }

  protected boolean e()
  {
    int i = getArguments().getInt("status");
    return (i == 0) || (i == 5);
  }

  protected int f()
  {
    return getArguments().getInt("status");
  }

  protected String g()
  {
    FragmentActivity localFragmentActivity = getActivity();
    int i = getArguments().getInt("status");
    int j = R.string.dialog_download_fail;
    switch (i)
    {
    case 5:
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    case 6:
    }
    while (true)
    {
      return localFragmentActivity.getString(j);
      j = R.string.dialog_201_title;
      continue;
      j = R.string.file_not_found;
      continue;
      j = R.string.dialog_337_title;
      continue;
      j = R.string.dialog_not_supported_file;
      continue;
      j = R.string.dialog_351_title;
    }
  }

  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    a.a(new l(this, paramIntent, paramBundle), new Intent[] { paramIntent });
  }

  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    a.a(new m(this, paramIntent, paramInt, paramBundle), new Intent[] { paramIntent });
  }

  static abstract interface a
  {
    public abstract an.c a(int paramInt, Uri paramUri, String paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.k
 * JD-Core Version:    0.6.2
 */