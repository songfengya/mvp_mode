package com.example.layzzweekend.been;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/10/26.
 */
public class FirstFragment_MainDetail_Been implements Serializable{
    private List<String> descriptionList;
    private List<String> lrzm_tipsList;
    private List<String> booking_policyList;
    private List<String> ticket_ruleList;
    private List<String> ticket_usageList;
    private List<String> represent_dataList;

    public FirstFragment_MainDetail_Been() {
    }

    public FirstFragment_MainDetail_Been(List<String> descriptionList, List<String> lrzm_tipsList, List<String> booking_policyList, List<String> ticket_ruleList, List<String> ticket_usageList, List<String> represent_dataList) {
        this.descriptionList = descriptionList;
        this.lrzm_tipsList = lrzm_tipsList;
        this.booking_policyList = booking_policyList;
        this.ticket_ruleList = ticket_ruleList;
        this.ticket_usageList = ticket_usageList;
        this.represent_dataList = represent_dataList;
    }

    public List<String> getDescriptionList() {
        return descriptionList;
    }

    public void setDescriptionList(List<String> descriptionList) {
        this.descriptionList = descriptionList;
    }

    public List<String> getLrzm_tipsList() {
        return lrzm_tipsList;
    }

    public void setLrzm_tipsList(List<String> lrzm_tipsList) {
        this.lrzm_tipsList = lrzm_tipsList;
    }

    public List<String> getBooking_policyList() {
        return booking_policyList;
    }

    public void setBooking_policyList(List<String> booking_policyList) {
        this.booking_policyList = booking_policyList;
    }

    public List<String> getTicket_ruleList() {
        return ticket_ruleList;
    }

    public void setTicket_ruleList(List<String> ticket_ruleList) {
        this.ticket_ruleList = ticket_ruleList;
    }

    public List<String> getTicket_usageList() {
        return ticket_usageList;
    }

    public void setTicket_usageList(List<String> ticket_usageList) {
        this.ticket_usageList = ticket_usageList;
    }

    public List<String> getRepresent_dataList() {
        return represent_dataList;
    }

    public void setRepresent_dataList(List<String> represent_dataList) {
        this.represent_dataList = represent_dataList;
    }
}
