package com.gaojunhui.koreantv.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/7/12.
 */
public class Hot {

    /**
     * status : 0
     * liked : false
     * related_user : [{"status":0,"name":"孽小妖","source_uid":"1EB52E0F802F227FAFF469256AD90CB7","gender":0,"atype":0,"custom":null,"icon_url":{"240":"http://q.qlogo.cn/qqapp/1105237557/1EB52E0F802F227FAFF469256AD90CB7/100","640":"http://q.qlogo.cn/qqapp/1105237557/1EB52E0F802F227FAFF469256AD90CB7/100","origin":"http://q.qlogo.cn/qqapp/1105237557/1EB52E0F802F227FAFF469256AD90CB7/100","format":"unknown"},"id":"57722bb155c400fdcbf8ea04"}]
     */

    private List<ItemsBean> items;

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        private int status;
        private boolean liked;
        /**
         * status : 0
         * name : 孽小妖
         * source_uid : 1EB52E0F802F227FAFF469256AD90CB7
         * gender : 0
         * atype : 0
         * custom : null
         * icon_url : {"240":"http://q.qlogo.cn/qqapp/1105237557/1EB52E0F802F227FAFF469256AD90CB7/100","640":"http://q.qlogo.cn/qqapp/1105237557/1EB52E0F802F227FAFF469256AD90CB7/100","origin":"http://q.qlogo.cn/qqapp/1105237557/1EB52E0F802F227FAFF469256AD90CB7/100","format":"unknown"}
         * id : 57722bb155c400fdcbf8ea04
         */

        private List<RelatedUserBean> related_user;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public boolean isLiked() {
            return liked;
        }

        public void setLiked(boolean liked) {
            this.liked = liked;
        }

        public List<RelatedUserBean> getRelated_user() {
            return related_user;
        }

        public void setRelated_user(List<RelatedUserBean> related_user) {
            this.related_user = related_user;
        }

        public static class RelatedUserBean {
            private int status;
            private String name;
            private String source_uid;
            private int gender;
            private int atype;
            private Object custom;
            /**
             * 240 : http://q.qlogo.cn/qqapp/1105237557/1EB52E0F802F227FAFF469256AD90CB7/100
             * 640 : http://q.qlogo.cn/qqapp/1105237557/1EB52E0F802F227FAFF469256AD90CB7/100
             * origin : http://q.qlogo.cn/qqapp/1105237557/1EB52E0F802F227FAFF469256AD90CB7/100
             * format : unknown
             */

            private IconUrlBean icon_url;
            private String id;

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSource_uid() {
                return source_uid;
            }

            public void setSource_uid(String source_uid) {
                this.source_uid = source_uid;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public int getAtype() {
                return atype;
            }

            public void setAtype(int atype) {
                this.atype = atype;
            }

            public Object getCustom() {
                return custom;
            }

            public void setCustom(Object custom) {
                this.custom = custom;
            }

            public IconUrlBean getIcon_url() {
                return icon_url;
            }

            public void setIcon_url(IconUrlBean icon_url) {
                this.icon_url = icon_url;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public static class IconUrlBean {
 //               @com.google.gson.annotations.SerializedName("240")
                private String value240;
//                @com.google.gson.annotations.SerializedName("640")
                private String value640;
                private String origin;
                private String format;

                public String getValue240() {
                    return value240;
                }

                public void setValue240(String value240) {
                    this.value240 = value240;
                }

                public String getValue640() {
                    return value640;
                }

                public void setValue640(String value640) {
                    this.value640 = value640;
                }

                public String getOrigin() {
                    return origin;
                }

                public void setOrigin(String origin) {
                    this.origin = origin;
                }

                public String getFormat() {
                    return format;
                }

                public void setFormat(String format) {
                    this.format = format;
                }
            }
        }
    }
}
