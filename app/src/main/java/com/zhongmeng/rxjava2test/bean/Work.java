package com.zhongmeng.rxjava2test.bean;

import java.util.List;

/**
 * author :rcw.
 * date :2017/10/16 13:43.
 */

public class Work extends BaseBean {

    private List<TjdbListBean> tjdbList;

    public List<TjdbListBean> getTjdbList() {
        return tjdbList;
    }

    public void setTjdbList(List<TjdbListBean> tjdbList) {
        this.tjdbList = tjdbList;
    }

    public static class TjdbListBean {
        /**
         * typeName : 预约待审核人数
         * neednumber : 0
         * currentnumber : 11
         */

        private String typeName;
        private int neednumber;
        private int currentnumber;

        public String getTypenum() {
            return typenum;
        }

        public void setTypenum(String typenum) {
            this.typenum = typenum;
        }

        private String typenum;
        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public int getNeednumber() {
            return neednumber;
        }

        public void setNeednumber(int neednumber) {
            this.neednumber = neednumber;
        }

        public int getCurrentnumber() {
            return currentnumber;
        }

        public void setCurrentnumber(int currentnumber) {
            this.currentnumber = currentnumber;
        }
    }
}
