package com.zhongmeng.rxjava2test.bean;

import java.util.List;

/**
 * author :rcw.
 * date :2017/10/12 10:54.
 */

public class Banner extends BaseBean{

    private List<ImgListBean> imgList;

    public List<ImgListBean> getImgList() {
        return imgList;
    }

    public void setImgList(List<ImgListBean> imgList) {
        this.imgList = imgList;
    }

    public static class ImgListBean {
        /**
         * id : 1
         * title : images1
         * url : http://www.cyrytj.com:8060/cdc_appInterface/slideFile/images1.png
         */

        private int id;
        private String title;
        private String url;

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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "ImgListBean{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }
}
