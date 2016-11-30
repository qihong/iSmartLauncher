
package com.bostage.ismartplayer.detail;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class MediaModel implements Parcelable {

    private int id;
    private String title;
    private String imageUrl;
    private String videoUrl;
    private String videoUrlNext;

    private MediaModel(
            final int id,
            final String title,
            final String imageUrl,
            final String videoUrl,
            final String videoUrlNext) {

        this.title = title;
        this.imageUrl = imageUrl;
        this.videoUrl = videoUrl;
        this.videoUrlNext = videoUrlNext;
    }

    protected MediaModel(Parcel in) {
        id = in.readInt();
        title = in.readString();
        imageUrl = in.readString();
        videoUrl = in.readString();
        videoUrlNext = in.readString();
    }

    public static final Creator<MediaModel> CREATOR = new Creator<MediaModel>() {
        @Override
        public MediaModel createFromParcel(Parcel in) {
            return new MediaModel(in);
        }

        @Override
        public MediaModel[] newArray(int size) {
            return new MediaModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoUrlNext() {
        return videoUrlNext;
    }

    public void setVideoUrlNext(String videoUrlNext) {
        this.videoUrlNext = videoUrlNext;
    }

    public static List<MediaModel> getVideoModels() {
        List<MediaModel> mediaModels = new ArrayList<>();

        String titles[] = {
                "TV3",
                "香港卫视HD",
                "催泪",
                "欧冠",
                "韩-KBS2",
        };

        String urls[] = {
                "http://i376.photobucket.com/albums/oo204/indiecrew/Asean%20TV/MY_tv3_zpsccy0afit.png",
                "http://imgsrc.baidu.com/forum/pic/item/410e5aafa40f4bfbd8a9a68a034f78f0f63618fa.jpg",
                "http://imgsrc.baidu.com/forum/pic/item/410e5aafa40f4bfbd8a9a68a034f78f0f63618fa.jpg",
                "http://imgsrc.baidu.com/forum/pic/item/410e5aafa40f4bfbd8a9a68a034f78f0f63618fa.jpg",
                "http://imgsrc.baidu.com/forum/pic/item/410e5aafa40f4bfbd8a9a68a034f78f0f63618fa.jpg",
        };

        String videoUrls[] = {
                "http://www.layarku.tv/media/indiecrew3.m3u8",
                "http://live.hkstv.hk.lxdns.com/live/hks/playlist.m3u8",
                "http://live.gslb.letv.com/gslb?stream_id=lb_cljc_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1",
                "http://live.gslb.letv.com/gslb?stream_id=lb_ouguan_1800&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1",
                "http://123.108.164.71/etv2/phd847/playlist.m3u8",
        };

        for (int i = 0; i < titles.length; i++) {
            MediaModel mediaModel = new MediaModel(
                    0, titles[i], urls[i], videoUrls[i], videoUrls[0]);
            mediaModels.add(mediaModel);
        }

        return mediaModels;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(imageUrl);
        dest.writeString(videoUrl);
        dest.writeString(videoUrlNext);
    }
}
