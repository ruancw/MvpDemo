package com.zhongmeng.rxjava2test.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * author :rcw.
 * date :2017/10/12 14:23.
 */

public class Notice extends BaseBean implements Parcelable{

    /**
     * message : 请求成功！
     * noticeList : [{"img_path":"http://owauh0662.bkt.clouddn.com/notice_20170920104225180.jpg","id":58,"notice_date":"2017-09-20 10:44","rownum":5,"title":"发个吧负固不宾","unitname":"系统","send_person":"系统管理员","url":"http://192.168.1.68:8080/cdc_appInterface/noticeManageController/lookNotice.do?noticeid=58"}]
     * totalNum : 5
     * state : 1
     * code : 200
     */

    private int totalNum;

    private ArrayList<NoticeListBean> noticeList;

    protected Notice(Parcel in) {
        totalNum = in.readInt();
    }

    public static final Creator<Notice> CREATOR = new Creator<Notice>() {
        @Override
        public Notice createFromParcel(Parcel in) {
            return new Notice(in);
        }

        @Override
        public Notice[] newArray(int size) {
            return new Notice[size];
        }
    };

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }


    public ArrayList<NoticeListBean> getNoticeList() {
        return noticeList;
    }

    public void setNoticeList(ArrayList<NoticeListBean> noticeList) {
        this.noticeList = noticeList;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "totalNum=" + totalNum +
                ", noticeList=" + noticeList +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(totalNum);
    }

    public static class NoticeListBean implements Parcelable{
        /**
         * img_path : http://owauh0662.bkt.clouddn.com/notice_20170920104225180.jpg
         * id : 58
         * notice_date : 2017-09-20 10:44
         * rownum : 5
         * title : 发个吧负固不宾
         * unitname : 系统
         * send_person : 系统管理员
         * url : http://192.168.1.68:8080/cdc_appInterface/noticeManageController/lookNotice.do?noticeid=58
         */

        private String img_path;
        private int id;
        private String notice_date;
        private int rownum;
        private String title;
        private String unitname;
        private String send_person;
        private String url;

        protected NoticeListBean(Parcel in) {
            img_path = in.readString();
            id = in.readInt();
            notice_date = in.readString();
            rownum = in.readInt();
            title = in.readString();
            unitname = in.readString();
            send_person = in.readString();
            url = in.readString();
        }

        public static final Creator<NoticeListBean> CREATOR = new Creator<NoticeListBean>() {
            @Override
            public NoticeListBean createFromParcel(Parcel in) {
                return new NoticeListBean(in);
            }

            @Override
            public NoticeListBean[] newArray(int size) {
                return new NoticeListBean[size];
            }
        };

        public String getImg_path() {
            return img_path;
        }

        public void setImg_path(String img_path) {
            this.img_path = img_path;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNotice_date() {
            return notice_date;
        }

        public void setNotice_date(String notice_date) {
            this.notice_date = notice_date;
        }

        public int getRownum() {
            return rownum;
        }

        public void setRownum(int rownum) {
            this.rownum = rownum;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUnitname() {
            return unitname;
        }

        public void setUnitname(String unitname) {
            this.unitname = unitname;
        }

        public String getSend_person() {
            return send_person;
        }

        public void setSend_person(String send_person) {
            this.send_person = send_person;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "NoticeListBean{" +
                    "img_path='" + img_path + '\'' +
                    ", id=" + id +
                    ", notice_date='" + notice_date + '\'' +
                    ", rownum=" + rownum +
                    ", title='" + title + '\'' +
                    ", unitname='" + unitname + '\'' +
                    ", send_person='" + send_person + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(img_path);
            parcel.writeInt(id);
            parcel.writeString(notice_date);
            parcel.writeInt(rownum);
            parcel.writeString(title);
            parcel.writeString(unitname);
            parcel.writeString(send_person);
            parcel.writeString(url);
        }
    }
}
