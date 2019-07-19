package com.viber.voip.gallery.selection;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.z;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.f;
import com.viber.voip.gallery.GalleryItem;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.cv;
import com.viber.voip.ui.dialogs.o;
import com.viber.voip.util.at;
import java.util.concurrent.ScheduledExecutorService;

public class q
  implements p
{
  private static final Logger a = ViberEnv.getLogger();
  private final FragmentActivity b;
  private a c;

  public q(FragmentActivity paramFragmentActivity, a parama)
  {
    this.b = paramFragmentActivity;
    this.c = parama;
  }

  public void a(GalleryItem paramGalleryItem)
  {
    if (paramGalleryItem.getMediaType() == 1)
      av.f.b.execute(new r(this, paramGalleryItem));
  }

  public void a(GalleryItem paramGalleryItem, int paramInt)
  {
    switch (paramInt)
    {
    case 1:
    default:
    case 0:
    case 2:
    case 5:
    case 3:
      FragmentManager localFragmentManager;
      ViberDialogHandlers.cv localcv;
      do
      {
        ConversationData localConversationData;
        do
        {
          do
          {
            do
            {
              return;
              Toast.makeText(this.b, R.string.file_not_found, 1).show();
              return;
              o.m().a(this.b);
              return;
            }
            while ((paramGalleryItem.isVideo()) || (!a()));
            FragmentActivity localFragmentActivity1 = this.b;
            FragmentActivity localFragmentActivity2 = this.b;
            int i = R.string.gallery_limit_exceeded;
            Object[] arrayOfObject = new Object[1];
            arrayOfObject[0] = Integer.valueOf(10);
            Toast.makeText(localFragmentActivity1, localFragmentActivity2.getString(i, arrayOfObject), 0).show();
            return;
          }
          while (this.c == null);
          localConversationData = this.c.P();
        }
        while (localConversationData == null);
        localFragmentManager = this.b.getSupportFragmentManager();
        localFragmentManager.executePendingTransactions();
        z.a(localFragmentManager, DialogCode.D306);
        localcv = new ViberDialogHandlers.cv(at.a(this.b, paramGalleryItem.getOriginalUri()), localConversationData.conversationId, localConversationData.conversationType, localConversationData.secretConversation, localConversationData.isInBusinessInbox, localConversationData.isInSmsInbox);
      }
      while (z.c(localFragmentManager, DialogCode.D321a) != null);
      o.i().a(localcv).d();
      return;
    case 4:
    }
    o.f().b(this.b);
  }

  public boolean a()
  {
    return true;
  }

  public void b(GalleryItem paramGalleryItem)
  {
  }

  public static abstract interface a
  {
    public abstract ConversationData P();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.selection.q
 * JD-Core Version:    0.6.2
 */