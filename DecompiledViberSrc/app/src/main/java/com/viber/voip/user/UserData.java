package com.viber.voip.user;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.viber.common.a.e;
import com.viber.common.b.b;
import com.viber.common.b.d;
import com.viber.common.b.h;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.settings.d.bf;
import com.viber.voip.settings.d.bg;
import com.viber.voip.user.viberid.ViberIdInfo;
import com.viber.voip.util.dk;
import com.viber.voip.util.dv;
import com.viber.voip.util.dx;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import org.greenrobot.eventbus.EventBus;

public class UserData
{
  private static final e L = ViberEnv.getLogger();
  private AtomicBoolean isNameUploadedToServer;
  private AtomicBoolean isPhotoUploadedToServer;
  private final EventBus mEventBus;
  private final Handler mMessagesHandler = av.e.d.a();

  public UserData(EventBus paramEventBus)
  {
    this.mEventBus = paramEventBus;
  }

  private String getName()
  {
    return d.bf.b.d();
  }

  public void clear()
  {
    d.bf.b.b();
    d.bf.c.b();
    d.bf.d.b();
    d.bf.e.b();
    this.isPhotoUploadedToServer = null;
    this.isNameUploadedToServer = null;
    notifyOwnerChange();
  }

  public Uri getImage()
  {
    String str = d.bf.c.d();
    if (!TextUtils.isEmpty(str))
    {
      if (str.startsWith("/image_id/"))
      {
        Uri localUri = dx.a(str.replace("/image_id/", ""));
        setImage(localUri);
        notifyOwnerChange();
        return localUri;
      }
      return Uri.parse(str);
    }
    return null;
  }

  public File getImageFile(Context paramContext)
  {
    Uri localUri = getImage();
    if (localUri == null);
    do
    {
      return null;
      if ((dx.b(localUri)) || (dx.c(localUri)))
      {
        String str = localUri.getLastPathSegment();
        return dv.s.b(paramContext, str, false);
      }
    }
    while (!dk.b(localUri));
    return new File(localUri.getPath());
  }

  public ViberIdInfo getViberIdInfo()
  {
    try
    {
      ViberIdInfo localViberIdInfo = new ViberIdInfo(d.bg.a.d(), d.bg.b.d(), d.bg.c.d());
      return localViberIdInfo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getViberImage()
  {
    Uri localUri = getImage();
    if (localUri != null)
      return localUri.toString();
    return "";
  }

  public String getViberName()
  {
    String str = getName();
    if (str != null)
      return str;
    return "";
  }

  public boolean isUserNameUploadedToServer()
  {
    try
    {
      if (this.isNameUploadedToServer == null)
        this.isNameUploadedToServer = new AtomicBoolean(d.bf.e.d());
      boolean bool = this.isNameUploadedToServer.get();
      return bool;
    }
    finally
    {
    }
  }

  public boolean isUserPhotoUploadedToServer()
  {
    try
    {
      if (this.isPhotoUploadedToServer == null)
        this.isPhotoUploadedToServer = new AtomicBoolean(d.bf.d.d());
      boolean bool = this.isPhotoUploadedToServer.get();
      return bool;
    }
    finally
    {
    }
  }

  public void notifyOwnerChange()
  {
    this.mMessagesHandler.post(new UserData..Lambda.0(this));
  }

  public void resetViberIdInfo(int paramInt)
  {
    try
    {
      d.bg.a.e();
      d.bg.c.e();
      d.bg.b.a(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setImage(Uri paramUri)
  {
    h localh = d.bf.c;
    if (paramUri == null);
    for (String str = ""; ; str = paramUri.toString())
    {
      localh.a(str);
      return;
    }
  }

  public void setName(String paramString)
  {
    h localh = d.bf.b;
    if (TextUtils.isEmpty(paramString))
      paramString = "";
    localh.a(paramString);
  }

  public void setNameUploadedToServer(boolean paramBoolean)
  {
    if (this.isNameUploadedToServer != null)
      this.isNameUploadedToServer.set(paramBoolean);
    while (this.isNameUploadedToServer == null)
    {
      d.bf.e.b();
      return;
      this.isNameUploadedToServer = new AtomicBoolean(paramBoolean);
    }
    d.bf.e.a(paramBoolean);
  }

  public void setPhotoUploadedToServer(boolean paramBoolean)
  {
    if (this.isPhotoUploadedToServer != null)
      this.isPhotoUploadedToServer.set(paramBoolean);
    while (this.isPhotoUploadedToServer == null)
    {
      d.bf.d.b();
      return;
      this.isPhotoUploadedToServer = new AtomicBoolean(paramBoolean);
    }
    d.bf.d.a(paramBoolean);
  }

  public void setUserData(String paramString, Uri paramUri)
  {
    setName(paramString);
    setImage(paramUri);
    notifyOwnerChange();
  }

  public void setViberIdInfo(ViberIdInfo paramViberIdInfo)
  {
    try
    {
      d.bg.a.a(paramViberIdInfo.getEmail());
      d.bg.b.a(paramViberIdInfo.getVersion());
      d.bg.c.a(paramViberIdInfo.isRegisteredOnCurrentDevice());
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static class OwnerChangedEvent
  {
    public final UserData userData;

    public OwnerChangedEvent(UserData paramUserData)
    {
      this.userData = paramUserData;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.UserData
 * JD-Core Version:    0.6.2
 */