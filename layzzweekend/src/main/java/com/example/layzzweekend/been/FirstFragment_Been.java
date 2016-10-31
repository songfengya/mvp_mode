package com.example.layzzweekend.been;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/25.
 */
public class FirstFragment_Been implements Serializable{

    /**
     * address : 湖北省武汉市武昌区徐东大街秦园东路福星惠誉水岸星城A区G17栋4901室
     * biz_phone :
     * category : 文艺生活
     * category_id : 14
     * collected_num : 46
     * consult_phone :
     * distance : 0
     * front_cover_image_list : ["http://image.lanrenzhoumo.com/leo/img/20160903092309_853b031a43495200d111d6f5239398a3.jpg","http://image.lanrenzhoumo.com/leo/img/20160903092647_84fe8390074c44a142116cc82b836d4d.png","http://image.lanrenzhoumo.com/leo/img/20160903092515_5764da0b73126a2e066caee6bd341cda.jpg","http://image.lanrenzhoumo.com/leo/img/20160903092334_5ef232056812ae4ef241fe373aae7c5a.jpg","http://image.lanrenzhoumo.com/leo/img/20160903092351_1bd3d2af3a42343ff2eb3f2dba852ac0.jpg"]
     * item_type : leo
     * jump_data :
     * jump_type : leo_detail_api
     * leo_id : 1351342007
     * poi : CANON HALL成人钢琴俱乐部
     * poi_name : CANON HALL成人钢琴俱乐部
     * price : 188.0
     * price_info : 188
     * sell_status : 2
     * show_free : true
     * tags : ["亲子","情侣","单身"]
     * time : {"end":"2017-10-11 21:00:00","start":"2016-09-03 00:00:00"}
     * time_desc : 9月3日 ~ 2017年10月11日 21:00
     * time_info : 截止至2017年10月11日
     * title : 成人钢琴【18课时】深度体验，遇见最美好的自己【188元抢购】！
     * viewed_num : 570
     * want_status : 0
     */

    private String address;
    private String biz_phone;
    private String category;
    private String category_id;
    private String collected_num;
    private String consult_phone;
    private String distance;
    private String item_type;
    private String jump_data;
    private String jump_type;
    private String leo_id;
    private String poi;
    private String poi_name;
    private String price;
    private String price_info;
    private String sell_status;
    private String show_free;
    private String time_desc;
    private String time_info;
    private String title;
    private String viewed_num;
    private String want_status;
    private List<String> front_cover_image_list;
    private List<String> tags;
     private Map<String,String> time;

    public FirstFragment_Been() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBiz_phone() {
        return biz_phone;
    }

    public void setBiz_phone(String biz_phone) {
        this.biz_phone = biz_phone;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getCollected_num() {
        return collected_num;
    }

    public void setCollected_num(String collected_num) {
        this.collected_num = collected_num;
    }

    public String getConsult_phone() {
        return consult_phone;
    }

    public void setConsult_phone(String consult_phone) {
        this.consult_phone = consult_phone;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public String getJump_data() {
        return jump_data;
    }

    public void setJump_data(String jump_data) {
        this.jump_data = jump_data;
    }

    public String getJump_type() {
        return jump_type;
    }

    public void setJump_type(String jump_type) {
        this.jump_type = jump_type;
    }

    public String getLeo_id() {
        return leo_id;
    }

    public void setLeo_id(String leo_id) {
        this.leo_id = leo_id;
    }

    public String getPoi() {
        return poi;
    }

    public void setPoi(String poi) {
        this.poi = poi;
    }

    public String getPoi_name() {
        return poi_name;
    }

    public void setPoi_name(String poi_name) {
        this.poi_name = poi_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice_info() {
        return price_info;
    }

    public void setPrice_info(String price_info) {
        this.price_info = price_info;
    }

    public String getSell_status() {
        return sell_status;
    }

    public void setSell_status(String sell_status) {
        this.sell_status = sell_status;
    }

    public String getShow_free() {
        return show_free;
    }

    public void setShow_free(String show_free) {
        this.show_free = show_free;
    }

    public String getTime_desc() {
        return time_desc;
    }

    public void setTime_desc(String time_desc) {
        this.time_desc = time_desc;
    }

    public String getTime_info() {
        return time_info;
    }

    public void setTime_info(String time_info) {
        this.time_info = time_info;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getViewed_num() {
        return viewed_num;
    }

    public void setViewed_num(String viewed_num) {
        this.viewed_num = viewed_num;
    }

    public String getWant_status() {
        return want_status;
    }

    public void setWant_status(String want_status) {
        this.want_status = want_status;
    }

    public List<String> getFront_cover_image_list() {
        return front_cover_image_list;
    }

    public void setFront_cover_image_list(List<String> front_cover_image_list) {
        this.front_cover_image_list = front_cover_image_list;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Map<String, String> getTime() {
        return time;
    }

    public void setTime(Map<String, String> time) {
        this.time = time;
    }


}
