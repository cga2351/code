package com.appboy.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.appboy.e.a.f;
import com.appboy.f.c;
import com.appboy.ui.R.drawable;
import com.appboy.ui.R.id;
import com.appboy.ui.R.layout;
import com.appboy.ui.actions.IAction;
import com.appboy.ui.feed.view.BaseFeedCardView;

public class TextAnnouncementCardView extends BaseFeedCardView<f>
{
  private static final String TAG = c.a(TextAnnouncementCardView.class);
  private IAction mCardAction;
  private final TextView mDescription = (TextView)findViewById(R.id.com_appboy_text_announcement_card_description);
  private final TextView mDomain = (TextView)findViewById(R.id.com_appboy_text_announcement_card_domain);
  private final TextView mTitle = (TextView)findViewById(R.id.com_appboy_text_announcement_card_title);

  public TextAnnouncementCardView(Context paramContext)
  {
    this(paramContext, null);
  }

  public TextAnnouncementCardView(Context paramContext, f paramf)
  {
    super(paramContext);
    if (paramf != null)
      setCard(paramf);
    setBackground(getResources().getDrawable(R.drawable.com_appboy_card_background));
  }

  protected int getLayoutResource()
  {
    return R.layout.com_appboy_text_announcement_card;
  }

  public void onSetCard(final f paramf)
  {
    this.mTitle.setText(paramf.c());
    this.mDescription.setText(paramf.a());
    setOptionalTextView(this.mDomain, paramf.e());
    this.mCardAction = getUriActionForCard(paramf);
    setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        TextAnnouncementCardView.this.handleCardClick(TextAnnouncementCardView.this.mContext, paramf, TextAnnouncementCardView.this.mCardAction, TextAnnouncementCardView.TAG);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.widget.TextAnnouncementCardView
 * JD-Core Version:    0.6.2
 */