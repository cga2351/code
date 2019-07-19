package com.viber.voip.widget;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo;
import com.viber.voip.messages.c;
import com.viber.voip.messages.conversation.adapter.d.i;
import com.viber.voip.messages.d;
import com.viber.voip.util.at;
import com.viber.voip.util.dj;
import com.viber.voip.util.upload.m;

@Deprecated
public class FileMessageLayout extends RelativeLayout
{
  private static final Logger a = ViberEnv.getLogger();
  private ViewGroup b;
  private FileIconView c;
  private TextView d;
  private TextView e;
  private i f;
  private d g;
  private Handler h;
  private Uri i;
  private volatile int j;
  private a k = new a(null);
  private b l = new b(null);

  public FileMessageLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public FileMessageLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public FileMessageLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    this.b = ((ViewGroup)LayoutInflater.from(paramContext).inflate(R.layout.msg_file, this));
    setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    this.h = av.a(av.e.a);
    this.c = ((FileIconView)this.b.findViewById(R.id.file_type_icon));
    this.e = ((TextView)this.b.findViewById(R.id.file_name));
    this.d = ((TextView)this.b.findViewById(R.id.file_size));
    this.d.setInputType(1);
  }

  private void a(String paramString1, String paramString2, d paramd)
  {
    this.e.setText(paramString1);
    this.d.setText(paramString2);
    this.g = paramd;
  }

  public void a(FileInfo paramFileInfo)
  {
    dj.c(this.b.findViewById(R.id.location_clickable_area), 8);
    String str = paramFileInfo.getFileName();
    a(str, at.a(paramFileInfo.getFileSize()), c.a(at.d(str)));
    this.c.a(true, 0L, this.g);
    this.c.getDownloadIcon().b();
    this.e.setTextColor(-16777216);
  }

  public void setMessageFileClickListener(i parami)
  {
    this.f = parami;
  }

  private class a
    implements m
  {
    private a()
    {
    }

    public void a(Uri paramUri, int paramInt)
    {
      if (paramUri.equals(FileMessageLayout.c(FileMessageLayout.this)))
      {
        FileMessageLayout.a(FileMessageLayout.this, paramInt);
        FileMessageLayout.e(FileMessageLayout.this).removeCallbacks(FileMessageLayout.d(FileMessageLayout.this));
        FileMessageLayout.e(FileMessageLayout.this).post(FileMessageLayout.d(FileMessageLayout.this));
      }
    }
  }

  private class b
    implements Runnable
  {
    private b()
    {
    }

    public void run()
    {
      FileMessageLayout.b(FileMessageLayout.this).a(FileMessageLayout.a(FileMessageLayout.this) / 100.0D);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.FileMessageLayout
 * JD-Core Version:    0.6.2
 */