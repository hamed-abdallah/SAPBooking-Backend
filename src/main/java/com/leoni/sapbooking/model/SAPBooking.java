package com.leoni.sapbooking.model;

import java.util.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SAPBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "persNum")
	private String persNum;
	@Column(name = "name")
	private String name;
	@Column(name = "status")
	private int status;
	@Column(name = "act")
	private String act;
	@Column(name = "team")
	private String team;
	@Column(name = "date")
	private Date date;
	@Column(name = "recCost")
	private String recCost;
	@Column(name = "wbs")
	private String wbs;
	@Column(name = "costCenter")
	private String costCenter;
	@Column(name = "shortText")
	private String shortText;
	@Column(name = "hours")
	private float hours;
	@Column(name = "creaton")
	private String creaton;
	@Column(name = "timeOfEnt")
	private String timeOfEnt;
	@Column(name = "lastChange")
	private String lastChange;
	@Column(name = "timeOfLast")
	private String timeOfLast ;
	@Column(name = "document")
	private String document ;
	@Column(name = "createdBy")
	private String createdBy ;
public static String[] fields(){
		
		return new String[] {"persNum","name","status","act","team","date","recCost","wbs","costCenter","shortText","hours","creaton","timeOfEnt","lastChange","timeOfLast","document","createdBy"};	
	}
	public SAPBooking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SAPBooking(Integer id, String persNum, String name, int status, String act, String team, Date date,
			String recCost, String wbs, String costCenter, String shortText, float hours, String creaton,
			String timeOfEnt, String lastChange, String timeOfLast, String document, String createdBy) {
		super();
		this.id = id;
		this.persNum = persNum;
		this.name = name;
		this.status = status;
		this.act = act;
		this.team = team;
		this.date = date;
		this.recCost = recCost;
		this.wbs = wbs;
		this.costCenter = costCenter;
		this.shortText = shortText;
		this.hours = hours;
		this.creaton = creaton;
		this.timeOfEnt = timeOfEnt;
		this.lastChange = lastChange;
		this.timeOfLast = timeOfLast;
		this.document = document;
		this.createdBy = createdBy;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPersNum() {
		return persNum;
	}
	public void setPersNum(String persNum) {
		this.persNum = persNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getAct() {
		return act;
	}
	public void setAct(String act) {
		this.act = act;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getRecCost() {
		return recCost;
	}
	public void setRecCost(String recCost) {
		this.recCost = recCost;
	}
	public String getWbs() {
		return wbs;
	}
	public void setWbs(String wbs) {
		this.wbs = wbs;
	}
	public String getCostCenter() {
		return costCenter;
	}
	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}
	public String getShortText() {
		return shortText;
	}
	public void setShortText(String shortText) {
		this.shortText = shortText;
	}
	public float getHours() {
		return hours;
	}
	public void setHours(float hours) {
		this.hours = hours;
	}
	public String getCreaton() {
		return creaton;
	}
	public void setCreaton(String creaton) {
		this.creaton = creaton;
	}
	public String getTimeOfEnt() {
		return timeOfEnt;
	}
	public void setTimeOfEnt(String timeOfEnt) {
		this.timeOfEnt = timeOfEnt;
	}
	public String getLastChange() {
		return lastChange;
	}
	public void setLastChange(String lastChange) {
		this.lastChange = lastChange;
	}
	public String getTimeOfLast() {
		return timeOfLast;
	}
	public void setTimeOfLast(String timeOfLast) {
		this.timeOfLast = timeOfLast;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
}
