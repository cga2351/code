package com.viber.voip.bot.item;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.Html;
import android.text.Spanned;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import com.viber.voip.util.da;
import java.util.Locale;

public class BotKeyboardItem extends KeyboardItem
{
  public static final Parcelable.Creator<BotKeyboardItem> CREATOR = new Parcelable.Creator()
  {
    public BotKeyboardItem a(Parcel paramAnonymousParcel)
    {
      return new BotKeyboardItem(paramAnonymousParcel, null);
    }

    public BotKeyboardItem[] a(int paramAnonymousInt)
    {
      return new BotKeyboardItem[paramAnonymousInt];
    }
  };
  private Spanned mCachedHtmlText;
  private String mReplyButtonText;
  public final ReplyButton replyButton;

  private BotKeyboardItem(Parcel paramParcel)
  {
    super(paramParcel);
    this.replyButton = ((ReplyButton)paramParcel.readParcelable(ReplyButton.class.getClassLoader()));
    this.mReplyButtonText = this.replyButton.getText();
    if (da.a(this.mReplyButtonText))
      this.mReplyButtonText = null;
  }

  public BotKeyboardItem(ReplyButton paramReplyButton)
  {
    this.replyButton = paramReplyButton;
    this.colSpan = paramReplyButton.getColumns();
    this.rowSpan = paramReplyButton.getRows();
    this.mReplyButtonText = paramReplyButton.getText();
    if (da.a(this.mReplyButtonText))
      this.mReplyButtonText = null;
  }

  public Spanned getCachedHtmlText(Context paramContext, float paramFloat)
  {
    if ((this.mCachedHtmlText == null) && (this.mReplyButtonText != null))
    {
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.mReplyButtonText;
      this.mCachedHtmlText = Html.fromHtml(String.format(localLocale, "<update_handler>%s</update_handler>", arrayOfObject), null, new e(paramContext, paramFloat));
    }
    return this.mCachedHtmlText;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.replyButton, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.bot.item.BotKeyboardItem
 * JD-Core Version:    0.6.2
 */