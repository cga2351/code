package com.vk.sdk.api;

import com.vk.sdk.api.methods.VKApiAudio;
import com.vk.sdk.api.methods.VKApiDocs;
import com.vk.sdk.api.methods.VKApiFriends;
import com.vk.sdk.api.methods.VKApiGroups;
import com.vk.sdk.api.methods.VKApiMessages;
import com.vk.sdk.api.methods.VKApiPhotos;
import com.vk.sdk.api.methods.VKApiUsers;
import com.vk.sdk.api.methods.VKApiVideo;
import com.vk.sdk.api.methods.VKApiWall;
import com.vk.sdk.api.photo.VKUploadAlbumPhotoRequest;
import com.vk.sdk.api.photo.VKUploadImage;
import com.vk.sdk.api.photo.VKUploadMessagesPhotoRequest;
import com.vk.sdk.api.photo.VKUploadWallPhotoRequest;
import java.io.File;

public class VKApi
{
  public static VKApiAudio audio()
  {
    return new VKApiAudio();
  }

  public static VKApiDocs docs()
  {
    return new VKApiDocs();
  }

  public static VKApiFriends friends()
  {
    return new VKApiFriends();
  }

  public static VKApiGroups groups()
  {
    return new VKApiGroups();
  }

  public static VKApiMessages messages()
  {
    return new VKApiMessages();
  }

  public static VKApiPhotos photos()
  {
    return new VKApiPhotos();
  }

  public static VKRequest uploadAlbumPhotoRequest(VKUploadImage paramVKUploadImage, long paramLong, int paramInt)
  {
    return new VKUploadAlbumPhotoRequest(paramVKUploadImage, paramLong, paramInt);
  }

  public static VKRequest uploadAlbumPhotoRequest(File paramFile, long paramLong, int paramInt)
  {
    return new VKUploadAlbumPhotoRequest(paramFile, paramLong, paramInt);
  }

  public static VKRequest uploadMessagesPhotoRequest(VKUploadImage paramVKUploadImage)
  {
    return new VKUploadMessagesPhotoRequest(paramVKUploadImage);
  }

  public static VKRequest uploadMessagesPhotoRequest(File paramFile)
  {
    return new VKUploadMessagesPhotoRequest(paramFile);
  }

  public static VKRequest uploadWallPhotoRequest(VKUploadImage paramVKUploadImage, long paramLong, int paramInt)
  {
    return new VKUploadWallPhotoRequest(paramVKUploadImage, paramLong, paramInt);
  }

  public static VKRequest uploadWallPhotoRequest(File paramFile, long paramLong, int paramInt)
  {
    return new VKUploadWallPhotoRequest(paramFile, paramLong, paramInt);
  }

  public static VKApiUsers users()
  {
    return new VKApiUsers();
  }

  public static VKApiVideo video()
  {
    return new VKApiVideo();
  }

  public static VKApiWall wall()
  {
    return new VKApiWall();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.VKApi
 * JD-Core Version:    0.6.2
 */