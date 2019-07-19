package com.viber.jni.slashkey;

public class SlashItem
{
  private String description;
  private int fullGifSizeBytes;
  private int fullImageSizeX;
  private int fullImageSizeY;
  private String imagePreviewUrl;
  private int imageSizeX;
  private int imageSizeY;
  private String imageUrl;
  private boolean isVideo;
  private String name;
  private String postContent;
  private String preContent;
  private String url;
  private int videoDuration;

  public String getDescription()
  {
    return this.description;
  }

  public int getFullGifSizeBytes()
  {
    return this.fullGifSizeBytes;
  }

  public int getFullImageSizeX()
  {
    return this.fullImageSizeX;
  }

  public int getFullImageSizeY()
  {
    return this.fullImageSizeY;
  }

  public String getImagePreviewUrl()
  {
    return this.imagePreviewUrl;
  }

  public int getImageSizeX()
  {
    return this.imageSizeX;
  }

  public int getImageSizeY()
  {
    return this.imageSizeY;
  }

  public String getImageUrl()
  {
    return this.imageUrl;
  }

  public String getName()
  {
    return this.name;
  }

  public String getPostContent()
  {
    return this.postContent;
  }

  public String getPreContent()
  {
    return this.preContent;
  }

  public String getUrl()
  {
    return this.url;
  }

  public int getVideoDuration()
  {
    return this.videoDuration;
  }

  public boolean isVideo()
  {
    return this.isVideo;
  }

  public String toString()
  {
    return "SlashItem{name='" + this.name + '\'' + ", imageUrl='" + this.imageUrl + '\'' + ", description='" + this.description + '\'' + ", url='" + this.url + '\'' + ", imageSizeX=" + this.imageSizeX + '\'' + ", imageSizeY=" + this.imageSizeY + '\'' + ", fullGifSizeBytes=" + this.fullGifSizeBytes + '\'' + ", videoDuration=" + this.videoDuration + '\'' + ", fullImageSizeX=" + this.fullImageSizeX + '\'' + ", fullImageSizeY=" + this.fullImageSizeY + '\'' + ", postContent=" + this.postContent + '\'' + ", preContent=" + this.preContent + '\'' + ", imagePreviewUrl=" + this.imagePreviewUrl + '\'' + ", isVideo=" + this.isVideo + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.slashkey.SlashItem
 * JD-Core Version:    0.6.2
 */